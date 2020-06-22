<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>物流派送系统之管理员注册页面</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function check_register(myform) {
            if (myform.adminID.value == ""
                || myform.adminPasswordv.value == "" || myform.adminPassword2.value == "") {
                alert("登录ID、真实姓名、密码必须全部填写！");
                return false;
            }
            if (myform.adminPassword.value.length < 6
                || myform.adminPassword.value.length < 6) {
                alert("您的密码长度小于6！");
                return false;
            }
            if (myform.adminPassword.value != myform.adminPassword2.value) {
                alert("您两次输入的密码不一致！");
                return false;
            }

            return true;
        }
    </script>
</head>
<body style="background:url('image/background.jpg')">
<center>
    <br><br><br><br><br><br><br><br><br><br>
    <div class="panel panel-primary"  style="width:30%;">
        <div class="panel-heading">
            <h1 class="panel-title">注册</h1>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" action="register" method="post" onSubmit="return check_register(this)">
                <div class="form-group">
                    <label class="col-sm-5 control-label">用户ID</label>
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
                <div class="form-group">
                    <label class="col-sm-5 control-label">确认密码</label>
                    <div class="col-sm-6">
                        <input class="form-control" type="password" name="adminPassword2">
                    </div>
                </div>
                <br>
                <input type="submit" value="登录">&nbsp;&nbsp;
                <input type="reset" value="重置">
                <h5><a href="adminLogin.jsp">&nbsp;返回登录页面&nbsp;</a></h5>
            </form>
        </div>
    </div>

</center>
</center>
</body>