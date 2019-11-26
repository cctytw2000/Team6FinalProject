<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/gif/png" href="${pageContext.request.contextPath}/Images/titleLogo.png">
<meta charset="UTF-8">
<title>討論看板</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 	套版用 -->
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
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

<!-- 	//套版用 -->
<style type="text/css">
th div {
	padding: 4px;
	margin: 4px;
	background-color: #79D700;
	border-radius: 6px;
	float: right;
}

th:hover div {
	background-color: #FFF6DE;
}

td {
	background-color: #F5F9F9;
	height: 90px;
}

tr:hover td {
	background-color: #FFF6DE;
}
</style>
</head>
<body>
	<jsp:include page="header/homeHeader.jsp" />

	<div>
		<h1 align="center">${boardType.boardName}看板</h1>

		<c:choose>
			<c:when test="${sessionScope.mem != Null }">
				<!--				<button type="button" class="btn btn-success" style="float:right; margin-right:40px"
					onclick="window.location.href='${pageContext.request.contextPath}/addArticle?id=${boardType.boardId}&name=${boardType.boardName}'">發表文章</button>
		-->

				<button type="button" class="btn btn-success"
					style="float: right; margin-right: 40px" data-toggle="modal"
					data-target="#addArticle">發表文章</button>

				<!-- Modal -->

				<form method='POST'
					action="${pageContext.request.contextPath}/addArticle"
					enctype="multipart/form-data">


					<div class="modal fade" id="addArticle" tabindex="-1" role="dialog"
						aria-labelledby="addArticle" aria-hidden="true">


						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="addArticle"></h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">


									<input type="hidden" name="author"
										value="${sessionScope.mem.memberdetail.nickname}" /> <input
										type="hidden" id="boardId" name="boardId"
										value="${boardType.boardId}">

<!---------------------------------------- 新增文章表單的作者和看板欄位 -->
<!-- 									<div class="form-row"> -->
<!-- 										<div class="form-group col-md-3"> -->
<%-- 											<label for="inputAuthor">作者</label> <b><label>${sessionScope.mem.memberdetail.nickname}</label></b> --%>
<!-- 										</div> -->
<!-- 										<div class="form-group col-md-9"> -->
<%-- 											<label>看板</label> <b><label>${boardType.boardName}</label></b> --%>
<!-- 										</div> -->
<!-- 									</div> -->
									
									<div class="form-row">
										<div class="form-group col-md-3">
											<button type="button" class="btn btn-light">作者 <b>${sessionScope.mem.memberdetail.nickname}</b></button>
										</div>
										<div class="form-group col-md-9">
											<button type="button" class="btn btn-light">看板 <b>${boardType.boardName}</b></button>
										</div>
									</div>
									
								
									
									<!-- 								<div class="form-group"> -->
									<!-- 									<label for="inputSubject">標題</label> <input type="text" -->
									<!-- 										class="form-control" id="inputSubject" -->
									<!-- 										placeholder="請輸入發文主題"> -->
									<!-- 								</div> -->



									<div class="form-row">

										<div class="form-group col-md-3">
											<label for="inputSubjectType">發文分類</label> <select
												id="inputSubjectType" name="subjectTypeId"
												class="form-control">
												<!-- 選擇發文分類 -->
												<!-- 												<option selected>請選擇</option> -->
												<c:forEach var="subjectType" items="${subjectType}">
													<option value="${subjectType.subjectTypeId}">${subjectType.subjectName}</option>
												</c:forEach>
											</select>
											<!-- \\選擇發文分類結束 -->
										</div>
										<div class="form-group col-md-9">
											<label for="inputSubject">標題</label> <input type="text"
												class="form-control" id="inputSubject" name="subject"
												placeholder="請輸入發文主題">
										</div>
									</div>

									<div class="form-group">
										<label for="exampleFormControlTextarea1">內文</label>
										<textarea class="form-control" id="bodyEditor" name="body" rows="10"></textarea>
									</div>
									

									<button type="submit" class="btn btn-primary mb-2">寫完囉，可以發表了</button>

									<!-- ====================================修改旗標 -->

									<table style="width: 100%">
										<!-- 											<tr> -->
										<!-- 												<td>作者</td> -->
										<%-- 												<td><b>${sessionScope.mem.memberdetail.nickname}</b></td> --%>
										<!-- 											</tr> -->
										<!-- 											<tr> -->
										<!-- 												<td>分類</td> -->
										<!-- 												<td> -->
										<!-- 																			<select name="subjectTypeId"> 舊版HTML下拉選單樣式 <select -->
										<!-- 													class="form-control" id="subjectTypeId"> -->
										<!-- 														選擇發文分類 -->
										<%-- 														<c:forEach var="subjectType" items="${subjectType}"> --%>
										<%-- 															<option value="${subjectType.subjectTypeId}">${subjectType.subjectName}</option> --%>
										<%-- 														</c:forEach> --%>
										<!-- 												</select> \\選擇發文分類結束 -->
										<!-- 												</td> -->
										<!-- 											</tr> -->
										<!-- 											<tr> -->
										<!-- 												<td>主題</td> -->
										<!-- 												<td><input type="text" name="subject" size="30px" /></td> -->
										<!-- 											</tr> -->

										<!-- 											<tr> -->
										<!-- 												<td>內文</td> -->
										<!-- 												<td><textarea rows="10" name="body" cols="50"></textarea></td> -->
										<!-- 											</tr> -->
										<!-- 											<tr> -->
										<!-- 												<td></td> -->
										<!-- 												<td><input type="submit" value="送出"></td> -->
										<!-- 											</tr> -->
									</table>
				</form>
	</div>



	</div>
	<div class="modal-footer"></div>
	</div>
	</div>
	</div>
















	</c:when>
	<c:otherwise></c:otherwise>
	</c:choose>
	<a style="text-decoration: none;"
		href="<spring:url value='board?id=${boardType.boardId}'/>"></a>

	<table class="shadow p-3 mb-5 bg-white rounded" style="width: 100%">
		<tr style="height: 35px; background-color: #E0F6C3">
			<th></th>
			<th style="text-align: center;">標題</th>
			<th>作者</th>
			<th><span style="font-size: small;"><font color="grey">人氣/互動</font></span></th>
			<th>發表時間</th>
			<th></th>
		</tr>
		<c:forEach var='DiscussionList' items="${DiscussionList}">
			<tr>
				<td><div>
						<img style="width: 100%; height: 90px;"
							src="<c:url value="Images/${DiscussionList.subjectType.subjectName}.png"/>">
					</div></td>
				<td><a style="text-decoration: none;"
					href="<spring:url value='article?id=${DiscussionList.articleId}'/>">【${DiscussionList.subjectType.subjectName}】
						${DiscussionList.subject}</a> <br> <a
					style="text-decoration: none;"
					href="<spring:url value='article?id=${DiscussionList.articleId}'/>"><span
						style="font-size: small;"><font color="grey">${DiscussionList.articleBody.split("<br>")[0]}......</font></span></a></td>
				<td>${DiscussionList.member.memberdetail.nickname}</td>
				<td><span style="font-size: small;">${DiscussionList.views}/
						${DiscussionList.reply.size()}</span></td>
				<td>${DiscussionList.postTimeStamp}</td>

			</tr>
		</c:forEach>
	</table>
	</div>
	<!-- 	套版用 -->
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>
	<!-- 自訂js設定檔  -->
	<script src="${pageContext.request.contextPath}/JS/newsBack.js"></script>
</body>
</html>
