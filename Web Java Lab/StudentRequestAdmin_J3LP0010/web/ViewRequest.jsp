<%-- 
    Document   : ViewRequest
    Created on : 28-Jun-2021, 21:09:37
    Author     : admin
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>
    <body>
        <div class="container">
            <div class="header">
                <h1>FPT Education System</h1>
                <h3>Teacher Control Panel</h3>
            </div>
            <%Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = sdf.format(date);
        %>
            <div class="content">
                <div class="left">
                    <a href="logout"><button>Welcome ${sessionScope.user.shortName}, Logout</button></a>
                    <a href="login"><button>Home</button></a>
                    <a href="#"><button>View Request</button></a>
                    <a href="#"><button>Solve Request</button></a>
                    <button>Today is: <%=currentDate%></button>
                </div>
                <div class="right">
                    <div class="view">
                        <h3 style="color: dodgerblue;">View Request</h3>
                        <form action="searchView" method="post" class="searchForm">
                            <p><strong>Select department </strong>
                                <select name="department">
                                    <c:forEach items="${listDepartment}" var="o">
                                        <option value="${o.id}" ${dpid == o.id?"selected":""}>${o.name}</option>
                                    </c:forEach>
                                </select></p>

                            <p style="margin-bottom: 0; padding-bottom: 1rem;"><strong>or Enter Request Title </strong>
                                <input type="text" name="txtSearch" value="${txt}">
                                <input type="submit" value="View"></p>
                        </form>
                        <table border="groove 2px">
                            <tr>
                                <th>Request Title</th>
                                <th>Date Create</th>
                                <th>Date Close</th>
                                <th>Status</th>
                                <th>Report To</th>
                                <th>Detail</th>
                            </tr>
                            <c:forEach items="${listView}" var="o">
                                <tr>
                                    <td>${o.title}</td>
                                    <td>${o.dateCreated}</td>
                                    <td>${o.closeDate == null ? "N/A":o.closeDate}</td>
                                    <c:if test="${o.status == 0}">
                                        <td>In progress</td>
                                    </c:if>
                                    <c:if test="${o.status != 0}">
                                        <td>${o.status == 1?"Accepted":"Reject"}</td>
                                    </c:if>
                                    <td>${o.requestName}</td>
                                    <c:if test="${o.status == 0}">
                                        <td><a href="solverequest?id=${o.id}&solve=0">Solve</a></td> 
                                    </c:if>
                                    <c:if test="${o.status != 0}">
                                        <td><a href="solverequest?id=${o.id}&solve=1">View</a></td> 
                                    </c:if>
                                </tr>
                            </c:forEach>

                        </table>
                    </div>
                </div>

            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>
