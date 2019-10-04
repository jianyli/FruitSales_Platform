<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2019/10/3
  Time: 上午12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录界面</title>

    <script type="text/javascript">
        function validate() {
            if (document.getElementById("username").value == "") {
                alert("用户名不能为空");
                document.getElementById("username").focus();
                return false;
            } else if (document.getElementById("password").value == "") {
                alert("密码不能为空");
                document.getElementById("password").focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div align="center">
    <h1>用户登录</h1>
    <form action="login.action" method="post" onsubmit="return validate()">
        用户名：<input type="text" id="username" name="username"/><br/>
        密码：<input type="password" id="password" name="password"/><br/>
        <input type="submit" value="提交"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="重置"/>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="registerPage.action">注册</a><br/>
        <c:if test="${errorMsg != null}">
            <font color="red">${errorMsg}</font>
        </c:if>
        <c:if test="${noticeMsg != null}">
            <font color="green">${noticeMsg}</font>
        </c:if>
    </form>
</div>
</body>
</html>
