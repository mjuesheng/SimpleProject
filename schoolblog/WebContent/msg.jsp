<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script language="javascript" type="text/javascript">
		// 以下方式定时跳转
		setTimeout("javascript:location.href='PersonalAdmin.jsp'", 3000); 
</script>
</head>
<body>
	${msg}...   <a href="PersonalAdmin.jsp">三秒返回主页面</a>
</body>

</html>