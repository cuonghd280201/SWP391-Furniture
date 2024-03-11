
<%@page import="inquiry.InquiryErrorDTO"%>
<%@page import="inquiry.Construction"%>
<%@page import="java.util.List"%>
<%@page import="users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Furniture - Main Page</title>
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
s
        <body>
            <div class="container-xxl bg-white p-0">
                <!-- Spinner Start -->
                <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                    <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                </div>
                <!-- Spinner End -->

                <!-- Nabar Start -->
            <%@include file="header.jsp" %>

            <!-- Navbar End -->


            <!-- Header Start -->
            <div class="container-fluid header bg-white p-0">
                <div class="row g-0 align-items-center flex-column-reverse flex-md-row">
                    <div class="col-md-6 p-5 mt-lg-10">
                        <h1 class="display-5 animated fadeIn mb-4">Find A <span class="text-primary">Perfect Furniture</span> To Live With Your Family</h1>
                        <p class="animated fadeIn mb-4 pb-2">Furniture companies often provide services such as design consulting, material selection and supply, custom furniture production, installation and finishing of interior spaces...</p>
                        <a href="#" id="getStartedBtn" class="btn btn-primary py-3 px-5 me-3 animated fadeIn">Get Started</a>
                    </div>
                    <div class="col-md-6 animated fadeIn">
                        <div class="owl-carousel header-carousel">
                            <div class="owl-carousel-item">
                                <img class="img-fluid" src="img/home1.jpg" alt="">
                            </div>
                            <div class="owl-carousel-item">
                                <img class="img-fluid" src="img/home2.jpg" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="popup" class="popup">
                <div class="popup-content">
                    <!-- Your popup content goes here -->
                    <div class="container-fluid bg-primary mb-5 wow fadeIn" data-wow-delay="0.1s" style="padding: 50px;">
                        <div class="container">
                            <form id="inquiryForm" method="post">
                                <div class="row g-2">
                                    <div class="col-md-13">
                                        <div class="row g-10">
                                            <div class="col-md-12">
                                                <label for="txtInquiryTittle">Inquiry Title <font color="red">*</font></label>
                                                <input type="text" placeholder="Inquiry Title" class="form-control" name="txtInquiryTittle" id="txtInquiryTittle">
                                                <div id="inquiryTitleError" class="error-message">Please enter an inquiry title.</div>
                                            </div>
                                            <c:set var="constructionList" value="${requestScope.constructionList}"></c:set>
                                                <div class="col-md-6">
                                                    <label for="txtConstructionID"><strong>Construction</strong> <font color="red">*</font></label>
                                                    <select class="form-control border-0 py-3" name="txtConstructionID" id="txtConstructionID">
                                                        <option value="" disabled="disabled" selected>Choose Project</option>
                                                    <c:if test="${not empty constructionList}">
                                                        <c:forEach var="construction" items="${constructionList}">
                                                            <c:if test="${not empty construction.constructionID}">
                                                                <option value="${construction.constructionID}">${construction.constructionName}</option>
                                                            </c:if>
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
                                                        <option value="${scale.scaleID}">${scale.scaleName}</option>
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
                                                            <option value="${projectType.projectTypeID}">${projectType.projectTypeName}</option>
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
                                                        <option value="${price.priceRangeID}">${price.priceRangeName}</option>
                                                    </c:forEach>
                                                </select>
                                                <div id="priceRangeIDError" class="error-message">Please select a price range.</div>
                                            </div>
                                            <div class="col-md-12">
                                                <label for="txtDescription"><strong>Description</strong> </label>
                                                <textarea placeholder="Short description about your inquiry..."
                                                          class="textarea form-control" name="txtDescription" id="form-message"
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

            <!-- Header End -->


            <!-- Search Start -->
            <div class="container-fluid bg-primary mb-5 wow fadeIn" data-wow-delay="0.1s" style="padding: 35px;">
                <div class="container">
                    <div class="row g-2">
                        <div class="col-md-10">
                            <div class="row g-2">
                                <div class="col-md-4">
                                    <input type="text" class="form-control border-0 py-3" placeholder="Search Keyword">
                                </div>
                                <div class="col-md-4">
                                    <select class="form-select border-0 py-3">
                                        <option selected>Property Type</option>
                                        <option value="1">Property Type 1</option>
                                        <option value="2">Property Type 2</option>
                                        <option value="3">Property Type 3</option>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <select class="form-select border-0 py-3">
                                        <option selected>Location</option>
                                        <option value="1">Location 1</option>
                                        <option value="2">Location 2</option>
                                        <option value="3">Location 3</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <button class="btn btn-dark border-0 w-100 py-3">Create</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Search End -->


            <!-- Category Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="text-center mx-auto mb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 600px;">
                        <h1 class="mb-3">Project Types</h1>
                        <p>Eirmod sed ipsum dolor sit rebum labore magna erat. Tempor ut dolore lorem kasd vero ipsum sit eirmod sit. Ipsum diam justo sed rebum vero dolor duo.</p>
                    </div>
                    <div class="row g-4">
                        <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <a class="cat-item d-block bg-light text-center rounded p-3" href="">
                                <div class="rounded p-4">
                                    <div class="icon mb-3">
                                        <img class="img-fluid" src="img/icon-apartment.png" alt="Icon">
                                    </div>
                                    <h6>Apartment</h6>
                                    <span>123 Properties</span>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.3s">
                            <a class="cat-item d-block bg-light text-center rounded p-3" href="">
                                <div class="rounded p-4">
                                    <div class="icon mb-3">
                                        <img class="img-fluid" src="img/icon-villa.png" alt="Icon">
                                    </div>
                                    <h6>Villa</h6>
                                    <span>123 Properties</span>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.5s">
                            <a class="cat-item d-block bg-light text-center rounded p-3" href="">
                                <div class="rounded p-4">
                                    <div class="icon mb-3">
                                        <img class="img-fluid" src="img/icon-house.png" alt="Icon">
                                    </div>
                                    <h6>Home</h6>
                                    <span>123 Properties</span>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.7s">
                            <a class="cat-item d-block bg-light text-center rounded p-3" href="">
                                <div class="rounded p-4">
                                    <div class="icon mb-3">
                                        <img class="img-fluid" src="img/icon-housing.png" alt="Icon">
                                    </div>
                                    <h6>Office</h6>
                                    <span>123 Properties</span>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                            <a class="cat-item d-block bg-light text-center rounded p-3" href="">
                                <div class="rounded p-4">
                                    <div class="icon mb-3">
                                        <img class="img-fluid" src="img/icon-building.png" alt="Icon">
                                    </div>
                                    <h6>Building</h6>
                                    <span>123 Properties</span>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.3s">
                            <a class="cat-item d-block bg-light text-center rounded p-3" href="">
                                <div class="rounded p-4">
                                    <div class="icon mb-3">
                                        <img class="img-fluid" src="img/icon-neighborhood.png" alt="Icon">
                                    </div>
                                    <h6>Townhouse</h6>
                                    <span>123 Properties</span>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.5s">
                            <a class="cat-item d-block bg-light text-center rounded p-3" href="">
                                <div class="rounded p-4">
                                    <div class="icon mb-3">
                                        <img class="img-fluid" src="img/icon-condominium.png" alt="Icon">
                                    </div>
                                    <h6>Shop</h6>
                                    <span>123 Properties</span>
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.7s">
                            <a class="cat-item d-block bg-light text-center rounded p-3" href="">
                                <div class="rounded p-4">
                                    <div class="icon mb-3">
                                        <img class="img-fluid" src="img/icon-luxury.png" alt="Icon">
                                    </div>
                                    <h6>Garage</h6>
                                    <span>123 Properties</span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Category End -->
            <!-- Property List Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="row g-0 gx-5 align-items-end">
                        <div class="col-lg-6">
                            <div class="text-start mx-auto mb-5 wow slideInLeft" data-wow-delay="0.1s">
                                <h1 class="mb-3">Sample projects can be referenced</h1>
                            </div>
                        </div>
                        <div class="col-lg-6 text-start text-lg-end wow slideInRight" data-wow-delay="0.1s">
                            <ul class="nav nav-pills d-inline-flex justify-content-end mb-5">
                                <li class="nav-item me-2">
                                    <a class="btn btn-outline-primary active" data-bs-toggle="pill" href="#tab-1">Modern</a>
                                </li>
                                <li class="nav-item me-2">
                                    <a class="btn btn-outline-primary" data-bs-toggle="pill" href="#tab-2">Classic</a>
                                </li>
                                <li class="nav-item me-0">
                                    <a class="btn btn-outline-primary" data-bs-toggle="pill" href="#tab-3">Basic</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="tab-content">
                        <div id="tab-1" class="tab-pane fade show p-0 active">

                            <div class="row g-4">
                                <c:forEach var="project" items="${sessionScope.listProjects}">
                                    <c:set var="image" value="${project.imageDTO}"/>
                                    <c:url var="single_recipe_url" value="displayDetailProject">
                                        <c:param name="projectID" value="${project.projectID}"/>
                                    </c:url>
                                    <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                                        <div class="property-item rounded overflow-hidden">
                                            <div class="position-relative overflow-hidden">
                                                <figure class="item-figure"><a href="${single_recipe_url}">

                                                        <img src="${image.imageURL}" style="width: 100%; height: 100%; object-fit: cover;"/>
                                                </figure>                                               
                                                <div class="bg-white rounded-top text-primary position-absolute start-0 bottom-0 mx-4 pt-1 px-3">Modern</div>
                                            </div>
                                            <div class="p-4 pb-0">
                                                <h5 class="text-primary mb-3">Price: 
                                                    <c:set var="formattedPrice">
                                                        <fmt:formatNumber type='currency' value='${project.price}' currencySymbol='VND'/>
                                                    </c:set>
                                                    <c:out value="${formattedPrice}" />
                                                </h5>
                                                <a class="d-block h5 mb-2" href="">${project.projectName}</a>
                                                <p><i class="fa fa-clock text-primary me-2"></i><c:out value='${project.createAt}'/></p>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>

                        </div>

                    </div>
                </div>




                <div class="col-12 text-center">
                    <a class="btn btn-primary py-3 px-5" href="">Browse More Property</a>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- Property List End -->


<!-- Call to Action Start -->
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
                            <h1 class="mb-3">Contact With Our Certified Agent</h1>
                            <p>Eirmod sed ipsum dolor sit rebum magna erat. Tempor lorem kasd vero ipsum sit sit diam justo sed vero dolor duo.</p>
                        </div>
                        <a href="" class="btn btn-primary py-3 px-4 me-2"><i class="fa fa-phone-alt me-2"></i>Make A Call</a>
                        <a href="" class="btn btn-dark py-3 px-4"><i class="fa fa-calendar-alt me-2"></i>Get Appoinment</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Call to Action End -->




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
</div>


<!-- Modal Start-->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <div class="title-default-bold mb-none">Login</div>
            </div>
            <div class="modal-body">
                <c:url var="login_url" value="loginPage"></c:url>
                <c:url var="register_url" value="registerPage"></c:url>
                    <form class="login-form" action="login_url" method="post" id="loginform">
                        <!--                                <div class="inline-box mb-5 mt-4">
                                            <a href="${login_url}">Login</a>
                                        <a href="${register_url}">Register</a>
                                    </div>-->
                    <div class="d-flex justify-content-between mb-5">
                        <button type="button" class="btn btn-success" style="font-size: 1.75rem"
                                onclick="dieu_huong_login()">Login</button>
                        <script>
                                    function dieu_huong_login() {
                                    location.assign("${login_url}");
                                    }
                        </script>
                        <button type="button" class="btn btn-danger" style="font-size: 1.75rem"
                                onclick="dieu_huong_Register()">Register</button>
                        <script>
                                    function dieu_huong_Register() {
                                    location.assign("${register_url}");
                                    }
                        </script>
                    </div>
                </form>
                <label>Login connect with your Social Network</label>
                <div class="login-box-social">
                    <ul>
                        <li><a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/BakeryRecipe/login-google&response_type=code&client_id=220347070456-brh7fuqartnn99t6prha0o1kcc6rmajr.apps.googleusercontent.com&approval_prompt=force"
                               class="google"><i class="fab fa-google-plus-g"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
        </form>


    </div>
    <!-- Modal End-->
    <script>
        document.getElementById('getStartedBtn').addEventListener('click', function () {
        document.getElementById('popup').style.display = 'flex';
        });
                function closePopup() {
                document.getElementById('popup').style.display = 'none';
                }
    </script>




    <!-- JavaScript Libraries -->
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

    <script src="js/select2.full.min.js"></script>


    <script>
<!--Chan gui form bang Enter-->
                $("#submitForm").keypress(function (e) {
        if (e.which == 13) {
        return false;
        }
        });    </script>
    <script src="js/submit_recipe.js"></script>
    <script>

                function checkNullFieldsSave(){
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