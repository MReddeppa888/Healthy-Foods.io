package com.tapfoods.models;

public class MenuItem 
{
	private int menuId;
	private int restaurantId;
	private String itemName;
	private float price;
	private String description;
	private String isAvailable;
	private java.sql.Blob imagePath;
	public MenuItem() {
		super();
	}
	
	public MenuItem(int restaurantId, String itemName, float price, String description, String isAvailable,
			java.sql.Blob imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	public MenuItem(int menuId, int restaurantId, String itemName, float price, String description, String isAvailable,
			java.sql.Blob imagePath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	public java.sql.Blob getImagePath() {
		return imagePath;
	}
	public void setImagePath(java.sql.Blob imagePath) {
		this.imagePath = imagePath;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String isAvailable() {
		return isAvailable;
	}
	public void setAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "MenuItem [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName
				+ ", description=" + description + ", price=" + price + ", isAvailable=" + isAvailable + "]";
	}
	
	
	
}
