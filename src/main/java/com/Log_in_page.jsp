<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<meta charset="UTF-8">
	<title>Log in page</title>
</head>
<body>
<div id='container'>
<div class='form-group'>
	<form action="Log_in_check" method="post" class="form-inline">
	<div class="form-group">
		    <label>Email address:</label>
		    <input type="email" name="email" placeholder="Enter Email"  class="form-control" id="email" required><br>
    </div><br>
   <div class="form-group">
	    <label for="pwd">Password:</label>
	    <input type="password" name="password" class="form-control" placeholder="Enter pasword" id="pwd" required>
  </div><br>
	  
	    <button type="submit" class="btn btn-default">Submit</button>
	
	</form>
		  <h2> <a href='Customer_Signup.jsp' >Sign Up</a></h2>
</div>

</div>



</body>
</html>