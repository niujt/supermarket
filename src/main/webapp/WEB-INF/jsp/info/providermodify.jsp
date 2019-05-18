<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<form method="post" action="/provider/saveupdateprovider" class="layui-form" enctype="multipart/form-data">
    <table class="layui-table" lay-skin="row" lay-size="lg">
        <tr>
            <td>供应商编码：</td>
            <td>
                <input class="layui-input" type="text" name="proCode" value="${provider.proCode}">
                <input class="layui-input" type="hidden" name="id" value="${provider.id}">
            </td>
        </tr>
        <tr>
            <td>供应商名称：</td>
            <td><input class="layui-input" type="text" name="proName"  value="${provider.proName}"></td>
        </tr>
        <tr>
            <td>联系人：</td>
            <td><input  class="layui-input" type="text" name="proContact" value="${provider.proContact}"></td>
        </tr>
        <tr>
            <td>联系电话：</td>
            <td>
                <input  class="layui-input" type="text" name="proPhone" value="${provider.proPhone}">
            </td>
        </tr>
        <tr>
            <td>联系地址：</td>
            <td>
                <input  class="layui-input" type="text" name="proAddress" value="${provider.proAddress}">
            </td>
        </tr>
        <tr>
            <td>传真：</td>
            <td>
                <input  class="layui-input" type="text" name="proFax" value="${provider.proFax}">
            </td>
        </tr>
        <tr>
            <td>描述：</td>
            <td>
                <input  class="layui-input" type="text" name="proDesc" value="${provider.proDesc}">
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