package com.tapfoods.DAO;

import java.util.ArrayList;

import com.tapfoods.models.OrderTable;

public interface OrderTableDAO 
{
	int addOrderDetails(OrderTable o);
	ArrayList<OrderTable> getAllOrderDetails();
	int getSingleOrderDetails(int userId);
	int deleteOrderDetails(int userId);
	int updateOrderDetails(OrderTable o);
	
}
