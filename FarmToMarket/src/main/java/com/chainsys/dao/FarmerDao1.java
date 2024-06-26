package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.CartPojo;
import com.chainsys.model.ProductPojo;

import com.chainsys.model.UserPojo;
import com.chainsys.util.Connect1;

public class FarmerDao1 implements FarmerDao {

	public void registrationUser(UserPojo add1) throws SQLException, ClassNotFoundException {

		Connection con = Connect1.getConnection();
		String sql = "INSERT INTO Users (name,type,phone, email, address, password) VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, add1.getName());
		pstmt.setString(2, add1.getType());
		pstmt.setString(3, add1.getPhone());
		pstmt.setString(4, add1.getEmail());
		pstmt.setString(5, add1.getAddress());
		pstmt.setString(6, add1.getPassword());
		pstmt.executeUpdate();

	}

	public UserPojo loginUser1(String email) throws ClassNotFoundException, SQLException {
		Connection connection = Connect1.getConnection();

		String loginQuery = "SELECT password,id,type FROM Users WHERE email = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		UserPojo user = new UserPojo();
		while (resultSet.next()) {
			user.setId(resultSet.getInt(2));
			user.setPassword(resultSet.getString(1));
			user.setType(resultSet.getString(3));
		}
		return user;
	}

	public List<UserPojo> retriveDetails() throws ClassNotFoundException, SQLException {
		ArrayList<UserPojo> list = new ArrayList<>();
		Connection connection = Connect1.getConnection();
		String select = "select id, name,type, phone,email, address from Users";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String type = resultSet.getString(3);
			String phone = resultSet.getString(4);
			String email = resultSet.getString(5);
			String address = resultSet.getString(6);

			UserPojo details = new UserPojo();
			details.setId(id);
			details.setName(name);
			details.setType(type);
			details.setPhone(phone);
			details.setEmail(email);
			details.setAddress(address);

			list.add(details);
		}
		connection.close();
		return list;
	}

	public List<UserPojo> retriveDetails1(int id) throws ClassNotFoundException, SQLException {
		ArrayList<UserPojo> list = new ArrayList<>();

		Connection connection = Connect1.getConnection();
		String select = "select id, name,type, phone,email, address from Users where id=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setInt(1, id);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			int id1 = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String type = resultSet.getString(3);
			String phone = resultSet.getString(4);
			String email = resultSet.getString(5);
			String address = resultSet.getString(6);

			UserPojo details = new UserPojo();
			details.setId(id1);
			details.setName(name);
			details.setType(type);
			details.setPhone(phone);
			details.setEmail(email);
			details.setAddress(address);

			list.add(details);
		}
		connection.close();
		return list;
	}

	public void DeleteUser(int id) throws ClassNotFoundException, SQLException {
		Connection connection = Connect1.getConnection();
		String delete = "delete from Users where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(delete);
		preparedStatement.setInt(1, id);
		int executeUpdate = preparedStatement.executeUpdate();
	}

	public void insertCategory(UserPojo add1) throws SQLException, ClassNotFoundException {
		Connection con = Connect1.getConnection();
		String sql = "INSERT INTO Categories(category_name) VALUES (?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		// Set the parameter value
		pstmt.setString(1, add1.getCategory());
		pstmt.executeUpdate();
	}

	public List<UserPojo> retriveCategoryDetails() throws ClassNotFoundException, SQLException {
		ArrayList<UserPojo> list = new ArrayList<>();
		Connection connection = Connect1.getConnection();
		String select = "select category_id, category_name from Categories";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			int category_id = resultSet.getInt(1);
			String category_name = resultSet.getString(2);

			UserPojo details = new UserPojo();
			details.setCategoryId(category_id);
			details.setCategory(category_name);
			list.add(details);
		}
		connection.close();
		return list;
	}

	public void DeleteCategory(int categoryId) throws ClassNotFoundException, SQLException {
		Connection connection = Connect1.getConnection();
		String delete = "delete from Categories where category_Id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(delete);
		preparedStatement.setInt(1, categoryId);
		 int executeUpdate = preparedStatement.executeUpdate();
	}

	public void insertProduct(ProductPojo add2) throws SQLException, ClassNotFoundException {
		Connection con = Connect1.getConnection();
		String sql = "INSERT INTO Products ( product_name, farmer_id,product_image, description, price, stock_quantity, category_id) VALUES ( ?, ?,?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, add2.getProductName());
		pstmt.setInt(2, add2.getFarmerId());
		pstmt.setBytes(3, add2.getProduct_image());
		pstmt.setString(4, add2.getDescription());
		pstmt.setFloat(5, add2.getPrice());
		pstmt.setInt(6, add2.getStockQuantity());
		pstmt.setInt(7, add2.getCategoryId());
		pstmt.executeUpdate();

	}

	public List<ProductPojo> retriveProductDetails(int id) throws ClassNotFoundException, SQLException {

		ArrayList<ProductPojo> list = new ArrayList<>();
		Connection connection = Connect1.getConnection();
		String select = "select product_id, product_name,product_image, farmer_id, description, price, stock_quantity, category_id from Products where farmer_id=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setInt(1, id);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			// Retrieve data from the result set
			int product_id = resultSet.getInt(1);
			String product_name = resultSet.getString(2);
			byte[] product_image = resultSet.getBytes(3);
			int farmer_id = resultSet.getInt(4);
			String description = resultSet.getString(5);
			float price = resultSet.getFloat(6);
			int stock_quantity = resultSet.getInt(7);
			int category_id = resultSet.getInt(8);
			ProductPojo details = new ProductPojo();
			details.setProductId(product_id);
			details.setProductName(product_name);
			details.setProduct_image(product_image);
			details.setFarmerId(farmer_id);
			details.setDescription(description);
			details.setPrice(price);
			details.setStockQuantity(stock_quantity);
			details.setCategoryId(category_id);
			list.add(details);
		}
		connection.close();
		return list;
	}

	public ArrayList<ProductPojo> retriveProductDetails() throws ClassNotFoundException, SQLException {

		ArrayList<ProductPojo> list = new ArrayList<>();
		Connection connection = Connect1.getConnection();
		String select = "select product_id, product_name,product_image, farmer_id, description, price, stock_quantity, category_id from Products ";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			int product_id = resultSet.getInt(1);
			String product_name = resultSet.getString(2);
			byte[] product_image = resultSet.getBytes(3);
			int farmer_id = resultSet.getInt(4);
			String description = resultSet.getString(5);
			float price = resultSet.getFloat(6);
			int stock_quantity = resultSet.getInt(7);
			int category_id = resultSet.getInt(8);
			ProductPojo details = new ProductPojo();
			details.setProductId(product_id);
			details.setProductName(product_name);
			details.setProduct_image(product_image);
			details.setFarmerId(farmer_id);
			details.setDescription(description);
			details.setPrice(price);
			details.setStockQuantity(stock_quantity);
			details.setCategoryId(category_id);
			list.add(details);
		}
		connection.close();
		return list;
	}

	
	public void DeleteProduct(int ProductId) throws ClassNotFoundException, SQLException {
		Connection connection = Connect1.getConnection();
		String delete = "delete from Products where Product_Id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(delete);
		preparedStatement.setInt(1, ProductId);
		int executeUpdate = preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();

	}
	/*public void DeleteProduct(String ProductName,int FarmerId) throws ClassNotFoundException, SQLException {
		Connection connection = Connect1.getConnection();
		String delete = "delete from Products where Product_name=? AND farmer_id" ;
		PreparedStatement preparedStatement = connection.prepareStatement(delete);
		preparedStatement.setString(1, ProductName);
		preparedStatement.setInt(2, FarmerId);
		int executeUpdate = preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();

	}*/

	public List<UserPojo> searchDetails(UserPojo obj) throws ClassNotFoundException, SQLException {
		ArrayList<UserPojo> list = new ArrayList<>();
		Connection connection = Connect1.getConnection();
		String select = "select id, name,type, phone,email, address from Users where type=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setString(1, obj.getType());
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String type = resultSet.getString(3);
			String phone = resultSet.getString(4);
			String email = resultSet.getString(5);
			String address = resultSet.getString(6);

			UserPojo details = new UserPojo();
			details.setId(id);
			details.setName(name);
			details.setType(type);
			details.setPhone(phone);
			details.setEmail(email);
			details.setAddress(address);

			list.add(details);
		}
		connection.close();
		return list;

	}

	public void updateUser(UserPojo add1) throws ClassNotFoundException, SQLException {

		Connection connection = Connect1.getConnection();
		String update = "update Users set name=?,phone=?, email=?, address=? where id=? ";
		PreparedStatement pstmt = connection.prepareStatement(update);
		pstmt.setString(1, add1.getName());
		pstmt.setString(2, add1.getPhone());
		pstmt.setString(3, add1.getEmail());
		pstmt.setString(4, add1.getAddress());
		pstmt.setInt(5, add1.getId());
		pstmt.executeUpdate();
		connection.close();

	}

	public void insertCart(int customerId, int productId, int quantity, float total, String action)
			throws ClassNotFoundException, SQLException {
		try (Connection connection = Connect1.getConnection();
				PreparedStatement selectStatement = connection
						.prepareStatement("SELECT * FROM Cart WHERE customer_id = ? AND product_id = ?");
				PreparedStatement updateStatement = connection.prepareStatement(
						"UPDATE Cart SET quantity = ?, total = ?, timestamp = CURRENT_TIMESTAMP WHERE customer_id = ? AND product_id = ?");
				PreparedStatement insertStatement = connection.prepareStatement(
						"INSERT INTO Cart (customer_id, product_id, quantity, total, status, timestamp) VALUES (?, ?, ?, ?, 'UNPAID', CURRENT_TIMESTAMP)")) {
			selectStatement.setInt(1, customerId);
			selectStatement.setInt(2, productId);

			try (ResultSet resultSet = selectStatement.executeQuery()) {
				if (resultSet.next()) {
					// If the product already exists in the cart, update the quantity and total
					int existingQuantity = resultSet.getInt("quantity");
					int newQuantity = 0;
					if (action.equals("add")) {
						newQuantity = existingQuantity + quantity;
					}
					if (action.equals("sub")) {
						newQuantity = existingQuantity - quantity;
					}
					float newTotal = total * newQuantity;
					// Set parameters for update statement
					updateStatement.setInt(1, newQuantity);
					updateStatement.setFloat(2, newTotal);
					updateStatement.setInt(3, customerId);
					updateStatement.setInt(4, productId);
					updateStatement.executeUpdate(); // Execute the update statement
					System.out.println("exiting");
				} else {
					// If the product doesn't exist in the cart, insert a new entry
					insertStatement.setInt(1, customerId);
					insertStatement.setInt(2, productId);
					insertStatement.setInt(3, quantity);
					insertStatement.setFloat(4, total);

					insertStatement.executeUpdate(); // Execute the insert statement
				}
			}
		}
	}

	public List<ProductPojo> searchDetails1(ProductPojo obj) throws ClassNotFoundException, SQLException {
		ArrayList<ProductPojo> list = new ArrayList<>();
		Connection connection = Connect1.getConnection();
		String select = "SELECT product_id, product_name, product_image, farmer_id, description, price, stock_quantity, category_id FROM Products WHERE category_id=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setInt(1, obj.getCategoryId());
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			int product_id = resultSet.getInt(1);
			String product_name = resultSet.getString(2);
			byte[] product_image = resultSet.getBytes(3);
			int farmer_id = resultSet.getInt(4);
			String description = resultSet.getString(5);
			float price = resultSet.getFloat(6);
			int stock_quantity = resultSet.getInt(7);
			int category_id = resultSet.getInt(8);
			ProductPojo details = new ProductPojo();
			details.setProductId(product_id);
			details.setProductName(product_name);
			details.setProduct_image(product_image);
			details.setFarmerId(farmer_id);
			details.setDescription(description);
			details.setPrice(price);
			details.setStockQuantity(stock_quantity);
			details.setCategoryId(category_id);
			list.add(details);
		}
		connection.close();
		return list;
	}

	public List<ProductPojo> retrieveProductDetailsSorted(ProductPojo obj) throws ClassNotFoundException, SQLException {
		ArrayList<ProductPojo> list = new ArrayList<>();
		Connection connection = Connect1.getConnection();

		String select = "SELECT product_id, product_name, product_image, farmer_id, description, price, stock_quantity, category_id FROM Products WHERE category_id = ? ORDER BY price ASC;";

		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setInt(1, obj.getCategoryId());
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			int product_id = resultSet.getInt(1);
			String product_name = resultSet.getString(2);
			byte[] product_image = resultSet.getBytes(3);
			int farmer_id = resultSet.getInt(4);
			String description = resultSet.getString(5);
			Float price = resultSet.getFloat(6);
			int stock_quantity = resultSet.getInt(7);
			int category_id = resultSet.getInt(8);
			ProductPojo details = new ProductPojo();
			details.setProductId(product_id);
			details.setProductName(product_name);
			details.setProduct_image(product_image);
			details.setFarmerId(farmer_id);
			details.setDescription(description);
			details.setPrice(price);
			details.setStockQuantity(stock_quantity);
			details.setCategoryId(category_id);
			list.add(details);
		}
		connection.close();
		return list;
	}

	public List<ProductPojo> retrieveProductDetailsSorted1(ProductPojo obj)
			throws ClassNotFoundException, SQLException {
		ArrayList<ProductPojo> list = new ArrayList<>();
		Connection connection = Connect1.getConnection();

		String select = "SELECT product_id, product_name, product_image, farmer_id, description, price, stock_quantity, category_id FROM Products WHERE category_id = ? ORDER BY price DESC;";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setInt(1, obj.getCategoryId());
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			int product_id = resultSet.getInt(1);
			String product_name = resultSet.getString(2);
			byte[] product_image = resultSet.getBytes(3);
			int farmer_id = resultSet.getInt(4);
			String description = resultSet.getString(5);
			Float price = resultSet.getFloat(6);
			int stock_quantity = resultSet.getInt(7);
			int category_id = resultSet.getInt(8);
			ProductPojo details = new ProductPojo();
			details.setProductId(product_id);
			details.setProductName(product_name);
			details.setProduct_image(product_image);
			details.setFarmerId(farmer_id);
			details.setDescription(description);
			details.setPrice(price);
			details.setStockQuantity(stock_quantity);
			details.setCategoryId(category_id);
			list.add(details);
		}
		connection.close();
		return list;
	}

	public List<CartPojo> retrieveCartDetails(int id) throws ClassNotFoundException, SQLException {
		ArrayList<CartPojo> list = new ArrayList<CartPojo>();
		Connection connection = Connect1.getConnection();
		String select = "SELECT p.product_id,p.product_name, p.product_image, p.price, c.cart_id, c.quantity, (p.price * c.quantity) AS total "
				+ "FROM Products p " + "JOIN Cart c ON p.product_id = c.product_id "
				+ "WHERE c.customer_id = ? AND status='UNPAID'";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setInt(1, id); // set the parameter in the query
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			// Retrieve data from the result set
			int productId = resultSet.getInt("product_id");
			String product_name = resultSet.getString("product_name");
			byte[] product_image = resultSet.getBytes("product_image");
			float price = resultSet.getFloat("price");
			int quantity = resultSet.getInt("quantity");
			float total = resultSet.getFloat("total");
			int cart_id = resultSet.getInt("cart_id");
			// Create a Pojo object and set its attributes
			ProductPojo product = new ProductPojo();
			product.setProductId(productId);
			product.setProductName(product_name);
			product.setProduct_image(product_image);
			product.setPrice(price);
			CartPojo cartItem = new CartPojo();
			cartItem.setCartId(cart_id);
			cartItem.setQuantity(quantity);
			cartItem.setTotal(total);
			cartItem.setProduct(product);
			list.add(cartItem);
		}
		connection.close();
		return list;
	}

	public List<CartPojo> DeleteCart(int cartId) throws ClassNotFoundException, SQLException {
		ArrayList<CartPojo> list = new ArrayList<CartPojo>();
		Connection connection = Connect1.getConnection();
		String delete = "delete from Cart where cart_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(delete);
		preparedStatement.setInt(1, cartId);
		int executeUpdate = preparedStatement.executeUpdate();
		connection.close();
		return list;
	}

	public void updateStatus(CartPojo add1) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pstmtCart = null;
		PreparedStatement pstmtProduct = null;
		ResultSet rs = null;

		try {
			connection = Connect1.getConnection();
			connection.setAutoCommit(false);

			String updateCart = "UPDATE Cart SET status=? WHERE customer_id=?";
			pstmtCart = connection.prepareStatement(updateCart);
			pstmtCart.setString(1, "PAID");
			pstmtCart.setInt(2, add1.getCustomerId());
			pstmtCart.executeUpdate();

			String selectCartItems = "SELECT product_id, quantity FROM Cart WHERE customer_id=? AND status='PAID'";
			pstmtCart = connection.prepareStatement(selectCartItems);
			pstmtCart.setInt(1, add1.getCustomerId());
			rs = pstmtCart.executeQuery();

			String updateProduct = "UPDATE Products SET stock_quantity = stock_quantity - ? WHERE product_id = ?";
			pstmtProduct = connection.prepareStatement(updateProduct);
			while (rs.next()) {
				int productId = rs.getInt("product_id");
				int quantity = rs.getInt("quantity");
				pstmtProduct.setInt(1, quantity);
				pstmtProduct.setInt(2, productId);
				pstmtProduct.executeUpdate();
			}

			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				connection.rollback();
			}
			throw e;
		} finally {

			if (rs != null) {
				rs.close();
			}
			if (pstmtCart != null) {
				pstmtCart.close();
			}
			if (pstmtProduct != null) {
				pstmtProduct.close();
			}
			if (connection != null) {
				connection.setAutoCommit(true);
				connection.close();
			}
		}
	}

	public void updateFarmerProducts(ProductPojo add1) throws ClassNotFoundException, SQLException {
		Connection connection = Connect1.getConnection();

		String update = "update Products set price=?,stock_quantity=? where product_id=? ";
		PreparedStatement pstmt = connection.prepareStatement(update);

		pstmt.setFloat(1, add1.getPrice());
		pstmt.setInt(2, add1.getStockQuantity());
		pstmt.setInt(3, add1.getFarmerId());
		int executeUpdate = pstmt.executeUpdate();

		connection.close();
	}
}
