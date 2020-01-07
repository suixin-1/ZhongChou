<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">今日众筹</h1>

			        <div class="jumbotron">
						  <h2>今日新增众筹资金：<span id="moneyCount" style="color:#4b63bc;font-size: 1.2em;"></span>￥</h2>
						  <h5>昨日总众筹资金：18900￥</h5>
						  <h2>今日新增众筹项目：10</h2>
						  <h5>昨日新增众筹项目</h5>
						  <p><a class="btn btn-primary btn-lg" href="#" role="button">查看详细</a></p>
					</div>
			
			          <div><h2 class="sub-header" style="display: inline-block;">实时数据</h2><span style="display: inline-block;">(每5s自动刷新)</span></div>
			          <div class="table-responsive">
			            <table class="table table-striped">
			              <thead>
			                <tr>
			                  <th>时间</th>
			                  <th>类型</th>
			                  <th>记录</th>
			                  <th>操作</th>
			                </tr>
			              </thead>
			              <tbody>
			                <tr>
			                  <td>10秒前</td>
			                  <td>新众筹项目</td>
			                  <td>用户xxx发起了新的众筹项目xxxxx</td>
			                  <td><a href="#">查看项目</a></td>
			                </tr>
			                <tr>
			                  <td>15秒前</td>
			                  <td>项目达标</td>
			                  <td>众筹项目xxxxx已达标</td>
			                  <td><a href="#">查看项目</a></td>
			                </tr>
			                 <tr>
			                  <td>20秒前</td>
			                  <td>众筹资金</td>
			                  <td>用户xxx参与了众筹项目xxxxx</td>
			                  <td><a href="#"></a></td>
			                </tr>
			                 <tr>
			                  <td>1分前</td>
			                  <td>项目达标</td>
			                  <td>众筹项目xxxxx已达标</td>
			                  <td><a href="#">查看项目</a></td>
			                </tr>
			                  <tr>
			                  <td>5分前</td>
			                  <td>众筹资金</td>
			                  <td>用户xxx参与了众筹项目xxxxx</td>
			                  <td><a href="#"></a></td>
			                </tr>
			               
			              </tbody>
			            </table>
			          </div>
			          <script type="text/javascript" src="js/jquery1.12.4.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/countUp.js" ></script>
		<script>
			$(document).ready(function() {
				
				var liLength=$(".nav-sidebar>li");
				//左边栏
		   	 	for(var i=0;i<liLength.length;i++){
		   	 		$(liLength[i]).click(function(){
		   	 			for(var j=0;j<liLength.length;j++){
		   	 				//alert("cd");
		   	 				$(liLength[j]).removeClass("active");
		   	 			}
		   	 			$(this).addClass("active");
		   	 		});
		   	 	}
				
				
				
				var options = {
					useEasing: true,
					useGrouping: true,
					separator: ',',
					decimal: '.',
				};
				var demo = new CountUp('moneyCount', 10000, 208965, 0, 2.5, options);
				if(!demo.error) {
					demo.start();
				} else {
					console.error(demo.error);
				}
			});
		</script>
			<!-- end -->	
			</div>
</body>
</html>