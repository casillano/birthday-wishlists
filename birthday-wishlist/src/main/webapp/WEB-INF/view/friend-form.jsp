<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Save Customer</title>
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"
	/>
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"
	/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Birthday (or special occasion) Wishlists</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Friend</h3>
		<form:form action="saveFriend" modelAttribute="friend" method="POST">
			
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td><label>Birthday (YYYY-MM-DD):</label></td>
						<td><form:input path="birthday" /></td>
					</tr>
					<tr>
						<td><label>Wishlist ID:</label></td>
						<td><form:input path="wishlistId" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both"></div>
		<p><a href="${pageContext.request.contextPath}/friends/showAll">Back to list</a></p>
		
	</div>
</body>
</html>