<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>product-info1</title>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">用户日志</h1>

		<div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">用户日志信息</h3>
				</div>
			  <div class="panel-body">
				    
				    <table class="table table-bordered">
				    	
					  <%-- <tr>
					  	<th>日志ID</th>
					  	<td>${logs.logUsId}</td>
					  </tr> --%>
					  <tr>
					  	<th>用户姓名 </th>
					  	<td>${user.usName}</td>
					  </tr>
					  <tr>
					  	<th>日志内容</th>
					  	<td>${logs.logContent}</td>
					  </tr>
					 
					</table>
				  </div>
			</div>
		</div>
	</div>

</body>


</html>


