<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Home</title>

    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<style>
body{
background: linear-gradient(to right, #3498db, #2c3e50);
}
</style>
<body>
<jsp:include page="Customer_header.jsp" />
    <div class="container mt-5">
        <div class="col-md-6 offset-md-3">
            <h2 class="text-center mb-4">Customer-home</h2>
            
            <div class="text-center">
                <a href="nameServer" class="btn btn-success btn-lg btn-block mb-3">Review Product</a>
                <a href="prepare_product" class="btn btn-success btn-lg btn-block mb-3">View Products</a>
                <a href="Customer_Log_in.jsp" class="btn btn-success btn-lg btn-block mb-3">Log-Out</a>
            </div>
        </div>
    </div>

</body>
</html>
