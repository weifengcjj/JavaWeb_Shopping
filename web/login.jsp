<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/6
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <title>Login</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="wrapper" style="height: 450px;">
    <div class="container">
        <h1>Welcome</h1>
        <form action="login" method="post">
            <input type="text" placeholder="admin" name="username">
            <input type="password" placeholder="password" name="password">

            <div class="btn-group">
                <input type="radio" id="radio1" name="type" value="1" checked>
                <label for="radio1">User</label>
            </div>
            <div class="btn-group">
                <input type="radio"  id="radio2" name="type" value="0">
                <label for="radio2">Admin</label>
            </div>
            <br>

            <button type="submit">Login</button>
            <button type="button"  onclick="abc()">Logon</button>

            <h1 style="font-family: 幼圆;font-size: 20px; color: black;text-align: -moz-right;">
                <%
                    if(request.getSession().getAttribute("msg") == null){}
                    else {
                        out.print(request.getSession().getAttribute("msg"));
                    }
                %>
                <br>
                <%
                    if(request.getAttribute("login_msg")==null) {}
                    else
                    {
                        out.print(request.getAttribute("login_msg"));
                    }
                %>
            </h1>
            <%--      //<a href="register.jsp">注册</a>--%>
            <div style="color:black;font-family: '微软雅黑 Light';text-align: right;" class="aa">
                <p>© 2023-2024 YGJ @</p>
                <p>C1-20230306-1</p>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
    $('#login-button').click(function(event){
        event.preventDefault();
        $('form').fadeOut(500);
        $('.wrapper').addClass('form-success');
    });
    function  abc()
    {
        window.location = "register.jsp";
    }
</script>
<style>
    .aa{
        position: fixed;
        bottom: 0;
    }
    a:hover{
        background: cyan;
        color: black;

        box-shadow: 0 0 5px #03e9f4,
        0 0 25px #03e9f4,
        0 0 50px #03e9f4,
        0 0 200px #03e9f4;
        -webkit-box-reflect:below 1px linear-gradient(transparent, #0005);
    }
    a:nth-child(1){
        filter: hue-rotate(270deg);
    }
    a:nth-child(2){
        filter: hue-rotate(110deg);
    }
    a span{
        position: absolute;
        display: block;
    }
    a span:nth-child(1){
        top: 0;
        left: 0;
        width: 100%;
        height: 2px;
        background: linear-gradient(90deg,transparent,#03e9f4);
        animation: animate1 1s linear infinite;
    }
    @keyframes animate1{
        0%{
            left: -100%;
        }
        50%,100%{
            left: 100%;
        }
    }
    a span:nth-child(2){
        top: -100%;
        right: 0;
        width: 2px;
        height: 100%;
        background: linear-gradient(180deg,transparent,#03e9f4);
        animation: animate2 1s linear infinite;
        animation-delay: 0.25s;
    }
    @keyframes animate2{
        0%{
            top: -100%;
        }
        50%,100%{
            top: 100%;
        }
    }
    a span:nth-child(3){
        bottom: 0;
        right: 0;
        width: 100%;
        height: 2px;
        background: linear-gradient(270deg,transparent,#03e9f4);
        animation: animate3 1s linear infinite;
        animation-delay: 0.50s;
    }
    @keyframes animate3{
        0%{
            right: -100%;
        }
        50%,100%{
            right: 100%;
        }
    }


    a span:nth-child(4){
        bottom: -100%;
        left: 0;
        width: 2px;
        height: 100%;
        background: linear-gradient(360deg,transparent,#03e9f4);
        animation: animate4 1s linear infinite;
        animation-delay: 0.75s;
    }
    @keyframes animate4 {
        0% {
            bottom: -100%;
        }
        50%, 100% {
            bottom: 100%;
        }
    }
</style>
</body>
</html>

