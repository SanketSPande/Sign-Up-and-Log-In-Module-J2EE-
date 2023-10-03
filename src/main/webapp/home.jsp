<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//Http 1.1
response.setHeader("Pragma","no-cache");//Http 1.0
response.setDateHeader ("Expires", 0);//Proxies

if(session.getAttribute("uname")==null)
	response.sendRedirect("Signin.jsp");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <style>
        body {
            background-color: #f0f0f0;
        }
        header {
            background-color: #007bff;
            color: #fff;
            padding: 20px 0;
            text-align: center;
        }
/* Updated button styles for "Your Profile" and "Update Profile" buttons */
.button-container .btn-custom {
    width: 200px;
    height: 70px;
    font-size: larger;
    background-color: #556B2F; /* Olive color */
    color: #fff;
    border: none;
    border-radius: 5px; /* Rounded corners */
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Add a subtle shadow */
    transition: background-color 0.3s, transform 0.2s;
}

/* Apply the same style to both buttons */
.button-container .btn-custom:hover {
    background-color: #7c9538; /* Lighter olive on hover */
    transform: scale(1.05); /* Slight scale-up effect on hover */
    box-shadow: 0 6px 8px rgba(0, 0, 0, 0.2); /* Enhance shadow on hover */
}

/* Keep the same logout button style */
.logout-btn {
    position: absolute;
    top: 20px;
    right: 20px;
    background-color: #800000; /* Burgundy color */
    color: #fff;
    border: none;
    padding: 10px 20px;
    font-size: larger;
    border-radius: 5px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Add a subtle shadow */
    transition: background-color 0.3s, transform 0.2s;
}

/* Hover effect for the logout button */
.logout-btn:hover {
    background-color: #800000; /* Keep the burgundy color on hover */
    transform: scale(1.05); /* Slight scale-up effect on hover */
    box-shadow: 0 6px 8px rgba(0, 0, 0, 0.2); /* Enhance shadow on hover */
}


        .red-color {
            color: red;
        }
        /* Custom CSS to center the "Make a Choice" heading */
        .center-heading {
            text-align: center;
            margin-top: 100px; /* Adjust this value as needed for vertical centering */
        }
    </style>
    <script>
        function Datalist() {
            document.location.href = "http://localhost:8080/Signup-Signin_Feature/lServlet";
        }

        function update() {
            document.location.href = "http://localhost:8080/Signup-Signin_Feature/passValidation.jsp";
        }

        function Logout() {
            document.location.href = "http://localhost:8080/Signup-Signin_Feature/logout";
        }
    </script>
</head>
<body>
    <header>
        <button type="submit" class="btn btn-danger logout-btn" onclick="Logout()">
            <i class="bi bi-power"></i> Logout
        </button>
        <h1 class="display-4">Welcome to the Home Page</h1>
    </header>
    
    <div class="container center-heading">
        <h2>Make a Choice</h2>
        <div class="button-container">
            <!-- Updated button styles with more professional colors -->
            <button class="btn btn-custom btn-lg" onclick="Datalist()">Your Profile</button>
            <button class="btn btn-custom btn-lg" onclick="update()">Update Profile</button>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
