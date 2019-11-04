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
</head>

<body>
	<jsp:include page="header/homeHeader.jsp" />




	<div
		style="height:100%;background-image: url(<c:url value='/Images/pattern.png' />)">
		<section class="container">
			<div class="row" style="padding: 50px 15%">

				<h5 style="color: white; font-size: 23px">
					帳號ID:${member.member_id }
					<div style="margin-top: 30px">
						<p style="color: pink">帳號: ${member.account}</p>
						<p style="color: pink">會員姓名: ${member.username}</p>
						<p style="color: pink">暱稱: ${membermemberdetail.nickname}</p>
						<p style="color: pink">性別: ${member.memberdetail.sex}</p>
						<p style="color: pink">地址: ${member.memberdetail.address}</p>
						<p style="color: pink">連絡電話: ${member.memberdetail.tel}</p>
						<p style="color: pink">會員註冊日期: ${member.registeredtime.replace(".0","")}</p>
						<p style="color: pink">會員等級:${member.memberlevel.levelName}</p>

					</div>
				</h5>


			</div>


		</section>



	</div>
	<jsp:include page="footer/homeFooter.jsp" />

</body>

</html>