
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>�λ�����ý���</title>

</head>
<body>

	<form action="/bigdataShop/board/search2.do">
		
		<select name="tag">
			<option value="writer">�ۼ���</option>
			<option value="title">����</option>
			<option value="content">����</option>
		</select> <input type="text" name="search" /> <input type="submit" value="�˻�">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/bigdataShop/board/user/insert.do"
				style="text-align: right;">�۾���</a></li>
		</ul>
	</form>


	<table class="table">
		<thead>
			<tr>
				<th>��ȣ</th>
				<th>����</th>
				<th>�ۼ���</th>
				<th>�ۼ���¥</th>
				<th>��ȸ��</th>
				<th>����</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${boardlist}">
				<tr>
					<td><a href="/bigdataShop/board/user/read.do?board_no=${board.board_no}&action=READ">${board.board_no}</a></td>
					<td>${board.title}</td>
					<td>${board.id}</td>
					<td>${board.reg_dtm}</td>
					<td>${board.hit}</td>
					<td><a href="/bigdataShop/board/delete.do?id=${board.board_no}">����</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<ul class="pagination">
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
	</div>

</body>
</html>










