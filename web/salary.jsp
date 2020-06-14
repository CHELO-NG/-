<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="entity.*" %>
    <%@ page import="service.*" %>
    <%@ page import="serviceimpl.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理派送人员的薪水</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">
     <center><h1>财务管理</h1>
     <font size="3" color="#DC143C">多劳多得!</font>
     </center> 
  </div>
  <div class="body" id="body1">
     <div class="body_table">
<table align="center" border="0" width="750px" cellspacing="0">	
		<tr>
			<td><hr></td>
		</tr>
	</table>
	<table  align="center" border="1" width="750px" cellspacing="0">
			<tr>
				<th width="200px">派送人员编号</th>
				<th width="200px">派送人员姓名</th>
				<th width="200px">派送人员薪水</th>		
		        <th width="100px">操作</th>
		    </tr>
	  <%--  <%
			SalaryService s = new SalaryServiceImpl();
	        
			List<Salary> list = s.queryAllSalary();
			for(Salary sa: list){
	    %>  
	    	<tr>
	    		<td><%=sa.getName() %></td>
	    		<td><%=sa.getSex() %></td>
	    		<td><%=sa.getAge() %></td>
	    		<td><%=sa.getWeight() %></td>
	    		<td><%=sa.getHeight() %></td>
	    		<td>
	    			<a href="javascript:query(<%=stu.getId() %>)">查询详情</a>
	    			<a href="javascript:update(<%=stu.getId() %>)">修改</a>
	    			<a href="javascript:del(<%=stu.getId()%>)">删除</a>
	    		</td>
	    	</tr>
	  <%
	    	}

	    %>--%>   
	</table>
    </div>
  </div>
</body>
</html>