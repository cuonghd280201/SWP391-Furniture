<%-- 
    Document   : profile_user
    Created on : Feb 29, 2024, 1:38:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8">
        <title>Ranna | Author Details</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon -->
        <link rel="shortcut icon" href="img/favicon.png">
        <!-- Normalize Css -->
        <link rel="stylesheet" href="css/normalize.css">
        <!-- Main Css -->
        <link rel="stylesheet" href="css/main.css">
        <!-- Bootstrap Css -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Animate CSS -->
        <link rel="stylesheet" href="css/animate.min.css">
        <!-- Fontawesome CSS -->
        <link rel="stylesheet" href="css/fontawesome-all.min.css">
        <!-- Flaticon CSS -->
        <link rel="stylesheet" href="fonts/flaticon.css">
        <!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <!-- Custom Css -->
        <link href="css/style.css" rel="stylesheet">
        <script src="js/modernizr-3.6.0.min.js"></script>
    </head>
    <body>
        <!-- Model Start -->


        <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
            <![endif]-->

        <!-- Add your site or application content here -->
        <!-- Preloader Start Here -->
        <div id="preloader"></div>
        <!-- Preloader End Here -->
        <!-- ScrollUp Start Here -->
        <!-- ScrollUp End Here -->
        <div id="wrapper" class="wrapper">
            <!-- Header Area Start Here -->            
            <!-- Header Area End Here -->
            <!-- Inne Page Banner Area Start Here -->
            <%@include file="header.jsp" %>

            <!-- Inne Page Banner Area End Here -->
            <!-- Single Author Area Start Here -->
            <section class="single-author-page-wrap padding-top-80 padding-bottom-50">
                <div class="container">
                    <div class="row gutters-60">
                        <div class="col-lg-8">
                            <c:set var="profile_result" value="${requestScope.USER_PROFILE}"/>
                            <c:set var="error" value="${requestScope.UPDATE_ERR}"></c:set>
                            <c:set var="update_profile_trigger" value="${requestScope.EDIT_TRIGGER}"></c:set>
                            <c:if test="${empty update_profile_trigger}">
                                <c:if test="${not empty profile_result}">
                                    <form action="displayUserProfileController" method="POST">

                                        <div class="author-info">
                                            <div class="media media-none--xs" style="display: flex; flex-direction: column">
                                                <div style="display: flex; flex-direction: row">
                                                    <img src="${profile_result.image}" alt="My Person" class="rounded-circle media-img-auto"
                                                         style="width: 15%; height: 20%; margin-right: 10px">

                                                    <div style="display: flex; flex-direction: column; margin-left: 10px; margin-top: 20px">
                                                        <h1 class="author-title">${profile_result.lastName}
                                                        </h1>
                                                    </div>
                                                    <div style="display: flex; flex-direction: column; margin-left: 10px; margin-top: 20px">
                                                        <h1 class="author-title">${profile_result.firstName}
                                                        </h1>
                                                    </div>

                                                    <div style="display: flex; flex-direction: row; margin-left: 20%; margin-top: 20px">
                                                        <div style="margin-bottom: 20px ">
                                                            <input type="submit" name="editBtn" value="Edit profile" class="btn btn-light fa-1x"/>

                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="media-body" style="margin-top: 20px; width: 100%">

                                                    <div style="width: 100%; display: flex; flex-direction: row; border-bottom: solid 1px #C0C0C0">
                                                        <div style="width: 30%">
                                                            <label style="font-size: 20px; font-weight: bold">First Name </label>
                                                        </div>
                                                        <div style="width: 70%; margin-bottom: 10px;">
                                                            <p style="font-size: 25px; text-align: center;">${profile_result.firstName}</p>
                                                        </div>
                                                    </div>
                                                    <div style="width: 100%; display: flex; flex-direction: row; border-bottom: solid 1px #C0C0C0; margin-top: 10px">
                                                        <div style="width: 30%">
                                                            <label style="font-size: 20px; font-weight: bold">LastName: </label>
                                                        </div>
                                                        <div style="width: 70%; margin-bottom: 10px; ">
                                                            <p style="font-size: 25px; text-align: center; width: 100%"> ${profile_result.lastName}</p>
                                                        </div>
                                                    </div>

                                                    <div style="width: 100%; display: flex; flex-direction: row; border-bottom: solid 1px #C0C0C0; margin-top: 10px">
                                                        <div style="width: 30%">
                                                            <label style="font-size: 20px; font-weight: bold">Email: </label>
                                                        </div>
                                                        <div style="width: 70%; margin-bottom: 10px;">
                                                            <p style="font-size: 25px; text-align: center; width: 100%"> ${profile_result.email}</p>
                                                        </div>
                                                    </div>

                                                    <div style="width: 100%; display: flex; flex-direction: row; border-bottom: solid 1px #C0C0C0; margin-top: 10px">
                                                        <div style="width: 30%">
                                                            <label style="font-size: 20px; font-weight: bold">Phone number: </label>
                                                        </div>
                                                        <div style="width: 70%; margin-bottom: 10px; ">
                                                            <p style="font-size: 25px; text-align: center; width: 100%"> ${profile_result.phoneNumber}</p>
                                                        </div>
                                                    </div>

                                                    <div style="width: 100%; display: flex; flex-direction: row; border-bottom: solid 1px #C0C0C0; margin-top: 10px">
                                                        <div style="width: 30%">
                                                            <label style="font-size: 20px; font-weight: bold">Date Of Birth: </label>
                                                        </div>
                                                        <div style="width: 70%; margin-bottom: 10px; ">
                                                            <p style="font-size: 25px; text-align: center; width: 100%"> ${profile_result.dataOfBirth}</p>
                                                        </div>
                                                    </div>





                                                </div>
                                            </div>
                                        </div>
                                    </form>

                                </c:if>
                            </c:if>



                            </section>
                            <%@include file="footer.jsp" %>

                            <!-- Single Author Area End Here -->
                            <!-- Footer Area Start Here -->

                            <!-- Modal End-->  

                            <!-- Jquery Js -->
                            <script src="js/jquery-3.3.1.min.js"></script>
                            <!-- Bootstrap Js -->
                            <script src="js/popper.min.js"></script>
                            <!-- Bootstrap Js -->
                            <script src="js/bootstrap.min.js"></script>
                            <!-- Plugins Js -->
                            <script src="js/plugins.js"></script>
                            <!-- Owl Carousel Js -->
                            <script src="js/owl.carousel.min.js"></script>
                            <!-- Smoothscroll Js -->
                            <script src="js/smoothscroll.min.js"></script>
                            <!-- Custom Js -->
                            <script src="js/main.js"></script>
                            </body>
                            </html>
