<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>UpLoad</h1>
<form action="/upload" enctype="multipart/form-data" method="post">
<input type="file" name="myFile">
<img alt="" src="/image/${img }">
<button>Uploadss</button>
</form>
</body>
</html>