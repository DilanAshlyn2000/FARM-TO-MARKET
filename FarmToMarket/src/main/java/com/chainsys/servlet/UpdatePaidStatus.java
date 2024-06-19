package com.chainsys.servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.FarmerDao1;
import com.chainsys.model.CartPojo;


/**
 * Servlet implementation class UpdatePaidStatus
 */
@WebServlet("/UpdatePaidStatus")
public class UpdatePaidStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePaidStatus() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("id");
		FarmerDao1 register = new FarmerDao1();
		CartPojo user = new CartPojo();
		user.setCustomerId(id);
		try {
			register.updateStatus(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("PaymentSuccess.html");
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		doGet(request, response);
	}

}
