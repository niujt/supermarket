<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

  <div class="right">
      <div class="location">
          <strong>你现在所在的位置是:</strong>
          <span>人事管理页面 >> 员工修改页</span>
      </div>
      <div class="providerAdd">
          <form id="peopleForm" name="peopleForm" method="post" action="${pageContext.request.contextPath }/people/saveupdatepeople" enctype="multipart/form-data">
              <input type="hidden" name="id" value="${people.id }"/>
              <div>
                  <label for="peopleName">姓名：</label>
                  <input type="text" name="peopleName" id="peopleName" value="${people.peopleName}"> 
                  <font color="red"></font>
              </div>
              <div>
                  <label for="peopleAge">年龄：</label>
                 <input type="text" name="peopleAge" id="peopleAge" value="${people.peopleAge }"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="deptid">部门：</label>
                 <input type="hidden"
					value="${people.deptid }" id="pid" /> <select name="deptid"
					id="deptid">
					<c:if test="${deptlist != null }">
						<option value="">--请选择--</option>
						<c:forEach var="d" items="${deptlist}">
							<option
								<c:if test="${d.id == people.deptid}">selected="selected"</c:if>
								value="${d.id}">${d.dname}</option>
						</c:forEach>
					</c:if>
				</select> <font color="red"></font> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="salary">薪水：</label>
                  <input type="text" name="salary" id="salary" value="${people.salary }"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="gender">性别：</label>
                  <select name="gender" id="gender">
					<c:choose>
						<c:when test="${people.gender == 1 }">
							<option value="1" selected="selected">男</option>
							<option value="2">女</option>
						</c:when>
						<c:otherwise>
							<option value="1">男</option>
							<option value="2" selected="selected">女</option>
						</c:otherwise>
					</c:choose>
				</select>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/peoplemodify.js"></script>