<%-- 
    Document   : listInquiryPage
    Created on : Mar 2, 2024, 10:15:53 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css" integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc=" crossorigin="anonymous" />


        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>

    </head>
    <c:import url="adminDashboardController"></c:import>


    <body>
        <c:if test="${sessionScope.SAVE_NOTI != null}">
            <%-- Script for displaying SweetAlert2 notification --%>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
            <script>
                // Function to display SweetAlert2 notification
                function showNotification(message, type) {
                    Swal.fire({
                        icon: type,
                        title: message,
                        showConfirmButton: false,
                        timer: 3000
                    });
                }

                // Check if notification attribute is set and call the function
                var saveNoti = "${sessionScope.SAVE_NOTI}";
                if (saveNoti && saveNoti === "success") {
                    showNotification("Inquiry Created Successfully", "success");
                    // Remove the success notification attribute from the session
                ${sessionScope.remove("SAVE_NOTI")};
                }
            </script>
        </c:if>



        <c:if test="${sessionScope.LOGIN_USER!=null  || sessionScope.LOGIN_USER.isActived==false }">

            <!-- Navbar Start -->
            <%@include file="header.jsp" %>

            <!-- Header End -->
            <!-- Search Start -->
        </div
        <!-- Search End -->
        <section class="section">
            <div class="container">
                <div class="justify-content-center row">
                    <div class="col-lg-12">
                        <div class="container-fluid bg-primary mb-5 wow fadeIn" data-wow-delay="0.1s" style="padding: 35px;">
                            <form action="#" class="">
                                <div class="g-2 row">
                                    <div class="col-lg-9">
                                        <div class="filler-job-form">
                                            <i class="uil uil-briefcase-alt"></i><input id="exampleFormControlInput1" placeholder="Search Inquiry... " type="search" class="form-control filler-job-input-box form-control" />
                                        </div>
                                    </div>
                                    
                                    <div class="col-lg-3">
                                        <div>
                                            <a class="btn btn-success ms-2" href="#"><i class="uil uil-cog"></i> Search</a>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="align-items-center row">
                            <div class="col-lg-8">
                                <div class="mb-3 mb-lg-0"><h6 class="fs-16 mb-0">Showing 1 – 5 of ${sessionScope.numberOfInquirys} results</h6></div>
                            </div>
                            
                        </div>
                        <c:set var="inquiryList" value="${requestScope.MY_INQUIRY_LIST}"></c:set>
                        <c:if test="${empty inquiryList}">
                            </br><h2>You have not saved any inquiry yet!</h2>
                        </c:if>
                        <c:if test="${not empty inquiryList}">
                        </c:if>


                        <div class="candidate-list">
                            <c:forEach var="inquiry" items="${inquiryList}">
                                <c:url var="single_recipe_url" value="displayDetailInquiry">
                                    <c:param name="inquiryID" value="${inquiry.inquiryID}"/>
                                </c:url>
                                <c:set var="construction" value="${inquiry.construction}"/>
                                <c:set var="s" value="${inquiry.scale}"/>
                                <c:set var="p" value="${inquiry.projectType}"/>
                                <c:set var="r" value="${inquiry.priceRange}"/>

                                <div class="candidate-list-box card mt-4">

                                    <div class="p-4 card-body">

                                        <div class="align-items-center row">
                                            <div class="col-auto">
                                                <div class="candidate-list-images">
                                                    <a href="#"><img src="img/inquiry.jpg" alt="" class="avatar-md img-thumbnail rounded-circle" /></a>
                                                </div>
                                            </div>
                                            <div class="col-lg-5">
                                                <div class="candidate-list-content mt-3 mt-lg-0">

                                                    <h5 class="fs-19 mb-0">
                                                        <a class="primary-link" href="${single_recipe_url}">${inquiry.inquiryTittle}</a>
                                                    </h5>

                                                    <p class="text-muted mb-2">${inquiry.description}</p>
                                                    <ul class="list-inline mb-0 text-muted">
                                                        <li class="list-inline-item"><i class="fa fa-clock text-primary me-2"></i> ${inquiry.createAt}</li>
                                                        <li class="list-inline-item"><i class="mdi mdi-wallet"></i> ${r.priceRangeName}</li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="mt-2 mt-lg-0 d-flex flex-wrap align-items-start gap-1">
                                                    <span class="badge bg-soft-secondary fs-14 mt-1">${construction.constructionName}</span><span class="badge bg-soft-secondary fs-14 mt-1">${s.scaleName}</span><span class="badge bg-soft-secondary fs-14 mt-1">${p.projectTypeName}</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="favorite-icon">
                                            <c:choose>
                                                <c:when test="${inquiry.statusInquiry == 1}">
                                                    <!-- Display Waiting status -->
                                                    <span class="badge ms-1 bg-info">
                                                        <i class="mdi align-middle"></i> Waiting
                                                    </span>
                                                </c:when>
                                                <c:when test="${inquiry.statusInquiry == 2}">
                                                    <!-- Display Approved status -->
                                                    <span class="badge ms-1 bg-success">
                                                        <i class="mdi align-middle"></i> Approved
                                                    </span>
                                                </c:when>
                                                <c:when test="${inquiry.statusInquiry == 3}">
                                                    <!-- Display Rejected status -->
                                                    <span class="badge ms-1 bg-danger">
                                                        <i class="mdi align-middle"></i> Rejected
                                                    </span>
                                                </c:when>

                                                <c:otherwise>
                                                    <!-- Display Save Draft status -->
                                                    <span class="badge ms-1 bg-dark">
                                                        <i class="mdi align-middle"></i> Save Draft
                                                    </span>
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                    </div>

                                </div>

                            </c:forEach>


                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="mt-4 pt-2 col-lg-12">
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <c:set var="currentPage" value="${requestScope.CURRENT_PAGE}"></c:set>
                        <c:set var="pageSize" value="${requestScope.PAGE_SIZE}"></c:set>
                        <c:set var="totalInquiries" value="${fn:length(inquiryList)}"></c:set>
                        <c:set var="totalPages" value="${(totalInquiries + pageSize - 1) / pageSize}"></c:set>
                        <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                            <a class="page-link" href="?page=${currentPage - 1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:forEach var="page" begin="1" end="${totalPages}">
                            <li class="page-item ${currentPage == page ? 'active' : ''}">
                                <a class="page-link" href="?page=${page}">${page}</a>
                            </li>
                        </c:forEach>
                        <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                            <a class="page-link" href="?page=${currentPage + 1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</section>
<div class="container-xxl bg-white p-0">
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->







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

                        <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
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
</div>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>
</c:if>
</body>

</html>