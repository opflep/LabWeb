<%-- 
    Document   : contact
    Created on : Jun 8, 2018, 4:19:43 PM
    Author     : dungndse05558
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel ="stylesheet" href="css/homepage.css" type="text/css">
    </head>
    <body>
        <div> <%@ include file="header.jsp"  %></div>
        <div class="content">
            <div class="first-content">
                <div class="contact-frame">
                    <h1>All fields are required</h1>
                    <div class="contact">
                        <form action="contact" method="post">
                            <div><p>Name: <input type="text" name ="name" value="${requestScope.name}"></p></div>
                            <div><p>Email: <input type="text" name ="email" value="${requestScope.email}"></p></div>
                            <div><p>Phone: <input type="text" name ="phone" value="${requestScope.phone}"></p></div>
                            <div><p>Company: <input type="text" name ="company" value="${requestScope.company}"></p></div>
                            <div><p>Message: <textarea type="text" name ="message" >${requestScope.message}</textarea></p></div>
                            <div><button>Save</button></div>
                            <div><i id="errorContact">${requestScope.error}</i></div>
                            
                        </form>
                    </div>
                </div>
                
            </div>
            <div> <%@ include file="categoryList.jsp"  %></div>
        </div>
    </body>
</html>
