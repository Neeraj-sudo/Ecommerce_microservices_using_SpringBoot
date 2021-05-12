package com.prodstore.dto;

public class AppUserResponse {
	private String password;
	private String email;
	private String profile;
	
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
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public AppUserResponse(String password, String email, String profile) {
		this.password = password;
		this.email = email;
		this.profile = profile;
	}
	public AppUserResponse() {}
	
	
	
}
