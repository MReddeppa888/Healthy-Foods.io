package com.tapfoods.CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.DAO.MenuItemDAO;
import com.tapfoods.DAOImpl.MenuItemDAOImpl;
import com.tapfoods.models.MenuItem;
@WebServlet("/menu")
public class MenuItemServlet extends HttpServlet
{
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		int restaurantId=Integer.parseInt(arg0.getParameter("restaurantId"));
		session=arg0.getSession();        
		MenuItemDAO MenuItemDAO =new  MenuItemDAOImpl();
		List<MenuItem> menuItem=MenuItemDAO.getAllMenuItem(restaurantId);
		session.setAttribute("session_menuItem", menuItem);
	
		arg1.sendRedirect("menuHome.jsp");
	}
}
