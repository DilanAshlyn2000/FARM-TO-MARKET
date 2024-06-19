package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.FarmerDao1;
import com.chainsys.model.ProductPojo;

/**
 * Servlet implementation class SearchCategoryHighToLow
 */
@WebServlet("/SearchCategoryHighToLow")
public class SearchCategoryHighToLow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchCategoryHighToLow() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int categoryId = Integer.parseInt(request.getParameter("type"));
			float price = Float.parseFloat(request.getParameter("price1"));
			ProductPojo obj = new ProductPojo();
			obj.setCategoryId(categoryId);
			obj.setPrice(price);
			FarmerDao1 productRetriever = new FarmerDao1();
			List<ProductPojo> productList = productRetriever.retrieveProductDetailsSorted1(obj);
			request.setAttribute("productList", productList);
			request.getRequestDispatcher("ProductTable1.jsp?type='categoryId'").forward(request, response);
		} catch (ClassNotFoundException | SQLException | NumberFormatException e) {
			// Handle exceptions
			e.printStackTrace();
		}
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
