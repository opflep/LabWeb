<%-- 
    Document   : AboutMe
    Created on : Mar 23, 2018, 12:04:19 PM
    Author     : Chu Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/FashionBlog/CSS_Style/Home.css" rel="stylesheet" type="text/css"/>
        <title>AboutMe Page</title>
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
                <a href="HomeController" class="subMenuBar  noneLine">My Fashion Blog </a>
                <a class="subMenuBar fontBold">About Me</a>
                <a href="/FashionBlog/Web-Content/Contact.jsp" class="subMenuBar noneLine">Contact</a>
            </div>
            <!--display all content and advertising--> 
            <div id="bigContener">
                <!--display all blog (list blogs)-->
                <div id="listBlogs" class="fontArial">
                    <h1 class="title">Contact me</h1>
                    <div id="bigcontentAboutMe" class="fontArial">
                        <img class="imgAboutMe floatLeft" src="${me.picture}">
                        <div class="floatRight" id="contentAboutMe">
                            <p><span class="fontBold">Name:</span> ${me.name}</p>
                            <p><span class="fontBold">Age</span> ${me.age}</p>
                            <p>${me.description}</p>
                        </div>
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
