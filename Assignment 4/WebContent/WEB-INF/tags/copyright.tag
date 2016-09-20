<%@tag import="helpers.RomanNumber"%>
<%@tag import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="since" required="true" type="Integer"%>

<%
 Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
%>

&#169; <%= RomanNumber.toRoman(since) %>-<%= RomanNumber.toRoman(currentYear) %> <jsp:doBody/>
