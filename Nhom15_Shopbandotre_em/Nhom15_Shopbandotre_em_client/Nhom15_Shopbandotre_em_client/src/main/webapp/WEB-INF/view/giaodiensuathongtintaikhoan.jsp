<%-- 
    Document   : giaodiensuathongtintaikhoan
    Created on : May 5, 2021, 5:56:04 PM
    Author     : Dell_Latitude_7480
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sữa thông tin</title>
        <!-- Fontawesome -->
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet" type="text/css"> 
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <link rel="stylesheet"
              href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
              integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
              crossorigin="anonymous">
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
        </br></br>

        <section class="cartorder">
            <div class="container">

                <div class="row" id="tt">
                    <div class="col-md-3">
                        <div id="ulcart" >  <br>
                            <div class="dropdown">
                                <i style="font-size: 30px; margin-top: -50px" class="fas fa-list" class=" dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                    Tài Khoản </br><h3  style="color: orange; margin-left: 20px">${khachhang.ho} ${khachhang.ten}</h3></i>


                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                    <li><a data-bs-toggle="modal" data-bs-target="#exampleModalthaydoimatkhau" style="height: 40px" class="dropdown-item" href=""><i class="fas fa-unlock-alt" style="font-size: 20px;margin-right: 10px"></i> Đổi mật khẩu</a></li>
                                    <li class="dropdown-item">
                                        <form:form action="${pageContext.request.contextPath}/logout"   method="POST">
                                            <i class="fas fa-sign-out-alt" style="font-size: 20px;margin-right: 10px"></i> 

                                            <input id="logout"   type="submit" value="Đăng xuất" />


                                        </form:form>
                                    </li>
                                </ul>
                            </div>



                        </div>
                    </div>



                    <div class="col-md-9">
                        <c:url var="saveUrl" value="/taikhoan/savesuathongtinkhachhang" />
                        <form:form method="POST" action="${saveUrl}" >
                            <div class="form-group">

                                <div class="form-header">
                                    <h3 class="form-title">
                                        <i class="fa fa-user"></i> Thông tin cá nhân 
                                    </h3>

                                </div>
                                <br/>  
                                <!-- Place for messages: error, alert etc ... -->
                                <div class="form-group">
                                   
                                        <div>

                                            <!-- Check for registration error -->
                                            <c:if test="${registrationError != null}">

                                                <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                                    ${registrationError}
                                                </div>

                                            </c:if>

                                        </div>
                                    
                                </div>
                                <c:if test="${thongbao != null}">
                                    <div class="alert alert-success" role="alert">
                                        ${thongbao}
                                    </div>
                                </c:if>
                                <br/>  
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text" style="height: 100%">
                                                <span class="fa fa-1x fa-user-circle"> Tên tài khoản </span>
                                            </div>
                                        </div>
                                        <input style="color: red"  class="form-control " type="text" name="makh"
                                               placeholder="Tên tài khoản" value="${khachhang.makh}"  disabled="disabled" />
                                    </div>
                                    <span class="help-block" id="error"></span> <span id="dup"></span>
                                </div>
                            </div>
                            <br/>
                            <div class="row">

                                <div class="form-group col-lg-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text" style="height: 100%">
                                                <i class="fa fa-id-badge" aria-hidden="true">  Họ</i>
                                            </div>
                                        </div>
                                        <input type="text" name="ho" class="form-control" placeholder="Họ" value="${khachhang.ho}"/>
                                    </div>
                                    <span class="help-block" id="error"></span>
                                </div>

                                <div class="form-group col-lg-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text" style="height: 100%">
                                                <i class="fa fa-id-badge" aria-hidden="true" ">  Tên</i>
                                            </div>
                                        </div>
                                        <input name="ten" type="text" class="form-control"
                                               placeholder="Tên" value="${khachhang.ten}"  />
                                    </div>
                                    <span class="help-block" id="error"></span>
                                    <br/>
                                </div>

                                <div class="form-group col-lg-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text" style="height: 100%">
                                                <span>+84</span>
                                            </div>
                                        </div>
                                        <input type="text" name="sdt" type="number" class="form-control"
                                               placeholder="Số điện thoại" value="${khachhang.sdt}"/>
                                    </div>
                                    <span class="help-block" id="error"></span>
                                </div>

                                <div class="form-group col-lg-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text" style="height: 100%">
                                                <span>@</span>
                                            </div>
                                        </div>
                                        <input type="text" name="email" type="email" class="form-control"
                                               placeholder="Email" value="${khachhang.email}"/>
                                    </div>
                                    <span class="help-block" id="error"></span>
                                </div>

                            </div>
                            <br/>        
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text" style="height: 100%">
                                            <i class="fa fa-calendar" aria-hidden="true">   Ngày sinh</i>
                                        </div>
                                    </div>
                                    <input name="ngaysinh" type="date" class="form-control"
                                           placeholder="Ngày sinh" value="${khachhang.ngaysinh}" />
                                </div>


                                <span class="help-block" id="error"></span>
                            </div>
                            <br/>    
                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text" style="height: 100%">
                                                <i class="fa fa-transgender-alt" aria-hidden="true">  Giới tính</i>
                                            </div>
                                        </div>

                                        <div style="margin-left: 40px;"
                                             class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" name="gioitinh" value="Nam"
                                                   class="custom-radio" checked="checked"
                                                   style="margin-top:5px;margin-right:3px;" />
                                            <label for="" style="margin-right: 50px">Nam</label>


                                        </div>
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" name="gioitinh" value="Nữ"
                                                   style="margin-top:5px;margin-right:3px;" />
                                            <label for="gioitinh">Nữ</label>
                                        </div>

                                    </div>
                                </div>

                            </div>



                            <br>


                        </div>
                        <div class="col-md-3"></div>
                        <div class="col-md-2"></div>
                        <div class="col-md-4">
                            <button style="width: 90%;height: 110%" type="button" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#exampleModal">Lưu thay đổi</button>
                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Bạn có chắc chắn muốn thay đổi thông tin  không ?</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">

                                        </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-primary">Có</button>
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Không</button>

                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                </form:form>
        </section>


        <!-- Modal thay doi mat khau -->
        <div class="modal fade" id="exampleModalthaydoimatkhau" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <c:url var="savechangepassword" value="/taikhoan/savesuapassword"/>
                <form:form method="POST" action="${savechangepassword}">


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
