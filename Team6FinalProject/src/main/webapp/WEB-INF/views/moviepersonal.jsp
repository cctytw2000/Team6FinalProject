<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!-- movieindex.jsp -->
<html>

<head>
<meta charset="UTF-8">

<title>後台影片管理</title>
<%--     <meta http-equiv="refresh" content="5;url=${pageContext.request.contextPath}"> --%>


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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script>
	$(function() {
		$(".flip").click(function() {
			$(".panel").slideToggle("slow");
			$(".xs1").toggle();
			$(".xs2").toggle();
		});
	});
</script>
<title>title</title>
<style>
.label1 {
	color: white;
}

.sex {
	color: white;
}

.flip {
	background: #E09697;
	cursor: pointer;
	font-family: 'Arial';
}

.panel {
	/* 	margin: 0px; */
	/* 	text-align: center; */
	background: #e5eecc;
	display: none;
	font-family: 'Arial';
}

.footer_div {
	height: 30px;
}
</style>
</head>

<body
	style="height: 100%;background-image: url(<c:url value='/Images/pattern.png'  />)">
	<!-- 底色設定 循環至....... -->

	<jsp:include page="header/manageHeader.jsp" />

	<section class="footer-top-section" style="height: 100%;">
		<div style="text-align: center" class="container">
			<!-- New Video 可伸縮新增表單 -->

			<div class="row justify-content-start">

				<!-- New Video Button 按鈕-->
				<span class="col-1 flip">New Video</span>


			</div>

			<div class="row panel">

				<!-- New Video panel 新增內容 -->
				<div id="addmovie" class="col-lg-6 col-md-4 tab-pane fade">
					<form method="POST" action="moviepersonal/addmovie"
						enctype="multipart/form-data">
						<!-- action 寫入目標 controller func -->
						<p>
							影片名稱: <input name="name" type="text" size="50px" />
						<p>
							內文描述:
							<textarea name="game_desc" style="width: 400px; height: 200px;"></textarea>
						<p>
							選擇影片: <input name="productImage" type="file" />
						<p>
							<input type="submit" value="送出">
					</form>
				</div>

				<!-- New Video panel 新增內容 -->
			</div>
			<!-- New Video 可伸縮新增表單 End-->

			<!-- New Video  新增內容 -->
			<div class="row justify-content-start">
				<!-- New Video panel 新增內容 -->
				<div id="addmovie" class="col-lg-6 col-md-4 tab-pane fade">
					<form method="POST" action="moviepersonal/addmovie"
						enctype="multipart/form-data">
						<!-- action 寫入目標 controller func -->
						<p>
							影片名稱: <input name="name" type="text" size="50px" />
						<p>
							內文描述:
							<textarea name="game_desc" style="width: 400px; height: 200px;"></textarea>
						<p>
							選擇影片: <input name="productImage" type="file" />
						<p>
							<input type="submit" value="送出">
					</form>
				</div>

				<!-- New Video panel 新增內容 -->
			</div>
		</div>

		<!-- New Video  新增內容 -->

		<!-- Recent game   影片區-->
		<div class="section-title">
			<!-- <div class="cata new"> this is a pink TAG </div> -->
			<h2>影片區</h2>
		</div>
		<div class="row">
			<c:forEach var="allmovies" items="${allmovies}">
				<div class="col-lg-4 col-md-6">
					<div class="recent-game-item">
						<!-- 						標籤 -->

						<div class="rgi-thumb-video set-bg">
							<div class="cata racing">racing</div>
							<video class="set-video" poster="/Images/video-Bg.jpg"
								playsinline="playsinline" controls="controls">
								<source src="<c:url value='/Movie/${allmovies.location_Test}'/>"
									type="video/mp4">
							</video>
						</div>
						<div class="rgi-content">
							<!-- 							標題 -->
							<h6>${allmovies.location_Test }</h6>
							<h5>${allmovies.name }</h5>
							<!-- 							內文 -->
							<p>${allmovies.movie_content}</p>
							<!-- 							案讚數 -->
							<a href="#" class="comment">3 Comments</a>

							<div class="rgi-extra">
								<div class="rgi-heart">
									<img src="Images/icons/heart.png" alt="heart.png">
								</div>
							</div>
						</div>

					</div>
				</div>

			</c:forEach>
		</div>
		<!-- Recent game   End-->
		</div>

		<div class="footer_div"></div>
	</section>

	<%--     <div style="height:auto;background-image: url(<c:url value='/Images/pattern.png'  />)"> --%>
	<!--     </div> -->
	<!-- 底色設定 End -->

	<!--    Footer Section  -->
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>
	<%-- 	<jsp:include page="footer/homeFooter.jsp" /> --%>
</body>

</html>