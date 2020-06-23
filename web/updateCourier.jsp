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
<center>
	<form  class="form-horizontal" role="form" method="post" action="updateCourier">
		<div class="form-group">
			<label class="col-sm-2 control-label">派送人员编号</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" name="courierID" value="<%=courier.getCourierID()%> "disabled >
			</div>
		</div>
		<input type="hidden" name="courierID" value="<%=courier.getCourierID()%>">
		<div class="form-group">
			<label class="col-sm-2 control-label">派送人员姓名</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" name="courierName" value="<%=courier.getCourierName()%>">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">派送人员电话</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" name="courierPhone" value="<%=courier.getCourierPhone()%>">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">派送人员负责区域</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" name="courierArea" value="<%=courier.getCourierArea()%>">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">派送人员薪水</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" name="courierSalary" value="<%=courier.getCourierSalary()%>">
			</div>
		</div>
		<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="取消">
	</form>
</center>

<br>
<center>
	<a href="courier">返回</a>
</center>
</body>
</html>