<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员设置</title>
</head>
<body>
      
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">管理员设置</h1>

            <div class="panel panel-default">
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title">
                       		 管理员密码修改
                   		 </div></br>
                    		<div name="addadmin-form" >
 								<tr height="40px">
                                <td>
                                       原密码
                                </td>
                                <td>
                                    <font color="red">*&nbsp;&nbsp;&nbsp;&nbsp; </font><input type="password" name="user" size="32px" id="user" 
                                          onblur="checkuser('user','用户名不能为空')"/>
                                    <span id="userspan"></span>
                                </td>
                            </tr>
                            </br>
                            </br>
                            <tr height="40px">
                                <td>
                                    新密码
                                </td>
                                <td>
                                    <font color="red">*&nbsp;&nbsp; &nbsp;&nbsp;</font><input type="password" name="password" id="password" size="32px" 
                                    />
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
                                    />
                                        <span id="repasswordspan"></span>
                                </td>
                            </tr>
                            </br>
                            </br>
                            <button onclick="javascript:check()" type="submit" class="btn btn-default btn-primary pull-left ">确认修改</button></br></br>
                        </div>
                    </div>
                </div>
            </div>

     
<script type="text/javascript">
    function updateAdmin(){
    	list = {"user":$("#user").val(),"password":$("#password").val(),"repassword":$("#repassword").val()}
		$.ajax({
			//请求方式
			type : "POST",
			//请求的媒体类型
			  contentType: "text/html;charset=UTF-8",
			  //请求地址
	            url : "/setting_admin",
	            data:list,
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
	//$("#contentframework");
		
    }   
    
    function checkuser(id,info){
        //1.获取用户输入的用户名数据
        var uValue=document.getElementById(id).value;
        //2.进行效验       
        var list = {"password":$("#user").val(),"username":$("#admin-id").html()}
        $.ajax({
			//请求方式
            type : "GET",
            //请求的媒体类型
            contentType: "text/html;charset=UTF-8",
            //请求地址
            url : "/verify_admin",
            //数据，json字符串
            data : list,
            dataType:"json",
            //请求成功
            success : function(result) {
                console.log(result);
               if(result.status==200){
            	   $("#userspan").html("<font color='green'>"+result.msg+"</font>");
               }else{
                	$("#userspan").html("<font color='red'>"+result.msg+"</font>");
                	
               }
            }
		},true);	
    }
    
    function check(){  	
    	var list = {"username":$("#admin-id").html(),"password":$("#password").val()}
    	var pwd1 = $("#password").val();
    	var pwd2 = $("#repassword").val();
    	if(pwd1==pwd2){	
        $.ajax({
			//请求方式
            type : "GET",
            //请求的媒体类型
            contentType: "text/html;charset=UTF-8",
            //请求地址
            url : "/setting_admin",
            //数据，json字符串
            dataType:"json",
            data:list,
            //请求成功
            success : function(result) {
                console.log(result);
                alert("修改成功！")
            }
		},true);
    	}else{
    		alert("两次密码不一致，请检查！")
    	}
    }
    
</script>
</body>
</html>