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
import com.chainsys.model.UserPojo;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list=null;
		
		String name = request.getParameter("name");
		
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String id=request.getParameter("updateId");
        System.out.println(id);
        int id1=Integer.parseInt(id);
        UserPojo user = new UserPojo();
        user.setName(name);
	
        user.setPhone(phone);
        user.setEmail(email);
        user.setAddress(address);
        user.setId(id1);
        FarmerDao1 register=new FarmerDao1();
		try 
		{
			register.updateUser(user);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	
        try 
        {
            list=register.retriveDetails();
          
        } 
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        request.setAttribute("list", list);
        request.getRequestDispatcher("UserTable.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
