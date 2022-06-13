<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body ng-app="myapp" ng-controller="myController">

<div class="card">
  <div class="card-header row">
   <div class="col-9">
   <h1><a href="/Smartphone/product/admin/home" style="text-decoration: none">HOME</a></h1>
   </div>
   
  </div>
  <div class="card-body">
  <form action="/Smartphone/category/deletes" method="post">
  <div class="offset-8">
     <button class="btn btn-danger">Delete</button>
     <a href="/Smartphone/category/create" class="btn btn-primary">Add New Category</a>
     
   </div>
  
    <table class="table">
  <thead>
    <tr>
      <th scope="col" class="col-3">
        <div>
          <input type="checkbox"  ng-model="selectAll">
        </div>
      </th>
      <th scope="col" class="col-5">Name</th>

      <th scope="col" colspan="2">    
      Actions
      </th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="category" items="${categories}">
      <tr>
      <td scope="row">
        <div>
          <input type="checkbox" name="select"  ng-checked="selectAll">
        </div>
      </td>
      <td>${category.name }</td>
      
      <td>
        <a href="/Smartphone/category/delete/${category.id }" class="btn btn-danger">Delete</a>
        <a href="/Smartphone/category/edit/${category.id }" class="btn btn-warning">Update</a>
      </td>
      
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