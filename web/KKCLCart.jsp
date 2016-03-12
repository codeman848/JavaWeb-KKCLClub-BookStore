<%-- 
    Document   : KKCLCart
    Created on : Mar 19, 2015, 1:35:30 PM
    Author     : clefebvre1-cc

    Revision History:
        Cody Lefebvre:03.19.2015:created
        Cody Lefebvre:03.20.2015:created foreach loop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KKCLCart</title>
    </head>
    <jsp:include page="KKCLBanner.jsp" />
    <body>
        <h1>Your Loan Cart</h1>
        <table border=1 bordercolor=black>
            <tr>
                <th>Code</th>
                <th>Description</td>
                <th>Quantity</th>  
            </tr>
            <c:set var="total" value="${0}"></c:set>
            <c:forEach var="cart" items="${cart.items}">
            <tr>
                <td>${cart.code}</td>
                <td>${cart.description}</td>
                <td>${cart.quantity}</td>
            </tr>
            <c:set var="total" value="${total + cart.quantity}"></c:set>
            </c:forEach>
        </table>
        <p>total is ${total}</p>
        <br/>
        <br/>
        <a href="KKCLClearCart">Clear the Cart</a><br/>
        <a href="KKCLELoan">Return to eLoan</a>
    </body>
    <footer>
        <jsp:include page="KKCLFooter.jsp" />
    </footer>
</html>
