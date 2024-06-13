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
import com.chainsys.model.ProductPojo;
import com.chainsys.model.UserPojo;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* String ProductName=request.getParameter("productName"); */
		HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("id");
        System.out.println(id);
		String ProductId = request.getParameter("productId");
		int ProductId1 = Integer.parseInt(ProductId);
		System.out.println(ProductId1);
		
		 String Price = request.getParameter("price");
		 System.out.println(Price);
		 float Price1 = Float.parseFloat(Price);
		 
		String quantity=request.getParameter("quantity");
		int quantity1=Integer.parseInt(quantity);
		String FarmerId = request.getParameter("farmerId");
		int FarmerId1 = Integer.parseInt(FarmerId);
		System.out.println(FarmerId1);
		float total=quantity1*Price1;
		 
	
		//System.out.println(cartId1);
	   // int categoryId = Integer.parseInt(request.getParameter("categoryId"));

		 FarmerDao1 register=new FarmerDao1();
			try 
			{
		register.insertCart(id,ProductId1,quantity1,total);
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
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
