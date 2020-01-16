<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>权限页面</title>
</head>
<body>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">管理员账号权限</h1>
		
			<div class="panel-heading">
				<div class="panel-title">用户名，<font color="red">${admin_ju_name.adminName}</font> </div>
			</div>
			
			<input type="hidden" value="${admin_ju_name.adminId}" id="adminId">
		<div class="table-responsive ">
							<table class="table table-striped table-bordered">
								<thead>
								
									<tr>
										<th>权限名</th>
										<th>操作</th>
									</tr>
								</thead>
								
									<TR>
										
									<TD>管理员权限</TD>
									<TD>
										<input type="checkbox" id="checkAll">
									</TD>
									
									
										
									</TR>
									<TR>
										
									<TD>用户权限</TD>
									<TD>
										<input type="checkbox" id="checkAlll">
									</TD>
									
									
										
									</TR>
									<a href="javascript:ToClick('admin/account_admin')" type="hidden" id="tgadmin"></a>
								<script>
									function ooo(){
										var list;
										//alert($("#checkAll").is(":checked"))
										if($("#checkAll").is(":checked") && $("#checkAlll").is(":checked")){
											alert("只能选择一个权限~~~");
											return false;
										}else if(!$("#checkAll").is(":checked") && !$("#checkAlll").is(":checked")){
											alert("必须选择一个权限~~~");
											return false;
										}else{
											if($("#checkAll").is(":checked")){
												list={"quanxian":"admin","adminId":$("#adminId").val()};
											}else{
												list={"quanxian":"user","adminId":$("#adminId").val()};
											}
											$.ajax({
												//请求方式
											    type : "POST",
											    //请求的媒体类型
											    //contentType: "text/html;charset=UTF-8",
											    //请求地址
											    url : "/adminJurisdiction",
											    //数据，json字符串
											    data : list,
											    //请求成功
											    success : function(result) {
											        console.log(result);
											        if(result.status==200){
											        	alert(result.data);
											        	document.getElementById("tgadmin").click();
											        }else if(result.status==500){
											        	alert(result.data);
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
									}
								</script>

							</table>
							
							<button onclick="javascript:ooo()" type="submit" class="btn btn-default btn-primary pull-left check()">保存</button>
							<button onclick="javascript:ToClick('admin/account_admin')" type="submit" class="btn btn-default btn-primary pull-left check()">取消</button>
						</div>
	</div>
</body>
</html>