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
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="">
          <h1 class="page-header">所有众筹项目</h1>

		<div class="panel panel-default">
  <div class="panel-body">
			<div class="form-inline" >
			  <div class="form-group">
			    <input type="text" class="form-control"  placeholder="项目名称" id="psName">
			  </div>
			   <div class="form-group">
			    <input type="text" class="form-control"  placeholder="项目发起人" id="usName">
			  </div>
			  <div class="form-group">
			   <select class=form-control id="psType" >
			   	<option >项目状态</option>
			   	<option >众筹中</option>
			   	<option >众筹失败</option>
			   	<option >众筹成功</option>
			   	<option >待审核</option>
			   	<option >待上架</option>
			   	<option >审核未通过</option>
			   </select>
			  </div>
			   <div class="form-group">
			   <select class=form-control id="pstName">
			   	<option value="">项目类型</option>
			   	<option>教育助学</option>
			   	<option>爱心环保</option>
			   	<option>扶贫助困</option>
			   	<option>公益创业</option>
			   	<option>公益活动</option>
			   </select>
			  </div>
			  &nbsp;&nbsp;
			  <button class="btn btn-default btn-primary" onclick="javascript:ToClickSubmit2('selectAll')">查询</button>
			</div>
    </div>
   </div>
			<div class="panel panel-default">
  <div class="panel-heading">
    <div class="panel-title">
    	所有项目列表
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
                  <th>项目进度</th>
                  <th>开始日期</th>
                  <th>结束日期</th>
                  <th>已筹金额</th>
                  <th>发起人</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody id="tbody_list">
             <c:forEach items="${list }" var="p" varStatus="s">
                <tr>
                  <td>${s.index+1}</td>
                  <td>${p.pstName}</td>
                  <td>${p.psName}</td>
                  <td>${p.psGetmoney/p.psMoney}%</td>
                  <td><fmt:formatDate value="${p.psStarttime}" pattern="yyyy-MM-dd" /></td>
                  <td><fmt:formatDate value="${p.psEndtime}" pattern="yyyy-MM-dd" /></td>
                  <td>${p.psGetmoney}</td>
                  <td>${p.usName}</td>
                  <td>
                  	<a href="javascript:ToClick('selectById?id=${p.usId}')">详情</a>
                  	
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
			        function ToClickSubmit2(url){
				    	/* $("#p_id").val();
				        $("#p_name").val();
				        $("#p_des").val();
				        $("#p_time").val();
				        $("#p_status").val(); */
				        
				        var list={"pstName":$("#pstName").val(),"psName":$("#psName").val(),"psType":$("#psType").val(),"usName":$("#usName").val()};
				        
				        $.ajax({
							//请求方式
				            type : "POST",
				            //请求的媒体类型
				           	//contentType: "text/html;charset=UTF-8",
				            //请求地址
				            url : "/selectAll",
				            //数据，json字符串
				            //data : "p_id="+$("#p_id").val()+"&p_name="+$("#p_name").val()+"&p_des="+ $("#p_des").val()+"&p_status="+$("#p_status").val(),
				          	data : list,
				            //请求成功
				            success : function(result) {
				               // console.log(result);
				                //$("#myModal").css("display:none");
				                
				               $("#include").html(result);
				            }
				            //请求失败，包含具体的错误信息
				            /* error : function(e){
				                console.log(e.status);
				                console.log(e.responseText);
				            } */
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
				    		    url : "/selectAll",
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