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
import com.chainsys.model.CartPojo;
import com.chainsys.model.ProductPojo;

/**
 * Servlet implementation class CartView
 */
@WebServlet("/CartView")
public class CartView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	 * 
	 * String ProductName=request.getParameter("ProductName"); String Price
	 * =request.getParameter("price1"); System.out.println(Price); float Price1 =
	 * Float.parseFloat(Price);
	 * 
	 * 
	 * String quantity=request.getParameter("quantity"); int
	 * quantity1=Integer.parseInt(quantity); float total=quantity1*Price1;
	 * FarmerDao1 form = new FarmerDao1();
	 * 
	 * 
	 * try {
	 * 
	 * List<ProductPojo> list = form.retriveCartDetails();
	 * request.setAttribute("list", list);
	 * request.getRequestDispatcher("CartView1.jsp").forward(request, response); }
	 * catch (ClassNotFoundException | SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * }
	 */
         HttpSession session = request.getSession(false);	 
		 int id =  (int) session.getAttribute("id");
		 System.out.println(id);
		FarmerDao1 form = new FarmerDao1();
		try {
			
			List<CartPojo> list = form.retrieveCartDetails(id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("CartView1.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
