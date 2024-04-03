<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
      <link rel="stylesheet" href="css/Sign_in_css.css">
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body >
<div class="marquee-container">
  <div class="marquee-text">
    <h3>Welcome to Our Web site</h3>
  </div>
</div>
    <div class="container" >
        <div class="jumbotron">
           <form action="signup_Servlet" method="post">
	
			<label>First Name </label>
			 <input type="text" name="First_name" placeholder="Enter First Name" required class="input"><br>
			  <label>Last Name
			   </label> <input type="text" name="Last_name" placeholder="Enter Last Name" required class="input"><br>
			  <label>Age
			   </label>  <input type="number" name="Age"  min="1" placeholder="Enter Age" required class="input"><br>
			  <label>E-mail
			   </label>  <input type="email" name="email" placeholder="Enter Email" required class="input"><br>
		 	    <label>Password
		 	     </label>  <input type="password" name="password" placeholder="Enter pasword" required class="input"><br>
			   <label>Gender</label>
<select name="Gender" required class="input">
    <option value="male">Male</option>
    <option value="female">Female</option>
</select><br>
	<input type="submit" class="btn btn-success" value="Sign-Up">
	</form>     
            <div class="mt-3">
                <p>if you have an account please go to Log-in Page</p> <a class="button" href="Customer_Log_in.jsp">Log-in</a>
                
             
            </div>
        </div>
    </div>
</body>
</html>
