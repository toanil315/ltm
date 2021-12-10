<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="Post" action="AdminController?action=login">
		<label style="display: block; width: 250px">User Name: </label>
		<input type="text" name="userName" /> <br />
		<label style="display: block; width: 250px">Password: </label>
		<input type="password" name="password" /> <br />
		<%
			if(request.getAttribute("error") != null) {
		%>
		<p><%= (String)request.getAttribute("error") %></p>
		<%} %>
		<input type="submit" value="Login" /><br />
	</form>
</body>
</html>