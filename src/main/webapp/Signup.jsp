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
    <script>
		function reload(){
		document.location.href = "http://localhost:8080/Signup-Signin_Feature/Signup.jsp";
		}
		function validate(){
			
			var username = document.getElementById("usrnme");	
			var password = document.getElementById("password");	
			var name = document.getElementById("nme");
			var contact = document.getElementById("cnct");
			
			if(username.value.trim() ==""){
				alert("No blank values allowed for username");
				return false;			
			}
			if(password.value.trim() ==""){
				alert("No blank values allowed for password");
				return false;			
			}
			if(name.value.trim() ==""){
				alert("No blank values allowed for name");
				return false;			
			}
			if(contact.value.trim() ==""){
				alert("No blank values allowed for contact");
				return false;			
			}
			
			else{
				true;
			}
		}
	</script>
    
</head>
<body>

 <header id="h">
        <h3>Signup Form</h3>
    </header>

    <h2>User Driven Registration - New User</h2>
    <small id="s"><em>Mandatory fields are marked with an asterisk (*)</em> </small><br><br>

    <form onsubmit="return validate()" action="Signup" method ="post">

        <label for="username">Username*</label><br> <input type="text" class="textbox" name="username" id="usrnme" required><br><br>

        <label for="password">Password*</label><br> <input type="password" class="textbox" name="pwd" id="password" required><br><br>

        <label for="name">Name*</label><br> <input type="text" class="textbox" name="name" id="nme" required><br><br>

        <label for="contact">Contact*</label><br> <input type="text" class="textbox" name="contact" id="cnct" required><br><br>
       
       <input type="submit" class="button" value="Signup">
        <input type="button" class="button" value="Reset" onclick="reload()">
  	   <br><br>      
      

    </form>
</body>
</html>