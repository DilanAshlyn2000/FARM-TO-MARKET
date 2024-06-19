package com.chainsys.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.dao.FarmerDao1;
import com.chainsys.model.ProductPojo;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProduct() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductPojo delete = new ProductPojo();
		FarmerDao1 emp = new FarmerDao1();

		String ProductId = request.getParameter("id");
		int ProductId1 = Integer.parseInt(ProductId);
		try {
			emp.DeleteProduct(ProductId1);
			PrintWriter writer = response.getWriter();
			writer.println(delete.getProductId() + "deleted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		DisplayProduct obj = new DisplayProduct();
		obj.doGet(request, response);
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
