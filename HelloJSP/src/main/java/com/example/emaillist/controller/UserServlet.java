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
public class UserServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		if("join".equals(actionName)) {
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
			if(result == 1) {
				resp.sendRedirect(req.getContextPath() + "/users?a=joinsuccess");
			} else {
				resp.sendError(404);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get 요청처리
		String actionName= req.getParameter("a");
		if("joinform".equals(actionName)) {
			// a = joinform
			RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/WEB-INF/views/users/joinform.jsp");
			rd.forward(req, resp);
		} else if ("joinsuccess".equals(actionName)) {
			// a =joinsuccess
			// 가입 성공 페이지로
			RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/WEB-INF/views/users/joinsuccess.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendError(404);
		}
	}
}
