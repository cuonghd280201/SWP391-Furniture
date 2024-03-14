
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
        <style>
            .inner-page-banner {
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                height: 100px; /* Adjust the height to your desired value */
            }

           
        </style>

    </head>

    <body>

        <section class="inner-page-banner bg-common" data-bg-image="img/figure/inner-page-banner1.jpg">
            <div class="">
                <div class="row">
                    <div class="col-12">
                        <div class="breadcrumbs-area">
                            <h1>User Login Page</h1>
                            <ul>
                                <li>
                                    <a href=homePage name="btAction" value="Home">Home</a>
                                </li>
                                <li>Login</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <div class="container">
            <input type="checkbox" id="check">   
            <div class="login form">
                <header>Login</header>
                    <c:set var="error" value="${requestScope.LOGIN_ERR}"></c:set>

                    <form action="loginController"  method="post">
                        <input type="text" name="txtemail" placeholder="Enter your email">

                    <c:if test="${not empty error.emailEmptyErr}">
                        <font color="red">${error.emailEmptyErr}</font></br>
                    </c:if>
                    <input type="password" name="txtpassword" placeholder="Enter your password">

                    <c:if test="${not empty error.passwordEmptyErr}">
                        <font color="red">${error.passwordEmptyErr}</font></br>
                    </c:if>

                    <c:if test="${not empty error.accountNotFound}">
                        <font color="red">${error.accountNotFound}</font></br>
                    </c:if>

                    <c:if test="${not empty error.accIsactive}">
                        <font color="red">${error.accIsactive}</font></br>
                    </c:if>

                    <c:url var="forgot_url" value="forgotPasswordPage"></c:url>

                        <a href="${forgot_url}">Forgot password?</a>
                    <input type="submit" class="button"> <!-- Change to type="submit" -->
                    <h2 style="color: red;">${result}</h2>
                    <c:url var="verifyEmail_url" value="verifyEmailPage"></c:url>
                    <label class="lost-password"><a href="${verifyEmail_url}">Verify your email?</a></label>
                </form>
                <div class="signup">
                    <span class="signup">Don't have an account?
                        <a href="register.jsp"><button><i class="fas fa-user-plus"></i> Signup</button></a>
                    </span>
                </div>
            </div>   
        </div>
    </body>
</html>
