<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>消息後台</title>
</head>
<body>
	<h1>消息後台功能</h1>
	<h3>新增消息類別</h3>
	<form action="newsBack/addNewsType">
		<input type="text" name="newsTypeName"> <input type="submit"
			value="送出">
	</form>
	<br>
	<h3>新增遊戲類別</h3>
	<form action="newsBack/addGameType">
		<input type="text" name="gameTypeName"> <input type="submit"
			value="送出">
	</form>
	<br>
	<h3>新增活動類別</h3>
	<form action="newsBack/addActivityType">
		<input type="text" name="activityTypeName"> <input
			type="submit" value="送出">
	</form>
	<br>
	<h3>
		<a href="newsBack/addGame">新增遊戲</a>
	</h3>
	<br>
	<h3>
		<a href="newsBack/addActivity">新增活動</a>
	</h3>
	<br>
	<h3>
		<a href="newsBack/addNews">新增消息</a>
	</h3>
	<br>
	<%-- 	<c:forEach var="product" items="${products }"> --%>
	<!-- 		<table> -->
	<!-- 			<tr> -->
	<!-- 				<td>商品名稱 -->
	<%-- 				<td><a href="<spring:url value='product?game_id=${product.game_id }'/>">${product.name }</a> --%>
	<!-- 			<tr> -->
	<!-- 				<td>商品售價 -->
	<%-- 				<td>NT ${product.price }元 --%>
	<!-- 			<tr> -->
	<!-- 				<td>商品分類 -->
	<%-- 				<td>${product.category.category } --%>
	<!-- 		</table> -->
	<%-- 		<form method="GET" action="products/update"> --%>
	<%-- 			<input type="hidden" name="game_id" value="${product.game_id }"> --%>
	<!-- 			<input type="submit" value="更新"> -->
	<%-- 		</form> --%>
	<%-- 		<form method="GET" action="products/delete"> --%>
	<%-- 			<input type="hidden" name="game_id" value="${product.game_id }"> --%>
	<!-- 			<input type="submit" value="下架"> -->
	<%-- 		</form> --%>
	<!-- 		<hr> -->
	<%-- 	</c:forEach> --%>
</body>
</html>