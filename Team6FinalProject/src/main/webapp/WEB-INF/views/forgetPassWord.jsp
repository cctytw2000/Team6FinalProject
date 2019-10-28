<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="CSS/RegisteredMember.css"> -->
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/RegisteredMember.css'
	type="text/css" />


</head>
<body>




	<%-- <form:form action="${pageContext.request.contextPath}/member/register" method='POST' --%>





	<form action="${pageContext.request.contextPath}/member/sendChangePassWordPage" method="post">

		<fieldset>
			<legend>忘記密碼</legend>
			<div class="div1">
				<label class='label1'>帳號:</label><input type="text" id="account"
					name="account">
			</div>
			<div class="div1" style="text-align: center">
				<input name="insert" type="submit" value="輸入">
			</div>

		</fieldset>
	</form>
</body>
</html>