<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.tapfoods.models.CartItem" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.tapfoods.models.*" %>
<%@ page import="com.tapfoods.DAOImpl.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart - Tap~Foods</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!--  <meta http-equiv="refresh" content="3">-->
   
    
    
</head>
<body>
	
	<%
        User user = (User) session.getAttribute("session_user");
	List<MenuItem> menuItem=(List<MenuItem> )session.getAttribute("session_menuItem");
	
    %>
    <div class="navbar">
        <div class="logo">
            Tap~Foods
        </div>
        <div class="username">
            <% if (user != null) { %>
                Welcome <%= user.getUsername() %>
            <% } %>
        </div>
        <div class="links">
        
       		<a href="#"><i class="fas fa-search"></i> Search</a>
            <a href="loginHome.jsp"><i class="fas fa-search"></i> Restaurants</a>
            <a href="menuHome.jsp"><i class="fas fa-search"></i> Menus</a>
            <a href="#"><i class="fas fa-tags"></i> Offers</a>
            <a href="#"><i class="fas fa-question-circle"></i> Help</a>
            <% if (user != null) { %>
                <form action="logOut" method="get">
                	<button type="submit"><i class="fas fa-sign-out-alt"></i>Sign Out</button>
                </form>
            <% } else { %>
                <a href="registration.jsp"><i class="fas fa-user-plus"></i> Sign Up</a>
                <a href="login.jsp"><i class="fas fa-sign-in-alt"></i> Sign In</a>
            <% } %>
        </div>
    </div>>
    	

<%
    Map<Integer, CartItem> cartItems = (Map<Integer, CartItem>) session.getAttribute("session_cart");
    double total = 0;
    double cartTotal = 0;

    //System.out.println(cartItems);
%>

<%
		if(cartItems !=null)
		{
			
			for(Map.Entry<Integer, CartItem> item : cartItems.entrySet())
			{
				%><div class="flex-container2"><%
				CartItem cartItem = item.getValue();
				int itemId=item.getKey();
				int itemQuantity = item.getValue().getItemQuantity();  // Fix: Now using CartItem
				String itemName=cartItem.getItemName();
				double itemPrice = cartItem.getPrice();
				double itemTotal = itemQuantity * itemPrice;
				total += itemTotal;
				%>
				
	        <div class="flex-item2">
	        	<div class="name" ><%=itemName%></div>
	        </div>
	            <img src="ImageMenuServlet?id=<%= itemId %>&t=<%= System.currentTimeMillis() %>" alt="<%= itemName%>">
                <!-- <img src="https://via.placeholder.com/300x200" alt="Restaurant Image 1">  -->
	            <div class="restaurant-info">
		            <p><strong>Price:</strong> <%= String.format("%.2f",itemPrice) %></p>
		            <p><strong>Name:</strong> <%= cartItem.getItemName() %></p>
		            <p><strong>Quantity:</strong> <%= itemQuantity %></p>
            
	            <div class="links">
	            <form action="cart" method="post" >
	                 	<!--  <button class="quantity-button" onclick="decreaseQuantity(<%= itemId %>)">-</button>
	                	<button class="quantity-button" onclick="increaseQuantity(<%= itemId %>)">+</button> -->
	               		<input type="number" value="<%= itemQuantity %>" min="1" class="quantity-input" name="quantity">
	            	
	            		<input type="hidden" name="itemId" value="<%= itemId %>">
			            <button class="action-button update-button" onclick="updateItem(<%= itemId %>)" name="action" value="update">Update</button>
			            <button class="action-button remove-button" onclick="removeItem(<%= itemId %>)"  name="action" value="remove">Remove</button>
			            <button class="action-button amount-button" onclick="payAmount(<%= itemId %>)" >Amount Pay</button>
		            </form>
	        	</div>
	         </div> 
	        	
			
			<div class="total">Total: ₹ <%= String.format("%.2f", itemTotal) %></div>
			
				<% if (cartItems != null && !cartItems.isEmpty()&& user !=null) { %>
		        <div class="checkout">
		            <a href="checkOut.jsp"><button>Checkout</button></a>
		        </div>
				<% } 
				else
				{
					%>  
					<div class="checkout">
		            <a href="login.jsp"><button>Checkout</button></a>
		        	</div>
					
					<%
				}%>
			
			</div>
				
				<%
			}
		}
			%>
			
			
			

<div class="cart-box">
    <h2>Your Cart</h2>
    <div class="cart-items">
        <%
            if (cartItems != null && !cartItems.isEmpty()) {
                for (Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
                    CartItem cartItem = entry.getValue();
                   int itemId= entry.getKey();
                    int quantity = entry.getValue().getItemQuantity();  // Fix: Now using CartItem
                    double price = cartItem.getPrice();
                    double itemTotal = quantity * price;
                    cartTotal += itemTotal;
        %>
        <form action="cart" method="post" >
        <input type="hidden" name="itemId" value="<%= itemId %>">
	        <div class="cart-item">
	            <span><%= cartItem.getItemName() %> (x<%= quantity %>)</span>
	            <span> ₹ <%= String.format("%.2f", itemTotal) %></span>
	            <button class="action-button remove-button" onclick="removeItem(<%= itemId %>)"  name="action" value="remove">Remove</button>
	        </div>
        </form>
        <%
                }
            } else {
        %>
        <p>Your cart is empty.....</p>
        <%
            }
        %>
    </div>

    <div class="total">Total: ₹ <%= String.format("%.2f", cartTotal) %></div>
    
    <% if (cartItems != null && !cartItems.isEmpty() && user !=null) { %>
        <div class="checkout">
            <a href="checkOut.jsp"><button>Checkout</button></a>
        </div>
   		 <% } 
		else
		{
			%>  
			<div class="checkout">
            <a href="login.jsp"><button>Checkout</button></a>
        	</div>
			<%
		}%>
</div>

</body>
</html>


<style>

body {
    font-family: Arial, sans-serif;
    background-color: gray;
    color: white;
    margin: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    min-height: 100vh;
}

.navbar {
    background-color: silver;
    color:black;
    overflow: hidden;
    position: fixed;
    top: 0;
    width: 100%;
    height:60px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 20px;
    z-index: 1000;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.navbar .logo, .navbar .username {
    font-size: 24px;
    font-weight: bold;
    color: black;
}

.navbar .links {
    display: flex;
    align-items: center;
}

.navbar .links a {
    position: relative;
    display: inline-block;
    color: black;
}


.navbar .links a, .navbar .links button {
    padding: 14px 20px;
    font-size: 16px;
    
    margin: 0 5px;
    transition: background-color 0.3s ease;
    background-color: silver;
    border: none;
}

.navbar .links a,.navbar .links button{
    position: relative;
    text-decoration: none; /* Removes default underline */
    color: black;
    padding-bottom: 5px; /* Space for the underline */
}

.navbar .links a::after,.navbar .links button::after {
    content: "";
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
    height: 2px;
    background-color: red; /* Color of the underline */
    transform: scaleX(0);
    transition: transform 0.3s ease-in-out;
}

.navbar .links a:hover::after,.navbar .links button:hover:after {
    transform: scaleX(1); /* Expands the line on hover */
}


.name{
	font-size:25px;
	color:black;
	font:bold;
	margin-bottom: 5px;
}


.cart-box {
    width: 600px;
    padding: 30px;
    margin-top: 80px;
    background-color: silver;
    text-align: center;
    border-radius: 10px;
    color: black;
}

 h2 {
    margin-bottom: 20px;
    font-size: 36px;
}

  .cart-items {
      text-align: left;
      margin-bottom: 20px;
  }

.cart-item {
    display: flex;
    width:100%;
    height:20px;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 10px;
    padding-left: 10px;
    padding-right: 10px;
    padding-top:10px;
    padding-bottom:12px;
 	border: 3px solid black;
    border-radius: 50px;
    background: #ffffff;
    color: black;
}

.total {
    font-size: 20px;
    font-weight: bold;
    margin-top: 20px;
    margin-bottom: 20px;
}

.checkout button {
    padding: 10px 20px;
    border: none;
    background: teal;
    color: black;
    font-size: 18px;
    border-radius: 10px;
    cursor: pointer;
    transition: 0.3s;
}

.checkout button:hover {
    background: gray;
}
      
      

.flex-container2 {
   width: 400px;
   height:500px;
   padding: 30px;
   margin-top: 80px;
   background-color: silver;
   text-align: center;
   border-radius: 10px;
   color: black;
}
      
img {
    width: 100%;
    height: 200px;
    border-radius: 10px;
    border: 3px solid black;
}
     
.quantity-input {
    width: 50px;
    height:22px;
    text-align: center;
    margin: 0 5px;
    border: 3px solid teal;
    border-radius: 5px;
    padding: 5px;
    
}

.action-button {
    padding: 10px;
    margin-top: 3px;
    background-color: teal;
    color: black;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
.action-button:hover {
    background-color: gray;
    
}
        
   
</style>
















