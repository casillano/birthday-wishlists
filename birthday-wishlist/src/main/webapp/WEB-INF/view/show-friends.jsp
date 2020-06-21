<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Show Friends and Their Birthdays</title>
	<link type="text/css" rel="stylesheet"
	 href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Birthday (or special occasion) Wishlists</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<input type="button" value="Add Friend"
				onclick="window.location.href='showAddForm'; return false;"
				class="add-button"
			/>
			
			<form:form action="search" method="GET">
				Search Friends: <input type="text" name="searchName" value="${searchText}"/>
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<table>
				<tr>
					<th>Name</th>
					<th>Birthday</th>
					<th>Wishlist</th>
					<th>Actions</th>
				</tr>
				
				<c:forEach var="friend" items="${friends}">
				
					<c:url var="updateLink" value="/friends/showUpdateForm">
						<c:param name="friendId" value="${friend.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/friends/deleteFriend">
						<c:param name="friendId" value="${friend.id}" />
					</c:url>
					
					<tr>
						<td> ${friend.name}</td>
						<td> ${friend.birthday}</td>
						<td>
							<button onclick="window.open('https://www.amazon.${friend.amazonDomain}/hz/wishlist/ls/${friend.wishlistId}', '_blank')">View Wishlist ${friend.amazonDomain}</button>
						</td>
						<td> 
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this person?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>