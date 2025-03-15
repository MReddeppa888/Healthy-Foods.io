package com.tapfoods.models;

import java.util.Date;

public class OrderTable 
{
	//orderId, restaurantId, userId, orderTime, , status,       
	
	private int orderId;
	private int userId;
	private int restaurantId;
	private Date ordetDate;
	private double totalAmount;
	private String status;
	private String paymentMethed;
	public OrderTable() {
		super();
	}
	public OrderTable(int orderId, int userId, int restaurantId, Date ordetDate, double totalAmount, String status,
			String paymentMethed) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.ordetDate = ordetDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethed = paymentMethed;
	}
	public OrderTable(int userId, int restaurantId, double totalAmount, String status, String paymentMethed) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethed = paymentMethed;
	}
	public OrderTable(int userId, int restaurantId, Date ordetDate, double totalAmount, String status,
			String paymentMethed) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.ordetDate = ordetDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethed = paymentMethed;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Date getOrdetDate() {
		return ordetDate;
	}
	public void setOrdetDate(Date ordetDate) {
		this.ordetDate = ordetDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMethed() {
		return paymentMethed;
	}
	public void setPaymentMethed(String paymentMethed) {
		this.paymentMethed = paymentMethed;
	}
	@Override
	public String toString() {
		return "OrderTable [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId
				+ ", ordetDate=" + ordetDate + ", totalAmount=" + totalAmount + ", status=" + status
				+ ", paymentMethed=" + paymentMethed + "]";
	}

	

}
