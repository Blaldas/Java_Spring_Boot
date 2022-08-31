<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update vendor</title>
</head>
<body>
<h2>Update vendor id = ${vendor.id}</h2>
		<form action="saveVendor" method="post">
			<pre>
				Id:   <input type="text" name="id"  value="${vendor.id}" readonly/>
				Code: <input type="text" name="code" value="${vendor.code}"/>
				Name: <input type="text" name="name" value="${vendor.name}"/>
				Type: <select name="type">
  						<option ${vendor.type=='Contract'?'selected':''}>Contract</option>
  						<option ${vendor.type=='Regular'?'selected':''}>Regular</option>
  				</select>
			  	Email: <input type="text" name="email" value="${vendor.email}"/>
			  	Phone: <input type="text" name="phone" value="${vendor.phone}"/>
			  	Address:<input type="text" name="address" value="${vendor.address}"/>
			 	<input type="submit" value="save" />
			</pre>
		</form>
</body>
</html>