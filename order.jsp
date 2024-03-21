<%@page import="com.entity.Book_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.BookOrderImplementation"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored = "false" %>
 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Book</title>
<%@include file="All_component/allCSS.jsp"%>

</head>



<body style="background-color: #f0f1f2">


	
	
	<c:if test="${empty userobj }">
	
		<c:redirect url = "login.jsp"></c:redirect>
	
	</c:if>
	
	



<%@include file="All_component/navbar.jsp"%>

	<!-- -------------------------- navbar end ---------------------- -->
	
	
	<div class  = "container p-1">



		<table class="table table-striped mt-3">
		
		<h4 class = "text-center text-primary">Your Order</h4>
			<thead class = "bg-primary text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Type</th>
				</tr>
			</thead>
			<tbody>
			
			
			
				<%
				
				    User u = (User)session.getAttribute("userobj");
				
					BookOrderImplementation dao = new BookOrderImplementation(DBConnect.getConnection());
					
					List<Book_Order> list = dao.getBook(u.getEmail());
					
					
					for(Book_Order b : list){
				%>


					<tr>
						<th scope="row"><%=b.getOrderid() %></th>
						<td><%=b.getUsername() %></td>
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
	
	
	
	
</body>
</html>

























