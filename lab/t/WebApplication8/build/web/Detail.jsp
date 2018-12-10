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
                            <div class="inline">
                                <div><img src="${detail.getImglink()}" class="img-home"/></div>
                                <span class="h3 font-bold">${detail.getTitle()}</span>
                                <p>${detail.getFulldescription()}</p>
                            </div>
                      </section>
                    </div>   
                </article>
                <%@include file="Aside.jsp" %>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
