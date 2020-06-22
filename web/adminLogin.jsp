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
<body style="background:url('image/background.jpg')">
	<center>
		<br><br><br><br><br><br><br><br><br><br>
		<div class="panel panel-primary"  style="width:30%;">
			<div class="panel-heading">
				<h1 class="panel-title">登录</h1>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="login" method="post">
					<div class="form-group">
						<label class="col-sm-5 control-label">用户登录</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" name="adminID">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-5 control-label">登录密码</label>
						<div class="col-sm-6">
							<input class="form-control" type="password" name="adminPassword">
						</div>
					</div>
					<br>
					<input type="submit" value="登录">&nbsp;&nbsp;
					<input type="reset" value="重置">
					<h5>如果您尚未注册，请先进行<a href="register.jsp">&nbsp;注册&nbsp;</a></h5>
				</form>
			</div>
		</div>

	</center>
</center>
</body>
</html>