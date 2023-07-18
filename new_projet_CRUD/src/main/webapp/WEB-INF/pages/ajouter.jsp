<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajout d'un nouveau stagiaire</h1>
	<p>Modification du stagiaire N° : ${stagiaire.id }</p>
	<form method="post">
	<p><input type="hidden" name ="id" value="${stagiaire.id }"/></p>
	<p><input type="text" name ="prenom" placeholder="Votre prénom" value="5"/></p>
	<p><input type="text" name ="email" placeholder="Votre adresse mail" value="${stagiaire.email }"/></p>
	<p><input type="text" name ="mdp" placeholder="Votre mot de passe" value="${stagiaire.mdp }"/></p>
	<p><input type="date" name ="ddn" placeholder="Votre date de naissance" value="${stagiaire.ddn }"/></p>
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