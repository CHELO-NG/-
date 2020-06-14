<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>派送人员信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">
     <center><h1>派送人员信息</h1></center> 
  </div>
  <div class="body" id="body1">
    <ul>
      <li><a href="addCourier.jsp">添加派送人员信息</a></li>
    </ul>
  </div>
  <div class="body" id="body2">
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
				<th width="200px">派送人员电话号码</th>
				<th width="200px">派送人员负责区域</th>		
		        <th width="100px">操作</th>
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