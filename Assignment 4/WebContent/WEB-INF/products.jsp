<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="T" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="includes/chooseLocale.html"%>

	<fmt:bundle basename="apptexts">
		<h2>
			<fmt:message key="products" />
		</h2>
		<c:forEach items="${products}" var="product">
		<h3>${product.pName}</h3>
		<img src="${product.imageFile}" alt="Coffe Cup" height="150" width="150">
			<p>
				<fmt:message key="name" /> : ${product.pName} </br>
				<fmt:message key="price" /> : <fmt:formatNumber value="${product.priceInEuro}" type="currency"/></p> </br>
				<c:forEach items="${product.descriptions}" var="description">

					<c:if test="${description.langCode == pageContext.response.locale}">
					<fmt:message key="description" /> : ${description.text}
					</c:if>

				</c:forEach>
			</p>
		</c:forEach>

	</fmt:bundle>

	<T:copyright since="2008">Høgskolen i Bergen</T:copyright>
</body>
</html>