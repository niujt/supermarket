<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/userhead.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>人事管理页面</span>
        </div>
        <div class="search">
        	<form method="post" action="${pageContext.request.contextPath }/people/peoplelist.html" enctype="multipart/form-data">
				<span>姓名：</span>
				<input name="queryPeopleName" type="text" value="${queryPeopleName }">
				<span>职位：</span>
				<select name="querydeptid"  id="querydeptid"></select>
				<input type="hidden" name="pageIndex" value="1"/>
				<input value="查 询" type="submit" id="searchbutton">
			</form>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">姓名</th>
                <th width="10%">年龄</th>
                <th width="10%">职位</th>
                <th width="10%">薪水</th>
                <th width="10%">性别</th>
                <th width="10%">创建时间</th>
                <th width="40%">操作</th>
            </tr>
            <c:forEach var="people" items="${peopleList }" varStatus="status">
				<tr>
					<td>
					<span>${people.peopleName }</span>
					</td>
					<td>
					<span>${people.peopleAge }</span>(周岁)
					</td>
					<td>
					<a href="#" onclick="showdept()"><c:if test="${people.deptid==1}">普通员工</c:if> <c:if
							test="${people.deptid==2}">经理</c:if> </a>
					</td>
					<td>
					<span>${people.salary}</span>(元)
					</td>
					<td>
					 <span><c:if test="${people.gender==1}">男</c:if> <c:if
							test="${people.gender==2}">女</c:if> </span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${people.creationDate}" pattern="yyyy-MM-dd"/>
					</span>
					</td>
					<td>
					<span><a class="viewPeople" href="javascript:;" peoid="${people.id }" peoname="${people.peopleName }"><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
					</td>
				</tr>
			</c:forEach>
        </table>
			<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
		  	<c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPageNo" value="${currentPageNo}"/>
	          	<c:param name="totalPageCount" value="${totalPageCount}"/>
          	</c:import>
          	
          	
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该信息吗？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/peoplelist.js"></script>
