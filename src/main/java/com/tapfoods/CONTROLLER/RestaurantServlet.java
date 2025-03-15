package com.tapfoods.CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.DAO.RestaurantDAO;
import com.tapfoods.DAOImpl.MenuItemDAOImpl;
import com.tapfoods.DAOImpl.RestaurantDAOImpl;
import com.tapfoods.models.Restaurant;
import com.tapfoods.models.User;

@WebServlet("/RestaurantServlet")
@SuppressWarnings("serial")
public class RestaurantServlet extends HttpServlet
{
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		session=arg0.getSession();        
		MenuItemDAOImpl menuDAO =new  MenuItemDAOImpl();
		RestaurantDAOImpl restaurantDAO =new  RestaurantDAOImpl();
		
//		String imagePath=null;
//		int num=1;
//		for(int i=1;i<=190;i++)
//		{
//			imagePath = "E:\\tap_food\\Images2\\"+num+".jpg";
//			int updateRestaurantImage = menuDAO.updateMenuItemImage(imagePath,i);
//			num++;
//			if(num==100)
//			{
//				num=5;
//			}
//		}
		
		
		
		
		
		List<Restaurant> restaurant=restaurantDAO.getAllRestaurant();
		
		session.setAttribute("session_restaurant", restaurant);
		 User user = (User) session.getAttribute("session_user");
		if(user != null)
		{
			arg1.sendRedirect("loginHome.jsp");
		}
		else
		{
			arg1.sendRedirect("home.jsp");
		}
	}
}
