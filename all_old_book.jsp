<%@page import="com.entity.Book_details"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.BooksDavImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Recent Books</title>
<%@include file="All_component/allCSS.jsp"%>



<style type="text/css">
.back-img {
	background: url("img/bookimg.jpg");
	height: 50vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
}

.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>


</head>
<body>


	<%@include file="All_component/navbar.jsp"%>



	<div class="container-fluid">
		<div class="row p-3 ">
			
			<%
			
				BooksDavImplementation dao = new BooksDavImplementation(DBConnect.getConnection());
				List<Book_details> list = dao.getAllOldBook();
				
				
				
				for (Book_details b : list){
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhotoname() %>"
							style="width: 100px; height: 150px" class="img-thumbin">
						<p><%=b.getBookname()%></p>
						<p><%=b.getAuthor()%></p>
						<p>
							Categories :
							<%=b.getBookcategory()%></p>
						<div class="row">
							
							<a href="view_books.jsp?bid=<%=b.getBookid() %>"
								class="btn btn-success btn-sm ml-5">View Details</a> 
							
							<a href=""
								class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=b.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>
	
		
		


		</div>
	</div>





</body>
</html>