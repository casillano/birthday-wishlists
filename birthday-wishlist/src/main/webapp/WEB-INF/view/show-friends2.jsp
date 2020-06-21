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
	 href="${pageContext.request.contextPath}/resources/css/main.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Birthday (or special occasion) Wishlists</h2>
		</div>
	</div>
	
	<input type="button" value="Add Friend"
				onclick="window.location.href='showAddForm'; return false;"
				class="add-button"
			/>
			
	<form:form action="search" method="GET" class="search-form">
		Search Friends: <input type="text" name="searchName" value="${searchText}"/>
		<input type="submit" value="Search" class="add-button" />
	</form:form>
			
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					<table data-vertable="ver1">
						<thead>
							<tr class="row100 head">
								<th class="column100 column1" data-column="column1">Name</th>
								<th class="column100 column2" data-column="column2">Birthday</th>
								<th class="column100 column3" data-column="column3">Wishlist</th>
								<th class="column100 column3" data-column="column4">Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="friend" items="${friends}">
				
								<c:url var="updateLink" value="/friends/showUpdateForm">
									<c:param name="friendId" value="${friend.id}" />
								</c:url>
								
								<c:url var="deleteLink" value="/friends/deleteFriend">
									<c:param name="friendId" value="${friend.id}" />
								</c:url>
								
								<tr class="row100">
									<td class="column100 column1" data-column="column1"> ${friend.name}</td>
									<td class="column100 column2" data-column="column2"> ${friend.birthday}</td>
									<td class="column100 column3" data-column="column3">
										<!--  <button onclick="window.open('https://www.amazon.ca/hz/wishlist/ls/${friend.wishlistId}', '_blank')">View Wishlist</button> -->
										<a href="https://www.amazon.${friend.amazonDomain}/hz/wishlist/ls/${friend.wishlistId}" target="_blank">View Wishlist</a>
										
									</td>
									<td class="column100 column4" data-column="column4"> 
										<a href="${updateLink}">Update</a>
										|
										<a href="${deleteLink}"
											onclick="if (!(confirm('Are you sure you want to delete this person?'))) return false">Delete</a>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>