<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
    <title>超市管理系统</title>
</head>
<body>
<%@include file="menu.jsp" %>
<%--<div class="search">--%>
<%--<form method="POST"--%>
<%--action="${pageContext.request.contextPath}/user/userlist.html">--%>
<%--<span>用户名：</span> <input name="queryname" class="input-text"--%>
<%--type="text" value="${queryUserName}"> <span>用户角色：</span> <select--%>
<%--name="queryUserRole">--%>
<%--<c:if test="${roleList != null}">--%>
<%--<option value="">--请选择--</option>--%>
<%--<c:forEach var="role" items="${roleList}">--%>
<%--<option--%>
<%--<c:if test="${role.id == queryUserRole}">selected="selected"</c:if>--%>
<%--value="${role.id}">${role.roleName}</option>--%>
<%--</c:forEach>--%>
<%--</c:if>--%>
<%--</select> <input type="hidden" name="pageIndex" value="1" /> <input--%>
<%--value="查 询" type="submit" id="searchbutton"> <a--%>
<%--href="${pageContext.request.contextPath}/user/adduser.html">添加用户</a>--%>
<%--</form>--%>
<%--</div>--%>
<!--用户-->
<div style="margin-bottom: 5px;">

    <!-- 示例-970 -->
    <ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>

</div>

<div class="layui-btn-group demoTable">
    <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>
    <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
    <button class="layui-btn" data-type="isAll">验证是否全选</button>
</div>

<table id="userlist" lay-filter="test"></table>
<script type="text/html" id="toolbar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
        <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
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
            , height: 312
            , url: '/user/json/userlist' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {type:'checkbox', fixed: 'left'}
                ,{field: 'userCode', title: '用户编码', width: 140, sort: true}
                , {field: 'userName', title: '用户名称', width: 140, sort: true}
                , {field: 'gender', title: '性别', width: 140, sort: true}
                , {field: 'age', title: '年龄', width: 140}
                , {field: 'phone', title: '电话', width: 140}
                , {field: 'userRole', title: '用户角色', width: 140, sort: true}
                ,{fixed: 'right', width:178, align:'center', toolbar: '#toolbar'}
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
        table.on('checkbox(test)', function(obj){
            console.log(obj)
        });
        //监听事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });
        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            ,getCheckLength: function(){ //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
            }
            ,isAll: function(){ //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选': '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });

</script>
</html>

