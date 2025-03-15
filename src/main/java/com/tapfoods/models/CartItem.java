package com.tapfoods.models;

public class CartItem {
    private int itemId;
    private int restaurantId;
    private String itemName;
    private int itemQuantity;
    private double price;
    private double subTotal;

    public CartItem() {}

    public CartItem(int itemId, int restaurantId, String itemName, int itemQuantity, double price, double subTotal) {
        this.itemId = itemId;
        this.restaurantId = restaurantId;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.price = price;
        this.subTotal = subTotal;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "CartItem [itemId=" + itemId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", price=" + price + "]";
    }
}
