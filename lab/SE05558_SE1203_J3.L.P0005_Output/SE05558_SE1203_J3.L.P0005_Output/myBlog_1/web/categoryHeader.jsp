<%-- 
    Document   : categoryHeader
    Created on : Jun 25, 2018, 5:18:58 PM
    Author     : dungndse05558
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
                        <c:set var="temp2" value="${requestScope.category}"></c:set>
                        <c:choose>
                            <c:when test="${temp2 =='fullArticle'}">
                                <i class="kli">
                                    <a href="category?category=${requestScope.category2}" >Category ${requestScope.category2}</a>
                                </i> - 
                                <i class="kli active"><a href="category?category=fullArticle">Full Article</a></i>
                            </c:when>
                            <c:otherwise>
                                <i class="kli active">
                                    <a href="category?category=${requestScope.category2}" >Category ${requestScope.category2}</a>
                                </i> - 
                                <i class="kli"><a href="category?category=fullArticle" >Full Article</a></i>
                            </c:otherwise>    
                        </c:choose>
    </body>
</html>
