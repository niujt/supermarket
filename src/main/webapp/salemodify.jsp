<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>销售单管理页面 >> 销售单修改页面</span>
	</div>
	<div class="providerAdd">
		<form id="saleForm" name="saleForm" method="post"
			action="${pageContext.request.contextPath }/sale/saveupdatesale.html">
			<input type="hidden" name="id" value="${sale.id }">
			<!--div的class 为error是验证错误，ok是验证成功-->
			<div class="">
				<label for="scode">销售编码：</label> <input type="text"
					name="scode" id="scode" value="${sale.scode}"
					readonly="readonly">
			</div>
			<div>
				<label for="sname">售货名称：</label>
				<select id="sname" name="sname">	
				</select>
				<font color="red"></font>
			</div>
			<div>
				<label for="snumber">销售数量：</label> <input type="text"
					name="snumber" id="snumber" value="${sale.snumber}">
				<font color="red"></font>
			</div>
			<div>
				<label for="sprice">售价：</label> <input type="text"
					name="sprice" id="sprice" value="${sale.sprice}">
				<font color="red"></font>
			</div>
			<div class="providerAddBtn">
				<input type="button" name="save" id="save" value="保存"> <input
					type="button" id="back" name="back" value="返回">
			</div>
		</form>
	</div>

</div>
</section>

<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/salemodify.js"></script>