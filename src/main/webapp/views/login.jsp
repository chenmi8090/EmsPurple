<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(function(){
			   $("#sub").click(function(){
			      var username = $("#username").val();
			      var password = $("#password").val();
			      var rememberMe = $("#rememberMe").val();
			      console.log(username);
			      console.log(password);
			      $.ajax({
                      url:"${pageContext.request.contextPath}/admin/adminLogin?username="+username+"&password="+password+"&rememberMe="+rememberMe,
					  type:"GET",
                      processData:false,
                      contentType:false,
					  success:function(result){
                          console.log(result);
                          if(result.success){
                              location.href="${pageContext.request.contextPath}/employee/findAllEmployees";
						  }else{
                              $("#span").append("<font color='red'><font>").text(result.message);
						  }
					  }
				  })
			   });
			});
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
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Login :
					</h1>
					<span id="span"></span>
					<form action="javascript:;" id="adminLogin" method="post" >
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									账号:
								</td>
								<td valign="middle" align="left">
									<input id="username" type="text" class="inputgri" name="username" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input id="password" type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									记住我：
								</td>
								<td valign="middle" align="left">
									<input id="rememberMe" type="checkbox" name="rememberMe" />
								</td>
							</tr>
						</table>
						<p>
							<input id="sub" type="submit" class="button" value="Submit &raquo;" />
							<input type="button" class="button" onclick="location.href='regist.jsp'" value="Regist &raquo;" />
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
