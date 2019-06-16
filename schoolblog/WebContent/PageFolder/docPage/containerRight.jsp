<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--     right   start        -->
			<div id="right" class="col-lg-3" >
				<div class="authorInfo">
					<div class="gerenziliao">
						<span style=";">|</span>个人资料
					</div>
					<div class="touxiang">
						<div>
							<img src="${ map['imgurl']}" onerror="this.src='img/xiaolian.jpg'" />${map['username']}
							<button class="btn btn-default">关注</button>
						</div>
					</div>
					<div class="simpleInfo">
						<table class="table" >
							<tr>
								<td>原创</td>
								<td>粉丝</td>
								<td>喜欢</td>
								<td>评论</td>
							</tr>
							<tr>
								<td>${map['txtNum']}</td>
								<td>666</td>
								<td>66</td>
								<td>809</td>
							</tr>
						</table>
					</div>
					<div class="kongbai"></div>
				</div>
				<div class="personalMessage">
					<div class="gerenziliao">
						<span style="">|</span>文章推荐
					</div>
					<div class="megTitle">
						<ul>
							<li><a>人工智能为听障学生打造全新课堂</a></li>
							<li><a>通用的架构方法论通用的架构方法论通用的架构方法论通用的架构方法论通用的架构方法论通用的架构方法论</a></li>
							<li><a>通用的架构方法论</a></li>
							<li><a>通用的架构方法论</a></li>
							<li><a>通用的架构方法论</a></li>
						</ul>
					</div>
					<div class="kongbai"></div>
				</div>
			</div>
			<!--     right   end        -->