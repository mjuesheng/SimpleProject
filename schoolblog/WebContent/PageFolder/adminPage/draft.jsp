<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--            文章管理--- >草稿箱             start       -->
			<div class="container-draft col-lg-12 col-md-12 col-sm-12" style="display:none;" >
				<div class="subText  col-lg-12 col-md-12 col-sm-12"><img src="img/1517895088_361143.png"></div>
				<div class="subMenu col-lg-12 col-md-12 col-sm-12">
					<div class="createMessage">
						<ul>
							<li class="message-btn"><a><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> 新建文章 </a></li>
						</ul>
						<ul>
							<li class="subed-btn"><a onclick="addMessage('0')"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span> 发布箱 </a></li>
						</ul>
					</div>
				</div>
				<div class="subInformation col-lg-12 col-md-12 col-sm-12">
					<table class="table table-hover subInformation-table"  style="background: #FFFFFF;">
							<tr>
								<th class="th-one">标 题</th>
								<th>允许评论</th>
								<th>发布者</th>
								<th>发布日期</th>
								<th>类型</th>
								<th>管 理</th>
							</tr>
					</table>
				</div>
			</div>
			<!--            文章管理--- >草稿箱             end       -->