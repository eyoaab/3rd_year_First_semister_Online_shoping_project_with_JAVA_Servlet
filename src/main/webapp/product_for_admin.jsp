<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
   
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
       

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<jsp:include page="adminHeader.jsp" />
<div class="container">
    <h2>Product List</h2>

    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Quantity in Stock</th>
                    <th>Category ID</th>
                    <th>Created Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.productDescription}</td>
                        <td>${product.price}</td>
                        <td>
                            <img src=${product.imageUrl} alt="Product Image" style="max-width: 100px; max-height: 100px;">
                        </td>
                        <td>${product.quantityInStock}</td>
                        <td>${product.categoryId}</td>
                        <td>${product.createdDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>



</body>
</html>
