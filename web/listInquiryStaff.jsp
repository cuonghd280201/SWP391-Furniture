<%-- 
    Document   : listInquiryStaff
    Created on : Mar 7, 2024, 12:23:25 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
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
    </head>
    <c:import url="LoadHomeStaffController"></c:import>

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
                    showNotification("Inquiry approved Successfully", "success");
                    // Remove the success notification attribute from the session
                ${sessionScope.remove("SAVE_NOTI")};
                } else if (saveNoti && saveNoti === "fail"){
                    showNotification("Inquiry rejected Successfully", "fail");
                }
            </script>
        </c:if>


        <div class="dashboard-main-wrapper">

            <%@include file="siderBarStaff.jsp" %>

            <div class="dashboard-wrapper">
                <div class="dashboard-ecommerce">
                    <div class="container-fluid dashboard-content ">
                        <div class="row">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <div class="page-header">

                                    <h2 class="pageheader-title">Manager</h2>
                                    <div class="page-breadcrumb">
                                        <nav aria-label="breadcrumb">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Manager Inquiry Info</a></li>
                                            </ol>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ============================================================== -->
                        <!-- end pageheader  -->
                        <!-- ============================================================== -->
                        <div class="row">
                            <!-- ============================================================== -->

                            <!-- ============================================================== -->

                            <!-- recent orders  -->
                            <!-- ============================================================== -->

                            <div class="col-xl-12 col-lg-12 col-md-6 col-sm-12 col-12">
                                <div class="card">
                                    <section class="section">
                                        <div class="container">
                                            <div class="justify-content-center row">
                                                <div class="col-lg-12">
                                                    <div class="container-fluid bg-primary mb-5 wow fadeIn" data-wow-delay="0.1s" style="padding: 35px;">
                                                        <form action="#" class="">
                                                            <div class="g-2 row">
                                                                <div class="col-lg-4">
                                                                    <div class="filler-job-form">
                                                                        <i class="uil uil-briefcase-alt"></i><input id="exampleFormControlInput1" placeholder="Search here... " type="search" class="form-control filler-job-input-box form-control" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-lg-4">
                                                                    <div class="filler-job-form">
                                                                        <i class="uil uil-location-point"></i>
                                                                        <select class="form-select selectForm__inner" data-trigger="true" name="choices-single-location" id="choices-single-location" aria-label="Default select example">
                                                                            <option value="AF">Watting</option>
                                                                            <option value="AX">Approved</option>
                                                                            <option value="AL">Reject</option>

                                                                        </select>
                                                                    </div>
                                                                </div>

                                                                <div class="col-lg-4">
                                                                    <div>
                                                                        <a class="btn btn-success" href="#"><i class="uil uil-filter"></i> Filter</a><a class="btn btn-success ms-2" href="#"><i class="uil uil-cog"></i> Advance</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <c:set var="inquiryList" value="${sessionScope.MY_INQUIRY_LIST_STAFF}"></c:set>
                                                    <c:if test="${empty inquiryList}">
                                                        </br><h2>You have not saved any inquiry yet!</h2>
                                                    </c:if>
                                                    <c:if test="${not empty inquiryList}">
                                                    </c:if>


                                                    <div class="candidate-list">
                                                        <c:forEach var="inquiry" items="${inquiryList}">
                                                            <c:url var="single_recipe_url" value="displayDetailInquiryStaff">
                                                                <c:param name="inquiryID" value="${inquiry.inquiryID}"/>
                                                            </c:url>
                                                            <c:set var="construction" value="${inquiry.construction}"/>
                                                            <c:set var="s" value="${inquiry.scale}"/>
                                                            <c:set var="p" value="${inquiry.projectType}"/>
                                                            <c:set var="r" value="${inquiry.priceRange}"/>
                                                            <c:set var="u" value="${inquiry.userDTO}"/>



                                                            <div class="candidate-list-box card mt-4">

                                                                <div class="p-4 card-body">

                                                                    <div class="align-items-center row">
                                                                        <div class="col-auto">
                                                                            <div class="candidate-list-images">
                                                                                <a href="#"><img style="border-radius: 50%; width: 70px; height: 70px; object-fit: cover;" src="${u.image}" alt="">
                                                                                </a>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-lg-5">
                                                                            <div class="candidate-list-content mt-3 mt-lg-0">

                                                                                <h5 class="fs-19 mb-0">
                                                                                    <a class="primary-link" href="${single_recipe_url}">${inquiry.inquiryTittle}</a>
                                                                                </h5>

                                                                                <p class="text-muted mb-2">Sent By: ${u.email}</p>
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
                                <div class="mt-4 pt-2">
                                    <nav aria-label="Page navigation example">
                                        <ul class="pagination justify-content-center">
                                            <c:set var="currentPage" value="${sessionScope.CURRENT_PAGE}"></c:set>
                                            <c:set var="pageSize" value="${sessionScope.PAGE_SIZE}"></c:set>
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
                                </section>


                            </div>
                        </div>
                    </div>


                </div>

















                <!-- ============================================================== -->
            </div>
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

            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
            <script src="lib/wow/wow.min.js"></script>
            <script src="lib/easing/easing.min.js"></script>
            <script src="lib/waypoints/waypoints.min.js"></script>
            <script src="lib/owlcarousel/owl.carousel.min.js"></script>

            <!-- Template Javascript -->
            <script src="js/main.js"></script>




    </body>

</html>


