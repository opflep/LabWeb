<%-- 
    Document   : Registration
    Created on : May 22, 2018, 1:13:23 PM
    Author     : vietnkse04597
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/css.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>

        <div class="RegistrationForm">
            Registration form
        </div>
        <br> <br>

        <div>    
            <form action ="DoRegistration" method="post">
                <table>
                    <tr>
                        <td class="RegistrationTable"> User Name: </td>
                        <td>  
                            <input type="textbox" name="txtUsername" value="${param.txtUsername}"/>
                        </td>
                    </tr>

                    <tr>
                        <td class="RegistrationTable"> Password: </td>
                        <td> <input type="password" name="txtPassword" /> </td>
                    </tr>

                    <tr>
                        <td class="RegistrationTable"> User Type: </td>
                        <td> 
                            <select name="selectUserType" >
                                <option value="teacher" > teacher</option>
                                <option value="student" > student</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td class="RegistrationTable"> Email: </td>
                        <td> <input type="textbox" name="txtEmail" value="${param.txtEmail}" /> </td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td> ${sessionScope.RegistrationResult} </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td> <input type="submit" value="Register" name="btnRegister" /> </td>
                    </tr>

                </table>
            </form>
        </div>

    </body>
</html>
