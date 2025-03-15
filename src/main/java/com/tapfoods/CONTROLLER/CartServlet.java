package com.tapfoods.CONTROLLER;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.DAO.MenuItemDAO;
import com.tapfoods.DAOImpl.CartItemDAO;
import com.tapfoods.DAOImpl.MenuItemDAOImpl;
import com.tapfoods.models.CartItem;
import com.tapfoods.models.MenuItem;

@SuppressWarnings("serial")
@WebServlet("/cart")
public class CartServlet extends HttpServlet 
{


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<Integer, CartItem> items = null;
		HttpSession session = req.getSession();
		
		CartItemDAO cart =(CartItemDAO) session.getAttribute("cart");
		
		if(cart==null)
		{
			cart=new CartItemDAO();
			session.setAttribute("cart", cart);
		}
		String itemId = req.getParameter("itemId");
		String action = req.getParameter("action");
		
		if("add".equals(action))
		{
			 items = addItemToCart(req,cart);
		}
		else if("update".equals(action))
		{
			items=updateCartItem(req,cart);
		}
		else if("remove".equals(action))
		{
			 items = removeItemFromCart(req,cart);
		}
		else if("CheckOutUpdate".equals(action))
		{
			items = updateCartItem(req,cart);
			session.setAttribute("session_cart", items);
			resp.sendRedirect("checkOut.jsp");
		}
		
		if(!("CheckOutUpdate".equals(action)))
		{
			session.setAttribute("session_cart", items);
			resp.sendRedirect("cart.jsp");
		}
		
		
		
		
	}	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
		
	}
	
	
	private Map<Integer, CartItem> addItemToCart(HttpServletRequest req, CartItemDAO cart) {

		
		Map<Integer, CartItem> items = null;
		
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		MenuItemDAO menuItemDAO = new MenuItemDAOImpl();
		
		 MenuItem menuItem = menuItemDAO.getMenuItem(itemId);
		
		
		HttpSession session = req.getSession();
		session.setAttribute("restaurantId",menuItem.getRestaurantId() );		
		if(menuItem !=null)
		{
			CartItem item=new CartItem(menuItem.getMenuId(),menuItem.getRestaurantId(),
					menuItem.getItemName(),quantity,menuItem.getPrice(),quantity*menuItem.getPrice());
			
			items = cart.addItem(item);
			
		}
		return items;
	}
	
	private Map<Integer, CartItem> updateCartItem(HttpServletRequest req, CartItemDAO cart) {
		
		int itemId = (Integer.parseInt(req.getParameter("itemId")));
		int quantiry = (Integer.parseInt(req.getParameter("quantity")));
		
		Map<Integer, CartItem> items = cart.updateItem(itemId, quantiry);
		
		return items;
	}
	
		
	private Map<Integer, CartItem> removeItemFromCart(HttpServletRequest req, CartItemDAO cart) {

		int itemId=(Integer.parseInt(req.getParameter("itemId")));
		
		Map<Integer, CartItem> items=cart.removeItem(itemId);
		return items;
	}


	

	
}







