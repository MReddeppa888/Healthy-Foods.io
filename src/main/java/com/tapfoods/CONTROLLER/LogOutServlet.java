package com.tapfoods.CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.models.*;

@SuppressWarnings("serial")
@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet
{
	
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		
		 User user = (User) session.getAttribute("session_user");
		 List<Restaurant> restaurantList=(List<Restaurant> )session.getAttribute("session_restaurant");
		 List<MenuItem> menuItem=(List<MenuItem> )session.getAttribute("session_menuItem");
		 
//		 System.out.println(user);
//		 System.out.println(restaurantList);
//		 System.out.println(menuItem);
		 
		 session.setAttribute("session_user", null);
//		 session.setAttribute("session_restaurant", null);
//		 session.setAttribute("session_menuItem", null);
		 
		 
		 user = (User) session.getAttribute("session_user");
		 restaurantList=(List<Restaurant> )session.getAttribute("session_restaurant");
		 menuItem=(List<MenuItem> )session.getAttribute("session_menuItem");
		 
//		 System.out.println(user);
//		 System.out.println(restaurantList);
//		 System.out.println(menuItem);
		 
		 resp.sendRedirect("loginHome.jsp");
		 
	}
	
}



