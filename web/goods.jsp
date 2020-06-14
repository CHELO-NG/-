<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>货物信息管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">
     <center><h1>货物信息管理</h1></center> 
  </div>
  <div class="body" id="body1">
    <ul>
       <li><a href="addGoods.jsp">新添加货物</a></li>
    </ul>
  </div>
  <div class="body" id="body2">
     <div class="body_table">
<table align="center" border="0" width="1200px" cellspacing="0">	
		<tr>
			<td><hr></td>
		</tr>
	</table>
	<table  align="center" border="1" width="1200px" cellspacing="0">
			<tr>
				<th width="250px">货单号</th>
				<th width="250px">货物名称</th>
				<th width="250px">发货地址</th>
				<th width="250px">到达地址</th>	
			    <th width="250px">发货人</th>
			    <th width="250px">收货人</th>
			    <th width="250px">收货人电话</th>
			    <th width="250px">派送人员编号</th>
			    <th width="250px">发货日期</th>
			    <th width="250px">派送状态</th>
		        <th width="150px">操作</th>
		    </tr>
	   <%-- <%
			StudentService ns = new StudentServiceImpl();
			List<Student> list = ns.queryAllStudent();
			for(Student stu: list){
	    %>  
	    	<tr>
	    		<td><%=stu.getName() %></td>
	    		<td><%=stu.getSex() %></td>
	    		<td><%=stu.getAge() %></td>
	    		<td><%=stu.getWeight() %></td>
	    		<td><%=stu.getHeight() %></td>
	    		<td>
	    			<a href="javascript:query(<%=stu.getId() %>)">查询详情</a>
	    			<a href="javascript:update(<%=stu.getId() %>)">修改</a>
	    			<a href="javascript:del(<%=stu.getId()%>)">删除</a>
	    		</td>
	    	</tr>--%>
	 <%--  <%
	    	}

	    %>--%>   
	</table>
    </div>
  </div>
</body>
</html>