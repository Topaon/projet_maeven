<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
	<h:form>
	<h:messages /> <!-- affiche d'�ventuels messages d'erreur -->
		<label>x : </label><h:inputText value="#{calcul.x }" />
		<h:commandButton value="calcul de la racine carr�e" action="#{calcul.calculerRacineCarre }" />
	</h:form>
	<hr/>
	
	resultat : <h:outputText value="#{calcul.res }" />
	
</f:view>
</body>
</html>