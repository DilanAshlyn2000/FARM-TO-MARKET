<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.UserPojo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Details</title>
<style>
    body {
        background-image: url("1111.jpg");
        background-size: cover;
        color: #fff;
        padding: 150px 0;
    }

    table {
        border-collapse: collapse;
        width: 73%;
        background-color: white;
        margin-top: 57px;
        margin-left: 179px;
        color:black;
    }

    td {
        border: 2px solid #ddd;
        padding: 8px;
        text-align:center;
    }

    h1 {
        color: #4CAF50;
      /*   background-color: rgba(9, 9, 9, 0.5); */
        text-shadow: 2px 2px 4px violet;
        text-decoration-line: underline;
        text-align: center;
        position: absolute;
        top: 5px;
        left: 28%;
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
        background-color: #2F80ED;
        color: white;
        border: 2px solid black;
    }

    .button2:hover {
        background-color: white;
        color: black;
    }

    .search {
        position: absolute;
        top: 27%;
        right: 157px;
        color: white;
    }
</style>
</head>
<body>
    <h1>CATEGORY DETAILS</h1>
    <table border="1">
        <tr style="text-align: center; background-color: #4CAF50; color: white;">
            <td>CATEGORY ID</td>
            <td>CATEGORY NAME</td>
            <td colspan="1">ACTION</td>
        </tr>
        <%
        List<UserPojo> form = (List<UserPojo>) request.getAttribute("list");
        if (form != null) {
            for (UserPojo obj : form) {
        %>
        <tr>
            <td><%= obj.getCategoryId()%></td>
            <td><%= obj.getCategory()%></td>
            <td>
                <form action="DeleteCategoryServlet" method="get">
    <input type="hidden" value="<%= obj.getCategoryId() %>" name="categoryId"> <!-- Make sure you're passing the categoryId here -->
    <input type="submit" value="DELETE DETAILS" class="button1" name="action">
</form>
            </td>
           
        </tr>
        <%
            }
        }
        %>
        
    </table>
    
</body>
</html>
