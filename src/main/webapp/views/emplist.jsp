<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<div id="wrap" style="width: 80%">
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
							<a href="#">main</a>
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
								Salary
							</td>
							<td>
								Age
							</td>
						<shiro:hasAnyRoles name="root,admin">
							<td>
								Operation
							</td>
						</shiro:hasAnyRoles>
						</tr>
						<c:forEach items="${requestScope.employees}" varStatus="em" var="employee">
						<c:if test="${em.count%2!=0}">
						<tr class="row1">
							<td>
								${employee.id}
							</td>
							<td>
								${employee.name}
							</td>
							<td>
								${employee.salary}
							</td>
							<td>
								${employee.age}
							</td>
							<shiro:hasAnyRoles name="root,admin">
							<td>
								<shiro:hasPermission name="user:remove">
									<a href="${pageContext.request.contextPath}/employee/removeEmployee?id=${employee.id}">delete employee</a>&nbsp;
								</shiro:hasPermission>
								<shiro:hasPermission name="user:modify">
									<a href="${pageContext.request.contextPath}/employee/findEmployeeById?id=${employee.id}">update employee</a>
								</shiro:hasPermission>
							</td>
							</shiro:hasAnyRoles>
						</tr>
						</c:if>
						<c:if test="${em.count%2==0}">
						<tr class="row2">
							<td>
									${employee.id}
							</td>
							<td>
									${employee.name}
							</td>
							<td>
									${employee.salary}
							</td>
							<td>
									${employee.age}
							</td>
							<shiro:hasAnyRoles name="admin,root">
							<td>
								<shiro:hasPermission name="user:remove">
									<a href="${pageContext.request.contextPath}/employee/removeEmployee?id=${employee.id}">delete employee</a>&nbsp;
								</shiro:hasPermission>
								<shiro:hasPermission name="user:modify">
									<a href="${pageContext.request.contextPath}/employee/findEmployeeById?id=${employee.id}">update employee</a>
								</shiro:hasPermission>
							</td>
							</shiro:hasAnyRoles>
						</tr>
						</c:if>
						</c:forEach>
					</table>
					<p>
						<c:if test="${requestScope.page>1}">
						<input type="button" class="button" value="Next Page" onclick="location='${pageContext.request.contextPath}/employee/findAllEmployees?page=${requestScope.page-1}'"/>
						</c:if>

						<c:if test="${requestScope.page<requestScope.maxPage}">
						<input type="button" class="button" value="Before Page" onclick="location='${pageContext.request.contextPath}/employee/findAllEmployees?page=${requestScope.page+1}'"/>
						</c:if>
					</p>
					<p>
						<shiro:hasPermission name="user:add">
							<input type="button" class="button" value="Add Employee" onclick="location='${pageContext.request.contextPath}/views/addEmp.jsp'"/>
						</shiro:hasPermission>
						<shiro:hasAnyRoles name="root,admin">
							<input type="button" class="button" value="Check Logs" onclick="location='${pageContext.request.contextPath}/log/findAllLogs'"/>
						</shiro:hasAnyRoles>
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
