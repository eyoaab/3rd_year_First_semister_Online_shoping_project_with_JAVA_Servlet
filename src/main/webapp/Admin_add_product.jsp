<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/AdminAddProduct.css"> 
</head>
 <jsp:include page="adminHeader.jsp" />
<body>

<div class="container mt-5">
        <div class="card">
            <div class="card-header text-black "id='back'>
                <h2 class="text-center">Add New Product</h2>
            </div>
            <div class="card-body">
                <form action="Admin_add" method="post">
                    <div class="form-group">
                        <label for="productName">Product Name:</label>
                        <input type="text" name="productName" placeholder="Enter Product Name" required class="form-control">
                    </div>

                  <div class="form-group">
                    <label for="productDescription">Product Description:</label>
                    <input type="text" name="productDescription" placeholder="Enter Product Description" required class="form-control input">
                </div>

                <div class="form-group">
                    <label for="productPrice">Product Price:</label>
                    <input type="number" name="productPrice" min="1" placeholder="Enter Product Price" required class="form-control input">
                </div>

                <div class="form-group">
                    <label for="productImageURL">Product Image URL:</label>
                    <input type="text" name="productImageURL" placeholder="Enter Product Image URL" required class="form-control input">
                </div>
                <div class="form-group">
                    <label for="productQtty">Amount in stock:</label>
                    <input type="number" name="productQtty" placeholder="Enter amount in stock" required class="form-control input">
                </div>

                    <div class="form-group">
                        <label for="category">Select a Category:</label>
                        <select id="category" name="category" class="form-control">
                            <option value="electronics">Electronics</option>
                            <option value="clothing">Clothing</option>
                            <option value="homeAndGarden">Home and Garden</option>
                        </select>
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-success butt">Add Product</button>
                        <button type="reset" class="btn btn-danger ml-2 butt">Cancel</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
    
    
   
  
      
            
   
</body>
</html>
