<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<style type="text/css">
.ii {
	width: 680px;
	height: 100px;
}



.aaaa {
	width: 680px;
	height: 50px;
	
}

.aaaa h1 {
	
	margin-left: -400px;
}

.bb {
	text-align: left;
}

a {
	font-size: 15px;
	font-weight: bold;
	margin-left: 30px;
}

a:link {
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
	color: red;
}

ul, li {
	text-align: left;
	line-height: 15px;
	font-size: 15px;
}

.tt {
	margin-top: -14px;
	text-align: right;
}
h2{
   text-align: left;
}
.lianjie{
   color:black;
}
</style>
</head>
<body>
  
	<div class="aaaa">

		<h2><span class="label label-default">新闻中心</span></h2>
	</div>

  <div class="daohan">
  <ul class="nav nav-tabs" >
  <li ><a href=" <c:url value='/query.new?method=queryAll&id=1'/>">国际</a></li>
  <li ><a href=" <c:url value='/query.new?method=queryAll&id=2'/>">国内</a> </li>
  <li ><a href=" <c:url value='/query.new?method=queryAll&id=3'/>">军事</a></li>
  <li ><a href=" <c:url value='/query.new?method=queryAll&id=4'/>">体育</a></li>
  <li > <a href=" <c:url value='/query.new?method=queryAll&id=5'/>">娱乐</a> </li>
  <li ><a href="<c:url value='/query.new?method=queryAll&id=6'/>">社会</a></li>
  <li ><a href=" <c:url value='/query.new?method=queryAll&id=7'/>">财经</a></li>
  </ul>
  </div>	
   <br><br>
	<div class="cc">
			<c:forEach items="${newFor }" var="newFor">
				<ul>
					<li><a  class="lianjie"
						href="<c:url value='/querynewsid.new?method=querynewsid&id=${newFor.newsId }'/>">${newFor.newsName }</a>
					</li>
                    <li class="tt">${newFor.newsTime }</li>
				</ul>

			</c:forEach>

	<nav aria-label="Page navigation">
     <ul class="pagination">
     <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
      </li>
     </ul>
   </nav>
		
	</div>
	
	
</body>
</html>