<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
             <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<title>管理用户信息</title>
</head>
<body>
<div>
                        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                            <div class="">
                                <div class="modal-header">
                                   
                                    <h4 class="modal-title" id="myModalLabel">用户信息详情</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form">
                                        <div class="form-validate form-horizontal" id="feedback_form"
                                              >
                                           

                                            <div class="form-group ">
                                                 <label for="u_usEmail" class="control-label col-lg-2">用户邮箱<span
                                                        class="required"> *</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="u_usEmail" name="usEmail" type="text" value="${usermanage.usEmail}" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="u_usName" class="control-label col-lg-2">用户姓名<span
                                                        class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="u_usName" name="usName" type="text" value="${usermanage.usName}" />
                                                </div>
                                            </div>
                                            
                                             <div class="form-group ">
                                                <label for="u_usPassword" class="control-label col-lg-2">登录密码<span
                                                        class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="u_usPassword" name="usPassword" type="text" value="${usermanage.usPassword}" />
                                                </div>
                                            </div>

												 <div class="form-group ">
                                                <label for="u_usMoney" class="control-label col-lg-2">账户余额<span
                                                        class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="u_usMoney" name="usMoney" type="text" value="${usermanage.usMoney}" />
                                                </div>
                                            </div>
											
											 <div class="form-group ">
                                                <label for="u_usIdcardusIdcard" class="control-label col-lg-2">用户身份证号码<span
                                                        class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="u_usIdcardusIdcard" name="usIdcardusIdcard" type="text" value="${usermanage.usIdcard}" />
                                                </div>
                                            </div>
                                            
                                            <div class="form-group ">
                                                <label for="u_usPhone" class="control-label col-lg-2">手机号码<span
                                                        class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="u_usPhone" name="usPhone" type="text" value="${usermanage.usPhone}" />
                                                </div>
											
												 <div class="form-group ">
                                                <label for="u_usAddress" class="control-label col-lg-2">用户地址<span
                                                        class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="u_usAddress" name="usAddress" type="text" value="${usermanage.usAddress}" />
                                                </div>
                                            </div>
											
											 <div class="form-group ">
                                                <label for="u_usRole" class="control-label col-lg-2">用户状态(0.未激活 1.已激活)<span
                                                        class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="u_usRole" name="usRole" type="text" value="${usermanage.usRole}" />
                                                </div>
                                            </div>
                                            
                                             <div class="form-group ">
                                                <label for="u_sex" class="control-label col-lg-2">用户性别<span
                                                        class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="u_ussex" name="ussex" type="text" value="${usermanage.usSex}" />
                                                </div>
                                            </div>
											
											 
											
                                            <div class="form-group" style="text-align: right;">
                                            </div>
                                        </div>
                                        <!--aaaaaaaaaaaaa  -->
                                                <div class="col-lg-offset-2 col-lg-10">
                                                    <button class="btn btn-primary" type="button" onclick="javascript:ToClickSubmit('updatauser2')">保存</button>
                                                </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <script type="text/javascript">
                    
                    function ToClickSubmit(url){
				    	/* $("#l_logId").val();
				        $("#l_logUsId").val();
				        $("#l_logContent").val();
				         
				        */
				        var list={"u_usEmail":$("#u_usEmail").val(),"u_usName":$("#u_usName").val(),"u_usPassword":$("#u_usPassword").val(),
				        		 "u_usMoney":$("#u_usMoney").val(),"u_usIdcardusIdcard":$("#u_usIdcardusIdcard").val(),"u_usPhone":$("#u_usPhone").val()
				        		 ,"u_usAddress":$("#u_usAddress").val(),"u_usRole":$("#u_usRole").val(),"u_ussex":$("#u_ussex").val(),};
				        
				        		 
				       // var list={}
				        		 
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
				            success : function(result) {
				                //console.log(result);
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
                    </script>
</body>
</html>