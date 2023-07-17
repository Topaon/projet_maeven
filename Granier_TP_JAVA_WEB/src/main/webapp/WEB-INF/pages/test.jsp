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
	<h1>Page de test</h1>
	<form method="post">
		<div >
			<label >test</label>
			<input type="text" name="mdp" value="${stagiaire.prenom }" placeholder="Saisir une valeur test">
		</div>
<!-- 		<div> -->
<!-- 			<input type="submit" value="Valider" /> -->
<!-- 			<input type="reset" value="Reset"/> -->
<!-- 		</div> -->
		<c:choose>
		<c:when test="${not empty stagiaire }">
			<button type="submit" name="action" value="modifier">Modifier</button>
		</c:when>
		<c:otherwise>
			<button type="submit">Valider</button>
		</c:otherwise>	
	</c:choose>	
	</form>
</body>
</html>