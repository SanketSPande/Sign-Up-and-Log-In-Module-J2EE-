<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function goback(){
	document.location.href = "http://localhost:8080/Signup-Signin_Feature/home.jsp";
	}	
</script>

<style>
.button1 {
            width: 300px;
            height: 70px;
            color: rgb(239, 94, 94);            
            position: absolute;
            left: 600px;
			font-size: 24px;
        }
h1 {
    text-align: center;
    font-size: 30px; /* Adjust the font size as desired */
    color: rgb(0, 0, 0); /* Set the text color */
}
</style>
</head>
<body>
<h1>Incorrect Password</h1>
<input type="button" class="button1" value ="Go back" onclick="goback()"> 
</body>
</html>