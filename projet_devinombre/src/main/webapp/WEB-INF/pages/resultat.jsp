<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <%@ taglib prefixe="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Affichage du résultat</h1>
	<c:if test="${empty user }">
		
	</c:if>
	<%
	if(session.getAttribute("gagne") == "oui") {%>
	<p>Félicitation, vous avez gagné !</p>
	<%} else {%>
	<p>Dommage, réessayez</p>
	<%} %>
	<p>Première réponse : ${reponse1 }</p>
	<p>Deuxième réponse : ${reponse2 }</p>
	<p>Troisième réponse : ${reponse3 }</p>
	<p>La solution était ${solution }</p>
	<form method="post">
		<button>Recommencer</button>
	</form>
</body>
</html>