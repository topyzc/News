<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加主题</title>
</head>
<body>
 
      
    <form action="/News/add.cat" method="post">
        主题id:<input type="text" name="topicId" value="" /><br />
		主题名：<input type="text" name="topicName" value="" /><br /> 
		<input type="submit" value="提交" /><br />
	</form>
	
</body>
</html>