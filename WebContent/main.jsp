<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style type="text/css">
 #all{
         border-style:solid;
	      border-color:#F8F8FF;
	     margin-left:auto;
         margin-right:auto;
	     text-align: center;
         box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
         -webkit-box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
         font: 12px Arial, Helvetica, sans-serif;
         border-radius: 10px;
        -webkit-border-radius: 10px;
		height:1700px;
		width:1000px;	
		  
	}
	#top{
		position: absolute;
		height:280px;
		width:1000px;
	
		
	}
	
	#left{
		height:1100px;
		width:200px;
		position: absolute;
		margin-top:300px;

	}
	#right{
		height:1100px;
		width:680px;
		position: absolute;
		margin-top:300px;
		margin-left:220px;
    
		
	}
	#bottom{
        width:1000px;	
	    height:300px;
		position: absolute;
		margin-top:1450px;
		
	
	}
	
</style>
</head>
<body>
 
	

       <div id="all">
		
		<div id="top">
			<jsp:include page="top.jsp" />
		</div>
		
		<div id="left">
			<jsp:include page="left.jsp" />
		</div>
		<div id="right">
		
	     <jsp:include page="right.jsp" /> 
		</div>	
		<div id="bottom">
		
	     <jsp:include page="bottom.jsp" /> 
		</div>	
		
	    
		
	</div> 
</body>
</html>