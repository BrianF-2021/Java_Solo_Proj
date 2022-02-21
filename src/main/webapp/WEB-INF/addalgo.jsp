<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!-- Formatting (dates) --> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- FOR Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" >
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/style.css">
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/javascript/javascript.js" defer></script>

	<title>Add Algo</title>
</head>
<body class="bg-dark">
	<div class="container border text-light border bg-dark p-3">
		<h1 class="m-3 text-center text-grad" >Add an Algo</h1>
		<hr>
		<div class="d-flex flex-row justify-content-center">
			<div class="ms-3 w-75">
				<p class="text-left width70">${user.firstName} ${user.lastName}</p>
			</div>
			<div class="d-flex flex-row justify-content-between w-25 me-3">
				<a class="txtDecoration" href="/home">Home</a>
				<a class="txtDecoration" href="/edit/user">Edit Profile</a>
				<a class="txtDecoration" href="/logout">Logout - (${user.firstName} ${user.lastName})</a>
			</div>
		</div>
		<hr>
		<div class="d-flex flex-column justify-content-center align-items-center p-3">
			<h2 class="text-center" > ~ <span class="text-center bold">New Algo</span> ~ </h2>
			<form:form action="/adding/algo/${algo.id}" method="POST" modelAttribute="algo">
				<p class="d-flex flex-column">
					<form:label class="color-bl label txt-underline" path="name">Name: </form:label>
					<form:errors class="text-danger" path="name"/>
					<form:textarea class="commentbox color-gr ms-3 bg-dark border border-light" type="text" path="name"/>
				</p>
				<p class="d-flex flex-column">
					<form:label class="color-bl label txt-underline" path="description">Description: </form:label>
					<form:errors class="text-danger" path="description"/>
					<form:textarea class="commentbox color-gr ms-3 bg-dark border border-light" type="text" path="description"/>
				</p>
				<p class="d-flex flex-column">
					<form:label class="color-bl label txt-underline" path="solution">Solution: </form:label>
					<form:errors class="text-danger" path="solution"/>
					<form:textarea class="commentbox color-gr ms-3 bg-dark border border-light" type="text" path="solution"/>
				</p>
				<div class="d-flex flex-row justify-content-around m-3">
					<form:hidden path="user" value="${user.id}"/>
					<input class="btns" type="submit" value="Submit"/>
					<a class="btns"  href="/home">Cancel</a>
				</div>
			</form:form>
		</div>
	</div>


</body>
</html>

<%-- 			<form:hidden path="user" value="${user}"/> --%>