<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- FOR Bootstrap CSS (SIMPLE) -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

	<!-- BOOTSTRAP CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

	<!-- MY OWN CSS -->
	<link rel="stylesheet" href="/css/style.css"/>

	<!-- FOR ANY BOOTSTRAP THAT USES JS OR jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/javascript/javascript.js" defer></script>
	<title>Registration Page</title>
</head>
<body>
	<div class="container border border-dark" >
		<h1 class="m-3 text-center" >Register</h1>
		<hr>
		<div class="d-flex flex-column justify-content-center align-items-center">
			<div class="d-flex flex-row justify-content-around w-50">
				<a href="/">Go Back</a>
			</div>
		</div>
		<hr>
		
	 	<div class="d-flex flex-column justify-content-center align-items-center mb-5">   

		    <form:form class="form-control w-75" method="POST" action="/registering" modelAttribute="user">
   		        <p class="mb-3 mt-t">
		            <form:label path="firstName">First Name: </form:label>
		            <form:errors class="text-danger" path="firstName"/>
		            <form:input class="form-control" type="text" placeholder="First Name" path="firstName"/>
		        </p>
		        
		       	<p class="mb-3 mt-t">
		            <form:label path="lastName">Last Name: </form:label>
		            <form:errors class="text-danger" path="lastName"/>
		            <form:input class="form-control" type="text" placeholder="Last Name" path="lastName"/>
		        </p>
		        <p class="mb-3 mt-t">
		            <form:label path="email">Email: </form:label>
		            <form:errors class="text-danger" path="email"/>
		            <form:input class="form-control" type="email" placeholder="Email" path="email"/>
		        </p>
		        <p class="mb-3 mt-t">
		            <form:label path="password">Password: </form:label>
		            <form:errors class="text-danger" path="password"/>
		            <form:password class="form-control" placeholder="Password" path="password"/>
		        </p>
		        <p class="mb-3 mt-t">
		            <form:label path="passwordConfirmation">Confirm Password: </form:label>
		            <form:errors class="text-danger" path="passwordConfirmation"/>
		            <form:password class="form-control" placeholder="Password" path="passwordConfirmation"/>
		        </p>
		        <input class="btns" type="submit" value="Register"/>
		    </form:form>
	     </div>
	</div>
</body>
</html>

<%-- 		    <p><form:errors path="user.*"/></p> --%>
		    
		    
		    
		    

