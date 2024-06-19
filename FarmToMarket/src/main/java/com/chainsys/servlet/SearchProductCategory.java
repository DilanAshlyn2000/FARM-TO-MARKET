package com.chainsys.servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.FarmerDao1;
import com.chainsys.model.ProductPojo;


/**
 * Servlet implementation class SearchProductCategory
 */
@WebServlet("/SearchProductCategory")
public class SearchProductCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchProductCategory() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FarmerDao1 emp = new FarmerDao1();
		ProductPojo obj = new ProductPojo();
		List<ProductPojo> list = new ArrayList<>();
		int categoryId = Integer.parseInt(request.getParameter("type"));
		obj.setCategoryId(categoryId);
		try {
			list = emp.searchDetails1(obj);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
		request.setAttribute("productList", list);
		request.getRequestDispatcher("ProductTable1.jsp").forward(request, response);
	 }

@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doGet(request, response);
	}

}
