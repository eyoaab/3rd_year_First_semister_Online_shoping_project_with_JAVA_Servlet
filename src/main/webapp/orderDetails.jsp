<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Order Details</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<jsp:include page="adminHeader.jsp" />
    <div class="container">
        <h2>Order Details</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Product Name</th>
                    <th>Order Date</th>
                    <th>Order Total</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="orderDetail" items="${orderDetails}">
                    <tr>
                        <td>${orderDetail.firstName}</td>
                        <td>${orderDetail.lastName}</td>
                        <td>${orderDetail.productName}</td>
                        <td>${orderDetail.orderDate}</td>
                        <td>${orderDetail.orderTotal}</td>
                        <td>${orderDetail.quantity}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
