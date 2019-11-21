<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>討論區後台</title>
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
<%-- <script src="${pageContext.request.contextPath}/JS/membersBack.js"></script> --%>
<script src="https://kit.fontawesome.com/685268963f.js"></script>
<!-- 	//套版用 -->
</head>
<body>
	<jsp:include page="header/manageHeader.jsp" />

	<div class="container mt-3">
		<h1 align="center">討論區後台功能</h1>
		<div align="center">
<!-- 			<a href="addBoard">新增討論區看板</a> -->
			
			
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
新增討論區看板
</button>
			
	<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">

<form:form method='POST' action="${pageContext.request.contextPath}/addBoard" modelAttribute="boardType" enctype="multipart/form-data">
		<form:input path="boardName" type="text" size="50px" />
		<form:input path="bImage" type='file'/>
		<p>
			<input type="submit" value="送出">
			<button type="button" onclick="GoBack()">取消</button>
	</form:form>




      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>		
			
			
			
			
			
			
			
			
			
			
			
			
<!-- 			<a href="addSubjectType">新增發文分類</a>  -->
			<table>
				<tr>
					<th>看板序號</th>
					<th>看板名稱</th>
					<th>文章數</th>
					<th>瀏覽次數</th>
				</tr>
				<c:forEach items="${Blist}" var='boardType' varStatus="s">
					<tr>
						<td>${s.index+1}</td>
						<td>${boardType.boardName}</td>
						<td>${boardType.discussion.size()}</td>
						<td>${boardType.boardViews}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</div>
		<!-- 	套版用 -->
		<script
			src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
		<script src="${pageContext.request.contextPath}/JS/main.js"></script>
		<!-- 自訂js設定檔  -->
		<script src="${pageContext.request.contextPath}/JS/newsBack.js"></script>
</body>
</html>