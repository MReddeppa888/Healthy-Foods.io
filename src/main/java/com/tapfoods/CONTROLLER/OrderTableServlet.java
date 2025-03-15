package com.tapfoods.CONTROLLER;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.DAOImpl.OrderTableDAOImpl;
import com.tapfoods.models.CartItem;
import com.tapfoods.models.OrderTable;
import com.tapfoods.models.User;

@SuppressWarnings("serial")
@WebServlet("/placeOrder")
public class OrderTableServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		User user = (User) session.getAttribute("session_user");
		int itemId=(Integer.parseInt(req.getParameter("itemId")));
		double cartTotal=(Double.parseDouble(req.getParameter("cartTotal")));
		String paymentMethod=req.getParameter("paymentMethod");
		
		
	
		int userId = user.getUserId();
		
		OrderTableDAOImpl orderTableDAOImpl = new OrderTableDAOImpl();
		
		
		
		
		
//		List<MenuItem> menuItem=(List<MenuItem> )session.getAttribute("session_menuItem");
//		List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("session_restaurant");
		Map<Integer, CartItem> cartItems = (Map<Integer, CartItem>) session.getAttribute("session_cart");

		if (cartItems == null || cartItems.isEmpty()) {
		    System.out.println("Cart is empty or not found in session.");
		    return;
		}
		
		Collection<CartItem> values = cartItems.values();
		//System.out.println(values);

		Iterator<CartItem> iterator = values.iterator();
		int rows=0;
		while (iterator.hasNext()) {
		    CartItem cartItem = iterator.next();  // Fetch only once per iteration

		    int restaurantId = cartItem.getRestaurantId();
		    int quantity = cartItem.getItemQuantity();
		    double price = cartItem.getPrice();

		    OrderTable orderTable = new OrderTable(userId, restaurantId, quantity * price, "pending", paymentMethod);
		    orderTableDAOImpl.addOrderDetails(orderTable);
		    rows++;
		   
		    
		   
		}
		//System.out.println(rows+"  "+itemId+"  "+cartTotal+"  "+paymentMethod+" in order table");
		
		req.setAttribute("rows", rows);
		req.setAttribute("itemId", itemId);
		req.setAttribute("cartTotal", cartTotal);
		req.setAttribute("paymentMethod", paymentMethod);
		
		
		if(rows !=0)
		{
			resp.sendRedirect("OrderItemServlet?rows=" + rows + "&itemId=" + itemId + "&cartTotal=" + cartTotal + "&paymentMethod=" + paymentMethod);
			
			//resp.sendRedirect("OrderItemServlet?rows=" + rows);
			
			// resp.sendRedirect("OrderItemServlet?rows");
		}
		
		
		
		
		
		
		
		
		
	}
	
}










