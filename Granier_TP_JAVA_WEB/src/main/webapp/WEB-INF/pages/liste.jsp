<%@ page import="fr.inetum.tp.entites.Stagiaire" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Stagiaire user = (Stagiaire) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("login");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link href="assets/css.css" rel="stylesheet">
</head>
<body style="background-color: rd">
	<p class="list-title">Liste des stagiaires</p>
	<div id="list-head-container" class="container-flex-end">
		<a id="list-btn-add" class="btn btn-primary" href="ajouter">
			<svg xmlns="http://www.w3.org/2000/svg" width="25" height="30" fill="currentColor" class="bi bi-person-fill-add" viewBox="0 0 16 16">
				<path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7Zm.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0Zm-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z"/>
				<path d="M2 13c0 1 1 1 1 1h5.256A4.493 4.493 0 0 1 8 12.5a4.49 4.49 0 0 1 1.544-3.393C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4Z"/>
			</svg>
		</a>
		<a id="list-btn-disconnect" class="btn btn-secondary" href="login">
			<svg xmlns="http://www.w3.org/2000/svg" width="25" height="30" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
			  <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"/>
			  <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
			</svg>
		</a>
	</div>
	<div class="liste-main-div">
		<table class="table table-striped">
			<thead>
				<tr class="row-head">
					<td>Id</td>
					<td>Prenom</td>
					<td>email</td>
					<td>Mot de passe</td>
					<td>Voie</td>
					<td>Ville</td>
					<td>Date de naissance</td>
					<td>Rôle</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${listeStagiaires }">
					<tr>
						<td>${s.id }</td>
						<td>${s.prenom }</td>
						<td>${s.email }</td>
						<td>${s.mdp }</td>
						<td>${s.adresse.nomVoie }</td>
						<td>${s.adresse.ville }</td>
						<td>${s.ddn }</td>
						<td>${s.role }</td>
						<td>
							<a class="btn btn-danger" href="liste?idsup=${s.id }">Supprimer</a>
							<a class="btn btn-warning" href="ajouter?id=${s.id }&prenom=${s.prenom}&mdp=${s.mdp}&email=${s.email}&ddn=${s.ddn}&adresseId=${s.adresse.id}&role=${s.role}">Modifier</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>