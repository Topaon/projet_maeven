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
	<h1>Affichage du r�sultat</h1>
	<c:if test="${empty user }">
		
	</c:if>
	<%
	if(session.getAttribute("gagne") == "oui") {%>
	<p>F�licitation, vous avez gagn� !</p>
	<%} else {%>
	<p>Dommage, r�essayez</p>
	<%} %>
	<p>Premi�re r�ponse : ${reponse1 }</p>
	<p>Deuxi�me r�ponse : ${reponse2 }</p>
	<p>Troisi�me r�ponse : ${reponse3 }</p>
	<p>La solution �tait ${solution }</p>
	<form method="post">
		<button>Recommencer</button>
	</form>
</body>
</html>