$(document).ready(function(){
	var bno = Number(window.location.pathname.split("/")[2]);
	var resultArray = [];
	var html = '';

	$.ajax({
		async : false,
		url : "/reply/" + bno,
		type : "GET",
		success : function(result){
			renewTable(result, bno);
		}	
	});
		
	// 새 댓글 쓰기 버튼 클릭
	$("#createBtn").click(function(){
		action='create';
		type = 'POST'
		$("#modal-title").text("새 댓글 작성");
		$("#myModal").modal();
	});
	


	
	// Modal의 Submit 버튼 클릭 (새로운 댓글 생성)
	$("#modalSubmit").click(function(){

		var data = {
			"bno" : bno,
			"rno" : next,
			"userName" : $("#userName").val(),
			"contents" : $("#contents").val()
		};
		
		console.log(data);
		
		$.ajax({
			url : "/reply",
			type : "POST",
			data : data,
			success : function(result){
				renewTable(result, bno);
				$("#userName").val("");
				$("#contents").val("");
				$("#myModal").modal('hide');
			}			
		});
	});
});



function renewTable(result, bno){
	var html = '';
	length = result.length;

	for(var i = 0; i < length; i++){
		html += '<tr>'
				+ '<td><input type="hidden" id="id'+result[i].rno+'" value="'+result[i].id+'"></td>'
				+ '<td>' + result[i].rno + '</td>' 
				+ '<td><input class="form-control" type="text" id="'+ result[i].rno +'" value="' + result[i].contents + '" rows="40" readonly></td>' 
				+ '<td align="center">' +result[i].userName + '</td>'
				+ "<td>"
				+ "<div class='btn-group'>"
				+ "<button value="+ result[i].rno + " class='btn btn-xs btn-warning modify'>수정</button>"
				+ "<button value="+ result[i].rno + " class='btn btn-xs btn-danger delete'>삭제</button>" 
				+ "</div>"
				+ "</td>"	
				+ "</tr>";		
	}
	
	if(length != 0)
		$("#replyTable").html(html);
	else
		$("#replyTable").html("<tr><td>댓글이 없습니다.</td></tr>");
	
	$(".modify").click(function(){
		var rno = $(this).val();
		$("#" + rno).attr("readonly", false);	
	});
	
	// 삭제 버튼 클릭시 이벤트 처리
	$(".delete").click(function(){
		var rno = $(this).val();	
		var id = $("#id"+rno).val();
				
		var data = {
			"id" : id,
			"bno" : bno,
			"rno" : rno
		};
		
		$.ajax({
			async : false,
			url : "/delete",
			type : "POST",
			data : data,
			success : function(result){
				console.log(result);
				renewTable(result, bno);
			}
		})
		
	});
}