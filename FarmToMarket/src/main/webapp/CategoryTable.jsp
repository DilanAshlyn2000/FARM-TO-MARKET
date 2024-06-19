<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.chainsys.model.UserPojo"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Category Details</title>
<style>
body {
	background-image: url("1111.jpg");
	background-size: cover;
	color: #fff;
	font-family: Arial, sans-serif;
	padding: 50px 20px;
	margin: 0;
}

.container {
	max-width: 800px;
	margin: 0 auto;
}

h1 {
	color: #4CAF50;
	text-shadow: 2px 2px 4px violet;
	text-decoration: underline;
	text-align: center;
	margin-top: 0;
	padding-top: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	color: black;
}

table th, table td {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: center;
}

table th {
	background-color: #4CAF50;
	color: white;
}

table tr:nth-child(even) {
	background-color: #f2f2f2;
}

.button1, .button2 {
	display: inline-block;
	padding: 8px 16px;
	margin: 5px;
	border: none;
	cursor: pointer;
	font-size: 14px;
	border-radius: 4px;
	transition: background-color 0.3s;
}

.button1 {
	background-color: #fff;
	color: #000;
	border: 1px solid #000;
}

.button1:hover {
	background-color: #4CAF50;
	color: #fff;
}

.button2 {
	background-color: #2F80ED;
	color: #fff;
	border: none;
}

.button2:hover {
	background-color: #1E63B8;
}
</style>
</head>
<body>
	<div class="container">
		<h1>CATEGORY DETAILS</h1>
		<table>
			<thead>
				<tr>
					<th>CATEGORY ID</th>
					<th>CATEGORY NAME</th>
					<th>ACTION</th>
				</tr>
			</thead>
			<tbody>
				<% List<UserPojo> form = (List<UserPojo>) request.getAttribute("list");
                if (form != null) {
                    for (UserPojo obj : form) { %>
				<tr>
					<td><%= obj.getCategoryId() %></td>
					<td><%= obj.getCategory() %></td>
					<td>
						<form action="DeleteCategoryServlet" method="get">
							<input type="hidden" value="<%= obj.getCategoryId() %>"
								name="categoryId"> <input type="submit" value="DELETE"
								class="button1" name="action">
						</form>
					</td>
				</tr>
				<% }
                } %>
			</tbody>
		</table>
	</div>
</body>
</html>

