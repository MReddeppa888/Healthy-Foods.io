<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tapfoods.models.*, com.tapfoods.DAOImpl.*, com.tapfoods.DAO.*, java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tap~Foods~Menus~Items</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="menuHome.css">
    <!--  <meta http-equiv="refresh" content="3">-->
</head>
<body>
    <%
        User user = (User) session.getAttribute("session_user");
        List<MenuItem> menuItem = (List<MenuItem>) session.getAttribute("session_menuItem");
    %>
    <div class="navbar">
        <div class="logo">Tap~Foods</div>
        <div class="username">
            <% if (user != null) { %> Welcome <%= user.getUsername() %> <% } %>
        </div>
        <div class="links">
            <a href="#"><i class="fas fa-search"></i> Search</a>
            <a href="loginHome.jsp"><i class="fas fa-search"></i> Restaurants</a>
            <a href="cart.jsp"><i class="fas fa-shopping-cart"></i> Cart</a>
            <a href="#"><i class="fas fa-tags"></i> Offers</a>
            <a href="#"><i class="fas fa-question-circle"></i> Help</a>
            <% if (user != null) { %>
                <form action="logOut" method="get"><button type="submit"><i class="fas fa-sign-out-alt"></i>Sign Out</button></form>
            <% } else { %>
                <a href="registration.jsp"><i class="fas fa-user-plus"></i> Sign Up</a>
                <a href="login.jsp"><i class="fas fa-sign-in-alt"></i> Sign In</a>
            <% } %>
        </div>
    </div>

   <div style="margin-top: 60px;"></div> 

     <section class="top">
	        <h1>Organic Healthy ~ Foods</h1>
	        <h3>Eat Fresh, Stay Healthy</h3>
	        <p>Your Journey to Wholesome Eating Starts Here...!</p>
    	</section>
	  <!--      <input type="text" placeholder="Search for restaurants or dishes...">
    -->

    <%
        if (menuItem != null) {
    %>
    <div class="flex-container2">
        <% for (MenuItem menu : menuItem) { %>
            <div class="flex-item2">
                <img src="ImageMenuServlet?id=<%= menu.getMenuId() %>&t=<%= System.currentTimeMillis() %>" alt="<%= menu.getItemName()%>">
                <div class="restaurant-info">
                    <div class="rating"> Price: <%=  String.format("%.2f",menu.getPrice()) %></div>
                    <div class="name"><%= menu.getItemName() %><%= menu.getMenuId() %></div>
                    <p><%= menu.getDescription() %></p>
                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="add">
                        <button class="menu-button" name="itemId" value="<%= menu.getMenuId() %>">Add to Cart</button>
                        <input type="number" value="1" min="1" class="quantity-input" name="quantity">
                    </form>
                </div>
            </div>
        <% } %>
    </div>
    <% } else { %>
        <p>No Menu Items available......</p>
    <% } %>

    <footer class="footer">
        <div class="footer-section">
            <h2>About Us</h2>
            <p>We deliver the best food experience.</p>
        </div>
        <div class="footer-section">
            <h2>Contact</h2>
            <p>Email: reddyreddeppa888@gmail.com<br>Phone: +19 99495 74802</p>
        </div>
        <div class="footer-section">
            <h2>Careers</h2>
            <p>Join our team! <a href="#">Job openings</a>.</p>
        </div>
        <div class="footer-section">
            <h2>Follow Us</h2>
            <p>
                <a href="https://www.facebook.com/reddy.m.9028194"><i class="fab fa-facebook"></i> Facebook</a><br>
                <a href="https://www.instagram.com/lucky_boy._008/?hl=en"><i class="fab fa-instagram"></i> Instagram</a>
            	<a href="#"><i class="fab fa-twitter"></i> Twitter</a>
            </p>
        </div>
    </footer>

    
</body>
</html>
<style>

	body {
    font-family: Arial, sans-serif;
    background-color: gray;
    color: #ffffff;
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

.top {

	background-color:teal; 
	
    height: 300px;
    width: 100%;
    text-align: center;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    color: silver;
    font-size: x-large;
    
   
}

.top input[type="text"] {
    padding: 10px;
    width: 60%;
    border-radius: 5px;
    border: none;
    outline: none;
    margin-top: 10px;
}

.top input[type="text"]::placeholder {
    color: #555;
}

.bottom {
    background-color: #f30faa;
    width: 100%;
    padding-bottom: 15%;
}

.flex-container2 {
   display: flex;
   color:black;
   flex-wrap: wrap;
   justify-content: space-around;
   width: 80%;
   margin-top: 20px; /* Reduced top margin */
   padding-bottom: 2%; /* Reduced bottom padding */
}


.flex-item2 {
	background-color: silver;
	color: black;
	border-radius: 10px;
	width: 23%; /* Slightly reduced width to create more space between boxes */
	margin-bottom: 15px; /* Reduced bottom margin */
	padding: 8px; /* Reduced padding */
	transition: transform 0.7s ease; /* Smooth transition */
}

.flex-item2:hover {
    transform: translateY(-5px); /* Move up by 25px */
}


.flex-item2 img {
    width: 100%;
    height: 200px;
    object-fit: cover;
    border-radius: 10px;
    background-color: #CCCCCC; /* Gray background */
 	display: block; /* Ensures proper spacing */
}

.flex-item2 .restaurant-info {
    padding: 10px;
    text-align: center;
}

.flex-item2 .restaurant-info .rating {
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: gray;
    color: black;
    padding: 5px 10px;
    border-radius: 20px;
    margin-bottom: 10px;
    font: bold;
}



.flex-item2 .restaurant-info .name {
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 5px;
}

.flex-item2 .restaurant-info p {
    font-size: 14px;
    margin-bottom: 15px;
}

.flex-item2 .restaurant-info .menu-button {
    padding: 10px;
    background-color: teal;
    color: black;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease;
}

.flex-item2 .restaurant-info .menu-button:hover {
    background-color: gray;
}

.flex-container {
    display: flex;
    justify-content: space-around;
    width: 80%;
    margin-top: 40px;
    aspect-ratio: 1 / 0.3;
    padding-left: 10%;
    padding-right: 0%;
    padding-bottom: 0%;
}



.footer {
    background-color: silver;
    width: 100%;
    padding: 20px 0;
    display: flex;
    justify-content: space-around;
    align-items: flex-start;
    flex-wrap: wrap;
    color: black;
    margin-top: auto;
}

.footer .footer-section {
    width: 22%;
    margin-bottom: 20px;
}

.footer .footer-section h2 {
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 10px;
    color: #00203FFF;
}

.footer .footer-section p {
    font-size: 14px;
    color: #00203FFF;
}

.footer .footer-section a {
    color: #00203FFF;
    text-decoration: none;
    transition: color 0.3s ease;
}

.footer .footer-section a:hover {
    color: red;
}
        
.quantity-input {
    width: 50px;
    height:20px;
    text-align: center;
    margin: 0 5px;
    border: 3px solid teal;
    border-radius: 5px;
    padding: 5px;
}

.quantity-button {
    padding: 5px 10px;
    background-color: navy;
    color: white;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    transition: background-color 0.3s ease;
}

.quantity-button:hover {
    background-color: red;
}

.quantity-container {
    display: flex;
    align-items: center;
}



</style>