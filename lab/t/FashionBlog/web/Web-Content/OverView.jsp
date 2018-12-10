<%-- 
    Document   : OverView
    Created on : Mar 16, 2018, 3:35:29 PM
    Author     : Chu Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/FashionBlog/CSS_Style/Home.css" rel="stylesheet" type="text/css"/>
        <title>OverView Page</title>
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
            <!--display all content and advertising--> 
            <div id="bigContener">
                <!--display all blog (list blogs)-->
                <div id="listBlogs" class="fontArial">
                    <h1 class="title">Overview - Blog</h1>
                    <!--display list data pagination-->
                    <table class="dataTable">
                        <c:forEach items="${arrPagination}" var="paginRow">
                            <c:if test="${paginRow.type==1}">
                                <tr>
                                    <td class="tdfashionName"><c:out value = "${paginRow.title}"/></td>
                                    <td class="tdfashionLikeIcon"></td>
                                    <td class="tdfashionCommentIcon"></td>
                                    <td class="tdfashionDate"><p class="floatRight magin" >
                                            <c:out value = "${paginRow.date}"/> </p></td>
                                </tr>
                            </c:if>
                            <c:if test="${paginRow.type==2}">
                                <tr>
                                    <td class="tdfashionName"><a href="DetailController?ID=${paginRow.id}" class="fontColorBlack">
                                            <c:out value = "${paginRow.title}"/></a></td>
                                    <td class="tdfashionLikeIcon magin"><div id="numberLikeComment"><img class="floatLeft" src="/FashionBlog/Image/iconLike.PNG"/><p class="floatRight magin"> 1</p></div></td>
                                    <td class="tdfashionCommentIcon"><div id="numberLikeComment"><img class="floatLeft" src="/FashionBlog/Image/iconComment.PNG"/><p class="floatRight magin"> 1</p></div></td>
                                    <td class="tdfashionDate"><p class="floatRight magin" > <c:out value = "${paginRow.date}"/> </p></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                    <!--display number pagination-->
                    <div id="numberPagination">
                        <c:forEach items="${arrNumPagination}" var="num">
                            <c:if test="${num.type==1}">
                                <a class="activation"><c:out value = "${num.number}"/></a>
                            </c:if>
                            <c:if test="${num.type==2}">
                                <a class="deactivation" href="OverViewController?currentPage=${num.number}">
                                    <c:out value = "${num.number}"/></a>
                                </c:if>
                            </c:forEach>
                    </div>
                </div>
                <!--the advertising-->
                <div id="advertising" class="fontArial">
                    <p class="sharePage magin">Share this page</p>
                    <div id="lineAdvertising">
                        <p class="iconAdvertising"></p>&nbsp;
                        <u><a href="https://www.facebook.com/">Share with Facebook</a></u><br>
                    </div>
                    <div id="lineAdvertising">
                        <p class="iconAdvertising"></p>&nbsp;
                        <u><a href="https://www.youtube.com">Share with Twitter</a></u><br>
                    </div>
                    <div id="lineAdvertising">
                        <p class="iconAdvertising"></p>&nbsp;
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
