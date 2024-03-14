<%-- 
    Document   : comment.jsp
    Created on : Mar 14, 2024, 1:59:14 AM
    Author     : Admin
--%>
<%@page import="comments.CommentDTO" %>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="comment.css">

    </head>
    <body>

        <div class="recipe-reviews">
            <div class="section-heading heading-dark">
                <h2 class="item-heading">PROJECT COMMENTS</h2>
            </div>
            <div class="avarage-rating-wrap">
                <div class="total-reviews">Total Comments: <span
                        class="review-number">${commentsList.size()}</span></div>
            </div>
            <ul id="commentList">
                <c:forEach var="commentDto" items="${commentsList}">
                    <c:set var="userId" value="${commentDto.userID}" />
                    <c:set var="firstName" value="${commentDto.firstName}" />
                    <c:set var="image" value="${commentDto.image}" />
                    <c:set var="commentDetail" value="${commentDto.commentDetail}" />
                    <c:set var="createAt" value="${commentDto.createAt}" />
                    <c:set var="updateAt" value="${commentDto.updateAt}" />
                    <li class="reviews-single-item comment-element">
                        <div class="media media-none--xs">
                            <img src="${image}" alt="commenter-avatar" class="media-img-auto"
                                 style="height: 100px; width: 100px">
                            <div class="media-body">
                                <h4 class="comment-title">${firstName}</h4>                            
                                <p id="comment-detail-${commentDto.commentID}">${commentDetail}</p>
                                <c:if test="${userId == currentUser.userId}">
                                    <p class="d-none" id="comment-detail">${commentDetail}</p>
                                    <p class="d-none">${commentDto.commentID}</p>
                                    <button class="btn-delete" type="submit" style="background-color: red; color: white; border: none;">
                                        <i class="fas fa-trash-alt" style="color: white;"></i> 
                                    </button>
                                </c:if>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <c:url value="CreateNewComment" var="commentUrl">
            <c:param name="txtProjectID" value="${param.projectID}" />
        </c:url>

        <div class="leave-review">
            <div class="section-heading heading-dark">
                <h2 class="item-heading">LEAVE A COMMENT</h2>
            </div>
            <form action="${commentUrl}" method="post">
                <div class="row">
                    <div class="col-12 form-group">
                        <label>Comment :</label>
                        <textarea placeholder="" class="textarea form-control" name="txtCommentDetail"
                                  rows="7" cols="20" data-error="Message field is required" required></textarea>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="col-12 form-group mb-0">
                        <button type="submit" class="item-btn" value="Comment" name="btAction">COMMENT</button>
                    </div>
                </div>
            </form>
        </div>    </body>
</html>
