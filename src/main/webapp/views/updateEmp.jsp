<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	</head>

	<body>
		<div id="wrap">
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
								<a href="#">Update</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					<form action="${pageContext.request.contextPath}/employee/modifyEmployee" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									${requestScope.employeeById.id}
								</td>
								<input type="hidden" name="id" value="${requestScope.employeeById.id}">
							</tr>
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${requestScope.employeeById.name}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="${requestScope.employeeById.salary}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									age:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="${requestScope.employeeById.age}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									status:
								</td>
								<td valign="middle" align="left">
									正常：<input type="radio" class="inputgri" name="status" value="正常" checked/>
									异常：<input type="radio" class="inputgri" name="status" value="异常"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Confirm" />
							<input type="button" class="button" value="Return Emplist" onclick="location='${pageContext.request.contextPath}/employee/findAllEmployees'" />
						</p>
					</form>
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
