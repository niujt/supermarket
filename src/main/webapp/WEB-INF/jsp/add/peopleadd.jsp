<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>人事管理页面 >> 员工添加页面</span>
     </div>
     <div class="providerAdd">
         <form id="peopleForm" name="peopleForm" method="post" action="${pageContext.request.contextPath }/people/savepeople.html">
             <!--div的class 为error是验证错误，ok是验证成功-->
             <div class="">
                 <label for="peopleName">姓名：</label>
                 <input type="text" name="peopleName" class="text" id="peopleName" value=""> 
				 <!-- 放置提示信息 -->
				 <font color="red"></font>
             </div>
             <div>
                 <label for="peopleAge">年龄：</label>
                 <input type="text" name="peopleAge" id="peopleAge" value=""> 
				 <font color="red"></font>
             </div>
             <div>
                <label >职位：</label>
				<!-- 列出所有的职位分类 -->
				 <select name="deptid" id="querydeptid">
				</select>
             </div>
             <div>
                 <label for="salary">薪水：</label>
                 <input type="text" name="salary" id="salary" value=""> 
				 <font color="red"></font>
             </div>
             <div>
                <label>性别：</label> <select name="gender" id="gender">
					<option value="1" selected="selected">男</option>
					<option value="2">女</option>
				</select>
             </div>
             <div class="providerAddBtn">
                  <input type="button" name="add" id="add" value="保存">
				  <input type="button" id="back" name="back" value="返回">
             </div>
         </form>
     </div>
 </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/peopleadd.js"></script>