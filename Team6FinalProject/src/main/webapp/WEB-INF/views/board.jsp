<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>看板文章列表</title>
</head>
<body>
	<div align="center">
	<h1>看板主頁</h1>
	<h1>您進入的看板名稱:${boardType.boardName}</h1>
	<a href="#">發表新主題</a>
<table>
	<tr><th>標題</th><th>作者</th><th>人氣</th></tr>
	<c:forEach var='discussion' items="${discussionList}">
		<tr>
			<td><a style="text-decoration:none;" href="<spring:url value='article?id=${discussion.articleId}'/>">${discussion.subject}</a></td>
			<td><a style="text-decoration:none;" href="<spring:url value='article?id=${discussion.author}'/>">${discussion.author}</a></td>
			<td>${discussion.views}</td>			
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html> 