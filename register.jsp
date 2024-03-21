<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored = "false" %>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebook: Registeration</title>

<%@include file="All_component/allCSS.jsp"%>

</head>
<body style = "background-color: #f0f1f2">



	<%@include file="All_component/navbar.jsp"%>

	<!-- -------------------------- navbar end ---------------------- -->



	<div class="container p-2">

		<div class="row">

			<div class="col-md-4 offset-md-4">

				<div class="card " style="border-radius: 15px">

					
					<div class="card-body">
					
					<h4 class = "text-center">Register Here</h4>

<!-- ------------- jstl ------------- -->
						<c:if test="${not empty successMsg }">

							<p class="text-center text-success">${successMsg}</p>
							<c:remove var="successMsg" scope = "session"/>
							
						</c:if>
						
						<c:if test = "${not empty failedMsg }">
						
							<p class = "text-center text-danger">${failedMsg}</p>
							<c:remove var="failedMsg" scope = "session"/>
						
						</c:if>


						<form action = "register" method = "Post">
						
						
						<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter full name" required="required" name = "name">
							</div>
						
						
						<div class="form-group">
								<label for="exampleInputEmail1">Phone</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter phone number" required="required" name = "phone">

							</div>
						
						
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email" required="required" name = "email">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
							</div>
							
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" required="required"  name = "password">
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1" name = "check"> <label class="form-check-label"
									for="exampleCheck1">Agree terms & conditions</label>
							</div>
							
							<div class = "text-center pt-2" >
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
							
						</form>

					</div>

				</div>

			</div>

		</div>

	</div>



















	<!-- -------------------------- footer ---------------------- -->

	<%@include file="All_component/footer.jsp"%>

</body>
</html>











































