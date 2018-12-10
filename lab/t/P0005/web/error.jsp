
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
    </head>
    <body>
        <div class="container">
            <div class="pre-header">
            </div>
            <div class="header">
                <p class="news-name inner">My Blog</p>
            </div>
            <div class="menu">
                <ul class="menu-list inner">
                    <a href="ArticleController"><li>Home</li></a>
                    <a href="ContactController"><li>Contact</li></a>
                </ul>
            </div>
            <div class="content">
                <div class="content-container inner">
                    <div class="result">
                        <h2>${param.error}</h2>
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
