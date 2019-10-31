<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>所有商品</title>
</head>

<body>
	

	<section>
		<div>
			<div class="container" style="text-align: center">
				<h1>商品清單</h1>
			</div>
		</div>
	</section>
	
	<form method="GET" action="queryCategory">
		商品分類<select name="category">
			<option value="-1">請挑選</option>
			<c:forEach var="category" items="${categories }">
				<option value="${category }">${category }</option>
			</c:forEach>
		</select>
		<input type="submit" value="查詢">
	</form>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
		
	<section class="container">
		<div class="row">
			<c:forEach var="product" items="${products }">
				<div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
					<div class="thumbnail" style="width: 320px; height: 340px">
						<img width='150' height='150'
							src="<c:url value='/getPicture/${product.game_id}' />" />
						<div class="caption">
							<p align="center"><a href="<spring:url value='product?game_id=${product.game_id }'/>">${product.name }</a></p>
							<p align="center">NT ${product.price }元</p>
							<p align="center">${product.category }</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section> 
</html>