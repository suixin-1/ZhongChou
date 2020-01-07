<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>products</title>
</head>
<body>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">${fbd.psName}</h1>

		
			<ul class="nav nav-tabs">
		  <li role="presentation" class="active"><a href="javascript:ToClickSubmit2('selectById?id=${fbd.psId}')">基本信息</a></li>
		  <li role="presentation"><a href="javascript:ToClickSubmit2('selectMessage?id=${fbd.psId}')">项目信息</a></li>
		  <li role="presentation"><a href="javascript:ToClickSubmit2('selectComment?id=${fbd.psId}')">项目评论</a></li>
		  <li role="presentation"><a href="javascript:ToClickSubmit2('selectSchedule?id=${fbd.psId}')">项目进度</a></li>
		  <li role="presentation"><a href="product-info5.html">项目跟踪</a></li>
		</ul>
          
				
				 <div>
          		<div class="panel panel-default">
				  <div class="panel-heading">
				    <h3 class="panel-title">项目评论</h3>
				  </div>
				  <div class="panel-body">
		
					   <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>评论人</th>
                                <th>评论内容</th>
                               
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach  items="${list }" var="p" varStatus="s">
                         						<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${s.index+1 }</TD>
													<TD>${p.name }</TD>
													 <TD>${p.comment }</TD> 
												</TR>
												
												</c:forEach>
                            </tbody>
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