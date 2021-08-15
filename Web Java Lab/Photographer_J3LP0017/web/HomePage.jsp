<%-- 
    Document   : HomePage
    Created on : Jul 12, 2021, 4:48:21 PM
    Author     : Admin
--%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
        <title>My Front Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="image">
                        <img src="images/homeImage.jpg" alt="First">
                    </div>
                    <div class="description">
                        Lorem ipsum dolor sit amet
                    </div>
                    <div class="content">
                        <ul >
                            <c:forEach items="${list}" var="i" >
                                <li class="span4">
                                    <div class="image">
                                        <img src="images/${i.img}">
                                    </div>
                                    <h4>
                                        <a href="view?id=${i.id}">View ${i.name}</a>
                                    </h4>
                                    <p>${i.description}</p>
                                </li>

                            </c:forEach>
                        </ul>
                    </div>
                    <div class="about">
                        <h3>About me</h3>
                    </div>
                    <div class="about-detail">
                        ${contact.about}
                    </div>
                </div>
                <div class="right">
                    <div class="header-right">
                        <h4>Share this page</h4>
                    </div>
                    <div class="social">
                        <div>
                            <ul>
                                <li><img src="images/face.png"><a href="https://www.facebook.com/"><span>Share on Facebook</span></a></li>
                                <li><img src="images/twitter.png"><a href="https://twitter.com/?lang=vi"><span>Share on Twitter</span></a></li>
                                <li><img src="images/google.png"><a href="https://www.google.com/"><span>Share on Google</span></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>

