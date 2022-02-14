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
	<script type="text/javascript" src="/js/javascript.js" defer></script>
	<title>Home</title>
</head>
<body class="bg-secondary">
	<div class="package border border-light bg-dark text-light">
		<h1 class="m-3 text-center" >The Interview Algo</h1>
		<hr>
		<div class="d-flex flex-row justify-content-center">
				<p class="text-left width70">Welcome ${user.firstName} ${user.lastName}</p>
				<div class="d-flex flex-row justify-content-around width30">
					<a href="/snakeGame">Snake Game</a>
					<a href="/add/algo">Add Algo</a>
					<a href="/logout">Logout - (${user.firstName} ${user.lastName})</a>
				</div>
		</div>
		<hr>
		
				<div class="container mt-3 pb-3"> 
		  <h2 class="text-center">Algos</h2>         
		  <table class="table table-striped overFlowScroll border">
			<thead>
			  <tr class="text-light bg-secondary">
			    <th>Algo</th>
			    <th>Description</th>
			    <th>Likes</th>
			    <th>Action</th>
			  </tr>
			</thead>
			<tbody>
			
				<c:forEach  items="${algos}" var="algo">
				  <tr class="text-light">
				  	<td> <a href="/algo/details/${algo.id}"> ${algo.name}</a> </td>
				    <td>${algo.description}</td>
				    <td>${algo.likers.size()}</td>
				    <td>
				    	<c:choose>
				    	<c:when test="${algo.likers.contains(user)}">
				    		<a href="/unlike/${algo.id}">Unlike</a>
				    	</c:when>
				    	<c:otherwise>
				    		<a href="/like/${algo.id}">Like</a>
				    	</c:otherwise>
				    	</c:choose>
				    </td>
				  </tr>
				</c:forEach>
			</tbody>
		  </table>

		</div>

	</div>
</body>
</html>


