<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>訂單資料</title>
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
    
    <section class="footer-top-section" style="height: 495px;">
        <div style="height: 378px;color:white;" class="container">
            <div class="footer-top-bg">
                <img src="../Images/footer-top-bg.png" alt="">
            </div>
    
	<h2 align="center"  style="color:white">訂單編號${order.order_id }</h2><br>
		<div align="center">
			<table border="1" style="text-align:center">
 				<tr><th>商品編號<th>商品名稱<th>數量<th>金額
				<c:forEach var="orderItem" items="${order.orderItems}">
					<tr><td>${orderItem.product.game_id}</td>
					<td>${orderItem.product.name}</td>
					<td>${orderItem.count}</td>
					<td>${orderItem.subtotal}元</td>
					</tr>
				</c:forEach>
			</table>
			訂單時間${order.ordertime}<br>
			總金額${order.total }元<p>
		</div>
	 </div>

    </section>
	
	<jsp:include page="footer/homeFooter.jsp" />
</body>
</html>