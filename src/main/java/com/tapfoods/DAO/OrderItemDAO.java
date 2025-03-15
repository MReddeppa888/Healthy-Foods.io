package com.tapfoods.DAO;

import java.util.ArrayList;

import com.tapfoods.models.OrderItem;

public interface OrderItemDAO 
{
	
	 int addOrderItem(OrderItem o);
	 ArrayList<OrderItem> getAllOrderItem();
	 ArrayList<OrderItem> getOrderItem(int orderItemId);
	 int deleteOrderItem(int orderItemId);
	 int updateOrderItem(OrderItem o);
	
	 
}
