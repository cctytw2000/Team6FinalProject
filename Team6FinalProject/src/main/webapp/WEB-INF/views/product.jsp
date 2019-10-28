<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品資料</title>
</head>
<body>
	<h1 align="center">商品資料</h1>
	<table align="center">
		<tr><td width="100px">商品名稱<td width="500px">${product.name }		
		<tr><td width="100px">商品分類<td width="500px">${product.category }
		<tr><td width="100px">廠商名稱<td width="500px">${product.publisher }
		<tr><td width="100px">商品售價<td width="500px">NT ${product.price }元
		<tr><td width="100px">商品庫存<td width="500px">${product.stock }
		<tr><td width="100px">商品描述<td width="500px">${product.game_desc }
	</table>
</body>
</html>