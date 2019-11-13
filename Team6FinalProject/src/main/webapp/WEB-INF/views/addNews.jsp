<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增消息</title>
<!-- 	套版用 -->
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/bootstrap.min.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/font-awesome.min.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/owl.carousel.css'
	type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/style.css' type="text/css" />
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/CSS/animate.css'
	type="text/css" />
<%-- <script src="${pageContext.request.contextPath}/JS/membersBack.js"></script> --%>
<script src="https://kit.fontawesome.com/685268963f.js"></script>
<!-- 	//套版用 -->
<!-- 自訂js設定檔  -->
<script src="${pageContext.request.contextPath}/JS/addNews.js"></script>
</head>
<body>
	<jsp:include page="header/manageHeader.jsp" />

	<div class="container mt-3">
		<h1>新增消息資料</h1>
		<form:form
			action="${pageContext.request.contextPath}/newsBack/addNews1"
			method="POST" modelAttribute="news">
		消息類別:<form:select path="newsType_" onchange="PickGOrA(this.value)" id="pickGOrA">
				<form:option value="-1">請挑選</form:option>
				<form:options items="${newsTypeMap}"></form:options>
			</form:select>
			<p>
				<!-- 		依照使用者選取的消息類別來顯示遊戲或活動細節 -->
			<div style="display: none" id="game">
				遊戲名稱:
				<form:select path="game_" onchange="gameDetail(this.value)"
					id="gameSelect">
					<form:option value="-1">請挑選</form:option>
					<form:options items="${gameMap }"></form:options>
				</form:select>
				<p>
				<div style="display: none" id="gameDetail">
					<table border="2" RULES=ALL>
						<tr>
							<td>遊戲名稱</td>
							<td id="gameName"></td>
						</tr>
						<tr>
							<td>遊戲發售日</td>
							<td id="gamepublicationDate"></td>
						</tr>
						<tr>
							<td>遊戲發行商</td>
							<td id="gamepublisher"></td>
						</tr>
						<tr>
							<td>遊戲平台</td>
							<td id="gameplatform"></td>
						</tr>
					</table>
				</div>
			</div>
			<div style="display: none" id="activity">
				活動名稱:
				<form:select path="activity_" id="activitySelect"
					onchange="activityDetail(this.value)">
					<form:option value="-1">請挑選</form:option>
					<form:options items="${activityMap}"></form:options>
				</form:select>
				<p>
				<div style="display: none" id="activityDetail">
					<table border="2" RULES=ALL>
						<tr>
							<td>活動名稱</td>
							<td id="activityName"></td>
						</tr>
						<tr>
							<td>活動地點</td>
							<td id="activityLocation"></td>
						</tr>
						<tr id="activityStartingDate_time1">
							<td>活動日期</td>
							<td id="activityStartingDate_time"></td>
						</tr>
						<tr id="activityStartingTime_date1">
							<td>活動時間</td>
							<td id="activityStartingTime_date"></td>
						</tr>
						<tr id="activityStartingDate1">
							<td>活動開始日</td>
							<td id="activityStartingDate"></td>
						</tr>
						<tr id="activityEndingDate1">
							<td>活動結束日</td>
							<td id="activityEndingDate"></td>
						</tr>

					</table>
				</div>
			</div>
			<!-- 		/依照使用者選取的消息類別來顯示遊戲或活動細節 -->
			<p>
				消息標題:
				<form:input path="title" type="text" />
			<p>
				消息內容:
				<textarea class="form-control inline" name="article" id="article"
					rows="30" cols="100" style="resize: none;"></textarea>
			<p>
				是否需要顯示遊戲細節: <input type="radio" name="showGame" value="1"> 是
				<input type="radio" name="showGame" value="0"> 否
			<div id="showGame1"></div>
			<div class="row mb-2"></div>
			<div id="showGame2"></div>
			<p>
				是否需要顯示活動細節: <input type="radio" name="showActivity" value="1">
				是 <input type="radio" name="showActivity" value="0"> 否
			<div id="showActivity1"></div>
			<div class="row mb-2"></div>
			<div id="showActivity2"></div>
			<p>
				是否刊登: <input type="radio" name="isVisable" value="1"> 是 <input
					type="radio" name="isVisable" value="0"> 否
			<p>
				<input type="submit" value="下一步:上傳圖片">
				<button type="button" onclick="GoBack()">取消</button>
		</form>






	</div>
	<!-- 	套版用 -->
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>
</body>
</html>