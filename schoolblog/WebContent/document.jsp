<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="boostrap/bootstrap.css" />
		<link rel="stylesheet" href="css/reset.css" />
		<link rel="stylesheet" href="css/document.css" />
		<link rel="stylesheet" href="css/jquery-ui.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js" ></script>
		<script type="text/javascript" src="js/document.js" ></script>
		<script>
			window.onload=function(){
				tuijianTextAjax();
			}
		</script>
</head>

	<body>
	
	
		<!--     header   start        -->
		<%@ include file="PageFolder/docPage/header.jsp" %>
		
		<div id="imgPc" style="height: 150px;background: #FF0000;">
			<div>
				<img src="img/javacourse_bg.jpg" style="width:100%;">
			</div>
		</div>
			
		<div id="container">
			<!--     left   start        -->
			<%@ include file="PageFolder/docPage/containerLeft.jsp" %>
			
			<!--     middle   start        -->
			<%@ include file="PageFolder/docPage/containerMiddle.jsp" %>
			
			<!--     right   start        -->
			<%@ include file="PageFolder/docPage/containerRight.jsp" %>
		</div>
	</body>
</html>