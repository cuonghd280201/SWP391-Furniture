<%-- 
    Document   : detailInquiryStaff
    Created on : Mar 7, 2024, 1:01:33 AM
    Author     : Admin
--%>

<%-- 
    Document   : listInquiryStaff
    Created on : Mar 7, 2024, 12:23:25 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
            <div class="dashboard-main-wrapper">

            <%@include file="siderBarStaff.jsp" %>

            <div class="dashboard-wrapper">
                <div class="dashboard-ecommerce">
                    <div class="container-fluid dashboard-content ">
                        <!-- ============================================================== -->
                        <!-- pageheader  -->
                        <!-- ============================================================== -->
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
                                    <c:set var="inquiryList" value="${sessionScope.MY_INQUIRY_LIST_STAFF}"></c:set>

                                    <c:set var="inquiryDTO" value="${requestScope.DETAIL_INQUIRY_STAFF}" />

                                    <c:set var="construction" value="${inquiryDTO.construction}"/>
                                    <c:set var="s" value="${inquiryDTO.scale}"/>
                                    <c:set var="p" value="${inquiryDTO.projectType}"/>
                                    <c:set var="r" value="${inquiryDTO.priceRange}"/>

                                    <div class="container-xxl py-5">
                                        <div class="container">
                                            <div class="bg-light rounded p-3">
                                                <div class="bg-white rounded p-4" style="border: 1px dashed rgba(0, 185, 142, .3)">
                                                    <div class="row g-5 align-items-center">
                                                        <div class="col-lg-6 wow fadeIn" data-wow-delay="0.1s">
                                                            <img class="img-fluid rounded w-100" src="img/call-to-action.jpg" alt="">
                                                        </div>
                                                        <div class="col-lg-6 wow fadeIn" data-wow-delay="0.5s">
                                                            <div class="mb-4">
                                                                <h1 class="mb-3">${inquiryDTO.projectID}</h1>
                                                                <p>   
                                                                    <span class="badge ms-1 
                                                                          <c:choose>
                                                                              <c:when test="${inquiryDTO.statusInquiry == 1}">
                                                                                  bg-info
                                                                              </c:when>
                                                                              <c:when test="${inquiryDTO.statusInquiry == 2}">
                                                                                  bg-success
                                                                              </c:when>
                                                                              <c:otherwise>
                                                                                  bg-danger
                                                                              </c:otherwise>
                                                                          </c:choose>">
                                                                        <i class="mdi align-middle"></i>
                                                                        <c:choose>
                                                                            <c:when test="${inquiryDTO.statusInquiry == 1}">
                                                                                Waiting
                                                                            </c:when>
                                                                            <c:when test="${inquiryDTO.statusInquiry == 2}">
                                                                                Approved
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                Rejected
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </span>
                                                                </p>
                                                                <p>Contruction Name: ${construction.constructionName}</p>
                                                                <p>Scale Name: ${s.scaleName}</p>
                                                                <p>Price Range: ${r.priceRangeName}</p>
                                                                <p>Project Type Name: ${p.projectTypeName}</p>
                                                                <p>${inquiryDTO.description}</p>
                                                                <c:url var="approved_inquiry_url" value="approvedInquiryController">
                                                                    <c:param name="inquiryID" value="${param.inquiryID}"/>
                                                                </c:url>
                                                                <button id="approveButton" class="btn btn-primary py-3 px-4 me-2"><i class="fas fa-check-circle me-2"></i>Approved</button>

                                                                <c:url var="reject_inquiry_url" value="rejectInquiryController">
                                                                    <c:param name="inquiryID" value="${param.inquiryID}"/>
                                                                </c:url>
                                                                <button id="rejectButton" class="btn btn-dark py-3 px-4"><i class="fas fa-check-circle me-2"></i>Reject</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- ============================================================== -->
                </div>

                <div id="approvalModal" class="modal">
                    <div class="modal-content">
                        <span class="close" onclick="closeModal()">&times;</span>
                        <p>Do You Want To Aprroved This Inquiry?</p>
                        <div class="button-group">
                            <button class="yes-button" onclick="approve()">Yes</button>
                            <button class="no-button" onclick="closeModal()">No</button>
                        </div>
                    </div>
                </div>

                <div id="rejectModal" class="modal">
                    <div class="modal-content">
                        <span class="close" onclick="closeModal()">&times;</span>
                        <p>Do You Want To Rejected This Inquiry?</p>
                        <div class="button-group">
                            <button class="yes-button" onclick="reject()">Yes</button>
                            <button class="no-button" onclick="closeModal()">No</button>
                        </div>
                    </div>
                </div>

                <style>
                    /* Modal styles */
                    .modal {
                        display: none;
                        position: fixed;
                        z-index: 1;
                        left: 0;
                        top: 0;
                        width: 100%;
                        height: 100%;
                        overflow: auto;
                        background-color: rgba(0,0,0,0.4);
                    }

                    /* Modal content */
                    .modal-content {
                        position: absolute;
                        top: 50%;
                        left: 50%;
                        transform: translate(-50%, -50%);
                        background-color: #fefefe;
                        padding: 20px;
                        border: 1px solid #888;
                        width: 60%;
                        text-align: center;
                    }

                    /* Close button */
                    .close {
                        color: #aaa;
                        float: right;
                        font-size: 28px;
                        font-weight: bold;
                    }

                    .close:hover,
                    .close:focus {
                        color: black;
                        text-decoration: none;
                        cursor: pointer;
                    }

                    /* Button group */
                    .button-group {
                        display: flex;
                        justify-content: center;
                        gap: 10px;
                        margin-top: 20px;
                    }

                    /* Buttons */
                    .button-group button {
                        padding: 10px 20px;
                        border: none;
                        border-radius: 5px;
                        cursor: pointer;
                    }

                    .yes-button {
                        background-color: #28a745;
                        color: #fff;
                    }

                    .yes-button:hover {
                        background-color: #218838;
                    }

                    .no-button {
                        background-color: #dc3545;
                        color: #fff;
                    }

                    .no-button:hover {
                        background-color: #c82333;
                    }
                </style>

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

                <script>
                                // Get the modal
                                var modal = document.getElementById("approvalModal");

                                // Get the button that opens the modal
                                var btn = document.getElementById("approveButton");

                                // When the user clicks on the button, open the modal
                                btn.onclick = function () {
                                    modal.style.display = "block";
                                }

                                // When the user clicks on <span> (x), close the modal
                                span.onclick = function () {
                                    modal.style.display = "none";
                                }

                                // Function to approve the inquiry
                                function approve() {
                                    // Construct the URL
                                    var url = "${approved_inquiry_url}";

                                    // Redirect to the URL
                                    window.location.href = url;

                                    // Close the modal
                                    closeModal();
                                }

                                // Function to close the modal
                                function closeModal() {
                                    modal.style.display = "none";
                                }
                </script>

                 <script>
                                // Get the modal
                                var modal = document.getElementById("rejectModal");

                                // Get the button that opens the modal
                                var btn = document.getElementById("rejectButton");

                                // When the user clicks on the button, open the modal
                                btn.onclick = function () {
                                    modal.style.display = "block";
                                }

                                // When the user clicks on <span> (x), close the modal
                                span.onclick = function () {
                                    modal.style.display = "none";
                                }

                                // Function to approve the inquiry
                                function reject() {
                                    // Construct the URL
                                    var url = "${reject_inquiry_url}";

                                    // Redirect to the URL
                                    window.location.href = url;

                                    // Close the modal
                                    closeModal();
                                }

                                // Function to close the modal
                                function closeModal() {
                                    modal.style.display = "none";
                                }
                </script>


                </body>

                </html>



