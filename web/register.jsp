<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>物流派送系统之管理员注册页面</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function check_register(myform){
		if(myform.aid.value=="" || myform.aname.value==""
				   || myform.apassword.value=="" || myform.apassword2.value==""){
			 alert("登录ID、真实姓名、密码必须全部填写！");
			return false;
		}
		if(myform.apassword.value.length < 6 
				|| myform.apassword2.value.length < 6){
		   alert("您的密码长度小于6！");
		   return false;
		}
		if(myform.upassword.value != myform.apassword2.value){
		   alert("您两次输入的密码不一致！");
		   return false;
		}
		
		var reg = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;  
		
		if (!reg.test(myform.aemail.value))
		{
		    alert("您输入的邮件地址格式有误！");
		    return false;
		}
		
		return true;
	}
</script>
</head>
<body>
<center>
  <h1>注册操作</h1>
  <hr>
  <form action="register_check.jsp" method="post" onSubmit="return check_register(this)">
    <table border="1">
      <tr>
        <td colspan="2" align="center">管理员注册</td>   
      </tr>
      <tr>
        <td align="right">登录ID：</td>
        <td><input type="text" name="aid"></td>
      </tr>
      <tr>
        <td align="right">真实姓名：</td>
        <td><input type="text" name="aname"></td>
      </tr>      
	  <tr>
		<td align="right">性&nbsp;&nbsp;&nbsp;别：</td>
		<td>
			<input type="radio" name="asex" value="男" checked>男
			<input type="radio" name="asex" value="女">女
		</td>
	  </tr>
     <tr>
        <td align="right">登录密码：</td>
        <td><input type="password" name="apassword"></td>
      </tr>
      <tr>
        <td align="right">确认密码：</td>
        <td><input type="password" name="apassword2"></td>
      </tr>
      <tr>
        <td colspan="2">
          &nbsp;&nbsp;<input type="submit" value="注册">&nbsp;&nbsp;
          <input type="reset" value="重置"> 
        </td>   
      </tr>
    </table>
  </form>
  <h5><a href="Login.jsp">&nbsp;返回登录页面&nbsp;</a></h5>
  
</center>
</body>