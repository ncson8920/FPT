<%-- 
    Document   : Header
    Created on : Jul 12, 2021, 4:39:44 PM
    Author     : Admin
--%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/header.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="nav">
            <div class= "nav-inner">
                    <li> <a href="home">My front page</a></li>
                    <c:forEach items="${list}" var="i" >
                        <li><a href="view?id=${i.id}">${i.name}</a> </li>
                        </c:forEach>
                    <li> <a href="contact">Contact</a> </li>
            </div>
        </div>
        <div class="header">
            <div class="header-inner">
                <div class="img"> </div>
                <div class="title ">
                    PHOTOGRAPHER
                </div>
                <div class="subtitle">
                    Welcome to this website
                </div>
            </div>
        </div>
    </body>
</html>
