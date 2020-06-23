<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="entity.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>修改货物信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            function sel(goodsState) {
                if (goodsState == "待配送") {
                    $("#goodsState option[ value='待配送']").attr("selected", true);
                    $("#goodsState").selectpicker('refresh');
                } else if (goodsState == "配送中") {
                    $("#goodsState option[ value='配送中']").attr("selected", true);
                    $("#goodsState").selectpicker('refresh');
                } else if (goodsState == "已签收") {
                    $("#goodsState option[ value='已签收']").attr("selected", true);
                    $("#goodsState").selectpicker('refresh');
                } else if (goodsState == "已退货") {
                    $("#goodsState option[ value='已退货']").attr("selected", true);
                    $("#goodsState").selectpicker('refresh');
                }
            }
        })

    </script>
</head>
<body>
<%
    Goods goods = (Goods) request.getAttribute("goods");
%>
<center>
    <form class="form-horizontal" role="form" method="post" action="updateGoods">

        <input type="hidden" name="goodsID" value="<%=goods.getGoodsID() %>">
        <div class="form-group">
            <label class="col-sm-2 control-label">货单号</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="goodsID" value="<%=goods.getGoodsID() %>" disabled>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">货物名称</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="goodsName" value="<%=goods.getGoodsName()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">发货地址</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="goodsStart" value="<%=goods.getGoodsStart()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">到达地址</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="goodsSend" value="<%=goods.getGoodsSend() %>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">发货人</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="consigner" value="<%=goods.getConsigner()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">收货人</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="consignee"
                       value="<%=goods.getConsignee() %>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">收货人电话</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="phone" value="<%=goods.getPhone() %>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">派送人员编号</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="courierID" value="<%=goods.getCourierID() %>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">派送人员电话</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="courierPhone" value="<%=goods.getCourierPhone()%>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">发货日期</label>
            <div class="col-sm-10">
                <input class="form-control" type="date" name="date" value="<%=goods.getDate()%>">
            </div>
        </div>
        <div class=" form-group">
            <label class="col-sm-2 control-label">送货状态</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="goodsState" value="<%=goods.getGoodsState()%>">
                <span class="help-block">请输入 待配送/配送中/已签收/已退货</span>
            </div>
        </div>
        <input type="submit" value="提交">
        <input type="reset" value="取消">
    </form>
</center>
<br>
<center>
    <a href="goods">返回</a>
</center>
</body>
</html>