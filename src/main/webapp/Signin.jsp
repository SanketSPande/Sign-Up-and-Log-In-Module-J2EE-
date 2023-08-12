<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
<style>
        #head {
            background-color: rgb(105, 105, 194);
            width: 100%;
            height: 70px;
        }

        .textbox {
            width: 500px;
        }

        .button {
            background-color: rgb(183, 183, 241);
        }
    </style>
</head>
<body>
 <header id="head">
        <h3>Login Form</h3>
    </header>

    <p>(CARE: Username and password are case sensitive.)</p>

    <form action="Signin" method ="post">

        <label for="username">Username*</label><br>
        <input type="text" class="textbox" name="username" required><br><br>

        <label for="password">Password*</label><br>
        <input type="password" class="textbox" name="password" required><br><br>

        <input type="submit" class="button" value="Login">
        <input type="submit" class="button" value="Reset">

    </form><br>

    <a href="http://localhost:8080/Signup-Signin_Feature/Signup.jsp">New User? Register here</a>
</body>
</html>