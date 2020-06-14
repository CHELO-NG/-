<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>货物状态管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">
     <center><h1>派送事务管理</h1></center> 
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
				<th width="200px">管理员编号</th>
				<th width="200px">派送物件编号</th>
				<th width="200px">货物状态</th>		
		        <th width="200px">修改货物状态</th>
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