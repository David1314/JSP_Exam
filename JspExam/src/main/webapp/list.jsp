<%@ page language="java" import="java.util.*,com.yuxiaoli.domain.Film" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Object obj=request.getAttribute("msg");
	if(obj!=null){
		out.println(obj.toString());
	}
	%>
	<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
		align="center">
		<tr>
			<td bgcolor="#E8E8E8">Film_id</td>
			<td bgcolor="#E8E8E8">title</td>
			<td bgcolor="#E8E8E8">description</td>
			<td bgcolor="#E8E8E8">name</td>
			<td bgcolor="#E8E8E8">删除</td>
		</tr>
		<%
			request.setCharacterEncoding("utf-8");
		  
		%>
<c:forEach var="film" items="${requestScope.filmList}" >
			<tr> 
					
                    <td>${film.film_id} </td> 
                    <td>${film.title}</td>
                    <td>${film.description}</td>
                    <td>${film.name}</td>
                    <td><a href="DeleteFilmServlet?film_id=${film.film_id}">删除</a></td>
          </tr> 
	</c:forEach>
	</table>
</body>
</html>