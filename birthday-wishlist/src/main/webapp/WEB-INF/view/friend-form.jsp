<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Save Customer</title>
	<!-- css was taken from online -->
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/main.css"
	/>
	
	<style>.error {color: red}</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Birthday (or special occasion) Wishlists</h2>
		</div>
	</div>
	<div id="container">
		<h3 class="save-friend">Save Friend</h3>
		<form:form action="saveFriend" modelAttribute="friend" method="POST">
			<!-- hidden id form tag so that the id of the person persists,
				 allows person to be updated instead of creating another person -->
			<form:hidden path="id" />
			
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110 add-form">
			<table data-vertable="ver1 add-form">
				<tbody>
					<tr class="row100">
						<!-- form tags are used to set the attributes of the Friend entity -->
						<td class="column100 column1"><label>Name:</label></td>
						<td class="column100 column2"><form:input path="name" />
						<!-- error tags show any validation errors of the given attribute -->
						<form:errors path="name" cssClass="error"/>
						</td>
					</tr>
					<tr class="row100">
						<td class="column100 column1"><label >Birthday (YYYY-MM-DD):</label></td>
						<td class="column100 column2"><form:input path="birthday" />
						<form:errors path="birthday" cssClass="error"/>
						</td>
					</tr>
					<tr class="row100">
						<td class="column100 column1"><label>Wishlist ID:</label></td>
						<td class="column100 column2"><form:input path="wishlistId" />
						<form:errors path="wishlistId" cssClass="error" />
						</td>
					</tr>
					<tr class="row100">
					<td class="column100 column1"><label>Amazon Domain:</label></td>
					<td class="column100 column2">
						<form:select path="amazonDomain">
							<form:option value="ca" label=".ca"/>
							<form:option value="com" label=".com"/>
						</form:select>
						</td>
					</tr>
					<tr class="row100">
						<td class="column100 column1"><input type="submit" value="Save"  class="save"/></td>
						<td class="column100 column2"><p><a href="${pageContext.request.contextPath}/friends/showAll">Back to list</a></p></td>
					</tr>
				</tbody>
			</table>
			</div>
			</div>
		</form:form>
		
	</div>
</body>
</html>