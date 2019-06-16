
var newsSize = 10;    //记录博客数量，根据这个长度去展示新闻数量
/*       首页文章创建    start          */
function createText(date){
	$('.tableContainer').remove();
	for(var i = 0; i < date[0].size; i++) {
		$("#middle_message").prepend($('<table class="tableContainer table table-hover"><tr><td class="tdContainer"></td></tr></table>'));
	}
	
	$(".tdContainer").each(function(){
		$(this).prepend($('<a class="TbLJ" href="#"></a>'));
	});
	
	var index=0;
	$(".TbLJ").each(function(){
		$(this).attr("href","documentServlet?messageId="+date[index].messageId);
		$(this).append($('<p class="meessage_Titlefont"></p>'));
		$(this).append($('<p class="meessage_authorFont"></p>'));
		index++;
	});
	$(".meessage_authorFont").each(function(){
		$(this).append($('<em class="textType"></em>'));
		$(this).append($('<em class="author"></em>'));
		$(this).append($('<em class="textDate"></em>'));
		$(this).append($('<em class="newOrold"></em>'));
		$(this).append($('<em class="readNumInfo"></em>'));
	});
	
	//添加内容
	var index=0;
	$('.meessage_Titlefont').each(function(){
		if(index>=date[0].size){
			index=0;
		}
		$(this).text(date[index].title);
		index++;
	});
	$('.textType').each(function(){
		if(index>=date[0].size){
			index=0;
		}
		$(this).text(date[index].textType);
		index++;
	});
	$('.author').each(function(){
		if(index>=date[0].size){
			index=0;
		}
		$(this).text("作者："+date[index].author);
		index++;
	});
	$('.textDate').each(function(){
		if(index>=date[0].size){
			index=0;
		}
		$(this).text(date[index].date);
		index++;
	});
	$('.readNumInfo').each(function(){
		if(index>=date[0].size){
			index=0;
		}
		$(this).html("阅读数：<em style='color:#5FBDEB'>"+date[index].readNum+"</em>");
		index++;
	});
}

//首页文章信息
function conectionText(t){
	$.ajax({
		url:"indexAjax?t="+t,
		type:"post",
		dataType: "json",
		success:function(date){
			newsSize = date[0].size;
			createText(date);
		},error:function(){
				
		}
	});
}
/*       首页文章创建    end          */


/*        左侧导航条自动创建     start               */
function createNavigationBarAjax(){
	 $.ajax({  
        url:"NavigationBarAjax",  
        type: "post",
        datetype:"json",
        success: function (result, status) {   	
        	var dataObj=eval("("+result+")");
        	createNavigationBar(dataObj);
        }, error: function (res) {
        	alert(res)
        }  
    });
}

function createNavigationBar(result){
	$('.createNavigationBar li').remove();
	for(var i = 0; i < result[0].size; i++) {
		$('.createNavigationBar').append($('<li class="lan'+i+'"></li>'));
	}
	var i=0;
	$(".createNavigationBar li").each(function(){
		$(this).prepend($('<a href="releaseTypeAjax?t=1&type='+result[i].name+'">'+result[i].name+'</a>'));
		i++;
	});
}
/*        左侧导航条自动创建     end               */


/*        今日新闻     start               */
function createNewsAjax(){
	 $.ajax({  
        url:"xinwenAjax",  
        type: "post",
        datetype:"json",
        success: function (data, status) {   	
        	createNews(data);
        }, error: function (res) {
        	alert(res)
        }  
    });
}
function createNews(result){
	$('#todayNews a').remove();
	for(var i = 0; i <newsSize ; i++) {
		$('#todayNews').append($('<a></a>'));
	}
	var i =0;
	$("#todayNews a").each(function(){
		$(this).append($('<div class="newsTitle" style="">'+result[i].title+'</div>'));
		$(this).attr("href",result[i].newsUrl);
		i++;
	});
	
}
/*        今日新闻     end               */




