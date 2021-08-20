<%-- 
    Document   : giaodiendangkytaikhoan
    Created on : May 4, 2021, 9:46:34 PM
    Author     : Dell_Latitude_7480
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng ký tài khoản</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet" type="text/css"> 
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <style type="text/css">
            section {
                background-color: #fff;
            }
        </style>
        
    </head>
    <body>
        <c:url var="dangkyUrl" value="/taikhoan/dangkytaikhoan"/>
        <section style="margin-left: 25%; margin-right: 25%">
            <div class="signup-form-container">
                <!-- form start -->
                <form:form modelAttribute="crmUser" method="post" role="form" onsubmit="return(validate())" name="myForm"
                           id="register-form" autocomplete="off" action="${dangkyUrl}">

                    <div class="form-header">
                        <h3 class="form-title">
                            <i class="fa fa-user"></i> Đăng ký
                        </h3>

                    </div>


                    <!-- Place for messages: error, alert etc ... -->
                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>

                                <!-- Check for registration error -->
                                <c:if test="${registrationError != null}">

                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                        ${registrationError}
                                    </div>

                                </c:if>
                                
                            </div>
                        </div>
                    </div>

                    <div class="form-body">

                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <span class="fa fa-1x fa-user-circle"></span>
                                    </div>
                                </div>
                                <form:input cssClass="form-control" path="userName" class="form-control" name="username"
                                            placeholder="Tên tài khoản"       />
                            </div>

                            <span class="help-block" id="error"></span> <span id="dup"></span>
                        </div>
                        <div class="row">

                            <div class="form-group col-lg-6">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fa fa-id-badge" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                    <input type="text" name="ho" class="form-control" placeholder="Họ" />
                                </div>
                                <span class="help-block" id="error"></span>
                            </div>

                            <div class="form-group col-lg-6">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fa fa-id-badge" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                    <input name="ten" type="text" class="form-control"
                                           placeholder="Tên" />
                                </div>
                                <span class="help-block" id="error"></span>
                            </div>

                        </div>

                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <span class="glyphicon glyphicon-envelope">@</span>
                                    </div>
                                </div>
                                <input type="email" name="email" class="form-control"
                                       placeholder="Email" />
                            </div>
                            <span class="help-block" id="error"></span>
                        </div>

                       <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <span class="glyphicon glyphicon-envelope"></span>
                                    </div>
                                </div>
                                <input type="text" name="diachi" class="form-control"
                                       placeholder="Dia chi" />
                            </div>
                            
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <span>+84</span>
                                    </div>
                                </div>
                                <input type="text" name="sdt" type="number" class="form-control"
                                       placeholder="Số điện thoại" />
                            </div>
                            <span class="help-block" id="error"></span>
                        </div>

                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="fa fa-calendar" aria-hidden="true"></i>
                                    </div>
                                </div>
                                <input name="ngaysinh1" type="date" class="form-control"
                                       placeholder="Ngày sinh">
                            </div>


                            <span class="help-block" id="error"></span>
                        </div>
                        <div class="row">

                            <div class="form-group col-lg-6">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                    <form:password path="password" class="form-control" placeholder="Mật khẩu" name="password"/>
                                </div>
                                <span class="help-block" id="error"></span>
                            </div>

                            <div class="form-group col-lg-6">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                    <input name="cpassword" type="password" class="form-control"
                                           placeholder="Xác nhận mật khẩu">
                                </div>
                                <span class="help-block" id="error"></span>
                            </div>

                        </div>

                        <div class="row">
                            <div class="form-group col-lg-6">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fa fa-transgender-alt" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                    <div style="margin-left: 5px;"
                                         class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" name="gioitinh" value="Nam"
                                               class="custom-radio" checked="checked"
                                               style="margin-top:5px;margin-right:3px;" />
                                        <label for="">Nam</label>


                                    </div>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" name="gioitinh" value="Nữ"
                                               style="margin-top:5px;margin-right:3px;" />
                                        <label for="gioitinh">Nữ</label>
                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="form-footer">
                        <button type="submit" class="btn btn-info">
                            <i class="fa fa-sign-in fa-2" aria-hidden="true"></i> Đăng ký
                        </button>
                    </div>
                </form:form>
            </div>
        </section>


       
      

    </body>
</html>
