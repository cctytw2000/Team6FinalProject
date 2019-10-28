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
<h1>商城</h1>
	<form method="GET" action="queryCategory">
		商品分類<select name="category">
			<option value="-1">請挑選</option>
			<c:forEach var="category" items="${categories }">
				<option value="${category }">${category }</option>
			</c:forEach>
		</select>
		<input type="submit" value="查詢">
	</form>
	<c:forEach var="product" items="${products }">
		<table>
			<tr><td>商品名稱<td><a href="<spring:url value='product?game_id=${product.game_id }'/>">${product.name }</a>
			<tr><td>商品售價<td>NT ${product.price }元
			<tr><td>商品分類<td>${product.category }
		</table>
		<hr>
	</c:forEach>
</body>
</html>