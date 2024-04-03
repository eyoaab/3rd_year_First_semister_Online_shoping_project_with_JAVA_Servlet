<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login Page</title>
     <link rel="stylesheet" href="css/Admin_login.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

    <div class="container mt-5">
        <div class="col-md-6 offset-md-3">
            <h2 class="text-center mb-4">Admin Login</h2>
            <form action="AdminLoginServlet" method="post">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>

                <br><button type="submit" class="btn btn-primary btn-block">Login</button>
            </form>
        </div>
    </div>

</body>
</html>
