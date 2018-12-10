<%-- 
    Document   : index
    Created on : May 2, 2018, 2:34:41 PM
    Author     : Alpha 69
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Home</title>
    </head>
    <body>
        <div class="center">
            <%@include file="Header.jsp" %>
            <%@include file="Menubar.jsp" %>
            <div class="main-content">
                <article class="main">
                    <div class="margin">
                        <section class="article">
                            <div><span class="h2 font-bold">${introarticle.getTitle()}</span></div>
                            <br>
                            <span class="h4 font-bold">${introarticle.getShortDescription()}</span>
                            <p>${introarticle.getFulldescription()}</p>
                            <div class="img-intro-border">
                                <img src="${introarticle.getImglink()}" class="img-intro"/></div>
                        </section>
                        <section class="article">
                            <c:forEach var="i" begin="0" step="1" end="2">
                                <c:if test="${i<=articles.size()}">
                                    <div class="inline">
                                        <div><img src="${articles.get(i).getImglink()}" class="img-home"/></div>
                                        <span class="h3 font-bold"><a href="DetaiController?id=${articles.get(i).getId()}"> ${articles.get(i).getTitle()}</a></span>
                                        <p>${articles.get(i).getShortDescription()}</p>
                                    </div>
                                </c:if>

                            </c:forEach>

                        </section>
                        <div class="article">
                            <c:forEach var="i" begin="3" step="1" end="5">
                                <c:if test="${i<=articles.size()}">
                                    <div class="inline">
                                        <div><img src="${articles.get(i).getImglink()}" class="img-home"/></div>
                                        <span class="h3 font-bold"> <a href="DetaiController?id=${articles.get(i).getId()}">${articles.get(i).getTitle()}</a></span>
                                        <p>${articles.get(i).getShortDescription()}</p>
                                    </div>
                                </c:if>

                            </c:forEach>
                        </div>

                        
                    </div>   
                </article>
                <%@include file="Aside.jsp" %>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
