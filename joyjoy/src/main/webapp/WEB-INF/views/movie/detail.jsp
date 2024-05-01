<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@include file="../includes/header.jsp"%>

<style>
.uploadResult {
	width: 100%;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
	align-content: center;
	text-align: center;
}

.uploadResult ul li img {
	width: 100px;
}

.uploadResult ul li span {
	color: white;
}

.bigPictureWrapper {
	position: absolute;
	display: none;
	justify-content: center;
	align-items: center;
	top: 0%;
	width: 100%;
	height: 100%;
	z-index: 100;
	background: rgba(255, 255, 255, 0.5);
}

.bigPicture {
	position: relative;
	display: flex;
	justify-content: center;
	align-items: center;
}

.bigPicture img {
	width: 600px;
}


</style>

<!--Reply Modal -->
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
     <div class="modal-dialog">
         <div class="modal-content bg-secondary text-white">
             <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                 <h4 class="modal-title text-white" id="myModalLabel">REPLY MODAL</h4>
             </div>
             <div class="modal-body">
             	<div class="form-group">
             		<label>Reply</label>
             		<input class="form-control bg-white" name='reply' value='New Reply!!!'>
             	</div>
             	<div class="form-group">
             		<label>Replyer</label>
             		<input class="form-control" name='replyer' value='replyer' readonly>
             	</div>
             	<div class="form-group">
             		<label>Reply Date</label>
             		<input class="form-control" name='replyDate' value=''>
             	</div>
             	
             </div>
             <div class="modal-footer">
             	<button id='modalModifyBtn' type="button" class = "btn btn-warning">Modify</button>
             	<button id='modalRemoveBtn' type="button" class = "btn btn-danger">Remove</button>
             	<button id='modalRegisterBtn' type="button" class = "btn btn-primary" data-dismiss="modal">Register</button>
             	<button id='modalCloseBtn' type="button" class = "btn btn-light" data-bs-dismiss="modal" aria-label="Close">Close</button>
             </div>
         </div>
         <!-- /.modal-content -->
     </div>
     <!-- /.modal-dialog -->
 </div>

<!-- /.row -->
	<div class="container-fluid pt-4 px-4">
		<div class="row g-4">
	
			<div class="col-12">
				<div class="bg-secondary rounded h-100 p-4">
					<div class="d-flex justify-content-between align-items-center mb-4">
						<h4 class="mb-0">Detail Page</h4>
					</div>
					
					<input type="hidden" name='bno' value='<c:out value="${board.bno }"/>' />
					
					<div class="form-group mb-3">
						<label>제목</label><input class="form-control" name='title'
							value='<c:out value="${board.title }"/>' readonly="readonly">
					</div>
					<div class="form-group mb-3">
						<label>내용</label>
						<textarea class="form-control" rows="5" name='content'
                			readonly="readonly"><c:out value="${board.content }" />
                		</textarea>
					</div>
					<div class="form-group mb-3">
						<label>작성자</label><input class="form-control" name='writer'
							value='<c:out value="${board.writer }"/>' readonly="readonly">
					</div>
	
					<sec:authentication property="principal" var="pinfo"/>
						<sec:authorize access="isAuthenticated()">
							<c:if test="${pinfo.username eq board.writer }">
								<button data-oper='modify' class="btn btn-warning">Modify</button>
							</c:if>
						</sec:authorize>
					
	
					<button data-oper='list' class="btn btn-primary">List</button>
	
					<form id="operForm" action="/movie/modify" method="get">
						<input type="hidden" id="bno" name="bno"
							value='<c:out value= "${board.bno }" />'> <input
							type="hidden" name="pageNum"
							value='<c:out value= "${page.pageNum }" />'> <input
							type="hidden" name="amount"
							value='<c:out value= "${page.amount }" />'> <input
							type="hidden" name="type" value='<c:out value="${page.type }"/>'>
						<input type="hidden" name="keyword"
							value='<c:out value="${page.keyword }"/>'>
					</form>
	
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-6 -->
	</div>
	
	<div class='bigPictureWrapper'>
		<div class='bigPicture'></div>
	</div>
	
	<div class="container-fluid pt-4 px-4">
		<div class="row g-4">
			<div class="col-12">
				<div class="bg-secondary rounded h-100 p-4">
					<div class="d-flex justify-content-between align-items-center mb-4">
						<h4 class="mb-0">Files</h4>
					</div>
					<div class="panel-body">
						<div class='uploadResult'>
							<ul>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container-fluid pt-4 px-4">
		<div class="row g-4">
			<div class="col-12">
				<div class="bg-secondary rounded h-100 p-4">
					<div class="d-flex justify-content-between align-items-center mb-4">
						<h6 class="mb-0">
							<i class="fa fa-comments fa-fw"></i> Reply
						</h6>
						<sec:authorize access="isAuthenticated()">
							<button id='addReplyBtn' class='btn btn-primary btn-sm float-end'>New Reply</button>
						</sec:authorize>
					</div>
					
					
	
					<div class="panel-body">
						<ul class="chat" style="list-style-type: none; padding-left: 0px;">
							<!-- start reply -->
							<!-- <li class="left clearfix">
								<div>
									<div class="header">
										<hr>
									</div>
								</div>
							</li> -->
							<!-- end reply -->
						</ul>
					</div>
	
					<div class="panner-footer float-end"></div>
				</div>
			</div>
		</div>
	</div>


<!-- /.row -->
<%@include file="../includes/footer.jsp" %>

<script type="text/javascript" src="/resources/js/movieNav.js"></script> 
<script type="text/javascript" src="/resources/js/movieReply.js"></script> 

<script type="text/javascript">
$(document).ready(function() {
	
	let bnoValue = '<c:out value="${board.bno}"/>';
	let replyUL = $(".chat");
	
	console.log("bnoValue: " + bnoValue);
	
	showList(-1);
	
	function showList(page) {
		
		console.log("show list " + page);
		
		replyService.getList({bno:bnoValue, page: page|| 1}, function(replyCnt, list){
			
			console.log("replyCnt: " + replyCnt);
			console.log("list: " + list);
			console.log(list);
			
			if (page == -1) {
				pageNum = Math.ceil(replyCnt/10.0);
				showList(pageNum);
				return;
			}
			
			let str = "";
			
			if (list == null || list.length == 0) {
				/* replyUL.html(""); */
				return;
			} 
			
			for(let i=0, len = list.length || 0; i < len; i++) {
				str += "<hr>";
				str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
				str += "<div><div class='header'><strong class='primary-font'>"+list[i].replyer+"</strong>";
				str += "<small class='float-end text-muted'>"+replyService.displayTime(list[i].replyDate)+"</small></div>";
				str += "<p>"+list[i].reply+"</p></div></li>";
			}
			
			replyUL.html(str);
			
			showReplyPage(replyCnt);
		});
		
	}
	
	// 댓글 페이지번호 출력
	let pageNum = 1;
	let replyPageFooter = $(".panner-footer");
	
	function showReplyPage(replyCnt) {
		
		let endNum = Math.ceil(pageNum/ 10.0) * 10;
		let startNum = endNum - 9;
		
		let prev = startNum != 1;
		let next = false;
		
		if (endNum * 10 >= replyCnt){
			endNum = Math.ceil(replyCnt/10.0);
		}
		
		if (endNum * 10 < replyCnt){
			next = true;
		}
		
		let str = "<ul class='pagination pull-right'>";
		
		if (prev){
			str += "<li class='page-item'><a class='page-link' href='"+(startNum - 1)+"'>Previous</a></li>";
		}
		
		for (let i = startNum; i <= endNum ; i++){
			
			let active = pageNum == i ? "active" : "";
			
			str += "<li class='page-item "+active+" '><a class='page-link' href='"+i+"'>"+i+"</a></li>";
		}
		
		if(next) {
			str += "<li class='page-item'><a class='page-link' href='"+(endNum + 1)+"'>Next</a></li>";
		}
		
		str += "</ul></div>";
		
		replyPageFooter.html(str);
	}
	
	replyPageFooter.on("click", "li a", function(e){
		e.preventDefault();
		console.log("page click");
		
		let targetPageNum = $(this).attr("href");
		
		console.log("targetPageNum: " + targetPageNum);
		
		pageNum = targetPageNum;
		
		showList(pageNum);
	});
	
	// Reply Modal
	let modal = $(".modal");     
	let modalInputReply = modal.find("input[name='reply']");
	let modalInputReplyer = modal.find("input[name='replyer']");
	let modalInputReplyDate = modal.find("input[name='replyDate']");
	
	let modalModifyBtn = $("#modalModifyBtn");
	let modalRemoveBtn = $("#modalRemoveBtn");
	let modalRegisterBtn = $("#modalRegisterBtn");
	
	let replyer = null;
	
	<sec:authorize access="isAuthenticated()">
	    replyer = '<sec:authentication property="principal.username"/>';
	    replyer = replyer.replace('&#64;', '@').replace('&#46;', '.');
	</sec:authorize>
	
	let csrfHeaderName = "${_csrf.headerName}";
	let csrfTokenValue = "${_csrf.token}";
	
	$("#addReplyBtn").on("click", function(e) {
		
		modal.find("input").val("");
		modal.find("input[name='replyer']").val(replyer);
		modalInputReplyDate.closest("div").hide();
		modal.find("button[id != 'modalCloseBtn']").hide();
		
		modalRegisterBtn.show();
		
		$(".modal").modal("show");
	});
	
	// Ajax spring sercurity header...
	$(document).ajaxSend(function(e, xhr, options){
		xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
	})
	
	modalRegisterBtn.on("click", function(e) {
		
		let reply = {
				reply : modalInputReply.val(),
				replyer : modalInputReplyer.val(),
				bno : bnoValue
		};
		replyService.add(reply, function(result) {
			
			alert(result);
			
			modal.find("input").val("");
			modal.modal("hide");
			
			showList(-1);
		});
	});
	
	// 댓 조회 클릭 이벤트 처리
	$(".chat").on("click", "li", function(e){
		
		let rno = $(this).data("rno");
		
		replyService.get(rno, function(reply){
			modalInputReply.val(reply.reply);
			modalInputReplyer.val(reply.replyer);
			modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly", "readonly");
			modal.data("rno", reply.rno);
			
			modal.find("button[id != 'modalCloseBtn']").hide();
			modalModifyBtn.show();
			modalRemoveBtn.show();
			
			$(".modal").modal("show");
		});
	});
	
	// 댓 수정
	modalModifyBtn.on("click", function(e){
		
		let orginalReplyer = modalInputReplyer.val();
		
		let reply = {
				rno:modal.data("rno"),
				reply: modalInputReply.val(),
				replyer: orginalReplyer};
		
		if(!replyer){
			alert("로그인후 수정이 가능합니다.");
			modal.modal("hide");
			return;
		}
		
		console.log("Original Replyer: " + orginalReplyer);
		
		if(replyer != orginalReplyer){
			alert("자신이 작성한 댓글만 수정이 가능합니다.");
			modal.modal("hide");
			return;
		}
		
		replyService.update(reply, function(result){
			
			alert(result);
			modal.modal("hide");
			showList(pageNum);
		});
	});
	
	
	
	// 댓삭
	modalRemoveBtn.on("click", function(e){
		
		let rno = modal.data("rno");
	
		console.log("RNO: " + rno);
		console.log("REPLYER: " + replyer);
		
		if(!replyer){
			alert("로그인후 삭제가 가능합니다");
			modal.modal("hide");
			return;
		}
		
		let orginalReplyer = modalInputReplyer.val();
		
		console.log("Orginal Replyer: " + orginalReplyer);  //댓글의 원래 작성자
		
		if (replyer != orginalReplyer){
			alert("자신이 작성한 댓글만 삭제가 가능합니다");
			modal.modal("hide");
			return;
		}
		
	    replyService.remove(rno, orginalReplyer, function(result) {
	        alert(result);
	        modal.modal("hide");
	        showList(pageNum);
	    });
	});
	
	
});
</script>


<script type="text/javascript">
// 첨부파일 존
$(document).ready(function() {

	let bno = '<c:out value="${board.bno}"/>';
	
	$.getJSON("/movie/getAttachList", {bno: bno}, function(arr){
		
		console.log(arr);
		
		let str = "";
		
		$(arr).each(function(i, attach){
			
			// image type
			if(attach.fileType){
				
				let fileCallPath = encodeURIComponent( attach.uploadPath+ "/s_" 
						+ attach.uuid + "_" + attach.fileName);
				
				str += "<li data-path='" +attach.uploadPath+ "' data-uuid='" +attach.uuid+"' data-filename='" + attach.fileName+ "' data-type='" +attach.fileType+ "'><div>";
				str += "<img src='/movieDisplay?fileName=" +fileCallPath+"'>";
				str += "</div>";
				str += "</li>";
			
			}else {
				
				str += "<li data-path='" +attach.uploadPath+ "' data-uuid='" +attach.uuid+"' data-filename='" + attach.fileName+ "' data-type='" +attach.fileType+ "' ><div>";
				str += "<span> " + attach.fileName + "</span><br/>";
				str += "<img src='/resources/img/attach.png'>";
				str += "</div>";
				str += "</li>";
			}
		});
		
		$(".uploadResult ul").html(str);
		
	}); //$getjson
	
	$(".uploadResult").on("click", "li", function(e){
		
		console.log("view image");
		
		let liObj = $(this);
		
		let path = encodeURIComponent( liObj.data("path")+ "/" +liObj.data("uuid")+ "_" +liObj.data("filename"));
		
		if (liObj.data("type")){
			showImage(path.replace(new RegExp(/\\/g),"/"));
		} else {
			//download
			self.location = "/movieDownload?fileName=" +path
		}
	});
	
	function showImage(fileCallPath){
		
		$(".bigPictureWrapper").css("display", "flex").show();
		
		$(".bigPicture")
			.html("<img src='/movieDisplay?fileName=" +fileCallPath+"'>")
			.show();
	}
	
	$(".bigPictureWrapper").on("click", function(e){
		
		$(".bigPicture").hide();
		$('.bigPictureWrapper').hide();
	});
})

</script>

<script type="text/javascript">
$(document).ready(function() {
	
	let operForm = $("#operForm");
	
	$("button[data-oper='modify']").on("click", function(e) {
		operForm.attr("action", "/movie/modify").submit();
	});
	
	$("button[data-oper='list']").on("click", function(e) {
		operForm.find("#bno").remove();
		operForm.attr("action", "/movie/list")
		operForm.submit();
	});
	
});
</script> 
 
  