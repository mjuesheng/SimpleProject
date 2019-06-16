<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<!--            账号管理 ----密码修改                              start       -->
			<div class="container-webInfo col-lg-12 col-md-12 col-sm-12" style="display:none;">
				
				<div id="create-container"  class="col-lg-12 col-md-12 col-sm-12">
				
					<form action="upPsdServlet" onsubmit="return checkPsw2()" id="" method="post">
						<div class="form-group">
    						<label for="exampleInputPassword1">旧密码</label>
    						<input type="password" class="form-control" id="oldpsd"  name="oldpsd" placeholder="Password" onblur="updataCheckOld()">
  							<label id="oldpwd-msg" style="color:red;"></label>
  						</div>
  						<div class="form-group">
    						<label for="exampleInputPassword1">新密码</label>
    						<input type="password" class="form-control" id="newpsd" name="newpsd" placeholder="Password" onblur="updataCheckOne()">
  							<label id="password-msg" style="color:red;"></label>
  						</div>
  						<div class="form-group">
    						<label for="exampleInputPassword1">确认新密码</label>
    						<input type="password" class="form-control" id="new2psd" name="new2psd" placeholder="Password" onblur="updataCheckTwo()">
  							<label id="psdt-msg" style="color:red;"></label>
  						</div>
  						<div></div>
  						<div class="form-group">
    						<div class="col-sm-offset-2 col-sm-10">
      							<button type="submit" id="xiugai" class="btn btn-default">修改</button>
   							 </div>
  						</div>
					</form>
				</div>
			</div>
			
			<!--            账号管理 ----密码修改                              end       -->