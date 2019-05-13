<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>库存管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>库存编码：</strong><span>${goods.gcode}</span></p>
            <p><strong>库存商品名称：</strong><span>${goods.gname}</span></p>
            <p><strong>库存数量：</strong><span>${goods.gnumber}</span></p>
            
			<div class="providerAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/goodsview.js"></script>
