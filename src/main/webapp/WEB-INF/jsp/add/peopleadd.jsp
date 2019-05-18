<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<form onsubmit="return add('/people/savepeople.html')" class="layui-form" enctype="multipart/form-data">
    <table class="layui-table" lay-skin="row" lay-size="lg">
        <tr>
            <td>姓名：</td>
            <td>
                <input class="layui-input" type="text" name="peopleName">
            </td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input class="layui-input" type="text" name="peopleAge" value=""></td>
        </tr>
        <tr>
            <td>职位：</td>
            <td>
                <div class="layui-form-item">
                <select name="deptid">
                    <c:forEach items="${depts}" var="d">
                        <option value="${d.id}">${d.dname}</option>
                    </c:forEach>
                </select>
                </div>
            </td>
        </tr>
        <tr>
            <td>薪水：</td>
            <td>
                <input class="layui-input" type="text" name="salary" value="">
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <select name="gender">
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" class="layui-btn layui-btn-primary" value="保存">
            </td>
        </tr>

    </table>
</form>
</html>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/static/js/layui.all.js"></script>
<%@include file="../foot.jsp" %>