<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新闻</title>
</head>
<body>
     
    <form action="/News/add.new" method="post">
		新闻标题：<input type="text" name="newsName" value="" /><br /> 
		新闻内容：<input type="text" name="newsText" value="" /><br />
		新闻主题： <select name="id">
         <c:forEach items="${catForms }" var="catForms">
          <option value="${catForms.topicId }" >${catForms.topicName }</option>
         </c:forEach>
        </select> <br>
		
	
		<input type="submit" value="提交" /><br />
	</form>
</body>
</html>