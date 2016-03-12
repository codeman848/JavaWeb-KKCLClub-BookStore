<%-- 
    Document   : KKCLDisplayBooks
    Created on : Feb 25, 2015, 12:39:29 PM
    Author     : clefebvre1-cc
--%>

<!DOCTYPE HTML>
<html>
    <jsp:include page="KKCLBanner.jsp" />
<head>
<title>Add Book</title>
<link type="text/css" href="styles/main.css" rel="stylesheet" />
</head>
<body>
    <h1>Add a Book</h1>
    <b><font color="Red">${error}</font></b>
    <form method="post" action="KKCLAddBook">
        <table>
	<tr>
            <td>Code:</td>
            <td><input type="text" name="code" id="code" value="${book.code}"></td>     
	</tr>
	<tr>
            <td>Description:</td>
            <td><input type="text" name="description" id="description" value="${book.description}"></td>
	</tr>
        <tr>
            <td>Quantity:</td>
            <td><input type="text" name="quantity" id="quantity" value="${book.quantity}"</td>          
        </tr>
            <td></td>
            <td>
                <input type="submit" value="Save">&nbsp
                <input type="button" value="Cancel" ONCLICK="location.href='KKCLDisplayBooks'"/>
            </td>
        </table>
    </form>
</body>
<jsp:include page="KKCLFooter.jsp" />
</html>