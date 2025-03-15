<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP with External JavaScript</title>
    <script src="js/script.js"></script> <!-- Make sure the path is correct -->
    <style >
    
    	.navbar .links a {
    position: relative;
    text-decoration: none; /* Removes default underline */
    color: navy;
    padding-bottom: 5px; /* Space for the underline */
}

.navbar .links a::after {
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

.navbar .links a:hover::after {
    transform: scaleX(1); /* Expands the line on hover */
}
    
    </style>
</head>
<body>

   <div class="navbar">
    <div class="links">
        <a href="#">Search</a>
        <a href="loginHome.jsp">Restaurants</a>
        <a href="menuHome.jsp">Menus</a>
        <a href="#">Offers</a>
        <a href="#">Help</a>
    </div>
</div>
</body>
</html>






















