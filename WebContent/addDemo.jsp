<%@page import="dao.FboardDAO"%>
<%@page import="dto.FboardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>addDemo.jsp</title>
</head>
<body>
<%
	FboardDTO vo = new FboardDTO();
	vo.setSubject("ㅎㅇ");
	vo.setWriter("나");
	vo.setContent("MyBatis 연습");
	vo.setReip(request.getRemoteAddr());
	
	FboardDAO.getDao().addFboard(vo);
%>
</body>
</html>