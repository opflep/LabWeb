<%-- 
    Document   : specificBlog
    Created on : Jun 6, 2018, 5:14:52 PM
    Author     : dungndse05558
--%>

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
                    <c:forEach items="${blogs1}" var ="current">
                        <%@ include file="categoryHeader.jsp"  %>
                                <p class="first-content-1">
                            <a href="specificBlog?id=${current.id}"> ${current.name}</a>
                        </p>
                        <p class="first-content-1-1">Posted on ${current.datecreated} 
                            <i><a href ="#"> - Full Article</a></i>
                        </p>
                    
                                <div>
                        <div class="image">
                            <img src="${current.img}">
                        </div>
                        
                        <p class = "first-content-2">
                            <c:out value="${current.content}"/>
                        </p>
                    </div>
                    
                    </c:forEach>
                </div>
                 <hr>
            </div>
            <div> <%@ include file="categoryList.jsp"  %></div>
        </div>
                       

    </body>
</html>
