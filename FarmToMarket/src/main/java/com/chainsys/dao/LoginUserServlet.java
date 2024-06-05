package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password1=null;
		FarmerDao1 farmer=new FarmerDao1();
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session=request.getSession();
        try {
        	 password1 = farmer.loginUser1(email);
        	    if (password.equals(password1)) {
        	    	session.setAttribute("email", email);
        	        if (password.equals("Admin#01")) {
        	            request.getRequestDispatcher("AdminHome.html").forward(request, response);
        	        } else {
        	            request.getRequestDispatcher("Home1.html").forward(request, response);
        	        }
        	    } else {
        	        request.getRequestDispatcher("RegistrationUser.html").forward(request, response);
        	    }
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
				/*
				 * if((password.equals(password1))&&(password!="Admin#01")){
				 * request.getRequestDispatcher("home.html").forward(request, response); }else
				 * if(password.equals("Admin#01")) {
				 * request.getRequestDispatcher("Adminhome.html").forward(request, response); }
				 * else { request.getRequestDispatcher("RegistrationUser.html").forward(request,
				 * response); }
				 */
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
