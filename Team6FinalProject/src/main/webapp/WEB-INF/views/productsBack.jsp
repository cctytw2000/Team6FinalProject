<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有商品</title>
</head>
<body>
<h1>商城後台</h1>
	<form method="GET" action="queryCategory">
		商品分類<select name="category">
			<option value="-1">請挑選</option>
			<c:forEach var="category" items="${categories }">
				<option value="${category }">${category }</option>
			</c:forEach>
		</select>
		<input type="submit" value="查詢">
	</form>
	<h3><a href="products/add">新增商品</a></h3><br>
	<c:forEach var="product" items="${products }">
		<table>
			<tr><td>商品名稱<td><a href="<spring:url value='product?game_id=${product.game_id }'/>">${product.name }</a>
			<tr><td>商品售價<td>NT ${product.price }元
			<tr><td>商品分類<td>${product.category }
		</table>
		<form method="GET" action="products/update">
			<input type="hidden" name="game_id" value="${product.game_id }">
			<input type="submit" value="更新">
		</form>
		<form method="GET" action="products/delete">
			<input type="hidden" name="game_id" value="${product.game_id }">
			<input type="submit" value="下架">
		</form>
		<hr>
	</c:forEach>
</body>
</html>