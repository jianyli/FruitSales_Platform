<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2019/10/3
  Time: 下午2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>注册页面</title>
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
            }else if (document.getElementById("telephone").value == "" ||
                !(/^1[34578]\d{9}$/.test(document.getElementById("telephone").value))
            ) {
                alert("电话号码格式有误");
                document.getElementById("telephone").focus();
                return false;
            }else if (document.getElementById("name").value == "") {
                alert("姓名不能为空");
                document.getElementById("name").focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div align="center">
    <h1>注册页面</h1>
    <form action="register.action" method="post" onsubmit="return validate()">
        用户名：<input type="text" id="username" name="userName"/><br>
        密码：<input type="password" id="password" name="password"/><br/>
        姓名：<input type="text" id="name" name="name"/><br/>
        电话：<input type="text" id="telephone" name="telephone"/><br/>
        <input type="submit" value="注册"> &nbsp;&nbsp;
        <a href="/user/toLogin.action">返回登录页面</a>
    </form>
    <c:if test="${errorMsg != null}">
        <font color="red">${errorMsg}</font>
    </c:if>
</div>
</body>
</html>
