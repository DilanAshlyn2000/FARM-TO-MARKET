package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.FarmerDao1;
import com.chainsys.model.ProductPojo;
import com.chainsys.model.UserPojo;

/**
 * Servlet implementation class SearchCategoryLowToHigh
 */
@WebServlet("/SearchCategoryLowToHigh")
public class SearchCategoryLowToHigh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchCategoryLowToHigh() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /* FarmerDao1 emp = new FarmerDao1();
		    ProductPojo obj = new ProductPojo();
		    List<ProductPojo> list = new ArrayList<>();
		    int categoryId = Integer.parseInt(request.getParameter("Ctype"));
		    System.out.println(categoryId);
		    obj.setCategoryId(categoryId);
		    Float price = Float.parseFloat(request.getParameter("price1"));
		    obj.setPrice(price);
		    System.out.println(price);
		    try {
		      
		        list = emp.retrieveProductDetailsSorted(obj);
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		       
		    }
	   
		    request.setAttribute("list", list); 	  
		    request.getRequestDispatcher("ProductTable1.jsp").forward(request, response);
		}*/
		 try {
	          
	            int categoryId = Integer.parseInt(request.getParameter("type"));
	    float price = Float.parseFloat(request.getParameter("price1"));

	            ProductPojo obj = new ProductPojo();
	            obj.setCategoryId(categoryId);
	       obj.setPrice(price);

	            FarmerDao1 productRetriever = new FarmerDao1();
	            List<ProductPojo> productList = productRetriever.retrieveProductDetailsSorted(obj);

	            
	            request.setAttribute("productList", productList);
	            request.getRequestDispatcher("ProductTable1.jsp").forward(request, response);
		 } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
		     // Handle exceptions
		     e.printStackTrace();
		 }
	    }
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
