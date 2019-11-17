<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>最新消息</title>
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

</head>

<body
	style="background-image: url(<c:url value='/Images/pattern.png' />)">
	<jsp:include page="header/homeHeader.jsp" />

	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">熱門消息</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">
				<c:forEach var="news" items="${sessionScope.newses }" begin="0" end="4"> 
					<div class="nt-item">
						<span class="strategy">${news.newsType.newsTypeName }</span><a onclick="countView(${news.newsId })"
						href="newsDetail?newsId=${news.newsId }">${news.title }</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<!-- Latest news section end -->

	<div class="container-fluid ">
		<div class="row">
			<div id="newsWhite" class="col-2">
				<p style="color: white">我是列表欄</p>
			</div>
			<div id="newsCenter" class="col-6">
				<table
					style="border: none; text-align: left; width: 100%; color: white; table-layout: fixed; word-wrap: break-word;"
					id="newsOrderByTime">
				</table>
			</div>
			<div id="newsAD" class="col-4">
				<p style="color: white">我要放圖</p>
			</div>
		</div>
	</div>


	<!--背景底色 -->
	<section class="footer-top-section" style="height: 100%;">
		<div style="height: 378px" class="container"></div>
	</section>
	<!--//背景底色 -->

	<!--====== Javascripts & Jquery 套版用======-->
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>
	<!-- 自訂js設定檔  -->
	<script src="${pageContext.request.contextPath}/JS/newsPage.js"></script>


</body>
</html>