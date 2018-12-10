<%-- 
    Document   : home
    Created on : May 16, 2018, 4:49:37 PM
    Author     : dungndse05558
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel ="stylesheet" href="css/homepage.css" type="text/css">
        
    </head>
    <body>
        <div> <%@ include file="header.jsp"  %></div>
        
        <div class="content">
            <div class="first-content">
                <div>
                        <%@ include file="categoryHeader.jsp"  %>
                    <c:forEach items="${blogs1}" var ="current">
                        <p class="second-first-content-1"><a class="second-first-content-1" href="specificBlog?id=${current.id}"> ${current.name}</a>
                            <i>Posted on ${current.datecreated}</i>
                        </p>
                        <div>
                            <div class="image">
                                <img src="${current.img}">
                            </div>
                            <p class = "first-content-2">
                                <c:out value="${current.brief}"/>
                            </p>
                        </div>
                        
                    </c:forEach>
                </div>
                <hr>
                <div class="second-first-content-1">
                    <c:forEach items="${blogs2}" var ="current"> 
                        <p><a class="second-first-content-1" href="specificBlog?id=${current.id}"> ${current.name}</a>
                            <i>Posted on ${current.datecreated}</i>
                        </p>
                        <div>
                            <div class="image">
                                <img src="${current.img}">
                            </div>
                            <p class = "first-content-2">
                                <c:out value="${current.brief}"/>
                            </p>
                        </div>
                        <hr>
                    </c:forEach>
                </div>
                                
            </div>
            <div> <%@ include file="categoryList.jsp"  %></div>
        </div>
        <div class ="pagination">
            <input type="hidden" value="${requestScope.totalPage}" id="ipt-total-page">
            <input type="hidden" value="${requestScope.currentPage}" id="ipt-current-page">
            <input type="hidden" value="${requestScope.category}" id="ipt-current-category">
            <div id ="paging-wrapper"></div> 
        </div>
            <script  src="js/pagination.js"></script>
    </body>
</html>
