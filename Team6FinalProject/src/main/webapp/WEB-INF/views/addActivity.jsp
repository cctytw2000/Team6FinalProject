<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#oneDayOnly, #manyDays{
	width: 300px;
	height: 125px;
}
</style>
<title>新增活動</title>
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
<script src="${pageContext.request.contextPath}/JS/membersBack.js"></script>
<script src="https://kit.fontawesome.com/685268963f.js"></script>
<!-- 	//套版用 -->

</head>
<body>
	<jsp:include page="header/manageHeader.jsp" />
	<div class="container mt-3">
		<h1>新增活動資料</h1>
		<form:form
			action="${pageContext.request.contextPath}/newsBack/addActivity1"
			method="POST" modelAttribute="activity" >
		活動類別:<form:select path="activityType_" >
				<form:option value="-1">請挑選</form:option>
				<form:options items="${activityTypeMap }"></form:options>
			</form:select>
			<div  class="row mb-2"></div>
			<p>
				活動名稱:
				<form:input path="activityName" type="text" />
			<p>
				<button type="button" onclick="TimePick()">活動時間選擇</button>
				<!-- 			<button type="button" onclick="myFunction()">活動時間為一天適用</button> -->
			<div id="oneDayOnly">
				<!-- 		<div id="myDIV" style="display: none"> -->
				<p>
				<h4>
					適用於<span style="color: red">一</span>日活動
				</h4>
				<p>
					活動日期:
					<form:input id="datepicker1" name="startingDate_time"
						autocomplete="off" path="startingDate_time" type="text" />
				<p>
					活動時間:
					<form:input id="timepicker" name="startingTime_date"
						autocomplete="off" path="startingTime_date" type="text" />
			</div>
			<!-- 		<button type="button" onclick="myFunction2()">活動時間為多天適用</button> -->
			<div id="manyDays" style="display: none">
				<p>
				<h4>
					適用於<span style="color: red;">多</span>日活動
				</h4>
				<p>
					活動開始日:
					<form:input id="datepicker2" name="startingDate" autocomplete="off"
						path="startingDate" type="text" />
				<p>
					活動結束日:
					<form:input id="datepicker3" name="endingDate" autocomplete="off"
						path="endingDate" type="text" />
			</div>
			<p>
				活動地點:
				<form:input path="location" type="text" />
			<p>
				<input type="submit" value="送出">
				<button type="button" onclick="GoBack()">取消</button>
		</form:form>
	</div>

	<!-- 	套版用 -->
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>

	<!-- datepicker plugin設定檔 -->
	<link rel="stylesheet"
		href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
	<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

	<!-- timepicker plugin設定檔 -->
	<link href="${pageContext.request.contextPath}/CSS/mdtimepicker.css"
		rel="stylesheet">
	<script src="${pageContext.request.contextPath}/JS/mdtimepicker.js"></script>

	<!-- 自訂js設定檔  -->
	<script src="${pageContext.request.contextPath}/JS/addActivity.js"></script>
</body>
</html>