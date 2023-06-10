<%@ page import="com.ygj.Service.ProService" %>
<%@ page import="com.ygj.Model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/9
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册成功</title>

    <script>
        alert("注册成功！！！");
        <%
        ProService ps=new ProService();
        List<Product> list=ps.getallpro();
        request.getSession().setAttribute("allpro",list);
        %>
        window.location= "shoppingSusscs.jsp";
    </script>
</head>
<body>

</body>
</html>
