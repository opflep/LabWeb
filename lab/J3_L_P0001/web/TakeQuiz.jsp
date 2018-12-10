<%-- 
    Document   : TakeQuiz
    Created on : May 17, 2018, 1:44:49 PM
    Author     : vietnkse04597
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/css.css">
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="./js/js.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>

        <t:choose>
            <t:when test = "${sessionScope.playerScore == null}">
                <br>
                <div class="TakeQuizDiv">
                    Welcome <b> ${sessionScope.LoginUser} </b> 
                </div>

                <br> <br>
            </t:when>
        </t:choose>

        <t:choose>
            <t:when test = "${sessionScope.quiz != null}">

                <div>
                    <form action = "DoNextQuiz" method ="post">

                        <div class="TakeQuizDivTimeRemaining">
                            Time remaining: 
                            <b id = "minute"> ${sessionScope.minute}  </b> 
                            <b id = "minute"> :  </b> 
                            <b id = "second"> ${sessionScope.second} </b>
                        </div>

                        <br> <br>

                        <div class="TakeQuizDivTimeRemaining">
                            ${sessionScope.quiz.content}
                            <br> 
                            <t:forEach var ="r" items="${sessionScope.quiz.listAnswers}" >
                                <input type="checkbox" name="option${r.index}" /> ${r.content}  <br>  
                            </t:forEach>
                        </div>
                        <input type="submit" name="btnNext" value="Next"/>
                    </form>
                </div>

            </t:when>
            <t:otherwise>

                <t:choose>

                    <t:when test = "${sessionScope.playerScore != null}">

                        <abbr class="TakeQuizDivTimeRemaining">
                            Your score :
                        </abbr>

                        <t:choose>
                            <t:when test="${sessionScope.playerScore >= 5}">
                                <abbr class="TakeQuizPass">
                                    ${sessionScope.playerScore} ( ${sessionScope.playerScorePercent} %)- Passed
                                </abbr>
                            </t:when>
                            <t:otherwise>
                                <abbr class="TakeQuizFail">
                                    ${sessionScope.playerScore} ( ${sessionScope.playerScorePercent} %) - Failed
                                </abbr>
                            </t:otherwise>

                        </t:choose>
                        <br> <br>
                        <div class="TakeQuizDivTimeRemaining">
                            
                            <form action="DoTakeQuiz" method="post">
                                Take Another test
                                <input type="submit" value="Start" name="btnStart" class="TakeQuizBtnDecoration" />
                            </form>
                        </div>

                    </t:when>
                    <t:otherwise>
                        <div class="TakeQuizDiv">
                            Enter number of questions:
                            <br>
                            <div>
                                <form action="DoTakeQuiz" method="post">
                                    <input type="textbox" name="txtQuantityOfQuiz" /> <br> <br>
                                    <input type="submit" value="Start" name="btnStart" class="TakeQuizBtnDecoration" />
                                </form>
                            </div>
                        </div>
                    </t:otherwise>

                </t:choose>
            </t:otherwise>
        </t:choose>
    </body>
</html>
