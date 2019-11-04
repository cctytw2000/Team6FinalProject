<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>訂單</title>
</head>

<body style="background-image: url(<c:url value='/Images/pattern.png' />)">
	<jsp:include page="header/homeHeader.jsp" />


	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">重要消息</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">
				<c:forEach var="product" items="${sessionScope.products }">
					<div class="nt-item">
						<span class="new">${product.category.category }</span><a
							href="<spring:url value='product?game_id=${product.game_id }'/>">${product.name }</a><span>
							只要NT ${product.price }元</span>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- Latest news section end -->

	<section class="footer-top-section" style="height: auto;">
		<div style="height: auto;color:white;" class="container">
			<div class="footer-top-bg">
				<img src="../Images/footer-top-bg.png" alt="">
			</div>

			<h2 align="center" style="color:white">${sessionScope.mem.username }的訂單</h2><br>
			<c:choose>
				<c:when test="${empty orders }">
					<div align="center">
						<h3 style="color: white">您沒有訂單紀錄</h3>
					</div>
				</c:when>

				<c:otherwise>
					<div align="center" style="width:60%;margin:15px auto">
						<table border="1" style="text-align:center;width:100%">
							<tr>
								<th>訂單編號
								<th>訂單時間
								<th>訂單金額
								<th>狀態
									<c:forEach var="order" items="${orders}">
							<tr>
								<td><a href="showOrderDetail?order_id=${order.order_id }">${order.order_id }</a>
								<td>${order.ordertime.replace(".0","")}
								<td><span style="color:yellow;font-size:23px">${order.total}</span><span
										style="font-size:23px;float:right">元</span>
									<c:choose>
										<c:when test="${order.state == 1}">
								<td style="color:red">未付款</td>
								</c:when>
			</c:choose>
			</c:forEach>
			</table>
		</div>
		</c:otherwise>
		</c:choose>
		</div>

	</section>
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>

<%-- 	<jsp:include page="footer/homeFooter.jsp" /> --%>
</body>

</html>