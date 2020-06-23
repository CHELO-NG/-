<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>派送人员薪水</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="header">
    <center><h1>人员薪水管理</h1></center>
</div>
<div class="container" align="right">
    <a href="logout"  class="btn btn-info btn"><span class="glyphicon glyphicon-log-out">退出</span></a>
</div>
<br>
<center>
    <form class="form-inline" action="salary" role="form" onclick="window.opener.location.reload()">
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
            <th>派送人员编号</th>
            <th>派送人员姓名</th>
            <th>派送货物数量</th>
            <th>派送人员薪水</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${salary}" var="salary" varStatus="status">
            <tr>
                <td>${salary.courierID}</td>
                <td>${salary.courierName}</td>
                <td>${salary.count}</td>
                <td>${salary.courierSalary}</td>
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
