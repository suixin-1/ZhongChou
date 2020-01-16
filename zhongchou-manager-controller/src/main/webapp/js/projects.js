
// 所有项目功能方法
function ToClickSubmit2(url) {

	$.ajax({
		// 请求方式
		type : "POST",

		url : "/" + url,

		// data : list,
		// 请求成功
		success : function(result) {

			$("#include").html(result);
		}

	}, true);
}