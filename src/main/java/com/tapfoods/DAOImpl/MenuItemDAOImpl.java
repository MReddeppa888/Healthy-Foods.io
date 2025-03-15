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

import com.tapfoods.DAO.MenuItemDAO;
import com.tapfoods.DBUtils.DBUtils;
import com.tapfoods.models.MenuItem;

public class MenuItemDAOImpl implements MenuItemDAO 
{
	Connection con;
	private PreparedStatement pstmt;
	int status=0;
	private Statement stmt;
	private ResultSet resultSet;
	
	
	List<MenuItem> list=new ArrayList<MenuItem>();
	private MenuItem MenuItem=null;
	
	
	private static final String ADD_MENU_ITEM="insert into `menuitems`(`restaurantId`,`itemName`,`price`,`description`,`description`,`imagpath`) values(?,?,?,?,?,?)";     
	private static final String SELECT_ALL_MENU_ITEM="select * from `menuitems` where `restaurantId`=?";
	private static final String SELECT_ON_MENU_ITEM_Name="select * from `menuitems` where `itemName`=?";
	private static final String SELECT_ON_MENU_ITEM_Id="select * from `menuitems` where `menuId`=?";
	private static final String UPDATE_ON_MENU_ITEM_Name="update `menuitems` set `restaurantId`=?,`price`=?,`description`=?,`imagpath`=? where `itemName`=?";         
	private static final String DELETE_ON_MENU_ITEM_Name1="delete  from `menuitems` where `itemName`=?";
	
	public MenuItemDAOImpl() 
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
	public int addMenuItem(MenuItem m) {
		try {
			pstmt=con.prepareStatement(ADD_MENU_ITEM);
			pstmt.setInt(1, m.getRestaurantId());
			pstmt.setString(2, m.getItemName());
			pstmt.setDouble(3, m.getPrice());
			pstmt.setString(4, m.getDescription());
			pstmt.setString(5, m.isAvailable());
			//pstmt.setString(6, m.getImagePath());
			status = pstmt.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<MenuItem> getAllMenuItem(int restaurantId) {
		
		try
		{
			pstmt=con.prepareStatement(SELECT_ALL_MENU_ITEM);
			pstmt.setInt(1, restaurantId);
			resultSet=pstmt.executeQuery();
			list=extractUserFromResultSet(resultSet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	
	@Override
	public List<MenuItem> getMenuItem(String itemName) {
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_MENU_ITEM_Name);
			pstmt.setString(1, itemName);
			
			resultSet=pstmt.executeQuery();
			list=extractUserFromResultSet(resultSet);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public int updateMenuItem(MenuItem m) {
		try
		{
			pstmt=con.prepareStatement(UPDATE_ON_MENU_ITEM_Name);
			pstmt.setInt(1, m.getRestaurantId());
			pstmt.setString(6, m.getItemName());
			pstmt.setDouble(2, m.getPrice());
			pstmt.setString(3, m.getDescription());
			pstmt.setString(4, m.isAvailable());
			//pstmt.setString(5, m.getImagePath());
			status = pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public int updateMenuItemImage(String imagePath,int x) {
		try
		{
			File imageFile = new File(imagePath); // Corrected File class usage
            FileInputStream fis = new FileInputStream(imageFile);

            PreparedStatement ps = con.prepareStatement("update `menuitems` set `imagePath`=? where `menuId`=?");
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
	public int deleteMenuItem(String itemName) {
		try 
		{
			pstmt=con.prepareStatement(DELETE_ON_MENU_ITEM_Name1);
			pstmt.setString(1, itemName);
			status=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
		
	
	List<MenuItem> extractUserFromResultSet(ResultSet resultSet)
	{   
		try
		{
			while(resultSet.next())
			{
				int menuId=resultSet.getInt("menuId");
				int restaurantId=resultSet.getInt("restaurantId");
				String itemName=resultSet.getString("itemName");
				Float	price=resultSet.getFloat("price");
				String	description=resultSet.getString("description");
				String isAvailable=resultSet.getString("isAvailable");
				Blob	imagepath=resultSet.getBlob("imagePath");
				list.add(new MenuItem(menuId,restaurantId,itemName,price,description,isAvailable,imagepath));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MenuItem getMenuItem(int itemId) {
		
		try
		{
			pstmt=con.prepareStatement(SELECT_ON_MENU_ITEM_Id);
			pstmt.setInt(1, itemId);
			
			resultSet=pstmt.executeQuery();
			list=extractUserFromResultSet(resultSet);
			MenuItem=list.get(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return MenuItem;
		
	}
}








