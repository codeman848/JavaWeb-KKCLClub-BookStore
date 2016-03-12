<%-- 
    Document   : KKCLELoan
    Created on : Mar 6, 2015, 9:58:24 AM
    Author     : Cody-Ray

    Revision History:
        Cody Lefebvre:03.6.2015:created
        Cody Lefebvre:03.20.2015:created foreach loop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ELoan</title>
    </head>
    <header>
        <jsp:include page="KKCLBanner.jsp" />
    </header>
    <body>
        <h1>ELoan</h1>
            <table border=1 bordercolor=black>
                <tr>
                    <th>Code</th>
                    <th>Description</th>
                    <th>QOH</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="loanItem" items="${loanItem}">
                <tr>
                    <td>${loanItem.code}</td>
                    <td>${loanItem.description}</td>
                    <td>${loanItem.quantity}</td>
                    <td> <c:if test="${loanItem.quantity <= 0}">
                        <c:out value="N/A"></c:out></c:if>
                    <c:if test="${loanItem.quantity > 0}">
                        <c:out value=""></c:out>
                    <a href="<c:url value=
                           "/KKCLCart?code=${loanItem.code}&action=reserve"/>
                       ">Reserve</a></c:if></td>
                </tr>
                </c:forEach>
            </table>
    </body>
    <footer>
        <jsp:include page="KKCLFooter.jsp" />
    </footer>
</html>
