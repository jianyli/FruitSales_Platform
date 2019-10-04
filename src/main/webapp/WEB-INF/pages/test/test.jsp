<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2019/10/2
  Time: 下午4:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>test</title>
</head>
<body>
Test JSP view <br/>
<form action="finduser" method="post">
    用户名：<input type="text" name="name"/>
    <input type="submit" value="查询">
</form>
<table border="1">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>账号</th>
        <th>电话</th>
    </tr>
    <c:forEach items="${userList}" var="u" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${u.name}</td>
            <td>${u.username}</td>
            <td>${u.telephone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
