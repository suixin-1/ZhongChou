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
</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">用户日志</h1>

		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">用户日志列表</div>
			</div>
			<div class="panel-body">

				<div class="table-responsive ">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>日志id</th>
								<th>用户ID</th>
								<th>日志内容</th>
								<th>操作</th>
							</tr>
						</thead>
						<c:forEach items="${list }" var="logs">
							<TR>

								<TD>${logs.logId }</TD>
								<TD>${logs.logUsId }</TD>
								<TD>${logs.logContent }</TD>
								<TD><a href="javascript:ToClick('goLogsUpdate?id=${logs.logId}')">详情</a> | <a
									href="javascript:TologsDelete('logsDelete?id=${logs.logId }')">删除</a></TD>

							</TR>

						</c:forEach>

					</table>
				</div>

				<TR>
					<TD><SPAN id=pagelink>
							<DIV style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
								共[<B>${pb.total}</B>]条记录,[<B id="pagesAll">${pb.pages}</B>]页
								,每页显示 <select id="count" onchange="javascript:account_admin(1)">

									<c:choose>
										<c:when test='${pb.pageSize==5 }'>
											<option value="5" selected="selected">5</option>
											<option value="10">10</option>
											<option value="15">15</option>
										</c:when>
										<c:when test='${pb.pageSize==10 }'>
											<option value="5">5</option>
											<option value="10" selected="selected">10</option>
											<option value="15">15</option>
										</c:when>
										<c:when test='${pb.pageSize==15 }'>
											<option value="5">5</option>
											<option value="10">10</option>
											<option value="15" selected="selected">15</option>
										</c:when>
									</c:choose>


									<!-- <option value="10">10</option>
													    <option value="15">15</option> -->
								</select> 条

								<c:choose>
									<c:when test='${pb.pageNum>1 }'>
													[<A href="javascript:account_admin(${pb.pageNum-1})">前一页</A>]
												</c:when>
								</c:choose>

								<%-- [<A href="javascript:account_admin(${pb.pageNum-1})">前一页</A>] --%>
								<B>${pb.pageNum}</B>

								<c:choose>
									<c:when test='${pb.pages>pb.pageNum }'>
													[<A href="javascript:account_admin(${pb.pageNum+1})">后一页</A>] 
												</c:when>
								</c:choose>

								<%-- [<A href="javascript:account_admin(${pb.pageNum+1})">后一页</A>]  --%>

								到 <input type="text" size="3" id="page" name="page" value="1" />
								页 <input type="button" value="Go" onclick="to_page()" />
							</DIV>
					</SPAN></TD>

				</TR>

			</div>

		</div>

	</div>
</body>

<script>
	function to_page() {
		var pages = $("#page").val();
		//共几页
		var pagesAll = $("#pagesAll").html();

		if (pages > 0 && pages <= pagesAll) {
			account_admin(pages);
		} else {
			alert("输入的页数不正确！");
		}

	}

	function TologsDelete(url){
		$.ajax({
			//请求方式
			type : "GET",
			//请求的媒体类型
			contentType : "text/html;charset=UTF-8",
			//请求地址
			url : "/"+url,
			//数据，json字符串
			//data : list,
			//请求成功
			dataType:"json",
			success : function(result) {
				//console.log(result);
				if(result.status==200){
					$.ajax({
						//请求方式
			            type : "POST",
			            //请求的媒体类型
			            contentType: "text/html;charset=UTF-8",
			            //请求地址
			            url : "/logsList",
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
					},true);
				}else if(result.status==500){
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
	
	function account_admin(pages) {
		var list = {
			"count" : $("#count").val(),
			"pages" : pages
		};
		$.ajax({
			//请求方式
			type : "GET",
			//请求的媒体类型
			contentType : "text/html;charset=UTF-8",
			//请求地址
			url : "/logsList",
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

</html>