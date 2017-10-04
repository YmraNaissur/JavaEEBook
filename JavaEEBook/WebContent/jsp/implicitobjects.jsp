<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Демонстрация неявных объектов</title>
	</head>
	<body>
		<p>Эта JSP-страница использует неявные объекты для присоединения
		объектов к контекстам запроса (request), сеанса (session) и
		приложения (application).<br/>
		Она также получает некоторые параметры инициализации,
		передаваемые через конфигурационный файл web.xml.<br/>
		И наконец, она получает размер буфера из неявного объекта.<br/></p>
		<p>
			<%
				application.setAttribute("applicationAttribute",
					new String("Эта строка доступна для всех сеансов."));
				session.setAttribute("sessionAttribute",
					new String("Эта строка доступна для всех запросов."));
				request.setAttribute("requestAttribute",
					new String("Эта строка доступна в одном запросе."));
				
				 Enumeration<String> initParameterNames = config.getInitParameterNames();
				 out.print("Инициализация параметров, полученных ");
				 out.print("из неявных объектов конфигурации:<br/><br/>");
				 while (initParameterNames.hasMoreElements()) {
				 	String parameterName = initParameterNames.nextElement();
				 	out.println(parameterName + " = "
				 		+ config.getInitParameter(parameterName) + "<br/><br/>");
				 }
				 
				 out.println("Неявный объект <b>page</b> имеет тип "
				 	+ page.getClass().getName() + "<br/><br/>");
				 out.println("Размер буфера: " + response.getBufferSize() + " байт.");
			%>
		</p>
		<p>
			<a href="implicitobjects2.jsp">Щелкните здесь для продолжения.</a>
		</p>
	</body>
</html>