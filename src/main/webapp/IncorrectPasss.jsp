<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
response.setHeader("Pragma","no-cache");//Http 1.0
response.setDateHeader ("Expires", 0);//Proxies

if(session.getAttribute("uname")==null)
	response.sendRedirect("Signin.jsp");
else if(session.getAttribute("pass")==null )
	response.sendRedirect("home.jsp");
%>
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