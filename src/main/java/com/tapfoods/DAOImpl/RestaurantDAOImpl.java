package com.tapfoods.DAOImpl;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tapfoods.DAO.RestaurantDAO;
import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.models.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {
	Connection con;
	private PreparedStatement pstmt;
	int status=0;
	private Statement stmt;
	private ResultSet resultSet;
	
	
	String imagePath = null; // Change to your image path
	
	
	List<Restaurant> list=new ArrayList<Restaurant>();
	private Restaurant restaurant;
	
	
	private static final String ADD_RESTAURANT="insert into `restaurant`(`restaurantname`,`cvisineType`,`address`,`ratings`,`isActive`,`imagePath`,`adminuserId`) values(?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_RESTAURANT="select * from `restaurant`";
	private static final String SELECT_ON_restaurantname="select * from `restaurant` where `restaurantname`=?";
	private static final String UPDATE_ON_adminuserId="update `restaurant` set `restaurantname`=?,`cvisineType`=?`address`=?,`ratings`=?,`isActive`=?,`imagePath`=? where `adminuserId`=?";         
	private static final String DELETE_ON_adminuserId="delete  from `restaurant` where `adminuserId`=?";
	
	
	public RestaurantDAOImpl()
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
	public int addRestaurant(Restaurant r) 
	{
		try {
			pstmt=con.prepareStatement(ADD_RESTAURANT);
			pstmt.setString(1, r.getRestaurantname());
			pstmt.setString(2, r.getCvisineType());
			pstmt.setString(3, r.getAddress());
			pstmt.setFloat(4, (float) r.getRatings());
			pstmt.setString(5, r.isActive());
			pstmt.setInt(7, r.getAdminuserId());
			//pstmt.setBinaryStream(6, r.getImagePath());
			status = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Restaurant> getAllRestaurant() 
	{
		try
		{
			
			stmt=con.createStatement();
			resultSet=stmt.executeQuery(SELECT_ALL_RESTAURANT);
			list=extractUserFromResultSet(resultSet);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public Restaurant getRestaurant(String restaurantname) 
	{
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_restaurantname);
			pstmt.setString(1, restaurantname);
			
			resultSet=pstmt.executeQuery();
			list=extractUserFromResultSet(resultSet);
			restaurant=list.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public int updateRestaurant(Restaurant r) {
		try
		{
			pstmt=con.prepareStatement(UPDATE_ON_adminuserId);
			pstmt.setString(1, r.getRestaurantname());
			pstmt.setString(2, r.getCvisineType());
			pstmt.setString(3, r.getAddress());
			pstmt.setFloat(4, (float) r.getRatings());
			pstmt.setString(5, r.isActive());
			//pstmt.setBinaryStream(6, r.getImagePath());
			pstmt.setInt(7, r.getAdminuserId());
			status = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public int updateRestaurantImage(String imagePath,int x) {
		try
		{
			File imageFile = new File(imagePath); // Corrected File class usage
            FileInputStream fis = new FileInputStream(imageFile);
            //update `restaurant` set `restaurantname`=?,`cvisineType`=?`address`=?,`ratings`=?,`isActive`=?,`imagePath`=? where `adminuserId`=?"; 
            PreparedStatement ps = con.prepareStatement("update `restaurant` set `imagePath`=? where `restaurantId`=?");
            ps.setBinaryStream(1, fis, (int) imageFile.length());
            ps.setInt(2, x);
            int status = ps.executeUpdate();
            if(status==1) {
            	
            System.out.println("Image stored as BLOB successfully Completed......"+x);
            x++;
            }
            // Close resources
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteRestaurant(int adminuserId) {
		try 
		{
			pstmt=con.prepareStatement(DELETE_ON_adminuserId);
			pstmt.setInt(1, adminuserId);
			status=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	
	List<Restaurant> extractUserFromResultSet(ResultSet resultSet)
	{
		
		try
		{
			while(resultSet.next())
			{
				
				
				int  restaurantId=resultSet.getInt("restaurantId");
				String restaurantname=resultSet.getString("restaurantname");
				String	deliveryTime=resultSet.getString("deliveryTime");
				String	cvisineType=resultSet.getString("cvisineType");
				String	address=resultSet.getString("address");
				Double	ratings=resultSet.getDouble("ratings");
				String	isActive=resultSet.getString("isActive");
				int	 adminuserId=resultSet.getInt("adminuserId");
				Blob	imagePath=resultSet.getBlob("imagePath");
				
				//System.out.println(imagePath);
			
				list.add(new Restaurant(restaurantId,restaurantname,deliveryTime,cvisineType,
										address,ratings,isActive,adminuserId,imagePath));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

}















