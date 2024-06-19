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
 * Servlet implementation class DisplayProductAdminSide
 */
@WebServlet("/DisplayProductAdminSide")
public class DisplayProductAdminSide extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayProductAdminSide() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DISPLAY PRODUCT TABLE WITHOUT SESSION
		FarmerDao1 form = new FarmerDao1();
		try {
			List<ProductPojo> list = form.retriveProductDetails();
			request.setAttribute("list", list);
			request.getRequestDispatcher("ProductTableAdmin.jsp").forward(request, response);
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
