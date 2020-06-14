<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>物流管理系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
		function del(id){
			var flag = window.confirm("是否真的要删除？");
			if(flag){
				window.location.href = "delete.jsp?id=" + id;
			}
		}
		function update(id){
			window.location.href = "doUpdateStudent.jsp?id=" + id;
		}
		function query(id){
			window.location.href = "select.jsp?id=" + id;
		}
	</script>
</head>
<body>
 <div class="header">
     <center><h1>物流派送信息管理系统</h1></center> 
  </div>
  <div class="body" id="body1">
    <ul>
     
      <li><a href="add.jsp">添加派送信息</a></li>
      <li><a href="adminLogin.jsp">返回管理员登录界面</a></li>
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
				
				<th width="200px">派送物件编号</th>
				<th width="200px">派送人员编号</th>
				<th width="200px">顾客姓名</th>
				<th width="200px">发货地址</th>
				<th width="200px">到达地址</th>
				<th width="200px">顾客电话号码</th>
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