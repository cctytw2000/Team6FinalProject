<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>所有訂單</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/bootstrap.min.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/font-awesome.min.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/owl.carousel.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/style.css' type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/animate.css'
	type="text/css" />
	<script src="${pageContext.request.contextPath}/JS/membersBack.js"></script>

<script src="https://kit.fontawesome.com/685268963f.js"></script>
	
	
</head>
<body>
<jsp:include page="header/manageHeader.jsp" />
<div class="container mt-3">
	<h1>訂單管理</h1>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#showorders">訂單總覽</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#productCancel">架下商品</a></li>
	</ul>
<div class="tab-content">
	<div id="showorders" class="container tab-pane active">
		<table border="1" style="text-align: center">
				<tr><th>訂單編號<th>商品細項編號<th>商品名稱<th>商品數量<th>商品小計			
				<c:choose>				
				<c:when test="${not empty orders}">
					<c:forEach var="order" items="${orders}">
					<tr><td>${order.order.order_id}
						<td>${order.item_id}
						<td>${order.product.name}
						<td>${order.count}個
						<td>${order.subtotal}元							
					</c:forEach>
				</c:when>
				<c:otherwise>
					查無訂單資料
				</c:otherwise>
				</c:choose>
		</table>
	</div>	
	<div id="productCancel" class="container tab-pane fade">
	
	</div>
</div>
</div>
<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script	src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>		
</body>
</html>