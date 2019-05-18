<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<body>
<%@include file="../menu.jsp" %>

<hr>
<div class="layui-container">
<form class="layui-form" method="post" action="/user/savepass.html">
    <!--div的class 为error是验证错误，ok是验证成功-->
    <div class="layui-card">
        <div class="layui-card-header">修改密码：<span style="color: #e4393c;">${message}</span></div>
        <div class="layui-card-body">
            <label for="userCode"> 用户名：</label>
            <input type="text" name="userCode" class="layui-input" id="userCode" value="${user.userCode}"><br>
            <label for="oldpassword">旧密码：</label>
            <input type="hidden" name="id" value="${user.id}">
            <input type="password" name="oldpassword" class="layui-input" id="oldpassword" value=""><br>
            <label for="newpassword">新密码：</label>
            <input type="password" name="newpassword" class="layui-input" id="newpassword" value=""><br>
            <input type="submit" value="保存" class="layui-btn layui-btn-primary">
        </div>
    </div>
</form>
</div>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/static/js/layui.all.js"></script>