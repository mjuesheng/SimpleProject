<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<!--  后台首页     start   -->
			<div id="mainAdr">
				<!--  头     -->
				<div class="currmenu">
					<ul class="rig_nav">
						<li class="rig_seleli">
							<a href="PersonalAdmin.jsp">首页</a><span> x </span>
						</li>
						
					</ul>
				</div>

				<!--  信息公告    -->
				<div class="adtip">
					<div class="tip">
						<p class="goom">欢迎您，${username}</p>
						<p>文章发布总数<span>${releaseNum}</span>条，<span>${draftNum}</span>条未完成</p>
					</div>
					<div class="adv">
						<p>个人用户信息相关</p>
						<span> x </span>
					</div>
				</div>
				<!--  四个图片    -->
				<div class="rig_link">
					<ul>
						<li style="border: 1px solid #F5B58F;">
							<a class="messageClick" ><img src="img/img_01.jpg" alt="" title=""></a><br/>文章撰写</li>
						<li style="border: 1px solid #F29875;">
							<a class="infoSumButton"><img src="img/img_02.jpg" alt="" title=""></a><br/>网站数据</li>
						<li style="border: 1px solid #A5CAF7;">
							<a class="peronalInfoClick" onclick="getInfoEditor(0)"><img src="img/img_03.jpg" alt="" title=""></a><br/>个人信息</li>
						<li style="border: 1px solid #F6CB87;">
							<a class="helpButton"><img src="img/img_04.jpg" alt="" title=""></a><br/>网站相关</li>
					</ul>
				</div>
				
				<div class="rig_lm02">
					<div class="title"><img src="img/listicon.jpg" class="icon">
						<h2>相关信息展示</h2>
					</div>
					<div class="detail">
						<div class="det_inner">
							<div class="scordeti">
								<ul>
									<li>
										<p class="ywc">${releaseNum}</p>
										<h3>已发布文章</h3>
									</li>
									<li>
										<p class="wwc">${draftNum}</p>
										<h3>未完成文章</h3>
									</li>
									<li>
										<p class="ycd">120</p>
										<h3>访问人数</h3>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				
				<div class="rig_lm03" >
					<div class="title"><img src="img/listicon.jpg" class="icon">
						<h2>历史操作记录</h2>
					</div>
					<div class="clear"></div>
					<div class="caozuo">
						<table  id="historyInfo" class="table table-hover">
							<tr>
								<td>时间</td>
								<td>操作对象</td>
								<td>操作信息</td>
							</tr>
						</table>
						<div class="mainDaohang">
							<a onclick="jump(1)">首页</a>
							<a onclick="jumpTop()">上一页</a>
							<a onclick="jumpNext()">下一页</a>
							<a onclick="jumpEnd()">尾页</a>
							当前页数:<span id="nowPage"></span>/<span id="pageCount"></span>页
						</div>
					</div>
				</div>
				
				
			</div>
			<!--  后台首页     end   -->