package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chainsys.model.UserPojo;

/**
 * Servlet implementation class RegistrationUserServlet
 */
@WebServlet("/RegistrationUserServlet")
public class RegistrationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String type = request.getParameter("type");

		   String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");


        String password = request.getParameter("password");

       
        UserPojo user = new UserPojo();
        user.setName(name);
		user.setType(type);
        user.setPhone(phone);
        user.setEmail(email);
        user.setAddress(address);
        
        user.setPassword(password);
        FarmerDao1 register=new FarmerDao1();
		try 
		{
			register.registrationUser(user);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	
	response.sendRedirect("LoginUser.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password1=null;
		FarmerDao1 farmer=new FarmerDao1();
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        //HttpSession session=request.getSession();
        try {
        	 password1 = farmer.loginUser1(email);
        	    if (password.equals(password1)) {
        	    	//session.setAttribute("email", email);
        	        if (password.equals("Admin#01")) {
        	            request.getRequestDispatcher("AdminHome.html").forward(request, response);
        	        } else {
        	            request.getRequestDispatcher("home.html").forward(request, response);
        	        }
        	    } else {
        	        request.getRequestDispatcher("RegistrationUser.html").forward(request, response);
        	    }
        	 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
      
	
	}

}
