package com.tapfoods.DAO;

import java.util.ArrayList;

import com.tapfoods.models.OrderHistory;

public interface OrderHistoryDAO 
{
	
	int addOrderItemHistory(OrderHistory o);
	 ArrayList<OrderHistory> getAllOrderItemHistory();
	 ArrayList<OrderHistory> getOrderItemHistory(int orderHistoryId);
	 int deleteOrderItemHistory(int orderHistoryId);
	 int updateOrderItemHistory(OrderHistory o);
	
	
}
