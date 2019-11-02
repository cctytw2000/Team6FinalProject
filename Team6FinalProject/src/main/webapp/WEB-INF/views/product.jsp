<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" -->
<!-- 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> -->
<title>商品資料</title>
</head>

<body>
	<jsp:include page="header/homeHeader.jsp" />


			<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">重要消息</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">
			
				<c:forEach var="product" items="${products }">
					<div class="nt-item">
						<span class="new">${product.category.category }</span><a href="<spring:url value='product?game_id=${product.game_id }'/>">${product.name }</a><span> 只要NT ${product.price }元</span>
					</div>
				</c:forEach>
			
			</div>
		</div>
	</div>
	<!-- Latest news section end -->

	<div style="height:auto;background-image: url(<c:url value='/Images/pattern.png' />)">
	<section class="container" style="margin-left:25%">
		<div class="row" style="padding:30px">
			<img width='200' height='200'
				src="<c:url value='/getPicture/${product.game_id}'/>" />
			<div class="col-md-5">
				<h3 style="color:white">${product.name }</h3>
				<p>發行商: ${product.publisher }</p>
				<p>售價:NT${product.price }元</p>
				<p>庫存: ${product.stock}</p>
				<p>商品分類: ${product.category}</p>
				<p>商品簡介:${product.game_desc }</p>
				<p>
					<button type="button" class="btn btn-warning" onclick="window.location.href='products'">返回</button>
					<a href='addToCart?game_id=${product.game_id }&count=1' class='btn btn-warning btn-large'> 
						<span class='glyphicon-shopping-cart glyphicon'></span>加入購物車
					</a>
				</p>
			</div>
		</div>
		
<!-- 		<h2>test</h2> -->
<!--   		<div class="card" style="width:400px"> -->
<%--     		<img class="card-img-top" src="<c:url value='/getPicture/${product.game_id}'/>" alt="Card image" style="width:100%"> --%>
<!--     		<div class="card-body"> -->
<%--      		 <h4 class="card-title">${product.name }</h4> --%>
<%--      		 <p class="card-text">${product.publisher }</p> --%>
<%--      	 	<p class="card-text">售價:NT${product.price }元</p> --%>
<%--       		<p class="card-text">庫存: ${product.stock}</p> --%>
<%--      		 <p class="card-text">商品分類: ${product.category}</p> --%>
<%--       		<p class="card-text">商品簡介:${product.game_desc }元</p> --%>
<!--       		<a href="#" class="btn btn-primary">See Profile</a> -->
<!--     		</div> -->
<!--   		</div> -->
		
	</section>
	

	
	</div>
	<jsp:include page="footer/homeFooter.jsp" />
	
</body>

</html>