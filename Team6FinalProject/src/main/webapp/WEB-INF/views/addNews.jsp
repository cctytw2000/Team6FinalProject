<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增消息</title>
<script>
	function GoBack() {
		history.go(-1)
	}
	function PickGOrA() {
		var e = document.getElementById("pickGOrA");
		var gOrA = e.options[e.selectedIndex].value;
		var g = document.getElementById("game");
		var a = document.getElementById("activity");
		if (gOrA == 1) {
			g.style.display = "block";
			a.style.display = "none";
		} else if (gOrA == 2) {
			g.style.display = "none";
			a.style.display = "block";
		} else {
			g.style.display = "none";
			a.style.display = "none";
		}

	}
</script>
</head>
<body>
	<h1>新增消息資料</h1>
	<form:form
		action="${pageContext.request.contextPath}/newsBack/addNews1"
		method="POST" modelAttribute="news">
		消息類別:<form:select path="newsType_" onchange="PickGOrA()" id="pickGOrA">
			<form:option value="-1">請挑選</form:option>
			<form:options items="${newsTypeMap }"></form:options>
		</form:select>
		<p>
		<div style="display: none" id="game">
			遊戲:
			<form:select path="game_">
				<form:option value="-1">請挑選</form:option>
				<form:options items="${gameMap }"></form:options>
			</form:select>
		</div>
		<div style="display: none" id="activity">
			活動:
			<form:select path="activity_">
				<form:option value="-1">請挑選</form:option>
				<form:options items="${activityMap }"></form:options>
			</form:select>
		</div>
		<p>
		<p>
			消息標題:
			<form:input path="title" type="text" />
		<p>
			消息內容:
			<form:textarea path="article" rows="5" cols="30" style="resize:none;" />
		<p>
			是否刊登:
			<form:radiobutton path="isVisable" value="0" id="0" />
			<label for="0">是</label>
			<form:radiobutton path="isVisable" value="1" id="1" />
			<label for="1">否</label>
		<p>
			上傳圖片:
			<button type="button">未完成</button>
		<p>
			<!-- 消息類別預設遊戲介紹為1 -->
			<%-- 			<form:hidden path="newsType_" value="1" /> --%>
		<p>
			<input type="submit" value="送出">
			<button type="button" onclick="GoBack()">取消</button>
	</form:form>
</body>
</html>