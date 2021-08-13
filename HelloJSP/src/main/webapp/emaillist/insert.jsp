<%@page import="com.example.emaillist.vo.EmailVO"%>
<%@page import="com.example.emaillist.dao.EmaillistDaoImpl"%>
<%@page import="com.example.emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 파라미터 받아 오기
	String lastName = request.getParameter("last_name");
	String firstName = request.getParameter("first_name");
	String email = request.getParameter("email");
	
	EmaillistDao dao = new EmaillistDaoImpl();
	EmailVO vo = new EmailVO();
	vo.setLastName(lastName);
	vo.setFirstName(firstName);
	vo.setEmail(email);
	int result = dao.insert(vo);
	
	// index.jsp로 리다이렉트(페이지 전환: 302)
	if(result != 1) {
		response.sendRedirect(request.getContextPath() + "/emaillist/form.jsp");
	} else {
		response.sendRedirect(request.getContextPath() + "/emaillist");
	}
	
%>