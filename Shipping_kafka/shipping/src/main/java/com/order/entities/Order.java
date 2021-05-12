package com.order.entities;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//@Getter
//@Setter
//@NoArgsConstructor
//@Data

public class Order {
	
	private long id;
	private int totalPrice;
	
	private Date dateOrder;
	private int agentId;
	private int customerId;
	private int productId;
	private int quantity;
	
	
	private OrderStatus orderStatus;
	public Order(int totalPrice, int agentId, int customerId, int productId, int quantity,
			OrderStatus orderStatus) {
		super();
		this.totalPrice = totalPrice;
		this.dateOrder = new Date();
		this.agentId = agentId;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", totalPrice=" + totalPrice + ", dateOrder=" + dateOrder + ", agentId=" + agentId
				+ ", customerId=" + customerId + ", productId=" + productId + ", quantity=" + quantity
				+ ", orderStatus=" + orderStatus + "]";
	}
	
	

	
}
