<%-- 
    Document   : saveProject
    Created on : Mar 8, 2024, 3:50:30 AM
    Author     : cdkhu
--%>

<%@page import="projectType.ProjectTypeDTO"%>
<%@page import="project2.ProjectErrorDTO"%>
<%@page import="material.MaterialErrorDTO"%>
<%@page import="material.MaterialDTO"%>
<%@page import="java.util.List"%>
<%@page import="interior.InteriorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->

        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/vendor/fonts/circular-std/style.css"" rel="stylesheet" type="text/css"/>
        <link href="assets/libs/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css" rel="stylesheet" type="text/css"/>
        <link href="assets/vendor/charts/chartist-bundle/chartist.css" rel="stylesheet" type="text/css"/>
        <link href="assets/vendor/charts/morris-bundle/morris.css" rel="stylesheet" type="text/css"/>
        <link href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/vendor/charts/c3charts/c3.css" rel="stylesheet" type="text/css"/>
        <link href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css" rel="stylesheet" type="text/css"/>

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

            .switch {
                position: relative;
                display: inline-block;
                width: 60px;
                height: 34px;
            }

            /* Hide default HTML checkbox */
            .switch input {
                opacity: 0;
                width: 0;
                height: 0;
            }

            /* The slider */
            .slider {
                position: absolute;
                cursor: pointer;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                background-color: #757575; /* Gray color when off */
                -webkit-transition: .4s;
                transition: .4s;
            }

            .slider:before {
                position: absolute;
                content: "";
                height: 26px;
                width: 26px;
                left: 4px;
                bottom: 4px;
                background-color: white;
                -webkit-transition: .4s;
                transition: .4s;
            }

            input:checked + .slider {
                background-color: #0e0c28; /* Darker blue color when on */
            }

            input:focus + .slider {
                box-shadow: 0 0 1px #2196F3; /* Box shadow when focused */
            }

            input:checked + .slider:before {
                -webkit-transform: translateX(26px);
                -ms-transform: translateX(26px);
                transform: translateX(26px);
            }

            /* Rounded sliders */
            .slider.round {
                border-radius: 34px;
            }

            .slider.round:before {
                border-radius: 50%;
            }
        </style>




    </head>

    <c:import url="adminListConstruction"></c:import>

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
            <%@include file="siderBar.jsp" %>

            <!-- ============================================================== -->
            <!-- end left sidebar -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- wrapper  -->
            <!-- ============================================================== -->
            <div class="dashboard-wrapper">
                <div class="dashboard-ecommerce">
                    <div class="container-fluid dashboard-content ">
                        <!-- ============================================================== -->
                        <!-- pageheader  -->
                        <!-- ============================================================== -->
                        <div class="row">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <div class="page-header">

                                    <h2 class="pageheader-title">Staff</h2>
                                    <div class="page-breadcrumb">
                                        <nav aria-label="breadcrumb">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Detail Material</a></li>
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
                                    <h3 class="card-header">Detail Interior</h3>




                                    <!--                                    <div class="mb-3">
                                                                            <button class="create-btn" onclick="openCreatePopup()">Create</button>
                                                                        </div>-->


                                    <div class="card-body p-0">
                                        <div class="table-responsive">

                                            <form action="MainController" method="POST">
                                                <h4 class="card-header">Project Name:</h4>
                                                <input type="text" name="projectName" value="" class="form-control border-0" placeholder="Table"/><br>
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
                                                <h4 class="card-header">Project Scale:</h4>
                                                <input type="text" name="scale" value="" class="form-control border-0" placeholder="Table"/><br>
                                                <%
                                                    if (errors != null) {
                                                        if (errors.getScaleErr() != "") {
                                                %>
                                                <p class="text-center text-danger"><%= errors.getScaleErr()%></p>
                                                <%
                                                        }
                                                    }
                                                %>
                                                <h4 class="card-header">Project Description:</h4>
                                                <input type="text" name="description" value="" class="form-control border-0" placeholder="Table"/><br>
                                                <!--<h4 class="card-header">Project URL Image:</h4>
                                                <input type="text" name="image" value="" class="form-control border-0" placeholder="Table"/><br>-->
                                                <h4 class="card-header">Project Type:</h4>
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
                                    
                                </div>
                            </div>


                        </div>

                        <div id="deletePopup" class="popup">
                            <div class="popup-content">
                                <!-- Content of your popup goes here -->
                                <h2>Delete ProjectType</h2>
                                <p>Are you sure you want to delete?</p>

                                <div class="confirmation-buttons">
                                    <button class="update-btn" onclick="confirmDelete()">Yes</button>
                                    <button class="delete-btn" onclick="closePopup()">No</button>
                                </div>

                                <span class="close-btn" onclick="closeDeletePopup()">X</span>

                            </div>
                        </div>





                        <div id="updatePopup" class="popup">
                            <div class="popup-content">
                                <!-- Content of your popup goes here -->
                                <h2>Update ProjectType</h2>
                                <div class="container">
                                    <form action="action_page.php">
                                        <div class="row">
                                            <div class="col-25">
                                                <label for="fname">ProjectType Name</label>
                                            </div>
                                            <div class="col-75">
                                                <input type="text" id="fname" name="firstname" placeholder="Input first construction name..">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-25">
                                                <label for="fname">ProjectType Description</label>
                                            </div>
                                            <div class="col-75">
                                                <input type="text" id="fname" name="firstname" placeholder="Input construction description..">
                                            </div>
                                        </div>


                                        <div class="row">
                                            <input type="submit" value="Submit">
                                        </div>
                                    </form>
                                </div>
                                <span class="close-btn" onclick="closePopup()">X</span>

                            </div>
                        </div>


                        <div id="createPopup" class="popup">
                            <div class="popup-content">
                                <!-- Content of your popup goes here -->
                                <h2>Create</h2>
                                <div class="container">
                                    <form action="action_page.php">
                                        <div class="row">
                                            <div class="col-25">
                                                <label for="fname">ProjectType Name</label>
                                            </div>
                                            <div class="col-75">
                                                <input type="text" id="fname" name="firstname" placeholder="Input first construction name..">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-25">
                                                <label for="fname">ProjectType Description</label>
                                            </div>
                                            <div class="col-75">
                                                <input type="text" id="fname" name="firstname" placeholder="Input construction description..">
                                            </div>
                                        </div>


                                        <div class="row">
                                            <input type="submit" value="Submit">
                                        </div>
                                    </form>
                                </div>
                                <!-- Add form elements or other content as needed -->
                                <span class="close-btn" onclick="closeCreatePopup()">X</span>
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

                    <script>
                                    // Function to open the popup
                                    function openPopup() {
                                        document.getElementById("updatePopup").style.display = "block";
                                    }

                                    // Function to close the popup
                                    function closePopup() {
                                        document.getElementById("updatePopup").style.display = "none";
                                    }
                    </script>

                    <script>
                        // Function to open the popup
                        function openCreatePopup() {
                            document.getElementById("createPopup").style.display = "block";
                        }

                        // Function to close the popup
                        function closeCreatePopup() {
                            document.getElementById("createPopup").style.display = "none";
                        }
                    </script>


                    <script>
                        // Function to open the popup
                        function openDeletePopup() {
                            document.getElementById("deletePopup").style.display = "block";
                        }

                        // Function to close the popup
                        function closeDeletePopup() {
                            document.getElementById("deletePopup").style.display = "none";
                        }
                    </script>

                    </body>

                    </html>






