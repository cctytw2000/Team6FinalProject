<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header section -->
    <header class="header-section">
        <div class="container">
            <!-- logo -->
            <a class="site-logo" href="${pageContext.request.contextPath}">
                <img src="<c:url value='/Images/logo.png' />" alt="">
            </a>

            <!-- responsive -->
            <div class="nav-switch">
                <i class="fa fa-bars"></i>
            </div>
            <!-- site menu -->
         
                    <nav class="navbar navbar-expand-lg navbar-dark">
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#">首頁<span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">最新消息</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">遊戲討論區</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="membersBack">會員管理</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="productsBack">商品管理</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
    
        </div>
    </header>













