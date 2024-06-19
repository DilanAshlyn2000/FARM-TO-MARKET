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

import com.chainsys.model.UserPojo;

/**
 * Servlet implementation class DisplayFarmersServlet
 */
@WebServlet("/DisplayUserServlet")
public class DisplayUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayUserServlet() {
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

		try {
			List<UserPojo> list = form.retriveDetails();
			System.out.println(list.get(0));
			request.setAttribute("list", list);
			request.getRequestDispatcher("UserTable.jsp").forward(request, response);
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
		FarmerDao1 form = new FarmerDao1();
		HttpSession session = request.getSession();

		int id = (int) session.getAttribute("id");
		try {
			List<UserPojo> list = form.retriveDetails1(id);

			request.setAttribute("list", list);
			request.getRequestDispatcher("UserProfile.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

}


