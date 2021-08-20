<%-- 
    Document   : quanlisanpham
    Created on : Mar 28, 2021, 3:08:00 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Quản lí sản phẩm</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css" type="text/css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loaisanpham.css" type="text/css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/quanlisanpham.css" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.gstatic.com"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font/fontawesome-free-5.15.2-web/css/all.min.css"/>
    </head>
    <body>
        <div class="app">
            <header class="header-admin">
                <div class="grid">
                    <div class="header__navbar">
                        <ul class="header__navbar--list"> 
                            <li class="header__navbar--item">Xin chào:&nbsp;<span class="name-admin">Admin</span></li>
                        </ul>
                        <ul class="header__navbar--list">
                            <li class="header__navbar--item header-item--logout"><a href="${pageContext.request.contextPath}/trangchu" class="logout-link">Trang chủ</a></li>
                        </ul>
                    </div>
                </div>
            </header>
            <aside class="menu">
                <div class="menu-container">
                    <div class="menu-header">
                        <span>Menu</span>
                    </div>
                    <div class="menu-content">
                        <ul class="menu-list"> 
                            <li class="menu-item"><a href="#" id="menu-item--link" class="menu-item--link">Quản lí sản phẩm</a></li>
                            <li class="menu-item"><a href="#" id="menu-item--link" class="menu-item--link">Quản lí khách hàng</a></li>
                            <li class="menu-item"><a href="#" id="menu-item--link" class="menu-item--link">Quản lí hóa đơn</a></li>
                        </ul>
                    </div>
                </div>
            </aside>
            <section class="content">
                <div class="content-product">
                   <div class="modal__body">
                        <div class="auth-form">
                            <div class="auth-form__container">
                                <div class="auth-form__header">
                                    <h3 class="auth-form__heading">Edit Quantity</h3>
                                </div>
                                <c:url var="saveUrl" value="/admin/chitiethoadon/updateOrderDetail">
                                    <c:param name="orderid" value="${orderID}"/>
                                </c:url>
                                <form:form modelAttribute="orderDetailAttribute" method="POST" action="${saveUrl}">
                                    
                                    <div class="auth-form__form">
                                        <input type="hidden" name="orderdetailId" value="<c:out value='${orderDetailsAttribute.orderdetailId}' />"/>
                                        <label class="auth-form--title">Số lượng:</label>
                                        <div class="auth-form__group">
                                            <input name="quantity" class="auth-form__input" value="<c:out value='${orderDetailsAttribute.quantity}' />"/>
                                            
                                        </div>
                                        <input type="hidden" name="totalAmmount" value="<c:out value='${orderDetailsAttribute.totalAmmount}' />"/>
                                    </div>
                                    <div class="auth-form__controls">
                                        <input type="submit" class="btn btn__primary" value="Save"/>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>
