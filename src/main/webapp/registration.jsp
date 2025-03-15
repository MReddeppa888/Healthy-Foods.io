<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration - page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
    body, h2, p, a {
        margin: 0;
        padding: 0;
        font-family: 'Arial', sans-serif;
        box-sizing: border-box;
    }

    body {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        background: #f2f2f2;
        flex-direction: column;
        align-items: center;
        background-color: #00203FFF;
        color: #ffffff;
        margin: 0;
        height: 100vh;
    }

    /* Navbar styling */
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
        color: navy;
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
        color: #00203FFF;
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

    /* Login Box styling */
    .login-box {
        width: 400px;
        padding: 30px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: #D6ED17FF;
        text-align: center;
        border-radius: 10px;
        color: navy;
    }

    .login-box h2 {
        margin-bottom: 30px;
        font-size: 40px;
        font-weight: bold;
    }

    .input-box {
        position: relative;
        margin-bottom: 40px;
        width: 70%;
        padding-left: 5%;
    }

    .input-box input {
        width: 100%;
        padding: 0px 20px 5px 20px; /* Adjusted padding to leave space for icon on the right */
        border-radius: 10px;
        font-size: 20px;
        color: navy;
    }

    .input-box label {
        position: absolute;
        top: 1px;
        left: 50px;
        transition: 0.5s;
        color: navy;
        font-size: 17px;
        border: 10px;
    }

    .input-box input:focus ~ label,
    .input-box input:valid ~ label {
        top: -25px;
        left: 9px;
        color: navy;
        font-weight: bold;
        background: transparent;
        padding: 0 5px;
    }

    .input-box .icon {
        position: absolute;
        right: -35px;
        
    }

    .submit button {
        width: 70%;
        padding: 10px;
        border: none;
        outline: none;
        background: navy;
        color: #fff;
        font-size: 18px;
        border-radius: 10px;
        cursor: pointer;
        transition: 0.3s;
    }

    .submit button:hover {
        background: red;
        color:#fff ;
    }

    .register-link p {
        margin-top: 20px;
        color: navy;
        font-weight: bold;
        font-size: 18px;
    }

    .register-link p a {
        color: red;
        text-decoration: none;
        font-weight: bold;
        text-decoration: underline;
    }

    .register-link p a:hover {
        color: #0a0108 ;
        text-decoration: underline;
    }

    
    
</style>
</head>
<body>
	
<section>
    <div class="login-box" >
        <form action="sendData" method="post">
            <h1>Registration Form</h1>
            <div class="input-box">
                <span class="icon"></span>
                <input type="text" name="fullname" required>
                <label>Full Name</label>
            </div>
            <div class="input-box">
                <span class="icon"></span>
                <input type="number" name="phonenumber" required>
                <label>phoneNo</label>
            </div>
            <div class="input-box">
                <span class="icon"></span>
                <input type="email" name="email" required>
                <label>Email</label>
            </div>
            <div class="input-box">
                <span class="icon"></span>
                <input type="password" name="password" required>
                <label>password</label>
            </div>
           <div class="input-box">
                <span class="icon"></span>
                <input type="text" name="address" required>
                <label>address</label>
            </div>
            <div class="submit"><button type="submit">sign up</button></div>
            <div class="register-link">
            	<p>Do you have an account? <a href="login.jsp">Sign in</a></p>
            </div>
        </form>
    </div>
</section>
</body>
</html>