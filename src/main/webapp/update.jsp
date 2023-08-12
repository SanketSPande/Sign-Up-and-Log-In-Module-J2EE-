<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<title>Update Page</title>
    <style>
        .textbox {
            width: 300px;

        }
    </style>
</head>
<body>
 <h3>You can update the data by entering new data in the corresponding textbox</h3><br>

    *<em style="color:blue;">If not to update then leave it blank</em><br><br>

    <form action="Update" method="post">
        <label for="password">Password</label><br><br> <input type="password" name="password" class="textbox"><br><br>
        <label for="name">Name</label><br><br> <input type="text" name="name" class="textbox"><br><br>
        <label for="contact">Contact</label><br><br> <input type="text" name="contact" class="textbox"><br><br>

        <input type="submit" value="Save" style="background-color: rgb(123, 123, 243);">
    </form>

</body>
</html>