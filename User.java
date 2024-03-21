package com.entity;

public class User {

	
	private int id;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String password;
	
	private String address;
	
	private String landmark;
	
	private String city;
	
	private String state;
	
	private String pincode;
	
	
	
	
	
	
	public User() {
		super();
	}
	
	
	
	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}




	
	
	
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", phone=" + phone + ", password=" + password + ", address="
				+ address + ", landmark=" + landmark + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ "]";
	}
	
	
	
	
	
	
	
}































