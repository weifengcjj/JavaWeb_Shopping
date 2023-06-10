<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/14
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
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
        <h1>个人信息</h1>
        <h2 class="ex1">${userdetails.getUser().getUser()}</h2>
        <br>
        <h3 class="ex1">email：${userdetails.getUser().getEmail()}</h3>
        <h3 class="ex1">创建时间：${userdetails.getUser().getDatetime()}</h3>
        <h3 class="ex1">地址：${userdetails.getAddress()}</h3>
        <p class="ex1">这个人很懒，什么都没有留下......</p>
    </div>
</div>
</body>
</html>
