package kms.practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PracticeServlet extends HttpServlet {

	// XML이 이 객체에 해당하는 URL패턴을 획득하면 이 클래스의 인스턴스를 서버의 tomcat이 로드하고
	// 이 객체의 service 메소드에 서버로 부터 받은 request header의 데이터를 HttpServletRequest구현 객체로
	// 로드해서 파라미터로 넘겨준다.
	// service 메소드는 request 객체의 요청 종류(get, post, put, ...)에 맞는 do~메소드를 호출한다.

	@Override
	public void init() throws ServletException {
		System.out.println(getServletName() + "이 객체에 로드되었습니다!");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		if("sessiontest".equals(actionName)) {
			HttpSession session = req.getSession(false);
			session.setAttribute("weaponType", req.getParameter("weapon_type"));
			session.setAttribute("registerDate", req.getParameter("register_date"));
			resp.sendRedirect(req.getContextPath() + "/practice");
		}
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println(arg0.getRemoteHost() + "가 보낸 요청을 service 메소드로 받았습니다.");
		super.service(arg0, arg1);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("a") == null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/practice/main.jsp");
			rd.forward(req, resp);
		}
		
	}
}
