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
	<title>Home</title>
</head>
<body>
	<div class="container border border-dark">
		<h1 class="m-3 text-center" >Welcome ${user.firstName} ${user.lastName}</h1>
		<hr>
		<div class="d-flex flex-column justify-content-center align-items-center">
			<div class="d-flex flex-row justify-content-around w-50">
				<a href="/logout">Logout - (${user.firstName} ${user.lastName})</a>
			</div>
		</div>
		<hr>
<%-- 		<c:set var="sum" val="${0}"/> --%>
<%-- 		<c:forEach begin="0" end="${show.ratings.size()} varStatus="${i}"> --%>
<!-- 			< -->
		
		
<%-- 		</c:forEach> --%>
			
<%-- 		<c:forEach items="${show.ratings}" var="rate"> --%>
<%-- 			<c:set var="sum" val="${sum += rate.rating}" --%>
		
<%-- 		</c:forEach> --%>
		
		
		
		
		<div class="container mt-3 pb-3"> 
		  <h2>Ideas</h2>         
		  <table class="table table-striped overFlowScroll">
			<thead>
			  <tr>
			    <th>Show</th>
			    <th>Network</th>
			    <th>Average Rating</th>
			    <th>Likes</th>
			    <th>Action</th>
			  </tr>
			</thead>
			<tbody>
			
<%-- 				<c:forEach items="${shows}" var="show"> --%>
				<c:forEach begin="0" end="${shows.size()-1}" var="i"> 
				  <tr>
				  	<td> <a href="/show/details/${shows[i].id}"> ${shows[i].title}</a> </td>
				    <td>${shows[i].network}</td>
<%-- 				    <td> <a href="/show/details/${show.id}"> ${show.title}</a> </td> --%>
<%-- 				    <td>${show.network}</td> --%>
				    <td> <p> 
				    	${avgs[i]}
<%-- 				    	<c:forEach begin="0" end="${shows[i].ratings.size()}" varStatus="j">  --%>
<%-- 				    		${avgs[i]} --%>
<%-- 				    	</c:forEach> --%>
				     </p> </td>
				    <td>${shows[i].likers.size()}</td>
				    <td>
				    	<c:choose>
				    	<c:when test="${shows[i].likers.contains(user)}">
				    		<a href="/unlike/${shows[i].id}">Unlike</a>
				    	</c:when>
				    	<c:otherwise>
				    		<a href="/like/${shows[i].id}">Like</a>
				    	</c:otherwise>
				    	</c:choose>
<%-- 				    	<c:choose> --%>
<%-- 				    	<c:when test="${show.likers.contains(user)}"> --%>
<%-- 				    		<a href="/unlike/${show.id}">Unlike</a> --%>
<%-- 				    	</c:when> --%>
<%-- 				    	<c:otherwise> --%>
<%-- 				    		<a href="/like/${show.id}">Like</a> --%>
<%-- 				    	</c:otherwise> --%>
<%-- 				    	</c:choose> --%>
				    </td>
				  </tr>
				</c:forEach>
			</tbody>
		  </table>
		  <a class="btns bgGrey" href="/create/show">Add Show</a>
		</div>
	</div>
</body>
</html>

<%-- <c:out value="${user.email}"></c:out> --%>