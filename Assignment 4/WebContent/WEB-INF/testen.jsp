<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="T" tagdir="/WEB-INF/tags" %>
<fmt:setLocale
scope="session"
value="de"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>tjohuå</h2>
<fmt:bundle basename="apptexts">
	<fmt:message key="Apple"/>
</fmt:bundle>
<p>
<T:copyright since="2008">HiB</T:copyright>
</p>
</body>
</html>