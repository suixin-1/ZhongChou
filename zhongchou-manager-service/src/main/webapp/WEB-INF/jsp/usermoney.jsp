<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>众筹管理后台</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">众筹管理平台</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">

			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.html">首页</a></li>
				<li><a href="#">欢迎, 张三</a></li>
				<li><a href="#" title="修改个人资料和密码的页面">设置</a></li>
				<li><a href="#" title="退出登录">退出</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="index.html">首页</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li ><a href="products.html">所有项目*</a></li>
					<li><a href="#">项目审核</a></li>
					<li><a href="#">项目跟踪</a></li>
					<li><a href="#">项目评论</a></li>
					<li><a href="classify/all_classity.html">项目分类*</a></li>
					<li><a href="#">项目推荐</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="/toadd_admin">管理员添加</a></li>
					<li class="active"><a href="">管理员账号</a></li>
					<li><a href="">用户资金</a></li>
					<li><a href="">用户日志</a></li>
					<li><a href="">实名审核</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="">新闻管理</a></li>
					<li><a href="">问题管理</a></li>
					<li><a href="">管理用户</a></li>
					<li><a href="">管理日志</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">账户余额</h1>

				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-title">账户余额</div>
					</div>
					<div class="panel-body">

						<div class="table-responsive ">
							<table class="table table-striped table-bordered">
								<thead>
								
									<tr>
										<th>我的余额</th>
									
									</tr>
								</thead>
								

							</table>
						</div>

							<TR>
									<TD><SPAN id=pagelink>
																			</SPAN></TD>
								</TR>
					</div>


				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery1.12.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/countUp.js"></script>
	<script>
		$(document).ready(function() {

			$.ajax({
				//请求方式
				type : "POST",
				//请求的媒体类型
				  contentType: "text/html;charset=UTF-8",
				  //请求地址
		            url : "/"+url,
		            //请求成功
		            success : function(result) {
		                //console.log(result);
		                $("#include").html(result);
		            }
			//请求失败，包含具体的错误信息
            /* error : function(e){
                console.log(e.status);
                console.log(e.responseText);
            } */
		},true);
		//$("#contentframework");
		
		});
	
	</script>
</body>
</html>