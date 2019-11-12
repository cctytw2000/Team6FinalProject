<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>討論區後台</title>
</head>
<body>
	<div align="center">
	<a href="addBoard">新增討論區看板</a>
<table>
	<tr><th>看板編號</th><th>看板名稱</th></tr>
	<c:forEach var='boardType' items="${boardTypeList}">
		<tr>
			<td>${boardType.boardId}</td>
			<td>${boardType.boardName}</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>