<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">

.panel-body{
   height:250px;
}
</style>
</head>
<body>

<div class="panel panel-primary" >
  <div class="panel-heading" ><h2 class="panel-title">国际新闻</h2></div>
  <div class="panel-body">
    <c:forEach items="${newFor }" var="newFor">
			<c:if test="${newFor.topicId==1}">
				<li>${newFor.newsName }</li>
			</c:if>

		</c:forEach>
  </div>
</div>

<div class="panel panel-primary">
  <div class="panel-heading">
    <h2 class="panel-title">国内新闻</h2>
  </div>
  <div class="panel-body">
   <c:forEach items="${newFor }" var="newFor">
			<c:if test="${newFor.topicId==2}">
				<li>${newFor.newsName }</li>
			</c:if>

		</c:forEach>
  </div>
</div>

<div class="panel panel-primary">
  <div class="panel-heading">
    <h2 class="panel-title">体育新闻</h2>
  </div>
  <div class="panel-body">
   <c:forEach items="${newFor }" var="newFor">
			<c:if test="${newFor.topicId==3}">
				<li>${newFor.newsName }</li>
			</c:if>

		</c:forEach>
  </div>
</div>

</body>
</html>