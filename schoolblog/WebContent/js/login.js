$(function(){
	$('#username').focus().blur(checkName);
	$('#password').blur(checkPassword);
});

function checkName(){
	var name = $('#username').val();
	if(name == null || name == ""){
		//提示错误
		$('#count-msg').html("用户名不能为空");
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(!reg.test(name)){
		$('#count-msg').html("输入3-10个字母或数字或下划线");
		return false;
	}
	$('#count-msg').empty();
	return true;
}

function checkPassword(){
	var password = $('#password').val();
	if(password == null || password == ""){
		//提示错误
		$('#password-msg').html("密码不能为空");
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(!reg.test(password)){
		$('#password-msg').html("输入3-10个字母或数字或下划线");
		return false;
	}
	$('#password-msg').empty();
	return true;
}

function Onchage(){
	var img = document.getElementById("image");
	img.src="Identity.html?time="+new Date();
}


function onsub(){
	if(checkName() & checkPassword()&checkN()){
		return true;
	}else if(checkName()==false){
		return false;
	}else if(checkPassword()==false){
		return false;
	}else{
		return false;
	}
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

function check_number(){  
    var xhr = getXhr();  
    var code = $('#yanzheng').value;
    xhr.open('get','login.html?code='+code,true);
    xhr.send();
    
    var str= xhr.responseText;
    alert(str);
    var json = JSON.parse(str);
    if(json.flag==false){
    	alert(json.msg);
    }
}  