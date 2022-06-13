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
		<form:form action="/Smartphone/product/update/${Product.id }"  method="post" modelAttribute="Product" enctype="multipart/form-data">
			<div class="mb-3 row">
				<label for="inputName" class="col-sm-2 col-form-label">Name</label>
				<div class="col-sm-8">
					<form:input type="text" class="form-control" id="inputName"  path="name" value="${Product.name }" />
				</div>
			</div>
			<div class="mb-3 row">
				<label for="inputDate" class="col-sm-2 col-form-label">Price</label>
				<div class="col-sm-8">
					<form:input type="number" class="form-control" id="inputDate"  path="price" value="${Product.price }"/>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="inputColor" class="col-sm-2 col-form-label">Image</label>
				<div class="col-sm-8">
					<input type="file" class="form-control" id="inputColor"  name="image" /> 
				</div>
			</div>
			<div class="mb-3 row">
				<label for="inputquantity" class="col-sm-2 col-form-label">Quantity</label>
				<div class="col-sm-8">
					<form:input type="text" class="form-control" id="inputquantity"  path="quantity" value="${Product.quantity }"/>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="inputScreen" class="col-sm-2 col-form-label">screen</label>
				<div class="col-sm-8">
					<form:input type="text" class="form-control" id="inputScreen"  path="screen" value="${Product.screen }"/>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="inputchip" class="col-sm-2 col-form-label">chip</label>
				<div class="col-sm-8">
					<form:input type="text" class="form-control" id="inputchip"  path="chip" value="${Product.chip }"/>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="inputScreen" class="col-sm-2 col-form-label">Create Date</label>
				<div class="col-sm-8">
					<form:input type="date" class="form-control" id="inputScreen"  path="createDate" value="${Product.createDate }"/>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="inputType" class="col-sm-2 col-form-label">Category</label>
				<div class="col-sm-8">				
					<form:select path="category" class="form-control">
					  <form:option value="${Product.category.id }">${Product.category.name}</form:option>
					  <c:forEach var="category" items="${categories }">
					   <form:option value="${category.id }">${category.name }</form:option>
					  </c:forEach>
					</form:select>
				</div>
			</div> 
			<div class="mb-3 row ">
			  <div class="col-sm-2"></div>
			  <div class="col-sm-8 mt-3">
			   <button class="btn btn-primary">Save</button>
			  </div>
			</div>
			

		</form:form>
		 
	</div>

</body>
</html>