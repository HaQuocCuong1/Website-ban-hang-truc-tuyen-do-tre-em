<%-- 
    Document   : order-list
    Created on : May 21, 2021, 2:15:13 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thong tin don hang</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/giohang.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/payment.css">
        <link rel="stylesheet" href="https://fonts.gstatic.com"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font/fontawesome-free-5.15.2-web/css/all.min.css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="container">
        <div class="infoCustomer">
            <div class="infoCustomer_header">
                <h2 class="infoCustomer_header_text">Chúc mừng bạn đã đặt hàng thành công</h2>
            </div>
            <div class="infoCustomer_content">
                <h3>Vui lòng chuẩn bị số tiền:<c:out value="${orderdetail.totalAmmount}" /></h3>
            </div>
            <div class="infoCustomer_content">
                <h3>Mã đơn hàng:<c:out value="${order.orderID}" /></h3>
            </div>
        </div>
        <div class="infoOrder">
            <h2>Đơn hàng của bạn</h2>
            <div class="infoOrder_title">
                <div class="infoOrder-title-text">Sản phẩm</div>
                <div class="infoOrder-title-text">Tạm tính</div>
            </div>
            <c:forEach items="${listItem}" var="item">
            <div class="infoOrder_title">
                <div class="infoOrder-title-text"><img src="${pageContext.request.contextPath}/image/${item.product.thumbnail}" alt="" class="table-product-img"></div>
                <div class="infoOrder-title-text"><c:out value="${item.product.productName}" /></div>
                <div class="infoOrder-title-text">200<span style="font-size: 10px; font-weight: 400;">đ</span></div>
            </div>
            </c:forEach>
            <div class="infoOrder_title">
                <div class="infoOrder-title-text">Ngày giao hàng dự kiến</div>
                <div class="infoOrder-title-text"><c:out value="${order.shippedDate}" /></div>
            </div>
            <div class="infoOrder_btn">
                <input type="submit"  class="btn-dathang" value="Xem chi tiết"/>
            </div>
        </div>
    </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
