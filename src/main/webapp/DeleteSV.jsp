<%@page import="model.bean.SinhVien"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% SinhVien nvUpdate = (SinhVien)request.getAttribute("svDelete"); %>
	<form method="Post" action="SVController?action=delete">
		<label style="display: block; width: 250px">Id sinh vien: </label>
		<input readonly type="text" name="idDelete" value="<%= nvUpdate.getIdSV() %>" /> <br />
		<label style="display: block; width: 250px">Ten sinh vien: </label>
		<input type="text" name="hoten" value="<%= nvUpdate.getHoTen() %>" /> <br />
		<label style="display: block; width: 250px">Gioi tinh: </label>
		<input type="text" name="gioitinh" value="<%= nvUpdate.getGioiTinh() %>" /> <br />
		<label style="display: block; width: 250px">Id khoa: </label>
		<input type="text" name="idKhoa" value="<%= nvUpdate.getIdKhoa() %>" /> <br />
		<input type="submit" value="Xac nhan xoa" />
	</form>
</body>
</html>