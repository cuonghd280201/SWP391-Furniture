
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
<body>
  <div class="container">
    <input type="checkbox" id="check">   
    <div class="login form">
      <header>Login</header>
      <form action="./logining.vn">
        <input type="hidden" name="action" value="login"> <!-- Add action as a hidden field -->
        <input type="text" name="email" placeholder="Enter your email">
        <input type="password" name="password" placeholder="Enter your password">
        <a href="#">Forgot password?</a>
        <input type="submit" class="button" value="Login"> <!-- Change to type="submit" -->
        <h2 style="color: red;">${result}</h2>
      </form>
      <div class="signup">
        <span class="signup">Don't have an account?
          <label for="check">Signup</label>
        </span>
      </div>
    </div>
    
    <div class="registration form">
      <header>Signup</header>
      <form action="./signUp.vn">
        <input type="hidden" name="action" value="signup"> <!-- Add action as a hidden field -->
        <input type="text" name="email" placeholder="Enter your email">
        <input type="password" name="su-password" placeholder="Create a password">
        <input type="password" name="re-su-password" placeholder="Confirm your password">
        <input type="submit" class="button" value="Signup"> <!-- Change to type="submit" -->
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
