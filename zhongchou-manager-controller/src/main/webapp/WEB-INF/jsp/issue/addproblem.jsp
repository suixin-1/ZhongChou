<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>父问题</title>
</head>
<body>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">添加主问题</h1>

            <div class="panel panel-default">
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title">
                        添加父问题
                    </div>
                </div>
                <div class="panel-body">

                    <div class="table-responsive ">
                        <div>
                            
                            <div class="form-group">
                               <textarea type="text" id="questionname"class="form-control" rows="3" placeholder="问题名称"></textarea>
                            </div>
                            &nbsp;&nbsp;
                            <button class="btn btn-default btn-primary pull-right" onclick="javascript:addQuestionall('addQuestionall')">添加</button>
                            &nbsp;<button class="btn btn-default btn-primary pull-right" onclick="javascript:ToClick('parentQuestionall')" style="margin-right: 20px;">返回</button>
                        </div>
                    </div>
                </div>
            </div>
			<script type="text/javascript">
				function addQuestionall(url){
					var re = new RegExp(" ","g");
					var questionname = $("#questionname").val().trim().replace(re,"");
					
					if(questionname.length>0){
						var list={"questionname":questionname}
						$.ajax({
							//请求方式
				            type : "POST",
				            //请求的媒体类型
				            //contentType: "text/html;charset=UTF-8",
				            //请求地址
				            url : "/"+url,
				            //数据，json字符串
				            data : list,
				            //定义返回数据类型json
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
				        	            url : "/parentQuestionall",
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
					}else{
						alert("请输入父问题的名字");
					}
	
				}
				
			</script>
        </div>
</body>
</html>