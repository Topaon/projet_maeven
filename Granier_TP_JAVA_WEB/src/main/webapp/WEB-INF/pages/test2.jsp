<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/app.css">
<title>Test</title>
</head>
<body>
	<h1>Test 2</h1>
	<p></p>
	<form method="post">
		<div >
		<p>${parametreTest }</p>
		<p>${attributTest }</p>
			<label >test</label>
			<input type="text" name="jose" placeholder="Saisir une valeur pour tester la portée de request.getParameter">
		</div>
		<button type="submit">Valider</button>
	</form>
	<a href="test3">Lien vers la page test3.jsp</a>
</body>
</html>