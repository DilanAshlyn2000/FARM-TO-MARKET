package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.model.ProductPojo;

/**
 * Servlet implementation class DisplayProductUserSide
 */
@WebServlet("/DisplayProductUserSide")
public class DisplayProductUserSide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProductUserSide() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  FarmerDao1 form=new FarmerDao1();
	      try {
	    	  HttpSession session = request.getSession(false);
	 		 
	 		 int id =  (int) session.getAttribute("id");
	          List<ProductPojo> list = form.retriveProductDetails();
	          request.setAttribute("list", list);
	          request.getRequestDispatcher("ProductTable1.jsp").forward(request, response);
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
