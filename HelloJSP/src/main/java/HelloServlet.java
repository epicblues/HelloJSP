import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿은 HttpServlet을 상속
public class HelloServlet extends HttpServlet {

	// GET 방식의 요청을 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 응답의 페이지 타입 결정
		res.setContentType("text/html; charset= UTF-8");
		// MIME-TYPE ex) image/jpg, image/png, text/css -> 브라우저가 읽을 때 적용

		// 파라미터 확인
		String name = req.getParameter("name");

		if (name == null) {
			name = "Anonymous";
		}
		
		
		// 응답 출력을 위한 Writer
		PrintWriter out = res.getWriter();
		out.println("<h3>Hello Servlet</h3>");
		out.println("<p>Welcome, " + name + "</p>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 페이지 응답 설정
		res.setContentType("text/html; charset= UTF-8");
		
		// 파라미터 받아오기
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		
		PrintWriter out = res.getWriter();
		out.println("<h3>Form Data</h3>");
		out.println("<p>성: " + last_name +"</p>");
		out.println("<p>이름: " + first_name +"</p>");

	}

}
