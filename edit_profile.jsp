<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored = "false" %>
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<%@include file="All_component/allCSS.jsp"%>

</head>



<body style="background-color: #f0f1f2">



<%@include file="All_component/navbar.jsp"%>

	<!-- -------------------------- navbar end ---------------------- -->
	
	
	
	<div class = "container">
	
		<div class = "row">
		
			<div class = "col-md-4 offset-md-4">
			
				<div class = "card">
				
					<div class = "card-body">
					
					
					<h4 class = "text-center text-primary">Edit Profile</h4>


						<c:if test="${not empty successMsg}">
							<h5 class="text-center text-success">${successMsg }</h5>
							<c:remove var="successMsg" scope = "session"/>
						</c:if>
						
						
						<c:if test="${not empty failedMsg}">
							<h5 class = "text-center text-danger">${failedMsg }</h5>  
							<c:remove var="failedMsg" scope = "session"/>
						</c:if>





						<form action = "update_profile" method = "Post">
						
						
						<input type = "hidden" value = " ${userobj.id }" name = "id">
						
						
						<div class="form-group">
								<label for="exampleInputEmail1">Enter Full Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter full name" required="required" name = "name" value = "${userobj.name }">
							</div>
						
						
						<div class="form-group">
								<label for="exampleInputEmail1">Phone</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter phone number" required="required" name = "phone" value = "${userobj.phone }">

							</div>
						
						
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email" required="required" name = "email" value = "${userobj.email }">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
							</div>
							
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" required="required"  name = "password">
							</div>
						
							
							<div class = "text-center pt-2" >
								<button type="submit" class="btn btn-primary form-control">Update</button>
							</div>
							
						</form>
					
					
					
					</div>
				
				</div>
			
			</div>
		
		</div>
	
	</div>
	
	
	
	

</body>
</html>



































