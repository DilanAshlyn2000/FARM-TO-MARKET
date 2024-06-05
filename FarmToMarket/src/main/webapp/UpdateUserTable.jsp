<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
 
.form-container {
max-width: 330px;
    margin: 0 auto;
    padding: 20px;
   background-color: white; 
    border-radius: 0px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    position: absolute;
   color:black;
        left: 27%;
    top: 93px;
    line-height: 0.5;
    background-image: url('b1.webp'); 
  background-size: cover; 
  background-position: center; 

  
}

/* Style for the form heading */
.form-container h2 {
  margin-bottom: 20px;
  text-align: center;
  color: white;
}

/* Style for labels */
.form-container label {
  display: block;
  margin-bottom: 6px;
  color: white;
 font-weight: bold;
}

/* Style for input fields */
.form-container input[type="text"],
.form-container input[type="tel"],
.form-container input[type="email"],
.form-container input[type="password"],
.form-container select,
.form-container textarea {
  width: 100%;
  padding: 10px;
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box; /* Ensure padding and border are included in the width */
}

/* Style for submit button */
.form-container input[type="submit"] {
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 4px;
  background-color: #4CAF50;;
  color: #fff;
  font-size: 16px;
  cursor: pointer;
}

/* Style for submit button on hover */
.form-container input[type="submit"]:hover {
  background-color: black;
}
  
    img.img2{
    height: 582px;
    top: 93px;
    position: absolute;
    left: 682px;
    width:400px;
    opacity: 0.5; 
    }
 .pic1{
 position: relative;
    color: white;
    top: 21pc;
    left: 49pc;
    width: 250px;
    font-size: large;
    text-align: center;

 } 
  
  </style>
</head>
<body>

<img src="b1.webp" alt="image" class="img2" > 
<div class="pic1">
  <h2>Savoring the Journey from Soil to Supper</h2>
</div>

<div class="form-container">
  <h2>UPDATE TABLE</h2>
  <form action="UpdateUser" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" placeholder="Enter Name" >
    
    <label for="phone">Phone Number:</label>
    <input type="tel" id="phone" name="phone" placeholder="Enter Phone Number" pattern="[0-9]{10}" >

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" placeholder="Enter Email" required>

    <label for="address">Address:</label>
    <textarea id="address" name="address" rows="2" placeholder="Enter Address" ></textarea>

    <!-- Embedding Java code for the hidden input -->
    <%
      // Retrieving the 'updateId' parameter from the request
      String updateId = request.getParameter("updateId");
    %>
    <input type="hidden" name="updateId" value="<%= request.getParameter("updateId") %>">

    <input type="submit" value="UPDATE">
  </form>
</div>

</body>
</html>
