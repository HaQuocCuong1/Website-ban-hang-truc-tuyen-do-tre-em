  <%-- 
    Document   : index
    Created on : Mar 13, 2021, 8:20:55 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quần áo trẻ em 2021</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.gstatic.com"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font/fontawesome-free-5.15.2-web/css/all.min.css"/>
    </head>
    <body>
        <div class="app">
            <jsp:include page="menu.jsp"></jsp:include>
        <div class="app__container">
            <div class="grid">
                <div class="grid__row app-content">
                    <div class="grid__column-2">
                        <nav class="category">
                            <h3 class="category__heading">
                                <i class="category__heading-icon fas fa-list"></i>
                                Danh mục
                            </h3>
                            <ul class="category-list">
                            <c:forEach items="${categories1}" var="categories">
                                <c:url var="viewUrl" value="/product/list">
                                        <c:param name="categoriesId" value="${categories.id}"/>
                                </c:url>
                                <li class="category-item category-iten--active">                                  
                                    <a href="${viewUrl}" class="category-item-link"><c:out value="${categories.categoryName}"/></a>
                                </li>
                            </c:forEach>                                                  
                            </ul>
                        </nav>
                    </div>
                    <div class="grid__column-10">
                        <div class="home-filter">
                            <span class="home-filter__lable">Sắp xếp theo</span>
                            <button class="home-filter__btn btn">Phổ viến</button>
                            <button class="home-filter__btn btn btn__primary">Mới nhất</button>
                            <button class="home-filter__btn btn">Bán chạy</button>
                            <div class="select-input">
                                <span class="select-input__lable">Giá</span>
                                <i class="fas fa-angle-down"></i>
                                <!-- List option-->
                                <ul class="select-input__list">
                                    <li class="select-input-item">
                                        <a href="" class="select-input-item__link">Giá: thấp đến cao</a>
                                    </li>
                                    <li class="select-input-item">
                                        <a href="" class="select-input-item__link">Giá: cao đến thấp</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="home-filter__page">
                                <span class="home-filter__page-num">
                                    <span class="home-filter__page-curren">1</span>
                                    /14
                                </span>
                                <div class="home-filter__page-controll">
                                    <a href="" class="home-filter__page-btn home-filter__page-btn--disable">
                                        <i class="home-filter__page-icon fas fa-angle-left"></i>
                                    </a>
                                    <a href="" class="home-filter__page-btn">
                                        <i class="home-filter__page-icon fas fa-angle-right"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="home-product">
                            <div class="grid__row">
                    
                                <c:if test="${!empty listproducts}">
                                <c:forEach items="${listproducts}" var="product">
                      
                                        <div class="grid__column-2-4">
                                            <a class="home-product-item" href="${pageContext.request.contextPath}/product/chitiet?productId=${product.id}">
                                                <div class="home-product-item__img" style="background-image: url('${pageContext.request.contextPath}/image/${product.thumbnail}');"></div>
                                                <h4 class="home-product-item__name"><c:out value="${product.productName}" /></h4>
                                                <div class="home-product-item__price">

                                                    <span class="home-product-item__price-current"><c:out value="${product.price}" /></span>
                                                </div>
                                                <div class="home-product-item__action">
                                                    <span class="home-product-item__action-like home-product-item__action-like--liked">
                                                        <i class="home-product-item__like-icon-fill fas fa-heart"></i>
                                                        <i class="home-product-item__like-icon-emtity far fa-heart"></i>
                                                    </span>

                                                    <a style="text-decoration: none;" href="${pageContext.request.contextPath}/cart/addItem?productId=${product.id}"><button class="home-product-item__action-buy">Mua hàng</button></a>
                                                </div>
                                                <div class="home-product-item__origin">
                                                    <span class="home-product-item__brand">whoo</span>
                                                    <span class="home-product-item__origin-name">Japen</span>
                                                </div>
                                            </a>
                                        </div>
                                </c:forEach>
                                </c:if>
                            </div>
                        </div>
                        <ul class="pagination home-product__pagination">
                            <li id="pagination-item" class="pagination-item">
                                <a class="pagination-item__link">
                                    <i class="pagination-item-icon fas fa-angle-left"></i>
                                </a>
                            </li>
                            <li id="pagination-item" class="pagination-item">
                                <a class="pagination-item__link">1</a>
                            </li>
                            <li id="pagination-item" class="pagination-item">
                                <a class="pagination-item__link">2</a>
                            </li>
                            <li id="pagination-item" class="pagination-item">
                                <a class="pagination-item__link">3</a>
                            </li>
                            <li id="pagination-item" class="pagination-item">
                                <a class="pagination-item__link">...</a>
                            </li>
                            <li id="pagination-item" class="pagination-item">
                                <a class="pagination-item__link">14</a>
                            </li>
                            <li id="pagination-item" class="pagination-item">
                                <a class="pagination-item__link">15</a>
                            </li>
                            <li id="pagination-item" class="pagination-item">
                                <a class="pagination-item__link">
                                    <i class="pagination-item-icon fas fa-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <!--Modal layout-->
    <div class="modal modal--disable" id="modal">
        <div class="modal__overlay">
            
        </div>
        <div class="modal__body">
            <div class="auth-form" id="auth-form--dangki">
                <div class="auth-form__container">
                    <div class="auth-form__header">
                        <h3 class="auth-form__heading">Đăng kí</h3>
                        <span id="auth-form__swith--dangki" class="auth-form__swith-ptn">Đăng nhập</span>
                    </div>
                    <div class="auth-form__form">
                        <div class="auth-form__group">
                            <input type="text" class="auth-form__input" placeholder="Nhap email">
                        </div>
                        <div class="auth-form__group">
                            <input type="password" class="auth-form__input" placeholder="Nhap mat khau">
                        </div>
                        <div class="auth-form__group">
                            <input type="password" class="auth-form__input" placeholder="Nhap lai mat khau">
                        </div>
                    </div>
                    <div class="auth-form__controls">
                        <button id="closedangki" class="btn btn-right btn--normal">TRỞ LẠI</button>
                        <button class="btn btn__primary">ĐĂNG KÍ</button>
                    </div>
                </div>
            </div>

             
            <div class="auth-form" id="auth-form--dangnhap">
                <div class="auth-form__container">
                    <div class="auth-form__header">
                        <h3 class="auth-form__heading">Đăng nhập</h3>
                        <span id="auth-form__swith--dangnhap" class="auth-form__swith-ptn">Đăng kí</span>
                    </div>
                    <div class="auth-form__form">
                        <div class="auth-form__group">
                            <input type="text" class="auth-form__input" placeholder="Nhap email">
                        </div>
                        <div class="auth-form__group">
                            <input type="password" class="auth-form__input" placeholder="Nhap mat khau">
                        </div>
                    </div>
                    <div class="auth-form__controls">
                        <button id="closedangnhap" class="btn btn-right btn--normal">TRỞ LẠI</button>
                        <button class="btn btn__primary">ĐĂNG NHẬP</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
