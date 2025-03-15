package com.tapfoods.DAO;

import java.util.List;

import com.tapfoods.models.Restaurant;

public interface RestaurantDAO
{
	int addRestaurant(Restaurant r);
	List<Restaurant> getAllRestaurant();
	Restaurant  getRestaurant(String restaurantname);
	 int updateRestaurant(Restaurant r);
	 int updateRestaurantImage(String imagePath,int x);
	 int deleteRestaurant(int getRestaurantId);
	
}
