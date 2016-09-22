<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ct" uri="CoffeeTags"%>
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
		<table border="1px">
			<tr>
				<th><fmt:message key="Name"/></th>
				<th><fmt:message key="ShortDescription"/></th>
				<th><fmt:message key="Price"/></th>
				<th><fmt:message key="Quantity"/></th>
				<th><fmt:message key="Total"/></th>
			</tr>
			<c:forEach items="${cart.cartItems}" var="cartItem">
				<tr>
					<td>${cartItem.product.pName}</td>
					<c:forEach items="${cartItem.product.descriptions}"
						var="description">
						<c:if
							test="${description.langCode == pageContext.response.locale}">
							<td><ct:shorttext maxchars="20">${description.text}</ct:shorttext></td>
						</c:if>

					</c:forEach>
					<td><fmt:formatNumber value="${cartItem.product.priceInEuro}"
							type="currency" /></td>
					<td>${cartItem.quantity}</td>
					<td><fmt:formatNumber value="${cartItem.total}"
							type="currency" /></td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="4"><fmt:message key="TotalAmount"/></td>
				<td><fmt:formatNumber value="${cart.total}" type="currency" /></td>
			</tr>
		</table>
	<p>
	<a href="home"><fmt:message key="Home" /></a>
	<a href="products"><fmt:message key="Products" /></a>
	</p>
	</fmt:bundle>
</body>
</html>