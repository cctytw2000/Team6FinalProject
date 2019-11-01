<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>訂單</title>
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
						<span class="new">${product.category }</span><a href="<spring:url value='product?game_id=${product.game_id }'/>">${product.name }</a><span> 只要NT ${product.price }元</span>
					</div>
				</c:forEach>
            </div>
        </div>
    </div>
    <!-- Latest news section end -->
    
    <section class="footer-top-section" style="height: 495px;">
        <div style="height: 378px;color:white;" class="container">
            <div class="footer-top-bg">
                <img src="../Images/footer-top-bg.png" alt="">
            </div>
    
	<h2 align="center"  style="color:white">${sessionScope.mem.username }的訂單</h2><br>
		<div align="center">
			訂單時間${sessionScope.order.ordertime}<br>
			總金額${sessionScope.order.total }元<p>
			<table border="1" style="text-align:center">
 				<tr><th>商品編號<th>商品名稱<th>數量<th>金額
				<c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
					<tr><td><input type="hidden" name="game_id" value="${cartItem.product.game_id}">${cartItem.product.game_id}
					<td>${cartItem.product.name}
					<td>${cartItem.count}
					<td>${cartItem.subtotal}元
				</c:forEach>
			</table>
		</div>
	 </div>

    </section>
	
	<jsp:include page="footer/homeFooter.jsp" />
</body>
</html>