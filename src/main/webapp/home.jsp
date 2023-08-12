<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css"> 
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
response.setHeader("Pragma","no-cache");//Http 1.0
response.setDateHeader ("Expires", 0);//Proxies

if(session.getAttribute("uname")==null)
response.sendRedirect("Signin.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--  
<meta http-equiv="Cache-Control" content=" no-store">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
-->
<title>Home Page</title>
<style>
        header {
            background-color: antiquewhite;
            height: 100px;
        }

        .button1 {
            width: 200px;
            height: 70px;
            color: rgb(239, 94, 94);
            font-size: larger;
            position: absolute;
            left: 500px;

        }

        .button2 {
            width: 200px;
            height: 70px;
            color: rgb(239, 94, 94);
            font-size: larger;
            position: absolute;
            left: 850px;

        }
         .button3 {
            width: 100px;
            height: 40px;
            background-color: white;         
            position: absolute;
            left: 1420px;

        }
         .red-color {
            width: 70px;
            height: 70px;
            color:red;
    	}
    </style>
    <script>
        function Datalist() {
        	
            document.location.href = "http://localhost:8080/Signup-Signin_Feature/lServlet";
        }

        function update() {
            document.location.href = "update.jsp";
        }
        
		function Logout() {
        	
            document.location.href = "http://localhost:8080/Signup-Signin_Feature/logout";
        }

    </script>
</head>
<body>


<header>

<button type="submit" class ="button3" onclick ="Logout()" ><span class="bi bi-power red-color">  Logout</span></button>
        <h1>Welcome to home page</h1>
        
</header>
    <h1 style="text-align: center;">Make a Choice</h1><br><br>

    <form action="">

        <input type="button" class="button1" value="Your Profile" onclick="Datalist()">
        <input type="button" class="button2" value="Update Profile" onclick="update()">

    </form>


</body>
</html>