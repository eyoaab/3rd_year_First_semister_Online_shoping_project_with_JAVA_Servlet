<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Home</title>
    
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<style>
body{
background: linear-gradient(to right, #3498db, #2c3e50);
}
</style>
<body>

<jsp:include page="adminHeader.jsp"/>
    <div class="container mt-5">
        <div class="col-md-6 offset-md-3">
            <h2 class="text-center mb-4">Admin Home</h2>
            
            <div class="text-center">
                <a href="Admin_add_product.jsp" class="btn btn-success btn-lg btn-block mb-3">Add Product</a>
                <a href="ViewOrderDetailsServlet" class="btn btn-success btn-lg btn-block mb-3">Order Details</a>
                <a href="AdminViewProduct" class="btn btn-success btn-lg btn-block mb-3">View All Products</a>
                <a href="ViewAllCustomersServlet" class="btn  btn-success btn-lg btn-block mb-3">View all all Customer</a>
                <a href="ProductReviewDetailsServlet" class="btn  btn-success btn-lg btn-block mb-3">view all Review details</a>
                <a href="Admin_login.jsp" class="btn btn-success btn-lg btn-block mb-3">Log-Out</a>
			     
			     
            </div>
        </div>
    </div>

</body>
</html>
