<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<form onsubmit="return add('/user/saveuser.html')" class="layui-form" enctype="multipart/form-data">
    <table class="layui-table" lay-skin="row" lay-size="lg">
        <tr>
            <td>账号：</td>
            <td>
                <input class="layui-input" type="text" name="userCode">
            </td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input class="layui-input" type="text" name="userName" id="userName" value=""></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input  class="layui-input" type="password" name="userPassword" id="userPassword" value=""></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <select name="gender" id="gender">
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>出生日期：</td>
            <td><input class="layui-input" id="datetype" type="text" name="birthday"></td>
        </tr>
        <tr>
            <td>电话：</td>
            <td><input class="layui-input" type="text" name="phone" id="phone" value=""></td>
        </tr>
        <tr>
            <td>地址：</td>
            <td><input class="layui-input" name="address" id="address" value=""></td>
        </tr>
        <tr>
            <td>用户角色：</td>
            <td>
                <select name="userRole" id="userRole">
                    <c:forEach items="${role}" var="r">
                        <option value="${r.id}">${r.roleName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" class="layui-btn layui-btn-primary"  value="保存">
            </td>
        </tr>

    </table>
</form>
</html>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/static/js/layui.all.js"></script>
<%@include file="../foot.jsp" %>
