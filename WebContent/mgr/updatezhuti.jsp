<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改主题</title>
</head>
<body>

        <form action="/News/edit.cat" method="post">
        <input type="hidden" value="${cis.topicId }" name="id"><br>
             主题： <input type="text" name="topicName" value="${cis.topicName }" /><br>
		<input type="submit" value="提交" /><br />
	</form>
</body>
</html>