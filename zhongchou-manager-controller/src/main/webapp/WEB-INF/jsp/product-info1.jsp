<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>product-info1</title>
<body>
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">${fbd.psName}</h1>
		
			<ul class="nav nav-tabs">
		  <li role="presentation" class="active"><a href="javascript:ToClickSubmit2('selectById?id=${fbd.psId}')">基本信息</a></li>
		  <li role="presentation"><a href="javascript:ToClickSubmit2('selectMessage?id=${fbd.psId}')">项目信息</a></li>
		  <li role="presentation"><a href="javascript:ToClickSubmit2('selectComment?id=${fbd.psId}')">项目评论</a></li>
		  <li role="presentation"><a href="javascript:ToClickSubmit2('selectSchedule?id=${fbd.psId}')">项目进度</a></li>
		 <!--  <li role="presentation"><a href="product-info5.html">项目跟踪</a></li> -->
		</ul>
		
          <div>
          		<div class="panel panel-default">
				  <div class="panel-heading">
				    <h3 class="panel-title">申请人信息</h3>
				  </div>
				  <div class="panel-body">
				    <p>以下内容仅做示例</p>
				    <table class="table table-bordered">
				    	
					  <tr>
					  	<th>申请人</th>
					  	<td>${sbd.usName}</td>
					  </tr>
					  <tr>
					  	<th>申请人身份证</th>
					  	<td>${sbd.usIdcard}</td>
					  </tr>
					  <tr>
					  	<th>申请人地址</th>
					  	<td>${sbd.usAddress}</td>
					  </tr>
					  <tr>
					  	<th>客服联系人</th>
					  	<td>${sbpd.proACustName}</td>
					  </tr>
					  <tr>
					  	<th>客服联系电话</th>
					  	<td>${sbpd.proACustPhone}</td>
					  </tr>
					  <tr>
					  	<th>其它</th>
					  	<td>这只是个示例</td>
					  </tr>
					</table>
				  </div>
				</div>
				
				
		         <script> 
			        function ToClickSubmit2(url){
				    
				        
				       
				        
				        $.ajax({
							//请求方式
				            type : "POST",
				           
				            url :"/"+url,
				            
				            //	data : list,
				            //请求成功
				            success : function(result) {
				               
				               $("#include").html(result);
				            }
				           
						},true);
				    }
			        </script>
				
</body>
</html>