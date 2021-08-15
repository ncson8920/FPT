<%-- 
    Document   : Contact
    Created on : Jul 12, 2021, 4:57:55 PM
    Author     : Admin
--%>

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
                    <div class="about">
                        <h3>Contact</h3>
                    </div>
                    <div class="content-contact">
                        <h4>PHOTOGRAPHER</h4>
                        <div class="infor">
                            <p>Address: ${contact.address}
                                <br>City: ${contact.city}
                                <br>Country:  ${contact.country}</p>
                            <p>Tel: ${contact.phone}</p>
                            <p>Email: ${contact.email}<p>
                                <br><br>
                        </div> 
                        <div class="map">
                            <img src="images/map.PNG">
                        </div>
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
