<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Product Review Page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/Review_by_customer.css">
</head>

<body>
<jsp:include page="Customer_header.jsp"/>   
 <div class="container mt-5">
        <div class="card">
            <div class="card-header  text-white" id='back'>
                <h2 class="text-center">Product Review</h2>
            </div>
            <div class="card-body">
                <form action="SaveReviewServlet" method="post" class="needs-validation" novalidate>
                    <div class="form-group">
                        <label for="productName">Product Name:</label>
                        <select class="form-control" id="productName" name="productName" required onchange="updateProductId(this)">
                            <option value="" disabled selected>Select a product</option>
                            <c:forEach var="product" items="${products}">
                                <option value="${product.productId}" data-product-id="${product.productId}">${product.productName}</option>
                            </c:forEach>
                        </select>
                        <!-- Hidden input to store the selected product ID -->
                        <input type="hidden" id="selectedProductId" name="selectedProductId" value="">
                        <!-- Error message for product not selected -->
                        <small class="text-danger" id="productError" style="display:none;">Please select a product.</small>
                    </div>

                    <div class="form-group">
                        <label for="description">Description:</label>
                        <textarea class="form-control" id="description" name="description" rows="3" required placeholder="Give a comment about the product"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="rating">Rating:</label>
                        <input type="number" class="form-control" id="rating" name="rating" min="1" max="5" required placeholder="Rate out of 5">
                    </div>

                    <div class="text-center" id='last'>
                        <button type="submit" class="btn btn-primary mr-2" >Submit Review</button>
                        <button type="reset" class="btn btn-danger">Cancel</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="container mt-1">
        <p class="text-center text-white">Please be aware of what you mean</p>
    </div>

    <script>
        function updateProductId(select) {
            var selectedOption = select.options[select.selectedIndex];
            var selectedProductId = selectedOption.getAttribute('data-product-id');
            document.getElementById('selectedProductId').value = selectedProductId;

            var productError = document.getElementById('productError');
            if (selectedProductId) {
                productError.style.display = 'none';
            } else {
                productError.style.display = 'block';
            }
        }
    </script>
</body>
</html>
