<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      
        <form action="/News/edit.new" method="post">
        <input type="hidden" value="${news.newsId }" name="newsId"><br>
                 新闻名： <input type="text" name="newsName" value="" /><br>
                新闻内容： <input type="text" name="newsText" value="" /><br>
            <input type="hidden" value="${news.topicId }" name="topicId"><br>
		<input type="submit" value="提交" /><br />
	</form>
</body>
</html>