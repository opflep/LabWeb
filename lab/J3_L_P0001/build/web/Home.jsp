<%-- 
    Document   : Home
    Created on : May 17, 2018, 1:44:06 PM
    Author     : vietnkse04597
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/css.css">
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <br>
        <t:choose>
            <t:when test="${sessionScope.LoginUser == null}">
                <div>
                    <form action="DoLogin" method="post">

                        <table>

                            <tr>
                                <th colspan="2" class="HomeLoginDecoration">
                                    Login Form
                                </th>
                            </tr>
                            
                            <tr>
                                <th colspan="2">
                                    <br>
                                </th>
                            </tr>

                            <tr>
                                <td class="HomeTextDecoration"> User Name: </td>
                                <td>
                                    <input type="text" name ="txtUsername" value="${param.txtUsername}">
                                </td>                        
                            </tr>

                            <tr>
                                <td class="HomeTextDecoration"> Password: </td>
                                <td>
                                    <input type="password" name ="txtPassword" value="${param.txtPassword}">
                                </td>

                            </tr>

                            <tr>
                                <td></td>
                                <td class="HomeTextResult">
                                    ${LoginResult}
                                </td>

                            </tr>

                            <tr>
                                <td>
                                </td>
                                <td>
                                    <input type="submit" value="Sign in" name="btnSignin" />
                                    <a href="Registration.jsp" class="HomeTextDecoration"> Register </a>
                                </td>
                            </tr>

                        </table>
                    </form>
                </div>
            </t:when>
        </t:choose>
        <%@include file="Footer.jsp" %>
    </body>
</html>


