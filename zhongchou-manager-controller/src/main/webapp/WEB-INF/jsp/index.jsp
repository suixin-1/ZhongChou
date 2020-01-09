<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入JSTL资源  设置前缀 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>众筹项目后台管理系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
</head>

<body>
	<!--上部导航栏start-->
	<jsp:include page="head_left.jsp"></jsp:include>
	<!--上部导航栏end-->
	<div class="container-fluid">
		<div class="row">
			<!--左侧导航栏start-->
			<jsp:include page="left.jsp"></jsp:include>
			<!--左侧导航栏end-->
				<%-- <jsp:include page="${inpage}"></jsp:include> --%>
				<div id="include" style="overflow-y:scroll;" ><jsp:include page="${inpage}"></jsp:include></div>
		</div>
	</div>
</body>
</html>