package com.prodstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//3 kind of user: ADMIN, AGENET, VIEWER
@Entity
@Table(name = "appuser_table")
public class AppUser {
	
	private static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;
	
	@Column(unique = true)
	private String email;
	
	private String phone;
	private String address;
	
	private String profile;// ADMIN, AGENET, VIEWER
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public AppUser(String name, String password, String email, String phone, String address, String profile) {
		super();
		this.name = name;
		this.password=password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.profile = profile;
	}
	public AppUser() {}
	@Override
	public String toString() {
		return "AppUser [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phone="
				+ phone + ", address=" + address + ", profile=" + profile + "]";
	}
	
	
}







