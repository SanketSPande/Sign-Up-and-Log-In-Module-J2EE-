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
<style>
.button {
            width: 85px;
            height: 30px;
            background-color: rgb(183, 183, 241);
            font-size: larger;

        }
.textbox {
            width: 300px;
            height: 25px;
            font-size: larger;
        }    
.passForm{
text-align: center;
}    
</style>
<script type="text/javascript">
function validate(){
	
	var password = document.getElementById("pass");		
	
	if(password.value.trim() ==""){
		alert("No blank values allowed for password");
		return false;			
	}
	
	else{
		true;
	}
}
</script>
<title>Password Validation</title>
</head>
<body>
<div class="passForm">
<h2>To make changes in your profile, enter your password*</h2><br>

<form onsubmit="return validate()" action="PasswordValidation" method="post" >
	<input type="password" name ="password" id = "pass" placeholder="Enter Password" class="textbox">
	<input type="submit" class="button" value="Submit" >	
</form>
</div>
</body>
</html>