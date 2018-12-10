<%-- 
    Document   : Header
    Created on : May 17, 2018, 1:44:17 PM
    Author     : vietnkse04597
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="css/css.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <img class="HeaderTopImage" src="./img/top.png" />
        <img class="HeaderUnTopImage" src="./img/top_box.png" />
        <img class="HeaderLeftImage" src="./img/bg.jpg" />
        <img class="HeaderRightImage" src="./img/bg.jpg" />
        
        <ul class="HeaderUl">
            <li> <a href="Home.jsp" > Home </a> </li>
            <li> <a href="TakeQuiz.jsp"> Take Quiz </a> </li>
            <li> <a href="MakeQuiz.jsp"> Make Quiz </a> </li>
            <li> <a href="/J3_L_P0001/DoManagerQuiz"> Manager Quiz </a> </li>
                <t:choose>
                    <t:when test="${sessionScope.LoginUser != null}" >
                    <li> <a href="/J3_L_P0001/DoLogout"> Log out </a> </li>
                    </t:when>
                </t:choose>
        </ul>

    </body>
</html>
