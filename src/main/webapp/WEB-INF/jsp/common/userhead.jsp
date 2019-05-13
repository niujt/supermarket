<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/public.css" />
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>超市管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> ${userSession.userName }</span> , 欢迎你！</p>
            <a href="${pageContext.request.contextPath }/sys/user/outLogin.html">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2018年4月2日 11:11  星期一</span>
    </section>
 <!--主体内容-->
 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
              <li ><a href="${pageContext.request.contextPath }/bill/billlist.html">订单管理</a></li>
              <li><a href="${pageContext.request.contextPath }/provider/providerlist.html">供应商管理</a></li>
              <li><a href="${pageContext.request.contextPath }/refuse/refuselist.html">退货单管理</a></li>
              <li><a href="${pageContext.request.contextPath }/people/peoplelist.html">人事管理</a></li>
              <li><a href="${pageContext.request.contextPath }/sale/salelist.html">销售管理</a></li>
              <li><a href="${pageContext.request.contextPath }/goods/goodslist.html">库存管理</a></li>
              <li><a href="${pageContext.request.contextPath }/user/updatepass.html">密码修改</a></li>
              <li><a href="${pageContext.request.contextPath }/sys/user/outLogin.html">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>