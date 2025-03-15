<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tapfoods.models.*" %>
<%@ page import="com.tapfoods.DAOImpl.*" %>
<%@ page import="com.tapfoods.DAO.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tap~Food~Home~page</title>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
     
</head>
<body>
    <%
        User user = (User) session.getAttribute("session_user");
    	user=null;
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
            <a href="login.jsp"><i class="fas fa-search"></i> Search</a>
            <a href="login.jsp"><i class="fas fa-shopping-cart"></i> Cart</a>
            <a href="login.jsp"><i class="fas fa-tags"></i> Offers</a>
            <a href="login.jsp"><i class="fas fa-question-circle"></i> Help</a>
            <% if (user != null) { %>
                <a href="#"><i class="fas fa-sign-out-alt"></i> Sign Out</a>
            <% } else { %>
                <a href="registration.jsp"><i class="fas fa-user-plus"></i> Sign Up</a>
                <a href="login.jsp"><i class="fas fa-sign-in-alt"></i> Sign In</a>
            <% } %>
        </div>
    </div>

    <div style="margin-top: 60px;"></div> <!-- Space to avoid content overlap with fixed navbar -->

    <section class="top">
        <h1>Welcome to Tap~Foods</h1>
        <p>Delivering delicious meals to your doorstep.</p>
        
    </section>
	<%
		List<Restaurant> restaurantList=(List<Restaurant> )session.getAttribute("session_restaurant");
		if(restaurantList !=null)
		{
			%><div class="flex-container2"><%
			for(Restaurant restaurant:restaurantList)
			{
				%>
				
        <div class="flex-item2">
            <!--  <img src="https://via.placeholder.com/300x200" alt="Restaurant Image 1">-->
            <img src="food.jpg" alt="Restaurant Image 1">
            
            <div class="restaurant-info">
                <div class="rating">
                    <i class="fas fa-star"></i> <%=restaurant.getRatings()%>
                </div>
                <div class="name"><%=restaurant.getRestaurantname()%></div>
                <p><%=restaurant.getDeliveryTime()%> </p>
                <a href="login.jsp"><button class="menu-button" >View Menu</button></a>
            </div>
        
			</div>
		
				
				
				<%
			}
			%></div><%
		}
	%>
    

        

    <!-- Footer -->
    <footer class="footer">
        <div class="footer-section">
            <h2>About Us</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        </div>
        <div class="footer-section">
            <h2>Contact</h2>
            <p>Email: reddyreddeppa888@gmail.com<br>Phone: +19 99495 74802</p>
        </div>
        <div class="footer-section">
            <h2>Careers</h2>
            <p>Join our team and help us deliver the best food experience. Check out our <a href="#">job openings</a>.</p>
        </div>
        <div class="footer-section">
            <h2>Follow Us</h2>
            <p>
                <a href="#"><i class="fab fa-facebook"></i> Facebook</a><br>
                <a href="#"><i class="fab fa-twitter"></i> Twitter</a><br>
                <a href="#"><i class="fab fa-instagram"></i> Instagram</a>
            </p>
        </div>
    </footer>

</body>
</html>

<style >
     body {
            font-family: Arial, sans-serif;
            background-color: #00203FFF;
            color: #ffffff;
            margin: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
        }

        .navbar {
            background-color: #D6ED17FF;
            overflow: hidden;
            position: fixed;
            top: 0;
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 20px;
            z-index: 1000;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        .navbar .logo {
            font-size: 24px;
            font-weight: bold;
            color: navy;
        }

        .navbar .links {
            display: flex;
            align-items: center;
        }

        .navbar .links a {
            color: navy;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            font-size: 16px;
            border-radius: 5px;
            margin: 0 5px;
            transition: background-color 0.3s ease;
        }

        .navbar .links a:hover {
            background-color: #8c069e;
            color: #D6ED17FF;
        }

        .navbar .username {
            margin-right: auto;
            margin-left: 20px;
            font-size: 24px;
            font-weight: bold;
            padding-left: 20%;
            color: navy;
        }

        .navbar i {
            margin-right: 8px;
        }

        .top {
           /* background-color: #f30faa; -->*/
           background-image:url("6.jpg");
            height: 600px;
            width: 100%;
           
            text-align: center;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            color: red;
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
		    flex-wrap: wrap;
		    justify-content: space-around;
		    width: 80%;
		    margin-top: 20px; /* Reduced top margin */
		    padding-bottom: 2%; /* Reduced bottom padding */
		}


		    .flex-item2 {
		    background-color: #D6ED17FF;
		    color: #00203FFF;
		    border-radius: 10px;
		    width: 23%; /* Slightly reduced width to create more space between boxes */
		    margin-bottom: 15px; /* Reduced bottom margin */
		    padding: 8px; /* Reduced padding */
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
            background-color: #00203FFF;
            color: #D6ED17FF;
            padding: 5px 10px;
            border-radius: 20px;
            margin-bottom: 10px;
            font-size: 14px;
        }

        .flex-item2 .restaurant-info .rating i {
            margin-right: 5px;
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
            background-color: navy;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .flex-item2 .restaurant-info .menu-button:hover {
            background-color: red;
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

        .flex-item {
            background-color: #D6ED17FF;
            color: #00203FFF;
            text-align: top;
            align-content: flex-start;
            border-radius: 10px;
            width: 24%;
            aspect-ratio: 1 / 0.8;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .footer {
            background-color: #D6ED17FF;
            width: 100%;
            padding: 20px 0;
            display: flex;
            justify-content: space-around;
            align-items: flex-start;
            flex-wrap: wrap;
            color: navy;
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
            color: #8c069e;
        }
    </style> 








