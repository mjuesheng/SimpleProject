
var isAnimated = false; // 控制上部导航栏是否执行动画

/**
 * 二级菜单显示
 */
function show() {
	$(this).find("div").fadeIn(300);
}

/**
 * 二级菜单隐藏
 */
function hidden() {
	$(this).find("div").fadeOut(300);
}

$(document).ready(function() {
	
	// 二级菜单
	$("#nav>ul>li").each(
		function() {
			this.onmouseover = show;
			this.onmouseleave = hidden;
		}
	);

    // 上部导航栏显示与隐藏
    $(window).on("scroll",function(){
        if($(this).scrollTop() > 260){
            if(!isAnimated){
                $("#head_nav_top").animate({"top":"0px"},500);
                isAnimated = true;
            }
        }else{
            isAnimated = false;
            $("#head_nav_top").css("top","-50px");
        }
		
    })
	
});
