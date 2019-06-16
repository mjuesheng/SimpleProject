<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<!--            个人资料管理--- >             start       -->
		<div class="container-infoEditor col-lg-12 col-sm-12" style="display:none">
			<div  class="infoEditor_header" class="col-lg-12 col-sm-12"  >
					<p>
						<span class="glyphicon glyphicon-option-vertical" aria-hidden="true"></span>
						个人资料档案
					</p>
					<div class="editor">
						<ul>
							<li class="message-btn"><a onclick="$('#sub').click();">保存设置 </a></li>
						</ul>
					</div>
				</div>
				<div class="infoEditor_form col-lg-12 col-md-12 col-sm-9">
					<form action="InfoEditorAjax?t=1" method="post" class="form-horizontal col-lg-9 col-md-9 col-sm-9" >
						<div class="form-group">
	    					<label for="exampleInputName2">*昵 称:</label>
	   						<input type="text" class="form-control" name="nicheng" id="nicheng" value=""  />
						</div>
						<div class="form-group">
	    					<label for="exampleInputName2">*个人介绍:</label>
	   						<textarea class="form-control" rows="4" cols="70" id="introduce" name="introduce"></textarea>
						</div>
						<div class="form-group" style="float: left;margin-right: 5%;">
	    					<label for="exampleInputName2">*性 别:&nbsp;&nbsp;&nbsp;&nbsp;</label>
	   						男 <input type="radio" name="sex" id="boy" value="男" />
							女 <input type="radio" name="sex" id="girl" value="女" />
						</div>
						
						<div class="form-group" style="float: left;margin-right: 5%;">
	    					<label for="exampleInputName2">*血 型:&nbsp;&nbsp;</label>
	   						<select name="blood" id="blood">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="AB">AB</option>
								<option value="O">O</option>
							</select>&nbsp;性	
						</div>
						<div class="clear"></div>
						<div class="form-group">
	    					<label for="exampleInputName2">*邮 箱:</label>
	   						<input type="text" class="form-control" name="emialInfo" id="emialInfo" value="" />
						</div>
						<div class="form-group">
	    					<label for="exampleInputName2">*手机号:</label>
	   						<input type="text" class="form-control" name="phoneInfo" id="phoneInfo" value="" />
						</div>
						<div class="form-group">
	    					<label for="exampleInputName2">*出生日期:</label>
	    					<input type="date" class="form-control" name="birthday" id="birthday" value="" />
						</div>
						<input type="submit" id="sub" style="display:none;"/>
					</form>
				</div>
			</div>
			<!--            个人资料管理--- >             end       -->
			