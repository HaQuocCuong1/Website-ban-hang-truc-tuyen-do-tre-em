<%-- 
    Document   : quanlisanpham
    Created on : Mar 28, 2021, 3:08:00 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Quản lí sản phẩm</title>
        <link rel="stylesheet" href="https://fonts.gstatic.com"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"/>
        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font/fontawesome-free-5.15.2-web/css/all.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css" type="text/css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/quanlisanpham.css" type="text/css"/>
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
                            <li class="menu-item"><a href="${pageContext.request.contextPath}/admin/loaisanpham/list" id="menu-item--link" class="menu-item--link">Quản lí sản phẩm</a></li>
                            <li class="menu-item"><a href="#" id="menu-item--link" class="menu-item--link">Quản lí khách hàng</a></li>
                            <li class="menu-item"><a href="#" id="menu-item--link" class="menu-item--link">Quản lí hóa đơn</a></li>
                        </ul>
                    </div>
                </div>
            </aside>
            <section class="content">
                <div class="content-product">
                    <div class="header-product">
                        <span class="header-title">Danh sách sản phẩm</span>
                    </div>
                    <div class="feature">
                        <c:url var="addCcUrl" value="/admin/quanlisanpham/showFormForAdd?categoriesId=${categories.id}" />
                        <a href="${addCcUrl}" style="text-decoration: none;"><input id="button-add-product" class="button-add-product" type="button" value="Thêm sản phẩm" /></a>
                    </div>
                    <div class="info-product">
                        <table class="table-info-product" border="1" cellpadding ="0" cellspacing ="0">
                            <thead>
                                <tr class="info-product-title--list">
                                    <th class="info-product-title--item">Id</th>
                                    <th class="info-product-title--item">Tên Sản phẩm</th>
                                    <th class="info-product-title--item">Mô tả</th>
                                    <th class="info-product-title--item">Số lượng</th>
                                    <th class="info-product-title--item">Đơn giá</th>
                                    <th class="info-product-title--item">Ảnh</th>
                                    <th class="info-product-title--item" style="width: 200px">Action</th>
                                </tr>

                            </thead>
                            <tbody>
                         
                                <c:if test="${!empty categories.products}">
                                <c:forEach items="${categories.products}" var="product">
                                    <c:url var="editUrl" value="/admin/quanlisanpham/showFormForUpdate">
                                        <c:param name="categoriesId" value="${categories.id}"/>
                                    </c:url>
                                    <c:url var="deleteUrl" value="/admin/quanlisanpham/delete">
                                        <c:param name="categoriesId" value="${categories.id}"/>
                                    </c:url>
                                    <c:url var="viewUrl" value="/admin/quanlisanpham/list">
                                        <c:param name="categoriesId" value="${categories.id}"/>
                                    </c:url>
                                    <tr class="info-product-content--list">
                                        <td class="info-product-content--item"><c:out value="${product.id}" /></td>
                                        <td class="info-product-content--item"><c:out value="${product.productName}" /></td>
                                        <td class="info-product-content--item"><c:out value="${product.description}" /></td>
                                        <td class="info-product-content--item"><c:out value="${product.quantity}" /></td>
                                        <td class="info-product-content--item"><c:out value="${product.price}" /></td>
                                        <td class="info-product-content--item"><img class="info-product-content--img" src="${pageContext.request.contextPath}/image/${product.thumbnail}"/></td>
                                      
                                        <td>
                                            <ul class="btnaction-list">
                                                <c:url var="editCcUrl" value="/admin/quanlisanpham/showFormForUpdate?categoriesId=${categories.id}&productId=${product.id}" />
                                                <c:url var="deleteCcUrl" value="/admin/quanlisanpham/delete?productId=${product.id}&categoriesId=${categories.id}" />
                                                <li><a class="btnaction-item" href="${editCcUrl}"> <i class="far fa-edit" style="font-size: 20px; color: blue;"></i></a></li>
                                                
                                                <li><a class="btnaction-item" href="${deleteCcUrl}"><i class="far fa-trash-alt" style="font-size: 20px; color: red;"></i></a></li>
                                                
                                                <li><a class="btnaction-item btn-view" href="${viewUrl}">
                                                        <i class="far fa-eye" style="font-size: 20px; color: black;"></i>
                                                </a></li>
                                            </ul>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </c:if>
                            </tbody>

                        </table>
                    </div>
                </div>
            </section>
        </div>
        
        <script src="${pageContext.request.contextPath}/resources/js/quanlisanpham.js"></script>
    </body>
</html>
