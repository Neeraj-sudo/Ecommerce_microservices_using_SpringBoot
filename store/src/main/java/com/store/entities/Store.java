package com.store.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "store_table")
public class Store {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	
	private String storeName;
	private String pincode;
	private String city;
	private String state;
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
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
	public Store(int storeId, String storeName, String pincode, String city, String state) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
	}
	public Store() {}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName + ", pincode=" + pincode + ", city=" + city
				+ ", state=" + state + "]";
	}
	
	

}
