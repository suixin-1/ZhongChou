<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员添加</title>
</head>
<body>
      
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">新增管理员</h1>

            <div class="panel panel-default">
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title">
                       		 新增管理員
                   		 </div></br>
                    		<div name="addadmin-form" >
 								<tr height="40px">
                                <td>
                                    用户名
                                </td>
                                <td>
                                    <font color="red">*&nbsp;&nbsp;&nbsp;&nbsp; </font><input type="text" name="user" size="32px" id="user" 
                                        onfocus="showTips('user','用户名必须填！')" onblur="checkuser('user','用户名不能为空')"/>
                                    <span id="userspan"></span>
                                </td>
                            </tr>
                            </br>
                            </br>
                            <tr height="40px">
                                <td>
                                    密码
                                </td>
                                <td>
                                    <font color="red">*&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><input type="password" name="password" id="password" size="32px" 
                                    onfocus="showTips('password','密码必须填！')" onblur="checkuser('password','密码不能为空')"/>
                                        <span id="passwordspan"></span>
                                </td>
                            </tr>
                            </br>
                            </br>
                            <tr height="40px">
                                <td>
                                    确认密码
                                </td>
                                <td>
                                    <font color="red">*</font> <input type="password" name="repassword" id="repassword" size="32px" 
                                    onfocus="showTips('repassword','确认密码必须填！')" onblur="checkuser('repassword','确认密码不能为空')"/>
                                        <span id="repasswordspan"></span>
                                </td>
                            </tr>
                            </br>
                            </br>
                            <button onclick="javascript:addAdmin()" type="submit" class="btn btn-default btn-primary pull-left check()">添加</button></br></br>
                        </div>
                    </div>
                </div>
            </div>

     
<script type="text/javascript">

	var Addstatus=false;
	var adminUsernameS=false;
	
	 //验证添加字段是否为空
	function showTips(id,info){
        document.getElementById(id+"span").innerHTML="<font color='gray'>"+info+"</font>"
    }
    
    function checkuser(id,info){
        //1.获取用户输入的用户名数据
        var uValue=document.getElementById(id).value;
        //2.进行效验
        if(uValue==""){
            document.getElementById(id+"span").innerHTML="<font color='gray'>"+info+"</font>"
            return false;
        }else{
            document.getElementById(id+"span").innerHTML=""
        }
        $.ajax({
			//请求方式
            type : "GET",
            //请求的媒体类型
            contentType: "text/html;charset=UTF-8",
            //请求地址
            url : "/admin/verifyUsername",
            //数据，json字符串
            data : "verifyUsername="+$("#user").val(),
            dataType:"json",
            //请求成功
            success : function(result) {
               // console.log(result);
               if(result.status==200){
            	   $("#userspan").html("<font color='green'>"+result.msg+"</font>");
            	   adminUsernameS=true;
               }else{
                	$("#userspan").html("<font color='red'>"+result.msg+"</font>");
                	adminUsernameS=false;
               }
            }
            //请求失败，包含具体的错误信息
            /* error : function(e){
                console.log(e.status);
                console.log(e.responseText);
            } */
		},true);	
    }
	
	
	/* function CheckForm(){
		if (document.addadmin-form.password.value != document.addadmin-form.repassword.value) {
  		 alert("您两次输入的密码不一样！请重新输入.");
   		
   		return false;
		}
  		 return true;
	} */

	function addAdmin(){
		
		if ($("#password").val() != $("#repassword").val()) {
	  		 alert("您两次输入的密码不一样！请重新输入.");
		}else{
			if($("#user").val().trim().length==0){
				Addstatus=false;
				alert("用户名不能为空！");
			}else if(adminUsernameS){
				Addstatus=true;				
			}
		}
		
		if(Addstatus && adminUsernameS){
			var list={"user":$("#user").val(),"password":$("#repassword").val()};
			$.ajax({
				//请求方式
	            type : "GET",
	            //请求的媒体类型
	            contentType: "text/html;charset=UTF-8",
	            //请求地址
	            url : "/admin/Admin_add",
	            //数据，json字符串
	            data : list,
	            //请求成功
	            success : function(result) {
	                //console.log(result);
	                $("#include").html(result);
	                
	                var liLength=$(".nav-sidebar>li");
					//左边栏
			   	 				   	 		
			   	 			for(var j=0;j<liLength.length;j++){
			   	 				//alert("cd");
			   	 				$(liLength[j]).removeClass("active");
			   	 			}
			   	 			$("#adminUsernameS").addClass("active");
			   	 		
			   	 	
	                
	            }
	            //请求失败，包含具体的错误信息
	            /* error : function(e){
	                console.log(e.status);
	                console.log(e.responseText);
	            } */
			},true);	
		}
	}
</script>
</body>
</html>