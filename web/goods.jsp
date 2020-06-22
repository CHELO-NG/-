<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>货物信息管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function del(goodsID){
            var flag = window.confirm("是否真的要删除？");
            if(flag){
                window.location.href = "deleteGoods?goodsID=" + goodsID;
            }
        }
        function update(goodsID){
            window.location.href = "queryGoods?goodsID=" + goodsID +"&flag=1";
        }
        function query(goodsID){
            window.location.href = "queryGoods?goodsID=" + goodsID +"&flag=0";
        }
        $(function () {
            function setClass()
            {
                var style=document.getElementById("style");
                var d=document.getElementById("dataTable");
                if(d.innerText=="待配送"){
                    style.setAttribute("class","active");
                    style.setAttribute("className","active");
                }else if(d.innerText=="已签收"){
                    style.setAttribute("class","success");
                    style.setAttribute("className","success");
                }else if(d.innerText=="配送中"){
                    style.setAttribute("class","warning");
                    style.setAttribute("className","warning");
                }else if(d.innerText=="已退货"){
                    style.setAttribute("class","danger");
                    style.setAttribute("className","danger");
                }
            }
        })

        $(function () {
            $("table.pagination tr.disabled a").click(function () {
                return false;
            });
        });
    </script>
</head>
<body>
<div class="header">
    <center><h1>货物信息管理</h1></center>
</div>
<div class="container" align="right">
    <a href="addGoods.jsp" class="btn btn-info btn"><span class="glyphicon glyphicon-plus"></span></a>
    <a href="logout" class="btn btn-info btn"><span class="glyphicon glyphicon-log-out">退出</span></a>
</div>
<br>
<center>
    <form class="form-inline" action="goods" role="form" onclick="window.opener.location.reload()" >
        <div class="form-group">
            <input type="text" class="form-control" name="keywords" placeholder="请输入查询关键词">
            &nbsp;&nbsp;
            <button type="submit" class="btn btn-default">查询</button>
        </div>

    </form>
</center>
<br>
<div class="listDIV">
    <table class="table table-striped table-bordered table-hover table-condensed">
		<thead>
        <tr>
            <th>货单号</th>
            <th>货物名称</th>
            <th>发货地址</th>
            <th>到达地址</th>
            <th>发货人</th>
            <th>收货人</th>
            <th>收货人电话</th>
            <th>派送人员编号</th>
            <th>派送人员电话</th>
            <th>发货日期</th>
            <th>派送状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${goods}" var="goods" varStatus="status">
            <tr id="style" href="javascript:setClass()">
                <td>${goods.goodsID}</td>
                <td>${goods.goodsName}</td>
                <td>${goods.goodsStart}</td>
                <td>${goods.goodsSend}</td>
                <td>${goods.consigner}</td>
                <td>${goods.consignee}</td>
                <td>${goods.phone}</td>
                <td>${goods.courierID}</td>
                <td>${goods.courierPhone}</td>
                <td>${goods.date}</td>
                <td id="dataTable">${goods.goodsState}</td>
                <td>
                    <a href="javascript:update(${goods.goodsID})"><span
                            class="glyphicon glyphicon-edit"></span></a>&nbsp&nbsp&nbsp&nbsp
                    <a href="javascript:del(${goods.goodsID})"><span
                            class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<center>
    <nav class="pageDIV">
        <ul class="pagination">
            <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
                <a href="?page.start=0">
                    <span>«</span>
                </a>
            </li>

            <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
                <a href="?page.start=${page.start-page.count}">
                    <span>‹</span>
                </a>
            </li>

            <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
                <c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
                    <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                        <a href="?page.start=${status.index*page.count}"
                           <c:if test="${status.index*page.count==page.start}">class="current"</c:if>
                        >${status.count}</a>
                    </li>
                </c:if>
            </c:forEach>

            <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                <a href="?page.start=${page.start+page.count}">
                    <span>›</span>
                </a>
            </li>
            <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
                <a href="?page.start=${page.last}">
                    <span>»</span>
                </a>
            </li>
        </ul>
    </nav>
    <br><br><br>
    <em>
        Copyright &copy;
        18130047 程龙/李阳/李鑫 制作,Logistics delivery management system,2020
    </em>
</center>

</body>
</html>