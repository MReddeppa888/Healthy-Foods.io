package com.tapfoods.models;

import java.util.Date;

public class OrderHistory 
{
	private int orderHistoryId;
	private int orderId;
	private int userId;
	private Date orderDate;
	private double totalAmount;
	private String status;
	private String paymentMethed;
	
	public OrderHistory() {
		super();
	}

	public OrderHistory(int orderId, int userId, double totalAmount, String status, String paymentMethed) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethed = paymentMethed;
	}

	public OrderHistory(int orderId, int userId, Date orderDate, double totalAmount, String status,
			String paymentMethed) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethed = paymentMethed;
	}

	public OrderHistory(int orderHistoryId, int orderId, int userId, Date orderDate, double totalAmount, String status,
			String paymentMethed) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethed = paymentMethed;
	}

	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
		return "OrderHistory [orderHistoryId=" + orderHistoryId + ", orderId=" + orderId + ", userId=" + userId
				+ ", ordetDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status
				+ ", paymentMethed=" + paymentMethed + "]";
	}
	
	
}
