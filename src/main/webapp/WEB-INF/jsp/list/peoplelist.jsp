<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<body>
<%@include file="../menu.jsp" %>
<hr>
<div class="demoTable">
    员工姓名：
    <div class="layui-inline">
        <input class="layui-input" name="peopleName" id="peopleName" autocomplete="off">
    </div>
    部门：
    <div class="layui-inline">
        <input class="layui-input" name="dname" id="dname" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
    <button type="button" class="layui-btn "
            onclick="addHtml('/people/peopleadd.html')">添加订单
    </button>
</div>
<table id="peoplelist" lay-filter="test"></table>
<script type="text/html" id="toolbar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="del">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="edit">编辑</button>
    </div>
</script>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/static/js/layui.all.js"></script>
<script type="text/javascript">
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#peoplelist'
            ,id:'testReload'
            , height: 500
            , url: '/people/json/peoplelist' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'peopleName', title: '姓名', width: 140, sort: true}
                , {field: 'peopleAge', title: '年龄', width: 140, sort: true}
                , {field: 'dname', title: '职位', width: 140, sort: true}
                , {field: 'salary', title: '薪水(元)', width: 140}
                , {field: 'gender', title: '性别', width: 140}
                , {field: 'creationDate', title: '创建时间', width: 140, sort: true}
                , {fixed: 'right', title: '操作', width: 178, align: 'center', toolbar: '#toolbar'}
            ]], done: function (res, curr, count) {
                $("[data-field = 'gender']").children().each(function () {

                    if ($(this).text() === '1') {
                        $(this).text("男");
                    } else if ($(this).text() === '2') {
                        $(this).text("女");
                    }
                });
            }
        });
        //监听事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    del("/people/deletepeople/"+data.id);
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                editHtml('/people/updatepeople.html/'+data.id);
            }
        });
        var $ = layui.$, active = {
            reload: function () {
                var peopleName = $('#peopleName');
                var dname = $('#dname');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        peopleName: peopleName.val(),
                        dname: dname.val()
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
</body>
</html>