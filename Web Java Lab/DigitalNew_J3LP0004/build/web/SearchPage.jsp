
<%@page import="javax.naming.Context"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Search</title>
        <link href="css/home.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <h3>${result}</h3><br>
                    <c:if test="${sizeList > 0}">
                        <c:forEach items="${listSearch}" var="o">
                            <div class="tittle">
                                <a href="detail?newsId=${o.id}">${o.title}</a>
                            </div>
                            <div class="image_search">
                                <img src="images/${o.image}"/>
                            </div>
                            <div class="text_search">
                                ${o.summary}
                            </div>
                            <br><br>
                        </c:forEach>
                    </c:if>
                    <c:if test="${sizeList == 0}">
                        <h1>Not found</h1>
                    </c:if>
                </div> 
                <div class="right">
                    <div class="newst">
                        <div class="titleNews">
                            <span>Digital News</span>
                        </div>
                        <div class="contentNews">
                            ${news.summary}
                        </div>
                    </div>
                    <div class="newst">
                        <div class="titleNews">
                            Search
                        </div>
                        <form action="search" method="post">
                            <input value="${txtSearch}" class="searchBox" type="text" name="txtSearch" required>
                            <input class="searchButton" type="submit" name="btnGo" value="Go">
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
