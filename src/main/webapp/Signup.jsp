<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        text-align: center;
        margin: 0;
        padding: 0;
    }

    #h {
        background-color: #007bff;
        width: 100%;
        height: 70px;
        display: flex;
        justify-content: center;
        align-items: center;
        color: white;
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

    small {
        font-size: 18px;
        color: coral;
    }

    .textbox {
        width: 100%;
        height: 30px;
        font-size: 18px;
        margin-bottom: 15px;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    .button-container {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-top: 20px;
    }

    .button {
        width: 48%;
        height: 50px;
        background-color: #007bff;
        color: #fff;
        font-size: 18px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.2s;
    }

    .button:hover {
        background-color: #0056b3;
        transform: scale(1.05);
    }

    label {
        font-weight: bold;
    }
</style>
<script>
    function reload() {
        document.location.href = "http://localhost:8080/Signup-Signin_Feature/Signup.jsp";
    }

    function validate() {
        var username = document.getElementById("usrnme");
        var password = document.getElementById("password");
        var name = document.getElementById("nme");
        var contact = document.getElementById("cnct");

        if (username.value.trim() == "") {
            alert("No blank values allowed for username");
            return false;
        }
        if (password.value.trim() == "") {
            alert("No blank values allowed for password");
            return false;
        }
        if (name.value.trim() == "") {
            alert("No blank values allowed for name");
            return false;
        }
        if (contact.value.trim() == "") {
            alert("No blank values allowed for contact");
            return false;
        }

        return true;
    }
</script>

</head>
<body>

<header id="h">
    <h3>Signup Form</h3>
</header>

<div class="container">
    <h2>User-Driven Registration - New User</h2>
    <small><em>Mandatory fields are marked with an asterisk (*)</em></small><br><br>

    <form onsubmit="return validate()" action="Signup" method="post">

        <label for="username">Username*</label><br>
        <input type="text" class="textbox" name="username" id="usrnme" required><br>

        <label for="password">Password*</label><br>
        <input type="password" class="textbox" name="pwd" id="password" required><br>

        <label for="name">Name*</label><br>
        <input type="text" class="textbox" name="name" id="nme" required><br>

        <label for="contact">Contact*</label><br>
        <input type="text" class="textbox" name="contact" id="cnct" required><br>

        <div class="button-container">
            <input type="submit" class="button" value="Signup">
            <input type="button" class="button" value="Reset" onclick="reload()">
        </div>
    </form>
</div>
</body>
</html>
