package com.chainsys.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chainsys.model.UserPojo;

/**
 * Servlet implementation class DeleteFarmer
 */
@WebServlet("/DeleteFarmer")
public class DeleteFarmer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFarmer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserPojo add2=new UserPojo();
		FarmerDao1 emp=new FarmerDao1();
		String id= request.getParameter("id");
		 int id1=Integer.parseInt(id); 
		
			try
			{  
				emp.DeleteUser(id1);
				PrintWriter writer = response.getWriter();
				writer.println(add2.getId() + "deleted");
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			DisplayUserServlet obj=new DisplayUserServlet();
			obj.doGet(request, response);
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
