<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 <style>
#con{margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 0px;
    margin-left: 0px;} 

</style> 
<script type="text/javascript">
function ToClickSubmit2(url){
	  $.ajax({
				//请求方式
	            type : "POST",
	            //请求地址
	            url : "/"+url,
	            //	data : list,
	            //请求成功
	            success : function(result) { 
	               $("#include").html(result);
	            }
	          
			},true);
	    }
      function ToClickSubmit3(url){
			  $.ajax({
						//请求方式
			            type : "POST",
			            //请求地址
			            url : "/"+url,
			            // data : list,
			            //请求成功
			            success : function(result) { 
			               $("#include").html(result);
			            }
			          
					},true);
			    } 

</script>
</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">项目详情信息审核</h1>
   <div id="con">
   		<table  class="table table-bordered">				    	
					  <tr>
					  	<th>用户名</th>
					  	<td>${list.usName}</td>
					  </tr>
					  <tr>
					  	<th>身份证号</th>
					  	<td>${list.usIdcard}</td>
					  </tr>
					  <tr>
					  	<th>手机号</th>
					  	<td>${list.usPhone}</td>
					  </tr>
					  <tr>
					  	<th>用户地址</th>
					  	<td>${list.usAddress}</td>
					  </tr>
					  <tr>
					  	<th>客服联系人</th>
					  	<td>${list1.psCustName}</td>
					  </tr>
					  <tr>
					  	<th>客服联系电话</th>
					  	<td>${list1.psCustPhone}</td>
					  </tr>
					   <tr>
					  	<th>项目地点</th>
					  	<td>${list1.psAddress}</td>
					  </tr>
					  <tr>
					  	<th>筹款目的</th>
					  	<td>${list1.psGoal}</td>
					  </tr>
					  <tr>
					  	<th>项目金额</th>
					  	<td>${list1.psMoney}</td>
					  </tr>
					  <tr>
					  	<th>筹资天数</th>
					  	<td>${list1.psDays}</td>
					  </tr>
					</table>
			   </div>
			   <div align="center">
			   			<h2>项目图片展示</h2><br>
					   <img src="${list1.psFile}" width=640 height=480 /> 
				</div>	 
				<br>
				 <div align="center">
			   			<h2>项目视频展示</h2>
					    <video src="${list1.psVideo}"  width="640" height="480" controls="controls">
						Your browser does not support the video tag.
						</video>
				<br>
				<br>
				<br>		
				</div>	 
					<div id="div1" align="center">
					<h2>项目故事展示</h2>
					    ${list1.psStory}
					</div>
										
					<script type="text/javascript" src="/wangEditor.min.js"></script>
					<script type="text/javascript">
					    var E = window.wangEditor
					    var editor = new E('#div1')
					    editor.create()
					</script>    
<%-- 					  <tr>
					  	<th>项目故事</th>
					  	<td>${list1.psStory}</td>
					  </tr>  --%>
<%-- 					  <tr>
					  	<th>更多支持</th>
					  	<td>${list1.psSupport}</td>
					  </tr>
					  <tr>
					  	<th>提供回报</th>
					  	<td>${list1.psRepay}</td>
					  </tr>
					  <tr>
					  	<th>关于自己</th>
					  	<td>${list1.psAboutme}</td>
					  </tr>
					  <tr>
					  	<th>具体规则</th>
					  	<td>${list1.psAboutme}</td>
					  </tr>
					  <tr>
					  	<th>具体规则</th>
					  	<td>${list1.psAboutme}</td>
					  </tr>
					  <tr>
					  	<th>回报内容</th>
					  	<td>${list1.psAboutme}</td>
					  </tr>
					  <tr>
					  	<th>人数上限</th>
					  	<td>${list1.psAboutme}</td>
					  </tr>
					  <tr>
					  	<th>回报时间</th>
					  	<td>${list1.psAboutme}</td>
					  </tr> --%>
				<br>
				<br>
				<br>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" >
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-primary" type="button" onclick="javascript:ToClickSubmit2('updateById?id=${list1.psId}')">审核通过</button>
    	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	 <button class="btn btn-primary" type="button" onclick="javascript:ToClickSubmit3('updateByPsId?id=${list1.psId}')">审核不通过</button>
 </div>

</body>
</html>