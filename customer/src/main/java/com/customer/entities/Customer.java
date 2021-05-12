package com.customer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@Getter
//@Setter
//@NoArgsConstructor
//@Data
@Entity
@Table(name = "customer_table")
public class Customer {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	//step 2 apply jsr 303 anotation on ur pojo
	
	@Size(min=4, message="namne should have atleast 4 characters")
	private String name;
	@Size(min=10, message="phone should have atleast 10 characters")
	private String phoneNo;
	@Size(min=6, message="address should have atleast 6 characters")
	private String address;
	
	@Email(message = "please enter correct email")
	private String email;
	
	
	public Customer(String name, String phoneNo, String address, String email) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Customer() {}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", phoneNo=" + phoneNo + ", address=" + address
				+ ", email=" + email + "]";
	}
	
	
	
	
}
