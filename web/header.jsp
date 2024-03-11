<%-- 
    Document   : header.jsp
    Created on : Mar 1, 2024, 12:51:54 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Makaan - Real Estate HTML Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

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
        <style>
            .container-fluid {
                /* Add your existing container styles here */
            }

            .header-carousel {
                /* Add your existing carousel styles here */
            }

            .col-md-6 {
                position: relative;
                z-index: 1; /* Ensure a higher z-index value */
            }

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
                background: #fff;
                padding: 20px;
                border-radius: 10px;
                z-index: 1000; /* Ensure a higher z-index value */
            }
        </style>
    </head>
    <body>
        <!-- Navbar Start -->
        <div class="container-fluid nav-bar bg-transparent">
            <nav class="navbar navbar-expand-lg bg-white navbar-light py-0 px-4">
                <a href="index.html" class="navbar-brand d-flex align-items-center text-center">
                    <div class="icon p-2 me-2">
                        <img class="img-fluid" src="img/icon-deal.png" alt="Icon" style="width: 30px; height: 30px;">
                    </div>
                    <h1 class="m-0 text-primary">Furniture</h1>
                </a>
                <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto">
                        <a href=homePage name="btAction" value="Home" class="nav-item nav-link active">Home</a>
                        <a href="dashboard.jsp" class="nav-item nav-link">About</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Project</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                                                    <a href="MainController?btnAction=Show" class="dropdown-item active">Project List</a>

                                <a href="displayInquiryCustomerController" class="dropdown-item">Inquiry List</a>
                                <a href="property-type.html" class="dropdown-item">Project Type</a>
                                    <a href="MainController?btnAction=Search Interior" class="dropdown-item">Create Project</a>
                            </div>
                        </div>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                                <a href="404.html" class="dropdown-item">404 Error</a>
                            </div>
                        </div>
                        <a href="contact.html" class="nav-item nav-link">Contact</a>
                    </div>
                    <li class="nav-item dropdown notification">
                        <a class="nav-link nav-icons" href="#" id="navbarDropdownMenuLink1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-fw fa-bell"></i> <span class="indicator"></span></a>
                        <ul class="dropdown-menu dropdown-menu-right notification-dropdown">
                            <li>
                                <div class="notification-title"> Notification</div>
                                <div class="notification-list">
                                    <c:import url="GetNotification"></c:import>
                                    <c:set var="noti" value="${sessionScope.NOTIFICATION_RESULT}"/>
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
                    <c:choose>
                        <c:when test="${empty sessionScope.USER}">
                            <!-- If no user is logged in -->
                            <button style="margin: 10px 20px 0 0" type="button" class="btn btn-primary px-3 d-none d-lg-flex" onclick="openModal()">
                                <i class="flaticon-profile"></i>Login
                            </button>
                        </c:when>
                        <c:otherwise>
                            <ul> 
                                <li class="nav-item dropdown nav-user">
                                    <a class="nav-link nav-user-img" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <img src="${sessionScope.USER.image}" alt="My Person" class="rounded-circle media-img-auto" style="width: 50px; height: 50px; margin-right: 10px; cursor: pointer;" onclick="toggleDropdown('dropdown-user')">
                                    </a>                           
                                    <div class="dropdown-menu dropdown-menu-right nav-user-dropdown" aria-labelledby="navbarDropdownMenuLink2">
                                        <div class="nav-user-info">
                                            <b>${sessionScope.USER.firstName} ${sessionScope.USER.lastName}</b>

                                        </div>
                                        <a class="dropdown-item" href="displayUserProfileController"><i class="fas fa-user mr-2"></i>Account</a>
                                        <a class="dropdown-item" href="removeAccountController" onclick="return confirm('Are you sure? Do you want to delete this item?');">Inactive account</a>
                                        <a class="dropdown-item" href="logoutController"><i class="fas fa-power-off mr-2"></i>Logout</a>
                                    </div>
                                </li>
                            </ul>
                        </c:otherwise>
                    </c:choose>


                </div>
            </nav>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
        <script>
                                            function openModal() {
                                                $('#myModal').modal('show');
                                            }
        </script>
        <script>
            function toggleDropdown(id) {
                var dropdown = document.getElementById(id);
                if (dropdown.style.display === "none") {
                    dropdown.style.display = "block";
                } else {
                    dropdown.style.display = "none";
                }
            }
        </script>

    </body>


</html>
