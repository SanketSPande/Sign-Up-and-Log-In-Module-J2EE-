<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Successful !!</title>
<style>
.button-container {
    text-align: center; 
}

.button1 {
    width: 200px;
    height: 30px;
    color: rgb(239, 94, 94);
    background-color: white;
    border: 2px solid rgb(239, 94, 94);
    border-radius: 5px;
    font-size: 16px; 
    transition: background-color 0.3s, color 0.3s, transform 0.3s, font-size 0.3s;
}

.button1:hover {
    background-color: rgb(239, 94, 94);
    color: white;
    transform: scale(1.05);
    font-size: 18px; 
}

h2 {
    text-align: center; 
}
</style>
</head>
<body>
<h2>Registration Successful !!</h2>
<div class="button-container">
    <input type="button" class="button1" value="Click to Sign in" onclick="goback()">
</div>

<script>
function goback(){
    document.location.href = "http://localhost:8080/Signup-Signin_Feature/Signin.jsp";
}
</script>

</body>
</html>
