<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer-header</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/Customer_head.css">
</head>
<body class='body'>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">Customer_Panel</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="Customer_home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="prepare_product">Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Customer_Review_page.jsp">Review</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="Customer_Log_in.jsp">LogOut</a>
                </li>
               
            </ul>
        </div>
    </div>
</nav>


</body>
</html>
