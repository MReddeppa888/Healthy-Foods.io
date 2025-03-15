package com.tapfoods.models;

public class Restaurant
{
	private int restaurantId;
	private String restaurantname;
	private String deliveryTime;
	private String cvisineType;
	private String address;
	private double ratings;
	private String isActive;
	private int adminuserId;
	private java.sql.Blob imagePath;
	public Restaurant() {
		super();
	}
	

	
	



	public Restaurant(String restaurantname, String deliveryTime, String cvisineType, String address, double ratings,
			String isActive, int adminuserId, java.sql.Blob imagePath) {
		super();
		this.restaurantname = restaurantname;
		this.deliveryTime = deliveryTime;
		this.cvisineType = cvisineType;
		this.address = address;
		this.ratings = ratings;
		this.isActive = isActive;
		this.adminuserId = adminuserId;
		this.imagePath = imagePath;
	}


//	public Restaurant(int restaurantId2, String restaurantname2, String deliveryTime2, String cvisineType2,
//			String address2, Double ratings2, String isActive2, int adminuserId2, java.sql.Blob imagePath2) {
//		// TODO Auto-generated constructor stub
//	}
	



	public Restaurant(int restaurantId, String restaurantname, String deliveryTime, String cvisineType, String address,
			Double ratings, String isActive, int adminuserId, java.sql.Blob imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantname = restaurantname;
		this.deliveryTime = deliveryTime;
		this.cvisineType = cvisineType;
		this.address = address;
		this.ratings = ratings;
		this.isActive = isActive;
		this.adminuserId = adminuserId;
		this.imagePath = imagePath;
	}



	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantname() {
		return restaurantname;
	}
	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}
	public String getCvisineType() {
		return cvisineType;
	}
	public void setCvisineType(String cvisineType) {
		this.cvisineType = cvisineType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public java.sql.Blob getImagePath() {
		return imagePath;
	}
	public void setImagePath(java.sql.Blob imagePath) {
		this.imagePath = imagePath;
	}
	public String isActive() {
		return isActive;
	}
	public void setActive(String isActive) {
		this.isActive = isActive;
	}
	public int getAdminuserId() {
		return adminuserId;
	}
	public void setAdminuserId(int adminuserId) {
		this.adminuserId = adminuserId;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantname=" + restaurantname + ", cvisineType="
				+ cvisineType + ", address=" + address + ", ratings=" + ratings + ", deliveryTime=" + deliveryTime
				+ ", imagePath=" + imagePath + ", isActive=" + isActive + ", adminuserId=" + adminuserId + "]";
	}
	
	
	
	
}
