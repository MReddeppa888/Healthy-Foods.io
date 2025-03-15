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

import com.tapfoods.DAOImpl.CartItemDAO;
import com.tapfoods.DAOImpl.OrderItemDAOImpl;
import com.tapfoods.DAOImpl.OrderTableDAOImpl;
import com.tapfoods.models.CartItem;
import com.tapfoods.models.OrderItem;
import com.tapfoods.models.User;

@SuppressWarnings("serial")
@WebServlet("/OrderItemServlet")
public class OrderItemServlet extends HttpServlet
{
	private int numberOfRows;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		//String rowsParam = arg0.getParameter("rows");
		
		int rows =(Integer.parseInt(arg0.getParameter("rows")));
		int itemId=(Integer.parseInt(arg0.getParameter("itemId")));
		double cartTotal=(Double.parseDouble(arg0.getParameter("cartTotal")));
		String paymentMethod=arg0.getParameter("paymentMethod");
		
		HttpSession session = arg0.getSession();
		
		User user = (User) session.getAttribute("session_user");
		int userId = user.getUserId();
		
		OrderItemDAOImpl orderItemDAOImpl = new OrderItemDAOImpl();
		OrderTableDAOImpl orderTableDAOImpl = new OrderTableDAOImpl();
		int orderId = orderTableDAOImpl.getSingleOrderDetails(userId);
		
		orderId=orderId-rows+1;
		
		Map<Integer, CartItem> cartItems = (Map<Integer, CartItem>) session.getAttribute("session_cart");

		if (cartItems == null || cartItems.isEmpty()) {
		    System.out.println("Cart is empty or not found in session.");
		    return;
		}
		
		Collection<CartItem> values = cartItems.values();
		//System.out.println(values);

		Iterator<CartItem> iterator = values.iterator();
		//int rows=0;
		while (iterator.hasNext()) {
		    CartItem cartItem = iterator.next();  // Fetch only once per iteration
		    
		    
		    
		    int itemId2 = cartItem.getItemId();
		    int quantity = cartItem.getItemQuantity();
		    double price = cartItem.getPrice();

		    OrderItem orderItem = new OrderItem(orderId, itemId2, quantity, quantity*price);

		    orderItemDAOImpl.addOrderItem(orderItem);
		    orderId++;
		    numberOfRows++;
		}
		
		//System.out.println(rows+"  "+itemId+"  "+cartTotal+"  "+paymentMethod+" in order item ");
		
		arg0.setAttribute("rows", rows);
		arg0.setAttribute("itemId", itemId);
		arg0.setAttribute("cartTotal", cartTotal);
		arg0.setAttribute("paymentMethod", paymentMethod);
		
		
		arg1.sendRedirect("OrderHistoryServlet?rows=" + rows + "&itemId=" + itemId + "&cartTotal=" + cartTotal + "&paymentMethod=" + paymentMethod);
			
		
		
		
	}

	
}
