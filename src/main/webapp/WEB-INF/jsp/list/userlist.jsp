<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
<table>
    <form method="POST" class="layui-form"
          action="/user/userlist.html">
        <tr>
            <td><span>&nbsp;&nbsp;&nbsp;&nbsp;用户名：</span></td>
            <td>
                <input name="queryname" class="layui-input"
                        type="text" value="${queryUserName}">
            </td>
            <td><span>&nbsp;&nbsp;&nbsp;&nbsp;用户角色：</span></td>
            <td>
                <select name="queryUserRole">
                    <%--<c:if test="${roleList != null}">--%>
                    <%--<option value="">--请选择--</option>--%>
                    <%--<c:forEach var="role" items="${roleList}">--%>
                    <%--<option--%>
                    <%--<c:if test="${role.id == queryUserRole}">selected="selected"</c:if>--%>
                    <%--value="${role.id}">${role.roleName}</option>--%>
                    <%--</c:forEach>--%>
                    <%--</c:if>--%>
                </select>
            </td>
            <td><input value="查 询" type="submit" id="searchbutton" class="layui-btn layui-btn-normal">
            </td>
            <td>
                <button class="layui-btn layui-btn-normal"
                        onclick="location.href='/user/adduser.html'">添加用户
                </button>
            </td>
        </tr>
    </form>
</table>

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
            , height: 360
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

