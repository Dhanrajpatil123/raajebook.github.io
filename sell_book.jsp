<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page isELIgnored = "false" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell Book</title>


<%@include file="All_component/allCSS.jsp"%>

</head>



<body style="background-color: #f0f1f2">



<c:if test="${empty userobj }">
	<c:redirect url = "login.jsp"></c:redirect>
</c:if>



<%@include file="All_component/navbar.jsp"%>

	<!-- -------------------------- navbar end ---------------------- -->
	
	
	
	<div class = "container">
	
		<div class = "row">
		
			<div class = "col-md-4 offset-md-4">
			
			
				<div class = "card">
				
					<div class = "card-body">
					
						
					<h5 class = "text-center text-primary p-1">Sell Old Book</h5>



						<c:if test="${not empty success }">
							<h5 class="text-center text-success">${success}</h5>
							<c:remove var="success" scope="session" />
						</c:if>


						<c:if test="${not empty failmsg }">
							<strong><h5 class="text-center text-danger">${failmsg}</h5></strong>
							<c:remove var="failmsg" scope="session" />
						</c:if>




						<form action="add_old_book" method="Post" enctype = "multipart/form-data">



		
			


				<input type = "hidden"  value = "${userobj.email }" name = "user">

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
								<label for="exampleFormControlFile1">Upload Photo</label> <input
									type="file" class="form-control-file" name = "bimg"
									id="exampleFormControlFile1">
							</div>


							<div class="text-center pt-2">
								<button type="submit" class="btn btn-primary">Sell</button>
							</div>


						</form>
						
						
					
					
					</div>
				
				</div>
			
			</div>
		
		</div>
	
	</div>
	




</body>
</html>



















































