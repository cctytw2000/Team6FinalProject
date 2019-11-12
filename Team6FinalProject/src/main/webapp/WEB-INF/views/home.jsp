<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
	<link href="./favicon.ico" rel="shortcut icon">
	<meta charset="UTF-8">
	<title>Gamily</title>

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


	<!-- Hero section -->
<!-- 	<section class="hero-section"> -->
		
		    <section style="background-color:black" style="width:100%;height:100%">
	            <video style="height:100%;width:100%" playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
	                <source src='<c:url value='/Movie/${homeMovie.movie.movieName}' />' type="video/mp4">
	            </video> 
    </section>
		
		
		
		
<!-- 	</section> -->
	<!-- Hero section end -->
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
	<!-- Footer top section -->
	<section class="footer-top-section">
		<div class="container">
			<div class="footer-top-bg">
				<img src="Images/footer-top-bg.png" alt="">
			</div>
			<div class="row">
				<div class="col-lg-4">
					<div class="footer-logo text-white">
						<img src="Images/newLogoFooter.png" alt="">
						<p>Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum
							dolor sit ame.</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="footer-widget mb-5 mb-md-0">
						<h4 class="fw-title">
							人氣排行 <a style="font-size: 10px" href="#">看更多...</a>
						</h4>
						<div class="latest-blog">
							<div class="lb-item">
								<div class="lb-thumb set-bg" data-setbg="Images/latest-blog/1.jpg"></div>
								<div class="lb-content">
									<div class="lb-date">PUBG</div>
									<p>昨日人氣：60000</p>
									<a href="#" class="lb-author">討論區</a>
								</div>
							</div>
							<div class="lb-item">
								<div class="lb-thumb set-bg" data-setbg="Images/latest-blog/2.jpg"></div>
								<div class="lb-content">
									<div class="lb-date">殭屍生存</div>
									<p>昨日人氣：54000</p>
									<a href="#" class="lb-author">討論區</a>
								</div>
							</div>
							<div class="lb-item">
								<div class="lb-thumb set-bg" data-setbg="Images/latest-blog/2.jpg"></div>
								<div class="lb-content">
									<div class="lb-date">殭屍生存</div>
									<p>昨日人氣：54000</p>
									<a href="#" class="lb-author">討論區</a>
								</div>
							</div>
							<div class="lb-item">
								<div class="lb-thumb set-bg" data-setbg="Images/latest-blog/2.jpg"></div>
								<div class="lb-content">
									<div class="lb-date">殭屍生存</div>
									<p>昨日人氣：54000</p>
									<a href="#" class="lb-author">討論區</a>
								</div>
							</div>
							<div class="lb-item">
								<div class="lb-thumb set-bg" data-setbg="Images/latest-blog/3.jpg"></div>
								<div class="lb-content">
									<div class="lb-date">魔獸世界</div>
									<p>昨日人氣：46000</p>
									<a href="#" class="lb-author">討論區</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="footer-widget">
						<h4 class="fw-title">熱門文章</h4>
						<div class="top-comment">
							<div class="tc-item">
								<div class="tc-thumb set-bg" data-setbg="Images/authors/1.jpg"></div>
								<div class="tc-content">
									<p>
										<a href="#">James Smith</a> <span>on</span> PUBG
									</p>
									<div class="tc-date">[問題] 怎樣才能變強阿?</div>
								</div>
							</div>
							<div class="tc-item">
								<div class="tc-thumb set-bg" data-setbg="Images/authors/2.jpg"></div>
								<div class="tc-content">
									<p>
										<a href="#">James Smith</a> <span>on</span> Lorem ipsum dolor
										sit amet, co
									</p>
									<div class="tc-date">June 21, 2018</div>
								</div>
							</div>
							<div class="tc-item">
								<div class="tc-thumb set-bg" data-setbg="Images/authors/3.jpg"></div>
								<div class="tc-content">
									<p>
										<a href="#">James Smith</a> <span>on</span> Lorem ipsum dolor
										sit amet, co
									</p>
									<div class="tc-date">June 21, 2018</div>
								</div>
							</div>
							<div class="tc-item">
								<div class="tc-thumb set-bg" data-setbg="Images/authors/4.jpg"></div>
								<div class="tc-content">
									<p>
										<a href="#">James Smith</a> <span>on</span> Lorem ipsum dolor
										sit amet, co
									</p>
									<div class="tc-date">June 21, 2018</div>
								</div>
							</div>
							<div class="tc-item">
								<div class="tc-thumb set-bg" data-setbg="Images/authors/4.jpg"></div>
								<div class="tc-content">
									<p>
										<a href="#">James Smith</a> <span>on</span> Lorem ipsum dolor
										sit amet, co
									</p>
									<div class="tc-date">June 21, 2018</div>
								</div>
							</div>
							<div class="tc-item">
								<div class="tc-thumb set-bg" data-setbg="Images/authors/4.jpg"></div>
								<div class="tc-content">
									<p>
										<a href="#">James Smith</a> <span>on</span> Lorem ipsum dolor
										sit amet, co
									</p>
									<div class="tc-date">June 21, 2018</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer top section end -->

	<!-- Feature section -->
	<section class="feature-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 p-0">
					<div class="feature-item set-bg" data-setbg="Images/features/1.jpg">
						<span class="cata new">new</span>
						<div class="fi-content text-white">
							<h5>
								<a href="#">Suspendisse ut justo tem por, rutrum</a>
							</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
							<a href="#" class="fi-comment">3 Comments</a>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 p-0">
					<div class="feature-item set-bg" data-setbg="Images/features/2.jpg">
						<span class="cata strategy">strategy</span>
						<div class="fi-content text-white">
							<h5>
								<a href="#">Justo tempor, rutrum erat id, molestie</a>
							</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
							<a href="#" class="fi-comment">3 Comments</a>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 p-0">
					<div class="feature-item set-bg" data-setbg="Images/features/3.jpg">
						<span class="cata new">new</span>
						<div class="fi-content text-white">
							<h5>
								<a href="#">Nullam lacinia ex eleifend orci porttitor</a>
							</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
							<a href="#" class="fi-comment">3 Comments</a>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 p-0">
					<div class="feature-item set-bg" data-setbg="Images/features/4.jpg">
						<span class="cata racing">racing</span>
						<div class="fi-content text-white">
							<h5>
								<a href="#">Lacinia ex eleifend orci suscipit</a>
							</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
							<a href="#" class="fi-comment">3 Comments</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Feature section end -->


	<!-- Recent game section  -->
	<section class="recent-game-section spad set-bg" data-setbg="Images/recent-game-bg.png">
		<div class="container">
			<div class="section-title">
				<div class="cata new">new</div>
				<h2>Recent Games</h2>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="recent-game-item">
						<div class="rgi-thumb set-bg" data-setbg="Images/recent-game/1.jpg">
							<div class="cata new">new</div>
						</div>
						<div class="rgi-content">
							<h5>Suspendisse ut justo tem por, rutrum</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum
								dolor sit amet, consectetur elit.</p>
							<a href="#" class="comment">3 Comments</a>
							<div class="rgi-extra">
								<div class="rgi-star">
									<img src="Images/icons/star.png" alt="">
								</div>
								<div class="rgi-heart">
									<img src="Images/icons/heart.png" alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="recent-game-item">
						<div class="rgi-thumb set-bg" data-setbg="Images/recent-game/2.jpg">
							<div class="cata racing">racing</div>
						</div>
						<div class="rgi-content">
							<h5>Susce pulvinar metus nulla, vel facilisis sem</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum
								dolor sit amet, consectetur elit.</p>
							<a href="#" class="comment">3 Comments</a>
							<div class="rgi-extra">
								<div class="rgi-star">
									<img src="Images/icons/star.png" alt="">
								</div>
								<div class="rgi-heart">
									<img src="Images/icons/heart.png" alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="recent-game-item">
						<div class="rgi-thumb set-bg" data-setbg="Images/recent-game/3.jpg">
							<div class="cata adventure">Adventure</div>
						</div>
						<div class="rgi-content">
							<h5>Suspendisse ut justo tem por, rutrum</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum
								dolor sit amet, consectetur elit.</p>
							<a href="#" class="comment">3 Comments</a>
							<div class="rgi-extra">
								<div class="rgi-star">
									<img src="Images/icons/star.png" alt="">
								</div>
								<div class="rgi-heart">
									<img src="Images/icons/heart.png" alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Recent game section end -->


	<!-- Tournaments section -->
	<section class="tournaments-section spad">
		<div class="container">
			<div class="tournament-title">Tournaments</div>
			<div class="row">
				<div class="col-md-6">
					<div class="tournament-item mb-4 mb-lg-0">
						<div class="ti-notic">Premium Tournament</div>
						<div class="ti-content">
							<div class="ti-thumb set-bg" data-setbg="Images/tournament/1.jpg"></div>
							<div class="ti-text">
								<h4>World Of WarCraft</h4>
								<ul>
									<li><span>Tournament Beggins:</span> June 20, 2018</li>
									<li><span>Tounament Ends:</span> July 01, 2018</li>
									<li><span>Participants:</span> 10 teams</li>
									<li><span>Tournament Author:</span> Admin</li>
								</ul>
								<p>
									<span>Prizes:</span> 1st place $2000, 2nd place: $1000, 3rd
									place: $500
								</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="tournament-item">
						<div class="ti-notic">Premium Tournament</div>
						<div class="ti-content">
							<div class="ti-thumb set-bg" data-setbg="Images/tournament/2.jpg"></div>
							<div class="ti-text">
								<h4>DOOM</h4>
								<ul>
									<li><span>Tournament Beggins:</span> June 20, 2018</li>
									<li><span>Tounament Ends:</span> July 01, 2018</li>
									<li><span>Participants:</span> 10 teams</li>
									<li><span>Tournament Author:</span> Admin</li>
								</ul>
								<p>
									<span>Prizes:</span> 1st place $2000, 2nd place: $1000, 3rd
									place: $500
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Tournaments section bg -->


	<!-- Review section -->
	<section class="review-section spad set-bg" data-setbg="#">
		<div class="container">
			<div class="section-title">
				<button type="button" class="btn btn-danger" onclick="window.location.href='findProductsByPage'">遊戲商城</button>
				<h2>最新商品</h2>
			</div>
			<div class="row">
				<c:forEach var="p" items="${sessionScope.productsTop8 }">
					<div class="col-lg-3 col-md-6"> 
						<div class="review-item">
							<div class="review-cover set-bg" data-setbg="<c:url value='/getPicture/${p.game_id}' />">
								<div class="score yellow" style="margin-top:0px">$${p.price }</div>
							</div>
							<div class="review-text">
								<h5>
									<a href="<spring:url value='product?game_id=${p.game_id }'/>">${p.name }</a>
								</h5>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!-- Review section end -->




	<jsp:include page="footer/homeFooter.jsp" />



</body>


</html>