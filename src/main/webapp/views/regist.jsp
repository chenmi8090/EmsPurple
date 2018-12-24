<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">

		</script>
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
								<a href="#">Regist</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Regist Admin info:
					</h1>
					<form action="${pageContext.request.contextPath}/admin/registAdmin" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="男" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="女"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="num" src="${pageContext.request.contextPath}/admin/code" />
									<a href="javascript:;" onclick="document.getElementById('num').src = '${pageContext.request.contextPath}/admin/code?'+(new Date()).getTime()">换一张</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="code" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />&nbsp;
							<input type="button" class="button" value="Login &raquo;" onClick="location.href='${pageContext.request.contextPath}/views/login.jsp'">
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
