<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="entity.*" %>
   <%@ page import="service.*" %>
   <%@ page import="serviceimpl.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加派送人员结果</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<%
   	request.setCharacterEncoding("utf-8");

   	String courierCode = request.getParameter("courierCode");
   	String courierName = request.getParameter("courierName");
   	String courierPhone = request.getParameter("courierPhone");// String-->Util.Date

   	Courier cou = new Courier(courierCode,courierName,
   			courierPhone);	
   	CourierService ns = new CourierServiceImpl();
	int n = ns.addCourier(cou);
			
	if(n >0) {
		//添加成功
		response.sendRedirect("Courier.jsp"); 
		
	}else {
		//添加失败
		response.sendRedirect("addCourier.jsp"); 	
	}
%>

</body>
</html>