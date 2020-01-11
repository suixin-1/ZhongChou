<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/projects.js"></script>
<title>product-info1</title>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">${fbd.psName}</h1>

		<ul class="nav nav-tabs">
			<li role="presentation"><a
				href="javascript:ToClickSubmit2('selectById?id=${fbd.psId}')">基本信息</a></li>
			<li role="presentation" class="active"><a
				href="javascript:ToClickSubmit2('selectMessage?id=${fbd.psId}')">项目信息</a></li>
			<li role="presentation"><a
				href="javascript:ToClickSubmit2('selectSchedule?id=${fbd.psId}')">项目进度</a></li>
		</ul>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">项目<font color="red">${fbd.psName}</font> 信息</h3>
			</div>
			<div class="panel-body">
				<table class="table table-bordered">

					<tr>
						<th>项目类型</th>
						<td>${sbud.pstName}</td>
					</tr>
					<tr>
						<th>项目标题</th>
						<td>${fbd.psName}</td>
					</tr>
					<tr>
						<th>筹款目的</th>
						<td>${fbd.psGoal}</td>
					</tr>
					<tr>
						<th>项目地点</th>
						<td>${fbd.psAddress}</td>
					</tr>
					<tr>
						<th>筹资金额</th>
						<td>${fbd.psMoney}</td>
					</tr>
					<tr>
						<th>筹资天数</th>
						<td>${fbd.psDays}</td>
					</tr>
					<!-- <tr>
						<th>自定义标签</th>
						<td>xxxxxx,xxx,xx,xx,</td>
					</tr> -->
					<tr>
						<th>封面图</th>
						<td><img alt="" src="${fbd.psFile }" width="100" height="60"></td>
					</tr>
					<%-- <tr>
						<th>其它</th>
						<td>${fbd.psStory }</td>
					</tr> --%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>