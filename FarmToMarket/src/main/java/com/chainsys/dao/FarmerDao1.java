package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.FarmerPojo;
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

	/*
	 * public UserPojo loginUser1(String email) throws ClassNotFoundException,
	 * SQLException { Connection connection = Connect1.getConnection(); String
	 * password = null; String loginQuery =
	 * "SELECT password,id FROM Users WHERE email = ?"; PreparedStatement
	 * preparedStatement = connection.prepareStatement(loginQuery);
	 * preparedStatement.setString(1, email); ResultSet resultSet =
	 * preparedStatement.executeQuery(); UserPojo user = new UserPojo(); while
	 * (resultSet.next()) { user.setId(resultSet.getInt(2));
	 * user.setPassword(resultSet.getString(1));
	 * 
	 * } return user; }
	 */
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

	// public List<ProductPojo> retriveProductDetails(String email) throws
	// ClassNotFoundException, SQLException {

	public List<ProductPojo> retriveProductDetails(int id) throws ClassNotFoundException, SQLException {

		ArrayList<ProductPojo> list = new ArrayList<>();
		Connection connection = Connect1.getConnection();
		String select = "select product_id, product_name,product_image, farmer_id, description, price, stock_quantity, category_id from Products where farmer_id=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setInt(1, id);
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

	public List<ProductPojo> retriveProductDetails() throws ClassNotFoundException, SQLException {

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
	}

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
		System.out.println(add1.getId());
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

}
