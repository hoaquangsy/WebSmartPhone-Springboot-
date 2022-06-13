<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet"
	href="/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/css/style.css">
<link rel="stylesheet"
	href="/css/dataTables.bootstrap5.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" />
</head>
<body>
<div>
	<!-- top navigation bar -->

<nav class=" bg-primary">
<ul class="nav " >
  <li class="nav-item">
    <a class="nav-link active text-light" aria-current="page" href="Smartphone/product/home">Home</a>
  </li>
  <li class="nav-item">
    <a class="nav-link text-light" href="/Smartphone/product/index">SmartPhone</a>
  </li>
  <li class="nav-item">
    <a class="nav-link text-light" href="/Smartphone/category/index">Category</a>
  </li>
  <li class="nav-item">
    <a class="nav-link text-light" href="/logout">Logout</a>
  </li>
</ul>
</nav>

</div>
<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true" style="height: 90%">
  <div class="carousel-indicators" >
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/image/1259854.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/image/1259864.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/image/1259901.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

</body>
<script src="/js/chart.min.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery-3.5.1.js"></script>
<script
	src="/js/jquery.dataTables.min.js"></script>
<script
	src="/js/dataTables.bootstrap5.min.js"></script>
<script src="/js/script.js"></script>
</html>