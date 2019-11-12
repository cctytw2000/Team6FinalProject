<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>討論區後台</title>
</head>
<body>

<%
    Integer hitsCount = 
      (Integer)application.getAttribute("hitCounter");
    if( hitsCount ==null || hitsCount == 0 ){
       /* First visit */
       out.println("討論區後台");
       hitsCount = 1;
    }else{
       /* return visit */
       out.println("討論區後台");
       hitsCount += 1;
    }
    application.setAttribute("hitCounter", hitsCount);
%>

<p>這個頁面的計數器: <%= hitsCount%></p>


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