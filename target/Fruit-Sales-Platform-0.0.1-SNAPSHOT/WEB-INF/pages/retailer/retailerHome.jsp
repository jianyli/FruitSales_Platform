<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2019/10/4
  Time: 上午10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>零售商管理</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        function init() {
            var countNumber = document.getElementById("countNumber").value;
            var sumPage = document.getElementById("sumPageNumber").value;
            var currentPage = document.getElementById("currentPage").value;
            var info = "一共<font color='blue'>"+countNumber+"</font>条数据，共<font color='blue'>"+sumPage+"</font>页，当前第<font color='blue'>"+currentPage+"</font>页";
            document.getElementById("pageInfo").value = info;
        }
        function changeStatus() {
            var status = document.getElementById("indexStatus").value;
            document.getElementById("status").value = status;
        }
        function toPrePage() {
            var currentPageObject = document.getElementById("currentPage");
            var currentPage = parseInt(currentPageObject.value);
            if (currentPage == 1) {
                alert("数据已到顶");
            } else {
                currentPageObject.value = currentPage - 1;
                var pageSize = parseInt(document.getElementById("pageSize").value);
                var startPageObject = document.getElementById("startPage");
                startPageObject.value = parseInt(startPageObject.value) - pageSize;
                document.getElementById("listForm").submit();
            }
        }
        function toNextPage(){
            var currentPageObject = document.getElementById("currentPage");
            var currentPage = parseInt(currentPageObject.value);
            var sumPage = parseInt(document.getElementById("sumPageNumber").value);
            if(currentPage>=sumPage){
                alert("数据已到底！");
            }else{
                currentPageObject.value = currentPage+1;
                var pageSize = parseInt(document.getElementById("pageSize").value);
                var startPageObject =document.getElementById("startPage");
                startPageObject.value = parseInt(startPageObject.value)+pageSize;
                document.getElementById("listForm").submit();
            }
        }

        function toLocationPage(){
            var pageNumber = document.getElementById("pageNumber").value;
            var currentPageObject = document.getElementById("currentPage");
            var currentPage = currentPageObject.value;
            if(pageNumber==null||pageNumber==""){
                alert("请输入要跳转的页数！");
            }else{
                pageNumber = parseInt(pageNumber);
                var sumPage = parseInt(document.getElementById("sumPageNumber").value);
                if(pageNumber<1){
                    alert("数据已到顶！");
                }else if(pageNumber>sumPage){
                    alert("数据已到底！");
                }else{
                    currentPageObject.value = pageNumber;
                    var pageSize = parseInt(document.getElementById("pageSize").value);
                    var startPageObject =document.getElementById("startPage");
                    if(pageNumber>currentPage){
                        startPageObject.value = parseInt(startPageObject.value)+pageSize;
                    }else if(pageNumber<currentPage){
                        startPageObject.value = parseInt(startPageObject.value)-pageSize;
                    }
                    document.getElementById("listForm").submit();
                }
            }
        }
    </script>
</head>
<body onload="init()">
<%@ include file="../menu.jsp" %><br/>
<form id="listForm" action="/retailer/list.action" method="post">
    姓名：<input type="text" name="name"/>
    手机：<input type="text" name="telephone"/>
    地址：<input type="text" name="address"/><br/>
    状态：<select id="indexStatus" onchange="changeStatus()">
    <option value="-1" selected="selected">全部</option>
    <option value="0">启用</option>
    <option value="1">停止</option>
</select>
    <input type="hidden" id="status" value="-1"/>
    创建日期：<input type="text" name="createTime"/>
    <input type="submit" value="搜索"/><br/>
    <c:if test="${errorMsg != null}">
        <font color="red">${errorMsg}</font>
    </c:if>
    <input type="hidden" id="startPage" name="startPage" value="${startPage}"/>
    <input type="hidden" id="currentPage" name="currentPage" value="${currentPage}"/>
    <input type="hidden" id="pageSize" name="pageSize" value="${pageSize}"/>
    <input type="hidden" id="sumPageNumber" name="sumPageNumber" value="sumPageNumber"/>
    <input type="hidden" id="countNumber" name="countNumber" value="${countNumber}"/>
</form>
<hr/>
<c:if test="${list != null}">
    <table border="1">
        <tr>
            <td>序号</td><td>姓名</td><td>手机号</td><td>地址</td><td>状态</td><td>创建日期</td><td>操作</td>
        </tr>
        <c:forEach items="${list}" var="item" varStatus="status">
            <tr>
                <td>${status.index+1}</td><td>${item.name}</td>
                <td>${item.telephone}</td><td>${item.address}</td>
                <td>
                    <c:if test="${item.status == 0}">
                        <font color="red">停用</font>
                    </c:if>
                    <c:if test="${item.status == 1}">
                        <font color="blue">启用</font>
                    </c:if>
                </td>
                <td>${item.createTime}</td>
                <td><a>编辑</a>|<a>删除</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${list == null}">
    <b>搜索结果为空！</b>
</c:if>
<div>
    <a onclick="toPrePage()">上一页</a><a onclick="toNextPage()">下一页</a>
    <input id="pageNumber" type="text"/><button onclick="toLocationPage()">go</button>
    <div id="pageInfo"></div>
</div>
</body>
</html>
