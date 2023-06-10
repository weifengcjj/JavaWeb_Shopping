<%@ page import="com.ygj.Service.ProService" %>
<%@ page import="com.ygj.Model.Product" %>
<%@ page import="com.ygj.Service.Service" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ygj.Model.Type" %>
<%@ page import="com.ygj.Model.Order" %>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>管理订单</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .navbar-brand:hover{
            background-image: linear-gradient(to right, #ebccd1 0%, #a6e1ec 0%, #c9e2b3 0%, #fff9ec 30%, #c2ce9c 64%, #7edbdc 100%);
        }
    </style>
</head>
<%
    ProService ps=new ProService();
    List<Order> allorder = ps.findAllorder();
    request.getSession().setAttribute("findAllorder",allorder);
%>
<body style="background-color: #e5e5e5">
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="zhuyeadmin">YGJ商城后台管理</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span>管理员:${user.getUser()}</a></li>
            <li><a href="exitlogin"><span class="glyphicon glyphicon-log-in"></span>退出登录</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-11 col-xs-11">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-2 col-xs-2">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="zhuyeadmin">首页</a>
                            </div>
                        </div>
                        <div class="col-md-2 col-xs-2">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="addPro.jsp">添加商品</a>
                            </div>
                        </div>
                        <div class="col-md-2 col-xs-2">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="addType.jsp">添加类别</a>
                            </div>
                        </div>
                        <div>
                            <div class="col-md-2 col-xs-2">
                                <div class="navbar-header">
                                    <a class="navbar-brand" href="manageUser.jsp">管理用户</a>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="col-md-2 col-xs-2">
                                <div class="navbar-header">
                                    <a class="navbar-brand" href="PayOrderAdmin.jsp">查看订单</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</div>
<!--分-->
<div class="container">
    <div class="row">
        <div class="col-md-11 col-xs-11">
            <div class="page-header">
                <h3>管理
                    <small>后台</small>
                </h3>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-12 col-xs-12">
            <div class="row">
                <table class="table table-hover table-bordered" id="aa">
                    <tr>
                        <th style="text-align: center;width: 300px;height: 40px;">订单号</th>
                        <th style="text-align: center;width: 300px;height: 40px;">订单总价</th>
                        <th style="text-align: center;width: 300px;height: 40px;">订单用户</th>
                        <th style="text-align: center;width: 500px;height: 40px;">订单创建时间</th>
                        <th style="text-align: center;width: 500px;height: 40px;">订单状态</th>
                        <th style="text-align: center;width: 500px;height: 40px;">操作</th>
                    </tr>
                    <c:forEach items="${findAllorder}" var="mode" varStatus="id2">
                        <form action="fahuo" method="post">
                            <tr>
                                <td style="background-color: skyblue;width: 300px;height: 40px;" >${mode.getOrdernum()}</td>
                                <td style="background-color: lavender;width: 300px;height: 40px;">￥${mode.getOrderprice()}</td>
                                <td style="background-color: skyblue;width: 300px;height: 40px;">${mode.getOrderuser().getUser()}</td>
                                <td style="background-color: springgreen;width: 600px;height: 40px;">${mode.getOrderdatetime()}</td>
                                <td style="background-color: springgreen;width: 600px;height: 40px;">${mode.getFlag().getFlagName()}</td>
                                <input type="hidden" name="flagid" value="${mode.getFlag().getId()}"/>
                                <input type="hidden" name="fahuo" value="${mode.getOrderid()}"/>
                                <td style="background-color: springgreen;width: 600px;height: 30px;"><input type="submit" value="发货"></td>
                        </form>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%--<c:forEach items="${alluser}" var="modelss" varStatus="id1">--%>
<%--    <form>--%>
<%--        <tr align="center" class="success" style="text-align: center;width:100px;height: 60px;">--%>
<%--            <td style="background-color: skyblue">${modelss.getId()}</td>--%>
<%--            <td style="background-color: skyblue">${modelss.getUser()}</td>--%>
<%--            <td style="background-color: skyblue">${modelss.getEmail()}</td>--%>
<%--            <td style="background-color: skyblue">${modelss.getDatetime()}</td>--%>
<%--            <td style="background-color:darkorchid;width: 180px;">--%>
<%--                <input type="hidden" name="id" value="${modelss.getId()}"/>--%>
<%--                <input type="submit"  value="Delete"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </form>--%>
<%--    <br/>--%>
<%--</c:forEach>--%>
