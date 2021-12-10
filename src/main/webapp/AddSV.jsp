<%@page import="model.bean.SinhVien"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="Post" action="SVController?action=add">
		<label style="display: block; width: 250px">Id sinh vien: </label>
		<input type="text" name="idSV"  /> <br />
		<label style="display: block; width: 250px">Ten sinh vien: </label>
		<input type="text" name="hoten"  /> <br />
		<label style="display: block; width: 250px">Gioi tinh: </label>
		<input name="gioitinh" type="radio" value="Nam" />
		<label>Nam</label>
		<input name="gioitinh" type="radio" value="Nu" />
		<label>Nu</label><br />
		<label style="display: block; width: 250px">Id khoa: </label>
		<input type="text" name="idKhoa" /> <br />
		<input type="submit" value="Add" />
	</form>
</body>
</html>