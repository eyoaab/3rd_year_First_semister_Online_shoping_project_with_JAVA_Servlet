<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }

        h2 {
            color: #007BFF;
        }

        table {
            width: 100%;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<jsp:include page="adminHeader.jsp" />
<body>

    <div class="container">
        <h2>Customer List</h2>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customerList}">
                    <tr>
                        <td>${customer.customerId}</td>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.age}</td>
                        <td>${customer.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
