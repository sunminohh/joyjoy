
console.log("Reply Modul.......");

let replyService = (function(){
	
	function add(reply, callback, error) {
		console.log("add reply............");
		
		$.ajax({
			type : 'post',
			url : '/etcReplies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		})
	}
	
	function getList(param, callback, error) {
		
		let bno = param.bno;
		let page = param.page || 1;
		
		$.getJSON("/etcReplies/pages/" + bno + "/" + page + ".json",
			function(data){
				if (callback) {
					// callback(data); // 댓글 목록만 가져오는 경우
					callback(data.replyCnt, data.list); // 댓글 숫자와 목록을 가져오는 경우
				}
			}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}
	
	function remove(rno, replyer, callback, error) {
	
		$.ajax({
			type: 'delete',
			url: '/etcReplies/' + rno,
			data: JSON.stringify({rno:rno, replyer:replyer}),
			contentType : "application/json; charset=utf-8",
			success : function(deleteResult, status, xhr) {
				if (callback) {
					callback(deleteResult);
				}
			}, 
			error : function(xhr, status, er) {
				if (error){
					error(er);
				}
			}
		});
	}
	
	function update(reply, callback, error) {
		
		console.log("RNO: " + reply.rno);
		
		$.ajax({
			type : 'put',
			url : '/etcReplies/' + reply.rno,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			}, error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}
	
	function get(rno, callback, error) {
		
		$.get("/etcReplies/" + rno + ".json", function(result) {
			
			if (callback) {
				callback(result);
			}
		}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}
	
	function displayTime(timeValue) {
		
		let today = new Date();
		
		let gap = today.getTime() - timeValue;
		
		let dateObj = new Date(timeValue);
		let str = "";
		
		if (gap < (1000 * 60 * 60 * 24)) {
			
			let hh = dateObj.getHours();
			let mi = dateObj.getMinutes();
			let ss = dateObj.getSeconds();
			
			return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi,
				':', (ss > 9 ? '' : '0') + ss ].join('');
		} else {
			let yy = dateObj.getFullYear();
			let mm = dateObj.getMonth() + 1; // 
			let dd = dateObj.getDate();
			
			return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
				(dd > 9 ? '' : '0') + dd ].join('');
		}
	};
	
	return {
		add : add,
		get : get,
		getList : getList,
		remove : remove,
		update : update,
		displayTime : displayTime
	}; 
})();

