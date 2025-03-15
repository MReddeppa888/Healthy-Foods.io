package com.tapfoods.CONTROLLER;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.DAOImpl.CartItemDAO;
import com.tapfoods.DAOImpl.OrderHistoryDAOImpl;
import com.tapfoods.DAOImpl.OrderItemDAOImpl;
import com.tapfoods.DAOImpl.OrderTableDAOImpl;
import com.tapfoods.models.CartItem;
import com.tapfoods.models.OrderHistory;
import com.tapfoods.models.User;

@SuppressWarnings("serial")
@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet
{
	private int numberOfRows;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		int rows =(Integer.parseInt(arg0.getParameter("rows")));
		int itemId=(Integer.parseInt(arg0.getParameter("itemId")));
		double cartTotal=(Double.parseDouble(arg0.getParameter("cartTotal")));
		String paymentMethod=arg0.getParameter("paymentMethod");
		
		
		System.out.println(rows+"  "+itemId+"  "+cartTotal+"  "+paymentMethod+" in order history");
		
		
		HttpSession session = arg0.getSession();
		
		User user = (User) session.getAttribute("session_user");
		int userId = user.getUserId();
		
		OrderHistoryDAOImpl orderHistoryDAOImpl = new OrderHistoryDAOImpl();
		
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
		
		
		     itemId = cartItem.getItemId();
		    int quantity = cartItem.getItemQuantity();
		    double price = cartItem.getPrice();
		    
		    //System.out.println(orderId+" "+userId +" "+ price +" "+ paymentMethod);
		    
		    OrderHistory orderHistory = new OrderHistory(orderId, userId, price, "shipped", paymentMethod);
		    orderHistoryDAOImpl.addOrderItemHistory(orderHistory);
		    orderId++;
		    numberOfRows++;
		}
		
		
			CartItemDAO cartItemDAO = new CartItemDAO();
			Map<Integer, CartItem> items = cartItemDAO.clearCart();
			session.setAttribute("session_cart", items);
				
			arg1.sendRedirect("orderSuccessful.jsp");
				
		
		
		
		
		
		
		
		
		
		
	}
}
