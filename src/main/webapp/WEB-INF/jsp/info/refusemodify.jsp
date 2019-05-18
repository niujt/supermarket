<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
	<title>超市管理系统</title>
</head>
<form method="post" action="" class="layui-form" enctype="multipart/form-data">
	<table class="layui-table" lay-skin="row" lay-size="lg">
		<tr>
			<td>退货单编码：</td>
			<td>
				<input class="layui-input" type="text" name="refCode" value="${refuse.refCode}">
				<input class="layui-input" type="hidden" name="id" value="${refuse.id}">
			</td>
		</tr>
		<tr>
			<td>退货商品名称：</td>
			<td><input class="layui-input" type="text" name="refName"  value="${refuse.refName}"></td>
		</tr>
		<tr>
			<td>退货数量：</td>
			<td><input  class="layui-input" type="text" name="refnumber" value="${refuse.refnumber}"></td>
		</tr>
		<tr>
			<td>退货理由：</td>
			<td>
				<input  class="layui-input" type="text" name="refReasion" value="${refuse.refReasion}">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" class="layui-btn layui-btn-primary"  value="保存">
			</td>
		</tr>

	</table>
</form>
</html>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/static/js/layui.all.js"></script>