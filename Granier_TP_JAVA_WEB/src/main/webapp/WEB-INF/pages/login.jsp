<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="fr">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link href="assets/css.css" rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<div class="main-div">
		<h1>TP Java/SQL</h1>
		<form method="post" class="login-form">
		  <div class="mb-3">
		    <label class="form-label">Adresse email</label>
		    <input type="text" class="form-control" placeholder="email"/>
		  </div>
		  <div class="mb-3">
		    <label class="form-label">Mot de passe</label>
		    <input type="password" class="form-control" placeholder="mot de passe"/>
		  </div>
		  <c:if test="${failed == 'oui' }">
			<p class="alert alert-danger" role="alert">Email ou mot de passe incorrect</p>
		  </c:if>
		  <div class="container-flex-end">
		    <button type="reset" class="btn btn-primary">Reset</button>
		    <button type="submit" class="btn btn-primary">Valider</button>
		  </div>
		</form>
	</div>
</body>
</html>