package Web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Util.DateUtil;

import Dao.ProjectDao;
import Dao.Project_has_userDao;
import Dao.UserDao;
import Entity.Pager;
import Entity.Project;
import Entity.Project_has_user;
import Entity.User;

public class MainServlet extends HttpServlet {

	/**
	 * Ĭ�����л�ID
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("_m");
		
		if(method == null||"".equals(method)){
			goMain(request,response);
		} else if("new_project".equals(method)){
			if(request.getMethod().equalsIgnoreCase("POST")){
				goSaveProject(request,response);
			} else{
				gonewProject(request,response);
			}
		} else{
			response.sendError(404, "������һ�������ڵ�ҳ��");
		}
		
		
	}


	private void goSaveProject(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String projectNum = request.getParameter("projectNum");
		String projectName = request.getParameter("projectName");
		String projectDsc = request.getParameter("projectDsc");
		String fuZeRen = request.getParameter("fuZeRen");
		String projectMember = request.getParameter("projectMember");
		String createTime = DateUtil.getTime();
		
		
		
		ProjectDao prodao = new ProjectDao();
		prodao.save(projectNum, projectName, projectDsc, createTime, fuZeRen, projectMember);
		
		String role = "��Ա";
		UserDao userDao = new UserDao();
		Project_has_userDao dao = new Project_has_userDao();
		String[] array = projectMember.split(",");
		
		if(array.length != 0){
			
			for(String name:array){
				User user = userDao.findByName(name);
				String userid = user.getId();
				
				Project_has_user pe=new Project_has_user();
				
				pe.setProjectid(projectNum);
				pe.setRole(role);
				pe.setUserid(userid);
				dao.save(userid, projectNum, role);
			}
		}

		response.sendRedirect("main.jspx");
	}
	
	private void gonewProject(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/new_project.jsp").forward(request, response);
	}


	private void goMain(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		String pageNum = request.getParameter("_p");
		int num = 1;
		if(Util.StringUtil.isNotEmpty(pageNum)){
			try{
				num = Integer.parseInt(pageNum);
			}catch(NumberFormatException e){
				response.sendRedirect("prod.jspx");
				return;
			}
		}
		
		
		User user = (User)session.getAttribute("user");
		ProjectDao prodao = new ProjectDao();
		Pager<Project> proList = prodao.findAllProject(user.getId(),num);
		
		session.setAttribute("proList", proList);
		request.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(request, response);
	}
}
