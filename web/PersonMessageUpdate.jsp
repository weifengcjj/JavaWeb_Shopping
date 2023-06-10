<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/14
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        body
        {
            background-image: url(image/2053760.jpg);
            background-size: cover;
        }
        div.transbox
        {
            width: 1050px;
            height: 420px;
            margin: auto;
            background-color: #ffffff;
            border: 1px solid #FFFFFF;
            opacity:0.8;
        }

        h1 {text-align: center;}
        h2.ex1 {margin-left:5cm;}
        h3.ex1 {margin-left:5cm;}
        img.ex1{margin-left:5cm;}
        p{text-align: right;}
        p.ex1{margin-right: 2cm;}
        p{color:mediumpurple}

        /*cc:change color*/
        a.cc:hover {
            border-radius: 15%;
            border: 1px solid palevioletred;
            background-color: azure;
        }
    </style>
</head>
<body style="background-color: #e5e5e5">
<div class="background">
    <div class="transbox">
        <a class="cc" href="zhuye" style="top: 0;left: 0;">返回</a>
        <h1>个人信息修改</h1>
        <div class="container">
            <div><h3>邮箱修改功能暂未开通，敬请期待...</h3></div>
            <br>
            <h3 class="ex1">当前地址：${userdetails.getAddress()}</h3>
            <form action="setper" method="post">
                <br>
                <h3>地址：<input type="text" placeholder="请输入修改的值" name="address"></h3>
                <input type="submit" value="修改">
            </form>

        </div>
        <p class="ex1">这个人很懒，什么都没有留下......</p>
    </div>
</div>
</body>
</html>
