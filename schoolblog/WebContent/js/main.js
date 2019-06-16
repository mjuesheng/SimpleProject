var strPage=1;
var countPage = 0;
	$(function(){
	
	jump(strPage);
	/*   头像设置     start    */
	imgAjax();
	$("#touxiang img").error(function() { 
		$(this).attr("src", "img/xiaolian.jpg"); 
	});
	/*   头像设置     end    */
	
	/*   表单验证    start    */
	$('#eml').focus().blur(checkEmail);
	$('#psd').blur(checkPassword);
	$('#phone').blur(checkTelphone);
	$('#username').blur(checkUserName);
	$('#name').blur(checkName);
	$('#psdt').blur(checkPassword2);
	
	$('#title').focus().blur(checkTitle);
	$('#introduce').blur(checkIntroduce);
	/*   表单验证    end    */
	
	/*   个人后台管理左侧导航栏二级菜单特效    start    */
	$('.sub1').click(function(){
		$('.nav1').toggle(500);
		$('.nav2').hide(500);
		$('.nav3').hide(500);
		$('.nav4').hide(500);
		$('.nav5').hide(500);
	});
	$('.sub2').click(function(){
		$('.nav2').toggle(500);
		$('.nav1').hide(500);
		$('.nav3').hide(500);
		$('.nav4').hide(500);
		$('.nav5').hide(500);
	});
	$('.sub3').click(function(){
		$('.nav3').toggle(500);
		$('.nav2').hide(500);
		$('.nav1').hide(500);
		$('.nav4').hide(500);
		$('.nav5').hide(500);
	});
	$('.sub4').click(function(){
		$('.nav4').toggle(500);
		$('.nav2').hide(500);
		$('.nav3').hide(500);
		$('.nav1').hide(500);
		$('.nav5').hide(500);
	});
	$('.sub5').click(function(){
		$('.nav5').toggle(500);
		$('.nav2').hide(500);
		$('.nav3').hide(500);
		$('.nav4').hide(500);
		$('.nav1').hide(500);
	});
	
	
	/*   个人后台管理左侧导航栏二级菜单特效    end    */
	
	$('.messageClick').click(function(){
		$('.container-in').show();
		$('.container-draft').hide();
		$('.container-subed').hide();
		$('.container-img').hide();
		$('.container-infoEditor').hide();
		$('.container-megUpdate').hide();
		$('.container-webInfo').hide();
		$('.infoSum-Container').hide();
		$('#mainAdr').hide();
		$('#help').hide();
		$('.addr').html("<label>HOME :文章管理 > 撰写文章</label>");
	});
	$('.subedClick').click(function(){
		$('.container-subed').show();
		$('.container-in').hide();
		$('.container-img').hide();
		$('.container-draft').hide();
		$('.container-infoEditor').hide();
		$('.container-megUpdate').hide();
		$('#mainAdr').hide();
		$('.infoSum-Container').hide();
		$('.container-webInfo').hide();
		$('#help').hide();
		$('.addr').html("<label>HOME :文章管理 > 已发布</label>");
	});
	
	$('.draftClick').click(function(){
		$('.container-draft').show();
		$('.container-subed').hide();
		$('.container-in').hide();   
		$('.container-img').hide();
		$('.container-infoEditor').hide();
		$('.container-megUpdate').hide();
		$('.infoSum-Container').hide();
		$('#mainAdr').hide();
		$('.container-webInfo').hide();
		$('#help').hide();
		$('.addr').html("<label>HOME :文章管理 > 草稿箱</label>");
	});
	
	$('.pitctureClick').click(function(){
		$('.container-img').show();
		$('.container-draft').hide();
		$('.container-subed').hide();
		$('.container-in').hide();
		$('.container-infoEditor').hide();
		$('.container-megUpdate').hide();
		$('.infoSum-Container').hide();
		$('#mainAdr').hide();
		$('.container-webInfo').hide();
		$('#help').hide();
		$('.addr').html("<label>HOME :个人资料 > 图片库</label>");
		/*    图片库ajax请求  start  */
		pictureAjax();
		/*    图片库ajax请求  end  */
	});
	
	$('.peronalInfoClick').click(function(){
		$('.container-infoEditor').show();
		$('.container-draft').hide();
		$('.container-subed').hide();
		$('.container-in').hide();
		$('.container-img').hide();
		$('.container-megUpdate').hide();
		$('.infoSum-Container').hide();
		$('#mainAdr').hide();
		$('.container-webInfo').hide();
		$('#help').hide();
		$('.addr').html("<label>HOME :文章管理 > 草稿箱</label>");
	});
	
	/*    新建文章按钮   start   */
	$('.message-btn').click(function(){
		$('.container-draft').hide();
		$('.container-subed').hide();
		$('.container-in').show();
		$('.container-img').hide();
		$('.container-infoEditor').hide();
		$('.container-megUpdate').hide();
		$('.container-webInfo').hide();
		$('.infoSum-Container').hide();
		$('#help').hide();
		$('.addr').html("<label>HOME :文章管理 > 撰写文章</label>");
	});
	/*    新建文章按钮   end   */
	
	/*    草稿箱按钮   start     */
	$('.draft-btn').click(function(){
		$('.container-draft').show();
		$('.container-subed').hide();
		$('.container-in').hide();   
		$('.container-img').hide();
		$('.container-infoEditor').hide();
		$('.container-megUpdate').hide();
		$('.container-webInfo').hide();
		$('.infoSum-Container').hide();
		$('#help').hide();
		$('.addr').html("<label>HOME :文章管理 > 草稿箱</label>");
		
	});
	/*    草稿箱按钮   end   */
	
	/*    发布箱按钮   start     */
	$('.subed-btn').click(function(){
		$('.container-draft').hide();
		$('.container-subed').show();
		$('.container-in').hide();   
		$('.container-img').hide();
		$('.container-webInfo').hide();
		$('.container-infoEditor').hide();
		$('.container-megUpdate').hide();
		$('.infoSum-Container').hide();
		$('#help').hide();
		$('.addr').html("<label>HOME :文章管理 > 已发布</label>");
	});
	/*    发布箱按钮   end     */

	/*    密码修改按钮   start     */
	$('.updatepsd').click(function(){
		$('.container-draft').hide();
		$('.container-subed').hide();
		$('.container-webInfo').show();
		$('.container-in').hide();   
		$('.container-img').hide();
		$('.container-infoEditor').hide();
		$('.container-megUpdate').hide();
		$('#mainAdr').hide();
		$('.infoSum-Container').hide();
		$('#help').hide();
		$('.addr').html("<label>HOME :账号管理 > 密码修改</label>");
	});
	/*    密码修改按钮   end     */
	$('.helpButton').click(function(){
		$('#help').show();
		$('.container-draft').hide();
		$('.container-subed').hide();
		$('.container-in').hide();   
		$('.container-img').hide();
		$('.container-infoEditor').hide();
		$('.container-megUpdate').hide();
		$('.infoSum-Container').hide();
		$('#mainAdr').hide();
		$('.container-webInfo').hide();
		$('.addr').html("<label>HOME :信息展示</label>");
	});
	$('.infoSumButton').click(function(){
		$('.infoSum-Container').show();
		$('#help').hide();
		$('.container-draft').hide();
		$('.container-subed').hide();
		$('.container-in').hide();   
		$('.container-img').hide();
		$('.container-infoEditor').hide();
		$('.container-megUpdate').hide();
		$('.infoSum').hide();
		$('#mainAdr').hide();
		$('.container-webInfo').hide();
		$('.addr').html("<label>HOME :信息统计</label>");
	});
	
});

/*  表单验证       start */
function checkUserName(){
	var name = $('#username').val();
	if(name == null || name == ""){
		//提示错误
		$('#username-msg').html("用户名不能为空");
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(!reg.test(name)){
		$('#username-msg').html("输入3-10个字母或数字或下划线");
		return false;
	}
	$('#username-msg').empty();
	return true;
}
function checkName(){
	var name = $('#name').val();
	if(name == null || name == ""){
		//提示错误
		$('#name-msg').html("昵称不能为空");
		return false;
	}
	$('#name-msg').empty();
	return true;
}
function checkPassword(){
	var password = $('#psd').val();
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
function checkPassword2(){
	var password = $('#psd').val();
	var password2 = $('#psdt').val();
	if(password2 == null || password2 == ""){
		//提示错误
		$('#psdt-msg').html("密码不能为空");
		return false;
	}
	
	if(password!=password2){
		$('#psdt-msg').html("前后密码不一致");
		return false;
	}
	$('#psdt-msg').empty();
	return true;
}
function checkEmail(){
	var email = $('#eml').val();
	if(email == null || email == ""){
		//提示错误
		$('#email-msg').html("邮箱不能为空");
		return false;
	}
	var reg =/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	if(!reg.test(email)){
		$('#email-msg').html("邮箱格式不正确");
		return false;
	}
	$('#email-msg').empty();
	return true;
}
function checkTelphone(){
	var tel= $('#phone').val();
	if(tel == null || tel == ""){
		//提示错误
		$('#tel-msg').html("手机号不能为空");
		return false;
	}
	var reg = /^1[3|4|5|8][0-9]\d{4,8}$/;
	if(!reg.test(tel)){
		$('#tel-msg').html("手机格式不正确");
		return false;
	}
	$('#tel-msg').empty();
	return true;
}

function checkSub(){
	if(checkUserName()&checkName()&checkPassword()&checkPassword2()&checkEmail()&checkTelphone()){
		return true;
	}else{
		return false;
	}
}

/*  表单验证         end */

/*   密码修改      start  */
function checkPsw2(){
	if(updataCheckOld()&updataCheckOne()&updataCheckTwo()){
		return true;
	}else{
		alert("不符合规范，修改失败!");
		return false;
	}
}
function updataCheckOld(){
	var password = $('#oldpsd').val();
	if(password == null || password == ""){
		//提示错误
		$('#oldpwd-msg').html("密码不能为空");
		return false;
	}
	var reg = /^\w{3,10}$/;
	if(!reg.test(password)){
		$('#oldpwd-msg').html("输入3-10个字母或数字或下划线");
		return false;
	}
	$('#oldpwd-msg').empty();
	return true;
}

function updataCheckOne(){
	var password = $('#newpsd').val();
	if(password == null || password == ""){
		//提示错误
		$('#password-msg').html("密码不能为空");
		return false;
	}
	var oldp = $('#oldpsd').val();
	if(oldp==password){
		$('#password-msg').html("新旧密码不能一样");
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

function updataCheckTwo(){
	var password = $('#newpsd').val();
	var password2 = $('#new2psd').val();
	if(password2 == null || password2 == ""){
		//提示错误
		$('#psdt-msg').html("密码不能为空");
		return false;
	}
	
	if(password!=password2){
		$('#psdt-msg').html("前后密码不一致");
		return false;
	}
	$('#psdt-msg').empty();
	return true;
}

/*   密码修改      end  */


/*   撰写文章 表单验证    start    */
function checkTitle(){
	var title = $('#title').val();	
	if(title == null || title == ""){
		//提示错误
		$('#title').focus();
		return false;
	}
	return true;
}

function checkIntroduce(){
	var introduce = $('#introduce').val();
	if(introduce == null || introduce == ""){
		//提示错误
		$('#introduce').focus();
		return false;
	}
	return true;
}

function checkEditorText(){
	var txt =editor.getContentTxt();
	if(txt == null || txt == ""){
		alert("文本内容不能为空!");
		return false;
	}
	return true;
}

function checkTxtType(){
	var txt = $("#txtType").val();
	if(txt=="未分类"){
		alert("请选择文章分类!");
		return false;
	}else{
		return true;
	}
}

function checkCkBox(){
	if($('#inlineCheckbox1').attr('checked')&$('#inlineCheckbox2').attr('checked')){
		return true;
	}else{
		if(confirm("评论与首页设置确定要这么做吗？")){
			return true;
		}else{
			return false;
		}
	}
}

function checkSub2(){
	if(checkTitle()&checkIntroduce()&checkTxtType()&checkCkBox()){
		return true;
	}else{
		return false;
	}
}

/*   撰写文章 表单验证    end    */


/*    发布箱ajax        start    */
function getXhr() {
	var xhr = null;
	if(window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else {
		xhr = new ActiveXObject('Microsoft.XMLHttp')
	}
	return xhr;
}
function checkN(t) {
	var xhr = getXhr();
	xhr.open('get', 'releaseAjax?t=' + t, false);
	xhr.send();
	var str = xhr.responseText;
	var data = eval("(" + str + ")"); //json为接收的后台返回的数据;
	return data;
}

/*    发布箱ajax        end    */

/*    图片头像ajax        start    */

function imgAjax(){
	 $.ajax({  
         url:"imgAjax",  
         type: "post",  
         dataType: "text",
         success: function (result, status) {   	
        	$("#touxiang img").attr("src",result);
         }, error: function (res) {
         	alert(res)
         }  
     });
}

function OpenDialog(){ 
    $('#btn_file').click();
}
function fileSub(){
	$('#btn_sub').click();
}
 	/*      图库图片信息   start    */
	function pictureAjax(){
		 $.ajax({  
	        url:"pictureAjax",  
	        type: "post",
	        dataType: "json",
	        success:function (data) {
	        	imgCreate(data);
	        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
	        	alert("图库信息错误!");
	        } 
	    });
	}
	
	//检查图片路径 图片是否存在
	function CheckImgExists(imgurl) { 
	   var result = 1;
	   $.ajax({
		   url:imgurl,  
	       type: "post",
	       async : false,
	       success:function () {
	    	   result = 2;
	       }, error: function (XMLHttpRequest, status, errorThrown) {
	    	   if(XMLHttpRequest.status==404){
	    		   result=1;
	    	   }
	        }
	   });
	   return result;
	} 
	
	
	/*          图片库动态创建              */

	function imgCreate(date){
		var index;           //控制循环添加
		var imgUrlIndex = new Array();   //有效的图片地址索引
		$('.img-border').remove();
		index=0;            //imgUrlIndex的索引
		for(var i = 0; i < date[0].size; i++) {
			var num =CheckImgExists(date[i].url);
			if(num==2){
				$('#create-container').prepend($('<div class="img-border"></div>'));
				imgUrlIndex[index] = i;
				index++;
			}
		}
		
		$(".img-border").each(function(){
			$(this).prepend($('<a class="img-click" href=""></a>'));
		});
		
		$(".img-click").each(function(){
			$(this).append($('<img class="tukuPc" src="img/xiaolian.jpg" />'));
			$(this).append($('<div class="img-btn"></div>'));
		});
		
		$('.img-btn').each(function(){
			$(this).append($('<a class="touxiang-set  text-style" href="">设为头像</a>'));
			$(this).append($('<a class="touxiang-delect text-style" href="">删除头像</a>'));
		});
		
		index=0;
		$('.tukuPc').each(function(){
			var imgIndex = imgUrlIndex[index];
			$(this).attr("src",date[imgIndex].url);
			index++;
		});
		
		index=0;
		$('.touxiang-set').each(function(){
			var imgIndex = imgUrlIndex[index];
			$(this).attr("href","tukuAdminServlet?imgId="+date[imgIndex].imgId);
			index++;
		});
		
		index=0;
		$('.touxiang-delect').each(function(){
			var imgIndex = imgUrlIndex[index];
			$(this).attr("href","delectImgServlet?imgId="+date[imgIndex].imgId);
			index++;
		});
		
		/*   头像管理    头像点击显示隐藏按钮         start  */
		$('.img-click').on({  
	        mouseover : function(){  
	        	$('.img-btn').show();
	        },  
	        mouseout : function(){  
	         	$('.img-btn').hide();
	        }
	    });
	    $('.img-btn').on({  
	        mouseover : function(){  
	        	$('.img-btn').show();
	        },  
	   	});
		/*   头像管理    头像点击显示隐藏按钮         end  */
		
	}
	/*          图片库动态创建           end   */

	
/*            发布箱 动态创建            start        */

function addMessage(t) {
	
	$('.tr-one').remove();
	var data = checkN(t);
	var message_container = $('.subInformation-table');
	for(var i = 0; i < data[0].size; i++) {
		var tr = document.createElement('tr');
		tr.className = 'tr-one';
		var title = document.createElement('th');
		title.className = 'th-title';
		var discuss = document.createElement('th');
		discuss.className = 'th-discuss';
		var administrator = document.createElement('th');
		administrator.className = 'th-administrator';
		var d = document.createElement('th');
		d.className = 'th-date';
		var type = document.createElement('th');
		type.className = 'th-type';
		var admin = document.createElement('th');
		admin.className = 'th-admin';
		var bianji = document.createElement('a');
		bianji.innerHTML = '编辑 ';
		$(bianji).attr("onclick","releaseUpdate('"+data[i].releaseId+"')");
		var del = document.createElement('a');
		del.className = 'delect';
		del.innerHTML = '删除';
		del.href = 'delectReleaseServlet?messageId='+data[i].releaseId+'&id=0';
		admin.appendChild(bianji);
		admin.appendChild(del);
		
		tr.appendChild(title);
		tr.appendChild(discuss);
		tr.appendChild(administrator);
		tr.appendChild(d);
		tr.appendChild(type);
		tr.appendChild(admin);
		
		title.innerHTML = data[i].title;
		discuss.innerHTML = data[i].discuss;
		administrator.innerHTML = data[i].username;
		d.innerHTML = data[i].date;
		type.innerHTML = '已发布';
		message_container.append(tr);
	}
}

/*            发布箱 动态创建            end        */

/*            草稿箱 动态创建            start        */
function checkDraft(t) {
	var xhr = getXhr();
	xhr.open('get', 'draftboxAjax?t=' + t, false);
	xhr.send();
	var str = xhr.responseText;
	var data = eval("(" + str + ")"); //json为接收的后台返回的数据；
	return data;
}
function addDraftbox(t) {
	$('.tr-one').remove();
	var data = checkDraft(t);
	var message_container = $('.subInformation-table');
	for(var i = 0; i < data[0].size; i++) {
		var tr = document.createElement('tr');
		tr.className = 'tr-one';
		var title = document.createElement('th');
		title.className = 'th-title';
		var discuss = document.createElement('th');
		discuss.className = 'th-discuss';
		var administrator = document.createElement('th');
		administrator.className = 'th-administrator';
		var d = document.createElement('th');
		d.className = 'th-date';
		var type = document.createElement('th');
		type.className = 'th-type';
		var admin = document.createElement('th');
		admin.className = 'th-admin';
		var bianji = document.createElement('a');
		bianji.innerHTML = '编辑 ';
		$(bianji).attr("onclick","draftUpdate('"+data[i].draftId+"')");
		var del = document.createElement('a');
		del.className = 'delect';
		del.innerHTML = '删除';
		del.href = 'delectDraftboxServlet?draftId='+data[i].draftId+'&id=0';
		admin.appendChild(bianji);
		admin.appendChild(del);
		
		tr.appendChild(title);
		tr.appendChild(discuss);
		tr.appendChild(administrator);
		tr.appendChild(d);
		tr.appendChild(type);
		tr.appendChild(admin);
		title.innerHTML = data[i].title;
		discuss.innerHTML = data[i].discuss;
		administrator.innerHTML = data[i].username;
		d.innerHTML = data[i].date;
		type.innerHTML = '未完成';
		message_container.append(tr);
	}
}

//文章编辑
function releaseUpdate(id){
	$('.container-megUpdate').show();
	$('.container-in').hide();
	$('.container-draft').hide();
	$('.container-subed').hide();
	$('.container-img').hide();
	$('.container-infoEditor').hide();
	$('#mainAdr').hide();
	$.ajax({
		   url:"messageUpdateAjax?type=release&id="+id,  
	       type: "post",
	       dateType:"json",
	       success:function (date) {
	    	   $('#megUpdateForm').attr("action","megUpdateServlet?id="+date[0].messageId);
	    	   $('#title2').attr("value",date[0].title);
	    	   $('#introduce2').attr("value",date[0].introduce);
	    	   var ue = UE.getEditor('editor2');  
	           ue.ready(function() {//编辑器初始化完成再赋值  
	               ue.setContent(date[0].txt);  //赋值给UEditor  
	           });
	    	   $(":radio[value='发布']").attr("checked","checked");
	    	   if(date[0].discuss=='Y'){
	    		   $(":checkbox[value='discuss']").prop("checked",true);
	    	   }
	    	   if(date[0].homePage=='Y'){
	    		   $(":checkbox[value='homePage']").prop("checked",true);
	    	   }
	    	   $("#textType").find("option[value="+date[0].type+"]").attr("selected",true);
	    	   
	       }, error: function (XMLHttpRequest, status, errorThrown) {
	    	   
	       }
	   });
	
}

function draftUpdate(id){
	$('.container-megUpdate').show();
	$('.container-in').hide();
	$('.container-draft').hide();
	$('.container-subed').hide();
	$('.container-img').hide();
	$('.container-infoEditor').hide();
	$('#mainAdr').hide();
	$.ajax({
		   url:"messageUpdateAjax?type=draftbox&id="+id,  
	       type: "post",
	       dateType:"json",
	       success:function (date) {
	    	   $('#megUpdateForm').attr("action","megUpdateServlet?id="+date[0].messageId);
	    	   $('#title2').attr("value",date[0].title);
	    	   $('#introduce2').attr("value",date[0].introduce);
	    	   var ue = UE.getEditor('editor2');  
	           ue.ready(function() {//编辑器初始化完成再赋值  
	               ue.setContent(date[0].txt);  //赋值给UEditor  
	           });
	    	   $(":radio[value='发布']").attr("checked","checked");
	    	   if(date[0].discuss=='Y'){
	    		   $(":checkbox[value='discuss']").prop("checked",true);
	    	   }
	    	   if(date[0].homePage=='Y'){
	    		   $(":checkbox[value='homePage']").prop("checked",true);
	    	   }
	    	   $("#textType").find("option[value="+date[0].type+"]").attr("selected",true);
	    	   
	       }, error: function (XMLHttpRequest, status, errorThrown) {
	    	   
	       }
	   });
	
}

/*            个人信息管理                      */
function getInfoEditor(t){
   $.ajax({
	   url:"InfoEditorAjax?t="+t,  
       type: "post",
       datetype:"json",
       success:function (data) {
    	   setInforEditor(data);
       }, error: function (XMLHttpRequest, status, errorThrown) {
    	   
       }
   });
}
//将个人用户信息写到前台
function setInforEditor(data){
	$('#nicheng').attr("value",data[0].name);
	$("textarea").val(data[0].introduce);
	$(":radio[value=" +data[0].sex+ "]").attr("checked","checked");
	$('#emialInfo').attr("value",data[0].email);
	$('#phoneInfo').attr("value",data[0].telephone);
	$('#birthday').attr("value",data[0].birthday);
	$("#blood").find("option[value="+data[0].blood+"]").attr("selected",true);
}

function jump(page){
	 $.ajax({
		   url:"jumpAjax?page="+page,  
	       type: "post",
	       datetype:"json",
	       success:function (data) {
	    	   $('#historyInfo').html("");
	    	   var dataObj=eval("("+data+")");
	    	   for(var i =0;i<dataObj[0].size;i++){
	    		   var str= "<tr class='historyInfo'><td>"+dataObj[i].upTime+"</td><td>"+dataObj[i].operName+"</td>" +"<td>"+dataObj[i].type+"</td></tr>";
	    		   $('#historyInfo').append(str);
	    	   }
	    	   $('#pageCount').text(dataObj[0].count);
	    	   $('#nowPage').text(page);
	    	   countPage= dataObj[0].count;
	       }, error: function (XMLHttpRequest, status, errorThrown) {
	    	   
	       }
	   });
}

//上一页
function jumpTop(){
	if(strPage-1==0){
		jump(1);
	}else{
		strPage=strPage-1;
		jump(strPage);
	}
}
//下一页
function jumpNext(){
	if(strPage+1>countPage){
		jump(strPage);
	}else{
		strPage = strPage+1;
		jump(strPage);
	}
}

//尾页
function jumpEnd(){
	jump(countPage);
}