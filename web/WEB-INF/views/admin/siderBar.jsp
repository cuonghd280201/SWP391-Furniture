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





        <title>Concept - Bootstrap 4 Admin Dashboard Template</title>
    </head>

    <body>
        <!-- ============================================================== -->
        <!-- main wrapper -->
        <!-- ============================================================== -->
        <div class="dashboard-main-wrapper">
            <!-- ============================================================== -->
            <!-- navbar -->
            <!-- ============================================================== -->

            <!-- ============================================================== -->
            <!-- end navbar -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- left sidebar -->
            <!-- ============================================================== -->
            <div class="nav-left-sidebar sidebar-dark">
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
                                <li class="nav-item">
                                    <a class="nav-link active" href="<c:url value="/admin/dashboard.vn"/>"
                                       data-toggle="collapse" aria-expanded="false" data-target="#submenu-1" aria-controls="submenu-1">
                                        <i class="fa fa-fw fa-user-circle"></i>Dashboard <span class="badge badge-success">6</span>
                                    </a>
                                    <!-- ... Submenu content ... -->
                                </li>

                                <!-- Manager Menu -->
                                <li class="nav-item">
                                    <a class="nav-link" href="#" id="managerLink">Manager</a>
                                    <ul id="submenu" style="display: none;">
                                        <li><a href="<c:url value="/admin/managerCustomer.vn"/>">Manage Customer</a></li>
                                        <li><a href="<c:url value="/admin/managerStaff.vn"/>">Manager Staff</a></li>
                                        <!-- ... Other submenu items ... -->
                                    </ul>
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



    </body>

</html>