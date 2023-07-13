<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Liste des stagiaires</h1>
	<a href="ajouter">Ajouter un Stagiaire</a>
	<table>
		<thead>
			<tr>
				<td>Photo</td>
				<td>Id</td>
				<td>Prenom</td>
				<td>email</td>
				<td>Mot de passe</td>
				<td>Date de naissance</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${listeStagiaires }">
				<tr>
					<td><img src=${s.photo } height="50px" width="auto"/></td>
					<td>${s.id }</td>
					<td>${s.prenom }</td>
					<td>${s.email }</td>
					<td>${s.mdp }</td>
					<td>${s.ddn }</td>
					<td><a href="liste?idsup=${s.id }">Supprimer</a></td>
					<td><a href="ajouter?id=${s.id }&prenom=${s.prenom}&mdp=${s.mdp}&email=${s.email}&ddn=${s.ddn}">Modifier</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>