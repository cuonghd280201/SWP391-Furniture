<%-- 
    Document   : detailProject
    Created on : Feb 29, 2024, 3:50:12 PM
    Author     : Admin
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Project Detail</title>
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
                                <a href="property-list.html" class="dropdown-item">Project List</a>
                                <a href="property-type.html" class="dropdown-item">Project Type</a>
                                <a href="property-agent.html" class="dropdown-item">Project Agent</a>
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
                    <c:choose>
                        <c:when test="${empty sessionScope.USER}">
                            <!-- If no user is logged in -->
                            <button style="margin: 10px 20px 0 0" type="button" class="btn btn-primary px-3 d-none d-lg-flex" onclick="openModal()">
                                <i class="flaticon-profile"></i>Login
                            </button>
                        </c:when>
                        <c:otherwise>
                            <!-- If a user is logged in -->
                            <!-- Clicking on the image will toggle the dropdown menu -->
                            <img src="${sessionScope.USER.image}" alt="My Person" class="rounded-circle media-img-auto" style="width: 40px; height: 40px; margin-right: 10px; cursor: pointer;" onclick="toggleDropdown('dropdown-user')">

                            <b>${sessionScope.USER.firstName} ${sessionScope.USER.lastName}</b>

                            <!-- Dropdown menu for user actions -->
                            <ul class="dropdown-menu-col-1" id="dropdown-user" style="width: 15rem; display: none;">
                                <!-- User actions -->
                                <li style="display: inline-block; width: 100%">
                                    <a href="displayUserProfileController">Profile</a>
                                </li>
                                <li style="display: inline-block; width: 100%">
                                    <c:url var="Reset_url" value="resetPasswordPage"></c:url>
                                    <a href="${Reset_url}">Reset Password</a>
                                </li>
                                <li style="display: inline-block; width: 100%">
                                    <a href="removeAccountController" onclick="return confirm('Are you sure? Do you want to delete this item?');">Inactive account</a>
                                </li>
                                <li style="display: inline-block; width: 100%">                                                                                        
                                    <a href="logoutController">Logout</a>
                                </li> 
                            </ul>
                        </c:otherwise>
                    </c:choose>


                </div>
            </nav>

            <c:set var="image" value="${DETAIL_PROJECT.imageDTO}"/>

            <div class="container-xxl py-5">
                <div class="container">
                    <div class="row g-5 align-items-center">
                        <div class="col-lg-6 wow fadeIn" data-wow-delay="0.1s">
                            <div class="about-img position-relative overflow-hidden p-5 pe-0">
                                <img class="img-fluid w-100" src="${image.imageURL}">
                            </div>
                        </div>
                        <div class="col-lg-6 wow fadeIn" data-wow-delay="0.5s">
                            <h1 class="mb-4">${DETAIL_PROJECT.projectName}</h1>
                            <p class="mb-4">${DETAIL_PROJECT.description}</p>
                            <p><i class="fa fa-balance-scale text-primary me-3"></i>${DETAIL_PROJECT.scale}</p>
                            <p><i class="fa fa-clock text-primary me-2"></i>${DETAIL_PROJECT.createAt}</p>
                            <p>

                                <c:set var="formattedPrice">
                                    <fmt:formatNumber type='currency' value='${DETAIL_PROJECT.price}' currencySymbol='VND'/>
                                </c:set>
                                <c:out value="${formattedPrice}" />
                            </p>

                            <p><i class="fa fa-building text-primary me-3"></i>${DETAIL_PROJECT.scale}</p>
                            <p><i class="fa fa-info-circle text-primary me-3"></i>${DETAIL_PROJECT.status}</p>

                            <a href="" class="btn btn-dark py-3 px-4"><i class="fa fa-calendar-alt me-2"></i>Request A Quote</a>


                        </div>
                    </div>
                    <div id="tab-1" class="tab-pane fade show p-0 active">
                        <div class="row g-4">
                            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                                <div class="property-item rounded overflow-hidden">
                                    <div class="position-relative overflow-hidden">
                                        <a href=""><img class="img-fluid" src="img/property-1.jpg" alt=""></a>
                                    </div>

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                                <div class="property-item rounded overflow-hidden">
                                    <div class="position-relative overflow-hidden">
                                        <a href=""><img class="img-fluid" src="img/property-2.jpg" alt=""></a>

                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                                <div class="property-item rounded overflow-hidden">
                                    <div class="position-relative overflow-hidden">
                                        <a href=""><img class="img-fluid" src="img/property-3.jpg" alt=""></a>

                                    </div>

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                                <div class="property-item rounded overflow-hidden">
                                    <div class="position-relative overflow-hidden">
                                        <a href=""><img class="img-fluid" src="img/property-4.jpg" alt=""></a>

                                    </div>

                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                                <div class="property-item rounded overflow-hidden">
                                    <div class="position-relative overflow-hidden">
                                        <a href=""><img class="img-fluid" src="img/property-5.jpg" alt=""></a>

                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Footer Start -->
                    <div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
                        <div class="container py-5">
                            <div class="row g-5">
                                <div class="col-lg-3 col-md-6">
                                    <h5 class="text-white mb-4">Get In Touch</h5>
                                    <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA</p>
                                    <p class="mb-2"><i class="fa fa-phone-alt me-3"></i>+012 345 67890</p>
                                    <p class="mb-2"><i class="fa fa-envelope me-3"></i>info@example.com</p>
                                    <div class="d-flex pt-2">
                                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-twitter"></i></a>
                                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-facebook-f"></i></a>
                                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-youtube"></i></a>
                                        <a class="btn btn-outline-light btn-social" href=""><i class="fab fa-linkedin-in"></i></a>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <h5 class="text-white mb-4">Quick Links</h5>
                                    <a class="btn btn-link text-white-50" href="">About Us</a>
                                    <a class="btn btn-link text-white-50" href="">Contact Us</a>
                                    <a class="btn btn-link text-white-50" href="">Our Services</a>
                                    <a class="btn btn-link text-white-50" href="">Privacy Policy</a>
                                    <a class="btn btn-link text-white-50" href="">Terms & Condition</a>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <h5 class="text-white mb-4">Photo Gallery</h5>
                                    <div class="row g-2 pt-2">
                                        <div class="col-4">
                                            <img class="img-fluid rounded bg-light p-1" src="img/property-1.jpg" alt="">
                                        </div>
                                        <div class="col-4">
                                            <img class="img-fluid rounded bg-light p-1" src="img/property-2.jpg" alt="">
                                        </div>
                                        <div class="col-4">
                                            <img class="img-fluid rounded bg-light p-1" src="img/property-3.jpg" alt="">
                                        </div>
                                        <div class="col-4">
                                            <img class="img-fluid rounded bg-light p-1" src="img/property-4.jpg" alt="">
                                        </div>
                                        <div class="col-4">
                                            <img class="img-fluid rounded bg-light p-1" src="img/property-5.jpg" alt="">
                                        </div>
                                        <div class="col-4">
                                            <img class="img-fluid rounded bg-light p-1" src="img/property-6.jpg" alt="">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-6">
                                    <h5 class="text-white mb-4">Newsletter</h5>
                                    <p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
                                    <div class="position-relative mx-auto" style="max-width: 400px;">
                                        <input class="form-control bg-transparent w-100 py-3 ps-4 pe-5" type="text" placeholder="Your email">
                                        <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="container">
                            <div class="copyright">
                                <div class="row">
                                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                                        &copy; <a class="border-bottom" href="#">Your Site Name</a>, All Right Reserved. 

                                        <!--/*** This template is free as long as you keep the footer author?s credit link/attribution link/backlink. If you'd like to use the template without the footer author?s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                                        Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a>
                                    </div>
                                    <div class="col-md-6 text-center text-md-end">
                                        <div class="footer-menu">
                                            <a href="">Home</a>
                                            <a href="">Cookies</a>
                                            <a href="">Help</a>
                                            <a href="">FQAs</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Footer End -->


                    <!-- Back to Top -->
                    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>

                    <!-- Modal End-->


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

