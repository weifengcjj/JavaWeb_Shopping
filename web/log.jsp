<%@ page import="com.ygj.Service.ProService" %>
<%@ page import="com.ygj.Model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ygj.Service.Service" %>
<%@ page import="com.ygj.Model.Type" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/6
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <style>
        #zuo1{
            display:block;
            position:fixed;
            width: 200px;
            height: 210px;
            top: 0;
            left: 0;
        }
        .a1 {
            /* 1.把a转换为块级元素 这样就可以让链接竖着表示了*/
            display: block;
            /* 设置长度与宽度 */
            width: 200px;
            height: 40px;
            /* 设置背景颜色 */
            background-image: linear-gradient(to right, #eea2a2 0%, #bbc1bf 19%, #57c6e1 42%, #b49fda 79%, #7ac5d8 100%);
            /* 设置字体大小 */
            font-family: "Times New Roman", Times, serif;
            font-size: 20px;
            color:cornsilk;
            /* 链接没有下划线 */
            text-decoration: none;
            /* 设置左边的内边距 */
            padding-left: 30px;
            /* 设置文本边距 */
            line-height: 40px;
        }
        /* 2.鼠标经过链接变换背景颜色 */
        .a1:hover {
            background-image: linear-gradient(to right, #e4afcb 0%, #b8cbb8 0%, #b8cbb8 0%, #e2c58b 30%, #c2ce9c 64%, #7edbdc 100%);
        }
        .fabu{
            border:2px solid #a1a1a1;
            width:30px;
            height: 30%;
            border-radius:25px;
            background-color: turquoise;
        }
        #d3{
            height: 100px;
            width: 200px;
            display:block;
            position: absolute;
            top: 0px;
            right: 0px;
        }
        #head {
            height: 40px;
            line-height: 40px;
            position: fixed;
            top: 0;
            width: 100%;
            text-align: center;
            background:grey;
            color: white;
            font-family: Arial;
            font-size: 12px;
            letter-spacing: 1px;
        }
        #footer {
            height: 40px;
            line-height: 40px;
            position: fixed;
            bottom: 0;
            width: 100%;
            text-align: center;
            background:grey;
            color: white;
            font-family: Arial;
            font-size: 12px;
            letter-spacing: 1px;
        }
        #center{
            background-image: linear-gradient(to top, #fddb92 0%, #d1fdff 100%);
            line-height: 50px;
            text-align: center;
            margin:auto;
            width: 800px;
            height: 800px;
            border: 1px solid gold;
        }
        #sonn{
            width: 50px;
            height: 50px;
            left: 0;
            top: 0;
        }
        .son{
            border-bottom: tan;
            border-top: #8a6d3b;
        }
    </style>
</head>
<body>

<div id="zuo1">
    <%Service service=new Service();
        List<Type> getalltype = service.getalltype();
        request.getSession().setAttribute("getalltype",getalltype);
    %>
<%--<c:forEach items="${getalltype}" var="modelss" varStatus="id1">--%>
<%--&lt;%&ndash;    <a class="a1" href="pro.do?name=0">All</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <a class="a1" href="pro.do?name=1">life</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <a class="a1" href="pro.do?name=2">ShouJi</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <a class="a1" href="pro.do?name=3">food</a>&ndash;%&gt;--%>
<%--    <a class="a1" href="pro.do?name=${modelss.getTypeId()}">${modelss.getTypeName()}</a>--%>
<%--</c:forEach>--%>

</div>
<div id="d3">
<a class="fabu" href="login.jsp">EXIT</a>
</div>
<div id="center">
<%--    <c:forEach items="${allpro}" var="modelss" varStatus="id1">--%>
<%--        <a id="aa" href="soletest.do?name=${modelss.getId()}" style="text-decoration: none;">--%>
<%--            <div class="son">--%>
<%--                <img id="sonn" src=" ${modelss.getImg()}" />--%>
<%--                <p style="font-size: 10px;">--%>
<%--                <h3>${modelss.getName()}</h3>--%>
<%--                &nbsp;&nbsp;店铺:${modelss.getDesc()}--%>
<%--                &nbsp;&nbsp;价格:${modelss.getPrice()}--%>
<%--&lt;%&ndash;                &nbsp;&nbsp;点击数:${modelss.getHits()}&ndash;%&gt;--%>
<%--                <a href="#" class="fabu" style="text-decoration: none;">点击详情</a>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--                </p>--%>
<%--            </div>--%>
<%--        </a>--%>
<%--        <br/>--%>
<%--    </c:forEach>--%>
</div>
</body>
</html>
