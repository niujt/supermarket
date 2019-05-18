<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
	<title>超市管理系统</title>
</head>
<body>
<%@include file="../menu.jsp" %>


        <%--<div class="search">--%>
        	<%--<form method="post" action="${pageContext.request.contextPath }/people/peoplelist.html" enctype="multipart/form-data">--%>
				<%--<span>姓名：</span>--%>
				<%--<input name="queryPeopleName" type="text" value="${queryPeopleName }">--%>
				<%--<span>职位：</span>--%>
				<%--<select name="querydeptid"  id="querydeptid"></select>--%>
				<%--<input type="hidden" name="pageIndex" value="1"/>--%>
				<%--<input value="查 询" type="submit" id="searchbutton">--%>
				<%--<a href="${pageContext.request.contextPath }/people/peopleadd.html">添加员工</a>--%>
			<%--</form>--%>
        <%--</div>--%>
<table id="peoplelist" lay-filter="test"></table>
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
			elem: '#peoplelist'
			, height: 800
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
