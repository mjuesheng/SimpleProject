<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="left_menu" class="col-lg-2 col-md-2 col-sm-2">
			<div id="touxiang" class="col-lg-12 col-md-12 col-sm-12 left-img">
				<form action="UploadServlet"  enctype="multipart/form-data" method="post" style="display:none">
					<input type="file" name="file1" id="btn_file" onchange="fileSub()" />
					<input type="submit" id="btn_sub" /> 
				</form>
				|<img src="" onclick="OpenDialog()">|
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12 left-text">
				<span><a href="#">文章(10)</a></span>
				<span><a href="#">评论(1300)</a></span>
				<span><a href="#">活跃度(99)</a></span>
			</div>
			<div class="subNav sub0 col-lg-12 col-md-12 col-sm-12 "><a href="PersonalAdmin.jsp">后台首页</a></div>
			<div class="subNav sub1 col-lg-12 col-md-12 col-sm-12 ">文章管理</div>
			<ul class="navContent nav1 col-lg-12 col-md-12 col-sm-12" >
				<li>
					<a class="messageClick"><span class="glyphicon glyphicon-menu-hamburger"></span> 撰写文章</a>
				</li>
				<li>
					<a class="subedClick" onclick="addMessage('0')"><span class="glyphicon glyphicon-menu-hamburger"></span> 已发布</a>
				</li>
				<li>
					<a class="draftClick" onclick="addDraftbox('0')"><span class="glyphicon glyphicon-menu-hamburger"></span> 草稿箱</a>
				</li>
				<!--  
				<li>
					<a href=""><span class="glyphicon glyphicon-menu-hamburger"></span> 垃圾箱</a>
				</li>
				-->
			</ul>
			
			<!--  
			<div class="subNav sub2 col-lg-12 col-md-12 col-sm-12">评论专区</div>
			<ul class="navContent nav2 col-lg-12 col-md-12 col-sm-12" style="display:none">
				<li>
					<a href="#"><span class="glyphicon glyphicon-menu-hamburger"></span> 评论管理</a>
				</li>
				<li>
					<a href="#"><span class="glyphicon glyphicon-menu-hamburger"></span> 评论设置</a>
				</li>
			</ul>
			-->	
			<div class="subNav sub3 col-lg-12 col-md-12 col-sm-12">个人资料</div>
			<ul class="navContent nav3 col-lg-12 col-md-12 col-sm-12" style="display:none">
				<li>
					<a class="peronalInfoClick" onclick="getInfoEditor(0)"><span class="glyphicon glyphicon-menu-hamburger"></span> 信息管理</a>
				</li>
				<li>
					<a class="pitctureClick"><span class="glyphicon glyphicon-menu-hamburger"></span> 图 片 库</a>
				</li>
			</ul>

			<div class="subNav sub4 col-lg-12 col-md-12 col-sm-12">账号管理</div>
			<ul class="navContent nav4 col-lg-12 col-md-12 col-sm-12" style="display:none">
				<li>
					<a class="updatepsd"><span class="glyphicon glyphicon-menu-hamburger"></span> 密码修改</a>
				</li>
				<!--  
				<li>
					<a href="#"><span class="glyphicon glyphicon-menu-hamburger"></span> 安全验证</a>
				</li>
				-->
			</ul>
			<div class="subNav sub5 col-lg-12 col-md-12 col-sm-12">网站相关</div>
			<ul class="navContent nav5 col-lg-12 col-md-12 col-sm-12" style="display:none">
				<li>
					<a class="helpButton"><span class="glyphicon glyphicon-menu-hamburger"></span> 网站简介</a>
				</li>
				<li>
					<a class="infoSumButton"><span class="glyphicon glyphicon-menu-hamburger"></span> 网站信息</a>
				</li>
			</ul>
		</div>

		</div>