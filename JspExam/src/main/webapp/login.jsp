<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <style type="text/css">
    	body{
    		color:#000;
    		font-size:14px;
    		margin:20px auto;
    	}
    	#message{
    		text-align: center;
    	}
    </style>
    <script type="text/javascript">
    	function check(form){
    		if(document.forms.loginForm.username.value==""){
    			alert("请输入用户名！");
    			document.forms.loginForm.username.focus();
    			return false;
    		}
    		if(document.forms.loginForm.password.value==""){
    			alert("请输入密码！");
    			document.forms.loginForm.password.focus();
    			return false;
    		}
    	}
    </script>
  </head>
  
  <body>
  <div id="message">
   <%
   		request.setCharacterEncoding("utf-8");
   		Object obj=request.getAttribute("msg");
   if(obj!=null){
	   out.println(obj.toString());
   }
   %>
   </div>
   <form action="<%=request.getContextPath() %>/LoginServlet" method="post" name="loginForm">
   <table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
   	<tr>
   		<td colspan="2" align="center" bgcolor="#E8E8E8">用户登录</td>
   	</tr>
   	<tr>
   		<td>用户名</td>
   		<td><input type="text" name="username"/></td>
   		
   	</tr>
   	<tr>
   		<td colspan="2" align="center">
		<input type="submit" name="submit" onclick="return check(this);">
		<input type="reset" name="reset">
	</td>
   	</tr>
   	  
   </table>

   </form>
  </body>
</html>
