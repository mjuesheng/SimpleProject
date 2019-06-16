<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--       header      start                -->
<div id="header" class="col-lg-12 col-md-12 col-sm-12" ">
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
					<li><a class="indexEditor" href="PersonalAdmin.jsp" >  <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span> 写博客</a></li>
					<li><a><span class="glyphicon glyphicon-leaf" aria-hidden="true"></span> 发Chat</a></li>
					<c:choose>
						<c:when test="${username==null}">
							<li><a href="login.jsp">登录</a></li>
							<li style="margin-left:2px"><a href="zhuce.jsp">注册</a></li>
						</c:when>
						<c:otherwise>
							<li  class="user_header" style="width:24%">
								<a id="welcome" href="javascript:void(0);">欢迎你，${username}</a>
								<div class="indexLoginInfo" style="display:none"> 
									<ul class="indexLogin">
										<!--  
										<li class="header_myInformation"><a>个 人 资 料</a></li>
										<hr/>
										-->
										<li><a href="PersonalAdmin.jsp">后 台 管 理</a></li>
										<hr/>
										<li><a href="destroyServlet">退 出</a></li>
										<br/>
									</ul>
								</div> 
							</li>
							<script>
								$(function(){
									/*    登录显示用户信息-----鼠标覆盖移除显示下拉框   start      */
									
									$('#welcome').mouseenter(function(){
										$('.indexLoginInfo').slideDown(500);
									});
									$('.indexLoginInfo').mouseenter(function(){
										$('.indexLoginInfo').slideDown(500);
									});
									$('.indexLoginInfo').mouseleave(function(){
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
		<!--       header      end                -->