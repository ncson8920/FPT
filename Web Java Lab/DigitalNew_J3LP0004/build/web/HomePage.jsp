<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/home.css" rel="stylesheet" type="text/css" />
<!--        <meta name="viewport" content="width=device-width">-->
    </head>
    <body> 
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <div class="tittle">
                        ${news.title}
                    </div>
                    <div class="image">
                        <img src="images/${news.image}"/>
                    </div>
                    <div class="text">
                        ${news.description}
                    </div>
                    <div class="signature">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        ${news.author} | ${date} 
                        <span> - </span>  ${time}
                    </div>
                </div>
                <div class="right">
                    <div class="newst">
                        <div class="titleNews">
                            <span>Digital News</span>
                        </div>
                        <div class="contentNews">
                            ${news.summary}
                        </div>
                        <div class="titleNews">
                            Search
                        </div>
                        <form action="search" method="post">
                            <input value="${txtSearch}" class="searchBox" type="text" name="txtSearch" required>
                            <input class="searchButton" type="submit" name="btnGo" value="Go" >
                        </form>                        
                    </div>
                    <div class="newst">
                        <div class="titleNews">
                            <span>Last Articles</span><br>
                        </div>
                        <c:forEach items="${listNews}" var="o">
                            <div class="lastArticles">
                                <a href="detail?newsId=${o.id}">${o.title}</a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
