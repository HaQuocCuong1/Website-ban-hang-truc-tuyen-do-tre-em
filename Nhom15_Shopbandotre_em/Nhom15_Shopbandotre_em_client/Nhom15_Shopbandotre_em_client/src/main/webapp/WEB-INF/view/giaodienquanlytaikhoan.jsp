<%-- 
    Document   : giaodienquanlytaikhoan
    Created on : May 4, 2021, 9:47:07 PM
    Author     : Dell_Latitude_7480
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page import="com.shopbandotreem.utils.SortUtils" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lí tài khoản khách hàng</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/base.css" type="text/css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loaisanpham.css" type="text/css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/quanlisanpham.css" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.gstatic.com"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font/fontawesome-free-5.15.2-web/css/all.min.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet" type="text/css"> 
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <style>
            #logout{
                width: 70%;
                border-style: none; 
                background-color: white;
                color: red;
            }
            #logout:hover{
                color: red;
                background-color: #EAEAEA;
            }
        </style>
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
            <div class="tab-content" id="nav-tabContent" style="margin-top: 2%">
                <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                    <div class="container"> 
                        <div class="row"> 

                            <div class="card text-center">
                                <div class="card-header">
                                    <c:if test="${registrationError != null}">

                                        <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                            ${registrationError}
                                        </div>

                                    </c:if>
                                    <c:if test="${thongbao != null}">
                                        <div class="alert alert-success" role="alert">
                                            ${thongbao}
                                        </div>
                                    </c:if> 
                                    <h4>Danh sách tài khoản khách hàng</h4>
                                </div>
                                <%-- Form Search--%>
                                <nav class="navbar navbar-light bg-light" >
                                    <div class="container-fluid">
                                        <c:url var="searchUrl" value="/admin/searchkhachhang"/>
                                        <form:form class="d-flex" action="${searchUrl}" method="GET">
                                            <input  class="form-control me-2" type="text" name="theSearchName" placeholder="Nhập tên user cần tìm.." aria-label="Search" style="width: 120%">
                                            <button class="btn btn-outline-success" type="submit" style="width: 50% ">Tìm kiếm</button>
                                        </form:form>
                                    </div>
                                </nav>
                                <div class="card-body">


                                    <!-- Modal -->

                                    <table class="table table-striped table-bordered table-list" > 


                                        <%-- link sort--%>
                                        <c:url var="sortLinkMakh" value="/admin/listkhachhang">
                                            <c:param name="sort" value="<%= Integer.toString(SortUtils.MAKH)%>" />
                                        </c:url>					
                                        <!-- construct a sort link for last name -->
                                        <c:url var="sortLinkTen" value="/admin/listkhachhang">
                                            <c:param name="sort" value="<%= Integer.toString(SortUtils.HOTEN)%>" />
                                        </c:url>

                                        <thead class="table-danger"> 
                                            <tr>
                                                <th class="hidden-xs">Tài khoản user_name <a href="${sortLinkMakh}"><i class="fas fa-sort-amount-down" style="font-size: 25px; color: seagreen; margin-left: 15px"></i></a></th> 
                                                <th>Họ Tên  <a href="${sortLinkTen}"><i class="fas fa-sort-amount-down" style="font-size: 25px; color: seagreen; margin-left: 15px"></i></a></th> 
                                                <th>Email</th> 
                                                <th>Số điện thoại</th> 
                                                <th>Giới tính</th> 
                                                <th><em class="fa fa-cog"></em></th>
                                            </tr> 
                                        </thead> 

                                        <tbody>

                                            <c:forEach items="${khachhangs}" var="khachhang">

                                                <tr> 

                                                    <td class="hidden-xs">${khachhang.makh}</td> 
                                                    <td>${khachhang.ho} ${khachhang.ten}</td> 
                                                    <td>${khachhang.email}</td> 
                                                    <td>${khachhang.sdt}</td> 
                                                    <td>
                                                        ${khachhang.gioitinh}
                                                    </td>

                                                    <td align="center">
                                                        
                                                        <c:url var="deleteUrl" value="/admin/deletekhachhang">
                                                            <c:param name="makh" value="${khachhang.makh}"/>
                                                        </c:url>
                                                        <c:if test="${empty khachhang.orders}">
                                                        <a href="${deleteUrl}" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${khachhang.makh}"><em class="fa fa-trash"></em></a>
                                                        </c:if>
                                                        <!-- Modal -->
                                                        <div class="modal fade" id="exampleModal${khachhang.makh}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title" id="exampleModalLabel">Bạn có chắc chắn muốn xóa khách hàng này không ?</h5>
                                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                    </div>
                                                                    <div class="modal-body">

                                                                    </div>
                                                                    
                                                                    <div class="modal-footer">
                                                                        <a href="${deleteUrl}"><button type="button" class="btn btn-primary">Có</button></a>
                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Không</button>
                                                                        
                                                                    </div>
                                                                    
                                                                </div>
                                                            </div>
                                                        </div>   
                                                    </td> 



                                                </tr> 

                                            </c:forEach>


                                        </tbody>
                                    </table>
                                    <c:if test="${empty khachhangs}">
                                        <p style="color:red">Không tìm thấy khách hàng nào</p>
                                    </c:if>
                                </div>

                                <div class="card-footer text-muted">

                                </div>
                            </div>
                        </div> 
                    </div> 
                </div>
                <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">...</div>
                <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">...</div>
            </div>


        </div>
    </div>



</div>
</div>


<!-- Modal thay doi mat khau -->
<div class="modal fade" id="exampleModalthaydoimatkhau" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <c:url var="savechangepasswordadmin" value="/taikhoan/savesuapasswordadmmin"/>
        <form:form method="POST" action="${savechangepasswordadmin}">


            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Thay đổi mật khẩu</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>


                <div class="modal-body">
                    <div class="form-group col-lg-12">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="height: 100%">
                                    <i  class="fas fa-sign-in-alt" aria-hidden="true"> Nhập mật khẩu mới</i>
                                </div>
                            </div>
                            <input name="passwordmoi" id="password" type="password"
                                   class="form-control" placeholder="mật khẩu mới">
                        </div>
                        <span class="help-block" id="error"></span>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="form-group col-lg-12">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <div class="input-group-text" style="height: 100%">
                                    <i  class="fas fa-sign-in-alt" aria-hidden="true"> Nhập lại mật khẩu mới</i>
                                </div>
                            </div>
                            <input name="passwordxacnhan" id="password" type="password"
                                   class="form-control" placeholder="mật khẩu mới">
                        </div>
                        <span class="help-block" id="error"></span>
                    </div>
                </div>
                <div class="modal-footer">

                    <button type="submit" class="btn btn-primary">Thay đổi</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>

        </form:form>
    </div>
</div>    
</body>
</html>
