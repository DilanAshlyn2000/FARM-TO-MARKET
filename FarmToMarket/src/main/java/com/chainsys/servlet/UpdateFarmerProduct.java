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
import com.chainsys.model.ProductPojo;

/**
 * Servlet implementation class UpdateFarmerProduct
 */
@WebServlet("/UpdateFarmerProduct")
public class UpdateFarmerProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateFarmerProduct() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		float price = Float.parseFloat(request.getParameter("price"));
		int stockQuantity = Integer.parseInt(request.getParameter("stock_quantity"));
		
		String id = request.getParameter("productId");
		
		int id1 = Integer.parseInt(id);
		ProductPojo product = new ProductPojo();
		product.setPrice(price);
		product.setStockQuantity(stockQuantity);
		product.setFarmerId(id1);
		FarmerDao1 productDao = new FarmerDao1();
		try {
			productDao.updateFarmerProducts(product);
			List<ProductPojo> list = productDao.retriveProductDetails();
			request.setAttribute("list", list);
			request.getRequestDispatcher("ProductTable.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
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
