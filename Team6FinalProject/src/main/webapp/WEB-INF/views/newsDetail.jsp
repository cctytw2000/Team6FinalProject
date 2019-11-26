<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/gif/png" href="${pageContext.request.contextPath}/Images/titleLogo.png">
<meta charset="UTF-8">
<title>消息內容</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 套版用 -->
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

<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://kit.fontawesome.com/685268963f.js"></script>
<!-- //套版用 -->
<style>
p {
	font-family: Microsoft JhengHei;
}
</style>
</head>
<body style="background-color: #F2F3F3">
	<jsp:include page="header/homeHeader.jsp" />

	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">熱門消息</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">
				<c:forEach var="news" items="${sessionScope.newses }" begin="0"
					end="4">
					<div class="nt-item">
						<span class="strategy">${news.newsType.newsTypeName }</span><a
							onclick="countView(${news.newsId })"
							href="newsDetail?newsId=${news.newsId }">${news.title }</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- Latest news section end -->

	<div class="container">
		<div>
			<div style="padding-top: 20px; padding-bottom: 10px">
				<h2 style="font-family: Microsoft JhengHei">${news.title}</h2>
			</div>
			<div>
				<button style="font-family: Microsoft JhengHei" type="button"
					class="btn btn-success pull-left">${news.newsType.newsTypeName}</button>
				<h4
					style="color: #FFD000; text-align: right; font-family: Microsoft JhengHei">
					(Gamily專題記者: <i>${news.member.username}</i> 報導)
					${news.publicationDate.replace(".0","")}
				</h4>
			</div>
			<hr style="margin-top: 30px">
			<div>
				<img width='400' height='400'
					style="float: left; margin-right: 30px"
					src="<c:url value='/getNewsPicture/${news.newsId}' />">
			</div>
			<div>
				<p id="article"
					style="color: black; font-size: large; text-align: left; font-family: Microsoft JhengHei">${news.article}</p>
			</div>
			<hr>

			<p id="gameDetail" style="display: none; float: left">
				<a style="font-family: Microsoft JhengHei; margin-right: 10px"
					class="btn btn-primary" data-toggle="collapse" href="#showG"
					role="button" aria-expanded="false" aria-controls="#showG">遊戲資訊</a>
			</p>
			<div class="row" style="float: left">
				<div class="col">
					<div class="collapse multi-collapse" id="showG">
						<div class="card card-body"
							style="text-align: left; width: 300px;">
							<p id="gameId" style="display: none">${news.game.gameId}</p>
							<p style="color: #D8171A; font-size: 20px">遊戲類型:${news.game.gameType.gameTypeName}</p>
							<p style="color: #D8171A; font-size: 20px">遊戲名稱:${news.game.gameName}</p>
							<p id="gamePublicationDate"
								style="color: #D8171A; font-size: 20px">遊戲發售日:${news.game.publicationDate}</p>
							<p style="color: #D8171A; font-size: 20px">遊戲發行商:${news.game.publisher}</p>
							<p style="color: #D8171A; font-size: 20px">遊戲平台:${news.game.platform}</p>
						</div>
					</div>
				</div>
			</div>
			<p>
			<p id="activityDetail" style="display: none; float: left">
				<a
					style="font-family: Microsoft JhengHei; margin-right: 10px; margin-left: 10px"
					class="btn btn-primary" data-toggle="collapse" href="#showA"
					role="button" aria-expanded="false" aria-controls="#showA">活動資訊</a>
			</p>
			<div class="row" style="float: left">
				<div class="col">
					<div class="collapse multi-collapse" id="showA">
						<div class="card card-body"
							style="text-align: left; width: 300px;">
							<p id="activityId" style="display: none">${news.activity.activityId}</p>
							<p style="color: #D8171A; font-size: 20px">活動類型:${news.activity.activityType.activityTypeName}</p>
							<p style="color: #D8171A; font-size: 20px">活動名稱:${news.activity.activityName}</p>
							<p id="startingDate_time" style="color: #D8171A; font-size: 20px">活動日期:${news.activity.startingDate_time}</p>
							<p id="startingTime_date" style="color: #D8171A; font-size: 20px">活動時間:${news.activity.startingTime_date}</p>
							<p id="startingDate" style="color: #D8171A; font-size: 20px">活動起始日:${news.activity.startingDate}</p>
							<p id="endingDate" style="color: #D8171A; font-size: 20px">活動結束日:${news.activity.endingDate}</p>
							<p style="color: #D8171A; font-size: 20px">活動地點:${news.activity.location}</p>
						</div>
					</div>
				</div>
			</div>

			<!-- 		顯示評論 -->
			<div id="memoForNews"></div>

			<!-- 		輸入評論 -->
			<div class="form-group" style="margin-top: 20px" id="add">
				<div class="input-group " style="width: 500px;">
					<input type="hidden" id="newsId" name="newsId"
						value="${news.newsId }"> <input type="hidden"
						id="member_id" value="${sessionScope.mem.member_id }">
					<textarea class="form-control" rows="1" id="addMemo" name="memo"
						style="resize: none; font-family: Microsoft JhengHei"
						placeholder="請輸入評論..."></textarea>
					<span class="input-group-btn">
						<button style="font-family: Microsoft JhengHei"
							class="btn btn-success" onclick="addMemo()">發表</button>
					</span>
				</div>
			</div>
		</div>
	</div>
		<!--背景底色 -->
		<!-- 	<section class="footer-top-section" style="height: 100%;"> -->
		<!-- 		<div style="height: 378px" class="container"></div> -->
		<!-- 	</section> -->
		<!--//背景底色 -->

		<!--====== Javascripts & Jquery 套版用======-->
		<script
			src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
		<script src="${pageContext.request.contextPath}/JS/main.js"></script>
		<!-- 自訂js設定檔  -->
		<script src="${pageContext.request.contextPath}/JS/newsDetail.js"></script>
</body>
</html>