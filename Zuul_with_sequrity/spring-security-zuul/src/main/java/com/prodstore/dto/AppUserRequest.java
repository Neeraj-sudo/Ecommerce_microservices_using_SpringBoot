package com.prodstore.dto;

public class AppUserRequest {
	private String name;
	private String password;
	private String email;
	private String phone;
	private String address;
	private String profile;

	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public AppUserRequest(String name, String password, String email, String phone, String address, String profile) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.profile = profile;
	}

	public AppUserRequest() {
	}

}
