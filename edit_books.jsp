<%@page import="com.entity.Book_details"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.BooksDavImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin : Add Books</title>

<%@include file = "allCSS.jsp" %>


</head>
<body style="background-color: #f0f1f2">


<%@include file ="navbar.jsp" %>



	<div class="container p-2">


		<div class="row ">

			<div class="col-md-4 offset-md-4">


				<div class="card" style="border-radius: 15px">

					<div class="card-body">

						<h4 class="text-center">Edit Books</h4>
						
					
						
						
						
					
				 	
					
				<%
				
					int id = Integer.parseInt(request.getParameter("id")); 
					
					BooksDavImplementation dao = new BooksDavImplementation(DBConnect.getConnection());
					
					Book_details b = dao.getBookById(id); 
					
					/* System.out.println(b); */
				
				%>
				
					
					
						

						<form action="../editbooks" method="Post" >

							<input type = "hidden" name = "id" value = "<%= b.getBookid()%>">

							<div class="form-group">
								<label for="exampleInputEmail1">Book Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter full name"
									required="required" name="bname"   value = "<%= b.getBookname()%>">
							</div>


							<div class="form-group">
								<label for="exampleInputEmail1">Auther Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter phone number"
									required="required" name="author"	value = "<%= b.getAuthor()%>">

							</div>


							<div class="form-group">
								<label for="exampleInputEmail1">Price</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									required="required" name="price"  value = "<%= b.getPrice()%>">
							</div>







						<div class="form-group">
								<label for="inputState">Book Status</label> 
								<select
									id="inputState" name="bstatus"  class="form-control">
									
														
									<%
									
										if("Active".equals(b.getStatus())){
									%>
											<option value = "Active">Active</option>
									
									<% 
										}
										else{
											
									%>
										 	
										 	<option value = "Inactive">Inactive</option>
										<%
										}
					
										%>
												
								</select>
							</div>



					


							<div class="text-center pt-2">
								<button type="submit" class="btn btn-primary">Update</button>
							</div>

						</form>



					</div>

				</div>

			</div>

		</div>

	</div>








</body>
</html>