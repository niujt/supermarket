<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<form onsubmit="return edit('/user/modifysave.html')" class="layui-form" enctype="multipart/form-data">
    <table class="layui-table" lay-skin="row" lay-size="lg">
        <tr>
            <td>账号：</td>
            <td>
                <input class="layui-input" type="text" name="userCode" value="${user.userCode}">
                <input class="layui-input" type="hidden" name="id" value="${user.id}">
            </td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input class="layui-input" type="text" name="userName" value="${user.userName}"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input class="layui-input" type="text" name="userPassword" value="${user.userPassword}"></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                <select name="gender" id="gender">
                    <option value="1" <c:if test="${user.gender==1}">男</c:if>>男</option>
                    <option value="2" <c:if test="${user.gender==2}">女</c:if>>女</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>出生日期：</td>
            <td><input class="layui-input" id="datetype" type="text" name="birthday"
                       value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>"></td>
        </tr>
        <tr>
            <td>电话：</td>
            <td><input class="layui-input" type="text" name="phone" value="${user.phone}"></td>
        </tr>
        <tr>
            <td>地址：</td>
            <td><input class="layui-input" name="address" value="${user.address}"></td>
        </tr>
        <tr>
            <td>用户角色：</td>
            <td>
                <select name="userRole" id="userRole">
                    <option value="">-请选择-</option>
                    <c:forEach items="${role}" var="r">
                        <option
                                <c:if test="${user.userRole==r.id}">selected</c:if>
                                value="${r.id}">${r.roleName}</option>
                    </c:forEach>
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
