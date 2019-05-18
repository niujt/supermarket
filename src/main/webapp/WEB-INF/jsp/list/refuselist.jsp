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
<!--退货列表-->
<hr>
<%--<div class="search">--%>
<%--<form method="post" action="${pageContext.request.contextPath }/refuse/refuselist.html" enctype="multipart/form-data">--%>
<%--<span>退货编码：</span>--%>
<%--<input name="queryRefCode" type="text" value="${queryRefCode }">--%>
<%--<span>退货名称：</span>--%>
<%--<input name="queryRefName" type="text" value="${queryRefName}">--%>
<%--<input type="hidden" name="pageIndex" value="1"/>--%>
<%--<input value="查 询" type="submit" id="searchbutton">--%>
<%--<a href="${pageContext.request.contextPath }/refuse/refuseadd.html">添加退货单</a> --%>
<%--</form>--%>
<%--</div>--%>

<table id="refuselist" lay-filter="test"></table>
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
            elem: '#refuselist'
            , height: 800
            , url: '/refuse/json/refuselist' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'refCode', title: '商品编码', width: 140, sort: true}
                , {field: 'refName', title: '商品名称', width: 140, sort: true}
                , {field: 'refnumber', title: '退货数量', width: 140, sort: true}
                , {field: 'refReasion', title: '退货理由', width: 140}
                , {field: 'creationDate', title: '创建时间', width: 140}
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
</html>
