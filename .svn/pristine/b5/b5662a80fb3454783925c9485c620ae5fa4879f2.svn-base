package Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

	/**
	 * 默认的序列化ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 获得欢迎页的请求，并跳转到登陆页
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

}
