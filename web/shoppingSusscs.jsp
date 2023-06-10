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
    <title>商城首页</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/public.css">
    <link rel="stylesheet" href="css/publicstyle.css">
    <style>
        body{
            width: 100%;
            height: 100%;
            position: relative;
        }
        .title-text {
            font-size: 20px;
            font-weight: 600;
            color: #8E2323;
            text-align: center;
            height: 39px;
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

        .solediv{
            position: relative;
            float: left;
            width: 232px;
            height: 160px;
            margin: 0 0 10px 10px;
            overflow: hidden;
            color: #333;
            background-color: #f7f9fa;
            border: 1px solid #f7f9fa;
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            border-radius: 10px;
            cursor: pointer;
            -webkit-transition: all 0.5s;
            -o-transition: all 0.5s;
            -moz-transition: all 0.5s;
            transition: all 0.5s;
        }
        .solediv:hover{
            border: 2px solid lightseagreen;
        }
        .img-war{
            position: absolute;
            width: 85px;
            height: 85px;
            overflow: hidden;
            background-color: rgba(27, 23, 67, 0.03);
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            border-radius: 10px;
        }
        .img11 {
            display: block;
            width: 100%;
            height: 100%;
            -webkit-border-radius: 10px;
            -moz-border-radius: 10px;
            border-radius: 10px;
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
        <div class="col-md-12 col-xs-12">
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
<!--轮播图-->
<div class="container">
    <div class="row">
        <div class="col-md-1 col-xs-1">
            <ul class="nav nav-pills nav-stacked">
                <c:forEach items="${getalltype}" var="modelss" varStatus="id1">
                    <%--    <a class="a1" href="pro.do?name=0">All</a>--%>
                    <%--    <a class="a1" href="pro.do?name=1">life</a>--%>
                    <%--    <a class="a1" href="pro.do?name=2">ShouJi</a>--%>
                    <%--    <a class="a1" href="pro.do?name=3">food</a>--%>
                    <li><a href="pro.do?name=${modelss.getTypeId()}">${modelss.getTypeName()}</a></li>
                </c:forEach>
                <%--                <li><a href="#">文学</a></li>--%>
                <%--                <li><a href="#">名著</a></li>--%>
                <%--                <li><a href="#">科技</a></li>--%>
            </ul>
        </div>
        <div class="col-md-8 col-xs-8">
            <c:forEach items="${allpro}" var="mode" varStatus="id2">
                <div class="solediv">
                    <a class="aa" href="soletest.do?name=${mode.getId()}" style="text-decoration: none;    display: inline-block;width: 100%;height: 100%;padding: 11px;">
                        <div class="img-war">
                            <image class="img11" src="${mode.getImg()}"></image>
                        </div>
                        <div style="height: 86px;margin-left: 92px;overflow: hidden;">
                            <div style="display: inline-block;max-height: 30px;margin: 6px 0 2px 0; white-space: nowrap;overflow: hidden;text-overflow: ellipsis;color: #333;font-size: 14px;line-height: 15px;">
                                    ${mode.getName()}
                            </div>
                            <div style="height: 15px;overflow: hidden;"></div>
                        </div>
                        <div style="margin-left: 92px;color: #ff5000;">
                        <span style="display: inline-block;font-size: 20px;line-height: 20px;">
                        <em>￥</em>
                        ${mode.getPrice()}
                        </span>
                        </div>
                    </a>

                </div>


            </c:forEach>
        </div>
        <div class="col-md-3 col-xs-3">
            <h5 style="margin-left:5px;">最新动态</h5>
            <ul>
                <li style="margin-top: 10px"><a target="_blank" href="http://cpc.people.com.cn/n1/2023/0311/c64094-32641777.html">习近平当选为中华人民共和国主席</a></li>
                <li style="margin-top: 10px"><a target="_blank" href="https://www.163.com/dy/article/HVHU8THL0529MKNM.html">董明珠:大学生打螺钉没什么不可以</a></li>
                <li style="margin-top: 10px"><a target="_blank" href="https://baijiahao.baidu.com/s?id=1760023608923429853">委员称年轻人想躺平更多是调侃</a></li>
            </ul>
        </div>
    </div>
</div>
<!--分行-->
<div class="container">
    <div class="row">
        <div class="col-md-11 col-xs-11">
            <div class="page-header">
                <h3>精选
                    <small>商品</small>
                </h3>
            </div>
        </div>
    </div>
</div>
<!--精选-->
<div class="container">
    <div class="row">
        <div class="col-md-9 col-xs-9">
            <div class="picshow">
                <!-- 大图 -->
                <div class="bigimg">
                    <ul class="imgUl"  id="imgUl">
                        <c:forEach items="${proimg}" var="mode" varStatus="id2">
                            <li><a  href="soletest.do?name=${mode.getId()}"><img class="img13" src="${mode.getImg()}" alt=""></a></li>
                        </c:forEach>
                        <%--                        <li><a href="#"><img class="img13" src="image/2046582.jpg" alt=""></a></li>--%>
                        <%--                        <li><a href="#"><img class="img13" src="image/2046582.jpg" alt=""></a></li>--%>
                    </ul>
                </div>
                <!-- 大图 end -->

                <!-- 控制块 -->
                <div class="control"  id="ctrl">
                    <c:forEach items="${proimg}" var="mode" varStatus="id2">
                        <a href="javascript:void(0)" index="${mode.getId()}"></a>
                    </c:forEach>
                </div>
                <!-- 控制块 end -->
            </div>

        </div>
    </div>
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
<script>
    // JavaScript Document
    var ctrl = document.getElementById("ctrl");
    var imgUl = document.getElementById("imgUl");
    // var  a = ctrl.children;
    var a = ctrl.getElementsByTagName("a");
    for(var i = 0 ; i <= a.length-1 ; i++){
        // 【关键】标签存储当前的索引值

        a[i].onmouseover = function(){
            // console.info("OK");
            // 把所有的标签，都变成普通样子。
            allElements();
            this.className = "current";  //  突出当前标签

            var index = this.getAttribute("index");
            imgUl.style.marginLeft = -700*index + "px";
        }
    }
    //  操作所有标签复原。
    function  allElements(){
        for(var k=0 ; k <= a.length-1 ; k++){
            a[k].className = "";  // 去掉类，复原
        }
    }

</script>
