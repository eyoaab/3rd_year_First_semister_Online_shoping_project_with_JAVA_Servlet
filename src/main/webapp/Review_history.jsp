<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Review Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<jsp:include page="adminHeader.jsp" />
    <h2>Product Review Details</h2>

    <table>
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Rating</th>
                <th>Review Date</th>
                <th>Review Description</th>
                <th>Customer Name</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="review" items="${productReviews}">
                <tr>
                    <td>${review.productName}</td>
                    <td>${review.rating}</td>
                    <td>${review.reviewDate}</td>
                    <td>${review.reviewDescription}</td>
                    <td>${review.customerFirstName} ${review.customerLastName}</td>
                    <td>${review.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
