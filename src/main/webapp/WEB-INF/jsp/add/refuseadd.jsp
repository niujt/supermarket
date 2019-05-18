<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<form onsubmit="return add('/refuse/saverefuse.html')" class="layui-form" enctype="multipart/form-data">
    <table class="layui-table" lay-skin="row" lay-size="lg">
        <tr>
            <td>退货单编码：</td>
            <td>
                <input class="layui-input" type="text" name="refCode">
            </td>
        </tr>
        <tr>
            <td>退货名称：</td>
            <td>
                <select name="refName">
                    <c:forEach var="g" items="${goods}">
                        <option value="${g.gname}">${g.gname}</option>
                    </c:forEach>
                </select>
        </tr>
        <tr>
            <td>退货数量：</td>
            <td><input  class="layui-input" type="text" name="refnumber" value=""></td>
        </tr>
        <tr>
            <td>退货理由：</td>
            <td>
                <input  class="layui-input" type="text" name="refReasion" value="">
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