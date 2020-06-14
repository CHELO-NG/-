<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理员登录界面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<script language="javascript">
	function validateLogin() {
		var aId = document.frmLogin.aid.value;
		var password = document.frmLogin.password.value;
		if ((aId == "") || (aId == "输入管理员用户名")) {
			alert("请输入用户名!");
			return false;
		}
		if ((password == "") || (password == "输入管理员密码")) {
			alert("请输入密码!");
			return false;
		}
	}
</script>
<body>
<center>
        <font face="楷体" size="10" color="#FFD700">18130047班物流派送管理</font><br>
		<font face="楷体" size="6" color="#000">登录界面</font>
		<form action="Login_check.jsp" method="post" name="frmLogin">
			<table width="300" height="180" border="5" bordercolor="#A0A0A0">
				<tr>
					<th>用户名：</th>
					<td><input type="text" name="aid" value="输入物流管理员用户名"
						maxlength="16"
						οnfοcus="if(this.value == '输入管理员用户名') this.value =''"></td>
				</tr>
				<tr>
					<th>密  码：</th>
					<td><input type="text" name="apassword" value="输入物流管理员密码"
						maxlength="20" 
						οnfοcus="if(this.value == '输入管理员密码') this.value =''">
						</td>
				</tr>
				<tr>
					<!-- 当点击登录则需要在Login_check.jsp进行判断,点击注册会跳转到注册界面 -->
					<td colspan="2" align="center">
					<input type="submit" value="登录" οnclick="return validateLogin()"> 
					
					<input type="reset" value="重  置"></td>
				</tr>
			</table>
		</form>
		<a href="register.jsp">还没有账号？点击这里进行注册</a>
</center>
</body>
</html>