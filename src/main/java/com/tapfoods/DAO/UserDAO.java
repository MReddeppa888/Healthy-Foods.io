package com.tapfoods.DAO;

import java.util.ArrayList;

import com.tapfoods.models.User;

public interface UserDAO 
{
	 int addUser(User u);
	 ArrayList<User> getAllUsers();
	 User getUser(String email);
	 int updateUser(User u);
	 int deleteUser(String email);
}
