<%-- 
    Document   : quanlisanpham
    Created on : Mar 28, 2021, 3:08:00 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                            <li class="header__navbar--item">Xin chào:&nbsp;<span class="name-admin"><security:authentication property="principal.username" /></span></li>
                            <li class="header__navbar--item">Chức vụ:&nbsp;<span class="name-admin"><security:authentication property="principal.authorities" /></span></li>
                            <li class="header__navbar--item">
                                <form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
                                <input type="submit" value="Logout" />
	
                            </form:form>
                            </li>
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
                            <li class="menu-item"><a href="${pageContext.request.contextPath}/admin/loaisanpham/list" id="menu-item--link" class="menu-item--link">Quản lí sản phẩm</a></li>
                            <li class="menu-item"><a href="${pageContext.request.contextPath}/admin/listkhachhang" id="menu-item--link" class="menu-item--link">Quản lí khách hàng</a></li>
                            <li class="menu-item"><a href="${pageContext.request.contextPath}/admin/hoadon/list" id="menu-item--link" class="menu-item--link">Quản lí hóa đơn</a></li>
                        </ul>
                    </div>
                </div>
            </aside>
            <section class="content">
                <div class="content-product">
                    <div class="header-product">
                        <span class="header-title">Danh sách loại sản phẩm</span>
                    </div>
                    <div class="feature">
                        <a href="${pageContext.request.contextPath}/admin/loaisanpham/showFormForAdd"><input id="button-add-product" class="button-add-product" type="button" value="Thêm Loại sản phẩm" /></a>
                    </div>
                    <div class="info-product">
                        <table class="table-info-product" border="1" cellpadding ="0" cellspacing ="0">
                            <thead>
                                <tr class="info-product-title--list">
                                    <th class="info-product-title--item">Id</th>
                                    <th class="info-product-title--item">Loại Sản phẩm</th>
                                    <th class="info-product-title--item" colspan="3">Action</th>
                                </tr>

                            </thead>
                            <tbody>
                                <c:forEach items="${categories}" var="categories">
                                    <c:url var="editUrl" value="/admin/loaisanpham/showFormForUpdate">
                                        <c:param name="categoriesId" value="${categories.id}"/>
                                    </c:url>
                                    <c:url var="deleteUrl" value="/admin/loaisanpham/delete">
                                        <c:param name="categoriesId" value="${categories.id}"/>
                                    </c:url>
                                    <c:url var="viewUrl" value="/admin/quanlisanpham/list">
                                        <c:param name="categoriesId" value="${categories.id}"/>
                                    </c:url>
                                    <tr class="info-product-content--list">
                                        <td class="info-product-content--item"><c:out value="${categories.id}"/></td>
                                        <td class="info-product-content--item"><c:out value="${categories.categoryName}"/></td>
                                        <td>
                                         
                                            <ul class="btnaction-list">
                                                <li><a class="btnaction-item" href="${editUrl}"> <i class="far fa-edit" style="font-size: 20px; color: blue;"></i></a></li>
                                                <c:if test="${empty categories.products}">
                                                    <li><a class="btnaction-item" href="${deleteUrl}"><i class="far fa-trash-alt" style="font-size: 20px; color: red;"></i></a></li>
                                                </c:if>
                             
                                                <li><a class="btnaction-item btn-view" href="${viewUrl}">
                                                        <i class="far fa-eye" style="font-size: 20px; color: black;"></i>
                                                </a></li>
                                            </ul>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>

                        </table>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>
