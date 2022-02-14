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
	<link rel="stylesheet" href="/css/snake_game_styles.css"/>

	<!-- FOR ANY BOOTSTRAP THAT USES JS OR jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/snake_game_js.js" defer></script>
	<title>Home</title>
</head>
<body>

    <div class="container">
        <h1 id="name" >Snake Game</h1>
        <canvas id="game" width="400" height="400"></canvas>
        <table class="table-bordered bg-light">
            <tr>
                <th>Name</th>
                <th># of Games</th>
                <th>Best</th>
            </tr>
            <tr>
                <td class="pad">${user.firstName}</td>
                <td class="pad" id="score" onload="postMyScore()"></td>
                <td class="pad" id="best" ></td>
            </tr>
            </table>
        <div class="optionsBar">
                <button class="btns" onclick="sendScore()">SendScore</button>
                <a class="btns" href="/home">Home</a>
                <a class="btns" href="/snakeGame">Start Over</a>
        </div>
    </div>

</body>
</html>