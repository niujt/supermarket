<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<body>
<%@include file="menu.jsp"%>
<h1 style="text-align: center">欢迎来到超市管理系统</h1>
<hr>
<div class="layui-carousel" id="test1">
    <div carousel-item style="height: 500px;">
        <div><img style="width: 100%;height: 100%;" src="/static/images/index_1.jpeg"></div>
        <div><img style="width: 100%;height: 100%;" src="/static/images/index_2.jpeg"></div>
        <div><img style="width: 100%;height: 100%;" src="/static/images/index_3.jpeg"></div>
        <div><img style="width: 100%;height: 100%;" src="/static/images/index_4.jpeg"></div>
    </div>
</div>
<hr>
<script type="text/javascript" src="/static/js/layui.all.js"></script>
<%@include file="foot.jsp" %>
</body>
</html>
    