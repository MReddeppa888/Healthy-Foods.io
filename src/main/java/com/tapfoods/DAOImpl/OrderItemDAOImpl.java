package com.tapfoods.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfoods.DAO.OrderItemDAO;
import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.models.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO 
{
	Connection con;
	private PreparedStatement pstmt;
	int status=0;
	private Statement stmt;
	private ResultSet resultSet;
	
	
	ArrayList<OrderItem> userArrayList=new ArrayList<OrderItem>();
	
	private static final String ADD_OrderItem="insert into `OrderItem`(`orderId`,`menuId`,`quantity`,`itemTotal`) values(?,?,?,?)";
	private static final String SELECT_ALL="select * from `OrderItem`";
	private static final String SELECT_ON_orderItemId="select * from `OrderItem` where `orderItemId`=?";
	private static final String DELETE_ON_orderItemId="delete  from `OrderItem` where `orderItemId`=?";
	private static final String UPDATE_ON_ORDER_orderItemId="update `ordertable` set `orderId`=?,`menuId`=?,`quantity`=?,`itemTotal`=? where `orderItemId`=?";         

	
	
	public OrderItemDAOImpl() 
	{
		try
		{
			con=DBUtils.connect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public int addOrderItem(OrderItem O) {
		try {
			pstmt=con.prepareStatement(ADD_OrderItem);
			pstmt.setInt(1, O.getOrderId());
			pstmt.setInt(2, O.getMenuId());
			pstmt.setInt(3, O.getQuantity());
			pstmt.setDouble(4, O.getItemTotal());
			status = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<OrderItem> getAllOrderItem() {
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL);
			userArrayList=extractUserFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userArrayList;
	}

	@Override
	public ArrayList<OrderItem> getOrderItem(int orderItemId) {
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_orderItemId);
			pstmt.setInt(1, orderItemId);
			
			resultSet=pstmt.executeQuery();
			userArrayList=extractUserFromResultSet(resultSet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userArrayList;
	}

	@Override
	public int deleteOrderItem(int orderItemId) {
		try 
		{
			pstmt=con.prepareStatement(DELETE_ON_orderItemId);
			pstmt.setInt(1, orderItemId);
			status=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int updateOrderItem(OrderItem o) {
		try 
		{
			pstmt=con.prepareStatement(UPDATE_ON_ORDER_orderItemId);
			pstmt.setInt(1, o.getOrderId());
			pstmt.setInt(2,o.getMenuId());
			pstmt.setInt(3, o.getQuantity());
			pstmt.setDouble(4, o.getItemTotal());
			pstmt.setInt(5, o.getOrderItemId());
			status=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	ArrayList<OrderItem> extractUserFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				userArrayList.add(new OrderItem(resultSet.getInt("orderItemId"),
						resultSet.getInt("orderId"),
						resultSet.getInt("menuId"),
						resultSet.getInt("quantity"),
						resultSet.getDouble("itemTotal")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userArrayList;
	}

	
}






