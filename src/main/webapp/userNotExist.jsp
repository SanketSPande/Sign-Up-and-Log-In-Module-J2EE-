<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function signUp(){
	document.location.href = "http://localhost:8080/Signup-Signin_Feature/Signup.jsp";
	}	
function signIn(){
	document.location.href = "http://localhost:8080/Signup-Signin_Feature/Signin.jsp";
	}
</script>

<style>
.button1 {
            width: 300px;
            height: 30px;
            color: rgb(239, 94, 94);  
            font-size: larger;          
        }
.alignment{
text-align: center;
}
</style>
</head>
<body>
<div class="alignment">
<h2>Invalid Username !</h2><br>

<p style="font-size: larger;">There could be 2 possible reasons</p>

<h3 style="font-size: larger;">1.Entered wrong Username</h3>
<input type="button" class="button1" value ="Go back to Sign In" onclick="signIn()"><br>

<h3 style="font-size: larger;">2.User does not exists please Sign Up</h3>
<input type="button" class="button1" value ="Sign Up" onclick="signUp()"> 
</div>
</body>
</html>