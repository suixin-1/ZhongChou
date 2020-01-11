<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>product-info1</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/projects.js"></script>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">${fbd.psName}</h1>

		<ul class="nav nav-tabs">
			<li role="presentation"><a
				href="javascript:ToClickSubmit2('selectById?id=${fbd.psId}')">基本信息</a></li>
			<li role="presentation"><a
				href="javascript:ToClickSubmit2('selectMessage?id=${fbd.psId}')">项目信息</a></li>
			<li role="presentation" class="active"><a
				href="javascript:ToClickSubmit2('selectSchedule?id=${fbd.psId}')">项目进度</a></li>
		</ul>
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">项目 <font color="red">${fbd.psName}</font> 列表</div>
			</div>
			<div class="panel-body">

				<div class="table-responsive ">
					<table class="table table-striped table-bordered">
						<tbody id="tbody_list">
							<tr>
								<th>项目名称</th>
								<td>${fbd.psName}</td>
							</tr>
							<tr>
								<th>开始日期</th>
								<td><fmt:formatDate value="${fbd.psStarttime}"
										pattern="yyyy-MM-dd" /></td>
							</tr>
							<tr>
								<th>结束日期</th>
								<td><fmt:formatDate value="${fbd.psEndtime}"
										pattern="yyyy-MM-dd" /></td>
							</tr>
							<tr>
								<th>已筹金额</th>
								<td>${fbd.psGetmoney}</td>
							</tr>
							<tr>
								<th>项目进度</th>
								<td>${fbd.psGetmoney/fbd.psMoney}%</td>
							</tr>
						
						

							


								
								
								
								
								
							


						</tbody>
					</table>
				</div>
			</div>


		</div>
	</div>
</body>
</html>
