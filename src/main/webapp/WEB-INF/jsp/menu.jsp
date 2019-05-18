<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<ul class="layui-nav" lay-filter="bigData">

    <li class="layui-nav-item layui-this"><a href="/index">首页</a></li>
    <li class="layui-nav-item "><a href="/bill/billlist.html">订单管理</a></li>
    <li class="layui-nav-item "><a href="/provider/providerlist.html">供应商管理</a></li>
    <li class="layui-nav-item"><a href="/refuse/refuselist.html">退货单管理</a></li>
    <li class="layui-nav-item"><a href="/people/peoplelist.html">人事管理</a></li>
    <li class="layui-nav-item"><a href="/sale/salelist.html">销售管理</a></li>
    <li class="layui-nav-item"><a href="/goods/goodslist.html">库存管理</a></li>
    <li class="layui-nav-item ">
        <a href="javascript:;">系统设置</a>
        <dl class="layui-nav-child"> <!-- 二级菜单 -->
            <dd><a href="/user/userlist.html">用户管理</a></dd>
            <dd><a href="/role/rolelist.html">角色管理</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item layui-layout-right">
        <a href="javascript:;">欢迎&nbsp;&nbsp;&nbsp;${userSession.userCode}&nbsp;&nbsp;&nbsp;</a>
        <dl class="layui-nav-child"> <!-- 二级菜单 -->
            <dd><a href="/user/updatepass.html">密码修改</a></dd>
            <dd><a href="/outLogin.html">退出系统</a></dd>
        </dl></li>
</ul>