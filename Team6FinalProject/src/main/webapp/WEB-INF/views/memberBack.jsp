<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" -->
<!-- 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> -->
<title>商品資料</title>






	<!-- 	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script> -->
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/bootstrap.min.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/font-awesome.min.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/owl.carousel.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/style.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/animate.css' type="text/css" />


	<script src="https://kit.fontawesome.com/685268963f.js"></script>
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/login.js"></script>
	<script src="${pageContext.request.contextPath}/JS/RegisteredMember.js"></script>
	<script src="${pageContext.request.contextPath}/JS/FBGoogleRegistered.js"></script>
	<script src="${pageContext.request.contextPath}/JS/FBGoogleLogin.js"></script>
	

	

</head>

<body>
	<jsp:include page="header/homeHeader.jsp" />














	<div
		style="height:100%;background-image: url(<c:url value='/Images/pattern.png' />)">
		<section class="container">
			<div class="row" style="padding: 50px 15%">

<div class="container mt-3">
  <h2>會員後台</h2>
  <br>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="tab" href="#home">帳號資料</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#menu1">會員資料</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#menu2">會員登入登出資訊</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
	<h5 style="color: white; font-size: 23px">
					帳號ID:${member.member_id}
					<div style="margin-top: 30px">
						<p style="color: pink">帳號: ${member.account}</p>
						<p style="color: pink">會員姓名: ${member.username}</p>
						<p style="color: pink">會員註冊日期: ${member.registeredtime.replace(".0","")}</p>
						<p style="color: pink">會員身分:${member.memberlevel.levelName}</p>

					</div>
				</h5>
    </div>
    <div id="menu1" class="container tab-pane fade"><br>

    </div>
    <div id="menu2" class="container tab-pane fade"><br>
<h5 style="color: white; font-size: 23px">
					帳號ID:${member.member_id}
					
			
					<div style="margin-top: 30px">
							<c:forEach var="imfo" items="${member.liLoInfo }">
						<p style="color: pink">請求IP:${imfo.ClientIP}</p>
						<p style="color: pink">請求類型: ${imfo.type}</p>
						<p style="color: pink">時間: ${imfo.loginTime}</p>
						<p style="color: pink">帳號類型: ${imfo.accountType}</p>
						<p style="color: pink">成功與否: ${imfo.isSuccess}</p>
</c:forEach>
					</div>
				</h5>
    </div>
  </div>
</div>


			


			</div>


		</section>



	</div>
	<jsp:include page="footer/homeFooter.jsp" />

</body>

</html>