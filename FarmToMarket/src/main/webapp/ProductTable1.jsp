<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.ProductPojo" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    .container {
        max-width: 1200px;
        margin: 20px auto;
        padding: 0 20px;
        
    }

    .card {
        width: calc(25% - 20px);
        margin: 10px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        overflow: hidden;
        display: inline-block;
        vertical-align: top;
        text-align: center; /* Center align content */
    }

    .card img {
        width: 100%;
        height: 200px; /* Set a fixed height for the images */
        object-fit: cover; /* Ensure the image fills the space without distortion */
        border-bottom: 1px solid #ddd;
    }

    .card-content {
        padding: 15px;
    }

    .card-content h2 {
        margin: 0 0 10px;
        font-size: 20px;
        text-align: center; /* Center align product name */
    }

    .card-content p {
        margin: 0 0 10px;
        font-size: 14px;
        text-align: left; /* Left align other details */
    }

    .add-to-cart {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 8px 16px;
        border-radius: 4px;
        cursor: pointer;
        margin-top: 10px; /* Add space between product details and button */
    }

    .add-to-cart:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>PRODUCTS DETAILS</h1>
        <div class="card-container">
            <% 
            List<ProductPojo> productList = (List<ProductPojo>) request.getAttribute("list");
            for (ProductPojo product : productList) {
            %>
            <div class="card">
                <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(product.getProduct_image()) %>" alt="Product Image">
                <div class="card-content">
                    <h2><%= product.getProductName() %></h2>
                    <p><strong>Product ID:</strong> <%= product.getProductId() %></p>
                    <p><strong>Farmer ID:</strong> <%= product.getFarmerId() %></p>
                    <p><strong>Description:</strong> <%= product.getDescription() %></p>
                    <p><strong>Price:</strong> <%= product.getPrice() %></p>
                    <p><strong>Stock Quantity:</strong> <%= product.getStockQuantity() %></p>
                    <button class="add-to-cart">Add to Cart</button>
                </div>
            </div>
            <% } %>
        </div>
    </div>
</body>
</html>

