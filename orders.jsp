<%@page import="com.entity.Book_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.BookOrderImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
   
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored = "false" %>
 	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin : All Orders</title>

<%@include file="allCSS.jsp"%>


</head>
<body>



	
	
	<c:if test="${empty userobj }">
	
		<c:redirect url = "login.jsp"></c:redirect>
	
	</c:if>
	
	



	<%@include file="navbar.jsp"%>


	<h3 class="text-center">Hello Admin</h3>



	<table class="table table-striped">
		<thead class="bg-warning">
			<tr>
				<th scope="col">Order Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Payment Type</th>
				
			</tr>
		</thead>
		
		
		<tbody>
		
		
		
		
		<%
		
			BookOrderImplementation dao = new BookOrderImplementation(DBConnect.getConnection());
		
			List<Book_Order> list = dao.getAllOrder();
			
			for(Book_Order b : list){
		%>
		
		
			<tr>
				<th scope="row"><%=b.getOrderid() %></th>
				<td><%=b.getUsername() %></td>
				<td><%= b.getEmail()%></td>
				<td><%=b.getFullAddress() %></td>
				<td><%=b.getPhone() %></td>
				<td><%=b.getBookname() %></td>
				<td><%=b.getAuthor() %></td>
				<td><%=b.getPrice() %></td>
				<td><%=b.getPaymentType() %></td>
				

			</tr>
		
		
		<%	
			
			}
		
		%>
		
		
		
		
			
			
		</tbody>
	</table>





	</div>





<div style = "margin-top: 260px">
	<%@include file = "footer.jsp" %>
</div>


</body>
</html>