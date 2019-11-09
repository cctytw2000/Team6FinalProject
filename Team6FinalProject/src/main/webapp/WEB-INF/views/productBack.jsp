<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
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
	<script src="${pageContext.request.contextPath}/JS/membersBack.js"></script>

<script src="https://kit.fontawesome.com/685268963f.js"></script>
<title>商品資料</title>
</head>

<body>
	<jsp:include page="header/manageHeader.jsp" />



	<div style="height:auto;background-image: url(<c:url value='/Images/pattern.png' />)">
		<section class="container">
			<div class="row" style="padding:50px 15%">
				<img width='200' height='200' src="<c:url value='/getPicture/${product.game_id}'/>" />
				<h5 style="color:white;font-size:23px">${product.name }
					<div style="padding-left:15px;margin-top:30px">
						<p style="color:pink">商品分類: ${product.category.category}
							<p style="color:pink">發行商: ${product.publisher}

								<p style="font-size: 30px;color:white">售價:NT${product.price }元<span
										style="padding-left:50px;color:white">庫存:${product.stock}</span>
					</div>
				</h5>

				<div>

					<p>
						<h4 style="color:pink">商品簡介:<p style="color:pink">${product.game_desc }</h4>
						<div style="float:right">
						<button type="button" class="btn btn-warning"
							onclick="window.location.href='<spring:url value='/productsBack'/>'">返回</button>
						<a href='products/update?game_id=${product.game_id }' class='btn btn-warning btn-large'>
							<span class='glyphicon-shopping-cart glyphicon'></span>更改商品資訊
						</a>
						</div>
					</p>
				</div>
				
					
    				<c:forEach var="c" items="${comments }">
    					<div class="media border p-3" style="width:600px">
    
    						<div class="media-body">
     				 			<h4 style="color: #BBFFEE">${c.member_name } 
     				 				<small><i>Posted on ${c.time.replace(".0","")}</i></small>
     				 				<small><i id="remove" onclick="window.location.href='<spring:url value='/removeComment?game_id=${product.game_id}&comment_id=${c.comment_id}'/>'">刪除</i></small>
								</h4>
      							<p id="${c.comment_id}" style="color: #FFFFBB">${c.comment }</p>      
    						</div>
  						</div>
    				</c:forEach>
      				
      				
      				
				<div class="form-group">
  					<nav class="navbar navbar-expand-sm " style="padding-left:0px">
						<form class="form-inline" action="addComment">
							<input type="hidden" name="game_id" value="${product.game_id }">
							<textarea class="form-control" rows="1" id="comment" name="comment" style="width:600px" placeholder="請輸入評論..."></textarea>
							<button class="btn btn-success" type="submit">Comment</button>
						</form>
					</nav>
				</div>
				
				
			</div>

			
		</section>

	</div>
	
	
	
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script	src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>
	<jsp:include page="footer/homeFooter.jsp" />
</body>

</html>