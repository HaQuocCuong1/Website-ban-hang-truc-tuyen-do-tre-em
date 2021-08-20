

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Log In</title>
        <!-- Fontawesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
              integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <!--Bootstrap 4.3.1-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!--CSS-->
        
    </head>
    <body>
        <section>
            <div class="container" id="cont-loginform" style="margin-left: 30%;margin-top:5%">
                <div class="card  w-50" id="cardForm">
                    <div class="card-header">
                        <h3>SIGN IN</h3>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/authenticateTheUser" 
                          method="POST" class="form-horizontal">

                            <!-- Place for messages: error, alert etc ... -->
                            <div class="form-group">
                                <div class="col-xs-15">
                                    <div>

                                        <!-- Check for login error -->

                                        <c:if test="${param.error != null}">

                                            <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                                Nhập sai username và password.
                                            </div>

                                        </c:if>

                                        <!-- Check for logout -->

                                        <c:if test="${param.logout != null}">

                                            <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                                Bạn đăng xuất thành công.
                                            </div>

                                        </c:if>

                                    </div>
                                </div>
                            </div>

                            <h5 class="card-title">Username</h5>
                              <input type="text" name="username" placeholder="username" class="form-control">
                            <h5 class="card-title">Password</h5>
                            <input type="password" name="password" placeholder="password" class="form-control" > <br>
                             <button type="submit" class="btn btn-success">Đăng nhập</button>
                             
                             <!-- I'm manually adding tokens ... Bro! -->

                                <input type="hidden"
                                   name="${_csrf.parameterName}"
                                   value="${_csrf.token}" />
                        </form>
                        <br>
                        <c:url var="dangkytaikhoanURL" value="/taikhoan/showFormdangkytaikhoan"/>
                        <div class="card-text">Bạn chưa có tài khoản nhấn vào đây để đăng ký  ? <a href="${dangkytaikhoanURL}">Đăng ký tài khoản</a></div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
