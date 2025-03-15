<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    

    <div class="content-spacing"></div> <!-- Space to avoid content overlap with fixed navbar -->

    <section>
        <div class="login-box">
            <form action="login" method="post">
                <h1>Login</h1>
                <div class="input-box">
                    <input type="email" required name="email">
                    <span class="icon"><i class="fas fa-envelope"></i></span>
                    <label>Email</label>
                </div>
                <div class="input-box">
                    <input type="password" required name="password">
                    <span class="icon"><i class="fas fa-lock"></i></span>
                    <label>Password</label>
                </div>
                <div class="submit"><button type="submit">Sign In</button></div>
                <div class="register-link">
                    <p>Don't have an account? <a href="registration.jsp">Sign Up</a></p>
                </div>
            </form>
        </div>
    </section>
</body>
</html>

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
        top: 10px;
        right: -35px; /* Moved icon to the right */
        font-size: 16px;
        
    }

    .submit button {
        width: 30%;
        padding: 10px;
        border: none;
        outline: none;
        background: #00203FFF;
        color: white;
        font-size: 18px;
        border-radius: 10px;
        cursor: pointer;
        transition: 0.3s;
    }

    .submit button:hover {
        background: red;
        color:navy ;
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