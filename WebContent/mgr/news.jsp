<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻编辑页面</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>



<c:if test="${empty requestScope.stuForms }">
		    
	                </c:if>  
         <c:if test="${!empty requestScope.stuForms }">
	      
	      
	      <div class="row">
			<div class="col-md-12">
				<table class="table table-hover" >
					<thead>
						<tr>
						
							<th>newsId</th>
							<th>新闻标题</th>
							<th>新闻内容</th>
							<th>新闻主题Id</th>
							<th>新闻发布时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					   <c:forEach items="${stuForms}" var="stuForms"> 
				           
							<tr>
								<th>${stuForms.newsId }</th>
								<th>${stuForms.newsName }</th>
								<th>${stuForms.newsText }</th>
								<th>${stuForms.topicId }</th>
								<th>${stuForms.newsTime }</th>
		
								 <td><a href="/News/update.new?id=${stuForms.newsId  }">
								<button type="button"  class="btn btn-success" id="news_add_modal"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改</button></a></td>
							  
								<td><a href="/News/delete.new?method=deletenew&id=${stuForms.newsId }">
								<button type="button"  class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除</button></a></td> 
								
							</tr>
						 </c:forEach> 
					</tbody>
				</table>
			</div>
		</div>          
        <%--  <table class="table table-hover">
					
	              
					    <tr>
								<td>newsId</td>
								<td>新闻标题</td>
								<td>新闻内容</td>
								<td>新闻主题Id</td>
								<td>新闻发布时间</td>
								<td>操作</td>
							</tr>	  
						<c:forEach items="${stuForms}" var="stuForms"> 
				           
							<tr>
								<td>${stuForms.newsId }</td>
								<td>${stuForms.newsName }</td>
								<td>${stuForms.newsText }</td>
								<td>${stuForms.topicId }</td>
								<td>${stuForms.newsTime }</td>
			
								<td><a href="/News/update.new?id=${stuForms.newsId  }">修改</a></td>
							
								<td><a href="/News/delete.new?method=deletenew&id=${stuForms.newsId }">删除</a></td>
								
							</tr>
						 </c:forEach> 
					</table> --%>
                </c:if>
</body>
</html>