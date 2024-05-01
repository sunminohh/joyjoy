<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@include file="../includes/myheader.jsp"%>


<!-- /.row -->
	<div class="container-fluid pt-4 px-4">
		<div class="row g-4">
	
			<div class="col-12">
				<div class="bg-secondary rounded h-100 p-4">
					<div class="d-flex justify-content-between align-items-center mb-4">
						<h4 class="mb-0">My Profile</h4>
					</div>
					
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
					
					<div class="form-group mb-3">
						<label>이름</label>
						<input class="form-control" name='userName' 
							value='<c:out value="${user.userName }"/>' readonly="readonly">
					</div>
				
					<div class="form-group mb-3">
						<label>아이디</label>
						<input class="form-control" name='userid'
							 value='<c:out value="${user.userid }"/>' readonly="readonly">
					</div>
					
					<div class="form-group mb-3">
						<label>이메일</label>
						<input class="form-control" name='userEmail'
							 value='<c:out value="${user.userEmail }"/>' readonly="readonly">
					</div>
					
					<div class="form-group mb-3">
						<label>가입일</label>
						<input class="form-control" name='regDate'
							 value='<fmt:formatDate pattern="yyyy-MM-dd" value="${user.regDate }"/>' readonly="readonly">
					</div>
	
					<a href="/user/modify?userid=${user.userid }" class="btn btn-warning">Update</a>
                    <a href="/" class="btn btn-primary">List</a>
	
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-6 -->
	</div>


<!-- /.row -->
<%@include file="../includes/footer.jsp" %>
<script type="text/javascript" src="/resources/js/profileNav.js"></script> 

 
  