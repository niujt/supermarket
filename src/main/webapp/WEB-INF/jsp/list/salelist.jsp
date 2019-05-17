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
<hr>

       <%--<div class="search">--%>
       <%--<form method="post" action="${pageContext.request.contextPath }/sale/salelist.html">--%>
			<%--<span>销售编码：</span>--%>
			<%--<input name="queryscode" type="text" value="${queryscode}">--%>
			<%--<span>商品名称：</span>--%>
			<%--<input name="querysname" type="text" value="${querysname}">--%>
			 <%--<input type="hidden" name="pageIndex" value="1"/>--%>
			 <%--<input	value="查 询" type="submit" id="searchbutton">--%>
			 <%--<span><button type="button" id="btnExport">导出excel</button></span>--%>
			 <%--<a href="${pageContext.request.contextPath }/sale/saleadd.html">添加销售单</a>--%>
		<%--</form>--%>
       <%--</div>--%>
<table id="salelist" lay-filter="test"></table>
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
			elem: '#salelist'
			, height: 360
			, url: '/sale/json/salelist' //数据接口
			, page: true //开启分页
			, cols: [[ //表头
				{field: 'scode', title: '销售编码', width: 140, sort: true}
				, {field: 'sname', title: '商品名称', width: 140, sort: true}
				, {field: 'snumber', title: '销售数量', width: 140, sort: true}
				, {field: 'pprice', title: '进价(元)', width: 140}
				, {field: 'sprice', title: '售价(元)', width: 140}
				, {field: 'profit', title: '利润(元)', width: 140, sort: true}
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
</html>