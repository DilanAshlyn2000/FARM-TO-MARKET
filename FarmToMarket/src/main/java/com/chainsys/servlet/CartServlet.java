package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.FarmerDao1;
import com.chainsys.model.ProductPojo;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("id");

		String ProductId = request.getParameter("productId");
		System.out.println(ProductId + "id in do get");
		int ProductId1 = Integer.parseInt(ProductId);

		String action = request.getParameter("action");
		String Price = request.getParameter("price");
		System.out.println(Price + "price");

		float Price1 = Float.parseFloat(Price);

		String quantity = request.getParameter("quantity");
		System.out.println(quantity + "quantity");
		int quantity1 = Integer.parseInt(quantity);

		float total = quantity1 * Price1;
		FarmerDao1 register = new FarmerDao1();
		try {
			register.insertCart(id, ProductId1, quantity1, total, action);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		try {
			List<ProductPojo> list = register.retriveProductDetails();
			request.setAttribute("productList", list);
			request.getRequestDispatcher("ProductTable1.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
