<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<div class="col-sm-3 col-md-2 sidebar">
		<ul class="nav nav-sidebar">
            <li class="active"><a href="javascript:ToClick('inde')">首页</a></li>
        </ul>
		<ul class="nav nav-sidebar">
            <li><a href="javascript:ToClick('selectAll?page=1')">所有项目*</a></li>
            <li><a href="javascript:ToClick('selectType')">项目审核</a></li>
            <li><a href="javascript:ToClick('comment?page=1')">项目评论</a></li>
            <li><a href="javascript:ToClick('classify?page=1')">项目分类</a></li>
            <li><a href="javascript:ToClick('recommend?page=1')">项目推荐</a></li>
          </ul>
		  
		  <ul class="nav nav-sidebar">
            <li><a href="javascript:ToClick('admin/toadd_admin')">管理员添加</a></li>
            <li id="adminUsernameS"><a href="javascript:ToClick('admin/account_admin')">管理员账号</a></li>
          </ul>
		  
		  
          <ul class="nav nav-sidebar">
			<li><a href="javascript:ToClick('usermanage')">管理用户</a></li>
            <li><a href="javascript:ToClick('usermoney')">用户资金</a></li>
            <li><a href="javascript:ToClick('logsList')">用户日志</a></li>
            <li><a href="">实名审核</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">新闻管理</a></li>
            <li><a href="javascript:ToClick('parentQuestionall')">问题管理</a></li>
            <li><a href="">管理日志</a></li>
          </ul>
	</div>
	<script type="text/javascript">

		function ToClick(url){
			
			$.ajax({
				//请求方式
	            type : "POST",
	            //请求的媒体类型
	            contentType: "text/html;charset=UTF-8",
	            //请求地址
	            url : "/"+url,
	            //数据，json字符串
	            //data : JSON.stringify(list),
	            //请求成功
	            success : function(result) {
	                //console.log(result);
	                $("#include").html(result);
	            }
			},true);
		}
	</script>
</body>
</html>