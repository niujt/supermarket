<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>人事管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>姓名：</strong><span>${people.peopleName}</span></p>
            <p><strong>年龄：</strong><span>${people.peopleAge}</span></p>
            <p><strong>职位：</strong><span><c:if test="${people.deptid==1}">经理</c:if>
            <c:if test="${people.deptid==2}">普通员工</c:if></span></p>
            <p><strong>薪水：</strong><span>${people.salary}</span></p>
            <p><strong>性别：</strong><span><c:if test="${people.gender==1}">男</c:if>
            <c:if test="${people.gender==2}">女</c:if></span></p>       
			<div class="providerAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/peopleview.js"></script>
