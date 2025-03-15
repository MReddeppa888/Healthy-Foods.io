<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update - page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
    

    body {
        background-color: #00203FFF;
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
    
    
</style>
</head>
<body>
	
<section>
    <div class="login-box" >
        <form action="registration.jsp" method="post">
            <h1>Update Failure</h1>
            
            <div class="register-link">
                    <p>You update again <a href="registration.jsp">Click here</a></p>
             </div>
        </form>
    </div>
</section>
</body>
</html>