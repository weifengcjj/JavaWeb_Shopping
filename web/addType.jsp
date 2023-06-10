<%@ page import="com.ygj.Service.Service" %>
<%@ page import="com.ygj.Model.Type" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>添加类型</title>
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
<body style="background-color: #e5e5e5">
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="zhuyeadmin">YGJ商城后台管理</a>
        </div>
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
                <h3>添加
                    <small>类型</small>
                </h3>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-3 col-xs-3">

        </div>
        <div class="col-md-6 col-xs-6">
            <div class="row">
                <form action="addtype" method="post">
                    <div class="modal-body">
                        <ul>
                            <li>
                                <label><span>请输入需要添加的商品类型&nbsp;: </span></label>
                                <input type="text" name="typename">
                            </li>
                        </ul>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary btn-sm">提交申请</button>
                    </div>
                </form>
            </div>
            <div class="row">
            </div>
        </div>
    </div>
</div>
</body>
</html>