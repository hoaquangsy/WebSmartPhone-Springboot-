<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
        
            <div class="col-lg-8 table-responsive mb-5">
            <c:if test="${not empty sessionScope.error}">
					<div class="alert alert-primary " role="alert">
						${sessionScope.error}
						<c:remove var="error" scope="session" />
					</div>
				</c:if>
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Products</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    <c:forEach var="cart" items="${carts}">
                        <tr>
                            <td class="align-middle"> ${cart.name}</td>
                            <td class="align-middle"> ${cart.price} </td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">    
                                    <form action="updateToCart" method="post">  
                                    <input type="hidden" name="id" value="${cart.id }">  
                                    <div class="row">
                                    <input type="text"  class="form-control form-control-sm bg-secondary text-center col-4"  value="${cart.quantity}" name="quantity" "> 
                                     <input type="submit"  class="mx-2 form-control form-control-sm bg-primary text-center col-6 "   value="update" > 
                                    </div>                      
                                    
                                    </form>                                     
                                </div>
                            </td>
                            <td class="align-middle" >${cart.price * cart.quantity}</td>
                            <td class="align-middle"><a href="myCart/delete/${cart.id}" class="btn btn-sm btn-primary"><i class="fa fa-times"></i></a></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
                <form class="mb-5" action="${pageContext.request.contextPath }/admin/BillServlet/create?total=${total}" method="post">
                    <div class="input-group">
                        <input type="text" class="form-control p-4" placeholder="Coupon Code">
                        <div class="input-group-append">
                            <button class="btn btn-primary">Apply Coupon</button>
                        </div>
                    </div>                
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Cart Summary</h4>
                    </div>
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Total</h5>
                            <h5 class="font-weight-bold" >${total }</h5>
                        </div>
                        <a href="/user/shopSmartPhone/order" class="btn btn-block btn-primary my-3 py-3">Proceed To Checkout</a>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>