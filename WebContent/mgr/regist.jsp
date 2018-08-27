<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>注册页面</title>

<body>
<form class="form-inline" action="/News/Regist.action" method="post">
  <div class="form-group">
    <label for="exampleInputName2">Name</label>
    <input type="text" class="form-control" id="exampleInputName2" name="username" placeholder="UserName">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword2">Password</label>
    <input type="Password" class="form-control" id="exampleInputPassword2" name="password" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-success">注册</button>
</form>
	
		
</body>
</html>