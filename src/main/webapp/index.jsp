<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
	<head>
		<title>add Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	</head>

	<body>
	获取当前用户的用户名：<shiro:principal></shiro:principal>
	<hr>
	<!-- 判断是否认证成功 -->
	<shiro:authenticated>
		认证成功
	</shiro:authenticated>
	<hr>
	<!-- 判断是否认证失败 -->
	<shiro:notAuthenticated>
		认证失败
	</shiro:notAuthenticated>
	<hr>
	<!-- 判断是否是游客登陆 -->
	<shiro:guest>
		是游客登陆
	</shiro:guest>
	<!-- 判断是否是正常登陆或RememberMe直接访问 -->
	<shiro:user>
		是正常登陆或RememberMe访问
	</shiro:user>
	<hr>
	<!-- 判断是否拥有该权限 -->
	<shiro:hasRole name="root">
		拥有root权限
	</shiro:hasRole>
	<hr>
	<!-- 是否缺少条件角色 -->
	<shiro:lacksRole name="aa">
		当前用户缺少条件角色aa(只有同时满足所有时判定生效)
	</shiro:lacksRole>
	<hr>
	<!-- 判断是否存在条件中的任意一种角色 -->
	<shiro:hasAnyRoles name="root,admin">
		存在条件中的任意一种角色
	</shiro:hasAnyRoles>
	<hr>
	<!-- 判断当前用户的角色中是否有拥有条件权限 -->
	<shiro:hasPermission name="user:add">
		当前用户的角色中有add权限
	</shiro:hasPermission>
	<hr>
	<!-- 判断当前用户的角色中是否有缺失条件权限 -->
	<shiro:lacksPermission name="user:aaa">
		当前用户的角色中缺失user:aaa权限
	</shiro:lacksPermission>
	<hr>
	</body>
</html>
