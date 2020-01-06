<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>products</title>
</head>
<body>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">项目进度</h1>

		
			<ul class="nav nav-tabs">
		  <li role="presentation" class="active"><a href="product-info1.html">基本信息</a></li>
		  <li role="presentation"><a href="javascript:ToClickSubmit2('selectMessage?id=${fbd.psId}')">项目信息</a></li>
		  <li role="presentation"><a href="javascript:ToClickSubmit2('selectComment?id=${fbd.psId}')">项目评论</a></li>
		  <li role="presentation"><a href="javascript:ToClickSubmit2('selectSchedule?id=${fbd.psId}')">项目进度</a></li>
		  <li role="presentation"><a href="product-info5.html">项目跟踪</a></li>
		</ul>
		

		
   
			<div class="panel panel-default">
  <div class="panel-heading">
    <div class="panel-title">
    	所有项目列表
    </div>
  </div>
  <div class="panel-body">
   
          <div class="table-responsive ">
            <table class="table table-striped table-bordered">
              <thead>
                <tr>

                  <th>项目名称</th>  
                 <th>开始日期</th>
                  <th>结束日期</th>
                    <th>已筹金额</th>
                     
                   <th>项目进度</th>
                 
                </tr>
              </thead>
              <tbody id="tbody_list">
             
                <tr>
                  
                
                  <td>${fbd.psName}</td>  
                  <td><fmt:formatDate value="${fbd.psStarttime}" pattern="yyyy-MM-dd" /></td>  
                  <td><fmt:formatDate value="${fbd.psEndtime}" pattern="yyyy-MM-dd" /></td>
                  <td>${fbd.psGetmoney}</td> 
                  <td>${fbd.psGetmoney/fbd.psMoney}%</td>
                </tr>
                
           
              </tbody>
            </table>
          </div>

  	             
				     
				    
				    </li>
				  </ul>
				</nav>   	
			  </div>
			 
			
			</div>
			      
			        </div>
			     
			       
</body>
</html>