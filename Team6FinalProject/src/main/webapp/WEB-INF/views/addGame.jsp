<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="../../document/home.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});

	function GoBack() {
		history.go(-1)
	}
</script>
<title>新增遊戲</title>
</head>
<body>
	<h1>新增遊戲資料</h1>
	<form:form action="${pageContext.request.contextPath}/newsBack/add"
		method="POST" modelAttribute="game">
		遊戲類別:<form:select path="gameType_">
			<form:option value="-1">請挑選</form:option>
			<form:options items="${gameTypeMap }"></form:options>
		</form:select>
		<p>
			遊戲名稱:
			<form:input path="gameName" type="text" />
		<p>
			發行日期:
			<form:input id="datepicker" name="publicationDate" autocomplete="off"
				path="publicationDate" type="text" />
		<p>
			發行商名稱:
			<form:input path="publisher" type="text" />
		<p>
			發行平台:
			<form:input path="platform" type="text" />
		<p>
			<!-- 新聞類別預設遊戲介紹為1 -->
			<form:hidden path="newsType_" value="1" />
		<p>
			<input type="submit" value="送出">
	</form:form>
	<!-- GameController's value:/addGame/cancel -->

	<button onclick="GoBack()">取消</button>


</body>
</html>