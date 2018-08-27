<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

ul,li{
text-align: left;
line-height: 15px;
font-size:15px;
}
p{
margin-top:-14px;
text-align: right;
}

</style>
</head>
<body>
      <c:forEach items="${newForms }" var="newForms"> 
        
      <ul>
         <li><a href="<c:url value='/querynewsid.new?method=querynewsid&id=${newForms.newsId }'/>">${newForms.newsName }</a> <p>${newForms.newsTime }</p>  </li>
         
     </ul> 
            
         
	 </c:forEach><br><br>
</body>
</html>