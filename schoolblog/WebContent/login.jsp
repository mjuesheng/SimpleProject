<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>用户登录</title>
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/login.css" />
    <script type="text/javascript" charset="utf-8" src="js/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/login.js"></script>
</head>
<body>
<div class="page">
	<div class="loginwarrp">
		<div class="logo">用户登陆</div>
        <div class="login_form">
			<form id="Login" name="Login" method="post" onsubmit="return onsub()" action="login.html">
				<li class="login-item">
					<span>用户名：</span>
					<input type="text" id="username" name="userName" class="login_input" >
                                        <span id="count-msg" class="error"></span>
				</li>
				<li class="login-item">
					<span>密　码：</span>
					<input type="password" id="password" name="password" class="login_input" >
                                        <span id="password-msg" class="error"></span>
				</li>
				<li class="login-item" style="width:240px;float:left;">
					<span>验证码：</span>
					<input type="text" id="yanzheng" name="yanzheng" style="width: 100px;" onblur="checkN()" class="login_input verify_input">
					<span id="yanzheng-msg" class="error"></span>
				</li>
				<img src="Identity.html" id="image" alt="一张图片" style="margin:15px 0px 0px 5px;"  onclick="Onchage()">
				<li class="login-sub">
					<input type="submit" name="Submit" value="登录" />
                    <input type="button" name="button" value="注册" onclick="window.location.href='zhuce.jsp'"/>
				</li>                
           </form>
		</div>
	</div>
</div>
<script type="text/javascript">	
		window.onload = function() {
			var config = {
				vx : 4,
				vy : 4,
				height : 2,
				width : 2,
				count : 100,
				color : "121, 162, 185",
				stroke : "100, 200, 180",
				dist : 6000,
				e_dist : 20000,
				max_conn : 10
			}
			CanvasParticle(config);
		}
		var msg = "${msg}";
		if(msg!=null || msg!=""){
			alert(msg);
		}
	 function getXhr(){  
	    var xhr = null;  
	    if(window.XMLHttpRequest){  
	        xhr = new XMLHttpRequest();  
	    }else{  
	        xhr = new ActiveXObject('Microsoft.XMLHttp')  
	    } 
	    return xhr;  
	}  
	function checkN(){  
	    var xhr = getXhr();  
	    var code = document.getElementById('yanzheng').value;
	    xhr.open('get','yanzheng.html?code='+code,false);
	    xhr.send();
	    var str= xhr.responseText;
	    var json = JSON.parse(str);
	    if(json.flag==false){
	    	$('#yanzheng-msg').html(json.msg);
	    	$('#flag').val("0");
	    	return false;
	    }else{
	    	$('#flag').val("1");
	    	return true;
	    }
	    
	}
	</script>
	<script type="text/javascript" src="js/canvas-particle.js"></script>
</body>
</html>
