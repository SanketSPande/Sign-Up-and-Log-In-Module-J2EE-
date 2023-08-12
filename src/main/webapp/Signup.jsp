<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<style>
        #h {
            background-color: rgb(105, 105, 194);
            width: 100%;
            height: 70px;
        }

        #s {
            color: coral;
        }

        .textbox {
            width: 500px;
        }

        .button {
            background-color: rgb(183, 183, 241);
        }
    </style>
    
    
</head>
<body>

 <header id="h">
        <h3>Signup Form</h3>
    </header>

    <h2>User Driven Registration - New User</h2>
    <small id="s"><em>Mandatory fields are marked with an asterisk (*)</em> </small><br><br>

    <form action="Signup" method ="post">

        <label for="username">Username*</label><br> <input type="text" class="textbox" name="username" required><br><br>

        <label for="password">Password*</label><br> <input type="password" class="textbox" name="password" required><br><br>

        <label for="name">Name*</label><br> <input type="text" class="textbox" name="name" required><br><br>

        <label for="contact">Contact*</label><br> <input type="text" class="textbox" name="contact" required><br><br>
       
       <input type="submit" class="button" value="Signup">
       <input type="button" class="button" value="Reset">  <br><br>      
      

    </form>
</body>
</html>