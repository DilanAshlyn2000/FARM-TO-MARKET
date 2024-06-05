package com.chainsys.model;

public class FarmerPojo {
	int id;
	String name;
	/* String username; */
	String gender;
	String DOB;
	String phoneNumber;
	String email;
	String address;
	float farmSize;
	String cropsGrown;
	String landOwnership;
	String landLocation;
	String soilType;
	Float income;
	String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*
	 * public String getUsername() { return username; } public void
	 * setUsername(String username) { this.username = username; }
	 */
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getFarmSize() {
		return farmSize;
	}
	public void setFarmSize(float farmSize) {
		this.farmSize = farmSize;
	}
	public String getCropsGrown() {
		return cropsGrown;
	}
	public void setCropsGrown(String cropsGrown) {
		this.cropsGrown = cropsGrown;
	}
	public String getLandOwnership() {
		return landOwnership;
	}
	public void setLandOwnership(String landOwnership) {
		this.landOwnership = landOwnership;
	}
	public String getLandLocation() {
		return landLocation;
	}
	public void setLandLocation(String landLocation) {
		this.landLocation = landLocation;
	}
	public String getSoilType() {
		return soilType;
	}
	public void setSoilType(String soilType) {
		this.soilType = soilType;
	}
	public Float getIncome() {
		return income;
	}
	public void setIncome(Float income) {
		this.income = income;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
