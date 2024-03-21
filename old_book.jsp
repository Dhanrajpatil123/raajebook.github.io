<%@page import="com.entity.Book_details"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.BooksDavImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Old Book</title>



<%@include file="All_component/allCSS.jsp"%>


</head>
<body>



	<%@include file="All_component/navbar.jsp"%>




	<c:if test="${not empty success }">

		<div class = "alert alert-success text-center">
			${success}
		</div>
		<c:remove var="success" scope="session" />
	</c:if>

	<c:if test="${not empty failed }">

		<div class = "alert alert-success text-center">
			${success}
		</div>
		<c:remove var="failed" scope="session" />

	</c:if>

	<div class="container p-5">

		<table class="table table-striped">
			<thead class = "bg-primary text-white">
			
				<tr >
					<td>Book Name</td>
					<td>Author</td>
					<td>Price</td>
					<td>Category</td>
					<td>Action</td>
				</tr>

			</thead>
			
			
			
			<tbody>
			
			
			
			<%
			
				User u = (User)session.getAttribute("userobj");
				String email = u.getEmail();

			
				BooksDavImplementation dao = new BooksDavImplementation(DBConnect.getConnection());
			
				List<Book_details> list = dao.getBookByOld(email, "Old Book");
				
				for(Book_details b : list){
					
			%>
			
				<tr>
					<td><%=b.getBookname() %></td>
					<td><%=b.getAuthor() %></td>
					<td><%=b.getPrice() %></td>
					<td><%=b.getBookcategory() %></td>
					<td>
						<a href = "delete_old_book?em=<%= email %>&&id=<%=b.getBookid() %>" class = "btn btn-sm btn-danger">Delete</a>
					</td>
				</tr>
				
			
			
			<%
				}
			%>
			
			
			
				
			</tbody>
			
		</table>
	</div>







</body>
</html>













































