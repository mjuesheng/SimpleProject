<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--     middle   start        -->
			<div id="middle" class="col-lg-6" >
				<div class="doc_header">
					<h1>
						<span class="glyphicon glyphicon-file" aria-hidden="true"></span>
							${map['textName']}
					</h1>
					<span class="doc_time">发布时间：${map['date']}</span>
					<span class="doc_personNum">阅读数：${map['readNum']} 次</span>
				</div>
				<hr />
				<div class="authorIntroduce">
					<span>
						作者：${map['username']}，${map['personalIntro']}
					</span>
				</div>
				<div class="doc_text">
					${map['txt']}
				</div>
				
					<div class="kongbai"></div>
			</div>
			<!--     middle   end        -->