<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>库存管理页面 >> 库存添加页面</span>
     </div>
     <div class="providerAdd">
         <form id="goodsForm" name="goodsForm" method="post" action="${pageContext.request.contextPath }/goods/savegoods.html">
             <!--div的class 为error是验证错误，ok是验证成功-->
             <font color="red">${error }</font>
             <div class="">
             	
                 <label for="gcode">编码：</label>
                 <input type="text" name="gcode" class="text" id="gcode" value=""> 
				 <!-- 放置提示信息 -->
				 <font color="red"></font>
             </div>
             <div>
                 <label for="gname">商品名称：</label>
                 <input type="text" name="gname" id="gname" value=""> 
				 <font color="red"></font>
             </div>
             <div>
                 <label for="gnumber">数量：</label>
                 <input type="text" name="gnumber" id="gnumber" value=""> 
				 <font color="red"></font>
             </div>
             <div>
                 <label for="gunit">单位：</label>
                 <select id="gunit" name="gunit">
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
                 <label for="pprice">进价：</label>
                 <input type="text" name="pprice" id="pprice" value=""> 
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
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/goodsadd.js"></script>