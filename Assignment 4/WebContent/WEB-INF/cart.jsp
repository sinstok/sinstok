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
		<table border="1px">
			<tr>
				<th>Name</th>
				<th>Short Description</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Total</th>
			</tr>
			<c:forEach items="${cart.cartItems}" var="cartItem">
				<tr>
					<td>${cartItem.product.pName}</td>
					<c:forEach items="${cartItem.product.descriptions}"
						var="description">
						<c:if
							test="${description.langCode == pageContext.response.locale}">
							<td><fmt:message key="description" /> : ${description.text}</td>
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
				<td>Total amount</td>
				<td><fmt:formatNumber value="${cart.total}" type="currency" /></td>
			</tr>
		</table>
	</fmt:bundle>
	<p>
	<a href="products">Tilbake</a>
	<a href="home">Hjem</a>
	</p>
</body>
</html>