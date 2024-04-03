<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">Admin Panel</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="AdminHome.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Admin_add_product.jsp">Add-Products</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="AdminViewProduct">View-Products</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="ViewOrderDetailsServlet">View-Order</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="ViewAllCustomersServlet">View-Customers</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="ProductReviewDetailsServlet">View-Review</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="Admin_login.jsp">Log-out</a>
                </li>
              
             
                
            </ul>
        </div>
    </div>
</nav>



</body>
</html>
