<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!-- movieHome.jsp -->
<html>

<head>
<link rel="icon" type="image/gif/png"
	href="${pageContext.request.contextPath}/Images/titleLogo.png">
<meta charset="UTF-8">
<title>首頁影片管理</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<%-- <script src="${pageContext.request.contextPath}/JS/memberMovieIndex.js"></script> --%>
<script
	src="${pageContext.request.contextPath}/JS/movieHomeUpdateAndDelete.js"></script>

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
</head>

<body
	style="height: 100%;background-image: url(<c:url value='/Images/pattern.png'  />)">
	<!-- 底色設定 循環至....... -->

	<jsp:include page="header/manageHeader.jsp" />

	<section class="footer-top-section" style="height: 100%">
		<!-- 	style="height: 100%" class="recent-game-section spad set-bg" -->
		<!-- 新增影片 Button trigger modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModalCenter">新增影片</button>

		<!-- 新增影片 Modal  #exampleModalCenter -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">修改影片訊息</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">


						<!-- 要改  action-->
						<form style="background-color: white" method="POST"
							action="${pageContext.request.contextPath}/movieHome/addMovie"
							enctype="multipart/form-data">
							<p>
								選則檔案: <input type="file" name="video_file"><br />
							<p>
								<!-- 								<input type="" value="送出"><br /> -->
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Save
									changes</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
		<!-- Modal  #exampleModalCenter End-->

		<!-- 已上傳的影片 -->
		<div class="container">

			<div class="section-title">
				<!-- 				<div class="cata new">已上傳的影片</div> -->
				<!--  -->
				<h2 style="color: white; text-align: center;">首頁影片管理</h2>
			</div>

			<div class="row">
				<c:forEach var="homeMovies" items="${homeMovies}">
					<div class="col-lg-4 col-md-6">
						<div class="recent-game-item" style="padding-bottom: 100px;">
							<div class="rgi-thumb set-bg">
								<!-- 		TAG 不需要 -->
								<!-- 		<div class="cata racing">影片</div> -->

								<video id="${homeMovies.movieId}" width="320" height="240"
									class="set-video"
									poster="${pageContext.request.contextPath}/Images/video-Bg.jpg"
									controls="controls">
									<%-- playsinline="playsinline"  --%>
									<%-- 										要改 <c:url> 的 value  --%>

									<source
										src="<c:url var="memberMoviesUrl" value='/movieHome/${homeMovies.movieName}'/>${memberMoviesUrl} "
										type="video/mp4">

								</video>

							</div>
							<div style="margin-top: 50px;" class="rgi-content">
								<!-- 								<h3>各元素取值確認</h3> -->
								<%-- 								<h6>sessionScope.mem.account == ${sessionScope.mem.account}</h6> --%>
								<!-- 								<h6>sessionScope.mem.member_id == -->
								<%-- 									${sessionScope.mem.member_id}</h6> --%>
								<%-- 								<h6>homeMovies.movieId == ${homeMovies.movieId}</h6> --%>
								<%-- 								<h6>homeMovies.movieName == ${homeMovies.movieName}</h6> --%>
								<!-- 								<h5>End</h5> -->
								<h6 style="padding-bottom: 30px;">檔案名稱 :
									${homeMovies.movieName}</h6>
								<h6 style="padding-bottom: 30px;">存放資料夾 : movieHome</h6>

								<!-- 	***************************************************   Update Model   **************************************************************    -->
								<!-- 								<a -->
								<%-- 									href="movieHome/viewUpdateMovie?movie_ID=${allmovies.movie_ID }" --%>
								<!-- 									class="commentUpdate">Update</a> -->
								<!-- href="moviepersonal/updateMovie" updateModalCenter -->


								<!-- Update Button trigger modal -->
								<button type="button" class="btn btn-primary"
									style="margin-right: 5px;" data-toggle="modal"
									data-target="#updateModalCenter"
									onclick="movieHomeUpdate('${homeMovies.movieId}','${homeMovies.movieName}')">Update</button>

								<!-- Update Modal  #UpdateModalCenter -->
								<div class="modal fade" id="updateModalCenter" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalCenterTitle"
									aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLongTitle">Update
													Modal</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">

												<form style="background-color: white" method="POST"
													action="${pageContext.request.contextPath}/movieHome/updateMovie"
													enctype="multipart/form-data">
													<p>
														<!-- 	確認要修改的影片與Model功能 -->
														<input type="hidden" name="updateMovieId" value=""
															id="updateMovieId" /> <input type="hidden"
															name="updateMovieName" value="" id="updateMovieName" />
														<input type="hidden" name="originMovieId"
															value="${homeMovies.movieId}" />
													<p>
														選則檔案: <input type="file" name="video_file"><br />
													<p>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">取消</button>
														<button type="submit" class="btn btn-primary">確認修改</button>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
								<!-- Update Modal  #UpdateModalCenter End-->


								<!-- 	**************************************************   Update Model End   ***********************************************************************   -->

								<!-- 	**************************************************   Delete Model    ***********************************************************************   -->
								<%-- onclick="window.location.href='moviepersonal/updateMovie?movie_ID=${allmovies.movie_ID }'" --%>
								<!-- 								<a -->
								<%-- 									href="moviepersonal/deleteMovie?movie_ID=${allmovies.movie_ID }" --%>
								<!-- 									class="commentDelete">Delete</a> -->
								<!-- Delete Button trigger modal -->
								<!-- 	檢查movieHomeUpdateAndDelete取值 -->

								<button type="button" class="btn btn-primary"
									style="margin-right: 5px;" data-toggle="modal"
									data-target="#deleteModalCenter"
									onclick="movieHomeDelete('${homeMovies.movieId}')">Delete</button>

								<!-- Delete  Modal  #deleteModalCenter -->
								<div class="modal fade" id="deleteModalCenter" tabindex="-1"
									role="dialog" aria-labelledby="exampleModalCenterTitle"
									aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLongTitle">Delete
													Modal</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">

												<form style="background-color: white" method="POST"
													action="${pageContext.request.contextPath}/movieHome/deleteMovie"
													enctype="multipart/form-data">
													<p>
														<!-- 	確認刪除的影片與Model功能  -->
														<input type="hidden" name="deleteMovieIdCheck" value=""
															id="deleteMovieIdCheck" /> <input type="hidden"
															name="deleteMovieId" value="${homeMovies.movieId}" />
														<%-- <input type="hidden" name="deleteMovieName" value="${homeMovies.movieName}" /> --%>
													<p>
														<!-- <input class="btn btn-secondary" type="submit" value="確認刪除"><br /> -->
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">取消</button>
														<button type="submit" class="btn btn-primary">確認刪除</button>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
								<!-- Delete Modal  #DeleteModalCenter End-->

								<!-- 	**************************************************   Delete Model End   ***********************************************************************   -->

								<!-- 	**************************************************   Dowload Model ***********************************************************************   -->
								<a class="btn btn-primary" style="margin-right: 5px;"
									href="${memberMoviesUrl} " download>Dowload</a>
								<!-- 	**************************************************   Dowload Model End   ***********************************************************************   -->

								<!-- 								<button type="button" class="btn btn-primary" -->
								<%-- 									style="margin-right: 5px;" onclick="movieHomeSetIndex('${homeMovies.movieId}')">Choose</button> --%>
								<input type="button" class="btn btn-primary"
									id="${homeMovies.movieId}${homeMovies.movieId}"
									style="margin-right: 5px; margin-top: 20px;"
									onclick="movieHomeSetIndex('${homeMovies.movieId}')"
									value="Choose">

							</div>

						</div>
					</div>

				</c:forEach>
			</div>
		</div>
	</section>
	<!-- Recent game section  End-->




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