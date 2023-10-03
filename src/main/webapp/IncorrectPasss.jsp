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
    <title>Incorrect Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin-top: 50px;
        }

        h1 {
            font-size: 30px;
            color: #333;
        }

        .button-container {
            margin-top: 20px;
        }

        .button1 {
            width: 100%;
            height: 50px;
            background-color: #007bff;
            color: #fff;
            font-size: 18px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.2s;
        }

        .button1:hover {
            background-color: #0056b3;
            transform: scale(1.05); /* Slight scale-up effect on hover */
        }
    </style>
    <script>
        function goback() {
            document.location.href = "http://localhost:8080/Signup-Signin_Feature/home.jsp";
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Incorrect Password</h1>
        <div class="button-container">
            <input type="button" class="button1" value="Go back" onclick="goback()">
        </div>
    </div>
</body>
</html>
