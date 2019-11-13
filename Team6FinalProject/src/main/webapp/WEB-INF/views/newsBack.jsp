<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>消息後台</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
</head>
<body>
	<jsp:include page="header/manageHeader.jsp" />

	<div class="container mt-3">
		<h1>消息後台功能</h1>

		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active"
				data-toggle="tab" href="#newsTypeHeader">消息類別</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#gameTypeHeader">遊戲類別</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#activityTypeHeader">活動類別</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#gameHeader">遊戲</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#activityHeader">活動</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#newsHeader">消息</a></li>
		</ul>

		<div class="tab-content">

			<!-- 新增消息類別 -->
			<div id="newsTypeHeader" class="container tab-pane active">
				<nav class="navbar navbar-expand-sm ">
					<form class="form-inline" action="newsBack/addNewsType">
						新增消息類別:<input class="form-control mr-sm-2" type="text"
							name="newsTypeName"> <input class="btn btn-success"
							type="submit" value="送出">
					</form>
				</nav>
				<table border="1" style="text-align: center">
					<tr>
						<th>消息類別編號
						<th>消息類別名稱
						<th>更新
						<th>刪除 <c:forEach var="newsType" items="${newsTypeList }">
								<tr>
									<td>${newsType.newsTypeId }
									<td>${newsType.newsTypeName }
									<td><button type="button" class="btn btn-warning"
											data-toggle="modal" data-target="#ooo"
											onclick="updateNewsType('${newsType.newsTypeId }', '${newsType.newsTypeName }')">更新</button>
									<td><button type="button" class="btn btn-warning"
											data-toggle="modal" data-target="#ooo"
											onclick="deleteNewsType(${newsType.newsTypeId })">刪除</button>
							</c:forEach>
				</table>
			</div>
			<!-- //新增消息類別 -->

			<!-- 新增遊戲類別 -->
			<div id="gameTypeHeader" class="container tab-pane">
				<nav class="navbar navbar-expand-sm ">
					<form class="form-inline" action="newsBack/addGameType">
						新增遊戲類別:<input class="form-control mr-sm-2" type="text"
							name="gameTypeName"> <input class="btn btn-success"
							type="submit" value="送出">
					</form>
				</nav>
				<table border="1" style="text-align: center">
					<tr>
						<th>遊戲類別編號
						<th>遊戲類別名稱
						<th>更新
						<th>刪除 <c:forEach var="gameType" items="${gameTypeList }">

								<tr>
									<td>${gameType.gameTypeId }
									<td>${gameType.gameTypeName }
									<td><button type="button" class="btn btn-warning"
											data-toggle="modal" data-target="#ooo"
											onclick="updateGameType('${gameType.gameTypeId }', '${gameType.gameTypeName }')">更新</button>
									<td><button type="button" class="btn btn-warning"
											data-toggle="modal" data-target="#ooo"
											onclick="deleteGameType(${gameType.gameTypeId })">刪除</button>
							</c:forEach>
				</table>
			</div>
			<!-- //新增遊戲類別 -->

			<!-- 新增活動類別 -->
			<div id="activityTypeHeader" class="container tab-pane">
				<nav class="navbar navbar-expand-sm ">
					<form class="form-inline" action="newsBack/addActivityType">
						新增活動類別:<input class="form-control mr-sm-2" type="text"
							name="activityTypeName"> <input class="btn btn-success"
							type="submit" value="送出">
					</form>
				</nav>
			</div>
			<!-- //新增活動類別 -->

			<!-- 遊戲 -->
			<div id="gameHeader" class="container tab-pane">
				<nav class="navbar navbar-expand-sm ">
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/newsBack/addGame"
						role="button">新增遊戲</a>
				</nav>
			</div>
			<!-- //遊戲 -->

			<!-- 活動 -->
			<div id="activityHeader" class="container tab-pane">
				<nav class="navbar navbar-expand-sm ">
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/newsBack/addActivity"
						role="button">新增活動</a>
				</nav>
			</div>
			<!-- //活動 -->

			<!-- 消息 -->
			<div id="newsHeader" class="container tab-pane">
				<nav class="navbar navbar-expand-sm ">
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/newsBack/addNews"
						role="button">新增消息</a>
				</nav>
			</div>
			<!-- //消息 -->

		</div>
	</div>
	<!-- 彈出式視窗		 -->
	<div id="ooo" class="modal inmodal fade" tabindex="-1" role="dialog"
		aria-hidden="true" data-backdrop="static" data-keyboard="true"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header" id="xxx"></div>
				<div class="modal-body" id="xxx1"></div>
			</div>
		</div>
	</div>
	<!-- //彈出式視窗		 -->

	<!-- 	套版用 -->
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>
	<!-- 自訂js設定檔  -->
	<script src="${pageContext.request.contextPath}/JS/newsBack.js"></script>
</body>
</html>