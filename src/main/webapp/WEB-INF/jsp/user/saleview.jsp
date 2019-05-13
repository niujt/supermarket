<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>销售管理页面 >> 信息查看</span>
     </div>
     <div class="providerView">
         <p><strong>销售编码：</strong><span>${sale.scode}</span></p>
         <p><strong>商品名称：</strong><span>${sale.sname}</span></p>
         <p><strong>销售数量：</strong><span>${sale.snumber}</span></p>
         <p><strong>售价：</strong><span>${sale.sprice}</span></p>
		<div class="providerAddBtn">
         	<input type="button" id="back" name="back" value="返回" >
        </div>
     </div>
 </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/saleview.js"></script>