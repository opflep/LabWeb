<%-- 
    Document   : Contact
    Created on : Mar 19, 2018, 5:34:59 PM
    Author     : Chu Anh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/FashionBlog/CSS_Style/Home.css" rel="stylesheet" type="text/css"/>
        <title>Contact Page</title>
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
                <a href="/FashionBlog/HomeController" class="subMenuBar  noneLine">My Fashion Blog </a>
                <a href="/FashionBlog/AboutMeController" class="subMenuBar noneLine">About Me</a>
                <a class="subMenuBar fontBold noneLine">Contact</a>
            </div>
            <!--display all content and advertising--> 
            <div id="bigContener">
                <!--display all blog (list blogs)-->
                <div id="listBlogs" class="fontArial">
                    <h1 class="title">Contact me</h1>
                    <div id="borderSendYourMessage">
                        <p class="fontArial fontThin magin">Send your messages </p>
                    </div>
                    <!--display notification if had-->
                    <div id="notify">
                        <c:if test="${isNotify==2}">
                            <div class="fontArial activeNotification" type="text" readonly="true">
                                <p>${notify}</p>
                            </div>
                        </c:if>
                        <!--insert successfully-->
                        <c:if test="${isNotify==3}">
                            <input class="fontArial successfulyMessage" type="text" readonly="true" value="${notify}">
                        </c:if>  
                    </div>
                    <p class="fontArial">Write your message here. Fill out the form:</p>
                    <!--display form--> 
                    <form action="/FashionBlog/ContactController" class="blockForm">
                        <!--display name and mail--> 
                        <div id="nameAndMail">
                            <div id="name">
                                <input class="fontArial inputText" type="text" name="txtName" value="${name}" placeholder="Write name here"/>
                            </div>
                            &nbsp;&nbsp;
                            <div id="mail">
                                <input class="fontArial inputText" type="text" name="txtMail" value="${mail}" placeholder="Write mail here"/>
                            </div>
                        </div>
                        <!--display text are of message-->
                        <div id="meassageArea">
                            <textarea class="areaText fontArial" name="txtArea" placeholder="Write message here">${mess}</textarea>
                        </div>
                        <!--display button confirm send--> 
                        <div id="btnSend">
                            <input class="fontArial btnSendRadius" type="submit" value="Send - Click here"/>
                        </div>
                    </form>
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
            <!--dipsplay the footer of pages-->
            <div id="theFooter" class="fontArial">
                <p class="floatRight">065356</p>
            </div> 
        </div>
    </body>
</html>
