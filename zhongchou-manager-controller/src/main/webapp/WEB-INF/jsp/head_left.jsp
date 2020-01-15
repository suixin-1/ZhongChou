<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		          	<li><a href="javascript:ToClick('inde')">首页</a></li>
		          	<li><a href="#">欢迎,<span id="admin-id">${adminName}</span></a></li>
		            <li><a href="javascript:ToClick('admin/setting_admin')" title="修改个人资料和密码的页面">设置</a></li>
		            <li><a href="#" title="退出登录">退出</a></li>
		        </ul>
			</div>
		</div>
	</nav>
<script type="text/javascript">
function account_admin(pages) {
	var list = {
		"admin-id" : $("#adminName").val(),
	};
	$.ajax({
		//请求方式
		type : "GET",
		//请求的媒体类型
		contentType : "text/html;charset=UTF-8",
		//请求地址
		url : "/admin/setting_admin",
		//数据，json字符串
		data : list,
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
	}, true);
}
</script>
</body>
</html>