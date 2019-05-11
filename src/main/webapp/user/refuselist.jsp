<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/userhead.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>退货管理页面</span>
        </div>
        <div class="search">
        	<form method="post" action="${pageContext.request.contextPath }/refuse/refuselist.html" enctype="multipart/form-data">
				<span>退货编码：</span>
				<input name="queryRefCode" type="text" value="${queryRefCode }">
				<span>退货名称：</span>
				<input name="queryRefName" type="text" value="${queryRefName}">
				<input type="hidden" name="pageIndex" value="1"/>
				<input value="查 询" type="submit" id="searchbutton">
				 <a href="${pageContext.request.contextPath }/refuse/refuseadd.html">添加退货单</a> 
			</form>
        </div>
        <!--退货列表-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">商品编码</th>
                <th width="20%">商品名称</th>
                <th width="10%">退货理由</th>
                 <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach var="refuse" items="${refuseList }" varStatus="status">
				<tr>
					<td>
					<span>${refuse.refCode }</span>
					</td>
					<td>
					<span>${refuse.refName }</span>
					</td>
					<td>
					<span>${refuse.refReasion}</span>
					</td>
					<td>
					 <span>
					<fmt:formatDate value="${refuse.creationDate}" pattern="yyyy-MM-dd"/>
					</span> 
					</td>
					<td>
					<span><a class="viewRefuse" href="javascript:;" refid=${refuse.id } refname=${refuse.refName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
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
<div class="remove" id="removeRef">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定不退该商品了么？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/refuselist.js"></script>
