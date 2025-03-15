package com.tapfoods.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfoods.DAO.OrderHistoryDAO;
import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.models.OrderHistory;

public class OrderHistoryDAOImpl implements OrderHistoryDAO 
{

	Connection con;
	private PreparedStatement pstmt;
	int status=0;
	private Statement stmt;
	private ResultSet resultSet;
	
	
	ArrayList<OrderHistory> OrderHistoryArrayList=new ArrayList<OrderHistory>();
	
										//orderHistoryId, orderId, userId, orderDate, totalAmount, status, paymentMethed
	private static final String ADD_orderHistory="insert into `orderhistory`(`orderId`,`userId`,`totalAmount`,`status`,`paymentMethed`) values(?,?,?,?,?)";
	private static final String SELECT_ALL="select * from `orderhistory`";
	private static final String SELECT_ON_OrderHistoryId="select * from `orderhistory` where `orderHistoryId`=?";
	private static final String DELETE_ON_OrderHistoryId="delete  from `orderhistory` where `orderHistoryId`=?";
	private static final String UPDATE_ON_ORDER_OrderHistoryId="update `orderhistory` set `orderId`=?,`userId`=?,`totalAmount`=?,`status`=?, `paymentMethed`=? where `orderHistoryId`=?";         

	
	public OrderHistoryDAOImpl() 
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
	public int addOrderItemHistory(OrderHistory o) {
		try {
			pstmt=con.prepareStatement(ADD_orderHistory);
			pstmt.setInt(1, o.getOrderId());
			pstmt.setInt(2, o.getUserId());
			pstmt.setDouble(3, o.getTotalAmount());
			pstmt.setString(4, o.getStatus());
			pstmt.setString(5, o.getPaymentMethed());
			status = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}


	@Override
	public ArrayList<OrderHistory> getAllOrderItemHistory() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<OrderHistory> getOrderItemHistory(int orderHistoryId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int deleteOrderItemHistory(int orderHistoryId) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int updateOrderItemHistory(OrderHistory o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
}
