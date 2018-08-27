<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
        <c:if test="${empty requestScope.catForms }">
		    
	                </c:if>  
         <c:if test="${!empty requestScope.catForms }">
	       <div class="row">
			<div class="col-md-8">
				<table class="table table-hover" >
					<thead>
						<tr>
						
							<th>ID</th>
							<th>主题</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					   <c:forEach items="${catForms}" var="cat"> 
				           
							<tr>
								<th>${cat.topicId }</th>
								<th>${cat.topicName }</th>
								<th>${stuForms.newsText }</th>
								<th>${stuForms.topicId }</th>
								<th>${stuForms.newsTime }</th>
			
								 <td><a href="/News/update.cat?id=${cat.topicId  }">
								<button type="button"  class="btn btn-success"><span class="glyphicon glyphicon-pencil" ></span>修改</button></a></td>
							
								<td><a href="/News/delete.cat?method=deletecat&id=${cat.topicId }">
								<button type="button"  class="btn btn-danger">删除</button></a></td> 
								
							</tr>
						 </c:forEach> 
					</tbody>
				</table>
			</div>
		</div>                    
      <%--    <table border="1" cellpadding="10" cellspacing="0">	              
					        <tr>
								<td>ID</td>
								<td>主题</td>
								<td>操作</td>
							</tr>	  
						<c:forEach items="${catForms}" var="cat"> 
				           
							<tr>
								<td>${cat.topicId }</td>
								<td>${cat.topicName }</td>
								<td><a href="/News/update.cat?id=${cat.topicId  }">修改</a></td>
							
								<td><a href="/News/delete.cat?method=deletecat&id=${cat.topicId }">删除</a></td>
								
							</tr>
						 </c:forEach> 
					</table> --%>
                </c:if>
                
                
                <br><br>
                
          
</body>
</html>