<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
response.setHeader("Pragma","no-cache");//Http 1.0
response.setDateHeader ("Expires", 0);//Proxies

if(session.getAttribute("uname")!=null)
	response.sendRedirect("http://localhost:8080/Signup-Signin_Feature/logout");
%>
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
            width: 300px;
            height: 25px;
            font-size: larger;
        }

        .button {
            width: 85px;
            height: 30px;
            background-color: rgb(183, 183, 241);
            font-size: larger;
            cursor: pointer; /* Add cursor pointer */
            transition: background-color 0.3s, transform 0.3s;
        }

        .button:hover {
            background-color: rgb(143, 143, 221); /* Change background color on hover */
            transform: scale(1.05); /* Scale the button on hover */
        }
    </style>
   
	<script>
		function reload(){
			document.location.href = "http://localhost:8080/Signup-Signin_Feature/Signin.jsp";
		}	
		function validate(){
			
			var username = document.getElementById("usrnme");	
			var password = document.getElementById("pwd");		
			
			if(username.value.trim() ==""){
				alert("No blank values allowed for username");
				return false;			
			}
			if(password.value.trim() ==""){
				alert("No blank values allowed for password");
				return false;			
			}
			
			else{
				true;
			}
		}
	</script>

</head>
<body>
 <header id="head">
        <h1>Login Form</h1>
    </header>

    <p style="font-size: larger;">(CARE: Username and password are case sensitive.)</p>

    <form onsubmit="return validate()" action="Signin" method ="post">

        <h3><label for="username" style="font-size: larger;">Username*</label></h3>
        <input type="text" class="textbox" name="username" id="usrnme" required><br>

        <h3><label for="password" style="font-size: larger;">Password*</label></h3>
        <input type="password" class="textbox" name="password" id="pwd" required><br><br>

        <input type="submit" class="button" value="Login">
        
    	<input type="button" class="button" value="Reset" onclick="reload()">
    

    </form><br>
    

    <a  style="font-size: larger;" href="http://localhost:8080/Signup-Signin_Feature/Signup.jsp">New User? Register here</a>
</body>
</html>
