<%-- 
    Document   : contract.jsp
    Created on : Mar 13, 2024, 11:55:25 PM
    Author     : Admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Contract Detail Description</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap-theme.min.css">
        <!-- Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="card job-detail" style="box-shadow: rgba(149, 157, 165, 0.2) 0px 8px 24px;">
                <div class="card-body p-3">
                    <div>
                        <div class="container" style="background-color: white;">
                            <div class="row justify-content-center p-5 mb-4" style="border: 1px solid #b3adad;">
                                <div id="pdf-content">
                                    <h1 class="text-center mb-4">Interior construction contract</h1>
                                    <p>Based on the needs and capacities of the parties involved, this Labor Subleasing Agreement (hereinafter referred to as the "Agreement") is made on [date] between the following parties:</p>
                                    <h5>A. COMPANY</h5>
                                    <p>Company: Funirute</p>
                                    <p>Phone: 09932131231</p>
                                    <p>Legal Representative: Hoàng Khánh Linh</p>
                                    <p>Position: STAFF</p>
                                    <p>(Hereinafter referred to as the "<strong>Sublessor</strong>")</p>
                                    <h5>B. CUSTOMER</h5>
                                    <div class="d-flex flex-column gap-3 mb-3">
                                        <div class="row">
                                            <div class="col-md-12 d-flex align-items-center">
                                                <div class="mb-0">
                                                    Company: <c:out value="${contractDetail.companyPartnerName}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 d-flex align-items-center">
                                                <div class="mb-0">
                                                    Phone: <c:out value="${contractDetail.companyPartPhoneNumber}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 d-flex align-items-center">
                                                <div class="mb-0">
                                                    Legal Representative: <c:out value="${contractDetail.legalRepresentation}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 d-flex align-items-center">
                                                <div class="mb-0">
                                                    Position: <c:out value="${contractDetail.legalRepresentationPosition}" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <p>(Hereinafter referred to as the "<strong>Sublessee</strong>")</p>
                                    <!-- Remaining content -->

                                    <div class="row">
                                        <div class="col-md-6">
                                            <label for="start_date" class="form-label">Start Date:</label>
                                            <input type="date" id="start_date" name="start_date" class="form-control">
                                        </div>
                                        <div class="col-md-6">
                                            <label for="end_date" class="form-label">End Date:</label>
                                            <input type="date" id="end_date" name="end_date" class="form-control">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label for="contract_price" class="form-label">Contract Price:</label>
                                            <input type="number" id="contract_price" name="contract_price" class="form-control">
                                        </div>
                                    </div>
                                </div>

                                <div class="row mt-4">
                                    <div class="col">
                                        <h2>Terms of contract</h2>
                                        <ul>
                                            <li>Artice 1: This section outlines the specific tasks and responsibilities of both parties involved in the interior construction project.</li>
                                            <li>Artice 2: It details the project schedule, including start date, completion date, and any important milestones</li>
                                            <!-- Thêm các điều khoản khác tương tự -->
                                        </ul>
                                    </div>
                                </div>
                                <!-- pdf-content2, pdf-content3, pdf-content4 sections -->
                                <!-- Signature section for Sublessor -->
                                <div class="row mt-4">
                                    <div class="col-md-6">
                                        <h5>Signature of Company</h5>
                                        <div class="signature-area">
                                            <!-- Add signature input field or image display area -->
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <h5>Signature of Customer</h5>
                                        <div class="signature-area">
                                            <!-- Add signature input field or image display area -->
                                        </div>
                                    </div>
                                </div>



                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
