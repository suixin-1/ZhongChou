<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>子问题详情</title>
	</head>
<body>
       <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">添加子问题</h1>

            <div class="panel panel-default">
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title">
                        添加子问题
                    </div> 
                </div>
                <div class="panel-body">

                    <div class="table-responsive ">
                        <div>
                        	<div class="form-group">
							   <select class=form-control id="questionall" >
							   		<c:forEach items="${questionall }" var="p" varStatus="s">
							   			<option value="${p.questionid}">${p.questionname}</option>
							   		</c:forEach>
							   </select>
							  </div>
                        
                            <div class="form-group">
                                <input type="text" class="form-control" id=questionothername placeholder="子问题名字" value="${questionother.questionothername }">
                            </div>
							
							<div class="form-group">
                                <input type="text" class="form-control" id="questionanswer" placeholder="子问题答案" value="${questionother.questionanswer }">
                            </div>
	
                            &nbsp;&nbsp;
                            <button class="btn btn-default btn-primary pull-right" onclick="javascript:ToClickSubmit2('addQuestionother')">添加</button>
		                        </div>
		                    </div>
		                </div>
		            </div>
						
						
						 <script type="text/javascript">
                    
                    function ToClickSubmit2(url){
				    	/* $("#p_id").val();
				        $("#p_name").val();
				        $("#p_des").val();
				        $("#p_time").val();
				        $("#p_status").val(); */
				        
				        var list={"questionothername":$("#questionothername").val(),"questionanswer":$("#questionanswer").val(),"questionall":$("#questionall").val()};
				        
				        $.ajax({
							//请求方式
				            type : "POST",
				            //请求的媒体类型
				           // contentType: "text/html;charset=UTF-8",
				            //请求地址
				            url : "/"+url,
				            //数据，json字符串
				            //data : "p_id="+$("#p_id").val()+"&p_name="+$("#p_name").val()+"&p_des="+ $("#p_des").val()+"&p_status="+$("#p_status").val(),
				          	data : list,
				          	dataType:"json",
				            //请求成功
				            success : function(result) {
				                console.log(result);
				                if(result.status==200){
				                	alert(result.msg);
				                	$.ajax({
				        				//请求方式
				        	            type : "GET",
				        	            //请求的媒体类型
				        	            contentType: "text/html;charset=UTF-8",
				        	            //请求地址
				        	            //?questionid=${p.questionid}&questionname=${p.questionname }
				        	            url : "/ToQuestionother?questionid="+$("#questionall").val()+"&questionname="+$("#questionall option:selected").text(),
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
						},true);
				    }
                    </script>
						
		        </div>
</body>
</html>