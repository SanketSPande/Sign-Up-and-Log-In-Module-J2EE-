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
    <style>
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

        }
    </style>
    <script>
		function reload(){
			document.location.href = "http://localhost:8080/Signup-Signin_Feature/update.jsp";
		}			
	</script>
</head>
<body>
 <h1>You can update the data by entering new data in the corresponding textbox</h1><br>

    <em style="color:blue; font-size: larger;"><h3>*If not to update then leave it blank and hit save</h3></em>

    <form action="Update" method="post">
        <h3><label for="password" style="font-size: larger;">Password</label></h3> <input type="password" name="password"  class="textbox"><br><br>
        <h3><label for="name" style="font-size: larger;">Name</label></h3> <input type="text" name="name"  class="textbox"><br><br>
        <h3><label for="contact" style="font-size: larger;">Contact</label></h3> <input type="text" name="contact"  class="textbox"><br><br>

        <input type="submit" value="Save" class="button">
        <input type="button" value="Reset" onclick="reload()" class="button">
        
    </form>

</body>
</html>