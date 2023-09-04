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
<h2>A user with this username already exists !</h2>

<p style="font-size: larger;">Please try a different username</p>

<input type="button" class="button1" value ="Go Back" onclick="signUp()"> 
</div>
</body>
</html>