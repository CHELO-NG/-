<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改货物状态信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function suc() {
		alert("修改成功！！！");
	}
</script>
</head>
<body>
<form action="doUpdateState.jsp" method="post">
		<table align="center">
			<tr>
			<td>货物派送结果</td>
			<td><input type="number" name="height" value="<%--<%=stu.getHeight() %> --%>"></td></tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="保存修改" onclick="suc()">
				</td>
			</tr>
		</table>
	</form>

<br>
<center>
	<a href="selectall.jsp">返回</a>
</center>
</body>
</html>