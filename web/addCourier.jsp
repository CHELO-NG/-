<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>添加派送员信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<center>
    <div class="header">
        <h1>添加派送员信息</h1>
    </div>
    <div class="body" id="body1">
        <ul>
            <li><a href="courier">返回主界面</a></li>
        </ul>
    </div>

    <form  class="form-horizontal" role="form" method="post" action="addCourier">
        <div class="form-group">
            <label class="col-sm-2 control-label">派送人员姓名</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="courierName">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">派送人员电话</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="courierPhone">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">派送人员负责区域</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="courierArea">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">派送人员薪水</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="courierSalary">
            </div>
        </div>
        <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="取消">
    </form>

</center>
</body>
</html>