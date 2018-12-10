<%-- 
    Document   : ManagerQuiz
    Created on : May 17, 2018, 1:48:11 PM
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

        <br> <br>
        <span class="ManagerQuizTableTextDecoration">
            Number of questions : 
        </span>

        <b class="ManagerQuizListQuestionSize">
            ${ListQuestions.size()}
        </b>

        <br> <br><br> <br>

        <table class="ManagerQuizTable">
            <tr>
                <th>
                    Question
                </th>
                <th>
                    DateCreated
                </th>
            </tr>
            <t:forEach var ="r" items="${ListQuestions}" >
                <tr>
                    <td class="ManagerQuizTableTextDecoration">
                        ${r.content}
                    </td>

                    <td class="ManagerQuizTableTextDecoration">
                        ${r.dataCreate}
                    </td>
                </tr>
            </t:forEach>
        </table>

    </body>
</html>
