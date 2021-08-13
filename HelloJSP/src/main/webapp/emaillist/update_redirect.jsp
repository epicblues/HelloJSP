<%@page import="com.example.emaillist.vo.EmailVO"%>
<%@page import="com.example.emaillist.dao.EmaillistDao"%>
<%@page import="com.example.emaillist.dao.EmaillistDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Long no = Long.parseLong(request.getParameter("no"));
	String lastName = request.getParameter("last_name");
	String firstName = request.getParameter("first_name");
	String email = request.getParameter("email");
	
	EmaillistDao dao = new EmaillistDaoImpl();
	EmailVO vo = new EmailVO();
	vo.setNo(no);
	vo.setLastName(lastName);
	vo.setFirstName(firstName);
	vo.setEmail(email);
	int result = dao.update(vo);
	if (result == 1) {
		response.sendRedirect(request.getContextPath() + "/emaillist");
	} else {
		response.sendRedirect(request.getContextPath() + "/sdfsdfsfsdfsdf");
	}

%>