<%@page import="dao.FboardDAO"%>
<%@page import="dto.FboardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>listDemo.jsp</title>
</head>
<body>
<%
	List<FboardDTO> list = FboardDAO.getDao().listFboard();
	
%>
<%
	for (FboardDTO e : list) {
%>
		<p><%=e.getNum()%> | <%=e.getSubject()%> | <%=e.getWriter()%></p>
<% 
	}
%>
</body>
</html>