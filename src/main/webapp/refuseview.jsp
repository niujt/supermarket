<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>退货单管理页面 >> 信息查看</span>
     </div>
     <div class="providerView">
         <p><strong>退货编号：</strong><span>${refuse.refCode}</span></p>
         <p><strong>退货名称：</strong><span>${refuse.refName}</span></p>
         <p><strong>退货理由：</strong><span>${refuse.refReasion}</span></p>
		<div class="providerAddBtn">
         	<input type="button" id="back" name="back" value="返回" >
        </div>
     </div>
 </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/refuseview.js"></script>