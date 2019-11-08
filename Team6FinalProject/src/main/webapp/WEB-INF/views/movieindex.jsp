<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<title>title</title>

</head>

<body style="height: 100%;background-image: url(<c:url value='/Images/pattern.png'  />)"">

	<jsp:include page="header/homeHeader.jsp" />


        
          
          
   
    <section class="container-fluid">
            <div >
	            <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
	                <source src="https://storage.googleapis.com/coverr-main/mp4/Mt_Baker.mp4" type="video/mp4">
	            </video>
	            <div class="container h-100">
	              <div class="d-flex h-100 text-center align-items-center">
	                 <div class="w-100 text-white">
	                   <h1 class="display-3">Video Header</h1>
	                   <p class="lead mb-0">With HTML5 Video and Bootstrap 4</p>
	                 </div>
	              </div>
	            </div>
			</div>  

    </section>
                                           
                                           
    <section class="container-fluid">
            <div >
	            <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
	                <source src="./Movie/BlizzCon2019.mp4" type="video/mp4">
	            </video>
			</div>  
    </section>
    

    <div style="height:auto;background-image: url(<c:url value='/Images/pattern.png'  />)">

    <section class="container">
			    <div class="row">
                    <c:forEach var="movie" items="${movies}" > 
                        <div class="col-lg-4  col-md-2">
                            <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
	                           <source src="Movie/BlizzCon2019.mp4" type="video/mp4">
	                        </video>
                            <div class="card-body">
                                <h6 class="card-title">
                                    ${movie.name }
                                </h6>
                                ${movie.movie_content}
						    </div>
					    </div>
                    </c:forEach>
                </div>

    </section>
<!--  Page Info Section End  -->
    </div>
    <!-- 底色設定 End -->
<!--    Footer Section  -->
	<script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
	<script src="${pageContext.request.contextPath}/JS/main.js"></script>
<%-- 	<jsp:include page="footer/homeFooter.jsp" /> --%>
</body>

</html>