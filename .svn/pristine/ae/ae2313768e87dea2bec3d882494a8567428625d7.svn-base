package Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Util.StringUtil;


import Dao.UserDao;
import Entity.User;

public class LoginServlet extends HttpServlet {

	/**
	 * 默认序列化ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 根据用户名和密码，进行登陆验证
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("_l");
		
		if(StringUtil.isEmpty(method)){
			goLogin(request,response);
		}else if("loginvalidate".equals(method)){
			goLoginValidate(request,response);
		} else{
			response.sendError(404, "请求了一个不存在的页面");
		}
		
		
		
	}

	private void goLoginValidate(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String userid = request.getParameter("editnum");
		UserDao userDao = new UserDao();
		User user = userDao.findById(userid);
		
		PrintWriter out = response.getWriter();
		if(user != null){
			if(user.getId().equals(userid)){
				out.print("1");
			} 
		}else{
			out.print("0");
		}
		out.flush();
		out.close();
	}

	private void goLogin(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		UserDao userDao = new UserDao();
		User user = userDao.findByName(username);
		//先通过用户名查询，若用户名不存在，直接返回
		if(user == null){
			request.getRequestDispatcher("/WEB-INF/views/index.jsp?code=1001").forward(request, response);
			return;
		} else{
			if(user.getPassword().equals(password)){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("main.jspx?_p=1");
			}
		}
		
	}

}
