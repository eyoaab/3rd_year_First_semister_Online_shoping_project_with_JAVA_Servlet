<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login Page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/Log_inCss.css">
</head>
<body>
    <div class="marquee-container">
        <div class="marquee-text">
            <h3>Welcome to Our Website</h3>
        </div>
    </div>

    <div class="container">
        <div class="jumbotron">
                           
            <form action="LogInServlet" method="post" class="form">
                <label for="email">Email address:</label>
                <input type="email" name="email" placeholder="Enter Email" id="email" required>
                <label for="pwd">Password:</label>
                <input type="password" name="password" placeholder="Enter Password" id="password" required>
                <br>
                <button type="submit" class="btn btn-primary">Log-in</button>
            </form>
            <div class="mt-3">
                <p>If you haven't an account, please create an account</p>
                <a class="btn btn-primary btn-success" href="Customer_Signup.jsp">Create Account</a>
            </div>
        </div>
    </div>

 
</body>
</html>
