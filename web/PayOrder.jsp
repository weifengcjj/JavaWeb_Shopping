<%@ page import="com.ygj.Service.Service" %>
<%@ page import="com.ygj.Model.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ygj.Model.User" %>
<%@ page import="com.ygj.Service.ProService" %>
<%@ page import="com.ygj.Model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ygj.Model.Order" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8">
  <title>我的订单</title>
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
<%
  User user = (User) request.getSession().getAttribute("user");//订单用户
  ProService ps=new ProService();

  List<Order> findorder = ps.findorder(user.getId());
  request.getSession().setAttribute("findorder",findorder);

%>
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
      <div class="row">
        <div class="col-md-12 col-xs-12">
        <table class="table table-hover table-bordered" id="aa">
          <tr>
            <th style="text-align: center;width: 300px;height: 40px;">订单号</th>
            <th style="text-align: center;width: 300px;height: 40px;">订单总价</th>
            <th style="text-align: center;width: 300px;height: 40px;">订单用户</th>
            <th style="text-align: center;width: 500px;height: 40px;">订单创建时间</th>
            <th style="text-align: center;width: 500px;height: 40px;">地址</th>
            <th style="text-align: center;width: 500px;height: 40px;">订单状态</th>
            <th style="text-align: center;width: 500px;height: 40px;">操作</th>
            <th style="text-align: center;width: 500px;height: 40px;">查看详情</th>
          </tr>
        <c:forEach items="${findorder}" var="mode" varStatus="id2">

          <tr>
            <td style="background-color: skyblue;width: 300px;height: 40px;" >${mode.getOrdernum()}</td>
            <td style="background-color: lavender;width: 300px;height: 40px;">￥${mode.getOrderprice()}</td>
            <td style="background-color: skyblue;width: 300px;height: 40px;">${mode.getOrderuser().getUser()}</td>
            <td style="background-color: azure;width: 600px;height: 40px;">${mode.getOrderdatetime()}</td>
            <td style="background-color: azure;width: 600px;height: 40px;">${mode.getUserDetails().getAddress()}</td>
            <td style="background-color: springgreen;width: 600px;height: 40px;">${mode.getFlag().getFlagName()}</td>
            <form action="zhifu" method="post">
              <input type="hidden" name="flagid" value="${mode.getFlag().getId()}"/>
              <input type="hidden" name="zhifu" value="${mode.getOrderid()}"/>
              <td style="background-color: springgreen;width: 600px;height: 30px;"><input type="submit" value="${mode.getFlag().getFlagButton()}"></td>
            </form>
            <form action="getprobyorder?orderid=${mode.getOrderid()}" method="post">
              <td style="background-color: springgreen;width: 600px;height: 30px;"><input type="submit" value="查看订单详情"></td>
            </form>

          </tr>
        </c:forEach>
        </table>
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
      <div class="col-md-10 col-md-offset-1">
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
