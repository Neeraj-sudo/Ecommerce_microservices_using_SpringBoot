package com.inventory.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Size;


@Entity
@Table(name = "inventory_table")
public class Inventory {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//step 2 apply jsr 303 anotation on ur pojo
	
	private Integer inventoryId;
	private long totalProdCount;
	
	
	
	
	public Integer getInventoryId() {
		return inventoryId;
	}




	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}




	public long getTotalProdCount() {
		return totalProdCount;
	}




	public void setTotalProdCount(long totalProdCount) {
		this.totalProdCount = totalProdCount;
	}





	public Inventory() {
		
	}




	public Inventory(Integer inventoryId, long totalProdCount) {
		super();
		this.inventoryId = inventoryId;
		this.totalProdCount = totalProdCount;
		
	}
	
	
	
}
