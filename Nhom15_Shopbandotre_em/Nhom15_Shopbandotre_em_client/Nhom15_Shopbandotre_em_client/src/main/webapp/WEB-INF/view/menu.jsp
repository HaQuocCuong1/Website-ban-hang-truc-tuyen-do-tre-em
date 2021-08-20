<%-- 
    Document   : menu
    Created on : Mar 18, 2021, 12:29:17 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<header class="header">
            <div class="grid">
                <nav class="header__navbar">
                    <ul class="header__navbar-list">
                        <li class="header__navbar-item header__navbar-item-QR header__navbar-item--sparate">
                            Vao cua hang
                        </li>
                        <li class="header__navbar-item"><span class="header__navbar--no-pointer">Ket noi</span>
                            <a href="https://www.facebook.com" class="header__navbar-icon--link">
                                <i class="header__nav-icon fab fa-facebook"></i>
                            </a>
                            <a href="https://www.instagram.com" class="header__navbar-icon--link">
                                <i class="header__nav-icon fab fa-instagram"></i>
                            </a>
                        </li>
                    </ul>
                        <ul class="header__navbar-list">
                        <li class="header__navbar-item header__navbar-item-notify">
                            <security:authorize access="hasRole('ADMIN')">
                                <a href="${pageContext.request.contextPath}/admin/loaisanpham/list" class="header__navbar-item-link">
                                    Admin
                                </a>
                            </security:authorize>
                        </li>
                        <li class="header__navbar-item">
                            <a href="#" class="header__navbar-item-link">
                                <i class="header__nav-icon far fa-question-circle"></i>Tro giup
                            </a>
                        </li>
                        <c:if test="${!empty khachhang}">
                        <li class="header__navbar-item">
                            User: <security:authentication  property="principal.username" />
                        </li>
                        </c:if>
                        <c:if test="${!empty khachhang}">
                        <li class="header__navbar-item">
                            <form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
                                <input type="submit" value="Logout" />
	
                            </form:form>
                        </li>
                        </c:if>
                        <li id="opendangki" class="header__navbar-item header__navbar-item--strong header__navbar-item--sparate"><a style="text-decoration: none;" href="${pageContext.request.contextPath}/taikhoan/showFormdangkytaikhoan">Đăng kí</a></li>
                        <li id="opendangnhap" class="header__navbar-item header__navbar-item--strong"><a style="text-decoration: none;" href="${pageContext.request.contextPath}/showMyLoginPage">Đăng nhập</a></li>
                        <!--Sau khi dang nhap-->
                       <!-- <li class="header__navbar-item header__navbar-user">
                            <img src="./assets/img/anh_sinhvien.jpg" alt="" class="header__navbar-user-img">
                            <span class="header__navbar-user-name">Ha Cuong</span>
                            <ul class="header__navbar-user-menu">
                                <li class="header__navbar-user-item">
                                    <a href="">Tài khoản của tôi</a>
                                </li>
                                <li class="header__navbar-user-item">
                                    <a href="">Đơn mua</a>
                                </li>
                                <li class="header__navbar-user-item">
                                    <a href="">Đăng xuất</a>
                                </li>
                            </ul>
                        </li>!-->
                    </ul>
                </nav>
                <!--Header with search-->
                <div class="header-with-serach">
                    <div class="header__logo">
                        <a href="${pageContext.request.contextPath}/trangchu" class="header__logo-link">
                            <img src="${pageContext.request.contextPath}/resources/img/logo-the-gioi-thoi-trang-baby.png" alt="" class="header__logo-img">
                        </a>
                    </div>
                    <div class="header__serach">
                        <!-- Search history-->
                        <div class="header__serach-input-wrap">
                            <input type="text" class="header__serach-input" placeholder="Nhập vào để tìm kiếm">
                            <div class="header__serach-history">
                                <h3 class="header__serach-history-heading">Lich su tim kiem</h3>
                                <ul class="header__serach-history-list">
                                    <li class="header__serach-history-item">
                                        <a href="">Kem duong da</a>
                                    </li>
                                    <li class="header__serach-history-item">
                                        <a href="">Kem tri mun</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <button class="header__serach-btn">
                            <i class="header__serach-btn-icon fas fa-search"></i>
                        </button>
                    </div>
                    <!--header -cart-->
                    <div class="header__cart">
                        <div class="header__cart-wrap">
                            <a href="${pageContext.request.contextPath}/cart/list" style="width: 100px"><i class="header__cart-icon fas fa-shopping-cart"></i></a>
                            <span class="header__cart-notice">3</span>
                            
                        </div>
                    </div>
                </div>
            </div>
        </header>
