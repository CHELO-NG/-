<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
            <li><a href="goods">返回主界面</a></li>
        </ul>
    </div>
    <form class="form-horizontal" role="form" method="post" action="addGoods">
        <div class="form-group">
            <label class="col-sm-2 control-label">货物名称</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="goodsName">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">发货地址</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="goodsStart">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">到达地址</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="goodsSend">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">发货人</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="consigner">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">收货人</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="consignee">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">收货人电话</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="phone">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">派送人员编号</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="courierID">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">派送人员电话</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="courierPhone">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">发货日期</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="date">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">送货状态</label>
            <div class="col-sm-10">
                <select class="form-control" name="goodsState">
                    <option value="待配送">待配送</option>
                    <option value="配送中">配送中</option>
                    <option value="已签收">已签收</option>
                    <option value="已退货">已退货</option>
                </select>
            </div>
        </div>

        <input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="取消">
    </form>

</center>
</body>
</html>