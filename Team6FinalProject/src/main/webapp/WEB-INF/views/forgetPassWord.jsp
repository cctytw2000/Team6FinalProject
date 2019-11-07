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
	<!-- <link rel="stylesheet" href="CSS/RegisteredMember.css"> -->





	<title>Game Book</title>

	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/bootstrap.min.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/font-awesome.min.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/owl.carousel.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/style.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/animate.css' type="text/css" />


	<script src="https://kit.fontawesome.com/685268963f.js"></script>

	<%-- 	<script src="${pageContext.request.contextPath}/JS/login.js"></script> --%>
	<%-- 	<script src="${pageContext.request.contextPath}/JS/RegisteredMember.js"></script> --%>
	<%-- 	<script src="${pageContext.request.contextPath}/JS/FBGoogleRegistered.js"></script> --%>
	<%-- 	<script src="${pageContext.request.contextPath}/JS/FBGoogleLogin.js"></script> --%>






	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/RegisteredMember.css' type="text/css" />


</head>

<body style="background-image: url(<c:url value='/Images/pattern.png' />)">



	<jsp:include page="header/header.jsp" />













	<section class="footer-top-section">
		<div style="height: 350px" class="container">
			<div class="footer-top-bg">
				<img src="<c:url value='/Images/footer-top-bg.png' />" />
			</div>

			<form action="${pageContext.request.contextPath}/member/sendChangePassWordPage" method="post">

				<fieldset style="margin-left:40%">
					<h3 style="text-align:center;color:white">${msg}</h3>
					<div class="div1">
						<label style="color:white" class='label1'>帳號:</label><input type="text" id="account"
							name="account">
					</div>
					<div class="div1" style="text-align: center">
						<input name="insert" type="submit" value="輸入">
					</div>

				</fieldset>
			</form>
		</div>

	</section>






	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>












</body>







</html>