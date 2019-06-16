<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			

<!--            文章管理--- >撰写文章             start       -->
			<div class="container-megUpdate col-lg-12 col-md-12 col-sm-12" style="display: none;">
				<form id="megUpdateForm"  method="post" class="form-horizontal"style="padding-top: 20px;">
					<div class="form-group">
   						<label for="inputEmail3" class="col-sm-1 control-label">标题:</label>
    					<div class="col-sm-10">
     					    <input type="text" class="form-control" id="title2" name="title" placeholder="title">
    					</div>
 					 </div>
 					 <div class="form-group">
   						<label for="inputEmail3" class="col-sm-1 control-label">简介:</label>
    					<div class="col-sm-10">
     					    <input type="text" class="form-control" id="introduce2" name="introduce" placeholder="introduce">
    					</div>
 					 </div>
 					 <label style="margin:0px 0px 0px 40px;"">内容:</label>
					<div id="editor2" name="textEditor" style="width:92%;height:330px; margin:-15px 0px 0px 97px;">  
						<script type="text/javascript" charset="utf-8">    
							 UE.getEditor("editor2").setHeight(350);
						</script>
					</div>
					<div class="ckb">
						<label class="radio-inline">
 							 <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="release" checked="checked"> 发布
						</label>
						<label class="radio-inline">
  							<input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="draftbox"> 存入草稿箱
						</label>
						<label class="checkbox-inline">
	  						<input type="checkbox" id="inlineCheckbox1" name="inlineCheckbox1" value="discuss"> 允许评论
						</label>
						<label class="checkbox-inline">
	  						<input type="checkbox" id="inlineCheckbox2" name="inlineCheckbox2" value="homePage"> 显示在我的博客首页    
						</label>
						<label>
							<select id="textType" name="textType" class="form-control" style="width:150px;margin:10px 0px 0px 30px;">
							  <option value="未分类">---文章类型---</option>
							  <option value="数据库">数据库</option>
							  <option value="人工智能">人工智能</option>
							  <option value="程序人生">程序人生</option>
							  <option value="编程语言">编程语言</option>
							  <option value="前端">前端</option>
							  <option value="云计算/大数据">云计算/大数据</option>
							  <option value="区块链">区块链</option>
							  <option value="研发管理">研发管理</option>
							  <option value="游戏开发">游戏开发</option>
							  <option value="物联网">物联网</option>
							  <option value="运维">运维</option>
							  <option value="计算机基础">计算机基础</option>
							  <option value="移动开发">移动开发</option>
							</select>
						</label>
					</div>
					<input type="submit" value="保存" class="btn btn-default" style="margin:5px 0px 5px 90px;"/>&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置" class="btn btn-default"/>&nbsp;&nbsp;&nbsp;
					<input type="button" value="取消" class="btn btn-default"/> 
				</form>
			</div>
			<!--            文章管理--- >撰写文章             end       -->