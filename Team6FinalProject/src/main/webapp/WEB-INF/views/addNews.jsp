<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增消息</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function GoBack() {
		history.go(-1)
	}
	// 	依照使用者選取的新聞類別來顯示遊戲或活動細節
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
		//避免活動或是遊戲id同時送出
		if (gOrA == 1) {
			document.getElementById("activitySelect").selectedIndex = 0;
			$("#activityDetail").hide();
		} else
			(gOrA == 2)
		{
			document.getElementById("gameSelect").selectedIndex = 0;
			$("#gameDetail").hide();
		}

	}

	//用ajax取回gameDetail
	function gameDetail(number) {
		//避免表格跳出
		if (number == -1) {
			$("#gameDetail").hide();
			return false;
		}
		$.ajax({
			type : "POST",
			url : "searchGameByAjax",
			dataType : "json",
			data : {
				gameId : number,
			},
			success : function(data) {
				$("#gameDetail").show();
				var gameName = data.name;
				$("#gameName").html(gameName);
				var gamepublicationDate = data.publicationDate;
				$("#gamepublicationDate").html(gamepublicationDate);
				var gamepublisher = data.publisher;
				$("#gamepublisher").html(gamepublisher);
				var gameplatform = data.platform;
				$("#gameplatform").html(gameplatform);

			}
		});
	}

	//用ajax取回activityDetail
	function activityDetail(number) {
		//避免表格跳出
		if (number == -1) {
			$("#activityDetail").hide();
			return false;
		}
		$.ajax({
			type : "POST",
			url : "searchActivityByAjax",
			dataType : "json",
			data : {
				activityId : number,
			},
			success : function(data) {
				$("#activityDetail").show();

				var activityName = data.name;
				$("#activityName").html(activityName);

				var activityLocation = data.location;
				$("#activityLocation").html(activityLocation);

				var activityStartingDate_time = data.startingDate_time;
				if (activityStartingDate_time == null) {
					$("#activityStartingDate_time1").hide();
				} else {
					$("#activityStartingDate_time1").show();
					$("#activityStartingDate_time").html(
							activityStartingDate_time);
				}

				var activityStartingTime_date = data.startingTime_date;
				if (activityStartingTime_date == null) {
					$("#activityStartingTime_date1").hide();
				} else {
					$("#activityStartingTime_date1").show();
					$("#activityStartingTime_date").html(
							activityStartingTime_date);
				}

				var activityStartingDate = data.startingDate;
				if (activityStartingDate == null) {
					$("#activityStartingDate1").hide();
				} else {
					$("#activityStartingDate1").show();
					$("#activityStartingDate").html(activityStartingDate);
				}

				var activityEndingDate = data.endingDate;
				if (activityEndingDate == null) {
					$("#activityEndingDate1").hide();
				} else {
					$("#activityEndingDate1").show();
					$("#activityEndingDate").html(activityEndingDate);
				}
			}
		});
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
				<form:options items="${activityMap }"></form:options>
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
			<form:textarea path="article" rows="5" cols="30" style="resize:none;" />
		<p>
			是否刊登:
			<form:radiobutton path="isVisable" value="0" id="0" />
			<label for="0">是</label>
			<form:radiobutton path="isVisable" value="1" id="1" />
			<label for="1">否</label>
		<p>
			<input type="submit" value="送出">
			<button type="button" onclick="GoBack()">取消</button>
	</form:form>
</body>
</html>