<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>add_classity</title>
</head>

<body>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">添加项目分类</h1>

            <div class="panel panel-default">
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title">
                        添加项目
                    </div> 
                </div>
                <div class="panel-body">

                    <div class="table-responsive ">
                        <div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="pstName" placeholder="分类名称">
                            </div>

                            <div class="form-group">
                               <textarea class="form-control" rows="3" id="pstDesc" placeholder="分类描述"></textarea>
                            </div>
                            &nbsp;&nbsp;
                            <button type="submit" class="btn btn-default btn-primary pull-right" onclick="javascript:ToClickSubmit2('add')">添加</button>
		                        </div>
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
				        
				        var list={"pstName":$("#pstName").val(),"pstDesc":$("#pstDesc").val()};
				        
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
				            //请求成功
				          	 dataType:"json",
					            success : function(result) {
					                //console.log(result);
					                
					                if(result.status==200){
					                	alert(result.msg);
					                	$.ajax({
					        				//请求方式
					        	            type : "GET",
					        	            //请求的媒体类型
					        	            contentType: "text/html;charset=UTF-8",
					        	            //请求地址
					        	            url : "/classify",
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
</body>
</html>