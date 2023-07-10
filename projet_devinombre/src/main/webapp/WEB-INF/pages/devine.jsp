<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Page deviner</h1>
	<div>Devinez le nombre ! Il est entre 1 et 10</div>
	<form method="post">
	<p>Réponse : </p><input name="reponse" type="text" placeholder="Entrer votre réponse ici"/>
	<input type="submit"/>
	<input type="reset"/>
	</form>
	<div>Essai N°${essai }</div>
</body>
</html>