<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="T" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="includes/chooseLocale.html"%>

	<h3>Kaffekopper AS</h3>
	<fmt:bundle basename="apptexts">
		<p>
			<fmt:message key="HaveALookAtOurWonderful" />
			<a href="products"><fmt:message key="products" /></a>
		</p>
	</fmt:bundle>
	<T:copyright since="2008">Høgskolen i Bergen</T:copyright>
</body>
</html>