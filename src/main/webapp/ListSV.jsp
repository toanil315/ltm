<%@page import="model.bean.Khoa"%>
<%@page import="model.bean.SinhVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<Khoa> listKhoa = (ArrayList<Khoa>)request.getAttribute("listKhoa"); %>
	<form action="SVController?mode=viewListSV" method="Post">
		<select name="idKhoa">
			<%
				for(int i = 0; i < listKhoa.size(); i++) { %>
					<option value="<%= listKhoa.get(i).getIdKhoa() %>"><%= listKhoa.get(i).getTenKhoa() %></option>
				<% }
			%>
		</select>
		<input type="submit" value="Xem" />
		<a style="text-decoration: none; padding: 5px 10px; background: blue; color: white" href="SVController?mode=add">ADD</a>
		<table border=1>
		<tr>
			<th>Ma SV</th>
			<th>Ho Ten</th>
			<th>Gioi tinh</th>
			<th>Khoa</th>
			<th></th>
		</tr>
	<%
		ArrayList<SinhVien> listSV = (ArrayList<SinhVien>)request.getAttribute("listSV");
		String status = (String)session.getAttribute("status");
		for(int i = 0; i < listSV.size(); i++) {
	%>
			<tr>
				<td><%= listSV.get(i).getIdSV()%></td>
				<td><%= listSV.get(i).getHoTen()%></td>
				<td><%= listSV.get(i).getGioiTinh()%></td>
				<td><%= listSV.get(i).getIdKhoa()%></td>
				<%if(status != null && status.equals("logined")) { %>
				<td>
					<a style="padding-right: 10px" href="SVController?mode=delete&idDelete=<%= listSV.get(i).getIdSV() %>">Delete</a>
					<a href="SVController?mode=update&idUpdate=<%= listSV.get(i).getIdSV() %>">Update</a>
				</td>
				<%} %>
			</tr>
	<%}%>
		</table>
	</form>
</body>
</html>