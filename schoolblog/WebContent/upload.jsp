<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.min.js" ></script>
	<script type="text/javascript" src="js/main.js" ></script>
  </head>
  
  <body>
     <form action="UploadServlet"  enctype="multipart/form-data" method="post">
    	<input type="file" name="file1" ><br/>
    	<input type="submit" value="登陆"> 
    </form>
    <a href="delectImgServlet?imgName=ad">图片删除测试</a>
    <a href="imgAjax?username=admin">图片信息回传</a>
    
    <button id="text" name="text" onclick="imgAjax()">图片Ajax</button>
    <div id="touxiang">|<img src="img/xiaolian.jpg">|</div>
    <div><a href="pictureAjax"> 图库地址</a></div>
  </body>
</html>
