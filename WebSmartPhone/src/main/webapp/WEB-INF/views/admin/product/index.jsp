<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body ng-app="myapp" ng-controller="myController">

	<div class="card">
		<div class="card-header row">
			<div class="col-9">
				<h1><a href="/Smartphone/product/admin/home" style="text-decoration: none">HOME</a></h1>
			</div>
			<div class="col-3">
				<a href="#" class="btn btn-danger">Delete</a> <a
					href="/Smartphone/product/create" class="btn btn-primary">Add
					New SmartPhone</a>

			</div>
		</div>
		<div class="card-body">
			<form class="d-flex" role="search" action="/Smartphone/product/search"
				method="post">
				<div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for products" name="name">
                        <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <input type="submit" class="btn btn-primary" value="Search">
                            </span>
                        </div>
                    </div>
			</form>
			<form action="/smartphone/deletes" class="mt-4" method="post">
				<!-- <div class="col-3">
					<button class="btn btn-danger">Delete</button>
					<a href="/smartphone/create" class="btn btn-primary">Add New
						SmartPhone</a>
				</div> -->
				<table class="table">

					<thead>
						<tr>
							<th scope="col">
								<div>
									<input type="checkbox" ng-model="selectAll" name="select">
								</div>
							</th>
							<th scope="col">Name</th>
							<th scope="col">Image</th>
							<th scope="col">Price</th>
							<th scope="col">Quantity</th>
							<th scope="col">Chip</th>
							<th scope="col">Screen</th>
							<th scope="col">CreateDate</th>
							      <th scope="col">Category</th>
							<th scope="col" colspan="2">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${products}">
							<tr>
								<th scope="row">
									<div>
										<input type="checkbox" ng-checked="selectAll">
									</div>
								</th>
								<td>${product.name }</td>
								<td> <img alt="" src="/image/${product.image }" width="80px"></td>
								<td>${product.price }</td>
								<td>${product.quantity }</td>
								<td>${product.screen }</td>
								<td>${product.chip }</td>
								<td><fmt:formatDate value="${product.createDate }"
										pattern="dd-MM-yyyy" /></td>
								<td>${product.category.name }</td>
								<td><a href="delete/${product.id }"
									class="btn btn-danger">Delete</a>
									 <a href="edit/${product.id }"
									class="btn btn-warning">Update</a></td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</form>

		</div>
	</div>




	<script src="/js/jquery.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/angular.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script>
		var app = angular.module("myapp", []);
		app.controller("myController", function($scope) {
			$scope.selectAll = false;
			$scope.select = function() {
				$scope.selectAll = true;
				console.log($scope.selectAll);
			}
		});
	</script>
</body>
</html>