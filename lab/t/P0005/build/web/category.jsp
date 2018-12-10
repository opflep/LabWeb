
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
                    <div class="category">
                        <p class="article">${message}</p>
                        <c:forEach var="article" items="${articles}">
                            <div class="article">
                                <p class="heading">
                                    <a href="ArticleController?id=${article.id}">${article.title}</a>
                                </p>
                                <p>
                                    ${article.content.substring(0, 300)}...
                                </p>
                                <div class="article-detail">
                                    <p>Post on ${article.date}</p>
                                </div>
                            </div>
                        </c:forEach>
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
    </body>
</html>

