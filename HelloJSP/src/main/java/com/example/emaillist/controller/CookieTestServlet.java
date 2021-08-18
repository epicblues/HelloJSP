package com.example.emaillist.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cookies")
public class CookieTestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("a");
		Cookie[] cookies = req.getCookies();
		
		if("delete".equals(action)) {
			if(cookies != null) {
				for (Cookie cookie : cookies) {
					if(cookie.getName().equals("example")) {
						// 쿠키는 삭제할 수없다=>무효화
						Cookie jcookie = new Cookie("example","");
						jcookie.setMaxAge(0);
						resp.addCookie(jcookie);
						
						break;
					}
				}
			}
		} 
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/cookies/cookie_form.jsp");
		rd.forward(req, resp);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//쿠키 세팅
		String value = req.getParameter("example");
		System.out.println("설정한 쿠키 값 : " +  value);
		
		//쿠키 생성
		Cookie cookie = new Cookie("example",value);
		
		//쿠키를 브라우저에 설정 : 응답객체에 추가
		resp.addCookie(cookie);
		
		// 응답 전송
		resp.sendRedirect(req.getContextPath() + "/cookies");
	}
}
