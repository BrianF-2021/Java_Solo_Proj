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
		<h1 class="m-3 text-center" >Login</h1>
		<hr>
		<div class="d-flex flex-column justify-content-center align-items-center">
			<div class="d-flex flex-row justify-content-around w-50">
				<a href="/">Go Back</a>
			</div>
		</div>
		<hr>
		
		<div class="d-flex flex-column justify-content-center align-items-center mb-5">
		    <p class="text-danger" ><c:out value="${loginError}" /></p>
		    <form class="form-control w-75" method="post" action="/loggingIn">
		        <p class="mb-3 mt-t">
		            <label for="email">Email: </label>
		            <input class="form-control" placeholder="Email" type="text" id="email" name="email"/>
		        </p>
		        <p class="mb-3 mt-t">
		            <label for="password">Password: </label>
		            <input class="form-control" placeholder="Password" type="password" id="password" name="password"/>
		        </p>
		        <input class="btns" type="submit" value="Login"/>
		    </form>    
	    </div>
    </div>
</body>
</html>