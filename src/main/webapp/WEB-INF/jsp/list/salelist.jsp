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
<table>
	<form method="POST" class="layui-form"
		  action="/user/userlist.html">
		<tr>
			<td><span>&nbsp;&nbsp;&nbsp;&nbsp;销售编码：</span></td>
			<td>
				<input name="queryscode" class="layui-input"
					   type="text" value="${queryscode}">
			</td>
			<td><span>&nbsp;&nbsp;&nbsp;&nbsp;商品名称：</span></td>
			<td>
				<input name="queryscode" class="layui-input"
					   type="text" value="${querysname}">
			</td>

			<td><input value="查 询" type="submit" class="layui-btn layui-btn-normal">
			</td>
			<td>
				<button type="button" class="layui-btn layui-btn-normal"
						onclick="addHtml('/sale/saleadd.html')">添加销售单
				</button>
			</td>
		</tr>
	</form>
</table>
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
			, height: 500
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
				editHtml("/sale/updatesale.html/"+data.id);
			}
		});

	});
</script>
<%@include file="../foot.jsp" %>
</html>