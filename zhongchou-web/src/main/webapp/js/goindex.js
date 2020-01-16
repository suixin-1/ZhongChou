$.ajax({
			//请求方式
	        type : "POST",
	        //请求的媒体类型
	        contentType: "text/html;charset=UTF-8",
	        //请求地址


	        url : "gonnindex",


	        //数据，json字符串
	        //data : JSON.stringify(list),
	        //请求成功
	        dataType:"json",
	        success : function(result) {
	            console.log(result);
	            if(result.status==200){
	            	/* var ceshi1 = new Vue({
	            		el:"#ceshi",
	            		data:{
	            			items:result.data
	            		}
	            	}) */
	            	
	            	if(result.msg!="成功"){
	            		$("#index-login").html(result.msg);
	            	}
	            	
	            }
	           
	        }
		},true);