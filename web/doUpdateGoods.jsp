<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="entity.*" %>
   <%@ page import="service.*" %>
   <%@ page import="java.util.*" %>
   <%@ page import="serviceimpl.*" %>
   <%@page import="java.text.DateFormat,java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>保存修改货物信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<%
   	request.setCharacterEncoding("utf-8");
String goodsID = request.getParameter("goodsID");
	String goodsName = request.getParameter("goodsName");
	String goodsStart = request.getParameter("goodsStart");// String-->Util.Date
	String goodsSend = request.getParameter("goodsSend");
	String consigner = request.getParameter("consigner");
	String consignee = request.getParameter("consignee");
	String phone = request.getParameter("phone");
	String courierID = request.getParameter("courierID");
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Date date = df.parse("date");
	Goods goods = new Goods(goodsID,goodsName,goodsStart,goodsSend,
			consigner,consignee,phone,courierID,new java.sql.Date(date.getTime()));	
	GoodsService ns = new GoodsServiceImpl();
    int n = ns.addGoods(goods);
	if(n >0) {
		//修改成功
		response.getWriter().println("修改成功！");
		response.sendRedirect("updateGoods.jsp"); 
		
	}else {
		//修改失败
		response.getWriter().println("修改失败，即将返回修改页面！");
		response.sendRedirect("doUpdateGoods.jsp"); 	
	
	}
%>
</body>
</html>