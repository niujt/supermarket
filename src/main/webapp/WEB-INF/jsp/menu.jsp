<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<ul class="layui-nav">

    <li class="layui-nav-item "><a href="/bill/billlist.html">订单管理</a></li>
    <li class="layui-nav-item "><a href="">供应商管理</a></li>
    <li class="layui-nav-item"><a href="">退货单管理</a></li>
    <li class="layui-nav-item"><a href="">人事管理</a></li>
    <li class="layui-nav-item"><a href="">销售管理</a></li>
    <li class="layui-nav-item"><a href="">库存管理</a></li>
    <li class="layui-nav-item layui-this">
        <a href="javascript:;">系统设置</a>
        <dl class="layui-nav-child"> <!-- 二级菜单 -->
            <dd><a href="/user/userlist.html">用户管理</a></dd>
            <dd><a href="">角色管理</a></dd>
            <dd><a href="">密码修改</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item layui-layout-right"><a href="/outLogin.html"> 欢迎小明&nbsp;&nbsp;&nbsp;退出系统</a></li>
</ul>