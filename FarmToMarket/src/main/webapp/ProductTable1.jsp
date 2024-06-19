<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.ProductPojo"%>
<%@ page import="java.util.*"%>
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
	display: inline-block;
    width: 276px;
}

.card img {
	width: 100%;
	height: 200px; /* Set a fixed height for the images */
	object-fit: cover;
	/* Ensure the image fills the space without distortion */
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
	top: -5px;
	position: relative;
}

.add-to-cart:hover {
	background-color: #45a049;
}

.quantity-container {
	display: flex;
	align-items: center;
	justify-content: space-between;
	margin-top: 10px;
}

.quantity-label {
	margin-right: 10px;
}

.quantity-input {
	width: 50px;
	padding: 5px;
	text-align: center;
}
      header {
      background-color: #333;
      color: #fff;
    }

    nav {
      padding: 0px 20px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .logo {
      font-size: 1.5rem;
      width: 251px;
    
    }
    
    .content {
      padding: 20px;
    }

    .header1{
      background-color: white;
      color: black;
    }
    .nav-links {
      list-style: none;
      padding: 0;
      margin: 0;
      display: flex;
    }

    .nav-links li {
      margin-right: 20px;
    }

    .nav-links li a {
      text-decoration: none;
      color: #000;
      transition: color 0.3s;
    }

    .nav-links li a:hover {
      color: olive;
    }

    .dropdown {
      position: relative;
    }

    .dropdown-content {
      display: none;
      position: absolute;
      background-color: #f9f9f9;
      min-width: 160px;
      box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
      z-index: 1;
    }

    .dropdown:hover .dropdown-content {
      display: block;
    }

    .dropdown-content a {
      color: #000;
      padding: 12px 16px;
      text-decoration: none;
      display: block;
    }

    .dropdown-content a:hover {
      background-color: #ddd;
    }
       input[type="image"] {
    position: absolute;
    top: 78px;
    height: 58px;
    right: 35px;
    }
</style>
</head>
<body>
  <header class="header1">
    <nav>
      <a href="#" class="logo">  <img src="Screenshot (188).png" alt="Logo" class="logo"></a>
      <ul class="nav-links">
        <li><a href="Home1.html">Home</a></li>
      <!--   <li><a href="DisplayProductUserSide">Market</a></li> -->
        <li><a href="MarketCategory.html">Market</a></li>
        <li class="dropdown">
          <a href="#">About Us</a>
          <div class="dropdown-content">
            <a href="OurPeople.html">Our Team</a>
            <a href="OurCompany.html">Our Company</a>    
          </div>
        </li>
            <li> <div class="dropdown1">
  <a href="DisplayUserServlet" class="logo1">  <i class="fa fa-bars" style="font-size:32px;">
    </i></a>

      </ul>
    </nav>
  </header>
	<div class="container">
		<h1>PRODUCTS DETAILS</h1>
		<form action="CartView" method="get">
        <input type="image" src="q7.jpg" alt="Submit">
    </form>
		<div class="card-container">
			<%
			List<ProductPojo> productList = (List<ProductPojo>) request.getAttribute("productList");
			for (ProductPojo product : productList) {
			%>
			<div class="card">
			<form action="CartServlet?product=<%= product%>">
				<img
					src="data:image/jpeg;base64,<%=Base64.getEncoder().encodeToString(product.getProduct_image())%>"
					alt="Product Image">
				<div class="card-content">
					<h2><%=product.getProductName()%></h2>
					
					<%-- <p>
						<strong>Product ID           :</strong>
						<%=product.getProductId()%></p>
							
					<p> --%>
					<%-- 	<strong>Farmer ID            :</strong>
						<%=product.getFarmerId()%></p>
					<p> --%>
					
						<p><strong>Description          :</strong>
						<%=product.getDescription()%></p>
					<p>
						<strong>Price                :</strong>
						<%=product.getPrice()%></p>
					<p>
						<strong>Stock Quantity(in Kgs):</strong>
						<%=product.getStockQuantity()%></p>
				<form action="CartView.java" method="get">
					<div class="quantity-container">
							<label for="quantity" class="quantity-label">Quantity:</label>
							 <input type="number" id="quantity" name="quantity" value="1" min="1" class="quantity-input">
						<input type="hidden" value="<%=product.getProductName()%>" name="productName">
						<input type="hidden" value="<%=product.getProductId()%>" name="productId">
						<input type="hidden" value="<%=product.getFarmerId()%>" name="farmerId">
				       <input type="hidden" value="<%=product.getPrice()%>" name="price"> 
					   <button class="#">Add to Cart</button>		
					</div>
					</form>
				</div>
				</form>
			</div>
			
 	<%
   }
			%>
<!--  <form action="SearchProductCategory" method="get">
            <select id="type" name="type" required autofocus>
                <option value="1">VEGETABLES</option>
                <option value="5">FRUITS</option>
                <option value="6">FLOWERS</option>
                <option value="7">GRAINS & CEREALS</option>
            </select>
            <input type="submit" value="SEARCH" class="button2">
        </form> -->
        		
     <form action="SearchCategoryLowToHigh" method="get">
    <% for (ProductPojo product : productList) { %>
        <input type="hidden" value="<%= product.getPrice() %>" name="price1">
    <% } %>
    <select id="type" name="type" required autofocus>
        <option value="1">VEGETABLES</option>
        <option value="5">FRUITS</option>
        <option value="6">FLOWERS</option>
        <option value="7">GRAINS & CEREALS</option>
    </select>
    <input type="submit" value="SORT LOW TO HIGH" class="button2">
</form>
        		
		  <form action="SearchCategoryHighToLow" method="get">
    <% for (ProductPojo product : productList) { %>
        <input type="hidden" value="<%= product.getPrice() %>" name="price1">
    <% } %>
    <select id="type" name="type" required autofocus>
        <option value="1">VEGETABLES</option>
        <option value="5">FRUITS</option>
        <option value="6">FLOWERS</option>
        <option value="7">GRAINS & CEREALS</option>
    </select>
    <input type="submit" value="SORT HIGH TO LOW" class="button2">
</form>
 
     
</body>
</html>

