<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改派送人员信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<%	
	Courier courier = (Courier)request.getAttribute("courier");
%>
	<form action="doupdate" method="post">
		<input type="hidden" name="id" value="<%=courier.getCourierCode() %>">
		<table align="center">
			<tr>
				<td>派送人员编号</td>
				<td><input type="text" name="courierCode" value="<%=courier.getCourierCode()%>"></td>
			</tr>
			<tr>
				<td>派送人员姓名</td>
				<td><input type="text" name="courierName" value="<%=courier.getCourierName()%>"></td>
			</tr>
			<tr>
				<td>派送人员电话号码</td>
				<td><input type="text" name="courierPhone" value="<%=courier.getCourierPhone() %>"></td> 
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="保存修改">
				</td>
			</tr>
		</table>
	</form>

<br>
<center>
	<a href="courier.jsp">返回</a>
</center>
</body>
</html>