package com.tapfoods.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import com.tapfoods.DAO.OrderTableDAO;
import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.models.OrderTable;

public class OrderTableDAOImpl implements OrderTableDAO 
{

	Connection con;
	private PreparedStatement pstmt;
	int status=0;
	private Statement stmt;
	private ResultSet resultSet;
	int orderId=0;
	
	
	ArrayList<OrderTable> ArrayList=new ArrayList<OrderTable>();
	
															//orderId, userId, restaurantId, ordetDate, totalAmount, status, paymentMethed
	private static final String ADD_ORDER_ITEM="insert into `ordertable`(`userId`,`restaurantId`,`totalAmount`,`status`,`paymentMethed`) values(?,?,?,?,?)";     
	private static final String SELECT_ALL_ORDER_ITEM="select * from `ordertable`";
	private static final String SELECT_ON_ORDER_USER_ID="select max(orderId) from `ordertable`";
	private static final String UPDATE_ON_ORDER_USER_ID="update `ordertable` set `restaurantId`=?,`ordetDate`=?,`totalAmount`=?,`status`=?,`paymentMethed`=?, where `userId`=?";         
	private static final String DELETE_ON_ORDER_ORDER_Id="delete  from `ordertable` where `orderId`=?";
	
	
	public OrderTableDAOImpl() 
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
	public int addOrderDetails(OrderTable o) {
		try {
			pstmt=con.prepareStatement(ADD_ORDER_ITEM);
			pstmt.setInt(2, o.getRestaurantId());
			pstmt.setInt(1, o.getUserId());
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
	public ArrayList<OrderTable> getAllOrderDetails() {
		try
		{
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL_ORDER_ITEM);
			ArrayList=extractUserFromResultSet(resultSet);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ArrayList;
	}

	@Override
	public int getSingleOrderDetails(int userId) {
		try
		{
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(SELECT_ON_ORDER_USER_ID);

			if (resultSet.next()) {  // Move cursor to the first row
			    orderId = resultSet.getInt(1);  // Use alias from query
			} else {
			    System.out.println("No orders found.");
			}
			
//			ResultSetMetaData metaData = resultSet.getMetaData();
//			for (int i = 1; i <= metaData.getColumnCount(); i++) {
//			    System.out.println("Column: " + metaData.getColumnName(i));
//			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderId;
	}

	@Override
	public int deleteOrderDetails(int orderId) {
		try 
		{
			pstmt=con.prepareStatement(DELETE_ON_ORDER_ORDER_Id);
			pstmt.setInt(1, orderId);
			status=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public int updateOrderDetails(OrderTable o) {
		try 
		{
			pstmt=con.prepareStatement(UPDATE_ON_ORDER_USER_ID);
			pstmt.setInt(1, o.getOrderId());
			pstmt.setDate(2, (Date) o.getOrdetDate());
			pstmt.setDouble(3, o.getTotalAmount());
			pstmt.setString(4, o.getStatus());
			pstmt.setString(5, o.getPaymentMethed());
			pstmt.setInt(5, o.getUserId());
			status=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	ArrayList<OrderTable> extractUserFromResultSet(ResultSet resultSet)
	{
		try
		{
			while(resultSet.next())
			{
				//orderId, userId, restaurantId, ordetDate, totalAmount, status, paymentMethed
				ArrayList.add(new OrderTable(resultSet.getInt("orderId"),
						resultSet.getInt("userId"),
						resultSet.getInt("restaurantId"),
						resultSet.getDate("ordetDate"),
						resultSet.getDouble("totalAmount"),
						resultSet.getString("status"),
						resultSet.getString("paymentMethed")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ArrayList;
	}

	
}












