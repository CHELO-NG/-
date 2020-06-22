<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>登录程序之登注册成功页面</title>
</head>
<body>
    <h2>恭喜您--注册成功！</h2>
    
    <h4>5秒后自动跳转到登录页面</h4>
<%
	response.setHeader("refresh", "5;adminLogin.jsp");
%>    

</body>
</html>