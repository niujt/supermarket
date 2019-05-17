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
        <%--<form method="post" action="${pageContext.request.contextPath }/bill/billlist.html">--%>
            <%--<span>商品名称：</span>--%>
            <%--<input name="queryProductName" type="text" value="${queryProductName}">--%>
            <%--<span>供应商：</span>--%>
            <%--<select name="queryProviderId" id="queryProviderId">--%>
            <%--</select>--%>
            <%--<span>是否付款：</span>--%>
            <%--<select name="queryIsPayment">--%>
                <%--<option value="">--请选择--</option>--%>
                <%--<option value="1" ${queryIsPayment == 1 ? "selected=\"selected\"":"" }>未付款</option>--%>
                <%--<option value="2" ${queryIsPayment == 2 ? "selected=\"selected\"":"" }>已付款</option>--%>
            <%--</select>--%>
            <%--<input type="hidden" name="pageIndex" value="1"/>--%>
            <%--<input value="查 询" type="submit" id="searchbutton">--%>
            <%--<span><button type="button" id="btnExport">导出excel</button></span>--%>
            <%--<a href="${pageContext.request.contextPath }/bill/billadd.html">添加订单</a>--%>
        <%--</form>--%>
    <%--</div>--%>
<table id="billlist" lay-filter="test"></table>
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
            elem: '#billlist'
            , height: 360
            , url: '/bill/json/billlist' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'billCode', title: '订单编码', width: 140, sort: true}
                , {field: 'productName', title: '商品名称', width: 140, sort: true}
                , {field: 'providerName', title: '供应商', width: 140, sort: true}
                , {field: 'productCount', title: '订单金额(元)', width: 140}
                , {field: 'isPayment', title: '是否付款', width: 140}
                , {field: 'isin', title: '是否入库', width: 140, sort: true}
                , {field: 'creationDate', title: '创建时间', width: 178, sort: true}
                , {fixed: 'right', title: '操作', width: 178, align: 'center', toolbar: '#toolbar'}
            ]], done: function (res, curr, count) {
                $("[data-field = 'isin']").children().each(function () {

                    if ($(this).text() === '1') {
                        $(this).text("是");
                    } else if ($(this).text() === '2') {
                        $(this).text("否");
                    }
                });
                $("[data-field = 'isPayment']").children().each(function () {

                    if ($(this).text() === '1') {
                        $(this).text("是");
                    } else if ($(this).text() === '2') {
                        $(this).text("否");
                    }
                });
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
