<%-- 
    Document   : giohang
    Created on : Mar 13, 2021, 11:38:13 PM
    Author     : ASUS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/giohang.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
        <link rel="stylesheet" href="https://fonts.gstatic.com"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font/fontawesome-free-5.15.2-web/css/all.min.css"/>
        <title>Giỏ hàng</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="main">
            <div id="content" class="content-area page-wrapper">
                <div class="row row-main">
                    <div class="large-12 col">
                        <div class="col-iner">
                            <div class="continue-shopping">
                                <a style="text-decoration: none;" href="${pageContext.request.contextPath}/trangchu" class="button-continue-shopping">←&nbspTiếp tục xem sản phẩm</a>
                            </div>
                            <header class="entry-header">
                                <h1 class="entry-title">Giỏ hàng</h1>
                            </header>
                            <div class="container">
                                <div class="grid">
                                    <div class="grid__row">
                                        <div class="grid-column-7">
                                            <form class="" action="" method="">
                                                <div class="cart-wrapper sm-touch-scroll">
                                                    <table class="table-product" border="0">
                                                        <thead class="table-product-title">
                                                            <tr>
                                                             
                                                                <th class="table-product-title--item product-name" colspan="2">SẢN PHẨM</th>
                                                                <th class="table-product-title--item product-price">GIÁ</th>
                                                                <th class="table-product-title--item product-quantity">SỐ LƯỢNG</th>
                                                                <th class="table-product-title--item product-subtotal" colspan="2">TẠM TÍNH</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody class="table-product-content">
                                                        <c:forEach items="${listItem}" var="item">
                                                                <tr class="table-product-content-list">
                                                                    
                                                                    <td class="table-product-content-item product-anh-content"><a href="#"><img src="${pageContext.request.contextPath}/image/${item.product.thumbnail}" alt="" class="table-product-img"></a></td>
                                                                    <td class="table-product-content-item product-name-content"><a href="#" class="product-name-font"><c:out value="${item.product.productName}"/><c:out value="${item.quantity}"/></a></td>
                                                                    <td class="table-product-content-item"><span class="price-name-content"><c:out value="${item.product.price}"/><span class="price-name-unit">đ</span></span></td>
                                                                    <td class="table-product-content-item product-quantity-content">
                                                                        <div class="button-add">
                     
                                                                            <c:url var="updateUrl" value="/cart/update">
                                                                                <c:param name="productId" value="${productId}" />
                                                                                <c:param name="qty" value="${qty}" />
                                                                            </c:url>  
                                                                            <form action="${updateUrl}" method="GET">
                                                                                <input type="hidden" value="${item.product.id}" name="productId"/>
                                                                                <input type="number" name="qty" class="input-text" step="1" min="0" max="999" size="4" value="<c:out value='${item.quantity}'/>" title="SL">
                                                                                <button type="submit" style="background-color: blue;" class="btn-remove-product">Edit</button>
                                                                            </form>
                                                                        </div>
                                                                    </td>
                                                                    <td class="table-product-content-item-subtotal-content">
                                                                        <span class="price-name-content"><c:out value="${item.subTotal}"/><span class="price-name-unit">đ</span></span>
                                                                    </td>
                                                                    <td class="table-product-content-item product-remove-content">
                                                                        <c:url var="deleteUrl" value="/cart/remove">
                                                                            <c:param name="productId" value="${productId}"/>
                                                                        </c:url>
                                                                            
                                                                            <form action="${deleteUrl}" method="GET">
                                                                                <input type="hidden" value="${item.product.id}" name="productId"/>
                                                                                <button type="submit" class="btn-remove-product">Xóa</button>
                                                                            </form>
                                                                    </td>
                                                                </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="grid-column-5">
                                            <div class="cart-total">
                                                <div class="cart-total-header">
                                                    <table class="cart-total-heder--table">
                                                        <thead>
                                                            <tr>
                                                                <th class="table-product-title--item cart-total-heder--item">CỘNG GIỎ HÀNG</th>
                                                            </tr>
                                                        </thead>
                                                    </table>
                                                </div>
                                                <table class="table-plust-cart">
                                                    <tbody>
                                                        <tr>
                                                            <th class="product-name-font title-provisional border-underline">Tạm tính</th>
                                                            <td class="date-title border-underline">
                                                                <span class="price-name-content">500,000<span class="price-name-unit">đ</span></span>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <th class="product-name-font title-provisional border-underline">Giao hàng</th>
                                                            <td class="date-title border-underline"><span class="price-name-content">30,000<span class="price-name-unit">đ</span></span></td>                                                                 
                                                        </tr>
                                                        <tr class="order-total">
                                                            <th class="product-name-font title-provisional border-underline">Tổng</th>
                                                            <td class="date-title border-underline"><span class="price-name-content"><c:out value="${total}"/><span class="price-name-unit">đ</span></span></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                <div class="payment">
                                                    <a href="${pageContext.request.contextPath}/payment/form" class="payment-link">TIẾN HÀNH THANH TOÁN</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
