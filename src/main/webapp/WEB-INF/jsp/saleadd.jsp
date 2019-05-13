<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>销售管理页面 >> 销售单添加页面</span>
     </div>
     <div class="providerAdd">
         <form id="saleForm" name="saleForm" method="post" action="${pageContext.request.contextPath }/sale/savesale.html">
             <!--div的class 为error是验证错误，ok是验证成功-->
             <div>
             	<span style="color:red">${error}</span>
             </div>
             <div class="">
                 <label for="scode">销售单编码：</label>
                 <input type="text" name="scode" class="text" id="scode" value=""> 
				 <!-- 放置提示信息 -->
				 <font color="red"></font>
             </div>
             <div>
                 <label>售货名：</label>
                 <select id="sname" name="sname" ></select>
				 <font color="red"></font>
             </div>
             <div>
                 <label for="snumber">销售数量：</label>
                 <input type="text" name="snumber" id="snumber" value="">
				 <font color="red"></font>
             </div>
             <div>
                 <label for="sprice">售价：</label>
                 <input type="text" name="sprice" id="sprice" value=""> 
				 <font color="red"></font>
             </div>
             <div class="providerAddBtn">
                  <input type="button" name="add" id="add" value="保存">
				  <input type="button" id="back" name="back" value="返回" >
             </div>
         </form>
     </div>
 </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/saleadd.js"></script>