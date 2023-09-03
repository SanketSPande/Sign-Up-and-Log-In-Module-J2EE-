<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.button {
            background-color: rgb(183, 183, 241);
        }
</style>
<title>Insert title here</title>
</head>
<body>

<h2>To make changes in your profile, enter your password*</h2><br>
<form action="/PasswordValidation" method="post">
<label for="name">Password</label>
<input type="text" name ="password" placeholder="Enter Password" class="textbox">
<input type="submit" class="button" value="Your Profile" >
</form>
</body>
</html>