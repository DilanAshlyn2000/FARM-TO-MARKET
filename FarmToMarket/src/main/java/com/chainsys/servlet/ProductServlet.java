package com.chainsys.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.chainsys.dao.FarmerDao1;
import com.chainsys.model.ProductPojo;


/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
@MultipartConfig
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productName = request.getParameter("productName");
		Part filePart = request.getPart("fileToUpload");
		byte[] imageBytes = null;

		if (filePart != null) {
			try (InputStream inputStream = filePart.getInputStream()) {
				// store them in the byte array
				imageBytes = inputStream.readAllBytes();
			} catch (IOException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error reading uploaded file");
				return;
			}
		}
		int farmerId = Integer.parseInt(request.getParameter("farmerId"));
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		ProductPojo insert = new ProductPojo();
		insert.setProductName(productName);
		insert.setFarmerId(farmerId);
		insert.setDescription(description);
		insert.setPrice(price);
		insert.setStockQuantity(stockQuantity);
		insert.setCategoryId(categoryId);
		insert.setProduct_image(imageBytes);
		FarmerDao1 insert1 = new FarmerDao1();
		try {
			insert1.insertProduct(insert);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("home.html");
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
