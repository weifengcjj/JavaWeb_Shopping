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

        #conn{
            width: 500px;
            height: 400px;
            overflow: hidden;
        }
        #phtot{
            width: 1200px;
            animation: switch 5s ease-out infinite;
        }
        #phtot > img{
            float: left;
            width: 400px;
            height: 300px;
        }
        @keyframes switch {
            0%,25%{
                margin-left:0;
            }
            35%,60%{
                margin-left:-400px;
            }
            70%,100%{
                margin-left:-800px;
            }
        }

        .message {
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            color: rgba(0, 0, 0, 0.85);
            font-size: 14px;
            font-variant: tabular-nums;
            line-height: 1.5715;
            list-style: none;
            -webkit-font-feature-settings: 'tnum';
            font-feature-settings: 'tnum';
            position: fixed;
            top: 8px;
            left: 0;
            z-index: 1010;
            width: 100%;
            pointer-events: none;
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
            <a class="navbar-brand" href="shoppingSusscs.jsp">YGJ商城</a>
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
                                <a class="navbar-brand" href="shoppingSusscs.jsp">首页</a>
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
        <div class="col-md-2 col-xs-2">
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
            <div class="col-md-6 col-xs-6">
                <div class="row">
<%--                    <form action="shoppingcar" method="post">--%>
                        <div class="col-md-3 col-xs-3" style="float: left;">
                            <img style="width: 330px;position:initial;height: 300px;border-radius: 10%;" src="${getonepro.getImg()}"/>
                        </div>

<%--                        <div class="col-md-3">--%>
<%--                            <h3 class="title-tit" style="CURSOR:pointer;font-family: 幼圆;font-size:10px;">${getonepro.getName()}</h3>--%>
<%--                            </p>--%>
<%--                            <p class="title-text" style="font-family: 幼圆;font-size:10px;">单价：￥${getonepro.getPrice()}</p>--%>
<%--                            <p class="title-text">店铺：${getonepro.getDesc()}</p>--%>

<%--                            <input  type="button"  value="-" onclick="this.form.c1.value--;"/>--%>
<%--                            <input type="text" style="width: 50px;"  name="c1" value=1 />--%>
<%--                            <input type="button" value="+" onclick="this.form.c1.value++"/>--%>
<%--                            <input type="hidden" name="id" value="${getonepro.getId()}"/>--%>
<%--                        </div>--%>

                        <div class="col-md-3 col-xs-3" style="width:250px;float:right;text-align: center">
                            <p class="title-tit" style="font-size:20px;">${getonepro.getName()}</p>
                            <br><br><br>
                            <p class="title-text" style="font-size:20px;">￥${getonepro.getPrice()}</p>
                            <br><br>
                            <p class="title-text" style="font-size:20px;">店铺：${getonepro.getDesc()}</p>
                            <br><br>
<%--                            this.form.c1.value--;--%>
                            <input  type="button"  value="-" onclick="rednum()"/>
                            <input type="text" class="c1" id="c1" style="width: 50px;"  name="c1" value=1 />
                            <input type="button" value="+" onclick="addnum()"/>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="hidden" class="pid" id="pid" name="pid" value="${getonepro.getId()}" />
                            <br><br>
                            <input class="button" type="button" value="加入购物车" style="border-radius: 10px;background-color: #fff9ec" id="addcar">

                        </div>
<%--                    </form>--%>
                </div>
        </div>

        <div class="col-md-3 col-xs-3 col-md-offset-1 col-xs-offset-1">
            <h5 style="margin-left:5px;">最新动态</h5>
            <ul>
                <li style="margin-top: 10px"><a target="_blank" href="http://cpc.people.com.cn/n1/2023/0311/c64094-32641777.html">习近平当选为中华人民共和国主席</a></li>
                <li style="margin-top: 10px"><a target="_blank" href="https://www.163.com/dy/article/HVHU8THL0529MKNM.html">董明珠:大学生打螺钉没什么不可以</a></li>
                <li style="margin-top: 10px"><a target="_blank" href="https://baijiahao.baidu.com/s?id=1760023608923429853">委员称年轻人想躺平更多是调侃</a></li>
            </ul>
        </div>
</div>
</div>
<div class="container">
<div class="row"></div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-9 col-xs-9" style="float:right;">
            <div>
                <h4 class="title-tit" style="font-size:40px;">${getonepro.getName()}</h4>
                <br>
                <br>
                <h3 class="title-tit" style="font-size:30px;">商品店铺：${getonepro.getDesc()}</h3>
                <br>
                <p class="title-tit" style="font-family: 华文仿宋;font-size:20px;">为什么每次刷牙都牙龈流血？</p>
                    <p class="title-tit" style="font-family: 华文仿宋;font-size:20px;">为什么吃什么都会上火？ </p>
                    <p class="title-tit" style="font-family: 华文仿宋;font-size:20px;">因为牙齿，你是不是不敢开怀大笑？</p>
                <p class="title-tit" style="font-family: 华文仿宋;font-size:20px;">你是不是因为牙齿问题，不敢在公开场合大声说话？</p>
                <p class="title-tit" style="font-family: 华文仿宋;font-size:20px;">用了这么多年牙刷，你真的用对牙刷了吗？</p>
                <br>
            </div>
            <div class="row"></div>
                <div className="descV8-container">

                    <div className="descV8-singleImage">
                        <a href="https://market.m.taobao.com/app/plastic/beauty-carefree-tool/home.html?type=index&amp;spm=a2141.7631564.1999060322.t2_meiwuyou_child_HotArea_1"
                           className="descV8-hotArea" style="width: 750px;
                height: 196px;
                top: 0px;
                left: 0px;"></a>
                        <img src="//img.alicdn.com/imgextra/i2/O1CN01KKdu2r1UEdOpQ5Zmr_!!6000000002486-2-tps-750-195.png"
                             data-name="singleImage" className="descV8-singleImage-image lazyload" style="width: 750px; height: 196px;">
                    </div>
                    <div className="descV8-singleImage">

                        <img src="https://img.alicdn.com/imgextra/i1/O1CN01Q09puy1Yhiypqyd1e_!!6000000003091-2-tps-1125-231.png"
                             data-name="singleImage" className="descV8-singleImage-image lazyload" style="width: 750px; height: 154px;">
                    </div>
                    <div className="descV8-singleImage">

                        <img src="${getonepro.getImg()}"
                             data-name="singleImage" className="descV8-singleImage-image lazyload"
                             style="width: 550px; height: 450.2903225806451px;">
                    </div>
                    <div className="descV8-singleImage">

                        <img data-src="https://img.alicdn.com/imgextra/i4/2206490606219/O1CN01eIlz3g1voLwZix0pY_!!2206490606219.jpg"
                             src="image/2050589.jpg" data-name="singleImage" className="descV8-singleImage-image lazyload"
                             style="width: 550px; height: 450.758064516129px;">
                    </div>
                    <div className="descV8-singleImage">

                        <img data-src="https://img.alicdn.com/imgextra/i1/2206490606219/O1CN01YJBzUl1voLxAej2hT_!!2206490606219.jpg"
                             src="image/291130.jpg" data-name="singleImage" className="descV8-singleImage-image lazyload"
                             style="width: 550px; height: 450.2903225806451px;">
                    </div>
                    <div className="descV8-singleImage">

                        <img data-src="https://img.alicdn.com/imgextra/i1/2206490606219/O1CN01WrPVAA1voLxGWahnQ_!!2206490606219.jpg"
                             src="image/2053760.jpg" data-name="singleImage" className="descV8-singleImage-image lazyload"
                             style="width: 550px; height: 450.2903225806451px;">
                    </div>
                </div>
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

<script>
        var num1=document.getElementById("c1");
        var num2=num1.value;
        function addnum()
        {
            if(num1.value>=${getonepro.getNum()})
            {
                func('不能再加了！！！库存不够了！！')
                return;
            }
            num2++;
            num1.value=num2;
        }
        function rednum()
        {
            if(num1.value<=1)
            {
                func('不能再减了！！！')
                return;
            }
            else{
                num2--;
                num1.value=num2;
            }
        }
        $(function() {
            $("#addcar").click(function () {
                    $.ajax({
                        type: "POST",
                        url: "shoppingcar",
                        data: {
                            c1: $(".c1").val(),
                            pid:$(".pid").val(),
                        },
                        success: function (data) {
                            func2('添加购物车成功！！！！！');
                        },
                    })
            });
        })


        // 创建一个div
        var lunbo=document.createElement("div");
        // 设置div的id值
        lunbo.id="lunbo";
        // 上面按钮点击事件
        function func(date){
            /* 创建div的样式，宽200px,高80px，下面的是css样式居中，
             * css样式居中具体了解链接：https://blog.csdn.net/A_Bear/article/details/80546181
             */
            var style1={
                background:"#ebccd1",
                position:"absolute",
                zIndex:10,
                width:"200px",
                height:"80px",
                left:"50%",
                top:"10%",
                marginLeft:"-100px",
                marginTop:"-40px",
                color:"black"
            }
            for(var i in style1)
                lunbo.style[i]=style1[i];
            // 当找不到id为lunbo的控件时
            if(document.getElementById("lunbo")==null){
                // 在body中添加lunbo控件（lunbo在上面创建的）
                document.body.appendChild(lunbo);
                // 显示内容
                lunbo.innerHTML=date;
                // 文本居中
                lunbo.style.textAlign="center";
                lunbo.style.lineHeight="80px"; // 作用是调节字体行高与div同高，使其保持水平居中
                // 设置2s后去掉弹出窗
                setTimeout("document.body.removeChild(lunbo)",2000)
            }
        }

        // 创建一个div
        var lunbo1=document.createElement("div");
        // 设置div的id值
        lunbo1.id="lunbo1";
        // 上面按钮点击事件
        function func2(date){
            /* 创建div的样式，宽200px,高80px，下面的是css样式居中，
             * css样式居中具体了解链接：https://blog.csdn.net/A_Bear/article/details/80546181
             */
            var style2={
                background:"#ebccd1",
                position:"absolute",
                zIndex:10,
                width:"200px",
                height:"80px",
                left:"70%",
                top:"10%",
                marginLeft:"-100px",
                marginTop:"-40px",
                color:"black"
            }
            for(var i in style2)
                lunbo1.style[i]=style2[i];
            // 当找不到id为lunbo的控件时
            if(document.getElementById("lunbo1")==null){
                // 在body中添加lunbo控件（lunbo在上面创建的）
                document.body.appendChild(lunbo1);
                // 显示内容
                lunbo1.innerHTML=date;
                // 文本居中
                lunbo1.style.textAlign="center";
                lunbo1.style.lineHeight="80px"; // 作用是调节字体行高与div同高，使其保持水平居中
                // 设置2s后去掉弹出窗
                setTimeout("document.body.removeChild(lunbo1)",2000)
            }
        }
</script>