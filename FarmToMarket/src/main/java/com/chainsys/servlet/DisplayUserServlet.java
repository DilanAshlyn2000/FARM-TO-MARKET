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
import com.chainsys.model.FarmerPojo;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  FarmerDao1 form=new FarmerDao1();
	      try {
	          List<UserPojo> list = form.retriveDetails();
	          System.out.println(list.get(0));
	          request.setAttribute("list", list);
	          request.getRequestDispatcher("UserTable.jsp").forward(request, response);
	      } catch (ClassNotFoundException | SQLException e) {
	          // TODO Auto-generated catch block
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
