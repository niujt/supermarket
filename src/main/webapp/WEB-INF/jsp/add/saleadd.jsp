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
            <td>销售单编码：</td>
            <td>
                <input class="layui-input" type="text" name="scode">
            </td>
        </tr>
        <tr>
            <td>售货名：</td>
            <td><input class="layui-input" type="text" name="sname"  value=""></td>
        </tr>
        <tr>
            <td>销售数量：</td>
            <td><input  class="layui-input" type="text" name="snumber" value=""></td>
        </tr>
        <tr>
            <td>售价：</td>
            <td>
                <input  class="layui-input" type="text" name="sprice" value="">
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
