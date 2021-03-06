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
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>


<script src="${pageContext.request.contextPath}/JS/product.js"></script>


</head>

<body>
	<jsp:include page="header/homeHeader.jsp" />


	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">重要消息</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">

				<c:forEach var="product" items="${sessionScope.products }">
					<div class="nt-item">
						<span class="new">${product.category.category }</span><a
							href="<spring:url value='product?game_id=${product.game_id }'/>">${product.name }</a><span>
							只要NT ${product.price }元</span>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
	<!-- Latest news section end -->

	<div
		style="height:auto;background-image: url(<c:url value='/Images/pattern.png' />)">
		<section class="container">
			<div class="row" style="padding: 50px 15%">
				<img width='200' height='200'
					src="<c:url value='/getPicture/${product.game_id}'/>" />
				<h5 style="color: white; font-size: 23px">${product.name }
					<div style="padding-left: 15px; margin-top: 30px">
						<p style="color: pink">商品分類: ${product.category.category}
						<p style="color: pink">發行商: ${product.publisher}
						<p style="font-size: 30px; color: white">
							售價:NT${product.price }元<span
								style="padding-left: 50px; color: white">庫存:${product.stock}</span>
					</div>
				</h5>

				<div>

					<p>
					<h4 style="color: pink">
						商品簡介:
						<p style="color: pink">${product.game_desc }
					</h4>
					<div style="float: right">
						<button type="button" class="btn btn-warning"
							onclick="window.location.href='findProductsByPage'">返回</button>
						<a href='addToCart?game_id=${product.game_id }&count=1'
							class='btn btn-warning btn-large'> <span
							class='glyphicon-shopping-cart glyphicon'></span>加入購物車
						</a>
					</div>
					</p>
				</div>


				<c:forEach var="c" items="${comments }">
					<div class="media border p-3" style="width: 600px;">

						<div class="media-body">
							<h4 style="color: #BBFFEE">${c.member_name }
								<small><i>Posted on ${c.time.replace(".0","")}</i></small>
								<c:choose>
									<c:when test="${sessionScope.mem.username == c.member_name}">
										<small><i id="edit" onclick="update('${c.comment_id}','${c.comment }','${product.game_id }')">編輯</i></small>
									</c:when>
								</c:choose>
							</h4>
							<p id="${c.comment_id}" style="color: #FFFFBB">${c.comment }</p>
						</div>
					</div>
				</c:forEach>



				<div class="form-group">
					<nav class="navbar navbar-expand-sm " style="padding-left: 0px">
						<form class="form-inline" action="addComment">
							<input type="hidden" name="game_id" value="${product.game_id }">
							<textarea class="form-control" rows="1" id="comment"
								name="comment" style="width: 600px" placeholder="請輸入評論..."></textarea>
							<button class="btn btn-success" type="submit">Comment</button>
						</form>
					</nav>
				</div>


			</div>

			<!-- 		<h2>test</h2> -->
			<!--   		<div class="card" style="width:400px"> -->
			<%--     		<img class="card-img-top" src="<c:url value='/getPicture/${product.game_id}'/>" alt="Card image" style="width:100%"> --%>
			<!--     		<div class="card-body"> -->
			<%--      		 <h4 class="card-title">${product.name }</h4> --%>
			<%--      		 <p class="card-text">${product.publisher }</p> --%>
			<%--      	 	<p class="card-text">售價:NT${product.price }元</p> --%>
			<%--       		<p class="card-text">庫存: ${product.stock}</p> --%>
			<%--      		 <p class="card-text">商品分類: ${product.category}</p> --%>
			<%--       		<p class="card-text">商品簡介:${product.game_desc }元</p> --%>
			<!--       		<a href="#" class="btn btn-primary">See Profile</a> -->
			<!--     		</div> -->
			<!--   		</div> -->



		</section>



	</div>
	<jsp:include page="footer/homeFooter.jsp" />



</body>

</html>