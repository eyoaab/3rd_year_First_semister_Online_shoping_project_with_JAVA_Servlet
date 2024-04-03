<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>

    <link rel="stylesheet" href="bootstrap/4.0.0/css/bootstrap.min.css">

    <style>
.product-card {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
            margin-top:1em;
            margin-bottom:.5em;
           box-shadow: 0 0 20px rgba(0, 0, 0, 0.6);       
        }
.cards{

height:10%
}
.product-image {
            max-width: 100%;
            max-height: 150px;
        }
.cart-sign {
            font-size: 20px;
            color: green;
        }
    </style>
</head>
<body>
<jsp:include page="Customer_header.jsp"/>
<div class="container">
    <div class="row">
        <c:forEach var="product" items="${productList}">
            <div class="col-md-4 ">
                <div class="product-card">
                    <img src=${product.imageUrl} alt="Product Image" class="product-image">
                    <h3>${product.name}</h3>
                    <h3>${product.price}</h3>
                    <p>${product.description}</p>
                    <span class="cart-sign">&#128722;</span> 
                </div>
            </div>
        </c:forEach>
    </div>
</div>



</body>
</html>
