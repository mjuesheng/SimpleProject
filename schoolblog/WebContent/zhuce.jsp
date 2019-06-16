<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    <meta charset="UTF-8">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/zhuce.css" />
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" type="text/css" href="boostrap/bootstrap.min.css"/>
	<script type="text/javascript" src="js/jquery.min.js" ></script>
	<script type="text/javascript" src="js/main.js" ></script>	

  </head>
  
  <body>
    <!--   header     start      -->
	   <div id="header">
			<h1>在 线 论 坛</h1>
			<img src="img/ujnlogo.png" />
			<ul class="zhuce-ul">
				<li>
					<a href="#">首页</a>
				</li>
				<li>
					<a href="login.jsp">登录</a>
				</li>
				<li>
					<a href="#">帮助</a>
				</li>
			</ul>
		</div>
		<!--   header     end      -->
		<!--  container-form     start      -->
		<div id="container-form">
			<h1>新用户注册</h1>
			<form action="zhuceServlet" onsubmit="return checkSub()" method="post" class="clear" class="form-horizontal">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 col-lg-2 control-label">邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>
					<div class="col-sm-10">
						<input type="text"  class="form-control" id="eml" name="eml">
						<label id="email-msg"></label>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2  col-lg-2 control-label">手机号:  +86</label>
					<div class="col-sm-10">
						<input type="tel" class="form-control" id="phone" name="phone">
						<label id="tel-msg"></label>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 col-lg-2 control-label">用户名:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username" name="username" value="">
						<label id="username-msg"></label>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 col-lg-2 control-label">昵&nbsp;&nbsp;&nbsp;&nbsp;称:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name" name="name">
						<label id="name-msg"></label>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 col-lg-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="psd" name="psd">
						<label id="password-msg"></label>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 col-lg-2 control-label">确认密码:</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="psdt" name="psdt">
						<label id="psdt-msg"></label>
					</div>
				</div>
				
				<input type="submit" class="btn btn-warning" id="" value="注册" style="margin-left: 70%; width: 100px;"/>
			</form>
		</div>
		<!--  container-form     end      -->
		
		<!--  footer     start      -->
		<div id="footer">
			<p>© 2000–<%=new Date().getYear()+1900 %> 济大BBS</p>
		</div>
		<!--  footer     end      -->
		
		<script type="text/javascript">
			
			var msg = "${msg}";
			if(msg!=null){
				alert(msg);
			}
		</script>
  </body>
</html>