<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>所有商品</title>
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
	
	
</head>

<body>
<jsp:include page="header/manageHeader.jsp" />
<div class="container mt-3">
	<h1>商品管理</h1>
<%-- 	<form method="GET" action="queryCategory"> --%>
<!-- 		商品分類<select name="category"> -->
<!-- 			<option value="-1">請挑選</option> -->
<%-- 			<c:forEach var="category" items="${categories }"> --%>
<%-- 				<option value="${category.category }">${category.category }</option> --%>
<%-- 			</c:forEach> --%>
<!-- 		</select> -->
<!-- 		<input type="submit" value="查詢"> -->
<%-- 	</form> --%>
<!-- 	<nav class="navbar navbar-expand-sm "> -->
<%-- 		<form class="form-inline" action="productsBack/addCategory"> --%>
<!-- 			<input class="form-control mr-sm-2" type="text" name="category" placeholder="新增商品分類"> -->
<!-- 			<button class="btn btn-success" type="submit">送出</button> -->
<%-- 		</form> --%>
<!-- 	</nav> -->
	
<!-- 	<button type="button" class="btn btn-primary" onclick="window.location.href='productsBack/add'">新增商品</button> -->
	
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#product">架上商品</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#productCancel">架下商品</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#addCategory">新增商品分類</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab" href="#addProduct">新增商品</a></li>
	</ul>
	
	<div class="tab-content">
	
	
	<div id="product" class="container tab-pane active">
	<table border="1" style="text-align: center">
		<tr><th>商品編號<th>商品名稱<th>商品售價<th>商品分類<th>下架
			<c:forEach var="product" items="${products }">

			<tr><td>${product.game_id }
				<td><a href="<spring:url value='productsBack/productBack?game_id=${product.game_id }'/>">${product.name }</a>
				<td>${product.price }元
				<td>${product.category.category }
				<td><button type="button" class="btn btn-warning" onclick="window.location.href='productsBack/products/delete?game_id=${product.game_id }'">下架</button>
		
			</c:forEach>
	</table>
	</div>
	
	<div id="productCancel" class="container tab-pane fade">
	<table border="1" style="text-align: center">
		<tr><th>商品編號<th>商品名稱<th>商品售價<th>商品分類<th>上架
			<c:forEach var="c_product" items="${cancelProduct }">

			<tr><td>${c_product.game_id }
				<td><a href="<spring:url value='productsBack/productBack?game_id=${c_product.game_id }'/>">${c_product.name }</a>
				<td>${c_product.price }元
				<td>${c_product.category.category }
				<td><button type="button" class="btn btn-warning" onclick="window.location.href='productsBack/products/reAdd?game_id=${c_product.game_id }'">上架</button>
		
			</c:forEach>
	</table>
	</div>
	
	<div id="addProduct" class="container tab-pane fade">
		<form method="POST" action="productsBack/addProduct" enctype="multipart/form-data">
		商品分類:<select name="category_id">
			<option value="-1">請挑選</option>
				<c:forEach var="c" items="${categoryMap}">
					<option value="${c.key }">${c.value }
				</c:forEach>
		</select>
		<p>
			商品名稱:
			<input name="name" type="text" size="50px" />
			<p>
				廠商名稱:
				<input name="publisher" type="text" size="50px" />
				<p>
					商品價格:
					<input name="price" type="text" />
					<p>
						庫存數量:
						<input name="stock" type="text" />
						<p>
							商品描述:
							<textarea name="game_desc" style="width:400px;height:200px;" ></textarea>
							<p>
								是否上架:
								<input type="radio" name="is_remove" value="0" id="0" /><label for="0">是</label>
								<input type="radio" name="is_remove" value="1" id="1" /><label for="1">否</label>
								<p>
									選擇圖片:
									<input name="productImage" type="file" />
									<p>
										<input type="submit" value="送出">
		</form>
	</div>
	
	<div id="addCategory" class="container tab-pane fade">
		<nav class="navbar navbar-expand-sm ">
		<form class="form-inline" action="productsBack/addCategory">
			<input class="form-control mr-sm-2" type="text" name="category" placeholder="新增商品分類">
			<button class="btn btn-success" type="submit">送出</button>
		</form>
	</nav>
	
	</div>
	
	
</div>


	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script	src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>

</body>

</html>