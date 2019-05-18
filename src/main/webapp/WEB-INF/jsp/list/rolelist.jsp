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
<hr>
<table>
        <tr>
            <td>
                <button type="button" class="layui-btn layui-btn-normal"
                        onclick="addHtml('/role/addrole.html')">添加角色
                </button>
            </td>
        </tr>

</table>
<%--<div class="search">--%>
<%--<a href="${pageContext.request.contextPath}/role/addrole.html" >添加角色</a>--%>
<%--</div>--%>

<table id="rolelist" lay-filter="test"></table>
<script type="text/html" id="toolbar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="del">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="edit">编辑</button>
    </div>
</script>
</body>
<script type="text/javascript" src="/static/js/layui.all.js"></script>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#rolelist'
            , height: 800
            , url: '/role/json/rolelist' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'roleCode', title: '角色编码', width: 140, sort: true}
                , {field: 'roleName', title: '角色名称', width: 140, sort: true}
                , {field: 'creationDate', title: '创建时间', width: 140, sort: true}
                , {fixed: 'right', title: '操作', width: 178, align: 'center', toolbar: '#toolbar'}
            ]], done: function (res, curr, count) {
            }
        });
        //监听事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            }
        });

    });

</script>
<%@include file="../foot.jsp" %>
</html>