<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
	
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">众筹项目分类</h1>

            <div class="panel panel-default">
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title"> 项目分类列表  <a class="btn btn-primary" href="javascript:ToClick('add_classity')">添加</a>
                    </div>
                </div>
                <div class="panel-body">

                    <div class="table-responsive ">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>分类名称</th>
                                <th>分类描述</th>
                                <th>添加时间</th>
                                <th>分类状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach  items="${Projectstype }" var="p" varStatus="s">
                         						<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${s.index+1 }</TD>
													<TD>${p.pstName }</TD>
													<TD>${p.pstDesc }</TD>
													<TD><fmt:formatDate value="${p.pstStardate}" pattern="yyyy-MM-dd" /></TD>
													<TD>
													<c:choose><c:when test='${p.pstType==0 }'>可用</c:when><c:when test='${p.pstType==1 }'>禁用</c:when></c:choose>
													</TD>
													
													<TD>
												 <a href="javascript:XQgetTable('motaikuang?id=${p.pstId}')">详情/修改</a> |
                                    <a href="javascript:getdel(${p.pstId })">删除</a>
													</TD>
												</TR>
												
												
								</c:forEach>

                            </tbody>
                        </table>
                    </div>
                   <!--模态框-->
                 
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
				    function XQgetTable(urlid){
				    	$.ajax({
							//请求方式
				            type : "GET",
				            //请求的媒体类型
				           // contentType: "text/html;charset=UTF-8",
				            //请求地址
				            url : "/"+urlid,
				          	//data : list,
				            //请求成功
				            success : function(result) {

				                
				                $("#include").html(result);
				            }
				            //请求失败，包含具体的错误信息
				            /* error : function(e){
				                console.log(e.status);
				                console.log(e.responseText);
				            } */
						},true);
				    }
				   /*  function getdel(id){
				        javascript:$('body').dailog({type:'danger',title:'错误.',discription:'您确定要删除ID为'+id+'的数据吗?'},
				            function(ret) {
				                if(ret.index===0){
				                	   window.location.href="/delclassity?pstId="+id;
				                };
				            })
				    } */
				    
				    function getdel(id){
				    	 if (confirm("是否删除"+id)) {
				    		   	$.ajax({
									//请求方式
						            type : "GET",
						            //请求的媒体类型
						           // contentType: "text/html;charset=UTF-8",
						            //请求地址
						            url : "/delbyId?pstId="+id,
						          	//data : list,
						            //请求成功
						            success : function(result) {

						                
						                $("#include").html(result);
						            }
						            //请求失败，包含具体的错误信息
						            /* error : function(e){
						                console.log(e.status);
						                console.log(e.responseText);
						            } */
								},true);
				    		  } else {
				    		   alert();
				    		  }
				 
				    }
				    
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
				    		    url : "/classify",
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