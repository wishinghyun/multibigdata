<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" session="true"%>
<!DOCTYPE
>
<html>
<head>
<title>bigdataShop</title>

</head>
<body>
		<form class="form-horizontal" method="post" 
			enctype="multipart/form-data"
					action="/bigdataShop/board/user/insert.do">
			
		<input type="hidden" name="id" id="id" value="kang">
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label">�ۼ���</label>
			</div>
			<div class="col-md-8">
				${"kang"}
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="title" class="control-label">����</label>
			</div>
			<div class="col-md-8">
				<input type="text" class="form-control input-lg" name="title"
					id="title" placeholder="����"> 
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="text" class="control-label">����</label>
			</div>
			<div class="col-md-8">
				<textarea class="form-control" rows="20" name="text" id="text"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="files" class="control-label">����1</label>
			</div>
			<div class="col-md-8">
				<input type="file" class="form-control input-lg" name="files"
					id="files" placeholder="���ϼ���"> 
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="title" class="control-label">����2</label>
			</div>
			<div class="col-md-8">
				<input type="file" class="form-control input-lg" name="files"
					id="title" placeholder="���ϼ���"> 
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="files" class="control-label">����3</label>
			</div>
			<div class="col-md-8">
				<input type="file" class="form-control input-lg" name="files"
					id="files" placeholder="���ϼ���"> 
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="files" class="control-label">����4</label>
			</div>
			<div class="col-md-8">
				<input type="file" class="form-control input-lg" name="files"
					id="files" placeholder="���ϼ���"> 
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="title" class="control-label">����5</label>
			</div>
			<div class="col-md-8">
				<input type="file" class="form-control input-lg" name="files"
					id="title" placeholder="���ϼ���"> 
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-10 text-center">
				<input type="submit" class="btn btn-lg btn-primary" value="�۾���">
				
				<button type="button" class="btn btn-danger btn-lg"
					onclick="javascript:cancelCheck()">
					<i class="fa fa-fw fa-close"></i> ���
				</button>
			</div>
		</div>
	</form>

</body>
</html>