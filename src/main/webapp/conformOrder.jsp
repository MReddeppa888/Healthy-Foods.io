<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conform ~ Order ~ page</title>
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
        <form action="PlaceOrder" method="post">
            <h1>Conform Order</h1>
            
            <div class="submit"><button type="submit">Conform</button></div>
        </form>
    </div>
</section>
</body>
</html>