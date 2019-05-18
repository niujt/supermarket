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

<%--<div class="search">--%>
<%--<form method="post" action="${pageContext.request.contextPath }/goods/goodslist.html">--%>
<%--<span>库存编码：</span>--%>
<%--<input name="querygcode" type="text" value="${querygcode}">--%>
<%--<span>库存商品名称：</span>--%>
<%--<input name="querygname" type="text" value="${querygname}">--%>
<%--<input type="hidden" name="pageIndex" value="1"/>--%>
<%--<input	value="查 询" type="submit" id="searchbutton">--%>
<%--<span><button type="button" id="btnExport">导出excel</button></span>--%>
<%--<a href="${pageContext.request.contextPath }/goods/goodsadd.html">添加库存</a>--%>
<%--</form>--%>
<%--</div>--%>
<table id="goodslist" lay-filter="test"></table>
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
            elem: '#goodslist'
            , height: 800
            , url: '/goods/json/goodslist' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'gcode', title: '库存编码', width: 140, sort: true}
                , {field: 'gname', title: '库存商品名称', width: 140, sort: true}
                , {field: 'gnumber', title: '库存商品数量', width: 140}
                , {field: 'pprice', title: '进价(元)', width: 140}
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