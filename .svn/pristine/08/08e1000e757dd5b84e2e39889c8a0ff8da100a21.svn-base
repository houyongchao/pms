package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter extends AbstractFilter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(uri);
		
		
		if ("".equals(uri) || "index.jsp".equals(uri) || uri.endsWith("jspx") || uri.endsWith("js")|| uri.endsWith("png")
				|| uri.endsWith("gif") || uri.endsWith("ico") || uri.endsWith("css")) {
			
			chain.doFilter(request, response);
		} else {
			System.out.println("URI:" + uri + "访问被拒绝！");
			response.sendRedirect("index.jspx");
			
		}
	}

}
