<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
	<h3>Add Category</h3>
		<form:form action="/Smartphone/category/store"  method="post" modelAttribute="Category">
			<div class="mb-3 row">
				<label for="inputName" class="col-sm-2 col-form-label">Name</label>
				<div class="col-sm-8">
					<form:input type="text" class="form-control" id="inputName"  path="name"/>
				</div>
			<div class="mb-3 row ">
			  <div class="col-sm-2"></div>
			  <div class="col-sm-8 mt-3">
			   <button class="btn btn-primary">Save</button>
			  </div>
			</div>
			</div>
			

		</form:form>
	</div>

</body>
</html>