<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" -->
<!-- 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<title>所有商品</title>



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
					<span class="new">${product.category.category }</span><a href="<spring:url value='product?game_id=${product.game_id }'/>">${product.name }</a><span> 只要NT ${product.price }元</span>
				</div>
			</c:forEach>
			
			
			
			</div>
		</div>
	</div>
	<!-- Latest news section end -->


<!-- 		style="height: 1px; border: none; color: #333; background-color: #333;"> -->
		
<div style="height:auto;background-image: url(<c:url value='/Images/pattern.png' />)">

	<nav class="navbar navbar-expand-sm ">
  			<form class="form-inline" action="getProductByKeyWord">
   				 <input class="form-control mr-sm-2" type="text" placeholder="Search" name="keyWord">
    			<button class="btn btn-success" type="submit">Search</button>
  			</form>
	</nav>
	
<%-- 	<form method="GET" action="queryCategory"> --%>
<!-- 		<h6 style="color:white">商品分類</h6> -->
<!-- 		<select name="category"> -->
<!-- 			<option value="-1">請挑選</option> -->
<%-- 			<c:forEach var="category" items="${categories }"> --%>
<%-- 				<option value="${category }">${category }</option> --%>
<%-- 			</c:forEach> --%>
<!-- 		</select> -->
<!-- 		<input type="submit" value="查詢"> -->
<%-- 	</form> --%>
	
	<div class="container" style="margin:0px">
	<div class="btn-group">
      <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      	商品分類
      </button>
      <div class="dropdown-menu">
      	<c:forEach var="c" items="${categories }">
			<a class="dropdown-item" href="queryCategory?category_id=${c.category_id }">${c.category }</a>
		</c:forEach>
      </div>
    </div>
	</div>

		
	<section class="container">
		
		<div class="row">
			<c:forEach var="product" items="${products }">
				<div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
					<div class="thumbnail" style="width: 320px; height: 340px">
					<div style="padding-left:25%">
						<img width='150px' height='150px' src="<c:url value='/getPicture/${product.game_id}' />" />
						</div>
						<div class="caption">
							<p align="center"style="max-width:300px;"><a href="<spring:url value='product?game_id=${product.game_id }'/>">${product.name }</a></p>
							<p align="center">NT ${product.price }元</p>
							<p align="center">${product.category.category }</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section> 
</div>

<jsp:include page="footer/homeFooter.jsp" />
</body>
	
</html>