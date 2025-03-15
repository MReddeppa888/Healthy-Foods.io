package com.tapfoods.DAO;

import java.util.List;

import com.tapfoods.models.MenuItem;

public interface MenuItemDAO 
{
	 int addMenuItem(MenuItem m);
	 List<MenuItem>  getAllMenuItem(int restaurantId);
	 List<MenuItem> getMenuItem(String email);
	 int updateMenuItem(MenuItem m);
	 int updateMenuItemImage(String imagePath,int x);
	 int deleteMenuItem(String email);
	MenuItem getMenuItem(int itemId);
	
}
