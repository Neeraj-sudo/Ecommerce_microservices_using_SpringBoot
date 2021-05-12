package com.inventory.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Size;


@Entity
@Table(name = "product_table")
public class Product {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//step 2 apply jsr 303 anotation on ur pojo
	
	private Integer productId;
	//@Size(min=10, message="name should have atleast 10 characters")
	private String pName;
	private double pPrice;
	private String pDesc;
	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public double getpPrice() {
		return pPrice;
	}
	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	
	public Product( String pName, double pPrice,String pDesc) {
		super();
		this.pName = pName;
		this.pPrice = pPrice;
		this.pDesc = pDesc;
	}
	public Product() {
		
	}
	
	
}
