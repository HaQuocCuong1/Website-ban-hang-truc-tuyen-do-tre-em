<%-- 
    Document   : productDetail
    Created on : Mar 19, 2021, 9:50:29 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết sản phẩm</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/giohang.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chitietsanpham.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
        <link rel="stylesheet" href="https://fonts.gstatic.com"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"/>
        <link rel="stylesheet" href="assets/font/fontawesome-free-5.15.2-web/css/all.min.css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="container-detailproduct">
            <div class="grid">
                <div class="grid__row">
                    <div class="grid__column-4">
                        <div class="product-img">
                            <img src="${pageContext.request.contextPath}/image/${product.thumbnail}" alt="" class="product-img__pictures">
                        </div>
                    </div>
                    <div class="grid__column-6">
                        <div class="page-link">
                            <ul class="page-link-list">
                                <li class="page-link-item"><a href="${pageContext.request.contextPath}/trangchu" style="text-decoration: none; color: var(--premary-color);">Trang chủ</a></li>
                                <li class="page-link-item">/</li>
                                <li class="page-link-item">Quần áo bé gái</li>
                            </ul>
                        </div>
                                <c:url var="addcard" value="/cart/add">
                                    <c:param name="productId" value="${productId}"/>
                                    <c:param name="qty" value="${qty}"/>
                                </c:url>
                        <form:form modelAttribute="CartItem" method="GET" action="${addcard}">
                            <input type="hidden" name="productId" value="${product.id}"/>
                        <div class="prodct-name">
                            ${product.productName}
                        </div>
                        <div class="product-price">
                            <span>${product.price}<span>đ</span></span>
                        </div>
                        <div class="product-content">
                            <p class="product-text">${product.description}</p>
                        </div>
                        <div class="product-size">
                            <div class="product-size-img">
                               <ul class="product-size-list">
                                   <li class="product-size-item">Có 4 size: 3tuổi, 5tuổi, 8 tuổi, 12 tuổi</li>
                               </ul>
                               <span class="product-lable-title">Size</span>
                               <div class="product-size-btn">
                                    <input class="select-size" type="button" value="1-3t">
                                    <input class="select-size" type="button" value="4-5t">
                                    <input class="select-size" type="button" value="6-8t">
                                    <input class="select-size" type="button" value="9-12t">
                               </div>
                            </div>
                        </div>
                        <div class="product-quantity">
                            <span class="product-lable-title">Số lượng</span>
                            <div class="button-add">
                                <input name="qty" type="number" class="input-text" step="1" min="0" max="999" size="4" value="1" title="SL">
                            </div>
                        </div>
                  
                        <div class="product-by">
                            <input type="submit" class="product-by-btn" value="Mua hàng" />
                        </div>
                        </form:form>
                    </div>
                    <div class="grid__column-2">
                        <ul class="necessary-info">
                            <li>
                                <h3 class="info-title">Giao hàng nhanh chóng</h3>
                                <p class="info-content">Chi trong vòng 24 giờ</p>
                            </li>
                            <li>
                                <h3 class="info-title">Bé khẻo mẹ yên tâm</h3>
                                <p class="info-content">100% sản phẩm an toàn cho bé</p>
                            </li>
                            <li>
                                <h3 class="info-title">Đổi trả dễ dàng</h3>
                                <p class="info-content">Đổi hàng trong 7 ngày miễn phí</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="grid__row">
                    <div class="product-description">
                        <div class="header-description">
                            <span class="product-lable-title">Mô tả</span>
                        </div>
                        <div class="info-description">
                            <table class="table-description">
                                <tbody>
                                    <tr class="description-color">
                                        <th class="description-design">Tên sản phẩm</th>
                                        <td>
                                            <p class="description-design product-text"> ${product.productName}</p>
                                        </td>
                                    </tr>
                                    <tr>

                                        <th class="description-design">Xuất xứ</th>
                                        <td>
                                            <p class="product-text description-design">Quần áo trẻ việt nam</p>
                                        </td>
                                    </tr>
                                    <tr class="description-color">

                                        <th class="description-design">Giới tính</th>
                                        <td>
                                            <p class="product-text description-design">Nữ</p>
                                        </td>
                                    </tr>
                                    <tr>

                                        <th class="description-design">Độ tuổi</th>
                                        <td>
                                            <p class="product-text description-design">10 - 31kg</p>
                                        </td>
                                    </tr>
                                    <tr class="description-color">

                                        <th class="description-design">Chất liệu</th>
                                        <td>
                                            <p class="description-design product-text"> Tafta, Oganza và tơ óng </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="description-design">Màu sắc</th>
                                        <td>
                                            <p class="description-design product-text">trắng, đen</p>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="grid__row">
                    <div class="border-color">
                        <div class="comment-product">
                            <div class="header-lable">Nhận xét của bạn</div>
                            <div class="">
                            <textarea class="content-cmt" rows="6" cols="70" placeholder="Đánh giá về sản phẩm gửi câu hỏi"></textarea>
                            </div>
                            <div>
                                <input class="submit-cmt" type="submit" value="Gửi">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
