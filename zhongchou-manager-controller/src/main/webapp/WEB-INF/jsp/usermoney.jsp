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