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
<%--<div class="search">--%>
<%--<form method="post" action="${pageContext.request.contextPath }/provider/providerlist.html" enctype="multipart/form-data">--%>
<%--<span>供应商编码：</span>--%>
<%--<input name="queryProCode" type="text" value="${queryProCode }">--%>
<%--<span>供应商名称：</span>--%>
<%--<input name="queryProName" type="text" value="${queryProName }">--%>
<%--<input type="hidden" name="pageIndex" value="1"/>--%>
<%--<input value="查 询" type="submit" id="searchbutton">--%>
<%--<a href="${pageContext.request.contextPath }/provider/provideradd.html">添加供应商</a>--%>
<%--</form>--%>
<%--</div>--%>
<!--供应商操作表格-->
<table id="providerlist" lay-filter="test"></table>
<script type="text/html" id="toolbar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="del">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="edit">编辑</button>
    </div>
</script>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/static/js/layui.all.js"></script>
<%--<script type="text/javascript" src="/static/js/billlist.js"></script>--%>
<script type="text/javascript">
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#providerlist'
            , height: 800
            , url: '/provider/json/providerlist' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'proCode', title: '供应商编码', width: 140, sort: true}
                , {field: 'proName', title: '供应商名称', width: 140, sort: true}
                , {field: 'proContact', title: '联系人', width: 140, sort: true}
                , {field: 'proPhone', title: '联系电话', width: 140}
                , {field: 'proFax', title: '传真', width: 140}
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
</body>
</html>
