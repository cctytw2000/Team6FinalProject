<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>遊戲討論區</title>
</head>
<body>
	<div align="center">
	<h1>討論區主頁</h1>
<table>
	<tr><th>看板名稱</th><th>篇數</th></tr>
	<c:forEach var='boardType' items="${boardTypeList}">
		<tr>
			<td><a style="text-decoration:none;" href="<spring:url value='board?id=${boardType.boardId}'/>">${boardType.boardName}</a></td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html> 