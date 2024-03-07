<%-- 
    Document   : verify
    Created on : Feb 28, 2024, 2:45:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Email</title>

        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Bakery Recipe| Verify Email</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <!-- Modernizr Js -->
        <script src="js/modernizr-3.6.0.min.js"></script>

    </head>
    <body>
    <body>
        <!--[if lte IE 9]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->
            <%@include file="header.jsp" %>

        <!-- Add your site or application content here -->
        <!-- Preloader Start Here -->
        <div id="preloader"></div>
        <!-- Preloader End Here -->
        <!-- ScrollUp Start Here -->
        <a href="#wrapper" data-type="section-switch" class="scrollup">
            <i class="fas fa-angle-double-up"></i>
        </a>
        <!-- ScrollUp End Here -->
        <div id="wrapper" class="wrapper">

            <!-- Inne Page Banner Area Start Here -->
            <section class="inner-page-banner bg-common" data-bg-image="img/figure/inner-page-banner1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="breadcrumbs-area">
                                <h1>Verify Code Page</h1>
                                <ul>
                                    <li>
                                        <a href="homePage">Home</a>
                                    </li>
                                    <li>Verify Code</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Inne Page Banner Area End Here -->

            <!-- Login Area Start Here -->
            <section class="login-page-wrap padding-top-80 padding-bottom-50">
                <div class="container">
                    <div class="row gutters-60">
                        <div class="col-lg-8">
                            <div class="login-box-layout1">
                                <div class="section-heading heading-dark">
                                    <h2 class="item-heading">VERIFY CODE FORM</h2>
                                </div>
                                <!--REGISTER FORM-->
                                <c:set var="error" value="${requestScope.VerifyCode_ERR}"></c:set>
                                    <form class="login-form" action="verifyCodeController"  method="post">

                                        <input  class="main-input-box" name="authcode" type="text" placeholder="otp code" required
                                                oninvalid="this.setCustomValidity('Enter otp code here')"
                                                oninput="this.setCustomValidity('')"/>
                                    <c:if test="${not empty error.codeIncorrect}">
                                        <font color="red">${error.codeIncorrect}</font></br>
                                    </c:if>


                                    <div class="inline-box mb-5 mt-4">
                                        <button class="btn btn-danger" style="font-size: 1.5rem" type="submit" >Verify Email</button>

                                    </div>
                                </form>

                            </div>
                        </div>


                    </div>
                </div>
            </section>

            <%@include file="footer.jsp" %>

            <!-- Login Area End Here -->

        </div>

        <!-- Jquery Js -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- Bootstrap Js -->
        <script src="js/popper.min.js"></script>
        <!-- Bootstrap Js -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Plugins Js -->
        <script src="js/plugins.js"></script>
        <!-- Smoothscroll Js -->
        <script src="js/smoothscroll.min.js"></script>
        <!-- Custom Js -->
        <script src="js/main.js"></script>
    </body>
</body>
</html>

<!--<form action="verifyCodeController" method="post">
            <input type="text" name="authcode" >
            <input type="submit" value="verify">
</form>-->
