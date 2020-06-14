<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理货物信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<center>
<div class="header">
    <h1>添加货物信息</h1>
</div>
<div class="body" id="body1">
    <ul>
        <li><a href="logistics.jsp">返回主界面</a></li>
    </ul>
</div>
<div class="body" id="body2">
    <form method="post" action="doAdd.jsp" onsubmit="return check(this)">
        货单号&nbsp;<input type="text" name="goodsID" class="input1"><br><br>
        货物名称&nbsp;<input type="text" name="goodsName" class="input1"><br><br>
        发货地址&nbsp;<input type="text" name="goodsStart" class="input1"><br><br>
        到达地址&nbsp;<input type="text" name="goodsSend" class="input1"><br><br>
        发货人&nbsp;<input type="text" name="consigner" class="input1"><br><br>
        收货人&nbsp;<input type="text" name="consignee" class="input1"><br><br>
        收货人电话&nbsp;<input type="text" name="phone" class="input1"><br><br>    
        派送人员编号&nbsp;<input type="text" name="courierID" class="input1"><br><br>
        发货日期&nbsp;<input type="text" name="date" class="input1"><br><br>
       
       <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="取消">
    </form>

</div>
</center>
</body>
</html>