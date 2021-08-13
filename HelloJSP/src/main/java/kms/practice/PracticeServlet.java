package kms.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PracticeServlet extends HttpServlet {

	// XML이 이 객체에 해당하는 URL을 획득하면 이 클래스의 인스턴스를 서버의 tomcat이 로드하고
	// 이 객체의 service 메소드에 서버로 부터 받은 request header의 데이터를 HttpServletRequest구현 객체로
	// 로드해서 파라미터로 넘겨준다.
	// service 메소드는 request 객체의 요청 종류(get, post, put, ...)에 맞는 do~메소드를 호출한다.

	@Override
	public void init() throws ServletException {
		System.out.println(getServletName() + "이 객체에 로드되었습니다!");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println(arg0.getRemoteHost() + "가 보낸 요청을 service 메소드로 받았습니다.");
		super.service(arg0, arg1);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		for(Method method : this.getClass().getMethods()) {
//			System.out.println(method.getName());
//		}
		// response객체의 body 문서 유형 결정
		
		String param = req.getParameter("name");
		if (param != null &&param.equals("kmsbabo")) throw new IOException();
		System.out.println(req.getCharacterEncoding());
		System.out.println(req.getRemoteHost());
		System.out.println(req.getRemotePort());
		System.out.println(req.getRemoteUser());
		req.getParameterMap().forEach((str, strArr) -> {
			System.out.printf("%s : %s%n", str, strArr[0]);
		});

		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = resp.getWriter(); // response body에 작성할 html
		writer.println("<h1>Title Test 1</h1>");
		writer.println("<p>Servlet이 잘 작성되었습니까?</p>");
		writer.println("<p>접속자의 이름은 " + param + "입니다!");
		writer.flush();
		writer.close();

		Thread thread = new Thread(() -> {
			Stream<Integer> intStream = Arrays.stream(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
			intStream.filter((i) -> i > 5).peek((i) -> {
				System.out.println(Thread.currentThread().getName());
			}).forEach((i) -> {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Interrupted! 루프 탈출!");
					return;
				}
			});
		});

		thread.start();
		System.out.println("현재 이 객체의 스레드 : " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("이 녀석의 스레드풀?" + Thread.currentThread().getThreadGroup());
		
	}
}
