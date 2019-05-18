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
    <form method="POST" class="layui-form"
          action="/user/userlist.html">
        <tr>
            <td><span>&nbsp;&nbsp;&nbsp;&nbsp;供应商编码：</span></td>
            <td>
                <input name="queryProCode" class="layui-input"
                       type="text" value="${queryProCode}">
            </td>
            <td><span>&nbsp;&nbsp;&nbsp;&nbsp;供应商名称：</span></td>
            <td>
                <input name="queryProName" class="layui-input"
                       type="text" value="${queryProName}">
            </td>

            <td><input value="查 询" type="submit" class="layui-btn layui-btn-normal">
            </td>
            <td>
                <button type="button" class="layui-btn layui-btn-normal"
                        onclick="addHtml('/provider/provideradd.html')">添加供应商
                </button>
            </td>
        </tr>
    </form>
</table>
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
            , height: 500
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
                    del("/provider/deleteprovider/"+data.id);
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                editHtml('/provider/updateprovider.html/'+data.id);
            }
        });

    });
</script>
<%@include file="../foot.jsp" %>
</body>
</html>
