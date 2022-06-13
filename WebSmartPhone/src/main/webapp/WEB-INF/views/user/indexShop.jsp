 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="container-fluid mb-5">
	<div class="row border-top px-xl-5">
		<div class="col-lg-12">
			<div id="header-carousel" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active" style="height: 410px;">
						<img class="img-fluid"
							src="${pageContext.request.contextPath }/images/carousel-1.jpg"
							alt="Image">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<h4 class="text-light text-uppercase font-weight-medium mb-3">10%
									Off Your First Order</h4>
								<h3 class="display-4 text-white font-weight-semi-bold mb-4">Fashionable
									Dress</h3>
								<a href="" class="btn btn-light py-2 px-3">Shop Now</a>
							</div>
						</div>
					</div>
					<div class="carousel-item" style="height: 410px;">
						<img class="img-fluid"
							src="${pageContext.request.contextPath }/images/carousel-2.jpg"
							alt="Image">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<h4 class="text-light text-uppercase font-weight-medium mb-3">10%
									Off Your First Order</h4>
								<h3 class="display-4 text-white font-weight-semi-bold mb-4">Reasonable
									Price</h3>
								<a href="" class="btn btn-light py-2 px-3">Shop Now</a>
							</div>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#header-carousel"
					data-slide="prev">
					<div class="btn btn-dark" style="width: 45px; height: 45px;">
						<span class="carousel-control-prev-icon mb-n2"></span>
					</div>
				</a> <a class="carousel-control-next" href="#header-carousel"
					data-slide="next">
					<div class="btn btn-dark" style="width: 45px; height: 45px;">
						<span class="carousel-control-next-icon mb-n2"></span>
					</div>
				</a>
			</div>


		</div>
	</div>
</div>
<div class="px-5">
	<span class="ml-4">Danh mục:</span>

	 <div class="flex-w flex-l-m filter-tope-group m-tb-10 ml-4">
					<button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5 how-active1" data-filter="*">
						All Products
					</button>

					<button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".women">
						Women
					</button>

					<button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".men">
						Men
					</button>

					<button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".bag">
						Bag
					</button>

					<button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".shoes">
						Shoes
					</button>

					<button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".watches">
						Watches
					</button>
	
    </div>
<%--     <c:forEach items="${ ds }" var="category">
		<div class="card ml-3" style="width: 18rem;">
			<ul class="list-group list-group-flush">
				<li class="list-group-item" >
				<a href="${pageContext.request.contextPath}/ShopServlet/category?id=${category.id }">${category.ten }</a>
				</li>
			</ul>
		</div>
	</c:forEach> --%>



</div>
<div class="container-fluid pt-5">
	<div class="text-center mb-4">
		<h2 class="section-title px-5">
			<span class="px-2">Trandy Products</span>
		</h2>
	</div>
	<div class="row px-xl-5 pb-3">
		<c:forEach var="product" items="${pages.getContent()}">
			<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
				<div class="card product-item border-0 mb-4">
					<div
						class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
						<img class="img-fluid w-100 h-100"
							src="/image/${product.image}"
							alt="">
					</div>
					<div
						class="card-body border-left border-right text-center p-0 pt-4 pb-3">
						<h6 class="text-truncate mb-3">${product.name}</h6>
						<div class="d-flex justify-content-center">
							<h6>Price: ${product.price}</h6>
							<h6 class="text-muted ml-2">
								<del></del>
							</h6>
						</div>
					</div>
					<div
						class="card-footer d-flex justify-content-between bg-light border">
						   <a
							href="/user/shopSmartPhone/detailSmartPhone/${product.id}"
							class="btn btn-sm text-dark p-0"><i
							class="fas fa-eye text-primary mr-1"></i>View Detail</a> 
							
							<a
							href="/user/shopSmartPhone/detailSmartPhone/${product.id}"
							class="btn btn-sm text-dark p-0"><i
							class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>

<nav aria-label="Page navigation example "  class="pb-1 ml-5">
  <ul class="pagination">
    <c:if test="${pages.getNumber() >0}">
      <li class="page-item"><a class="page-link" href="/user/shopSmartPhone/index?pageNumber=${pages.getNumber()-1 }">Previous</a></li>
    </c:if>
    <li class="page-item disable"><a class="page-link" >${pages.getNumber()+1 } / ${pages.getTotalPages() }
     </a></li>
     <c:if test="${pages.getNumber()< pages.getTotalPages()-1}">
    <li class="page-item"><a class="page-link" href="/user/shopSmartPhone/index?pageNumber=${pages.getNumber()+1 }">Next</a></li>
    </c:if>
  </ul>
</nav>

</div>



<%--  ${name} --%>