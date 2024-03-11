<%-- 
    Document   : saveProject
    Created on : Mar 8, 2024, 3:50:30 AM
    Author     : cdkhu
--%>

<%@page import="project2.ProjectErrorDTO"%>
<%@page import="projectType.ProjectTypeDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    </head>
    <body>
        <div class="container-xxl bg-white p-0">
            <!-- Spinner Start -->
            <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                    <span class="sr-only">Loading...</span>
                </div>
            </div>
            <!-- Spinner End -->


            <!-- Navbar Start -->
            <%@include file="header.jsp" %>

            <!-- Navbar End -->


            <!-- Header Start -->
            <div class="container-fluid header bg-white p-0">
                <div class="row g-0 align-items-center flex-column-reverse flex-md-row">
                    <div class="col-md-6 p-5 mt-lg-5">
                        <h1 class="display-5 animated fadeIn mb-4">Create Project</h1> 
                        <nav aria-label="breadcrumb animated fadeIn">
                            <ol class="breadcrumb text-uppercase">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Pages</a></li>
                                <li class="breadcrumb-item text-body active" aria-current="page">Create Project</li>
                            </ol>
                        </nav>
                    </div>
                    <div class="col-md-6 animated fadeIn">
                        <img class="img-fluid" src="img/header.jpg" alt="">
                    </div>
                </div>
            </div>
            <!-- Header End -->





            <!-- Property List Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <form action="MainController" method="POST">
                        Project Name:
                        <input type="text" name="projectName" value=""/><br>
                        <%
                            ProjectErrorDTO errors = (ProjectErrorDTO) request.getAttribute("SAVE_PROJECT_ERROR");
                            if (errors != null) {
                                if (errors.getProjectNameErr() != "") {
                        %>
                        <p class="text-center text-danger"><%= errors.getProjectNameErr()%></p>
                        <%
                                }
                            }
                        %>
                        Project Scale:
                        <input type="text" name="scale" value=""/><br>
                        <%
                            if (errors != null) {
                                if (errors.getScaleErr() != "") {
                        %>
                        <p class="text-center text-danger"><%= errors.getScaleErr()%></p>
                        <%
                                }
                            }
                        %>
                        Project Description
                        <input type="text" name="description" value=""/><br>
                        Project URL Image
                        <input type="text" name="image" value=""/><br>
                        Project Type:
                        <select name="projectTypeID">
                            <%
                                List<ProjectTypeDTO> listProjectType = (List<ProjectTypeDTO>) request.getAttribute("LIST_PROJECT_TYPE");
                                for (ProjectTypeDTO dto : listProjectType) {
                            %>
                            <option value="<%= dto.getProjectTypeID()%>">
                                <%= dto.getProjectTypeName()%>
                            </option>
                            <%
                                }
                            %>

                        </select><br>


                        <input type="submit" value="Save Project" name="btnAction" />
                        <input type="reset" value="Reset" />
                    </form>
                    <%
                        if (errors != null) {
                            if (errors.getProjectNameExisted() != "") {
                    %>
                    <p class="text-center text-danger"><%= errors.getProjectNameExisted()%></p>
                    <%
                        }
                        if (errors.getSessionRunOut() != "") {
                    %>
                    <p class="text-center text-danger"><%= errors.getSessionRunOut()%></p>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
            <!-- Property List End -->


            <!-- Call to Action Start -->
            <!--            <div class="container-xxl py-5">
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
                        </div>-->
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
    </body>
</html>
