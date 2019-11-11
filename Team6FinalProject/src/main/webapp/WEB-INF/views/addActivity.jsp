<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 日期選擇 -->
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="../../document/home.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script>
	var $s1=jQuery.noConflict();
	$s1(function() {
		$s1( "#datepicker1" ).datepicker({
			changeMonth: true,
			changeYear: true
		});
	});
	
	var $s2=jQuery.noConflict();
	$s2(function() {
		$s2( "#datepicker2" ).datepicker({
			changeMonth: true,
			changeYear: true
		});
	});
	
	var $s3=jQuery.noConflict();
	$s3(function() {
		$s3( "#datepicker3" ).datepicker({
			changeMonth: true,
			changeYear: true
		});
	});
</script>
<!-- 時間選擇 -->
<link href="${pageContext.request.contextPath}/CSS/mdtimepicker.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/JS/mdtimepicker.js"></script>
<script>
 	var $y=jQuery.noConflict();
 	$y(function(){
		$y('#timepicker').mdtimepicker();
	});
</script>
<script>
<!-- 倒回上一頁 -->
function GoBack() {
	history.go(-1)
}
<!-- 隱藏或顯現活動時間為一天的活動 -->
function TimePick() {
	var x = document.getElementById("oneDayOnly");
	var y = document.getElementById("manyDays");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	    y.style.display = "none";
	  } else {
	    x.style.display = "none";
	    y.style.display = "block";
	  }
	}
</script>
<style>
#oneDayOnly {
	width: 300px;
	height: 100px;
}

#manyDays {
	width: 300px;
	height: 100px;
}
</style>
<title>新增活動</title>
</head>
<body>
	<h1>新增活動資料</h1>
	<form:form
		action="${pageContext.request.contextPath}/newsBack/addActivity1"
		method="POST" modelAttribute="activity">
		活動類別:<form:select path="activityType_">
			<form:option value="-1">請挑選</form:option>
			<form:options items="${activityTypeMap }"></form:options>
		</form:select>
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
			<!-- 消息類別預設活動介紹為2 -->
			<form:hidden path="newsType_" value="2" />
		<p>
			<input type="submit" value="送出">
			<button type="button" onclick="GoBack()">取消</button>
	</form:form>
</body>
</html>