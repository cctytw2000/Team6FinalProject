<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/gif/png" href="${pageContext.request.contextPath}/Images/titleLogo.png">
<meta charset="UTF-8">
<title>新增消息</title>
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
<!-- 自訂js設定檔  -->
<script src="${pageContext.request.contextPath}/JS/addNews.js"></script>
<style>
#divArticle p{
	color:black;
	font-size:14px
}
.ck-editor__editable_inline {
    min-height: 500px;
}
</style>
<!-- ckeditor -->
<script src="${pageContext.request.contextPath}/JS/ckeditor.config.js"></script>
<script src="${pageContext.request.contextPath}/JS/ckeditor.js"></script>
</head>
<body>
	<jsp:include page="header/manageHeader.jsp" />

	<div class="container mt-3">
		<h1 align="center">新增消息資料</h1>
		<form onsubmit="return (validateForm());" name="news"
			action="${pageContext.request.contextPath}/newsBack/addNews1"
			method="POST" enctype="multipart/form-data">
			<p>
				消息類別:<span id="newsType"></span>
			<p>

				是否需要顯示遊戲細節: <input type="radio" name="showGame" value="1"> 是
				<input type="radio" name="showGame" value="0" CHECKED> 否
			<div id="showGame1"></div>
			<div class="row mb-2"></div>
			<div id="showGame2"></div>
			<p>

				是否需要顯示活動細節: <input type="radio" name="showActivity" value="1">是
				<input type="radio" name="showActivity" value="0" CHECKED> 否
			
			<div id="showActivity1"></div>
			<div class="row mb-2"></div>
			<div id="showActivity2"></div>
			<div class="row mb-2"></div>
			<p>

				消息標題: <input name="title" type="text" id="title" style="width: 100%" />
			<p>

				消息內容:
				<div id="divArticle">
					<textarea name="article" id="article" placeholder="請輸入內文!"></textarea>
				</div>
				<script>
					ClassicEditor
						.create( document.querySelector( '#article' ), ckeditorConfig )
			    		.then(editor => {
            					console.log(editor);
       					})
						.catch( error => {
			        		console.error( error );
			    	} );
    			</script>
			<p>
			<p>
				選擇圖片:<input id="newsImage" type="file" name="newsImage" />
			<p>
				是否刊登: <input type="radio" name="isVisable" value="1"> 是 <input
					type="radio" name="isVisable" value="0"> 否
			<p>
				<input onclick="check()" type="submit" value="送出">
				<button type="button" onclick="GoBack()">取消</button>
		</form>
	</div>
	<!-- 	套版用 -->
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>
</body>
</html>