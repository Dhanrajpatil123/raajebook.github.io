<%@page import="com.dao.BooksDavImplementation"%>
<%@page import="com.dao.BookDao"%>
<%@page import="com.entity.Book_details"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@page isELIgnored = "false" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin : All Books</title>

<%@include file="allCSS.jsp"%>


</head>
<body>


	<%@include file="navbar.jsp"%>


	<h3 class="text-center">Hello Admin</h3>




<c:if test="${not empty success }">
						<h5 class = "text-center text-success">${success}</h5>
						<c:remove var="success" scope = "session"/>
					</c:if>
					
					
					<c:if test="${not empty failmsg }">
						<h5 class = "text-center text-danger">${failmsg}</h5>
						<c:remove var="failmsg" scope = "session"/>
					</c:if>
					




	<table class="table table-striped">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Image</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Categories</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		
		
		<tbody>
		
			<%
			
				BooksDavImplementation dao = new BooksDavImplementation(DBConnect.getConnection());
			
				List<Book_details> list = dao.getAllBook();
			
				for (Book_details b : list){
					
			%>
			
			<tr>
				<td><%=b.getBookid() %></td>
				<td><img src="../book/<%=b.getPhotoname() %>" style = "width: 50px; height: 50px;"> </td>
				<td><%=b.getBookname() %></td>
				<td><%=b.getAuthor() %></td>
				<td><%=b.getPrice() %></td>
				<td><%=b.getBookcategory() %></td>
				<td><%=b.getStatus() %></td>
				
				<td><a href="edit_books.jsp?id=<%=b.getBookid() %>" class="btn btn-sm btn-primary"><i class = "fas fa-edit"></i> Edit</a> <a
					href="../delete?id=<%=b.getBookid()%>" class="btn btn-sm btn-danger"><i class = "fas fa-trash-alt"></i> Delete</a></td>
					
	<!-- if we directly send request on servlet through anchor tag then by default doget() method will call -->
			
			</tr>
			
			<%		
				}
			
			%>
		
			
			
		</tbody>
	</table>











<div  style = "margin-top: 60px">
	<%@include file = "footer.jsp" %>
</div>


</body>
</html>