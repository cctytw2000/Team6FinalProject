<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>商品資料</title>
</head>

<body>

	<section>
		<div>
			<div class="container" style="text-align: center">
				<h2>產品資料</h2>
			</div>
		</div>
	</section>
	<section class="container" >
		<div class="row">
			<img width='200' height='200'
				src="<c:url value='/getPicture/${product.game_id}'/>" />
			<div class="col-md-5">
				<h3>${product.name }</h3>
				<p>發行商: ${product.publisher }</p>
				<p>售價:NT ${product.price }元</p>
				<p>庫存: ${product.stock}</p>
				<p>商品分類: ${product.category}</p>
				<p>商品簡介:${product.game_desc }</p>
				<p>
					<a href="<spring:url value='/products' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>返回
					</a> 
					<a href='addToCart?game_id=${product.game_id }&count=1' class='btn btn-warning btn-large'> 
						<span class='glyphicon-shopping-cart glyphicon'></span>加入購物車
					</a>
				</p>
			</div>
		</div>
	</section>
</body>

</html>