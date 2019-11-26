<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!-- memberMovieIndex.jsp -->
<html>

<head>
    <link rel="icon" type="image/gif/png" href="${pageContext.request.contextPath}/Images/titleLogo.png">
<meta charset="UTF-8">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<script src="${pageContext.request.contextPath}/JS/memberMovieIndex.js"></script>
<title>title</title>

</head>

<body style="background-color: #eef2f6;">

	<jsp:include page="header/homeHeader.jsp" />









	<section style="height: 100%;" class="recent-game-section spad set-bg">
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModalCenter">新增影片</button>

		<!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">上傳影片</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					
						<form style="background-color: white" method="POST"
							action="${pageContext.request.contextPath}/member/addMovie"
							enctype="multipart/form-data">
					<div class="modal-body">



							<p>
								影片標題: <input name="movie_name" type="text" size="50px" />
							<p>
								內文描述:
								<textarea name="movie_content"
									style="width: 400px; height: 200px;"></textarea>
							<p>
								選擇檔案: <input type="file" name="video_file"><br />
							<p>
								<!-- 										<input type="submit" value="送出"><br /> -->
					</div>
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
		<div class="container">
			<div class="section-title">
				<div class="cata new">我的影片</div>
				<h2>影片</h2>
			</div>
			<div class="row">
				<c:forEach var="movie" items="${movies}">
					<div class="col-lg-4 col-md-6">
						<div class="recent-game-item">
							<div class="rgi-thumb set-bg">
								<div class="cata racing">遊戲影片</div>

								<video id="${movie.movie_ID}"
									onclick="updateviews('${movie.movie_ID}')" width="320"
									height="240" class="set-video"
									poster="${pageContext.request.contextPath}/Images/video-Bg.jpg"
									playsinline="playsinline" controls="controls">
									<source
										src="<c:url value='/memberMovies/${sessionScope.mem.account}${sessionScope.mem.member_id}/${movie.movie_ID}${movie.location_Test}'/>"
										type="video/mp4">
								</video>
							</div>
							<div style="margin-top: 50px;" class="rgi-content">

								<h6>${movie.location_Test }</h6>
								<h5>${movie.name}</h5>


								<p>${movie.movie_content}</p>

								<p>觀看次數：${movie.click_Sum}</p>

								<button type="button" class="btn btn-primary"
									data-toggle="modal"
									data-target="#${movie.member.account.split('@')[0]}${movie.movie_ID}">
									update</button>


								<!-- Modal -->
								<div class="modal fade"
									id="${movie.member.account.split('@')[0]}${movie.movie_ID}"
									tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
									aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Modal
													title</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<form style="background-color: white" method="POST"
												action="${pageContext.request.contextPath}/member/updateMovie"
												enctype="multipart/form-data">

												<div class="modal-body">


													<!-- 	method="POST" 對應 controller 的@RequestMapping( method = RequestMethod.POST) -->
													<!--    action="movieupdate/update" 對應 controller 的@RequestMapping(  value = "/moviepersonal/addMovie" ) -->

													<input type="hidden" name="movie_ID"
														value="${movie.movie_ID }" /> <input type="hidden"
														name="member_id"
														value="${movie.getMember().getMember_id() }" />
													<p>
														影片標題: <input name="movie_name" type="text" size="50px"
															value="${movie.name }" />
													<p>
														內文描述:
														<textarea name="movie_content"
															style="width: 400px; height: 200px;">${movie.movie_content}</textarea>
													<p>
														<input type="hidden" name="oldfilename"
															value="${movie.location_Test }" /> 選則檔案: <input
															type="file" name="video_file"
															value="${movie.location_Test }" />${movie.location_Test }<br />
										
												</div>
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





















								<button type="button" class="btn btn-primary"
									onclick="deleteMemberMovie('${movie.movie_ID }')">
									delete</button>












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