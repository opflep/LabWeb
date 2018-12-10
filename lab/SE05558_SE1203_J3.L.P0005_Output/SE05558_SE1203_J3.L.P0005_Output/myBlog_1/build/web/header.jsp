<%-- 
    Document   : header
    Created on : Jun 13, 2018, 4:24:00 PM
    Author     : dungndse05558
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    
    <body>
        <div class ="top-page">
            <p class ="top-page">my blogs</p>
        </div>
        
        <div id ="idmenu-bar">
            <ul class ="menu-bar">
                <c:set var="temp1" value="${requestScope.page}"></c:set>
                <c:choose>
                    <c:when test="${temp1 =='Home'}">
                        <li class ="menu-bar active"><a href="home" class ="menu-bar">Home</a></li>
                        <li class ="menu-bar"><a href="contact" class ="menu-bar">Contact</a></li>
                    </c:when>
                    <c:when test="${temp1 =='Contact'}">
                        <li class ="menu-bar"><a href="home" class ="menu-bar">Home</a></li>
                        <li class ="menu-bar active"><a href="contact" class ="menu-bar">Contact</a></li>
                    </c:when>
                        <c:when test="${temp1 ==''}">
                        <li class ="menu-bar"><a href="home" class ="menu-bar">Home</a></li>
                        <li class ="menu-bar"><a href="contact" class ="menu-bar">Contact</a></li>
                    </c:when>
                       
                    <c:when test="${temp1 ==null}">
                        <li class ="menu-bar"><a href="home" class ="menu-bar">Home</a></li>
                        <li class ="menu-bar"><a href="contact" class ="menu-bar">Contact</a></li>
                    </c:when>
                        
                </c:choose>
                
            </ul>
            
        </div>
    </body>
</html>
