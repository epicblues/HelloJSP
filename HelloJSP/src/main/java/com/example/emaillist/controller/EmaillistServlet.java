package com.example.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.emaillist.dao.EmaillistDao;
import com.example.emaillist.dao.EmaillistDaoImpl;
import com.example.emaillist.vo.EmailVO;

//@WebServlet(name="EmailList", urlPatterns="/el")
@WebServlet("/el")
public class EmaillistServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 목록 가져오기
		EmaillistDao dao = new EmaillistDaoImpl();
		List<EmailVO> list = dao.getList();
		
		// 요청에 list를 추가
		// list 객체를 list 키로 추가
		req.setAttribute("list", list);
		
		// JSP 요청을 전달(FORWARD);
		RequestDispatcher rd = getServletContext()
				.getRequestDispatcher("/WEB-INF/views/emaillist/index.jsp");
		rd.forward(req, res);
	}
}
