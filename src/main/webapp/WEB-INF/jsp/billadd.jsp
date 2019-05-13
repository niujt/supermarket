<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>订单管理页面 >> 订单添加页面</span>
     </div>
     <div class="providerAdd">
         <form id="billForm" name="billForm" method="post" action="${pageContext.request.contextPath }/bill/savebill.html">
             <!--div的class 为error是验证错误，ok是验证成功-->
             <div class="">
                 <label for="billCode">订单编码：</label>
                 <input type="text" name="billCode" class="text" id="billCode" value=""> 
				 <!-- 放置提示信息 -->
				 <font color="red"></font>
             </div>
             <div>
                 <label for="productName">商品名称：</label>
                 <input type="text" name="productName" id="productName" value=""> 
				 <font color="red"></font>
             </div>
              <div>
                 <label for="productUnit">单位：</label>
                 <select id="productUnit" name="productUnit">
                 	<option value="瓶">瓶</option>
                 	<option value="斤">斤</option>
                 	<option value="个">个</option>
                 	<option value="根">根</option>
                 	<option value="条">条</option>
                 	<option value="只">只</option>
                 	<option value="颗">颗</option>
                 	<option value="箱">箱</option>
                 	<option value="束">束</option>
                 </select> 
				 <font color="red"></font>
             </div>
             <div>
                 <label for="productCount">商品金额：</label>
                 <input type="text" name="productCount" id="productCount" value=""> 
				 <font color="red"></font>
             </div>
             <div>
                 <label for="totalPrice">总金额：</label>
                 <input type="text" name="totalPrice" id="totalPrice" value=""> 
				 <font color="red"></font>
             </div>
             <div>
                 <label >供应商：</label>
                 <select name="providerId" id="providerId">
		         </select>
				 <font color="red"></font>
             </div>
             <div>
                 <label >是否付款：</label>
                 <input type="radio" name="isPayment" value="1" checked="checked">未付款
				 <input type="radio" name="isPayment" value="2" >已付款
             </div>
             
               <div>
                 <label >是否入库：</label>
                 <input type="radio" name="isin" value="1" checked="checked">未入库
				 <input type="radio" name="isin" value="2" >入库
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
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/billadd.js"></script>