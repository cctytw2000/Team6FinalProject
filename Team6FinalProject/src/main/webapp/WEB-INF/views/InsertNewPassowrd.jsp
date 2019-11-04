<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>修改密碼</title>
	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/bootstrap.min.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/font-awesome.min.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/owl.carousel.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/style.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/animate.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/RegisteredMember.css' type="text/css" />


	<script src="${pageContext.request.contextPath}/JS/ForgetPWD.js"></script>



	<script src="https://kit.fontawesome.com/685268963f.js"></script>

	<%-- 	<script src="${pageContext.request.contextPath}/JS/login.js"></script> --%>
	<%-- 	<script src="${pageContext.request.contextPath}/JS/RegisteredMember.js"></script> --%>
	<%-- 	<script src="${pageContext.request.contextPath}/JS/FBGoogleRegistered.js"></script> --%>
	<%-- 	<script src="${pageContext.request.contextPath}/JS/FBGoogleLogin.js"></script> --%>
	<style>
		.label1 {
			color: white;
		}

		.sex {
			color: white;
		}
	</style>
</head>





<body>

	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header section -->
	<header class="header-section">
		<div class="container">
			<!-- logo -->
			<a class="site-logo" href="${pageContext.request.contextPath}"> <img src="../Images/logo.png" alt="">
			</a>

			<!-- responsive -->
			<div class="nav-switch">
				<i class="fa fa-bars"></i>
			</div>
			<!-- site menu -->
			<c:choose>
				<c:when test="${sessionScope.account != Null}">
					<nav class="navbar navbar-expand-lg navbar-dark">
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav mr-auto">
								<li class="nav-item active"><a class="nav-link"
										href="${pageContext.request.contextPath}">首頁<span
											class="sr-only">(current)</span></a></li>
								<li class="nav-item"><a class="nav-link" href="#">最新消息</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">遊戲討論區</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">影片區</a></li>
								<li class="nav-item"><a class="nav-link" href="#">商城</a></li>
								<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#"
										id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false"> 會員中心 </a>
									<c:choose>
										<c:when test="${sessionScope.type != 'General'}">

											<div style="" class="dropdown-menu" aria-labelledby="navbarDropdown">
												<a class="dropdown-item"
													href="${pageContext.request.contextPath}/member/memberdetail">會員資料</a>

												<div class="dropdown-divider"></div>
												<a class="dropdown-item" href="./LogOutMember.do">登出</a>
											</div>


										</c:when>
										<c:otherwise>


											<div style="" class="dropdown-menu" aria-labelledby="navbarDropdown">
												<a class="dropdown-item"
													href="${pageContext.request.contextPath}/member/memberdetail">會員資料</a>
												<a class="dropdown-item" href="member/CheangePassword.jsp">修改密碼</a>
												<div class="dropdown-divider"></div>
												<a class="dropdown-item" href="./LogOutMember.do">登出</a>
											</div>


										</c:otherwise>

									</c:choose>





									<div style="" class="dropdown-menu" aria-labelledby="navbarDropdown">
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/member/memberdetail">會員資料</a> <a
											class="dropdown-item" href="#">修改密碼</a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="./LogOutMember.do">登出</a>
									</div>
								</li>

							</ul>
						</div>
					</nav>
				</c:when>
				<c:otherwise>
					<nav class="navbar navbar-expand-lg navbar-dark">
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav mr-auto">
								<li class="nav-item active"><a class="nav-link" href="#">首頁<span
											class="sr-only">(current)</span></a></li>
								<li class="nav-item"><a class="nav-link" href="#">最新消息</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">遊戲討論區</a>
								</li>
								<li class="nav-item"><a class="nav-link" href="#">影片區</a></li>
								<li class="nav-item"><a class="nav-link" href="#">商城</a></li>
							</ul>
						</div>
					</nav>
				</c:otherwise>
			</c:choose>
		</div>
	</header>
	<!-- Header section end -->







	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">重要消息</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">
				<div class="nt-item">
					<span class="new">新聞</span> <a href="#">台灣獲得 LOL S2 冠軍</a>
				</div>
				<div class="nt-item">
					<span class="strategy">重要訊息</span> <a href="#">LOL 即將倒閉</a>
				</div>
				<div class="nt-item">
					<span class="racing">賽事</span><a href="#">台灣 練笑話 準決賽</a>
				</div>
				<div class="nt-item">
					<span class="racing">賽事</span><a href="#">台灣 講幹話 準決賽</a>
				</div>
				<div class="nt-item">
					<span class="racing">賽事</span><a href="#">台灣 講屁話 準決賽</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Latest news section end -->








	<!-- Hero section -->
	<!--     <section class="hero-section"> -->
	<!--         <div class="hero-slider owl-carousel"> -->
	<!--             <div class="hs-item set-bg" data-setbg="../Images/slider-1.jpg"> -->
	<!--                 <div class="hs-text"> -->
	<!--                     <div class="container"> -->
	<!--                         <h2>The Best <span>Games</span> Out There</h2> -->
	<!--                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada <br> lorem maximus mauris scelerisque, at rutrum nulla dictum. Ut ac ligula sapien. <br>Suspendisse cursus faucibus finibus.</p> -->
	<!--                         <a href="#" class="site-btn">Read More</a> -->
	<!--                     </div> -->
	<!--                 </div> -->
	<!--             </div> -->
	<!--             <div class="hs-item set-bg" data-setbg="../Images/slider-2.jpg"> -->
	<!--                 <div class="hs-text"> -->
	<!--                     <div class="container"> -->
	<!--                         <h2>The Best <span>Games</span> Out There</h2> -->
	<!--                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada <br> lorem maximus mauris scelerisque, at rutrum nulla dictum. Ut ac ligula sapien. <br>Suspendisse cursus faucibus finibus.</p> -->
	<!--                         <a href="#" class="site-btn">Read More</a> -->
	<!--                     </div> -->
	<!--                 </div> -->
	<!--             </div> -->
	<!--         </div> -->
	<!--     </section> -->
	<!-- Hero section end -->




	<section class="footer-top-section">
		<div style="height: 378px" class="container">
			<div class="footer-top-bg">
				<img src="<c:url value='/Images/footer-top-bg.png' />" />
			</div>


			<c:choose>
				<c:when test="${type == 'forget'}">
					<form action="${pageContext.request.contextPath}/member/ChangeNewPassowrd" method="post">
						<input type="hidden" name="account" value="${account}"> <input type="hidden" name="token"
							value="${token}">

						<input type="hidden" name="oldpassword" value="Null">
						<fieldset style="margin-left: 40%">
							<div style="text-align: center; color: white">修改密碼</div>
							<div class="div1">
								<label class='label1'>新密碼:</label><input type="password" id="password"
									name="newPassWord">

							</div>
							<div class="div1">
								<label class='label1'>請重複輸入新密碼:</label><input type="password" id="re_password"
									name="re_password"><span id="msg_password"></span>

							</div>
							<div class="div1" id="submit" style="text-align: center">
								<input name="insert" type="submit" value="送出" disabled>

							</div>

						</fieldset>
					</form>
				</c:when>






















				<c:otherwise>

					<form action="${pageContext.request.contextPath}/member/ChangeNewPassowrd" method="post">
						<input type="hidden" name="account" value="${param.account}">
						<input type="hidden" name="token" value="${param.token}">

						<fieldset style="margin-left: 40%; width: 50%">
							<div style="text-align: center; color: white; font-size: 36px">
								修改密碼</div>
							<div class="div1">
								<label class='label1'>舊密碼:</label><input type="password" id="oldpassword"
									name="oldpassword">

							</div>
							<div class="div1">
								<label class='label1'>新密碼:</label><input type="password" id="password"
									name="newPassWord">

							</div>
							<div class="div1">
								<label class='label1'>請重複輸入新密碼:</label><input type="password" id="re_password"
									name="re_password"><span id="msg_password"></span>

							</div>
							<div class="div1" id="submit" style="text-align: center">
								<input name="insert" type="submit" value="送出" disabled>

							</div>

						</fieldset>
					</form>

				</c:otherwise>

			</c:choose>
		</div>

	</section>







	<!-- Footer section -->
	<footer class="footer-section">
		<div class="container">
			<ul class="footer-menu">
				<li><a href="../home.jsp">Home</a></li>
				<li><a href="review.html">Games</a></li>
				<li><a href="categories.html">Blog</a></li>
				<li><a href="community.html">Forums</a></li>
				<li><a href="contact.html">Contact</a></li>
			</ul>
			<p class="copyright">
				<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				Copyright &copy;
				<script>
					document.write(new Date().getFullYear());
				</script>
				All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a
					href="https://colorlib.com" target="_blank">Colorlib</a>
				<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			</p>
		</div>
	</footer>
	<!-- Footer section end -->


	<!--====== Javascripts & Jquery ======-->
	<script src="../JS/jquery-3.2.1.min.js"></script>
	<script src="../JS/bootstrap.min.js"></script>
	<script src="../JS/owl.carousel.min.js"></script>
	<script src="../JS/jquery.marquee.min.js"></script>
	<script src="../JS/main.js"></script>












</body>

</html>