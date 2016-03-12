<%-- 
    Document   : KKCLDisplayBooks
    Created on : Feb 25, 2015, 12:39:29 PM
    Author     : clefebvre1-cc
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<!DOCTYPE HTML>
<html>
<jsp:include page="KKCLBanner.jsp" />
<head>
<title>Book listing</title>
<link type="text/css" href="styles/main.css" rel="stylesheet" />
</head>
<body>


<table border=1 bordercolor=black>
	<tr>
		<th>Code</th>
		<th>Description</th>
		<th>Quantity</th>
	</tr>
	
	<c:forEach var="book" items="${book}">
		<tr>
			<td>${book.code}</td>
			<td>${book.description}</td>
			<td>${book.quantity}</td>
		</tr>
	</c:forEach>
</table>
<button onclick="location.href='KKCLAddBook.jsp'">Add Book</button>
</body>
<jsp:include page="KKCLFooter.jsp" />
</html>