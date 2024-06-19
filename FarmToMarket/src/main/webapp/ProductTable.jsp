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

    table {
        width: 100%;
        border-collapse: collapse;
        border-spacing: 0;
    }

    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #4CAF50;
        color: white;
    }

    tr:hover {
        background-color: #f2f2f2;
    }

    .delete-btn {
        background-color: #f44336;
        color: white;
        border: none;
        padding: 8px 16px;
        border-radius: 4px;
        cursor: pointer;
    }

    .delete-btn:hover {
        background-color: #da190b;
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
      /* position: relative;
    left: -180px; */
    }

    .login-signup {
      display: flex;
      align-items: center;
      position: relative;
    left: 86%;
    }

    .login-signup a {
      text-decoration: none;
      color: #fff;
      padding: 10px;
    }

    .login-signup .login {
      margin-right: 10px;
    }

    .signup {
      background-color: #4CAF50; /* Green */
      border: none;
      color: white;
      padding: 10px 20px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      margin: 4px 2px;
      cursor: pointer;
      border-radius: 8px;
    }

    .signup:hover {
      background-color: #45a049;
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
  
</style>
</head>
<body>

<header>
    <nav>
     
      <div class="login-signup">
       
 <!--<a href="LogoutServlet" method="get"></a>-->
        <button class="signup">LOGOUT</button>
      </div>
    </nav>
  </header>
  <header class="header1">
    <nav>
      <a href="#" class="logo">  <img src="Screenshot (188).png" alt="Logo" class="logo"></a>
      <ul class="nav-links">
        <li><a href="AdminHome.html">Home</a></li>
        <li><a href="DisplayUserServlet">View Details</a></li>
            <li><a href="Category.html">Add Category</a></li>
           <li> <a href="DisplayCategory">View Category</a></li>
           <li> <a href="DisplayProduct">View Products</a></li>
          </div>
        </li>
      </ul>
    </nav>
  </header>
    <div class="container">
        <h1>PRODUCTS DETAILS</h1>
        <table>
            <tr>
                <!-- <th>PRODUCT ID</th> -->
                <th>PRODUCT NAME</th>
                <th>PRODUCT IMAGE</th>
                <th>FARMER ID</th>
                <th>DESCRIPTION</th>
                <th>PRICE</th>
                <th>STOCK QUANTITY</th>
                <th>CATEGORY ID</th>
                <th colspan="2">DELETE</th>
            </tr>
            <% 
            List<ProductPojo> productList = (List<ProductPojo>) request.getAttribute("list");
            for (ProductPojo product : productList) {
            	System.out.println("ID __" + product.getProductId());
            %>
            <tr>
               <%--  <td><%= product.getProductId() %></td> --%>
                <td><%= product.getProductName() %></td>
                <td><img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(product.getProduct_image()) %>" alt="Product Image" style="max-width: 100px; max-height: 100px;"></td>
                <td><%= product.getFarmerId() %></td>
                <td><%= product.getDescription() %></td>
                <td><%= product.getPrice() %></td>
                <td><%= product.getStockQuantity() %></td>
                <td><%= product.getCategoryId() %></td>
                <td>
                <input type="hidden" value="<%=product.getProductName()%>" name="productName">
                	<input type="hidden" value="<%=product.getPrice()%>" name="price">
                	<input type="hidden" value="<%=product.getCategoryId()%>" name="CategoryId">
                	<input type="hidden" value="<%=product.getStockQuantity()%>" name="stockQuantity">
		   <td><form action="DeleteProduct" method="get">
                 <button class="delete-btn" value=<%= product.getProductId() %> name="id")>Delete</button>
                 </form>
                </td>
            </tr>
          <td> 
            <%--  <button class="delete-btn"onclick="updateProduct(<%= product.getProductId() %>)">UPDATE</button> --%>
            <form action="UpdateFarmerProduct.jsp" >
            	<input type="hidden" name="id" value="<%=product.getProductId()%>">
               <!--  <input type="submit" name="update" value="Update"> -->
               <button>Update</button>
            </form>
            </td>
             </tr> 
            <% } %>
        </table>
    </div>
    <script>
function updateProduct(productId) {
    window.location.href = "UpdateFarmerProduct.jsp?productId=" + productId;
}
</script>   
</body>
</html> 
   