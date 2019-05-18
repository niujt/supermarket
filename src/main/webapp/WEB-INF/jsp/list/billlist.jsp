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
<div class="demoTable">
    商品名称：
    <div class="layui-inline">
        <input class="layui-input" name="productName" id="productName" autocomplete="off">
    </div>
    供应商名称：
    <div class="layui-inline">
        <input class="layui-input" name="providerName" id="providerName" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
    <button type="button" class="layui-btn "
            onclick="addHtml('/bill/billadd.html')">添加订单
    </button>
</div>
<table id="billlist" lay-filter="test"></table>
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
            elem: '#billlist'
            ,id:'testReload'
            , height: 500
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
                    del("/bill/deletebillbyid/" + data.id);
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                editHtml('/bill/updatebill.html/' + data.id);
            }
        });

        var $ = layui.$, active = {
            reload: function () {
                var productName = $('#productName');
                var providerName = $('#providerName');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                            productName: productName.val(),
                            providerName: providerName.val()
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
