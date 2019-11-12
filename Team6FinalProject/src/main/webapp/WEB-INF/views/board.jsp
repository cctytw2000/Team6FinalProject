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
	<a href="#">發表新主題</a>
<table>
	<tr><th>標題</th><th>作者</th></tr>
	<c:forEach var='discussion' items="${discussionList}">
		<tr>
			<td><a style="text-decoration:none;" href="<spring:url value='article?id=${discussion.articleId}'/>">${discussion.subject}</a></td>
			<td><a style="text-decoration:none;" href="<spring:url value='article?id=${discussion.author}'/>">${discussion.author}</a></td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html> 