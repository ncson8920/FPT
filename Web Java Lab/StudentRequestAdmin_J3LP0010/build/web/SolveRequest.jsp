<%-- 
    Document   : SolveRequest
    Created on : 28-Jun-2021, 21:08:02
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
        <%Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = sdf.format(date);
        %>
        <div class="container">
            <div class="header">
                <h1>FPT Education System</h1>
                <h3>Teacher Control Panel</h3>
            </div>
            <div class="content">
                <div class="left">
                    <a href="logout"><button>Welcome ${sessionScope.user.shortName}, Logout</button></a>
                    <a href="login"><button>Home</button></a>
                    <a href="view"><button>View Request</button></a>
                    <a href="#"><button>Solve Request</button></a>
                    <button style="color: ">Today is: <%=currentDate%></button>
                </div>
                <div class="right">
                    <div class="solve">
                        <h3 style="color: dodgerblue;">Request ID: ${listRequest.id}</h3>
                        <form action="solverequest?requestID=${listRequest.id}&add=1" method="post">
                            <table>
                                <tr>
                                    <td>Request to department</td>
                                    <td><input type="text" name="department" readonly value="${listRequest.requestName}">                                 
                                    </td>
                                </tr>
                                <tr>
                                    <td>Student ID</td>
                                    <td><input type="text" name="stuId" readonly value="${listRequest.studentId}"></td>
                                </tr>
                                <tr>
                                    <td>Student Name</td>
                                    <td><input type="text" name="stuName" readonly value="${listRequest.studentName}"></td>
                                </tr>
                                <tr>
                                    <td>Date Create</td>
                                    <td><input type="text" name="dateCreate" readonly value="${listRequest.dateCreated}"></td>
                                </tr>
                                <tr>
                                    <td>Request Title</td>
                                    <td><input type="text" name="title" readonly value="${listRequest.title}" ></td>
                                </tr>
                                <tr>
                                    <td>Request Content</td>
                                    <td><textarea name="title" readonly>${listRequest.content}</textarea></td>
                                </tr>
                                <tr>
                                    <td>Request Status</td>
                                    <td>
                                        <c:if test="${listRequest.solution != null}">
                                            <input type="radio" name="status" style="width: auto;"  value="1" ${r.status == 1? "checked":""} > <span style="color: green">Approve</span>
                                            <input type="radio" name="status" style="width: auto;"  value="2"  ${r.status == 2? "checked":""} > <span style="color: red">Reject</span>
                                        </c:if>
                                        <c:if test="${listRequest.solution == null}">
                                            <input type="radio" name="status" style="width: auto;"  value="1" checked > <span style="color: green">Approve</span>
                                            <input type="radio" name="status" style="width: auto;"  value="2" > <span style="color: red">Reject</span>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Date Close</td>
                                    <td><input type="text" name="dateClose" readonly value="${listRequest.closeDate}"></td>
                                </tr>
                                <tr>
                                    <td>Solve By</td>
                                    <td><input type="text" name="solveBy" readonly value="${sessionScope.user.shortName}"></td>
                                </tr>
                                <tr>
                                    <td>Attaches (if have)</td>
                                    <td>
                                        <c:if test="${listRequest.attachFile == null}">
                                            <a href="#" >Download File</a>
                                        </c:if>
                                        <c:if test="${listRequest.attachFile != null}">
                                            <a href="file/${listRequest.attachFile}" download >Download File</a>
                                        </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <td>School's Solution</td>
                                    <c:if test="${listRequest.solution != null}">
                                        <td><textarea name="solution" readonly>${listRequest.solution}</textarea></td>
                                    </c:if>
                                        
                                    <c:if test="${listRequest.solution == null}">
                                        <td><textarea name="solution" required >School agrees to your request!!!</textarea></td>
                                    </c:if>
                                        
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <c:if test="${check == null}">
                                            <button class="btnSave" type="submit" value="Save">Save </button>
                                        </c:if>
                                            <p>${result}</p>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>

            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>
