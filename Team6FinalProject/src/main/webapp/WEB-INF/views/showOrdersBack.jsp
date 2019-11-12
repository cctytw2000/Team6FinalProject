<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>所有訂單</title>
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

	
	
</head>
<body>
<jsp:include page="header/manageHeader.jsp" />

<div class="container mt-3">
	<h1>訂單管理</h1>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#showorders">訂單總覽</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#memberorder">會員訂單</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#productCancel">會員訂單</a></li>
	</ul>
<div class="tab-content">
	<div id="showorders" class="container tab-pane active">
		<table  id="table1" border="1" style="text-align: center">
				<tr><th>訂單編號<th>商品名稱<th>商品數量<th>商品小計			
				<c:choose>				
				<c:when test="${not empty orders}">
					<c:forEach var="order" items="${orders}">
					<tr><td>${order.order.order_id}
						<td>${order.product.name}
						<td>${order.count}個
						<td>${order.subtotal}元							
					</c:forEach>
				</c:when>
				<c:otherwise>
					查無訂單資料
				</c:otherwise>
				</c:choose>
		</table>
	</div>	
	<div id="memberorder" class="container tab-pane fade">
		會員:<select id="member_id">
			<c:choose>	
				<c:when test="${not empty members}">
					<c:forEach var="m" items="${members}">
						<option value="${m.member_id}">${m.member_id} ${m.username} ${m.account} 
					</c:forEach>
				</c:when>
				<c:otherwise>
					查無會員資料
				</c:otherwise>
			</c:choose>
		</select>
		<p>	
		<h2 id="morder" align="center"></h2><br>
			<c:choose>
				<c:when test="${empty morders}">
					<h3 align="center">您沒有訂單紀錄</h3>				
				</c:when>
				<c:otherwise>					
						<table border="1" style="text-align:center;width:100%">
							<tr>
								<th>訂單編號
								<th>訂單時間
								<th>訂單金額
								<th>狀態
								<c:forEach var="order" items="${morderss}">
							<tr>
								<td><a href="showOrderDetail?order_id=${order.order_id }">${order.order_id }</a>
								<td>${order.ordertime.replace(".0","")}
								<td><span style="color:yellow;font-size:23px">${order.total}</span><span
										style="font-size:23px;float:right">元</span>
									<c:choose>
										<c:when test="${order.state == 1}">
								<td style="color:red">未付款</td>
								</c:when>
			</c:choose>
			</c:forEach>
			</table>		
		</c:otherwise>
		</c:choose>
			<script>
			$(document).ready(function(){
				$("h2#morder").html($("select#member_id").val()+"的訂單");
			});			
			$("select#member_id").change(function() {					
				$.ajax({
					url: "./memberOrder?member_id="+$("select#member_id").val(),
					type: "GET",
					dataType: "json",
					success: function (data) {
						   message = $.parseJSON(data.jsondata);

		                
		              
					},
					error:function () {
		                alert("系統錯誤(ajax)");
		            }
				});			
			});			
		</script>
			
	</div>
	<div id="productCancel" class="container tab-pane fade">
	</div>
</div>
</div>
   
<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script	src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>		
</body>
</html>