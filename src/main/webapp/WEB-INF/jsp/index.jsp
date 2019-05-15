<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="css/layui.min.css">
    <title>超市管理系统</title>
</head> 
<body>
<div class="layui-header">
<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item layui-this"><a href="">订单管理</a></li>
    <li class="layui-nav-item "><a href="">供应商管理</a></li>
    <li class="layui-nav-item"><a href="">退货单管理</a></li>
    <li class="layui-nav-item"><a href="">人事管理</a></li>
    <li class="layui-nav-item"><a href="">销售管理</a></li>
    <li class="layui-nav-item"><a href="">库存管理</a></li>
    <li class="layui-nav-item">
        <a href="javascript:;">系统设置</a>
        <dl class="layui-nav-child"> <!-- 二级菜单 -->
            <dd><a href="">用户管理</a></dd>
            <dd><a href="">角色管理</a></dd>
            <dd><a href="">密码修改</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="">退出系统</a></li>
</ul>
</div>
<button type="button" class="btn btn-info">dsadas</button>
<script type="text/javascript" src="/static/js/layui.all.js"></script>
<script type="text/javascript">
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
</script>
</body> 
</html>
    