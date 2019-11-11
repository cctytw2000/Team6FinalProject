<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增消息圖片</title>
</head>
<body>
	<form:form
		action="${pageContext.request.contextPath}/newsBack/addArticlePicture"
		method="POST" modelAttribute="articlePicture"
		enctype="multipart/form-data">
	選擇主要圖片:<form:input path="newsImage" type="file" />
	
		<p>
			<%-- 	選擇次要圖片:<form:input path="picture" type="file" /> --%>
			<!-- 		<p> -->
			<%-- 	選擇次要圖片:<form:input path="picture" type="file" /> --%>
			<!-- 		<p> -->
			<%-- 	選擇主要圖片:<form:input path="picture" type="file" /> --%>
			<!-- 		<p> -->
			<input type="submit" value="送出">
	</form:form>
</body>
</html>