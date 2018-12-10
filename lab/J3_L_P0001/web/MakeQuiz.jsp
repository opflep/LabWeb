<%-- 
    Document   : MakeQuiz
    Created on : May 17, 2018, 1:44:58 PM
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

        <form action="DoMakeQuiz" method="post">
            <table class="MakeQuizTable">
                <tr>
                    <td>
                        Question:
                    </td>
                    <td >
                        <textarea class="MakeQuizTextareaOfQuestion" name="txtAreaQuestion">
                        
                        </textarea>
                    </td>

                </tr>

                <t:forEach var="r" begin="1" end="4">
                    <tr>
                        <td> Option ${r}: </td>
                        <td> 
                            <textarea class="MakeQuizTextareaOfOption" name="txtArea${r}">
                        
                            </textarea> 
                        </td>
                    </tr>
                </t:forEach>

                <tr>

                    <td>
                        Answer(s): 
                    </td>

                    <td>
                        <t:forEach var="r" begin="1" end="4">
                            <input type="checkbox" name="cbx${r}" > Option ${r}
                        </t:forEach>
                    </td>

                </tr>
                <tr>
                    <td></td>
                    <td> 

                        <input type="submit" value="Save" > 
                        <button>
                            Reset Data
                        </button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
