<%-- 
    Document   : siderBarStaff
    Created on : Mar 7, 2024, 12:27:06 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->


        <link href="<c:url value="/assets/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/assets/vendor/fonts/circular-std/style.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/assets/libs/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/assets/vendor/fonts/fontawesome/css/fontawesome-all.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/assets/vendor/charts/chartist-bundle/chartist.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/assets/vendor/charts/morris-bundle/morris.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/assets/vendor/charts/c3charts/c3.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/assets/vendor/fonts/flag-icon-css/flag-icon.min.css"/>" rel="stylesheet" type="text/css"/>


        <style>
            /* Popup styling */
            .popup {
                display: none;
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: white;
                padding: 20px;
                border: 1px solid #ccc;
                z-index: 1000;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                width: 80%;
                height: 80%;
                max-width: 3000px; /* Thay đổi giá trị này nếu bạn muốn giới hạn chiều rộng tối đa */
                max-height: 4000px; /* Thay đổi giá trị này nếu bạn muốn giới hạn chiều cao tối đa */
            }



            .popup-content {
                position: relative;
            }

            .close-btn {
                position: absolute;
                top: 10px;
                right: 10px;
                cursor: pointer;
                font-size: 20px;
                color: #555; /* You can customize the color */
            }

            input[type=text], select, textarea{
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                resize: vertical;
            }

            /* Style the label to display next to the inputs */
            label {
                padding: 12px 12px 12px 0;
                display: inline-block;
            }

            /* Style the submit button */
            input[type=submit] {
                background-color: #04AA6D;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: right;
            }

            /* Style the container */
            .container {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }

            /* Floating column for labels: 25% width */
            .col-25 {
                float: left;
                width: 25%;
                margin-top: 6px;
            }

            /* Floating column for inputs: 75% width */
            .col-75 {
                float: left;
                width: 75%;
                margin-top: 6px;
            }

            /* Clear floats after the columns */
            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 600px) {
                .col-25, .col-75, input[type=submit] {
                    width: 100%;
                    margin-top: 0;
                }
            }
        </style>





        <title>Furniture</title>
    </head>



        <body>
            <!-- ============================================================== -->
            <!-- main wrapper -->
            <!-- ============================================================== -->
            <div class="dashboard-main-wrapper">

                <!-- ============================================================== -->
                <!-- navbar -->
                <!-- ============================================================== -->
                <div class="dashboard-header">
                    <nav class="navbar navbar-expand-lg bg-white fixed-top">
                        <a class="navbar-brand" href="dashboard.jsp">FURNITURE</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse " id="navbarSupportedContent">
                            <ul class="navbar-nav ml-auto navbar-right-top">
                                <li class="nav-item">
                                    <div id="custom-search" class="top-search-bar">
                                        <input class="form-control" type="text" placeholder="Search..">
                                    </div>
                                </li>
                                <li class="nav-item dropdown notification">
                                    <a class="nav-link nav-icons" href="#" id="navbarDropdownMenuLink1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-fw fa-bell"></i> <span class="indicator"></span></a>
                                    <ul class="dropdown-menu dropdown-menu-right notification-dropdown">
                                        <li>
                                            <div class="notification-title"> Notification</div>
                                            <div class="notification-list">
                                            <c:import url="GetNotificationStaff"></c:import>
                                            <c:set var="noti" value="${sessionScope.NOTIFICATION_RESULT_STAFF}"/>
                                            <c:if test="${not empty noti}">
                                                <c:forEach var="notiDto" items="${noti}" varStatus="counter">

                                                    <div class="list-group">
                                                        <a href="#" class="list-group-item list-group-item-action active">
                                                            <div class="notification-info">
                                                                <div class="notification-list-user-img"><img src="img/inquiry.jpg" alt="" class="avatar-md img-thumbnail rounded-circle" /></div>
                                                                <div class="notification-list-user-block"><span class="notification-list-user-name">${notiDto.notificationContent}</span>
                                                                    <div class="notification-date">${notiDto.createAt}</div>                                                       
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </c:forEach>

                                            </c:if>
                                            <c:if test="${empty noti}">
                                                <div style="border-bottom: solid 1px black">
                                                    <p>No notification yet</p>
                                                </div>
                                            </c:if>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="list-footer"> <a href="#">View all notifications</a></div>
                                    </li>
                                </ul>
                            </li>

                            <li class="nav-item dropdown nav-user">

                                <a class="nav-link nav-user-img" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <img src="${sessionScope.USER.image}" alt="" class="user-avatar-md rounded-circle">
                                </a>                           
                                <div class="dropdown-menu dropdown-menu-right nav-user-dropdown" aria-labelledby="navbarDropdownMenuLink2">
                                    <div class="nav-user-info">
                                        <h5 class="mb-0 text-white nav-user-name">${sessionScope.USER.firstName}</h5>
                                        <span class="status"></span><span class="ml-2">${sessionScope.USER.firstName}</span>
                                    </div>
                                    <a class="dropdown-item" href="#"><i class="fas fa-user mr-2"></i>Account</a>
                                    <a class="dropdown-item" href="#"><i class="fas fa-cog mr-2"></i>Setting</a>
                                    <a class="dropdown-item" href="logoutController"><i class="fas fa-power-off mr-2"></i>Logout</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>

            <!-- ============================================================== -->
            <!-- end navbar -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- left sidebar -->
            <!-- ============================================================== -->
            <div class="nav-left-sidebar sidebar-dark" id="sidebar">
                <button class="btn btn-primary" id="sidebarToggleBtn">
                    <i class="fas fa-bars"></i>
                </button>
                <div class="menu-list">
                    <nav class="navbar navbar-expand-lg navbar-light">
                        <a class="d-xl-none d-lg-none" href="#">Dashboard</a>

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav flex-column">
                                <!-- ... Other menu items ... -->

                                <!-- Dashboard Menu -->


                                <li>
                                    <a href="listInquiryStaff.jsp" class="nav-link" aria-expanded="false" aria-controls="submenu">
                                        <i class="fas fa-fw fa-user"></i> List Inquiry
                                    </a>               
                                </li>
                                <!-- Manager Menu -->
                                <li>
                                    <a href="listInquiryS.jsp" class="nav-link" aria-expanded="false" aria-controls="submenu">
                                        <i class="fas fa-fw fa-user"></i> List Inquiry
                                    </a>               
                                </li>

                                <li>
                                    <a href="listInquiryS.jsp" class="nav-link" aria-expanded="false" aria-controls="submenu">
                                        <i class="fas fa-fw fa-user"></i> List Inquiry
                                    </a>               
                                </li>

                            </ul>
                        </div>
                    </nav>
                </div>

            </div>

            <!-- ============================================================== -->
            <!-- end left sidebar -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- wrapper  -->
            <!-- ============================================================== -->

            <!-- ============================================================== -->
            <!-- end main wrapper  -->
            <!-- ============================================================== -->
            <!-- Optional JavaScript -->
            <!-- jquery 3.3.1 -->
            <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
            <!-- bootstap bundle js -->
            <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
            <!-- slimscroll js -->
            <script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
            <!-- main js -->
            <script src="assets/libs/js/main-js.js"></script>
            <!-- chart chartist js -->
            <script src="assets/vendor/charts/chartist-bundle/chartist.min.js"></script>
            <!-- sparkline js -->
            <script src="assets/vendor/charts/sparkline/jquery.sparkline.js"></script>
            <!-- morris js -->
            <script src="assets/vendor/charts/morris-bundle/raphael.min.js"></script>
            <script src="assets/vendor/charts/morris-bundle/morris.js"></script>
            <!-- chart c3 js -->
            <script src="assets/vendor/charts/c3charts/c3.min.js"></script>
            <script src="assets/vendor/charts/c3charts/d3-5.4.0.min.js"></script>
            <script src="assets/vendor/charts/c3charts/C3chartjs.js"></script>
            <script src="assets/libs/js/dashboard-ecommerce.js"></script>
            <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
            <!-- JavaScript for highlighting active menu -->
            <script>
                $(document).ready(function () {
                    // Get the current URL
                    var currentUrl = window.location.pathname;

                    // Highlight the active menu item and open the submenu
                    $('.nav-item a').filter(function () {
                        return this.href === currentUrl;
                    }).addClass('active');

                    // Check if the active menu item is a submenu item
                    var activeMenuItem = $('.nav-item a.active');
                    if (activeMenuItem.parent().hasClass('nav-item')) {
                        activeMenuItem.parent().children('ul').show();
                        $("#managerLink").addClass('active');
                    }

                    // Toggle submenu visibility
                    $(".nav-item a").click(function (e) {
                        var clickedItem = $(this);
                        var isSubmenu = clickedItem.parent().hasClass('nav-item');

                        // Remove 'active' class from all menu items
                        $('.nav-item a').removeClass('active');
                        $("#managerLink").removeClass('active');

                        if (isSubmenu) {
                            e.preventDefault();
                            clickedItem.parent().children('ul').toggle();
                            $("#managerLink").addClass('active'); // Add 'active' class to the Manager link when submenu is visible
                        } else {
                            clickedItem.addClass('active');
                        }
                    });
                });
            </script>

            <script>
                $(document).ready(function () {
                    // Toggle sidebar when the button is clicked
                    $('#sidebarToggleBtn').click(function () {
                        console.log('Button clicked'); // Check if this is logged
                        $('#sidebar').toggleClass('show');
                        console.log('Sidebar toggled'); // Check if this is logged
                    });
                });
            </script>



    </body>

</html>