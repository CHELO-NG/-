<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改货物信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<%	
	Goods goods = (Goods)request.getAttribute("goods");
%>
	<form action="update" method="post">
		<input type="hidden" name="id" value="<%=goods.getGoodsID() %>">
		<table align="center">
			<tr>
				<td>货物名称</td>
				<td><input type="text" name="goodsName" value="<%=goods.getGoodsName()%>"></td>
			</tr>
			<tr>
				<td>发货地址</td>
				<td><input type="text" name="goodsStart" value="<%=goods.getGoodsStart()%>"></td>
			</tr>
			<tr>
				<td>收货地址</td>
				<td><input type="text" name="goodsSend" value="<%=goods.getGoodsSend() %>"></td> 
			</tr>
			<tr>
				<td>发货人</td>
				<td><input type="text" name="consigner" value="<%=goods.getConsigner()%>"></td>
			</tr>
			<tr>
				<td>收货人</td>
				<td><input type="text" name="consignee" value="<%=goods.getConsignee() %>"></td>
			</tr>
			<tr>
				<td>收货人电话</td>
				<td><input type="text" name="phone" value="<%=goods.getPhone() %>"></td>
			</tr>
			<tr>
				<td>派送人员编号</td>
				<td><input type="text" name="courierID" value="<%=goods.getCourierID() %>"></td>
			</tr>
			<tr>
				<td>发货时间</td>
				<td><input type="date" name="date" value="<%=goods.getDate() %>"></td>
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
	<a href="goods.jsp">返回</a>
</center>
</body>
</html>