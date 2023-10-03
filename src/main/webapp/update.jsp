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
<title>Update Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css">
<style>
    body {
        background-color: #f0f0f0;
    }
    .container {
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        margin-top: 50px;
    }
    .form-group {
        margin-bottom: 20px;
    }
    .textbox {
        width: 100%;
        height: 40px;
        font-size: 16px;
    }
    .button-container {
        display: flex;
        justify-content: space-between;
    }
    .button {
        width: 48%;
        height: 50px;
        font-size: larger;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        transition: background-color 0.3s, transform 0.2s;
        cursor: pointer;
    }
    .button:hover {
        background-color: #0056b3;
        transform: scale(1.05); /* Slight scale-up effect on hover */
    }
    .reset-button {
        width: 48%;
        height: 50px;
        font-size: larger;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        transition: background-color 0.3s, transform 0.2s;
        cursor: pointer;
    }
    .reset-button:hover {
        background-color: #0056b3;
        transform: scale(1.05); /* Slight scale-up effect on hover */
    }
</style>
</head>
<body>
<div class="container">
    <h1 class="text-center">Update Your Profile</h1>
    <em style="color: blue; font-size: larger;"><h3>*If not to update then leave it blank and hit save</h3></em>
    <form action="Update" method="post">
        <div class="form-group">
            <label for="password" style="font-size: larger;">Password</label>
            <input type="password" name="password" class="form-control textbox">
        </div>
        <div class="form-group">
            <label for="name" style="font-size: larger;">Name</label>
            <input type="text" name="name" class="form-control textbox">
        </div>
        <div class="form-group">
            <label for="contact" style="font-size: larger;">Contact</label>
            <input type="text" name="contact" class="form-control textbox">
        </div>
        <div class="button-container">
            <input type="submit" value="Save" class="btn btn-primary button">
            <input type="button" value="Reset" onclick="reload()" class="btn btn-primary reset-button">
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/js/bootstrap.min.js"></script>
<script>
    function reload() {
        document.location.href = "http://localhost:8080/Signup-Signin_Feature/update.jsp";
    }
</script>
</body>
</html>
