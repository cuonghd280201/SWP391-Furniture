<%-- 
    Document   : register
    Created on : Mar 2, 2024, 3:54:30 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login & Registration Form | CoderGirl</title>
        <link href="<c:url value="/style.css"/>" rel="stylesheet" type="text/css"/>

    </head>
    <style>
        .containerS {
            width: 33.33%; /* Chiều rộng 1/3 màn hình */
            margin: 0 auto; /* Canh giữa */
            padding: 20px; /* Để tạo khoảng cách xung quanh nội dung */
            box-sizing: border-box; /* Đảm bảo phần padding không làm thay đổi kích thước của container */
        }
        /* Thêm các CSS khác tại đây */
    </style>
    <body>
        <div class="containerS">

            <div class="registration form">
                <header>Signup</header>
                    <c:set var="error" value="${requestScope.REGISTER_ERR}"></c:set>

                    <form action="SigUpController" method="POST">
                        <input type="hidden" name="action" value="signup"> <!-- Add action as a hidden field -->
                        <input type="text" name="txtFirstName" placeholder="Enter your first name">
                         <c:if test="${not empty error.firstnameFormatErr}">
                        <font color="red">${error.firstnameFormatErr}</font></br>
                    </c:if>
                        <input type="text" name="txtLastName" placeholder="Enter your last name">
                         <c:if test="${not empty error.lastnameFormatErr}">
                        <font color="red">${error.lastnameFormatErr}</font></br>
                    </c:if>
                        <input type="text" name="txtPhonenumber" placeholder="Enter your phone number">
                         <c:if test="${not empty error.phonenumberFormatErr}">
                        <font color="red">${error.phonenumberFormatErr}</font></br>
                    </c:if>
                        <input type="text" name="txtEmail" placeholder="Enter your email">
                    <c:if test="${not empty error.emailFormatErr}">
                        <font color="red">${error.emailFormatErr}</font></br>
                    </c:if>
                    <input type="password" name="txtPassword" placeholder="Create a password">
                     <c:if test="${not empty error.passwordFormatErr}">
                        <font color="red">${error.passwordFormatErr}</font></br>
                    </c:if>
                    <input type="password" name="txtConfirm" placeholder="Confirm your password">
                     <c:if test="${not empty error.confirmNotMathched}">
                        <font color="red">${error.confirmNotMathched}</font></br>
                    </c:if>
                    <input type="submit" class="button" value="SignUp" name="btnAction"> <!-- Change to type="submit" -->
                </form>
                <div class="signup">
                    <span class="signup">Already have an account?
                        <label for="check">Login</label>
                    </span>
                </div>
            </div>
        </div>


    </body>
</html>

