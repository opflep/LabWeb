<%-- 
    Document   : Home
    Created on : Mar 15, 2018, 9:12:02 PM
    Author     : Chu Anh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/FashionBlog/CSS_Style/Home.css" rel="stylesheet" type="text/css"/>
        <title>Fashion Home Page</title>
    </head>
    <body>
        <div id="mainBoxShadow">
            <!--the big header content Logo and sublog-->
            <div id="bigHeader">
                <h1 class="magin logo">My Fashion Blog</h1>
                <p class="colorRed fontArial subLogo">Welcome to this website</p>              
            </div>
            <!--the menu bar background color red-->
            <div id="menuBar">
                <a class="subMenuBar fontBold">My Fashion Blog </a>
                <a href="/FashionBlog/AboutMeController" class="subMenuBar noneLine">About Me</a>
                <a href="/FashionBlog/Web-Content/Contact.jsp" class="subMenuBar noneLine">Contact</a>
            </div>
            <%String s = "http://localhost:8080/FashionBlog/";%>
            <!--display all content and advertising--> 
            <div id="bigContener">
                <!--display all blog (list blogs)-->
                <div id="listBlogs" class="fontArial">
                    <h1 class="title">Blog</h1>
                    <!--display list blog by order pushdate-->
                    <c:forEach items="${arrBlog}" var="blogs">
                        <c:if test="${blogs.type==1}">
                            <div id="blogType">
                                <div id="iconBlog"></div>
                                <div id="blogContener">
                                    <!--display header of blog-->
                                    <div id="theHeaderBlog">
                                        <a class="floatLeft" href="DetailController?ID=${blogs.fashionID}">
                                            <c:out value = "${blogs.fashionName}"/></a> 
                                        <i class="floatRight"><c:out value = "${blogs.pushDate}"/></i>
                                    </div> 
                                    <img class="imgBlogType1" src="${blogs.picture}"/>
                                    <i class="floatLeft magin textBlogType1"><c:out value = "${blogs.content}"/></i>
                                </div>                               
                            </div>
                        </c:if>
                        <c:if test="${blogs.type==2}">
                            <div id="blogType">
                                <div id="iconBlog"></div>
                                <div id="blogContener">
                                    <!--display header of blog-->
                                    <div id="theHeaderBlog">
                                        <a class="floatLeft" href="DetailController?ID=${blogs.fashionID}">
                                            <c:out value = "${blogs.fashionName}"/></a> 
                                        <i class="floatRight"><c:out value = "${blogs.pushDate}"/></i>
                                    </div> 
                                    <img class="imgBlogType2 floatLeft" src="${blogs.picture}"/>
                                    <div id="textContentBlogType2" class="floatRight">
                                        <p class="magin"><c:out value = "${blogs.content}"/></p>
                                    </div>

                                </div>                               
                            </div>
                        </c:if>
                    </c:forEach>
                    <!--display hyperlink overview-->
                    <div id="overView">
                        <a href="<%= s %>OverViewController?currentPage=1" class="fontArial">OverView</a>
                    </div>

                </div>
                <!--the advertising-->
                <div id="advertising" class="fontArial">
                    <p class="sharePage magin">Share this page</p>
                    <div id="lineAdvertising">
                        <p class="iconAdvertisingFB"></p>&nbsp;
                        <u><a href="https://www.facebook.com/">Share with Facebook</a></u><br>
                    </div>
                    <div id="lineAdvertising">
                        <p class="iconAdvertisingTW"></p>&nbsp;
                        <u><a href="https://www.youtube.com">Share with Twitter</a></u><br>
                    </div>
                    <div id="lineAdvertising">
                        <p class="iconAdvertisingGG"></p>&nbsp;
                        <u><a href="https://www.youtube.com">Share with Google</a></u><br>
                    </div>

                </div>
            </div>
            <!--dipsplay the footer of pages-->
            <div id="theFooter" class="fontArial">
                <p class="floatRight">065356</p>
            </div> 
        </div>



    </body>
</html>
