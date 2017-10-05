<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Enumeration" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Проверка на возможность извлечения</title>
	</head>
	<body>
		<p>Эта страница позволяет убедиться, что мы можем получить
			атрибуты приложения, сеанса и запроса, установленные
			на предыдущей странице.</p>
			<p>Значение атрибутов приложения (applicationAttribute):
			<%= application.getAttribute("applicationAttribute") %>
			<br/>
			Значение атрибутов сеанса (sessionAttribute):
			<%= session.getAttribute("sessionAttribute") %>
			<br/>
			Значение атрибутов запроса (requestAttribute):
			<%= request.getAttribute("requestAttribute") %>
		</p>
		<p>В контексте приложения были найдены следующие атрибуты:
			<br/><br/>
			<%
				Enumeration<String> applicationAttributeNames = pageContext
					.getAttributeNamesInScope(PageContext.APPLICATION_SCOPE);
				while (applicationAttributeNames.hasMoreElements()) {
					out.println(applicationAttributeNames.nextElement() + "<br/>");
				}
			%>
		</p>
		<p><a href="jsp/buggy.jsp">Эта гиперссылка указывает на JSP, к которой
			будет выполняться переход при возникновении исключения.</a></p>
	</body>
</html>