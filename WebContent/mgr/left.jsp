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
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>

<title>菜单</title>
<script type="text/javascript">
$("#topic_add_modal").click(function(){
	arlet(1)
	$("#topicAddModal").modal({
        backdrop:"static"
		});
});

</script>
<style type="text/css">
  
h1{
  font-size: 20px;
  text-align: cnter;
}

</style>
</head>

<body>


      <h1>菜单</h1>
      <div class="menu">
         <a href="/News/addnew.new"><button type="button"  class="btn btn-success">添加新闻</button></a><br><br>
         <a href="/News/querys.new"><button type="button"  class="btn btn-success">编辑新闻</button></a><br><br>
         <a href="/News/mgr/addca.jsp"><button type="button"  class="btn btn-success">添加主题</button></a><br><br>
         <a href="/News/query.cat"><button type="button"  class="btn btn-success">编辑主题</button></a><br><br>
      </div> 
    
</body>
</html>