<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top</title>
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<style type="text/css">
.login {
	margin-top: 50px;
	margin-left: -900px;
	font-size: 25px;
	font-weight: bold;
}

.regist {
	margin-top: -20px;
	margin-left: -700px;
	font-size: 25px;
	font-weight: bold;
}

.den {
	width: 200px;
	height: 30px;
	margin-left: 800px;
}

.img {
	height: 80px;
	width: 360px;
}

.png {
	height: 100px;
}
</style>

</head>
<body>


	<div class="img">

		<img alt="" src="img/1.png">
	</div>
	<div class="png">
		<img alt="" src="img/2.png">
	</div>
	<div class="den">
	    <a href="javascript:void(0);" onclick="login_modal"></a>
		<a href="/News/mgr/login.jsp">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
			href="/News/mgr/regist.jsp">注册</a>
	</div>


</body>
</html>