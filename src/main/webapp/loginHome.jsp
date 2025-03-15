<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tapfoods.models.*, com.tapfoods.DAOImpl.*, com.tapfoods.DAO.*, java.util.List" %>
<%@ page import="java.io.*, java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tap~Food~Restaurants</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!-- <link rel="stylesheet" href="loginHome.css">  --><!-- External CSS for better maintainability -->
	
</head>
<body>
    <% User user = (User) session.getAttribute("session_user"); %>
    <div class="navbar">
        <div class="logo">Tap~Foods</div>
        <div class="username"><% if (user != null) { %> Welcome <%= user.getUsername() %> <% } %></div>
        <div class="links">
            <a href="#"><i class="fas fa-search"></i> Search</a>
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

     <!-- Avoid content overlap with navbar -->
    <!-- <div style="margin-top: 60px;"></div> -->
    
    <section class="top">
        <h1>Welcome to Healthy  ~ Foods</h1>
        <!--  <p>Savor the Goodness of Nature </p>
        	  <p>Eat Fresh, Stay Healthy</p>
        -->
        <h3>Order Healthy , Eat Happy</h3>
        <p>Delivering delicious meals to your doorstep....</p>
  <!--  <input type="text" placeholder="Search for restaurants or dishes...">  -->
    </section>
    
    <% List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("session_restaurant"); %>
    <% if (restaurantList != null) { %>
        <div class="flex-container2">
            <% for (Restaurant restaurant : restaurantList) { %>
                
                
                <div class="flex-item2">
					<img src="ImageServlet?id=<%= restaurant.getRestaurantId() %>&t=<%= System.currentTimeMillis() %>" alt="<%= restaurant.getRestaurantname() %>">
                    <div class="restaurant-info">
                        <div class="rating"><i class="fas fa-star"></i> <%= restaurant.getRatings() %></div>
                        <div class="name"><%= restaurant.getRestaurantname() %><%= restaurant.getRestaurantId() %></div>
                        <p><%= restaurant.getDeliveryTime() %></p>
                        <a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>"><button class="menu-button">View Menu</button></a>
                    </div>
                </div>
            <% } %>
        </div>
    <% } %>

    <footer class="footer">
        <div class="footer-section">
            <h2>About Us</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        </div>
        <div class="footer-section">
            <h2>Contact</h2>
            <p>Email: reddyreddeppa888@gmail.com<br>Phone: +19 99495 74802</p>
        </div>
        <div class="footer-section">
            <h2>Careers</h2>
            <p>Join our team! <a href="#">Job openings</a></p>
        </div>
        <div class="footer-section">
            <h2>Follow Us</h2>
            <p>
                <a href="https://www.facebook.com/reddy.m.9028194"><i class="fab fa-facebook"></i> Facebook</a><br>
                <a href="https://www.instagram.com/lucky_boy._008/?hl=en"><i class="fab fa-instagram"></i> Instagram</a><br>
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
    color: black;
    text-align: center;
    padding: 14px 20px;
    text-decoration: none;
    font-size: 16px;
    border-radius: 7px;
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
	background-color: teal ;  
    height: 350px;
    width: 100%;
    padding-top: 5%;
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
    width: 40%;
    border-radius: 5px;
    border: none;
    outline: none;
    margin-top: 10px;
}

.flex-container2 {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    width: 80%;
    margin-top: 20px;
    padding-bottom: 2%;
}

.flex-item2 {
    background-color: silver;
    color: black;
    border-radius: 10px;
    width: 23%;
    margin-bottom: 15px;
    padding: 8px;
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
    background-color: #CCCCCC;
    display: block;
}

.restaurant-info {
    padding: 10px;
    text-align: center;
}

.restaurant-info .rating {
    
    align-items: center;
    justify-content: center;
    background-color: gray;
    color: black;
    padding: 5px 10px;
    border-radius: 20px;
    margin-bottom: 10px;
    font-size: 14px;
}



.restaurant-info .name {
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 5px;
}

.restaurant-info p {
    font-size: 14px;
    margin-bottom: 15px;
}

.menu-button {
    padding: 10px;
    background-color: teal;
    color: black;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease;
}

.menu-button:hover {
    background-color: gray;
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

.footer .footer-section p, .footer .footer-section a {
    font-size: 14px;
    color: #00203FFF;
    text-decoration: none;
    transition: color 0.3s ease;
}

.footer .footer-section a:hover {
    color: teal;
}
	
	
</style>



















