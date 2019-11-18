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
    <title>大頭貼清單</title>

    <!-- 	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script> -->
    <link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/bootstrap.min.css' type="text/css" />
    <link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/font-awesome.min.css' type="text/css" />
    <link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/owl.carousel.css' type="text/css" />
    <link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/style.css' type="text/css" />
    <link rel='stylesheet' href='${pageContext.request.contextPath}/CSS/animate.css' type="text/css" />


    <script src="https://kit.fontawesome.com/685268963f.js"></script>
    <script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/JS/login.js"></script> --%>
    <script src="${pageContext.request.contextPath}/JS/HeadShotList.js"></script>
    <!-- <script -->
    <%-- 	src="${pageContext.request.contextPath}/JS/FBGoogleRegistered.js"></script> --%>
    <%-- <script src="${pageContext.request.contextPath}/JS/FBGoogleLogin.js"></script> --%>
</head>

<body>
    <jsp:include page="header/homeHeader.jsp" />


    <!--                                                             <button type="button" id="addnewimg">新增新的大頭貼</button> -->
    <!-- Button trigger modal -->
    <button type="button" id="addnewimg" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
        新增新的大頭貼
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">新增一張大頭貼</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addHeadShot" action="${pageContext.request.contextPath}/member/addHeadShot" method='POST'
                        enctype="multipart/form-data">

                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">關閉</button>

                </div>

            </div>
        </div>
    </div>


















    <section class="container">
        <div class="row">
            <c:choose>
                <c:when test="${fn:length(memberheadshots) != 0 }">

                    <c:forEach var="memberheadshot" items="${memberheadshots}">
                        <div class="col-sm-3" style="width: 400px; height:250px;">

                            <c:choose>
                                <c:when test="${sessionScope.mem.headshot == memberheadshot.headshotname }">
                                    <img style="border:5px solid red;cursor: pointer;" data-toggle="modal"
                                        data-target="#${sessionScope.mem.username}${memberheadshot.id}" width="205"
                                        height="205"
                                        src="<c:url value='/memberImages/${sessionScope.mem.account}_${sessionScope.mem.member_id}/${sessionScope.mem.username}${sessionScope.mem.member_id}${memberheadshot.headshotname}' />">
                                    <h2>哈哈哈</h2>

                                    <div class="modal fade" id="${sessionScope.mem.username}${memberheadshot.id}"
                                        tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                                        aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">想要換此大頭貼嗎?</h5>
                                                    <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <img style="width:50%;margin:5px 100px" height="250"
                                                        src="<c:url value='/memberImages/${sessionScope.mem.account}_${sessionScope.mem.member_id}/${sessionScope.mem.username}${sessionScope.mem.member_id}${memberheadshot.headshotname}' />">

                                                </div>
                                                <div class="modal-footer">

                                                    <button type="button" class="btn btn-secondary"
                                                        data-dismiss="modal">取消</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </c:when>
                                <c:otherwise>

                                    <img style="cursor: pointer;" data-toggle="modal"
                                        data-target="#${sessionScope.mem.username}${memberheadshot.id}" width="205"
                                        height="205"
                                        src="<c:url value='/memberImages/${sessionScope.mem.account}_${sessionScope.mem.member_id}/${sessionScope.mem.username}${sessionScope.mem.member_id}${memberheadshot.headshotname}' />">





                                    <div class="modal fade" id="${sessionScope.mem.username}${memberheadshot.id}"
                                        tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                                        aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">想要換此大頭貼嗎?</h5>
                                                    <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <img style="width:50%;margin:5px 100px" height="250"
                                                        src="<c:url value='/memberImages/${sessionScope.mem.account}_${sessionScope.mem.member_id}/${sessionScope.mem.username}${sessionScope.mem.member_id}${memberheadshot.headshotname}' />">

                                                </div>
                                                <div class="modal-footer">

                                                    <form
                                                        action="${pageContext.request.contextPath}/member/changeHeadShot"
                                                        method="post">
                                                        <input name="id" type="hidden" value="${memberheadshot.id}" />
                                                        <button type="submit" class="btn btn-primary">換</button>
                                                    </form>
                                                    <button type="button" class="btn btn-secondary"
                                                        data-dismiss="modal">不換</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>





                                </c:otherwise>
                            </c:choose>

















                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <img src="<c:url value='/Images/noproduct.png' />" />
                </c:otherwise>
            </c:choose>


        </div>



    </section>








    <form id="addHeadShot" action="${pageContext.request.contextPath}/member/addHeadShot" method='POST'
        enctype="multipart/form-data">


    </form>
    <script src="${pageContext.request.contextPath}/JS/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/JS/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/JS/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/JS/jquery.marquee.min.js"></script>
    <script src="${pageContext.request.contextPath}/JS/main.js"></script>




</body>

</html>