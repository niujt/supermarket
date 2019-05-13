<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>退货管理页面 >> 退货修改页面</span>
	</div>
	<div class="providerAdd">
		<form id="refuseForm" name="refuseForm" method="post"
			action="${pageContext.request.contextPath }/refuse/saveupdaterefuse.html">
			<input type="hidden" name="id" value="${refuse.id }" />
			<span style="color:red">${error }</span>
			<div>
			
				<label for="refCode">退货单编码：</label> <input type="text"
					value="${refuse.refCode }" readonly="readonly">
			</div>
			<div>
				<label for="refName">退货名称：</label> <input type="text"
					name="refName" id="refName" value="${refuse.refName }" readonly="readonly"> <font
					color="red"></font>
			</div>
			<div>
				<label for="refnumber">退货数量：</label> <input type="text"
					name="refnumber" id="refnumber" value="${refuse.refnumber }"> <font
					color="red"></font>
			</div>
			<div>
				<label for="refReasion">退货理由：</label> <input type="text"
					name="refReasion" id="refReasion" value="${refuse.refReasion }"> <font
					color="red"></font>
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
	src="${pageContext.request.contextPath }/statics/js/refusemodify.js"></script>
