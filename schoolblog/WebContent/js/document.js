/*    推荐文章    创建      start  */
function tuijianTextAjax(){
	$.ajax({
		url:"tuijian",
		type:"post",
		dataType: "json",
		success:function(data){
			createTuijinText(data);
		},error: function (XMLHttpRequest, textStatus, errorThrown) {
        	alert(errorThrown);
        } 
	});
}


function createTuijinText(data){
	$('.megTitle li').remove();
	for(var i = 0; i <data[0].size ; i++) {
		$('.megTitle').append($("<li class='tuijianLi'></li>"));
	}
	i=0;
	$(".megTitle li").each(function(){
		$(this).append($('<a class="tuijianA" href=documentServlet?messageId='+data[i].releaseId+'>'+data[i].title+'</a>'));
		$(this).append($('<p class="tuijianP">作者:'+data[i].username+' | 类型:'+data[i].type+' | 阅读数:'+data[i].readNum+'</p>'));
		i++;
	});
}
/*    推荐文章    创建      end  */