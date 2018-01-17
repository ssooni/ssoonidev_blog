<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Read Contents</title>
</head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/board/reply.js"></script>

<body>
	<div class="container">
		<h3>
			작성자 : <b>${board.userName}</b>
		</h3>
		<hr>
		<h4>${board.contents}</h4>
		<hr>
		<h4>
			<b>댓글</b>
		</h4>
		<br>
		<table id="replyTable" class="table table-board">
			<!-- reply.js에서 채워줍니다. -->
		</table>
		<jsp:include page="../include/modal.jsp" />
		<button id="createBtn" type="button" class="btn btn-info btn-sm"
			data-toggle="modal">새 댓글 쓰기</button>
	</div>
</body>
</html>