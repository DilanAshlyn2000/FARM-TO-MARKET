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
import com.chainsys.model.CartPojo;

/**
 * Servlet implementation class DeleteCart
 */
@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCart() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FarmerDao1 form = new FarmerDao1();
		String cartId = request.getParameter("cartId");
		int cartId1 = Integer.parseInt(cartId);
		try {
			List<CartPojo> list = form.DeleteCart(cartId1);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		CartView obj = new CartView();
		obj.doGet(request, response);
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
