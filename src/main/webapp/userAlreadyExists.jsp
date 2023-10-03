<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Already Exists</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        text-align: center;
        margin: 0;
        padding: 0;
    }

    .container {
        max-width: 500px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        margin-top: 50px;
    }

    h2 {
        font-size: 24px;
        color: #333;
        margin-bottom: 20px;
    }

    p {
        font-size: 18px;
        color: #333;
        margin-bottom: 20px;
    }

    .button-container {
        margin-top: 20px;
    }

    .button1 {
        width: 100%;
        height: 50px;
        background-color: #007bff;
        color: #fff;
        font-size: 18px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
    }

    .button1:hover {
        background-color: #0056b3;
        transform: scale(1.05);
    }
</style>
<script>
    function signUp() {
        document.location.href = "http://localhost:8080/Signup-Signin_Feature/Signup.jsp";
    }
</script>
</head>
<body>
    <div class="container">
        <h2>A user with this username already exists!</h2>
        <p>Please try a different username.</p>
        <div class="button-container">
            <input type="button" class="button1" value="Go Back" onclick="signUp()">
        </div>
    </div>
</body>
</html>
