package Web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.MessageDao;
import Dao.TaskDao;
import Entity.Message;
import Entity.Pager;
import Entity.Task;
import Entity.User;
import Util.DateUtil;
import Util.PKUtil;

public class ProjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("_p");
		
		if(method == null||"".equals(method)){
			goProjectlast(request,response);
		} else if("first".equals(method)){
			goProject(request,response);
		} else if("fenxiang".equals(method)){
			goSaveIdea(request,response);
		} else if("project".equals(method)){
			goFabuProject(request,response);
		}
	}

	private void goFabuProject(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		String projectid = (String)session.getAttribute("projectid");
		
		String pageNum = request.getParameter("page");
		int num = 1;
		if(Util.StringUtil.isNotEmpty(pageNum)){
			try{
				num = Integer.parseInt(pageNum);
			}catch(NumberFormatException e){
				response.sendRedirect("main.jspx");
				return;
			}
		}
		
		
		MessageDao messDao = new MessageDao();
		Pager<Message> messageList = messDao.findAllProjectid(projectid, num);
		List<User> userList = messDao.findUserByProjectid(projectid);
		
		User user = (User) session.getAttribute("user");
		TaskDao taskDao = new TaskDao();
		List<Task> taskList = taskDao.findByUserid(user.getId());
		
		request.setAttribute("taskList", taskList);
		request.setAttribute("userList", userList);
		request.setAttribute("messageList", messageList);
		request.getRequestDispatcher("/WEB-INF/views/project.jsp").forward(request, response);
		
	}

	private void goSaveIdea(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String neiRong = request.getParameter("content");
		String createTime = DateUtil.getTime();
		HttpSession session = request.getSession();
		String projectid = (String)session.getAttribute("projectid");
		User user = (User)session.getAttribute("user");
		String userid = user.getId();
		String id = PKUtil.getPk();
		
		MessageDao messDao = new MessageDao();
		messDao.saveFenXiang(id, createTime, neiRong, userid, projectid);
		
		
		response.sendRedirect("project.jspx?_p=project");
	}

	private void goProject(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String projectid = request.getParameter("projectid");
		      
		HttpSession session = request.getSession();
		session.setAttribute("projectid", projectid);
		
		String pageNum = request.getParameter("page");
		int num = 1;
		if(Util.StringUtil.isNotEmpty(pageNum)){
			try{
				num = Integer.parseInt(pageNum);
			}catch(NumberFormatException e){
				response.sendRedirect("main.jspx");
				return;
			}
		}
		
		MessageDao messDao = new MessageDao();
		
		Pager<Message> messageList = messDao.findAllProjectid(projectid, num);
		List<User> userList = messDao.findUserByProjectid(projectid);
		
		User user = (User) session.getAttribute("user");
		TaskDao taskDao = new TaskDao();
		List<Task> taskList = taskDao.findByUserid(user.getId());
		
		request.setAttribute("taskList", taskList);
		request.setAttribute("userList", userList);
		request.setAttribute("messageList", messageList);
		request.getRequestDispatcher("/WEB-INF/views/project.jsp").forward(request, response);
	}
	private void goProjectlast(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String projectid = (String) session.getAttribute("projectid");
		
		String pageNum = request.getParameter("page");
		int num = 1;
		if(Util.StringUtil.isNotEmpty(pageNum)){
			try{
				num = Integer.parseInt(pageNum);
			}catch(NumberFormatException e){
				response.sendRedirect("main.jspx");
				return;
			}
		}
		
		MessageDao messDao = new MessageDao();
		Pager<Message> messageList = messDao.findAllProjectid(projectid, num);
		List<User> userList = messDao.findUserByProjectid(projectid);
		
		User user = (User) session.getAttribute("user");
		TaskDao taskDao = new TaskDao();
		List<Task> taskList = taskDao.findByUserid(user.getId());
		
		request.setAttribute("taskList", taskList);
		request.setAttribute("userList", userList);
		request.setAttribute("messageList", messageList);
		request.getRequestDispatcher("/WEB-INF/views/project.jsp").forward(request, response);
	}
	

	
}
