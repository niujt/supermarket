<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

  <div class="right">
      <div class="location">
          <strong>你现在所在的位置是:</strong>
          <span>库存管理页面 >> 库存修改页</span>
      </div>
      <div class="providerAdd">
          <form id="goodsForm" name="goodsForm" method="post" action="${pageContext.request.contextPath }/goods/saveupdategoods" enctype="multipart/form-data">
              <input type="hidden" name="id" value="${goods.id }"/>
              <!--div的class 为error是验证错误，ok是验证成功-->
              <div class="">
                  <label for="gcode">库存编码：</label>
                  <input type="text" name="gcode" id="gcode" value="${goods.gcode}" readonly="readonly"> 
              </div>
              <div>
                  <label for="gname">库存商品名称：</label>
                 <input type="text" name="gname" id="gname" value="${goods.gname }"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="gnumber">库存数量：</label>
                  <input type="text" name="gnumber" id="gnumber" value="${goods.gnumber }"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="pprice">进价：</label>
                  <input type="text" name="pprice" id="pprice" value="${goods.pprice}"> 
			<font color="red"></font>
              </div>
              <div class="providerAddBtn">
                  <input type="button" name="save" id="save" value="保存">
				  <input type="button" id="back" name="back" value="返回" >
              </div>
          </form>
      </div>
  </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/goodsmodify.js"></script>