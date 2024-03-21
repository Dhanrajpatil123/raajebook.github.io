<%@page import="java.util.List"%>
<%@page import="com.entity.Cart"%>
<%@page import="com.entity.User"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.CartDaoImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored = "false" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart-page</title>


<%@include file="All_component/allCSS.jsp"%>

</head>
<body style="background-color: #f7f7f7">


<!-- Navbar -->
	<%@include file="All_component/navbar.jsp"%>
	
	
	
	
	
	<c:if test="${empty userobj }">
	
		<c:redirect url = "login.jsp"></c:redirect>
	
	</c:if>
	
	



<c:if test="${not empty success}">

		<div class="alert alert-success text-center" role="alert">
			${success}
		</div>

		
		<c:remove var="success" scope = "session"/>

	</c:if>




<c:if test="${not empty failed}">

		<div class="alert alert-danger text-center role="alert">
			${failed}
		</div>

		
		<c:remove var="failed" scope = "session"/>

	</c:if>







	<div class="container">

		<div class="row p-2">

			<div class="col-md-6">

				


					<div class = "card bg-white">
					
						<div class = "card-body">
						
						<h3 class="text-center text-success">Your Selected Item</h3>

						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Book Name</th>
									<th scope="col">Author</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
							
							
							<%
							
								User u = (User)session.getAttribute("userobj");
							
								CartDaoImplementation dao = new CartDaoImplementation(DBConnect.getConnection());
							
								List<Cart> cart = dao.getBookByUser(u.getId());
								
								Double totalPrice = 0.00;
								
								
								for(Cart c : cart){
									totalPrice = c.getTotalPrice();
							%>

								<tr>
									<th scope="row"><%=c.getBookName() %></th>
									<td><%=c.getAuthor() %></td>
									<td><%=c.getPrice() %></td>
									<td>
										<a href = "remove_book?bid=<%=c.getBid() %>&&uid=<%=c.getUserid() %>&&cid=<%=c.getCid() %>" class = "btn btn-sm btn-danger">Remove</a>
									</td>
								</tr>



								<%
								}
							
							%>
							
							<tr>
								<td>Total Price</td>
								<td></td>
								<td></td>
								<td><%=totalPrice %></td>
							</tr>
							
							
							
								
							</tbody>
						</table>

					</div>
					
					</div>

					
			</div>
			
			
			
			
			
			
			<div class = "col-md-6">
			
				<div class = "card">
				
					<div class = "card-body">
					
						<h3 class = "text-center text-success">Your Details For Order</h3>
					
						<form action = "order" method = "post">
						
						
						<input type = "hidden" value = "${userobj.id }" name = "id">
						

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text" name = "username"
										class="form-control" id="inputEmail4"   value = "${userobj.name } " required = "required" <%-- value = "<%=u.getName() %>" readonly="readonly" --%>>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input name = "email"
										type="email" class="form-control" id="inputPassword4" value = "${userobj.email }" readonly="readonly"
										 <%-- value = "<%=u.getEmail() %>" readonly="readonly" --%>>
								</div>
							</div>
							
							
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Phone Number</label> <input type="number" name = "phone"
										class="form-control" id="inputEmail4" value = "${userobj.phone }" required = "required" <%-- value = "<%=u.getPhone() %>" --%>>
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Address</label> <input name = "address"
										type="text" class="form-control" id="inputPassword4" value = "${userobj.phone }" required = "required" 
										<%-- value = "<%=u.getAddress() %>" --%>>
								</div>
							</div>
							
							
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Landmark</label> <input type="text" name = "landmark" required = "required" 
										class="form-control" id="inputEmail4" value = "">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">City</label> <input name = "city"
										type="text" class="form-control" id="inputPassword4" required = "required" 
										value = "">
								</div>
							</div>
							
							
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">State</label> <input type="text" name = "state"
										class="form-control" id="inputEmail4" value = "" required = "required" >
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Zip</label> <input name = "pincode"
										type="number" class="form-control" id="inputPassword4" required = "required" 
										value = "">
								</div>
							</div>
							
							
							
							<div class = "form-group">
								<label>Payment Mode</label>
								<select class = "form-control" name = "payment" required = "required" >
								
									<option value = "noselect">---Select---</option>
									<option value = "cod">Cash On Delivery</option>
								</select>
							
							</div>
							
							
							
							<div class = "text-center">
							
								<button class = "btn btn-warning">Order Now</button>
							<a href = "index.jsp" class = "btn btn-success">Continue Shopping</a>
							
							</div>

						</form>
						
					
					</div>
				
				</div>
			
			</div>
			
			
			
			
			
			
			
			
			
		</div>

	</div>







</body>
</html>










































