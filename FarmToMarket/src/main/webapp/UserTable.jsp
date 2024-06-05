<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.UserPojo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank You Page</title>
<style>
body{
 background-image: url("1111.jpg"); 
      background-size: cover;
      color: #fff;
      padding: 150px 0;
    } 
table {
    border-collapse: collapse;
    width: 73%;
    background-color:white;
  
    margin-top: 57px;
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
    top: 5px;
    left:28%;
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
</style>
</head>
<body>
    <h1>USER DETAILS</h1>
    <table border="1">
        <tr style="text-align: center; background-color: #4CAF50; color: white;">
              <td>ID</td>
            <td>NAME</td>
            <td>TYPE</td>
            <td>PHONE NUMBER</td>
            <td>EMAIL</td>
            <td>ADDRESS</td>
            <td colspan="2">EDIT</td>
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
		 <td>
       <form action="UpdateUser" method="get">

       <input type="hidden" name="name" value="<%=obj.getId() %>">
       <%-- <a href="UpdateUserTable.jsp?updateId=<%=obj.getId() %>"><button>Update</button></a> --%>
       <a href="UpdateUserTable.jsp?updateId=<%=obj.getId() %>">Update</a>
     
	</form>
	  </td>
	  </tr>
    <%
       }
        %>  
    </table>
    <div class="search">
	<form action="SearchUserServlet" method="get">
			<label for="name">Type:</label><br>
			 <input type="text" id="name" name="type" placeholder="Enter type" required autofocus>
				<input type="submit" value="SEARCH" class="button2">
				</div>
				
    