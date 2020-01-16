<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>product-info1</title>
<script type="text/javascript">
	function ToClickSubmit2(url) {
		$.ajax({
			//请求方式
			type : "POST",
			//请求地址
			url : "/" + url,
			//	data : list,
			//请求成功
			success : function(result) {
				$("#include").html(result);
			}

		}, true);
	}
	function TologsDelete(url) {
		$.ajax({
			//请求方式
			type : "GET",
			//请求的媒体类型
			contentType : "text/html;charset=UTF-8",
			//请求地址
			url : "/" + url,
			//数据，json字符串
			//data : list,
			//请求成功
			dataType : "json",
			success : function(result) {
				//console.log(result);
				if (result.status == 200) {
					$.ajax({
						//请求方式
						type : "POST",
						//请求的媒体类型
						contentType : "text/html;charset=UTF-8",
						//请求地址
						url : "/IdentityList",
						//数据，json字符串
						//data : JSON.stringify(list),
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
				} else if (result.status == 500) {
					alert(result.msg);
				}
				//$("#include").html(result);
			}
		//请求失败，包含具体的错误信息
		/* error : function(e){
		    console.log(e.status);
		    console.log(e.responseText);
		} */
		}, true);
	}
</script>
</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">实名审核</h1>

		<div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">用户实名审核信息</h3>
				</div>
				<div class="panel-body">

					<table class="table table-bordered">

						<%-- <tr>
					  	<th>日志ID</th>
					  	<td>${logs.logUsId}</td>
					  </tr> --%>
						<tr>
							<th>用户姓名</th>
							<td>${user.usName}</td>
						</tr>
						<tr>
							<th>身份证正面照</th>
							<td> <img src="${identity.usIdentityImage1}" width=340
								height=280 />
								 </td>
						</tr>
						<tr>
							<th>身份证反面照</th>
							<td><img src="${identity.usIdentityImage2}" width=340
								height=280 /></td>
						</tr>


					</table>


					<div
						class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="btn btn-primary" type="button"
							onclick="javascript:ToClickSubmit2('updateUser?id=${user.usId}')">审核通过</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button class="btn btn-primary" type="button"
							onclick="javascript:TologsDelete('IdentityDelete?id=${identity.usIdentityId}')">审核不通过</button>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>


</html>


