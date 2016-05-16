<%--
  Created by IntelliJ IDEA.
  User: ZhenXi
  Date: 2016/4/15
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文豪图书馆</title>
    <script src="js/jquery-1.12.0.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/window.js"></script>
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<div id="head" style="padding-top: 10px; background-color: aqua; height: 40px;">
    <div id="nick" style="margin-left: 50px; float: left"><a href="login.html">我的图书馆</a></div>
    <p style="margin-left: 600px; display: inline; font-family: 楷体; font-size: 30px">文豪图书馆</p>
    <!--<a href="#" style="float: right; margin-right: 50px">关于我们</a>-->
</div>
<div style="width:700px; margin: 0 auto; border: none; margin-top: 100px">
    <select id="type" style="width: 100px; height: 30px; border-radius: 5px; font-size: 15px">
        <option value=0>书名</option>
        <option value=1>ISBN</option>
    </select>
    <input id="searchText" type="text" style="height: 30px; width: 500px; border-radius: 5px; font-size: 20px">
    <button id="search" style="height: 35px; width: 50px; background-color: #51ccff; color: white; border-radius: 5px">搜索</button>
</div>

<div style="margin-top: 100px">
    <div id="content" style="float: left; width: 900px; margin-left: 100px; border: 1px solid lightcyan; border-radius: 10px">
        <div id="categories" style="padding: 5px 30px 5px 30px"></div>
        <button onclick="orderByTime()">按时间排序</button>
        <button onclick="orderByNum()">按借阅数排序</button>
        <hr style="border: none; border-top: 1px solid lightgrey; margin-top: 10px"/>
    </div>
    <div id="aside" style="float: right; margin-right: 70px; border: 1px solid lightcyan;border-radius: 10px; height: 600px; width: 400px">
        <p style="margin: 20px 0 20px 30px; font-size: 20px">借书前十榜</p>
        <ol style="list-style: none">
        </ol>
    </div>
</div>
</body>
</html>
