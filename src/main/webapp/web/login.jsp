<%--
  Created by IntelliJ IDEA.
  User: ZhenXi
  Date: 2016/1/11
  Time: 1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>登录</title>
    <script src="js/jquery-1.12.0.min.js"></script>

    <style type="text/css">
        img {
            border: 1px solid #ffffff;
            width: 35%;
            margin-left: 5%;
            margin-right: 10%;
            float: left;
        }

        #login {
            float: right;
            width: 35%;
            margin-right: 5%;
            border-radius: 5px;
            border: 1px solid;
        }
    </style>
</head>
<body>
    <img src="img/login.jpg">
    <div id = "login">
        <textarea >
            <span>学号：</span><input type="text" placeholder="请输入学号"/>
            <span>密码：</span><input type="password" placeholder="请输入密码"/>
        </textarea>
    </div>

    <script type="text/javascript">
        function login(){
            var sno = $("sno").innerText;
            var pwd = $("password").innerText;
            $.ajax({

            });
        }
    </script>
</body>
</html>
