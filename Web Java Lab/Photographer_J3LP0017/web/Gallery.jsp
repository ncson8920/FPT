<%-- 
    Document   : Gallery
    Created on : Jul 12, 2021, 4:56:04 PM
    Author     : Admin
--%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
        <script src="js/home.js" type="text/javascript"></script>
        <title>My Front Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="about">
                        <h3>${g.name}</h3>
                    </div>

                    <div class="imageGallery">
                        <c:forEach items="${listImg}" var="i">
                            <div class="test" onclick="pause()">
                                <img src="images/${i}">
                            </div>
                        </c:forEach>

                        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                        <a class="next" onclick="plusSlides(1)">&#10095;</a>
                    </div>
                    <div class="contentGallery">
                        <c:forEach items="${listImg}" var="i" varStatus="o">
                            <div class="subImg">
                                <img src="images/${i}" onclick="currentSlide(${o.count})">
                            </div>
                        </c:forEach>
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
