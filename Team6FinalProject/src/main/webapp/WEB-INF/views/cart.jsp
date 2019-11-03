<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>購物車</title>
</head>
<body>
	<jsp:include page="header/homeHeader.jsp" />


    <!-- Latest news section -->
    <div class="latest-news-section">
        <div class="ln-title">重要消息</div>
        <div class="news-ticker">
            <div class="news-ticker-contant">
                <c:forEach var="product" items="${sessionScope.products }">
					<div class="nt-item">
						<span class="new">${product.category.category }</span><a href="<spring:url value='product?game_id=${product.game_id }'/>">${product.name }</a><span> 只要NT ${product.price }元</span>
					</div>
				</c:forEach>
            </div>
        </div>
    </div>
    <!-- Latest news section end -->



    <section class="footer-top-section" style="height: auto;">
        <div style="height: 378px" class="container">




    <h2 align="center" style="color:white;">購物車</h2><br>
    <c:choose>
		<c:when test="${empty sessionScope.cart or fn:length(sessionScope.cart.cartItems) eq 0 }">
			<div align="center">
				<h3 style="color:white">您的購物車是空的，趕緊去購物</h3>
				<img src="<c:url value='/Images/emptycart-removebg.png' />"/>
			</div>
		</c:when>
		<c:otherwise>
	<div align="center" style="color:white;">
		<table border="1" style="text-align:center">
			<tr><th>商品編號<th>商品名稱<th>數量<th>金額<th>刪除
			<c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
				<tr><td><input type="hidden" name="game_id" value="${cartItem.product.game_id}">${cartItem.product.game_id}
				<td>${cartItem.product.name}
				<td>${cartItem.count}
				<td>${cartItem.subtotal}元
				<td><button type="button" onclick="window.location.href='removeCartItem?game_id=${cartItem.product.game_id}'">刪除</button>
			</c:forEach>
			<tr><td colspan="5" align="right">
			<form method="post" action="clearCart">
				<input type="submit" value="清除購物車">
			</form>
		</table>
	</div>
		</c:otherwise>
	</c:choose>
	<div align="center" style="color:white;">
		<br>
		<table cellspacing="20">
			<tr><td>總金額: ${sessionScope.cart.total}元<td>
			<td><button type="button" class="btn btn-outline-warning" onclick="window.location.href='products'">繼續購物</button>
			<td><button type="button" class="btn btn-outline-warning" onclick="window.location.href='makeOrder'">確定購買</button>
		</table>
	</div>
        </div>

    </section>


	<jsp:include page="footer/homeFooter.jsp" />



</body>

</html>