<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>跳轉網頁</title>
<%--     <meta http-equiv="refresh" content="5;url=${pageContext.request.contextPath}"> --%>


    <link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/bootstrap.min.css' type="text/css" />
    <link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/font-awesome.min.css' type="text/css" />
    <link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/owl.carousel.css' type="text/css" />
    <link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/style.css' type="text/css" />
    <link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/animate.css' type="text/css" />

    <script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://kit.fontawesome.com/685268963f.js"></script>





    <style>
        .label1 {
            color: white;
        }

        .sex {
            color: white;
        }
    </style>
</head>





<body>


    <jsp:include page="header/header.jsp" />



    <section class="footer-top-section" style="height: 100%;">
        <div style="height: 378px" class="container">




            <div style="width:70%;height:30%;margin:10% auto;text-align: center;">
                <h1 style="color:white;font-size:50px">${msg}</h1>
                <h3 style="line-height: 2.5em;color:white">
                    頁面將在5秒鐘之後跳轉至首頁，如果沒有跳轉請點<a style="color:#33FFFF" href="${pageContext.request.contextPath}">首頁</a>
                </h3>
            </div>
        </div>

    </section>





    <jsp:include page="footer/footer.jsp" />










</body>

</html>