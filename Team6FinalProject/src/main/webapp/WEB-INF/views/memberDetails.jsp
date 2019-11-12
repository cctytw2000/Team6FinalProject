<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>會員資料</title>
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

	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="https://kit.fontawesome.com/685268963f.js"></script>

	<script>
		let open = 0
		function openUpdate() {
			if (open == 0) {
				document.getElementById("nickname").innerHTML = "<label>暱稱：</label> <br><input type='text'"
					+ "name='nickname' placeholder='來個新名字吧(ゝ∀･)'"
					+ "value='${MemberDetial.memberdetail.nickname}'></input> <br><input type='submit' value='更新'> <button id='update'"
					+ "type='button' onclick='openUpdate()'>編輯</button>"
				open = 1
			} else {
				document.getElementById("nickname").innerHTML = "<label>暱稱：</label> <br><input style='border-width: 0; background-color: white' type='text'"
					+ "name='nickname' placeholder='來個新名字吧(ゝ∀･)' disabled='disabled' readonly='readonly'"
					+ "value='${MemberDetial.memberdetail.nickname}'></input> <button id='update'"
					+ "type='button' onclick='openUpdate()'>取消</button>"
				open = 0
			}

		}
		
		function headshot(id) {
			let chenge = ""
			chenge += '<input name="memberId" type="hidden" value="'+id+'"/>'
			chenge += '<input id="memberimg" name="memberimg" type="file"/> <input type="submit" />'
			document.getElementById("Changeheadshot").innerHTML = chenge
		
		}
	</script>


</head>

<body>
	<jsp:include page="header/homeHeader.jsp" />


	<section class="footer-top-section" style="height: auto; padding-top: 15px">
		<div style="width: 30%; height: 100%; background-color: white; border-radius: 15px 15px;" class="container">
		
		
		
		
		<c:choose>
				<c:when test="${sessionScope.mem.headshot != Null}">
		
	
		<img width="212" height="250" src="<c:url value='/memberImages/${sessionScope.mem.username}${sessionScope.mem.member_id}${sessionScope.mem.headshot}' />">
						<button onclick="headshot('${sessionScope.mem.member_id}')"  type="button">換一張大頭貼吧</button>
				<form id="Changeheadshot"action="${pageContext.request.contextPath}/member/Changeheadshot" method="post" enctype="multipart/form-data">

			
					</form>
				</c:when>
				<c:otherwise>

			<img width="212" height="250" src="<c:url value='/memberImages/noimage.jpg' />">
						<button onclick="headshot('${sessionScope.mem.member_id}')"  type="button">新增一張大頭貼</button>
				<form id="Changeheadshot" action="${pageContext.request.contextPath}/member/Changeheadshot" method="post" enctype="multipart/form-data">
<%-- 			<input name="memberId" type='hidden' value="${sessionScope.mem.member_id}"/>  --%>
<!-- 			<input id="memberimg" name="memberimg" type='file'/> <input type="submit" /> -->
					</form>
				</c:otherwise>

			</c:choose>
		
		
		
		
	

			<form action="${pageContext.request.contextPath}/member/ChangeNickname" method="post">
				<p style="text-align: center; font-size: 30px; color: black">個人資料</p>
				<br>
				<div style="width: 100%; margin: 30px auto;">
					<input type="hidden" name="memberID" value="${MemberDetial.memberdetail.memberID}">
					<div>
						<label>姓名：</label>
						<p>${MemberDetial.username}</p>
					</div>

					<div id="nickname">
						<label>暱稱：</label> <br>
						<input style="border-width: 0; background-color: white" type="text" name="nickname"
							placeholder="來個新名字吧(ゝ∀･)" disabled="disabled" readonly="readonly"
							value="${MemberDetial.memberdetail.nickname}"></input>
						<button id="openupdate" type="button" onclick="openUpdate()">編輯</button>
					</div>


					<div>
						<label>信箱：</label>
						<p>${MemberDetial.account}</p>
					</div>







					<div>
						<label>電話：</label>
						<p>${MemberDetial.memberdetail.tel}</p>
					</div>




					<div>
						<label>生日：</label>
						<p>${MemberDetial.memberdetail.birth}</p>
					</div>
					<div>
						<label>身分證字號：</label>
						<p>${MemberDetial.memberdetail.idnumber}</p>
					</div>

				</div>
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