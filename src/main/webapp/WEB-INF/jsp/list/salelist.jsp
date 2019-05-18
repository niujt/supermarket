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
<div class="demoTable">
	销售编码：
	<div class="layui-inline">
		<input class="layui-input" name="scode" id="scode" autocomplete="off">
	</div>
	商品名称：
	<div class="layui-inline">
		<input class="layui-input" name="sname" id="sname" autocomplete="off">
	</div>
	<button class="layui-btn" data-type="reload">搜索</button>
	<button type="button" class="layui-btn "
			onclick="addHtml('/sale/saleadd.html')">添加订单
	</button>
</div>
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
			,id:'testReload'
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
					del("/sale/deletesalebyid/"+data.id);
					obj.del();
					layer.close(index);
				});
			} else if (obj.event === 'edit') {
				editHtml("/sale/updatesale.html/"+data.id);
			}
		});
		var $ = layui.$, active = {
			reload: function () {
				var sname = $('#sname');
				var scode = $('#scode');
				//执行重载
				table.reload('testReload', {
					page: {
						curr: 1 //重新从第 1 页开始
					}
					, where: {
						sname: sname.val(),
						scode: scode.val()
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
</html>