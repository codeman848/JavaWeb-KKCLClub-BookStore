<%-- 
    Document   : KKCLRegister
    Created on : Jan 29, 2015, 11:41:30 AM
    Author     : clefebvre1-cc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="KKCLBanner.jsp" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KKCL Programming Club</title>
        <link type="text/css" href="styles/main.css" rel="stylesheet" />
    </head>
    <body>
            <h4><b>New Member Registration Form</b></h4>
            <br/>
            <form action="KKCLDisplayMember.jsp" method="post">
                <label for="name">Full Name: <input type="text" required style ="width:200px; margin-left:50px;margin-bottom:2px; " name="name" param="name"/></label><br/>
                <label for="email">Email: <input type="text" required style ="width:300px; margin-left:81px; margin-bottom:2px;" name="email" /></label><br/>
                <label for="phone">phone:<input type="text" style ="width:100px; margin-left:82px; margin-bottom:2px;" name="phone" /></label><br/>
                <label for="it">IT Program:<select name="program" style="margin-left: 45px; margin-bottom:2px;">
                                                  <option value="CPA">CPA</option>
                                                  <option value="CP">CP</option>
                                                  <option value="ITSS">ITSS</option>
                                                  <option value="ITID">ITID</option>
                                           </select>
                    <br/>
                <label for="it">Year Level:<select name="year" style="margin-left: 52px;">
                                                  <option value="1">1</option>
                                                  <option value="2">2</option>
                                                  <option value="3">3</option>
                                                  <option value="4">4</option>
                                           </select>
                    <br/>
                    <br/>
                    <button type="Submit">Register</button>
                    <button type="reset">Reset</button>
                    <br/><br/>
                </form>
    </body>
    <jsp:include page="KKCLFooter.jsp" />
</html>
