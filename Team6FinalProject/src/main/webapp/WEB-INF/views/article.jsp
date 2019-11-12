<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="java.lang.*, java.sql.*, java.util.*, java.text.*"%>

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
			<tr><td><td colspan="3">作者：<a style="text-decoration:none;" href="<spring:url value='article?id=${discussion.author}'/>">${discussion.author}</a><td><td><td>
			<tr><td><td>${discussion.memo}<td><td>
			<tr><td><td>人氣:${discussion.views}<td><td>
		</table>
	</div>
</body>
</html>