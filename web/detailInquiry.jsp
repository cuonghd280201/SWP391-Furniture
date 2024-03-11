<%-- 
    Document   : detailInquiry
    Created on : Mar 4, 2024, 4:48:49 PM
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
                padding: 50px;
                border: 1px solid #ccc;
                z-index: 1000;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                width: 70%;
                height: 70%;
                max-width: 2000px; /* Thay đổi giá trị này nếu bạn muốn giới hạn chiều rộng tối đa */
                max-height: 3000px; /* Thay đổi giá trị này nếu bạn muốn giới hạn chiều cao tối đa */
            }

            .popup-content {
                background: #fff;
                padding: 20px;
                border-radius: 10px;
                z-index: 1000; /* Ensure a higher z-index value */
            }
        </style>
    </head>
    <c:import url="LoadHomePageController"></c:import>

        <body>
            
            <!-- Navbar Start -->
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
                                <a href="displayInquiryCustomerController" class="dropdown-item">Project List</a>
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
            <c:set var="inquiryDTO" value="${requestScope.DETAIL_INQUIRY}" />
            <c:set var="c" value="${inquiryDTO.construction}"/>
            <c:set var="s" value="${inquiryDTO.scale}"/>
            <c:set var="p" value="${inquiryDTO.projectType}"/>
            <c:set var="r" value="${inquiryDTO.priceRange}"/>

            <div class="container-xxl py-5">
                <div class="container">
                    <div class="bg-light rounded p-3">
                        <div class="bg-white rounded p-4" style="border: 1px dashed rgba(0, 185, 142, .3)">
                            <div class="row g-5 align-items-center">
                                <div class="col-lg-6 wow fadeIn" data-wow-delay="0.1s">
                                    <img class="img-fluid rounded w-100" src="img/inquiry.jpg" alt="">
                                </div>
                                <div class="col-lg-6 wow fadeIn" data-wow-delay="0.5s">
                                    <div class="mb-4">
                                        <h1 class="mb-3">${inquiryDTO.inquiryTittle}</h1>
                                        <p> <c:choose>
                                                <c:when test="${inquiryDTO.statusInquiry == 1}">
                                                    <!-- Display Waiting status -->
                                                    <span class="badge ms-1 bg-info">
                                                        <i class="mdi align-middle"></i> Waiting
                                                    </span>
                                                </c:when>
                                                <c:when test="${inquiryDTO.statusInquiry == 2}">
                                                    <!-- Display Approved status -->
                                                    <span class="badge ms-1 bg-success">
                                                        <i class="mdi align-middle"></i> Approved
                                                    </span>
                                                </c:when>
                                                <c:when test="${inquiryDTO.statusInquiry == 3}">
                                                    <!-- Display Rejected status -->
                                                    <span class="badge ms-1 bg-danger">
                                                        <i class="mdi align-middle"></i> Rejected
                                                    </span>
                                                </c:when>

                                                <c:otherwise>
                                                    <a href="#" id="getStartedBtn" class="btn btn-primary py-3 px-5 me-3 animated fadeIn">Edit</a>
                                                    <!-- Display Save Draft status -->
                                                    <span class="badge ms-1 bg-dark">
                                                        <i class="mdi align-middle"></i> Save Draft
                                                    </span>
                                                </c:otherwise>
                                            </c:choose>
                                        </p>
                                        <p>Contruction Name: ${c.constructionName}</p>
                                        <p>Scale Name: ${s.scaleName}</p>
                                        <p>Price Range: ${r.priceRangeName}</p>
                                        <p>Project Type Name: ${p.projectTypeName}</p>
                                        <p>${inquiryDTO.description}</p>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="popup" class="popup">
                <div class="popup-content">
                    <!-- Your popup content goes here -->
                    <div class="container-fluid bg-primary mb-5 wow fadeIn" data-wow-delay="0.1s" style="padding: 30px;">
                        <div class="container">
                            <form id="inquiryForm" method="post">
                                <div class="row g-2">
                                    <div class="col-md-13">
                                        <div class="row g-10">
                                            <div class="col-md-12">
                                                <label for="txtInquiryTittle">Inquiry Title <font color="red">*</font></label>
                                                <input type="text" placeholder="Inquiry Title" class="form-control" name="txtInquiryTittle" id="txtInquiryTittle" value="${inquiryDTO.inquiryTittle}">
                                                <div id="inquiryTitleError" class="error-message">Please enter an inquiry title.</div>
                                            </div>
                                            <c:set var="constructionList" value="${requestScope.constructionList}"></c:set>
                                                <div class="col-md-6">
                                                    <label for="txtConstructionID"><strong>Construction</strong> <font color="red">*</font></label>
                                                    <select class="form-control border-0 py-3" name="txtConstructionID" id="txtConstructionID">
                                                        <option value="" disabled="disabled" selected>Choose Project</option>
                                                    <c:if test="${not empty constructionList}">
                                                        <c:forEach var="construction" items="${constructionList}">
                                                            <option value="${construction.constructionID}"
                                                                    <c:if test="${construction.constructionID == c.constructionID}">selected</c:if>
                                                                    >${construction.constructionName}</option>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                                <div id="constructionIDError" class="error-message">Please select a construction.</div>
                                            </div>
                                            <!-- Add similar blocks for other fields -->

                                            <div class="col-md-6">
                                                <label for="txtScaleID"><strong>Scale</strong>  <font color="red">*</font></label>
                                                <select class="form-control border-0 py-3" name="txtScaleID" id="txtScaleID">
                                                    <option value="" disabled="disabled" selected>Choose Scale</option>
                                                    <c:set var="scaleList" value="${requestScope.scaleList}"></c:set>
                                                    <c:forEach var="scale" items="${scaleList}">

                                                        <option value="${scale.scaleID}"
                                                                <c:if test="${scale.scaleID == s.scaleID}">selected</c:if>
                                                                >${scale.scaleName}</option>
                                                    </c:forEach>
                                                </select>
                                                <div id="scaleIDError" class="error-message">Please select a scale.</div>
                                            </div>
                                            <div class="col-md-6">
                                                <label for="txtProjectTypeID"><strong>Project Type</strong> <font color="red">*</font></label>
                                                <select class="form-control border-0 py-3" name="txtProjectTypeID" id="txtProjectTypeID">
                                                    <option value="" disabled="disabled" selected>Choose Project Type</option>
                                                    <c:set var="projectTypeList" value="${requestScope.projectTypeList}"></c:set>
                                                    <c:if test="${not empty projectTypeList}">
                                                        <c:forEach var="projectType" items="${projectTypeList}">
                                                            <option value="${projectType.projectTypeID}"
                                                                    <c:if test="${projectType.projectTypeID == p.projectTypeID}">selected</c:if>
                                                                    >${projectType.projectTypeName}</option>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                                <div id="projectTypeIDError" class="error-message">Please select a project type.</div>
                                            </div>
                                            <div class="col-md-6">
                                                <label for="txtPriceRangeID"><strong>Price Range</strong>  <font color="red">*</font></label>
                                                <select class="form-control border-0 py-3" name="txtPriceRangeID" id="txtPriceRangeID">
                                                    <option value="" disabled="disabled" selected>Choose Price Range</option>
                                                    <c:set var="priceRangeList" value="${requestScope.priceList}"></c:set>
                                                    <c:forEach var="price" items="${priceRangeList}">

                                                        <option value="${price.priceRangeID}"
                                                                <c:if test="${price.priceRangeID == r.priceRangeID}">selected</c:if>
                                                                >${price.priceRangeName}</option>
                                                    </c:forEach>
                                                </select>
                                                <div id="priceRangeIDError" class="error-message">Please select a price range.</div>
                                            </div>
                                            <div class="col-md-12">
                                                <label for="txtDescription"><strong>Description</strong> </label>
                                                <textarea placeholder="Short description about your inquiry..."
                                                          class="textarea form-control" name="txtDescription" id="form-message" value="${inquiryDTO.description}"
                                                          rows="3" cols="20">${param.txtDescription}</textarea>
                                                <div id="descriptionError" class="error-message">Please enter a description.</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row g-2">
                                        <div class="col-md-4">
                                            <button class="btn btn-dark border-0 w-100 py-3" type="submit" formaction="createInquiryController" onclick="return checkNullFieldsSend()">Send Quote</button>
                                        </div>
                                        <div class="col-md-4">
                                            <button class="btn btn-dark border-0 w-100 py-3" type="submit" formaction="saveDraftInquiryController" onclick="return checkNullFieldsSave()">Save Draft</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <span class="close-btn" onclick="closePopup()">X</span>
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
            <script>
                document.getElementById('getStartedBtn').addEventListener('click', function () {
                    document.getElementById('popup').style.display = 'flex';
                });
                function closePopup() {
                    document.getElementById('popup').style.display = 'none';
                }
            </script>

            <script>

                function checkNullFieldsSave() {
                    var inquiryTitle = document.getElementById("txtInquiryTittle").value;
                    if (inquiryTitle === "") {
                        document.getElementById("inquiryTitleError").style.display = "block";
                        return false;
                    } else {
                        document.getElementById("inquiryTitleError").style.display = "none";
                    }
                }
            </script>

            <script>
                function checkNullFieldsSend() {
                    var inquiryTitle = document.getElementById("txtInquiryTittle").value;
                    var constructionID = document.getElementById("txtConstructionID").value;
                    var description = document.getElementById("form-message").value;
                    var scaleID = document.getElementById("txtScaleID").value;
                    var projectTypeID = document.getElementById("txtProjectTypeID").value;
                    var priceRangeID = document.getElementById("txtPriceRangeID").value;
                    if (inquiryTitle === "") {
                        document.getElementById("inquiryTitleError").style.display = "block";
                        return false;
                    } else {
                        document.getElementById("inquiryTitleError").style.display = "none";
                    }

                    if (constructionID === "") {
                        document.getElementById("constructionIDError").style.display = "block";
                        return false;
                    } else {
                        document.getElementById("constructionIDError").style.display = "none";
                    }

                    // Add similar checks for other fields

                    if (description.length > 2000) {
                        document.getElementById("descriptionError").innerHTML = "Description should not exceed 2000 characters.";
                        document.getElementById("descriptionError").style.display = "block";
                        return false;
                    } else {
                        document.getElementById("descriptionError").style.display = "none";
                    }

                    if (scaleID === "") {
                        document.getElementById("scaleIDError").style.display = "block";
                        return false;
                    } else {
                        document.getElementById("scaleIDError").style.display = "none";
                    }

                    if (projectTypeID === "") {
                        document.getElementById("projectTypeIDError").style.display = "block";
                        return false;
                    } else {
                        document.getElementById("projectTypeIDError").style.display = "none";
                    }

                    if (priceRangeID === "") {
                        document.getElementById("priceRangeIDError").style.display = "block";
                        return false;
                    } else {
                        document.getElementById("priceRangeIDError").style.display = "none";
                    }

                    return true;
                }
            </script>

            <style>
                .error-message {
                    display: none;
                    color: red;
                    margin-top: 5px;
                }
            </style>


    </body>


</html>


