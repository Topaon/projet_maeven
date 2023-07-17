<%@ page import="fr.inetum.tp.entites.Stagiaire" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
</head>
<body>
	<h1>Ajout d'un nouveau stagiaire</h1>
	<c:if test="${not empty stagiaireAdd }">
		<p>Modification du stagiaire N° : ${stagiaireAdd.id }</p>
	</c:if>
	<form method="post">
	<p><input type="hidden" name ="idNew" value="${stagiaireAdd.id }"/></p>
	<p><input type="text" name ="prenomNew" placeholder="Votre prénom" value="${stagiaireAdd.prenom }"/></p>
	<p><input type="text" name ="emailNew" placeholder="Votre adresse mail" value="${stagiaireAdd.email }"/></p>
	<p><input type="text" name ="mdpNew" placeholder="Votre mot de passe" value="${stagiaireAdd.mdp }"></p>
	<p><input type="date" name ="ddnNew" placeholder="Votre date de naissance" value="${stagiaireAdd.ddn }"/></p>
	<p><input type="text" name ="roleNew" placeholder="Rôle" value="${stagiaireAdd.role }"/></p>
	<p><input type="text" name ="nomVoieNew" placeholder="Voie" value="${stagiaireAdd.adresse.nomVoie }"/></p>
	<p><input type="text" name ="codePostalNew" placeholder="Code postal" value="${stagiaireAdd.adresse.codePostal }"/></p>
	<p><input type="text" name ="villeNew" placeholder="Ville" value="${stagiaireAdd.adresse.ville }"/></p>
	<c:choose>
		<c:when test="${not empty stagiaireAdd }">
			<button type="submit" name="action" value="modifier">Modifier</button>
		</c:when>
		<c:otherwise>
			<button type="submit">Valider</button>
		</c:otherwise>	
	</c:choose>	
	</form>
</body>
</html>