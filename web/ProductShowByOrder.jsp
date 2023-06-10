<%@ page import="com.ygj.Service.Service" %>
<%@ page import="com.ygj.Model.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ygj.Model.User" %>
<%@ page import="com.ygj.Service.ProService" %>
<%@ page import="com.ygj.Model.Product" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>订单详情</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .title-text {
            font-size: 20px;
            font-weight: 600;
            color: #8E2323;
            text-align: center;
            height: 39px;
        }
        .title-tit {
            font-size: 15px;
            font-weight: 500;
            color: #8E2323;
            text-align: center;
            height: 20px;
        }
        .title-tex {
            text-align: center;
        }
        .search #in{
            width:254px;
            height:30px;
            border:2px solid red;
            outline:none;
            font:14px/30px "microsoft yahei";
        }
        .search .btn_search{
            background:red;
            width:50px;
            height:34px;
            color:white;
            border:none;
            outline:none;
            font:14px/34px "microsoft yahei";
        }
    </style>
</head>
<body style="background-color: #e5e5e5">
<%--<%--%>
<%--    ProService ps=new ProService();--%>
<%--    List<Product> list=new ArrayList<>();--%>
<%--    list=ps.getallpro();--%>
<%--    request.getSession().setAttribute("allpro",list);%>--%>
<!--头部-->
<nav class="navbar navbar-default" role="navigation" style="position: sticky;top: 0;background-color:darkturquoise;z-index:999">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="zhuye">YGJ商城</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="showper"><span class="glyphicon glyphicon-user"></span>用户:${user.getUser()}</a></li>
            <li><a href="exitlogin"><span class="glyphicon glyphicon-log-in"></span>退出登录</a></li>
        </ul>
    </div>
</nav>
<!--导航条-->
<div class="container">
    <div class="row">
        <div class="col-md-11 col-xs-11">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-2 col-xs-2">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="zhuye">首页</a>
                            </div>
                        </div>
                        <div class="col-md-2 col-xs-2">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="getcar">我的购物车</a>
                            </div>
                        </div>
                        <div class="col-md-2 col-xs-2">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="getorder">我的订单</a>
                            </div>
                        </div>
                        <div class="col-md-4 col-xs-4">
                            <div class="navbar-header">
                                <form action="search" method="post">
                                    <div class="search">
                                        <input type="text" id="in"  name="search" placeholder="搜索热点"/>
                                        <button type="submit" class="btn_search">搜索</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div>
                            <div class="col-md-2 col-xs-2">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle"
                                            data-toggle="dropdown">
                                        我的中心 <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li class="divider"></li>
                                        <li><a href="showper">查看个人信息</a></li>
                                        <li><a href="tosetper">修改个人信息</a></li>
                                        <li><a href="tosetpwd">修改密码</a></li>
                                    </ul>
                                </div>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

            </nav>
        </div>
    </div>
</div>
</div>
<%--购物车--%>
<div class="container">
    <div class="row">
        <div class="col-md-9 col-xs-9">
            <div class="row">
                <c:forEach items="${probyorderlist}" var="mode" varStatus="id2">
                    <form action="repro" method="post">
                        <div class="col-md-3 col-xs-3">
                            <a href="soletest.do?name=${mode.getP().getId()}" style="text-decoration: none;">
                                <img style="width: 100px;height: 100px; margin-left: 50px;" src="${mode.getP().getImg()}"/>
                            </a>
                            <p>
                            <h3 class="title-tit" style="CURSOR:pointer">${mode.getP().getName()}</h3>
                            </p>
                            <p class="title-text">单价：￥${mode.getP().getPrice()}</p>
                            <p class="title-text">${mode.getP().getDesc()}</p>
                            <p class="title-text">数量：${mode.getSum()}</p>
                            <input type="hidden" name="revalue" value="${mode.getId()}">
<%--                            <input style="margin: auto" type="submit" value="删除">--%>
                        </div>
                    </form>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<!--分行-->
<div class="row">
</div>
<!--结尾-->
<div class="row">
    <div class="col-md-12 col-xs-12 bg-success">
        <div class="row">
            <div class="col-md-10 col-xs-10 col-md-offset-1 col-xs-offset-1">
                <div class="row">
                    <div class="col-md-2 col-xs-2 col-md-offset-1 col-xs-offset-1 bg-success">
                        <h1 class="title-text">YGJ商城</h1>
                    </div>
                    <div class="col-md-3 col-xs-3 bg-success">
                        <h3 class="title-text">关于商城</h3>
                        <h5 class="title-tex">最新消息</h5>
                        <h5 class="title-tex">经营范畴</h5>
                        <h5 class="title-tex">质量保证</h5>
                        <h5 class="title-tex">社会责任</h5>
                    </div>
                    <div class="col-md-2 col-xs-2 bg-success">
                        <h3 class="title-text">投资者关系</h3>
                        <h5 class="title-tex">蒲公英</h5>
                        <h5 class="title-tex">一楼公告</h5>
                    </div>
                    <div class="col-md-2 col-xs-2 bg-success">
                        <h3 class="title-text">关注我们</h3>

                        <h5 class="title-tex">信息技术系</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
