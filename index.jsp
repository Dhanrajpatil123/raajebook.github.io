<%@page import="com.entity.User"%>
<%@page import="com.entity.Book_details"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.BooksDavImplementation"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebook:Index</title>

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





<body style="background-color: #f7f7f7">




<%
	User u = (User)session.getAttribute("userobj");
	
%>





	<%@include file="All_component/navbar.jsp"%>

	<div class="container-fluid back-img">
		<h2 class="text-center text-danger" style = ""></h2>
	</div>






	<!-- --------------------- Start Recent Book ---------------------- -->


	<div class="container mt-2">

		<h3 class="text-center">Recent Book</h3>
		
		
		
		<div class="row">
			<!-- card-1 -->
			
		<%
			BooksDavImplementation dao2 = new BooksDavImplementation(DBConnect.getConnection());
		
			List<Book_details> list2 = dao2.getRecentBook();
			
			for(Book_details b : list2){
		%>
		
				<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhotoname() %>"
							style="width: 150px; height: 200px" class="img-thumbin">
						<p><%=b.getBookname() %></p>
						<p><%=b.getAuthor() %></p>
						
						
						
						<%
						
							if(b.getBookcategory().equals("Old Book")){
						%>
						
						<p>Categories : <%=b.getBookcategory() %></p>
							<div class="row text-center">
							 <a
								href="view_books.jsp?bid=<%=b.getBookid() %>" class="btn btn-success btn-sm ml-5">View Details</a> <a
								href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=b.getPrice() %></a>
						</div>
							
						
						<% 	
							}
						
							else{
						%>
						
							<p>Categories : <%=b.getBookcategory() %></p>
						<div class="row text-center">


							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i>Add Cart</a>

							<%
							} else {
							%>


							<a
								href="cartServlet?bid=<%=b.getBookid()%>&&uid=<%=u.getId()%>"
								class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i>Add Cart</a>

							<%
							}
							%>


							<a href="view_books.jsp?bid=<%=b.getBookid()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-indian-rupee-sign"></i><%=b.getPrice()%></a>
						</div>

						<%
						}
						%>


					</div>
				</div>
			</div>
		
		<%
			}
		%>

			<!-- card-2 -->

			


			<!-- card-3 -->

			
			<!-- card-4 -->

			

		</div>

		<div class="text-center">
			<a href = "all_recent_book.jsp" class="btn btn-danger btn-sm text-white mt-3">View all</a>
		</div>
	</div>

	<!-- --------------------- End Start Recent Book ---------------------- -->





	<hr>





	<!-- --------------------- Start New Book ---------------------- -->


	<div class="container ">

		<h3 class="text-center">New Book</h3>
		<div class="row">


			<!-- card-1 -->

			
			
			<%
			
				BooksDavImplementation dao = new BooksDavImplementation(DBConnect.getConnection());
				List<Book_details> list = dao.getNewBook();
				
				
				
				for (Book_details b : list){
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhotoname() %>"
							style="width: 150px; height: 200px" class="img-thumbin">
						<p><%=b.getBookname()%></p>
						<p><%=b.getAuthor()%></p>
						<p>
							Categories :
							<%=b.getBookcategory()%></p>
						<div class="row text-center">
						
						
						
						<%
							if(u == null){
						%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i>Add Cart</a>
								
						<%
							}
							else
							{
						%>
						
						
							<a href="cartServlet?bid=<%=b.getBookid() %>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i>Add Cart</a> 
						
						<%
							}
						%>
						
						
							
							<a href="view_books.jsp?bid=<%=b.getBookid() %>"
								class="btn btn-success btn-sm ml-1">View Details</a> 
								
							<a href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=b.getPrice()%></a>
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>
				
			



			<!-- card-2 -->

			



			<!-- card-3 -->

			


			<!-- card-4 -->

			

		</div>

		<div class="text-center">
			<a href = "all_new_book.jsp" class="btn btn-danger btn-sm text-white mt-3">View all</a>
		</div>
	</div>

	<!-- --------------------- End Start New Book ---------------------- -->




	<hr>





	<!-- --------------------- Start Old Book ---------------------- -->


	<div class="container ">

		<h3 class="text-center">Old Book</h3>
		<div class="row">


		<%
			BooksDavImplementation dao3 = new BooksDavImplementation(DBConnect.getConnection());
		
			List<Book_details> list3 = dao3.getOldBook();
			
			for(Book_details b : list3){
		%>
		
				<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getPhotoname() %>"
							style="width: 150px; height: 200px" class="img-thumbin">
						<p><%=b.getBookname() %></p>
						<p><%=b.getAuthor() %></p>
						
						
							<p>Categories : <%=b.getBookcategory() %></p>
						<div class="row text-center">
						 <a
								href="view_books.jsp?bid=<%=b.getBookid() %>" class="btn btn-success btn-sm ml-5">View Details</a> <a
								href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=b.getPrice() %></a>
						</div>
						
						

					
						
						
						
						
					</div>
				</div>
			</div>
		
		<%
			}
		%>



			<!-- card-2 -->

			



			<!-- card-3 -->



			<!-- card-4 -->

			

		</div>

		<div class="text-center">
			<a href = "all_old_book.jsp" class="btn btn-danger btn-sm text-white mt-3">View all</a>
		</div>
	</div>

	<!-- --------------------- End Start Old Book ---------------------- -->




	<hr>






<%@include file = "All_component/footer.jsp" %>



</body>

</html>








































