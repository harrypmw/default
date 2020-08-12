<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>SAMPLEDTO ${sampleDTO}</h2>
	<h2>Page ${page}</h2>
	<form action="/sample/uploadTest" method="post" enctype="multipart/form-data">
		<div>
			<input type="file" name="files" />
		</div>
		<div>
			<input type="file" name="files" />
		</div>
		<div>
			<input type="file" name="files" />
		</div>
		<div><input type="submit" value="submit"></div>
	</form>
</body>
</html>