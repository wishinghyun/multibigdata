<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/bigdataShop/common/css/jqcloud.css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.js"></script>
    <script type="text/javascript" src="/bigdataShop/common/js/jqcloud-1.0.4.js"></script>

</head>
<body>
	<div style="width: 1000px;">
	<h1>상품 댓글 분석</h1>
	<hr/>
		 <table border="1" style="border-collapse: collapse; height: 400px; width: 200px; text-align: center; float: left;">
		 	<tr>
		 		<th style="text-align: center;">키워드</th>
		 		<th style="text-align: center;">반복횟수</th>
		 	</tr>
				 <c:if test="${!empty commcount}">
			 		<c:forEach var="comm" items="${commcount}">
			 			<tr>
			 				<td>${comm.pro_comment}</td>
			 				<td>${comm.countnum}</td>
			 			</tr>	
			 		</c:forEach>
				 </c:if>
				 
			</table>
	</div>
	 <div id="keyword" style="width: 600px; height: 400px; border: 1px solid #ccc; float: left"></div>
	
	<script type="text/javascript">
	var word_array = new Array();
	
	<c:forEach var="comm" items="${wordview}" varStatus="status">
		word_array["${status.index}"] =  {text: "${comm.pro_comment}", weight: "${comm.countnum}"}
	</c:forEach>

    $(function() {
        $("#keyword").jQCloud(word_array);
    });
</script>

</body>

</html>


