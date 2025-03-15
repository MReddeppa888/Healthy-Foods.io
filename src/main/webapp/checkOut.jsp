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
    <title>CheckOut ~ page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!--  <meta http-equiv="refresh" content="3">-->
    <link rel="stylesheet" href="checkOut.css">
</head>
<body>
	
	<%
        User user = (User) session.getAttribute("session_user");
	List<MenuItem> menuItem=(List<MenuItem> )session.getAttribute("session_menuItem");
	
    %>
    
	<%
	    Map<Integer, CartItem> cartItems = (Map<Integer, CartItem>) session.getAttribute("session_cart");
	    double total = 0;
	    double cartTotal = 0;
	    CartItem cartItem=null;
	    //System.out.println(cartItems);
	%>
<div class="cart-box">
    <h2>CheckOut</h2>
    <div class="cart-items">
        <%
            if (cartItems != null && !cartItems.isEmpty()) {
                for (Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
                    cartItem = entry.getValue();
                    int quantity = cartItem.getItemQuantity();
                    double price = cartItem.getPrice();
                    double itemTotal = quantity * price;
                    cartTotal += itemTotal;
        %>
        
        <div class="cart-item">
            <p><strong style="color: red;">Item:</strong> <%= cartItem.getItemName() %></p>
            <p><strong style="color: red;">Price:</strong> ₹ <%= String.format("%.2f", price) %></p>
            <p><strong style="color: red;">Price:</strong> ₹ <%= String.format("%.2f", price*quantity) %></p>
            <p><strong>Quantity:</strong></p>
            <form action="cart" method="post">
                <input type="number" value="<%= quantity %>" min="1" class="quantity-input" name="quantity">
                <input type="hidden" name="itemId" value="<%= cartItem.getItemId() %>">
                <button class="action-button"  name="action" value="CheckOutUpdate">Update</button>
            </form>
        </div>
		<%
                }
            } else {
        %>
        <p>Your cart is empty.....</p>
        <%
            }
        %>
    </div>
    
    <form action="placeOrder" method="post">
    <input type="hidden" name="itemId" value="<%= cartItem.getItemId()%>">
    <input type="hidden" name="cartTotal" value="<%= cartTotal%>">
        <label for="address"><strong>Delivery Address:</strong></label>
        <textarea id="address" name="address" required></textarea>

        <label for="payment"><strong>Payment Method:</strong></label>
        <select id="payment" name="paymentMethod">
            <option value="credit">Credit Card</option>
            <option value="debit">Debit Card</option>
            <option value="cash">Cash on Delivery</option>
        </select>
        
        <div class="total">Total: ₹ <%= String.format("%.2f", cartTotal) %></div>
	
		
    
    
     <% if (cartItems != null && !cartItems.isEmpty()) { %>
            <div class="placeOrder">
                <button>Place Order</button>
            </div>
        <% } %>
    </form>
</div>


</body>
</html>

<style>
	
	@charset "UTF-8";
/* General Styles */
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

.cart-box {
    width: 45%;
    padding: 30px;
    margin-top: 80px;
    background-color: silver;
    text-align: center;
    border-radius: 10px;
    color: black;
}

.cart-box h2 {
    margin-bottom: 20px;
    font-size: 36px;
}

.cart-items {
    text-align: left;
    margin-bottom: 20px;
}

.cart-item {
	display:flex;
	width:100%;
	height:25px;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 10px;
    padding-left: 10px;
    padding-right: 10px;
    padding-top:10px;
    padding-bottom:10px;
    border: 3px solid black;
    border-radius: 50px;
    background: #ffffff;
    color: black;
}       
.action-button {
    padding: 5px;
    margin-top: 3px;
    margin-bottom: 3px;
    background-color: gray;
    color: black;
    border: none;
    border: 3px solid teal;
    border-radius: 5px;
    cursor: pointer;
}
.action-button:hover {
    background-color: teal;
    
}



select{
	
	border: 3px solid black;
	width:100px;
	height:30px;
	
}
textarea{
	
	border: 3px solid black;
	width:100px;
	height:30px;
	
}
         
.total {
    font-size: 30px;
    font-weight: bold;
    margin-top: 20px;
    margin-bottom: 20px;
    font-family: serif;
}
         
.placeOrder button {
    padding: 10px 20px;
    border: none;
    background: gray;
    color: black;
    font-size: 18px;
    border-radius: 10px;
    cursor: pointer;
    transition: 0.3s;
    border: 3px solid teal;
}

.placeOrder button:hover {
    background: teal;
}        


 .quantity-input {
    width: 50px;
    text-align: center;
    margin: 0 5px;
    border-radius: 5px;
    padding: 5px;
    color: black;
    background: gray;
    border: 3px solid teal;
}        
         
         
         
         
         
         
         
         
         
     

</style>



