import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿은 HttpServlet을 상속
public class HelloServlet extends HttpServlet{

	//GET 방식의 요청을 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 파라미터 확인
		String name = req.getParameter("name");
		
		if(name == null) {
			name = "Anonymous";
		}
		
		// 응답 출력을 위한 Writer
		PrintWriter out = res.getWriter();
		out.println("<h3>Hello Servlet</h3>");
		out.println("<p>Welcome, " + name + "</p>");
	}
	
}
