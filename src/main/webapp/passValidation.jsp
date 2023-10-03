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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Validation</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f0f0f0;
        }
        .passForm {
            text-align: center;
            margin-top: 10%;
        }
        .form-container {
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .button {
            width: 150px;
            height: 50px;
            background-color: #007bff;
            color: #fff;
            font-size: larger;
            border-radius: 10px; /* Rounded corners */
            border: none; /* Remove button border */
            transition: transform 0.2s;
        }
        .button:hover {
            transform: scale(1.05); /* Slight scale-up effect on hover */
        }
        .textbox {
            width: 300px;
            height: 40px;
            font-size: larger;
        }
    </style>
    <script type="text/javascript">
        function validate() {
            var password = document.getElementById("pass");

            if (password.value.trim() === "") {
                alert("No blank values are allowe for the password.");
                return false;
            } else {
                return true;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <div class="passForm form-container">
                <h2 class="mb-4">Please enter your password to update your profile*</h2>
                <form onsubmit="return validate()" action="PasswordValidation" method="post">
                    <div class="form-group">
                        <input type="password" name="password" id="pass" placeholder="Enter Password" class="form-control textbox">
                    </div>
                    <button type="submit" class="btn btn-primary button">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
