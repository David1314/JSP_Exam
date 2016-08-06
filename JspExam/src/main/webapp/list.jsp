<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver" align="center">
   	<tr>
   		<td bgcolor="#E8E8E8">Film_id</td>
   		<td bgcolor="#E8E8E8">title</td>
   		<td bgcolor="#E8E8E8">description</td>
   		<td bgcolor="#E8E8E8">language_id</td>
   		<td bgcolor="#E8E8E8">name</td>
   		<td bgcolor="#E8E8E8">删除</td>
   	</tr>
   		<%-- <c:forEach var="list" items="${request.getAttrbute("list")}">
			<tr> 
                    <td> ${list.village} </td> 
                    <td>${list.area}</td>
                    <td>${list.price}</td>
                    <td>${list.people}</td>
                    <td>${list.phone}</td>
          </tr> 
	</c:forEach> --%>
   	</table>
</body>
</html>