package Web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Entity.User;
import Util.StringUtil;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		String method = request.getParameter("_u");
		
		if(StringUtil.isEmpty(method)){
			gologin(request,response);
		} else if("adduser".equals(method)){
			goAddUser(request,response);
		} else if("saveuser".equals(method)){
			goSaveUser(request,response);
		}else if("xiugaimima".equals(method)){
			goXiuGaiMiMa(request,response);
		} else if("editpassword".equals(method)){
			goEditPassword(request,response);
		}
		
	}

	private void goXiuGaiMiMa(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/editpassword.jsp").forward(request, response);
	}

	private void goEditPassword(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String oldpassword = request.getParameter("oldpassword");
		String newpassword1 = request.getParameter("newpassword1");
		String newpassword2 = request.getParameter("newpassword2");
		
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userid = user.getId();
		
		UserDao userDao = new UserDao();
		User user1 = userDao.findById(userid);
		
		String userpassword = user1.getPassword();
		
		if(StringUtil.isEmpty(newpassword1)||StringUtil.isEmpty(newpassword2)){
			request.getRequestDispatcher("/WEB-INF/views/editpassword.jsp?code=1004").forward(request, response);
			return;
		} else if(!newpassword1.equals(newpassword2)){
			request.getRequestDispatcher("/WEB-INF/views/editpassword.jsp?code=1005").forward(request, response);
			return;
		} else if(oldpassword.equals(userpassword)){
			userDao.updateUser(newpassword1, userid);
			response.sendRedirect("main.jspx");
		}
		
	}

	private void goSaveUser(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String editnum = request.getParameter("editnum");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String pic = "1";
		
		if(StringUtil.isEmpty(password1)||StringUtil.isEmpty(password2)){
			request.getRequestDispatcher("/WEB-INF/views/adduser.jsp?code=1002").forward(request, response);
			return;
		} else if(!password1.equals(password2)){
			request.getRequestDispatcher("/WEB-INF/views/adduser.jsp?code=1003").forward(request, response);
			return;
		} else{
			User user = new User();
			user.setId(editnum);
			user.setUsername(username);
			user.setPassword(password1);
			user.setPic(pic);
			
			UserDao userDao = new UserDao();
			userDao.saveUser(user);
			response.sendRedirect("index.jspx");
		}
		
	}

	private void goAddUser(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/adduser.jsp").forward(request, response);
	}

	private void gologin(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);		
	}
	

}
