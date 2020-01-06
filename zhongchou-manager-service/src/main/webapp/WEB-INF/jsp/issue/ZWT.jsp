<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>子问题页面</title>
</head>

<body>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">子问题列表</h1>

            <div class="panel panel-default">
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title">
                      <font color="red">${questionname}</font> |子问题列表  <a class="btn btn-primary" href="javascript:ToClick('ToaddQuestionother')">添加</a>
                    </div>
                </div>
                <div class="panel-body">

                    <div class="table-responsive ">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>子问题序号</th>
                                <th>主问题</th>
                                <th>子问题名字</th>
                                <th>问题的答案</th>
                                <th>问题创建的时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                           <c:forEach items="${list}" var="ZWT" varStatus="status">
									<TR
										style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
									<TD>${status.index+1}</TD>
									<TD id="questionname">${questionname}</TD> <input type="hidden" id="questionid" value="${ZWT.questionid }"/>
									<TD>${ZWT.questionothername}</TD>
									<TD>${ZWT.questionanswer}</TD>
									<TD>${ZWT.questiondate}</TD>
									
									<td><a href="javascript:ToClick('ToupdateQuestionother?id=${ZWT.questionotherid}&questionname=${questionname}')">详情/修改</a> <!--<a href="#" title="查看项目详情"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span></a>-->
										<!--&nbsp;&nbsp;
                  	<a href="#" title="编辑项目信息"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>-->
									<a href="javascript:ToClick('TodeleteQuestionother?id=${ZWT.questionotherid}')"  >删除</a> <!--<a href="#" title="查看项目详情"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span></a>-->
										<!--&nbs  p;&nbsp;
                  	<a href="#" title="编辑项目信息"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>-->
									</td>
									</TR>

								</c:forEach>  
                        </table>
                    </div> 
                    
                    		<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${pb.total}</B>]条记录,[<B id="pagesAll">${pb.pages}</B>]页
												,每页显示
													<select id="count" onchange="javascript:all_classity(1)">													
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
												  </select>	
												条
												
												<c:choose>
												<c:when test='${pb.pageNum>1 }'>
													[<A href="javascript:all_classity(${pb.pageNum-1})">前一页</A>]
												</c:when>
												</c:choose>
												
												<B>${pb.pageNum}</B>
												
												<c:choose>
												<c:when test='${pb.pages>pb.pageNum }'>
													[<A href="javascript:all_classity(${pb.pageNum+1})">后一页</A>] 
												</c:when>
												</c:choose>

												到
												<input type="text" size="3" id="page" name="page" value="1"/>
												页
												
												<input type="button" value="Go" onclick="to_page()"/>
											</DIV>
									</SPAN></TD>
								
								</TR>
                    
                    
                    
                </div>
            </div>
        </div>
<script>
function to_page(){
  	 var pages = $("#page").val();
  	 //共几页
  	 var pagesAll = $("#pagesAll").html();
  	 
  	 if(pages>0 && pages<=pagesAll){
  		 all_classity(pages);
  	 }else{
  	  alert("输入的页数不正确！");
  	 }
  	 
  	}
  
  function all_classity(pages){
  	var list={"count":$("#count").val(),"pages":pages};
  		$.ajax({
  			//请求方式
  		    type : "GET",
  		    //请求的媒体类型
  		    contentType: "text/html;charset=UTF-8",
  		    //请求地址
  		    url : "/ToQuestionother?questionid="+$("#questionid").val()+"&questionname="+$("#questionname").html(),
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
  		},true);
  }
</script>

</body>
</html>