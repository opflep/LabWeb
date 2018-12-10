
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Blog</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Nova+Mono" />
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
                    <div class="article">
                        <a class="article-category" href="CategoryController?category=${article.category.category}">
                            Category ${article.category.category}
                        </a>
                        <span> - Full Category</span>
                        <p class="heading">${article.title}</p>
                        <p class="article-date">Post on ${article.date}<span> - Full Article</span></p>
                        <div class="article-content">
                            <img src="<%=request.getContextPath()%>/img/${article.image}" alt="img" />
                            <p>
                                ${article.content}
                            </p>
                        </div>
                        <div class="most-recent-blog">
                            <ul>
                                <c:forEach var="item" items="${topLastArticles}">
                                    <li>
                                        <a href="ArticleController?id=${item.id}">${item.title}</a>
                                        <span>Post on ${item.date}</span>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
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

