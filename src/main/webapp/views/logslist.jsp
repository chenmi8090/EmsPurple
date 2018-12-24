<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div id="wrap" style="width: 100%">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p id="t1">
                    <script language="javascript" type="text/javascript">
                        setInterval(
                            "document.getElementById('t1').innerHTML=new Date().toLocaleString()",
                            1000);
                    </script>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">Logs</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome <shiro:principal></shiro:principal>!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        DateTime
                    </td>
                    <td>
                        Message
                    </td>
                    <td>
                        success
                    </td>
                </tr>
                <c:forEach items="${requestScope.logs}" varStatus="lo" var="log">
                    <c:if test="${lo.count%2!=0}">
                        <tr class="row1">
                            <td>
                                    ${log.id}
                            </td>
                            <td>
                                    ${log.name}
                            </td>
                            <td>
                                <fmt:formatDate value="${log.datetime}" pattern="yyy-MM-dd HH:mm:ss" />
                            </td>
                            <td>
                                    ${log.message}
                            </td>
                            <td>
                                    ${log.success}
                            </td>
                        </tr>
                    </c:if>
                    <c:if test="${lo.count%2==0}">
                        <tr class="row2">
                            <td>
                                    ${log.id}
                            </td>
                            <td>
                                    ${log.name}
                            </td>
                            <td>
                                <fmt:formatDate value="${log.datetime}" pattern="yyy-MM-dd HH:mm:ss" />
                            </td>
                            <td>
                                    ${log.message}
                            </td>
                            <td>
                                    ${log.success}
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
            <p>
                <c:if test="${requestScope.page>1}">
                    <input type="button" class="button" value="Before Page"
                           onclick="location='${pageContext.request.contextPath}/log/findAllLogs?page=${requestScope.page-1}'"/>
                </c:if>

                <c:if test="${requestScope.page<requestScope.maxPage}">
                    <input type="button" class="button" value="Next Page"
                           onclick="location='${pageContext.request.contextPath}/log/findAllLogs?page=${requestScope.page+1}'"/>
                </c:if>
            </p>
            <p>
                <input type="button" class="button" value="Return EmpList"
                       onclick="location='${pageContext.request.contextPath}/employee/findAllEmployees'"/>
                <input type="button" class="button" value="Saft Exit &raquo;" onClick="location.href='${pageContext.request.contextPath}/admin/logout'">
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
