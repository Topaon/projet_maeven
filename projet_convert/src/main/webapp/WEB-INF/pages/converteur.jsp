<%@ page import="fr.inetum.tp.entites.Stagiaire" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Stagiaire user = (Stagiaire) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("login");
    }
%>
<%
System.out.println(request.getAttribute("probleme"));
%>
<!doctype html>
<html lang="fr">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/app.css">
<title>Login Page</title>
</head>
<body>
	<div class="content">
		<div class="header">projet converter</div>
		<div class="monForm shadow mt-5">
			<div class="titre bg-primary">login form</div>
			<form method="post">
				<div class="mb-3">
					<label for="login" class="form-label">Température</label> <input
						type="text" class="form-control" id="login" name="degre"
						placeholder="Saisir la température en degrés">
				</div>
				<div>
					<input type="submit" value="Valider" class="btn btn-primary" /> <input
						type="reset" value="Reset" class="btn btn-secondary float-end" />
				</div>
			</form>
			<%
			String prob = (String) request.getAttribute("probleme");
			if(prob == "oui") {%>
			<div style="color:white; background-color: red; width: 100%; text-align: center">Saisie incorrecte</div>	
			<%} else if(prob=="non") {%>
			<div style="color:white; background-color: green; width: 100%; text-align: center">Le résultat est : ${far } °F</div>	
			<%}%>
		</div>
	</div>
</body>
</html>
