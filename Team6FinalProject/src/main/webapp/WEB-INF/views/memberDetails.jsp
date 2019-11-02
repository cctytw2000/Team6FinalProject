<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script> -->
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


<script src="https://kit.fontawesome.com/685268963f.js"></script>
<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/JS/login.js"></script>
<script src="${pageContext.request.contextPath}/JS/RegisteredMember.js"></script>
<script
	src="${pageContext.request.contextPath}/JS/FBGoogleRegistered.js"></script>
<script src="${pageContext.request.contextPath}/JS/FBGoogleLogin.js"></script>

<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
<script src="https://kit.fontawesome.com/685268963f.js"></script>



<style>


</style>
</head>
<body>
	<jsp:include page="header/homeHeader.jsp" />


	<section class="footer-top-section" style="height: 100%;">
		<div
			style="width: 30%; height: 100%; background-color: white; border-radius: 15px 15px;"
			class="container">


			<p style="text-align: center;font-size:30px;color:black">個人資料</p>
			<br>
			<div style="width: 100%; margin: 30px auto;">


				<div>
					<label>姓名：</label>
					<p>${MemberDetial.username}</p>
				</div>

				<div>
					<label>信箱：</label>
					<p>${MemberDetial.account}</p>
				</div>



				<div>
					<label>暱稱：</label>
					<p>${MemberDetial.memberdetail.nickname}</p>
				</div>




				<div>
					<label>身分證字號：</label>
					<p>${MemberDetial.memberdetail.idnumber}</p>
				</div>



				<div>
					<label>生日：</label>
					<p>${MemberDetial.memberdetail.birth}</p>
				</div>


			</div>

		</div>

	</section>



	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>


</body>
</html>