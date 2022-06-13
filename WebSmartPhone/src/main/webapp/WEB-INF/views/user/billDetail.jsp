<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
        
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-bordered text-center mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Products</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    <c:forEach var="orderDetail" items="${orderDetails}">
                        <tr>
                            <td class="align-middle"> ${orderDetail.product.name}</td>
                            <td class="align-middle"> ${orderDetail.price} </td>
                            <td class="align-middle">
                                <div class="input-group quantity mx-auto" style="width: 100px;">    
                                    <form action="updateToorderDetail" method="post">  
                                    <input type="hidden" name="id" value="${orderDetail.id }">  
                                    <div class="row">
                                    <input type="text"  class="form-control form-control-sm bg-secondary text-center col-4"  value="${orderDetail.quantity}" name="quantity" "> 
                                     <input type="submit"  class="mx-2 form-control form-control-sm bg-primary text-center col-6 "   value="update" > 
                                    </div>                      

                                    </form>                                     
                                </div>
                            </td>
                            <td class="align-middle" >${orderDetail.price * orderDetail.quantity}</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
        </div>
    </div>