<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Joy Joy</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="/resources/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="/resources/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="/resources/css/style.css" rel="stylesheet">
</head>

<body>  
   
    <!-- Sign In Start -->
        <div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                    <div class="bg-secondary rounded p-4 p-sm-5 my-4 mx-3">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href="index.html" class="">
                                <h3 class="text-primary">Joy Joy</h3>
                            </a>
                        	<div class="d-flex justify-content-end"> 
				                <img alt="카카오로그인" src="/resources/img/kakao_login_medium_narrow.png" onclick="loginWithKakao()" style="margin-bottom:10px;">
				            </div>
                        </div>
                        
                        <form role="form" method='post' action="/login" id="loginForm">
                        	<fieldset>
                       
	                        <div class="form-floating mb-3">
	                            <input type="text" class="form-control" id="floatingInput" name="username" placeholder="name@example.com">
	                            <label for="floatingInput">Id</label>
	                        </div>
	                        <div class="form-floating mb-4">
	                            <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
	                            <label for="floatingPassword">Password</label>
	                        </div>
	                        <div class="d-flex align-items-center justify-content-between mb-4">
	                            <div class="form-check">
	                                <input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember-me">
	                                <label class="form-check-label" for="exampleCheck1">Remember Me</label>
	                            </div>
	                        </div>
	                        <button class="btn btn-primary py-3 w-100 mb-4" type="submit">Sign In</button>
	                        <p class="text-center mb-0">Don't have an Account? <a href="/user/register">Sign Up</a></p>
	                        </fieldset>
	                        
                        	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
        <!-- Sign In End -->
        
</body>

<!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/resources/lib/chart/chart.min.js"></script>
    <script src="/resources/lib/easing/easing.min.js"></script>
    <script src="/resources/lib/waypoints/waypoints.min.js"></script>
    <script src="/resources/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="/resources/lib/tempusdominus/js/moment.min.js"></script>
    <script src="/resources/lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="/resources/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="/resources/js/main.js"></script>  
    
    <script src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
    
    <script type="text/javascript">
    
    $(document).ready(function() {
    	Kakao.init('8ea600964b420ea3797f486c026bbe0d');
    	Kakao.isInitialized();
    });
    
    function loginWithKakao() {
    	Kakao.Auth.authorize({
    		redirectUri: 'http://localhost:8080/kakao/callback'
    	}); 
    }
    
 	$(".btn-primary").on("click", function(e) {
        
    	e.preventDefault();
    	$("#loginForm").submit();
    	
    });
 	
    
    </script>
