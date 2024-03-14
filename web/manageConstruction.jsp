<%-- 
    Document   : manageConstruction
    Created on : Mar 5, 2024, 12:21:58 AM
    Author     : Admin
--%>

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
    <c:import url="DisplayDetailConstruction"></c:import>
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
                    showNotification("ReActive Construction  Successfully", "success");
                    // Remove the success notification attribute from the session
                ${sessionScope.remove("SAVE_NOTI")};
                }
            </script>
        </c:if>

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

                                    <h2 class="pageheader-title">Manager</h2>
                                    <div class="page-breadcrumb">
                                        <nav aria-label="breadcrumb">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Manager Construction Info</a></li>
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
                            <c:set var="cDto" value="${requestScope.listConstruction}"/>
                            <c:set var="detail" value="${requestScope.DETAIL_INFO}"/>

                            <div class="col-xl-12 col-lg-12 col-md-6 col-sm-12 col-12">
                                <div class="card">
                                    <div class="mb-3">
                                        <button class="create-btn" onclick="openCreatePopup()">Create</button>
                                    </div>

                                    <h5 class="card-header">Manage Construction</h5>
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead class="bg-light">
                                                    <tr class="border-0">
                                                        <th class="border-0">Construction ID</th>
                                                        <th class="border-0">Construction Name</th>
                                                        <th class="border-0">Construction Description</th>
                                                        <th class="border-0">Construction Status</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="c" items="${cDto}">
                                                        <tr>
                                                            <td>${c.constructionID}</td>
                                                            <td>${c.constructionName}</td>
                                                            <td>${c.constructionDescription}</td>   
                                                            <td>${c.constructionStatus}</td>   
                                                            <td>
                                                                <c:url var="edit_construction_url" value="displayDetailConstruction">
                                                                    <c:param name="constructionID" value="${c.constructionID}"/>
                                                                </c:url>

                                                                <button class="update-btn" onclick="openPopup()"><i class="fas fa-edit"></i></button>


                                                                <div class="switch">
                                                                    <form id="switchForm_${c.constructionID}" action="deleteConstructionController" method="post">
                                                                        <input type="hidden" name="constructionID" value="${c.constructionID}">
                                                                        <input type="hidden" name="toggleValue" id="toggleValue_${c.constructionID}" value="${c.constructionStatus ? 'on' : 'off'}">
                                                                        <input type="checkbox" id="toggle_${c.constructionID}" ${c.constructionStatus ? "checked" : ""} onclick="updateAction(${c.constructionID})">
                                                                        <label for="toggle_${c.constructionID}"></label>
                                                                    </form>
                                                                </div>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>

                                    </div>
                                </div>
                            </div>


                        </div>


                        <div id="updatePopup" class="popup">
                            <div class="popup-content">
                                <!-- Content of your popup goes here -->
                                <h2>Update Contruction</h2>
                                <div class="container">
                                    <form action="" method="post">
                                        <div class="row">
                                            <div class="col-25">
                                                <label for="txtConstructionName">Construction Name</label>
                                            </div>
                                            <div class="col-75">
                                                <input type="text" id="txtConstructionName" name="txtConstructionName" value="${detail.constructionName}" >
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-25">
                                                <label for="txtContructionDescription">Construction Description</label>
                                            </div>
                                            <div class="col-75">
                                                <input type="text" id="txtContructionDescription" name="txtContructionDescription" value="${detail.constructionDescription}" >
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
                                    <form action="CreateConstructionController">
                                        <div class="row">
                                            <div class="col-25">
                                                <label for="txtConstructionName">Construction Name</label>
                                            </div>
                                            <div class="col-75">
                                                <input type="text" id="fname" name="txtConstructionName" placeholder="Input first construction name..">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-25">
                                                <label for="txtContructionDescription">Construction Description</label>
                                            </div>
                                            <div class="col-75">
                                                <input type="text" id="fname" name="txtContructionDescription" placeholder="Input construction description..">
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

                    <style>


                        /* The switch (checkbox input) */
                        .switch {
                            position: relative;
                            display: inline-block;
                            width: 40px;
                            height: 20px;
                        }

                        .switch input {
                            display: none;
                        }

                        .switch label {
                            position: absolute;
                            top: 0;
                            left: 0;
                            width: 40px;
                            height: 20px;
                            background-color: #ccc;
                            border-radius: 20px;
                            cursor: pointer;
                        }

                        .switch label:after {
                            content: '';
                            position: absolute;
                            top: 2px;
                            left: 2px;
                            width: 16px;
                            height: 16px;
                            background-color: #fff;
                            border-radius: 50%;
                            transition: 0.3s;
                        }

                        .switch input:checked + label {
                            background-color: #4CAF50;
                        }

                        .switch input:checked + label:after {
                            transform: translateX(20px);
                        }

                    </style>
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
                            var url = "${remove_recipe_url}";

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
                        function updateAction(constructionID) {
                            var confirmation = confirm("Are you sure you want to remove this construction?");
                            if (confirmation) {
                                var form = document.getElementById("switchForm_" + constructionID);
                                var toggleValue = document.getElementById("toggleValue_" + constructionID);
                                toggleValue.value = toggleValue.value === "on" ? "off" : "on";
                                form.submit();
                            }
                        }
                        function showSuccessPopup() {
                            alert("Account has been successfully deleted.");
                            // You can customize this to show a more visually appealing popup using libraries like Bootstrap modal
                        }
                    </script>
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


