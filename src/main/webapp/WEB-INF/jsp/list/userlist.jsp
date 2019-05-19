<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<body>
<%@include file="../menu.jsp" %>
<!--用户-->
<hr>
<div class="demoTable">
    用户名：
    <div class="layui-inline">
        <input class="layui-input" name="userName" id="userName" autocomplete="off">
    </div>
    用户角色：
    <div class="layui-inline">
        <input class="layui-input" name="userRoleName" id="userRoleName" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
    <button type="button" class="layui-btn "
            onclick="addHtml('/user/adduser.html')">添加用户
    </button>
</div>
<table id="userlist" lay-filter="test"></table>
<script type="text/html" id="toolbar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="del">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="edit">编辑</button>
    </div>
</script>
</body>
<script type="text/javascript" src="/static/js/layui.all.js"></script>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/static/js/userlist.js"></script>
<script type="text/javascript">
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#userlist'
            , height: 500
            ,id:'testReload'
            , url: '/user/json/userlist' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'userCode', title: '用户编码', width: 140, sort: true}
                , {field: 'userName', title: '用户名称', width: 140, sort: true}
                , {field: 'gender', title: '性别', width: 140, sort: true}
                , {field: 'age', title: '年龄', width: 140}
                , {field: 'phone', title: '电话', width: 140}
                , {field: 'userRole', title: '用户角色', width: 140, sort: true}
                , {fixed: 'right', title: '操作', width: 178, align: 'center', toolbar: '#toolbar'}
            ]], done: function (res, curr, count) {
                $("[data-field = 'gender']").children().each(function () {

                    if ($(this).text() === '1') {
                        $(this).text("男");
                    } else if ($(this).text() === '2') {
                        $(this).text("女");
                    }
                });
                $("[data-field = 'userRole']").children().each(function () {

                    if ($(this).text() === '1') {
                        $(this).text("系统管理员");
                    } else if ($(this).text() === '2') {
                        $(this).text("经理");
                    } else if ($(this).text() === '3') {
                        $(this).text("销售人员");
                    }
                });
            }
        });
        //监听事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    del("/user/deluser/" + data.id);
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                editHtml("/user/modifyuser.html/" + data.id);
            }
        });
        var $ = layui.$, active = {
            reload: function () {
                var userName = $('#userName');
                var userRoleName = $('#userRoleName');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        userName: userName.val(),
                        userRoleName: userRoleName.val()
                    }
                });
            }
        };
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
<%@include file="../foot.jsp" %>
</html>

