package com.example.emaillist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.emaillist.dao.UserDao;
import com.example.emaillist.dao.UserDaoImpl;
import com.example.emaillist.vo.UserVo;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		if ("join".equals(actionName)) {
			// 가입절차 수행
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			UserVo vo = new UserVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setEmail(email);
			vo.setGender(gender);
			UserDao dao = new UserDaoImpl();
			int result = dao.insert(vo);
			if (result == 1) {
				// 가입 성공
				resp.sendRedirect(req.getContextPath() + "/users?a=joinsuccess");
			} else {
				// 다시 joinform으로 리다이렉트
				resp.sendRedirect(req.getContextPath() + "/users?a=joinform");
			}

		} else if ("login".equals(actionName)) {
			UserDao dao = new UserDaoImpl();
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			UserVo vo = dao.getUserByEmailAndPassword(email, password);
			if(vo == null) {
				// 사용자 없음 or 비밀번호 오류
				System.err.println("사용자 없음");
				// 다시 로그인 폼으로
				resp.sendRedirect(req.getContextPath() + "/users?a=loginform");
			} else {
				// 사용자가 있다.
				System.out.println("사용자 발견! " + vo);
				// 사용자 정보를 서버에 기록(Session)
				// 홈페이지로 redirect
				resp.sendRedirect(req.getContextPath());
			}
		} else {
			resp.sendError(404);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get 요청처리
		String actionName = req.getParameter("a");
		if ("joinform".equals(actionName)) {
			// a = joinform
			RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/WEB-INF/views/users/joinform.jsp");
			rd.forward(req, resp);
		} else if ("joinsuccess".equals(actionName)) {
			// a =joinsuccess
			// 가입 성공 페이지로
			RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/WEB-INF/views/users/joinsuccess.jsp");
			rd.forward(req, resp);
		} else if ("loginform".equals(actionName)) {
			// a=loginform
			// 로그인 폼 페이지로
			RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/WEB-INF/views/users/loginform.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendError(404);
		}
	}
}
