<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>项目审核</title>
</head>
<body>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">项目审核</h1>

		
  
			<div class="panel panel-default">
  <div class="panel-heading">
    <div class="panel-title">
    	所有待审核项目列表
    </div>
  </div>
  
  <div class="panel-body">
   
          <div class="table-responsive ">
            <table class="table table-striped table-bordered">
              <thead>
                <tr>
                  <th>序号</th>
                  <th>项目类型</th>
                  <th>项目名称</th>                              
                   <th>  操作</th>
                </tr>
              </thead>
              <tbody id="tbody_list">
             <c:forEach items="${list }" var="p" varStatus="s">
                <tr>
                  <td>${s.index+1}</td>
                  <td>${p.pstName}</td>
                  <td>${p.psName}</td>   

                 <td>

                  	<a href="javascript:goParticulars('selectByPsId?usid=${p.usId}&psid=${p.psId}')"> 详情</a>
                  </td>
                </tr>
                
              </c:forEach>
              </tbody>
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
			       /*  function ToClickSubmit2(url){
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
						    } */
						    
				    function goParticulars(url){
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
				    		    url : "/selectType",
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