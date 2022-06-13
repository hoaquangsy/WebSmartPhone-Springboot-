<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>



    <div class="container-fluid mb-5 mt-5">
        <div class="card-body">
       <div class="table-responesive">
         
          <table class="table">
		  <thead>
		   <tr>
		    <th>Mã hóa đơn </th>
		    <th>Tổng tiền</th>
		    <th>Ngày tạo </th>
	<!-- 	    <th>Trạng thái đơn hàng</th> -->
		    <th>Chi tiết</th>
		    
		   </tr>
		
		  </thead>
		  
		  <tbody>
		  <c:forEach var="order" items="${order}">
		   <tr>
		    <td>${order.id }</td>
		    <td>${order.total }</td>
		    <td>${order.createDate }</td>
<%-- 		    <td>
		    <c:choose>
		         <c:when test="${order.status ==0 }">Chưa xác nhận</c:when>
		         <c:when test="${order.status ==1 }">Đang giao</c:when>
		         <c:when test="${order.status ==2 }">Đã giao</c:when>
		       </c:choose>    
		    </td> --%>
		    <td><a href="/user/shopSmartPhone/detailOrder/${order.id}">Chi tiết</a></td>
		   </tr> 
		  </c:forEach> 
 
		  </tbody>
       </table>
          
        
       
       </div>
     </div>
    </div>