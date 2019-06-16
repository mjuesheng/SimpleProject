<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<meta charset="UTF-8" />
		<title>首页</title>
		<link rel="stylesheet" href="css/reset.css" />
		<link href="boostrap/bootstrap.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/jquery-ui.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js" ></script>
		<script type="text/javascript" src="js/index.js"></script>
		<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
		<script>
			window.onload=function(){
				conectionText("0");
				createNavigationBarAjax();
				$("#myCarousel").carousel({interval:2000});
				createNewsAjax();
			}
			function setTime() {
				setInterval(function() {
					var data = new Date();
					var hour = data.getHours();
					var min = data.getMinutes();
					var s = data.getSeconds();
					var str = hour + ':' + min + ':' + s;
					$('#getTime').text(str);
				}, 1000);
			}
			$(function() {
	   			$( "#datepicker" ).datepicker();
	   			setTime();
  		 	});
			
			//导航栏下拉至一定高度后固定在顶部的特效
			$(function(){
				var nav=$("#left"); //得到导航对象
				var win=$(window); //得到窗口对象
				var sc=$(document);//得到document文档对象。
				win.scroll(function(){
				  if(sc.scrollTop()>=100){
				    nav.addClass("fixednav"); 
				    $("#middle").css("margin-left","8.2%")
				   $(".navTmp").fadeIn(); 
				  }else{
				   nav.removeClass("fixednav");
				   $("#middle").css("margin-left","0")
				   $(".navTmp").fadeOut();
				  }
				})  
				})
		</script>
	</head>
	
	<body>
		<!--       header      start                -->
		<%@ include file="PageFolder/indexPage/header.jsp" %>
		
		<!--       container      start                -->
		<div id="container" class="row">
			<div class="col-lg-1 col-md-1 col-sm-1"></div>
			
			<!--       left     start                -->
			<%@ include file="PageFolder/indexPage/containerLeft.jsp" %>
			
			<!--       middle     start                -->
			<%@ include file="PageFolder/indexPage/containerMiddle.jsp" %>
			
			<!--       right      start                -->
			<%@ include file="PageFolder/indexPage/containerRight.jsp" %>
			
			<div class="col-lg-2 col-md-2 col-sm-2"></div>
		</div>
		<!--       container      end                -->
	</body>
</html>
