<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8" />
		<title>首页</title>
		<link rel="stylesheet" href="css/reset.css" />
		<link href="boostrap/bootstrap.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/jquery-ui.css" />
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
		<script type="text/javascript" src="js/index.js"></script>
		<script>
			window.onload = function() {
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
				$("#datepicker").datepicker();
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
		<div id="header" class="col-lg-12 col-md-12 col-sm-12">
			<div id="menu-left" class="col-lg-8">
				<div id="header-img" style="position: absolute;top:-20px;"><img src="img/csdn.png" /></div>
				<ul class="header-menu">
					<li><a href="#">博客</a></li>
					<li><a>学院</a></li>
					<li><a href="#">博客</a></li>
					<li><a href="taobao/index.html">商城</a></li>
					<li><a href="https://job.csdn.net/">招聘</a></li>
					<li><a>活动</a></li>
					<li><a href="https://gitbook.cn/?ref=csdn">GitChat</a></li>
				</ul>
			</div>
			<div id="menu-right" class="col-lg-4">
				<ul class="header-menu">
					<li style="width: 20%;"></li>
					<li>
						<a class="indexEditor" href="PersonalAdmin.jsp"> <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 写博客</a>
					</li>
					<li>
						<a><span class="glyphicon glyphicon-leaf" aria-hidden="true"></span> 发Chat</a>
					</li>
					<c:choose>
						<c:when test="${username==null}">
							<li>
								<a href="login.jsp">登录</a>
							</li>
							<li style="margin-left:2px">
								<a href="zhuce.jsp">注册</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="user_header" style="width:24%">
								<a id="welcome" href="javascript:void(0);">欢迎你，${username}</a>
								<div class="indexLoginInfo" style="display:none">
									<ul class="indexLogin">
										<li class="header_myInformation">
											<a>个 人 资 料</a>
										</li>
										<hr/>
										<li>
											<a href="PersonalAdmin.jsp">后 台 管 理</a>
										</li>
										<hr/>
										<li>
											<a href="destroyServlet">退 出</a>
										</li>
										<br/>
									</ul>
								</div>
							</li>
							<script>
								$(function() {
									/*    登录显示用户信息-----鼠标覆盖移除显示下拉框   start      */
									$('#welcome').mouseenter(function() {
										$('.indexLoginInfo').slideDown(500);
									});
									$('.indexLoginInfo').mouseenter(function() {
										$('.indexLoginInfo').slideDown(500);
									});
									$('.indexLoginInfo').mouseleave(function() {
										$('.indexLoginInfo').stop(true);
										$('.indexLoginInfo').slideUp(500);

									});
									/*    登录显示用户信息-----鼠标覆盖移除显示下拉框   end      */
								});
							</script>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>

		<!--       container      start                -->
		<div id="container" class="row">
			<div class="col-lg-1 col-md-1 col-sm-1"></div>

			<!--       left     start                -->
			<div id="left" class="col-lg-1 col-md-1 col-sm-1">
				<ul class="createNavigationBar">
					
				</ul>
			</div>

			<!--       middle     start                -->
			<div id="middle" class="col-lg-6 col-md-6 col-sm-6">
				<div id="myCarousel" class="carousel slide" style="width:759px;">
	                <ol class="carousel-indicators">
					    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
	                <div class="carousel-inner">
	                    <div class="item active" style="height:150px">
	                        <img src="img/tm-1800x600-01.jpg" alt="first slide" />
	                    </div>
	                    <div class="item" style="height:150px">
	                        <img src="img/indexImg02.jpg" alt="second slide" />
	                    </div>
	                    <div class="item" style="height:150px">
	                        <img src="img/indexImg03.jpg" alt="third slide" />
	                    </div>
	                </div>
            	</div>
				<div id="middle_hengfu">论 坛 文 章</div>
				<div id="middle_message">
				
					<c:forEach items="${list}" var="list">
				
						<table class="tableContainer table table-hover ">
							<tr>
								<td class="tdContainer">
									<a href="documentServlet?messageId=${list.messageId}" class="TbLJ">
										<p class="meessage_Titlefont">
											${list.title}
										</p>
										<p class="meessage_authorFont">
											<em class="textType">${list.textType}</em>
											<em class="author">作者：${list.username}</em>
											<em class="textDate">${list.date}</em>
											<em class="readNumInfo">阅读数：<em style='color:#5FBDEB'>${list.readNum}</em></em>
										</p>
									</a>
								</td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</div>

			<!--       right      start                -->
			<div id="right" class="col-lg-2 col-md-2 col-sm-2">
				<!-- ------------Search---------- -->
				<div class="search">
					<label>Search</label>
					<form class="form-inline">
						<input type="text" class="form-control" style="width: 150px;" />
						<button type="submit" class="btn btn-default">Search</button>
					</form>
				</div>
				<hr/>
				<!-- -----------aphorism----------- -->
				<div class="aphorism">
					<label>APHORISM</label><br/>
					<div class="text1">
						<ul>
							<li style="text-align: left;">
								懒惰：是这样一种品质，它使得你花大力气去避免消耗过多的精力。它敦促你写出节省体力的程序，同时别人也能利用它们。为此你会写出完善的文档，以免别人问你太多问题。
							</li>
							<li style="text-align: left;">
								急躁：是这样一种愤怒——当你发现计算机懒洋洋地不给出结果。于是你写出更优秀的代码，能尽快真正的解决问题。至少看上去是这样。
							</li>
							<li style="text-align: left;">
								傲慢：极度的自信，使你有信心写出（或维护）别人挑不出毛病的程序。
							</li>
						</ul>
					</div>
				</div>
				<hr/>
				<!-----------------今日新闻------------------->
        		<div id="todayNews">
					<label style="color:red">
						<span class="glyphicon glyphicon-signal" aria-hidden="true"></span>
  						今日咨询
					</label>
					<br/>
        			<a href="">
						<div class="newsImg" >
							<img src='img/indexImg02.jpg' />
						</div>
						<div class="newsTitle">asacx</div>
					</a>
        		</div>
				
			</div>

			<div class="col-lg-2 col-md-2 col-sm-2"></div>
		</div>
		<!--       container      end                -->
	</body>

</html>