<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
             <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>摸抬筐</title>
</head>
<body>
<div>
                        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                            <div class="">
                                <div class="modal-header">
                                   
                                    <h4 class="modal-title" id="myModalLabel">分类详情</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="form">
                                        <form class="form-validate form-horizontal" id="feedback_form"
                                              >
                                            <div class="form-group ">
                                                <label for="p_id" class="control-label col-lg-2">序号<span
                                                        class="required"> *</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="p_id" name="pstId" type="text" readonly="readonly" value="${projectstype.pstId}" />
                                                </div>
                                            </div>

                                            <div class="form-group ">
                                                <label for="p_name" class="control-label col-lg-2">分类名称<span
                                                        class="required"> *</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="p_name" name="pstName" type="text" value="${projectstype.pstName}" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="p_des" class="control-label col-lg-2">分类描述<span
                                                        class="required"> *</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="p_des" name="pstDesc" type="text" value="${projectstype.pstDesc}" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label for="p_time" class="control-label col-lg-2">添加时间<span
                                                        class="required"> *</span></label>
                                                <div class="col-lg-10">
                                                    <input class="form-control" id="p_time" name="pstStardate" type="text" readonly value="<fmt:formatDate value="${projectstype.pstStardate}" pattern="yyyy-MM-dd" />""  />
                                                </div>
                                            </div>

                                            <div class="form-group ">
                                                <label for="p_status" class="control-label col-lg-2">分类状态<span
                                                        class="required"> *</span></label>
                                                <div class="col-lg-10">
                                                    <select class="form-control m-bot15" id="p_status" name="pstType">
                                                   <!--<select class="form-control m-bot15" id="p_status" name="pstType">  -->  
                                                	<c:choose>
	                                                	<c:when test='${projectstype.pstType==0 }'>
		                                                	<option value='0' selected>可用</option>
		                                                	<option value='1'>禁用</option>
	                                                	</c:when>
	                                                	<c:when test='${projectstype.pstType==1 }'>
		                                                	<option value='0'>可用</option>
		                                                	<option value='1' selected>禁用</option>
	                                                	</c:when>
                                                	</c:choose>
                                                    
                                                     <%--  <c:forEach items="${projectstype }" var="p"> 	  
			                                         <option id="form-field-phone" name="form-field-phone" value='${p.pstType}'}>${p.pstType}</option>
		                                          </c:forEach> --%>

                                                        <!-- <option>禁用</option> -->
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="text-align: right;">
                                            </div>
                                        </form>
                                        <!--aaaaaaaaaaaaa  -->
                                                <div class="col-lg-offset-2 col-lg-10">
                                                    <button class="btn btn-primary" type="button" onclick="javascript:ToClickSubmit('save')">保存</button>
                                                    <button class="btn btn-default" type="reset">重置</button>
                                                </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <script type="text/javascript">
                    
                    function ToClickSubmit(url){
				    	/* $("#p_id").val();
				        $("#p_name").val();
				        $("#p_des").val();
				        $("#p_time").val();
				        $("#p_status").val(); */
				        
				        var list={"p_id":$("#p_id").val(),"p_name":$("#p_name").val(),"p_des":$("#p_des").val(),"p_status":$("#p_status").val()};
				        
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
				                $("#myModal").css("display:none");
				                
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