<%-- 
    Document   : project-detail
    Created on : Mar 1, 2024, 4:00:01 AM
    Author     : cdkhu
--%>

<%@page import="interriorDetails.InteriorDetailsDTO"%>
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
            >


            <!-- Header Start -->
            <div class="container-fluid header bg-white p-0">
                <div class="row g-0 align-items-center flex-column-reverse flex-md-row">
                    <div class="col-md-6 p-5 mt-lg-5">
                        <h1 class="display-5 animated fadeIn mb-4">Project Detail</h1> 
                        <nav aria-label="breadcrumb animated fadeIn">
                            <ol class="breadcrumb text-uppercase">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item"><a href="#">Pages</a></li>
                                <li class="breadcrumb-item text-body active" aria-current="page">Project Detail</li>
                            </ol>
                        </nav>
                    </div>
                    <div class="col-md-6 animated fadeIn">
                        <img class="img-fluid" src="img/header.jpg" alt="">
                    </div>
                </div>
            </div>
            <!-- Header End -->


            <!--             Search Start 
            
                        <form action="MainController" method="POST">
                            <div class="container-fluid bg-primary mb-5 wow fadeIn" data-wow-delay="0.1s" style="padding: 35px;">
                                <div class="container">
                                    <div class="row g-2">
                                        <div class="col-md-10">
                                            <div class="row g-2">
                                                <div class="col-md-4">
            
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
                                            <button type="submit" value="Show" name="btnAction" class="btn btn-dark border-0 w-100 py-3">Search</button>
                                            <input type="submit" value="Show" name="btnAction" class="btn btn-dark border-0 w-100 py-3"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>-->

            <!-- Search End -->


            <!-- Property List Start -->

            <div class="container-xxl py-5">
                <div class="container">
                    <div class="row g-0 gx-5 align-items-end">
                        <div class="col-lg-6">
                            <div class="text-start mx-auto mb-5 wow slideInLeft" data-wow-delay="0.1s">
                                <h1 class="mb-3">Project Details</h1>
                            </div>
                        </div>

                    </div>
                    <div class="tab-content">
                        <div id="tab-1" class="tab-pane fade show p-0 active">
                            <div class="row g-4">
                                <%
                                    double totalMoney = 0;
                                    List<InteriorDetailsDTO> list = (List<InteriorDetailsDTO>) request.getAttribute("INTERIOR_BY_PROJECTID");
                                    if (list != null && !list.isEmpty()) {
                                %>
                                <table class="table">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th scope="col">No</th>
                                            <th scope="col">Interior Name</th>
                                            <th scope="col">Image</th>
                                            <th scope="col">Description</th>
                                            <th scope="col">Create At</th>
                                            <th scope="col">Update At</th>
                                            <th scope="col">Material Name</th>
                                            <th scope="col">Size</th>
                                            <th scope="col">Mass</th>
                                            <th scope="col">Quantity</th>
                                            <th scope="col">Unit Price</th>
                                            <th scope="col">Material Level</th>
                                            <th scope="col">Money</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            int count = 0;
                                            for (InteriorDetailsDTO dto : list) {
                                        %>
                                        <tr>
                                            <td>
                                                <%= ++count%>
                                            </td>
                                            <td>
                                                <%= dto.getInteriorName()%>
                                            </td>
                                            <td>
                                                <img class="media-img-auto" style="width: 150px; height: 150px; margin-right: 10px" src="<%= dto.getImage()%>" class="img-thumbnail">
                                            </td>
                                            <td>
                                                <%= dto.getDescription()%>
                                            </td>
                                            <td>
                                                <%= dto.getCreateAt()%>
                                            </td>
                                            <td>
                                                <%= dto.getUpdateAt()%>
                                            </td>
                                            <td>
                                                <%= dto.getMaterialName()%>
                                            </td>
                                            <td>
                                                <%= dto.getSize()%>
                                            </td>
                                            <td>
                                                <%= dto.getMass()%>
                                            </td>
                                            <td>
                                                <%= dto.getInteriorQuantity()%>
                                            </td>
                                            <td>
                                                <%= dto.getUnitPrice()%>
                                            </td>
                                            <td>
                                                <%= dto.getValueLevel()%>
                                            </td>
                                            <td>
                                                <%
                                                    double money = dto.getInteriorQuantity() * dto.getUnitPrice() * dto.getValueLevel();
                                                    totalMoney += money;
                                                %>
                                                <%= money%>
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                        <tr>
                                            <td colspan="5">
                                                Total: 
                                            </td>
                                            <td colspan="6">
                                                <%= totalMoney%>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                           <!--     <div class="col-12 text-center">
                                  <form action="${initParam['posturl']}" method="get">
                                        <input type="hidden" name="return" value="${initParam['returnurl']}">
                                        <input type="hidden" name="bussiness" value="${initParam['business']}">
                                        <input class="btn btn-primary py-3 px-5" type="submit" value="Payment">
                                       
                                    </form>
                                </div>-->
                                         
                        <div id="paypal-payment-button">
                            <%-- Your PayPal payment button code will go here --%>
                        </div>
                   
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%
            } else {
            %>
            <h1>this project did not have interior yet!</h1>
            <%
                }

            %>
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

                <script src="https://www.paypal.com/sdk/js?client-id=AdOtj2PGjcxwMu9VDhRWGrBGQo5mYpMoYQwzF7JagjzPyXq0Ft6E6TM8TOuiDPgQV7zeh-JFDKTfDXbV&disable-funding=credit,card"></script>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        
         <script>
        paypal.Buttons({
            style : {
                color: 'blue',
                shape: 'pill'
            },
            createOrder: function (data, actions) {
                return actions.order.create({
                    purchase_units : [{
                        amount: {
                            value: '0.1'
                        }
                    }]
                });
            },
            onApprove: function (data, actions) {
                return actions.order.capture().then(function (details) {
                    console.log(details);
                    window.location.replace("http://localhost:8084/FunitureQoute/paymentsuccess.jsp");
                });
            },
            onCancel: function (data) {
                window.location.replace("http://localhost:8084/FunitureQoute/MainController?btnAction=Show");
            }
        }).render('#paypal-payment-button');
    </script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>
</html>
