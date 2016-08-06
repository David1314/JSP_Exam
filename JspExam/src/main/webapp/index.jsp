<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Object obj=session.getAttribute("username");
   if(obj!=null){ %>
	   <a href="<%=request.getContextPath() %>/LogoutSerlet">退出</a>
	<br/><br/><br/>
<%    }else{%>
	<a href="login.jsp">用户登录</a>
	<br/><br/><br/>
 <%   }%>

	使用jsp对film的操作：
	<br/>
	<a href="list.jsp">显示film列表</a>
	<br/>
	<a href="add_film">新增film项</a>
	<br/>
	<a href="delete_film">删除film项</a>
	<br/><br/><br/>
	
	使用html对film列表进行编辑：
	<br/>
	<a href="edit.jsp">编辑film项</a>
</body>
</html>