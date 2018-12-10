
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"/>
        <title>About Our Company</title>
    </head>
    <body>
        <div class="center">
            <%@include file="Header.jsp" %>
            <div class="nav">
                <a href="Homecontroller">Home</a>
                <a href="aboutMyCakeController">About My Cake</a>
                <a href="Findus" class="font-bold">Find Maria'Cafe</a>
            </div>
            <div class="main-content">
                <article class="main">
                    <div class="margin">
                        <span class="h2 font-bold">${about.getTitle()}</span>
                        <div class="content">

                            <div>
                                <img src="${about.getImglink()}" class="img-about"/>
                            </div>
                            <p>${about.getFulldescription()}
                            </p>
                        </div>
                </article>
                <%@include file="Aside.jsp" %>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
