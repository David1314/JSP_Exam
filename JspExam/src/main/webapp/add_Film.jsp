<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	<div>
	<%
		Object obj=request.getAttribute("msg");
	if(obj!=null){
		out.println(obj.toString());
	}
	%>
      <form action="<%=request.getContextPath() %>/QueryLanguageByNameServlet" method="post">
        <fieldset>
          <legend>增加Film</legend>
          title:
        <input type="text" name="title" placeholder="title"><br><br/>
        description:
        <input type="text" name="description" placeholder="description"><br><br/>
        language:
        <select name="language">
        	<c:forEach var="language" items="${requestScope.list}">
				<option value="${language}">${language}</option>
		</c:forEach>
        </select>
        <br/><br/>
        <input type="submit" value="添加" class="btn">
        <input type="reset" value="重置">
        
        </fieldset>
     </form>
    </div>
</body>
</html>