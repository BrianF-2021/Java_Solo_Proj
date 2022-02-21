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
	<script type="text/javascript" src="/js/uploader.js" defer></script>
	<title>Edit User</title>
</head>
<body class="bg-dark">
	<div class="d-flex flex-column w-100 bg-dark text-light">
		<hr>
		<h1 class="m-3 text-center text-grad" >Edit Profile</h1>
		<hr>
		<div class="container border border-dark" >
			<div class="d-flex flex-row justify-content-center">
	<!-- 			<div class="d-flex flex-row justify-content-around width30"> -->
	<%-- 				<p class="text-left width70">Welcome ${user.firstName} ${user.lastName}</p> --%>
	<!-- 				<a href="/edit/user">Edit Profile</a> -->
	<!-- 			</div> -->
				<div class="w-75">
					<p class="text-left width70">${user.firstName} ${user.lastName}</p>
				</div>
					
	<!-- 			<div class="d-flex flex-row justify-content-around width30"> -->
				<div class="d-flex flex-row justify-content-between w-25 me-3">
					<a class="txtDecoration" href="/home">Home</a>
					<a class="txtDecoration" href="/add/algo">Add Algo</a>
					<a class="txtDecoration" href="/logout">Logout - (${user.firstName} ${user.lastName})</a>
				</div>
			</div>
		
<!-- 			<div class="d-flex flex-row justify-content-between"> -->
<!-- 				<a href="/home">Home</a> -->
<%-- 				<a href="/logout">Logout <span>- (${user.firstName} ${user.lastName}) </span></a> --%>
<!-- 			</div> -->
			<hr>
			<h1 class="mb-3 text-left" >Edit</h1>
		 	<div class="d-flex flex-column mb-5">   
	
			    <form:form class="form-control w-75" method="POST" action="/editing/user/${user.id}" modelAttribute="user">
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
			            <form:password class="form-control" placeholder="Password" path="password" value="${user.password}"/>
			        </p>
			        <p class="mb-3 mt-t">
			            <form:label path="passwordConfirmation">Confirm Password: </form:label>
			            <form:errors class="text-danger" path="passwordConfirmation"/>
			            <form:password class="form-control" placeholder="Password" path="passwordConfirmation" value="${user.password}"/>
			        </p>
			        <div class="d-flex flex-row justify-content-around m-3">
				        <input class="btns" type="submit" value="Submit"/>
				        <a class="btns" href="/home">Cancel</a>
				    </div>
			    </form:form>
		     </div>	
      		<div class="mb-3 mt-3 w-75">
      			 <form:form action="/add/picture/${user.id}" enctype="multipart/form-data" method="POST" modelAttribute="user">
	 				<form:hidden path="firstName" value="${user.firstName}"/>
	 				<form:hidden path="lastName" value="${user.lastName}"/>
	 				<form:hidden path="email" value="${user.email}"/>
	 				<form:hidden path="password" value="${user.password}"/>
	 				<h2>Add Profile Picture</h2>
	 				<img id="thumbnail" alt="Image Preview" />
	 				<form:label path="picture">Picture</form:label>
		            <form:errors class="text-light" path="picture"/>
	 				<form:input path="picture" type="file" name="picture" id="picture" accept="image/png, image/jpeg" placeholder="Browse Folders"/>
					<button id="upload-button">Upload</button>
				</form:form>
        	</div>		
    	</div>

    </div>
</body>
</html>
<!-- Try option A -->
<%--       			 <form:form action="/add/picture/${user.id}" enctype="multipart/form-data" method="POST" modelAttribute="user"> --%>
<%-- 	 				<form:hidden path="firstName" value="${user.firstName}"/> --%>
<%-- 	 				<form:hidden path="lastName" value="${user.lastName}"/> --%>
<%-- 	 				<form:hidden path="email" value="${user.email}"/> --%>
<%-- 	 				<form:hidden path="password" value="${user.password}"/> --%>
<!-- 	 				<h2>Add Profile Picture</h2> -->
<!-- 	 				<img id="thumbnail" alt="Image Preview" /> -->
<%-- 	 				<form:label path="picture">Picture</form:label> --%>
<%-- 		            <form:errors class="text-light" path="picture"/> --%>
<%-- 	 				<form:input path="picture" type="file" name="picture" id="picture" accept="image/png, image/jpeg" placeholder="Browse Folders"/> --%>
<!-- 					<button id="upload-button">Upload</button> -->
<%-- 				</form:form> --%>






<!-- 	 				<h2>Add Profile Picture</h2> -->
<!-- 	 				<img id="thumbnail" alt="Image Preview" /> -->
<!-- 	 				<input type="file" name="fileupload" id="fileupload" /> -->
<!-- 					<button id="upload-button" onclick="uploadFile()">Upload</button> -->


<%-- 	 			<form:form action="/add/picture" enctype="multipart/form-data" method="POST" modelAttribute="user"> --%>
<%-- 	 				<form:hidden path="firstName" value="${user.firstName}"/> --%>
<%-- 	 				<form:hidden path="email" value="${user.email}"/> --%>
<%-- 	 				<form:hidden path="password" value="${user.password}"/> --%>
<!-- 	 				<h2>Add Profile Picture</h2> -->
<!-- 	 				<img id="thumbnail" alt="Image Preview" /> -->
<!-- 	 				<input type="file" name="fileupload" id="fileupload" accept="image/png, image/jpeg" placeholder="Browse Folders"/> -->
<!-- 					<button id="upload-button" onclick="uploadFile()">Upload</button> -->
<%-- 				</form:form> --%>

<%-- <c:out value="${user.email}"></c:out> --%>

