import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Encoding Filter : init");
//		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		
		// 요청과 응답의 필터 조정
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		// 다음 연결된 필터로 요청과 응답을 전달
		chain.doFilter(req, res);
		
		

	}

	@Override
	public void destroy() {
		System.out.println("Encoding Filter : destroy");
//		Filter.super.destroy();
	}

	

}
