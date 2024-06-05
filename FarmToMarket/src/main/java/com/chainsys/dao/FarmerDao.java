package com.chainsys.dao;

import java.sql.SQLException;

import com.chainsys.model.FarmerPojo;
import com.chainsys.model.UserPojo;

public interface FarmerDao {
	/*
	 * void registrationFarmer(FarmerPojo add1) throws SQLException,
	 * ClassNotFoundException ; String loginUser(String name) throws
	 * ClassNotFoundException, SQLException;
	 */   
	public void registrationUser(UserPojo add1) throws SQLException, ClassNotFoundException;

}
