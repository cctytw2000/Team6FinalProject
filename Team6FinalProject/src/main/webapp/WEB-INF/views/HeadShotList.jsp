<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>大頭貼清單</title>

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
<%-- <script src="${pageContext.request.contextPath}/JS/login.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/JS/RegisteredMember.js"></script> --%>
<!-- <script -->
<%-- 	src="${pageContext.request.contextPath}/JS/FBGoogleRegistered.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/JS/FBGoogleLogin.js"></script> --%>
</head>
<body>
	<jsp:include page="header/homeHeader.jsp" />
	<div class="row">
		<c:forEach var="memberheadshot" items="${memberheadshots}">
<img class="col-md-3" width="212" height="250" src="<c:url value='/memberImages/${sessionScope.mem.account}_${sessionScope.mem.member_id}/${sessionScope.mem.username}${sessionScope.mem.member_id}${memberheadshot.headshotname}' />">

<%-- ${memberheadshot.headshotname} --%>
		</c:forEach>



	</div>
	<form action="${pageContext.request.contextPath}/member/addHeadShot"
		method='POST' enctype="multipart/form-data">

		<input type="file" name="headshotImg" id="headshotImg"> <input
			type="submit" value="新增">
	</form>
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>




</body>
</html>