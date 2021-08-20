<%-- 
    Document   : payment
    Created on : May 14, 2021, 12:45:38 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thanh toan</title>
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
                <h2 class="infoCustomer_header_text">THANH TOÁN</h2>
            </div>
            <div class="infoCustomer_content">
                <h3>Thông tin thanh toán</h3>
                <table class="infoCustomer_content_table" cellspacing="3">
                    <tr>
                        <td colspan="2">
                            <input type="text" name="makh" value="<c:out value='${khachhang.makh}' />" class="infoCustomer_content_name" placeholder="Nhập tên ">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="text" name="ten" value="<c:out value='${khachhang.ten}' />" class="infoCustomer_content_name" placeholder="Nhập tên ">
                        </td>
                    </tr>
                    <tr>
                        <td><input type="text"  placeholder="Nhập địa chỉ" value="<c:out value='${khachhang.ngaysinh}' />" class="infoCustomer_content"></td>
                        <td><input type="text" value="<c:out value='${khachhang.sdt}' />" name="soDienThoai" placeholder="Nhập số điện thoại" class="infoCustomer_content"></td>
                    </tr>
                    <tr>
                        <td><input type="text" value="<c:out value='${khachhang.email}' />" name="email" placeholder="Nhập email" class="infoCustomer_content"></td>
                    </tr>
                    <tr>
                        <td><input type="text" value="<c:out value='${khachhang.diachi}' />" name="diachi" placeholder="Nhập email" class="infoCustomer_content"></td>
                    </tr>
                </table>
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
                <div class="infoOrder-title-text"><c:out value="${item.product.productName}"/></div>
                <div class="infoOrder-title-text"><c:out value="${item.product.price}"/><span style="font-size: 10px; font-weight: 400;">đ</span></div>
            </div>
            </c:forEach>
            <div class="infoOrder_title">
                <div class="infoOrder-title-text">Tạm tính</div>
                <div class="infoOrder-title-text">300<span style="font-size: 10px; font-weight: 400;">đ</span></div>
            </div>
            <div class="infoOrder_title">
                <div class="infoOrder-title-text">Tổng</div>
                <div class="infoOrder-title-text"><c:out value="${total}"/><span style="font-size: 10px; font-weight: 400;">đ</span></div>
            </div>
            <div class="infoOrder_title-hinhthuc">
                    <input type="radio" name="hinhthuc" value="1" checked="true"/> Chuyển khoản ngân hàng<br/>
                    <input type="radio" name="hinhthuc" value="2"/> Trả tiền mặt khi nhận<br/>
            </div>
            <div class="infoOrder_btn">
                <a href="${pageContext.request.contextPath}/hoadon/add" style="text-decoration: none;"><input type="button"  class="btn-dathang" value="Đặt hàng"/></a>
            </div>
            
        </div>
    </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
