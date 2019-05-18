<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<form method="post" action="/user/saveuser.html" class="layui-form" enctype="multipart/form-data">
    <table class="layui-table" lay-skin="row" lay-size="lg">
        <tr>
            <td>角色编码：</td>
            <td>
                <input class="layui-input" type="text" name="roleCode">
            </td>
        </tr>
        <tr>
            <td>角色名称：</td>
            <td><input class="layui-input" type="text" name="roleName"  value=""></td>
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
