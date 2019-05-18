<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<form onsubmit="return add('/sale/savesale.html')" class="layui-form" enctype="multipart/form-data">
    <table class="layui-table" lay-skin="row" lay-size="lg">
        <tr>
            <td>销售单编码：</td>
            <td>
                <input class="layui-input" type="text" name="scode">
            </td>
        </tr>
        <tr>
            <td>销售商品名称：</td>
            <td>
                <select name="sname">
                    <c:forEach var="g" items="${goods}">
                        <option value="${g.gname}">${g.gname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>销售数量：</td>
            <td><input class="layui-input" type="text" name="snumber" value=""></td>
        </tr>
        <tr>
            <td>单位：</td>
            <td>
                <select name="sunit">
                    <option value="瓶">瓶</option>
                    <option value="斤">斤</option>
                    <option value="个">个</option>
                    <option value="根">根</option>
                    <option value="条">条</option>
                    <option value="只">只</option>
                    <option value="颗">颗</option>
                    <option value="箱">箱</option>
                    <option value="束">束</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>售价：</td>
            <td>
                <input class="layui-input" type="text" name="sprice" value="">
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
