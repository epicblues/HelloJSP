<%@page import="com.example.emaillist.dao.EmaillistDaoImpl"%>
<%@page import="com.example.emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 파라미터 받기
Long no = Long.parseLong(request.getParameter("no"));
// Dao 불러오기
EmaillistDao dao = new EmaillistDaoImpl();
// 삭제
int result = dao.delete(no);

// index.jsp로 Redirect
if(result == 1) {
	response.sendRedirect(request.getContextPath()+"/emaillist");
}
%>
