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
public class EmaillistServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String actionName = req.getParameter("action");
		// INSERT 처리
		if ("add".equals(actionName)) {
			String lastName = req.getParameter("last_name");
			String firstName = req.getParameter("first_name");
			String email = req.getParameter("email");

			EmaillistDao dao = new EmaillistDaoImpl();
			EmailVO vo = new EmailVO();
			vo.setLastName(lastName);
			vo.setFirstName(firstName);
			vo.setEmail(email);
			int result = dao.insert(vo);

			// index.jsp로 리다이렉트(페이지 전환: 302)
			if (result != 1) {
				res.sendRedirect(req.getContextPath() + "/el?a=form");
			} else {
				res.sendRedirect(req.getContextPath() + "/el");
			}
		} else if ("delete".equals(actionName)) {
			Long no = Long.parseLong(req.getParameter("no"));
			// Dao 불러오기
			EmaillistDao dao = new EmaillistDaoImpl();
			// 삭제
			int result = dao.delete(no);

			// index.jsp로 Redirect
			if (result == 1) {
				res.sendRedirect(req.getContextPath() + "/el");
			}
		} else if ("update".equals(actionName)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/update.jsp");
			rd.forward(req, res);

		} else if ("update_process".equals(actionName)) {
			Long no = Long.parseLong(req.getParameter("no"));
			String lastName = req.getParameter("last_name");
			String firstName = req.getParameter("first_name");
			String email = req.getParameter("email");
			
			EmaillistDao dao = new EmaillistDaoImpl();
			EmailVO vo = new EmailVO();
			vo.setNo(no);
			vo.setLastName(lastName);
			vo.setFirstName(firstName);
			vo.setEmail(email);
			int result = dao.update(vo);
			if (result == 1) {
				res.sendRedirect(req.getContextPath() + "/el");
			} else {
				res.sendRedirect(req.getContextPath() + "/views/error/error.jsp");
			}

		} else {
			doGet(req, res);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 파라미터 확인
		String formParam = req.getParameter("a");
		if ("form".equals(formParam)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/form.jsp");
			// 전달
			rd.forward(req, res);

		} else {

			// 목록 가져오기
			EmaillistDao dao = new EmaillistDaoImpl();
			List<EmailVO> list = dao.getList();

			// 요청에 list를 추가
			// list 객체를 list 키로 추가
			req.setAttribute("list", list);

			// JSP 요청을 전달(FORWARD);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/index.jsp");
			rd.forward(req, res);
		}
	}
}
