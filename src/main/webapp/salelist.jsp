<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
       <div class="location">
           <strong>你现在所在的位置是:</strong>
           <span>销售管理页面</span>
       </div>
       <div class="search">
       <form method="post" action="${pageContext.request.contextPath }/sale/salelist.html">
			<span>销售编码：</span>
			<input name="queryscode" type="text" value="${queryscode}">
			<span>商品名称：</span>
			<input name="querysname" type="text" value="${querysname}">
			 <input type="hidden" name="pageIndex" value="1"/>
			 <input	value="查 询" type="submit" id="searchbutton">
			 <span><button type="button" id="btnExport">导出excel</button></span>
			 <a href="${pageContext.request.contextPath }/sale/saleadd.html">添加销售单</a>
		</form>
       </div>
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0" id="tblExport">
          <tr class="firstTr">
              <th width="10%">销售编码</th>
              <th width="20%">商品名称</th>
              <th width="10%">销售数量</th>
              <th width="10%">进价</th>
              <th width="10%">售价</th>
              <th width="10%">利润</th>
              <th width="10%">创建时间</th>
              <th width="30%">操作</th>
          </tr>
          <c:forEach var="s" items="${sale}" varStatus="status">
				<tr>
					<td>
					<span>${s.scode}</span>
					</td>
					<td>
					<span>${s.sname}</span>
					</td>
					<td>
					<span>${s.snumber}</span>(${s.sunit})
					</td>
					<td>
					<span>${s.pprice}</span>(元)
					</td>
					<td>
					<span>${s.sprice}</span>(元)
					</td>
					<td>
					<span>${(s.sprice-s.pprice)*s.snumber}</span>(元)
					</td>
					<td>
					<span>
					<fmt:formatDate value="${s.creationDate}" pattern="yyyy-MM-dd"/>
					</span>
					</td>
					<td>
					<span><a class="viewSale" href="javascript:;" saleid=${s.id }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="modifySale" href="javascript:;" saleid=${s.id } ><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteSale" href="javascript:;" saleid=${s.id }  ><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
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
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-1.8.3.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery.table2excel.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $("#btnExport").click(function () {
        $("#tblExport").table2excel({
            exclude  : ".noExl", //过滤位置的 css 类名
            filename : "销售单-" + new Date().getTime() + ".xls" //文件名称
        });
    });
});

</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/salelist.js"></script>