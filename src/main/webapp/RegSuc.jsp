<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function goback(){
	document.location.href = "http://localhost:8080/Signup-Signin_Feature/Signin.jsp";
	}	
</script>

<style>
.button1 {
            width: 200px;
            height: 30px;
            color: rgb(239, 94, 94);            
            position: absolute;
            left: 600px;

        }
</style>
<body>
<h2>Registration Successful !</h2>
<input type="button" class="button1" value ="Click to Sign in" onclick="goback()">
</body>
</html>