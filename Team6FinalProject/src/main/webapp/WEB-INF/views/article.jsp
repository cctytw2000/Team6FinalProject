<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>瀏覽文章</title>
</head>
<body>
	<div align="center">
		<h2>瀏覽文章</h2>
		<table>
			<tr>
				<td><td colspan="3">標題：  ${discussion.subject}<td><td><td><td>
			<tr><td><td colspan="3">作者：  ${discussion.author}<td><td><td>
			<tr><td><td>${discussion.memo}<td><td>
		</table>
	</div>
</body>
</html>