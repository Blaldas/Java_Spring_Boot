<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<tr>
				<th>ID</th>
				<th>CODE</th>
				<th>NAME</th>
				<th>TYPE</th>
				<th>EMAIL</th>
				<th>PHONE</th>
				<th>ADDRESS</th>
			</tr>
			<c:forEach items="${vendors}" var="vendor">
				<tr>
					<td>${vendor.id}</td>
					<td>${vendor.code}</td>
					<td>${vendor.name}</td>
					<td>${vendor.type}</td>
					<td>${vendor.email}</td>
					<td>${vendor.phone}</td>
					<td>${vendor.address}</td>
					<td><a href="deleteVendor?id=${vendor.id}">DELETE</a></td>
					<td><a href="updateVendor?id=${vendor.id}">EDIT</a></td>
				</tr>
			</c:forEach>
		</table>
		</br>
		<a href="newVendor">Create New Vendor</a>

	</body>
</html>