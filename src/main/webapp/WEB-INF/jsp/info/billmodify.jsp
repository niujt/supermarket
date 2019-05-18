<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/static/css/layui.min.css">
	<title>超市管理系统</title>
</head>
<form  onsubmit="return edit('/bill/saveupdatebill.html')" class="layui-form" enctype="multipart/form-data">
	<table class="layui-table" lay-skin="row" lay-size="lg">
		<tr>
			<td>订单编码：</td>
			<td>
				<input class="layui-input" type="text" name="billCode" value="${bill.billCode}">
				<input class="layui-input" type="hidden" name="id" value="${bill.id}">
			</td>
		</tr>
		<tr>
			<td>商品名称：</td>
			<td><input class="layui-input" type="text" name="productName" value="${bill.productName}"></td>
		</tr>
		<tr>
			<td>单位：</td>
			<td>
				<select name="productUnit" >
					<option value="瓶" <c:if test="${bill.productUnit} == '瓶'">selected</c:if>>瓶</option>
					<option value="斤" <c:if test="${bill.productUnit} == '斤'">selected</c:if>>斤</option>
					<option value="个" <c:if test="${bill.productUnit} == '个'">selected</c:if>>个</option>
					<option value="根" <c:if test="${bill.productUnit} == '根'">selected</c:if>>根</option>
					<option value="条" <c:if test="${bill.productUnit} == '条'">selected</c:if>>条</option>
					<option value="只" <c:if test="${bill.productUnit} == '只'">selected</c:if>>只</option>
					<option value="颗" <c:if test="${bill.productUnit} == '颗'">selected</c:if>>颗</option>
					<option value="箱" <c:if test="${bill.productUnit} == '箱'">selected</c:if>>箱</option>
					<option value="束" <c:if test="${bill.productUnit} == '束'">selected</c:if>>束</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>商品金额：</td>
			<td>
				<input class="layui-input" type="text" name="productCount" value="${bill.productCount}">
			</td>
		</tr>
		<tr>
			<td>总金额：</td>
			<td>
				<input class="layui-input" type="text" name="totalPrice" value="${bill.totalPrice}">
			</td>
		</tr>
		<tr>
			<td>供应商：</td>
			<td>
				<select name="providerId">

					<c:forEach var="p" items="${providers}">
						<option value="${p.id}" <c:if test="${bill.productName==p.proName}">selected</c:if>>${p.proName}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>是否付款：</td>
			<td>
				<input type="radio" name="isPayment" value="1" <c:if test="${bill.isPayment==1}">checked</c:if>>已付款
				<input type="radio" name="isPayment" value="2" <c:if test="${bill.isPayment==2}">checked</c:if>>未付款
			</td>
		</tr>
		<tr>
			<td>是否入库：</td>
			<td>
				<select name="isin" >
					<option value="1" <c:if test="${bill.isin==1}">selected</c:if>>入库</option>
					<option value="2" <c:if test="${bill.isin==2}">selected</c:if>>未入库</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" class="layui-btn layui-btn-primary" value="保存">
			</td>
		</tr>

	</table>
</form>
</html>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/static/js/layui.all.js"></script>
<%@include file="../foot.jsp" %>