<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta charset="UTF-8">
		<title>个人后台管理主页</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
		<link rel="stylesheet" href="boostrap/bootstrap.css" />
		<link rel="stylesheet" href="css/PersonalAdmin.css" />
		<link rel="stylesheet" href="css/reset.css" />
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/main.js" ></script>
 		<script src="ueditor/ueditor.config.js" type="text/javascript"></script>
   		<script src="ueditor/ueditor.all.js" type="text/javascript"></script>
    	<script src="ueditor/lang/zh-cn/zh-cn.js" type="text/javascript"></script>
    	<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
   		<link href="ueditor/themes/default/css/ueditor.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			$(document).ready(function(){
				$('.delect').click(function(){
 				 msg = "${msg}";
 				 alert(msg);
				});
				
				zhexian();
			});
		</script>
  </head>
  <body>
    	<!--                header       start                       -->
		<%@ include file="PageFolder/adminPage/header.jsp" %>
		<!--                header       end                       -->

		<!--                left_menu       start                  -->
		<%@ include file="PageFolder/adminPage/leftMenu.jsp" %>
		<!--                left_menu       end                  -->

		<!--                container       start                 -->
		<div id="container" class="col-lg-10 col-md-10 col-sm-10 ">
			<div class="addr col-lg-12 col-md-12 col-sm-12"><label>HOME :</label></div>
			<!--     后台管理页面 ---主页       -->
			<%@ include file="PageFolder/adminPage/main.jsp" %>
			<!--     后台管理页面 ---文章发布页       -->
			<%@ include file="PageFolder/adminPage/messageEditor.jsp" %>
			<!--     后台管理页面 ---文章修改页       -->
			<%@ include file="PageFolder/adminPage/messageUpdate.jsp" %>
			<!--     后台管理页面 ---已发布文章信息       -->
			<%@ include file="PageFolder/adminPage/messageSubed.jsp" %>
			<!--     后台管理页面 ---草稿箱       -->
			<%@ include file="PageFolder/adminPage/draft.jsp" %>
			<!--     后台管理页面 ---图片库       -->
			<%@ include file="PageFolder/adminPage/picture.jsp" %>
			<!--     后台管理页面 ---个人资料       -->
			<%@ include file="PageFolder/adminPage/personInfo.jsp" %>
			<!--     后台管理页面 ---密码修改      -->
			<%@ include file="PageFolder/adminPage/webInfo.jsp" %>
			<!--     后台管理页面 ---help面板      -->
			<%@ include file="PageFolder/adminPage/help.jsp" %>
			<!--     后台管理页面 ---网站相关 _网站信息    -->
			<%@ include file="PageFolder/adminPage/infoSum.jsp" %>
		</div>
		<!--                container       end                  -->

		<!--                footer       start                  -->
		<div id="footer" class="col-lg-12 col-md-12 col-sm-12"></div>
		<!--                footer       end                  -->
  </body>
  
</html>
