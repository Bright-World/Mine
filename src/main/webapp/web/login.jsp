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

<%--
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
        /*function login(){
            var sno = $("sno").innerText;
            var pwd = $("password").innerText;
            $.ajax({

            });
        }*/
        /*$.ajax({
            url : 'http://localhost/Mine/getCategories',
            type : 'get',
            contentType : 'application/json',
            success : function(data) {
                alert(data);
            }
        });*/
    </script>
</body>
</html>
--%>
<html>
<head>
    <meta charset='utf-8'/>
    <title>登录</title>
    <script src="js/jquery-1.12.0.min.js"></script>

    <style type="text/css">
        h1 {
            font-size: 3em;
            font-family: "黑体";
            margin: 30px 0px 30px 100px;
        }
        img {
            border: 1px solid #ffffff;
            width: 20%;
            margin-left: 20%;
            margin-right: 10%;
            float: left;
        }

        #login {
            float: right;
            width: 20%;
            margin-right: 20%;
            margin-top: 50px;
            border-radius: 5px;
            border: 1px solid grey;
            padding: 0px auto;
        }
        button {

        }
    </style>
</head>
<body style="background-image: url(img/login_back.jpg);">
<h1>文豪图书馆</h1>
<hr />
<div style="margin-top: 50px">
    <img src="img/login.jpg">
    <div id = "login">
        <h2 style="text-align: center; font-family: 楷体">用户登录</h2>
        <div style="margin: 20px 0px 0px 30px">
            <span>学号：&nbsp;</span><input type="text" id="sno" placeholder="请输入学号"/>
        </div>
        <div style="margin: 10px 0px 0px 30px">
            <span>密码：&nbsp;</span><input type="password" id="pwd" placeholder="请输入密码"/>
        </div>
        <div style="margin: 10px 0px 20px 30px">
            <span>角色：</span>
            <select style="margin-left: 7px">
                <option value=1>普通用户</option>
                <option value=2>管理员</option>
            </select>
        </div>
        <div style="margin: 0px 0px 20px 80px">
            <button style="width: 50px; height: 30px" onclick="login()">登录</button>&nbsp;<a style="font-size: 5px" href="#">忘记密码？</a>
        </div>
    </div>
</div>
<script type="text/javascript">
    function login(){
        var data = JSON.stringify({
            sno : $("#sno").innerText,
            pwd : $("#pwd").innerText,
            role : parseInt($("select").val())
        });
        $.ajax({
            url: url.login,
            type: 'post',
            data: data,
            contentType: 'application/json',
            success: function(res) {
                res = JSON.parse(res);
                if(res.status == 1) {
                    sessionStorage.setItem("nick",res.res.nick);
                    sessionStorage.setItem("userId", res.res.userId);
                    window.onload();
                }else {
                    alert(res.msg);
                }
            }
        });
    }
</script>
</body>
</html>
