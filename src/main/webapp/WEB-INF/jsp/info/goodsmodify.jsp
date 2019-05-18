<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<form onsubmit="return edit('/goods/saveupdategoods')" class="layui-form" enctype="multipart/form-data">
    <table class="layui-table" lay-skin="row" lay-size="lg">
        <tr>
            <td>商品编码：</td>
            <td>
                <input class="layui-input" type="text" name="gcode" value="${goods.gcode}" readonly>
                <input class="layui-input" type="hidden" name="id" value="${goods.id}">
            </td>
        </tr>
        <tr>
            <td>商品名称：</td>
            <td><input class="layui-input" type="text" name="gname"  value="${goods.gname}" readonly></td>
        </tr>
        <tr>
            <td>单位：</td>
            <td>
                <select name="gunit" readonly>
                    <option value="瓶" <c:if test="${goods.gunit=='瓶'}">selected</c:if>>瓶</option>
                    <option value="斤" <c:if test="${goods.gunit=='斤'}">selected</c:if>>斤</option>
                    <option value="个" <c:if test="${goods.gunit=='个'}">selected</c:if>>个</option>
                    <option value="根" <c:if test="${goods.gunit=='根'}">selected</c:if>>根</option>
                    <option value="条" <c:if test="${goods.gunit=='条'}">selected</c:if>>条</option>
                    <option value="只" <c:if test="${goods.gunit=='只'}">selected</c:if>>只</option>
                    <option value="颗" <c:if test="${goods.gunit=='颗'}">selected</c:if>>颗</option>
                    <option value="箱" <c:if test="${goods.gunit=='箱'}">selected</c:if>>箱</option>
                    <option value="束" <c:if test="${goods.gunit=='束'}">selected</c:if>>束</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>商品数量：</td>
            <td><input class="layui-input" type="text" name="gnumber"  value="${goods.gnumber}"></td>
        </tr>
        <tr>
            <td>进价：</td>
            <td>
                <input  class="layui-input" type="text" name="pprice" value="${goods.pprice}">
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