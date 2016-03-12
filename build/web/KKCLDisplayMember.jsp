<%-- 
    Document   : KKCLDisplayMember
    Created on : Jan 29, 2015, 8:39:46 PM
    Author     : Cody-Ray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" href="styles/main.css" rel="stylesheet" />
    </head>
    <jsp:include page="KKCLBanner.jsp" />
    <body>
            <h1>Thanks for joining our club!</h1>
            <br/>
            <p>Here is the information you entered:</p>
            <h5 style="display:inline;">Full Name:</h5><p style ="margin-left:50px; display:inline;">${param.name}</p><br/>
            <h5 style="display:inline;">Email:</h5><p style ="margin-left:80px; display:inline;">${param.email}</p><br/>
            <h5 style="display:inline;">Phone:</h5><p style ="margin-left:75px; display:inline;">${param.phone}</p><br/>
            <h5 style="display:inline;">IT Program:</h5><p style ="margin-left:41px; display:inline;">${param.program}</p><br/>
            <h5 style="display:inline;">Year Level:</h5><p style ="margin-left:44px; display:inline;">${param.year}</p><br/>
            <br/>
            <p>To register another member, click on the back button in your browser or the return button below</p>
            </br>
            <form action="KKCLRegister.jsp">
                <button type="submit">Return</button>
            </form>
            </br>
    </body>
    <jsp:include page="KKCLFooter.jsp" />
</html>
