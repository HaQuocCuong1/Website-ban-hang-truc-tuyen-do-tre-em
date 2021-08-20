<%-- 
    Document   : orderDetailsAdmin
    Created on : May 22, 2021, 10:35:58 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiet hoa don</title>
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
                        <span class="header-title">Chi tiết hóa đơn</span>
                    </div>
                    
                    <div class="info-product">
                        <table class="table-info-product" border="1" cellpadding ="0" cellspacing ="0">
                            <thead>
                                <tr class="info-product-title--list">
                                    <th class="info-product-title--item">Id</th>
                                    <th class="info-product-title--item">Số lượng</th>
                                    <th class="info-product-title--item">Tổng tiền</th>
                                    <th class="info-product-title--item" style="width: 200px">Action</th>
                                </tr>

                            </thead>
                            <tbody>
                                <c:forEach items="${dshoadon}" var="orderdetailitem">
                                    <c:url var="editUrl" value="/admin/chitiethoadon/showForEdit">
                                        <c:param name="orderid" value="${orderid}"/>
                                        <c:param name="orderdetailId" value="${orderdetailitem.orderdetailId}"/>
                                    </c:url>
                                    <tr class="info-product-content--list">
                                        <td class="info-product-content--item"><c:out value="${orderdetailitem.orderdetailId}" /></td>
                                        <td class="info-product-content--item"><c:out value="${orderdetailitem.quantity}" /></td>
                                        <td class="info-product-content--item"><c:out value="${orderdetailitem.totalAmmount}" /></td>
                                        <td>                              
                                            <ul class="btnaction-list">
                                                <li><a class="btnaction-item" href="${editUrl}"> <i class="far fa-edit" style="font-size: 20px; color: blue;"></i></a></li>                                                                                                                        
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
