<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>

<style>
    .table th:nth-child(2),  
    .table td:nth-child(2) {
        width: 50%; /* 제목 칸 너비 조절 */
    }
</style>


<!-- Table Start -->
<div class="container-fluid pt-4 px-4"> 
	<div class="row g-4">
	
  	<div class="col-12">
         <div class="bg-secondary text-center rounded p-4">
             <div class="d-flex align-items-center justify-content-between mb-4">
                 <h1 class="mx-auto" style="text-align:center;">WELCOME!</h1>
             </div>
             <div class="d-flex align-items-center justify-content-between mb-4">
                 <h1 class="mx-auto" style="text-align:center;">WANNA ENJOY?</h1>
             </div>
             <div class="table-responsive">
              
             </div>
         </div>
     </div>
				 <!-- Table Start -->
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-secondary rounded h-100 p-4">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">MOVIE</h6>
                                <a href="/movie/list">Show All</a>
                            </div>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">#번호</th>
                                        <th scope="col" style="text-align: center;">제목</th>
                                        <th scope="col">작성자</th>
                                        <th scope="col" style="text-align: center;">작성일</th>
                                        <th scope="col" style="text-align: center;">조회</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${movieList }" var="movie">
	                                    <tr>
	                                      <td><c:out value="${movie.bno }"></c:out></td>
										<td>
											<a href="/movie/detail?bno=${movie.bno}"><c:out value="${movie.title}" /> 
											<b>[ <c:out value="${movie.replyCnt}" /> ]</b>
											</a>
										</td>
										<td><c:out value="${movie.writer }"></c:out></td>
										<td style="text-align: center;"><fmt:formatDate pattern="yyyy-MM-dd"
												value="${movie.regDate }" /></td>
										<td style="text-align: center;"><c:out value="${movie.readCnt }"></c:out></td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-secondary rounded h-100 p-4">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">GAME</h6>
                                <a href="/game/list">Show All</a>
                            </div>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">#번호</th>
                                        <th scope="col" style="text-align: center;">제목</th>
                                        <th scope="col">작성자</th>
                                        <th scope="col" style="text-align: center;">작성일</th>
                                        <th scope="col" style="text-align: center;">조회</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${gameList }" var="game">
	                                    <tr>
	                                      <td><c:out value="${game.bno }"></c:out></td>
										<td>
											<a href="/game/detail?bno=${game.bno}"><c:out value="${game.title}" /> 
											<b>[ <c:out value="${game.replyCnt}" /> ]</b>
											</a>
										</td>
										<td><c:out value="${game.writer }"></c:out></td>
										<td style="text-align: center;"><fmt:formatDate pattern="yyyy-MM-dd"
												value="${game.regDate }" /></td>
										<td style="text-align: center;"><c:out value="${game.readCnt }"></c:out></td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-secondary rounded h-100 p-4">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">BOOK</h6>
                                <a href="/book/list">Show All</a>
                            </div>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">#번호</th>
                                        <th scope="col" style="text-align: center;">제목</th>
                                        <th scope="col">작성자</th>
                                        <th scope="col" style="text-align: center;">작성일</th>
                                        <th scope="col" style="text-align: center;">조회</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${bookList }" var="book">
	                                    <tr>
	                                      <td><c:out value="${book.bno }"></c:out></td>
										<td>
											<a href="/book/detail?bno=${book.bno}"><c:out value="${book.title}" /> 
											<b>[ <c:out value="${book.replyCnt}" /> ]</b>
											</a>
										</td>
										<td><c:out value="${book.writer }"></c:out></td>
										<td style="text-align: center;"><fmt:formatDate pattern="yyyy-MM-dd"
												value="${book.regDate }" /></td>
										<td style="text-align: center;"><c:out value="${book.readCnt }"></c:out></td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-secondary rounded h-100 p-4">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">ETC</h6>
                                <a href="/etc/list">Show All</a>
                            </div>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">#번호</th>
                                        <th scope="col" style="text-align: center;">제목</th>
                                        <th scope="col">작성자</th>
                                        <th scope="col" style="text-align: center;">작성일</th>
                                        <th scope="col" style="text-align: center;">조회</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${etcList }" var="etc">
	                                    <tr>
	                                      <td><c:out value="${etc.bno }"></c:out></td>
										<td>
											<a href="/etc/detail?bno=${etc.bno}"><c:out value="${etc.title}" /> 
											<b>[ <c:out value="${etc.replyCnt}" /> ]</b>
											</a>
										</td>
										<td><c:out value="${etc.writer }"></c:out></td>
										<td style="text-align: center;"><fmt:formatDate pattern="yyyy-MM-dd"
												value="${etc.regDate }" /></td>
										<td style="text-align: center;"><c:out value="${etc.readCnt }"></c:out></td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
            

	</div>
</div>
<%@include file="includes/footer.jsp"%>


