<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin : Add Books</title>

<%@include file = "allCSS.jsp" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@page isELIgnored = "false" %>

</head>
<body style="background-color: #f0f1f2">


<%@include file ="navbar.jsp" %>

<c:if test="${empty userobj}">
	
	<c:redirect url="../login.jsp" />

</c:if>

	<div class="container p-2">


		<div class="row ">

			<div class="col-md-4 offset-md-4">


				<div class="card" style="border-radius: 15px">

					<div class="card-body">

						<h4 class="text-center">Add Books</h4>
						
					
						
						
						<c:if test="${not empty success }">
						<h5 class = "text-center text-success">${success}</h5>
						<c:remove var="success" scope = "session"/>
					</c:if>
					
					
					<c:if test="${not empty failmsg }">
						<strong><h5 class = "text-center text-danger">${failmsg}</h5></strong>
						<c:remove var="failmsg" scope = "session"/>
					</c:if>
						

						<form action="../addbooks" method="Post" enctype = "multipart/form-data">


							<div class="form-group">
								<label for="exampleInputEmail1">Book Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter full name"
									required="required" name="bname">
							</div>
							
							

							<div class="form-group">
								<label for="exampleInputEmail1">Auther Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter phone number"
									required="required" name="author">

							</div>


							<div class="form-group">
								<label for="exampleInputEmail1">Price</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									required="required" name="price">
							</div>




							<div class="form-group">
								<label for="inputState">Book Categories</label> <select
									id="inputState" name="btype" class="form-control">
									<option selected>---Select---</option>
									<option>New Book</option>
									<option>Old Book</option>
								</select>
							</div>



							<div class="form-group">
								<label for="inputState">Book Status</label> <select
									id="inputState" name="bstatus"  class="form-control">
									<option selected>---Select---</option>
									<option>Active</option>
									<option>Inactive</option>
								</select>
							</div>



							<div class="form-group">
								<label for="exampleFormControlFile1">Upload Photo</label> <input
									type="file" class="form-control-file" name = "bimg"
									id="exampleFormControlFile1">
							</div>


							<div class="text-center pt-2">
								<button type="submit" class="btn btn-primary">Add</button>
							</div>

						</form>



					</div>

				</div>

			</div>

		</div>

	</div>








</body>
</html>