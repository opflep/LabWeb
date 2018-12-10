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
        <title>Machine for Sale</title>
    </head>
    <body>
        <div class="center">
            <%@include file="Header.jsp" %>
            <%@include file="Menubar.jsp" %>
            <div class="main-content">
                <article class="main">
                    <div class="margin">
                        <div class="article">
                            <c:forEach var="i" begin="0" step="1" end="${Machines.size()-1}">
                                <c:if test="${i<=Machines.size()}">
                                    <section class="info">
                                        <div class="img-for-sale"><img src="${Machines.get(i).getImglink()}" class="img-home"/></div>
                                        <div class="float-right content-for-sale"><span class="h3">${Machines.get(i).getTitle()}</span>
                                            <p>${Machines.get(i).getFulldescription()}</p></div>
                                    </section>
                                </c:if>

                            </c:forEach>

                        </div>
                    </div>
                    <div class="paging">
                        <c:forEach var="i" begin="1" step="1" end="${totalPage}">
                            <c:if test="${page != i}">
                                <a href="SaleController?page=${i}">${i}</a> |
                            </c:if>
                            <c:if test="${page == i}">
                                ${i} |
                            </c:if>
                        </c:forEach>
                    </div>

                </article>
                <%@include file="Aside.jsp" %>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
