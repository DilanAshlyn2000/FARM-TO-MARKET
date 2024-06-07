<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.UserPojo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank You Page</title>
<style>

 body {
      margin: 0;
      font-family: Arial, sans-serif;
      /* font-family: Apple Chancery, cursive; */

      
      overflow: hidden;
      
    
    } 
table {
    border-collapse: collapse;
    width: 73%;
    background-color:white;
  
    margin-top: 108px;
    margin-left: 179px;
}
td {
    border: 2px solid #ddd;
    padding: 8px;
    color:black;
}
h1 {
    color: #4CAF50;
 
    text-decoration-line: underline;
    text-align: center;
    position: absolute;
    top: 103px;
    left: 40%;
}
.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid black;

}

.button1:hover {
  background-color: #4CAF50;
  color: white;
}
.button2 {
  background-color: #4CAF50; 
  color: white; 
  border: 2px solid black;

}

.button2:hover {
  background-color: 4CAF50;
  color: white;
}
.search{
position: absolute;
    top: 20%;
    right: 210px;
    color: white;  
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
<body>

<header>
    <nav>
     
      <div class="login-signup">
       
       <!--  <a href="LogoutServlet" method="get"></a> -->
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
           <li> <a href="DisplayProductAdminSide">View Products</a></li>
       
          </div>
        </li>
      </ul>
    </nav>
  </header>
    <h1>USER DETAILS</h1>
    <table border="1">
        <tr style="text-align: center; background-color: #4CAF50; color: white;">
              <td>ID</td>
            <td>NAME</td>
            <td>TYPE</td>
            <td>PHONE NUMBER</td>
            <td>EMAIL</td>
            <td>ADDRESS</td>
            <td>DELETE</td>
           <!--  <td colspan="2">EDIT</td> -->
        </tr>
        <% 
        List<UserPojo> form = (List<UserPojo>) request.getAttribute("list");
        for (UserPojo obj : form) {
        %>
        <tr>
        <td><%= obj.getId()%></td>
        <td><%= obj.getName()%></td>
        <td><%= obj.getType()%></td>
        <td><%= obj.getPhone()%></td>
        <td><%= obj.getEmail()%></td>
        <td><%= obj.getAddress()%></td>
       
        <td><form action="DeleteFarmer" method="get">
		<!-- Your input fields here -->
		<input type="hidden" class="button1" value=<%=obj.getId()%> name="id">
		<input type="submit" value="DELETE DETAILS" class="button1" name="action">
		
	</form>
		
      <%--  <form action="UpdateUser" method="get">

       <input type="hidden" name="name" value="<%=obj.getId() %>">
       <a href="UpdateUserTable.jsp?updateId=<%=obj.getId() %>"><button>Update</button></a>
       <a href="UpdateUserTable.jsp?updateId=<%=obj.getId() %>">Update</a>
     
	</form> --%>
	
	  </tr>
    <%
       }
        %>  
    </table>
    <div class="search">
	<form action="SearchUserServlet" method="get">
	<label for="type">Type:</label><br>
<select id="type" name="type" required autofocus>
  <option value="users">USER</option>
  <option value="farmers">FARMER</option>
  <option value="others">ADMIN</option>
</select>
<input type="submit" value="SEARCH" class="button2">
			<!-- <label for="name">Type:</label><br>
			 <input type="text" id="name" name="type" placeholder="Enter type" required autofocus>
				<input type="submit" value="SEARCH" class="button2"> -->
				</div>
				
    