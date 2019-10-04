<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2019/10/3
  Time: 下午3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>水果网络销售平台</h1>
<div style="background: aqua;float: left">
    <a>货物管理</a>
    <a href="${pageContext.request.contextPath}/retailer/list.action?status=-1">零售商管理</a>
    <a>购物合同</a>
    <a>用户设置</a>
</div>
<hr/>


</body>
</html>
