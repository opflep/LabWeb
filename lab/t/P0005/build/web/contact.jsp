
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Blog</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    <body>
        <div class="container">
            <div class="pre-header">
            </div>
            <div class="header">
                <p class="news-name inner">My Blogs</p>
            </div>
            <div class="menu">
                <ul class="menu-list">
                    <a href="ArticleController"><li class="page${'Home' == page}">Home</li></a>
                    <a href="ContactController"><li class="page${'Contact' == page}">Contact</li></a>
                </ul>
            </div>
            <div class="content">
                <div class="content-container inner">
                    <div class="contact">
                        <fieldset>
                            <legend>All fields are required</legend>
                            <form action="ContactController" method="POST">
                                <table>
                                    <tr>
                                        <td class="field">Name</td>
                                        <td><input type="text" id="name" name="name" required /></td>
                                    </tr>
                                    <tr>
                                        <td class="field">Email</td>
                                        <td><input type="email" id="email" name="email" required /></td>
                                    </tr>
                                    <tr>
                                        <td class="field">Phone</td>
                                        <td><input type="text" id="phone" name="phone" required /></td>
                                    </tr>
                                    <tr>
                                        <td class="field">Company</td>
                                        <td><input type="text" id="company" name="company" required /></td>
                                    </tr>
                                    <tr>
                                        <td class="field">Message</td>
                                        <td><textarea type="text" id="message" name="message" required ></textarea></td>
                                    </tr>
                                </table>
                                <input type="submit" id="submit" value="Send" />
                            </form>
                        </fieldset>
                        <p id="check"></p>
                    </div>
                    <div class="aside">
                        <div class="categories">
                            <p class="heading">Categories</p>
                            <ul>    
                                <c:forEach var="item" items="${categories}">
                                    <li>
                                        <span><img src="<%=request.getContextPath()%>/img/img01.jpg"></span>
                                        <a href="CategoryController?category=${item.category}">${item.category}</a>
                                    </li> 
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="clear">
                    </div>
                </div>
            </div>
            <div class="footer">
            </div>
        </div> <!--container-->
        <script src="<%=request.getContextPath()%>/js/contact.js"></script>
    </body>
</html>

