<%-- 
    Document   : findus
    Created on : Mar 11, 2018, 10:37:50 AM
    Author     : DoThong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Contact</title>
    </head>
    <body>
        <div class="center">
            <%@include file="Header.jsp" %>
            <%@include file="Menubar.jsp" %>
            <div class="main-content">
                <article class="main">
                    <div class="margin">
                        <section>

                            <div class="font-bold"><span class="h2 ">Contact</span></div>
                            <div class="font-bold"><br class="h3">Construction Machinery</div>
                            <p>Address : ${content.getAddress()}</p>
                            <br>City : ${content.getCity()}
                            <br>Country : ${content.getCountry()}
                            <br>Tel:${content.getTel()}
                            <br>Email:${content.getEmail()}

                        </section>
                        <div>
                            <form method="POST" action="">
                                <div class="row">
                                    <p>Write your message here. Fill out the form:</p>
                                    <div class="span6">
                                        <input id="name" name="name" placeholder="Write your name here" required="true"/>
                                    </div>
                                    <div class="span6">
                                        <input id="email" name="email" placeholder="Write your email here" type="email" required="true"/>
                                    </div>
                                </div>
                                <div class="message row">
                                    <textarea id="msg" name="msg" placeholder="Write your message here"></textarea>
                                    <div class="buttonright">
                                        <button class="buttton" type="submit">Send - Click here</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </article>
                <%@include file="Aside.jsp" %>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
