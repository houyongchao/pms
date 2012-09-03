package Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Goal;
import Entity.Pager;
import Service.GoalService;
import Util.StringUtil;

public class GoalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("_m");
		
		if (StringUtil.isEmpty(method)) {
			list(request,response);
		} else if("new".equals(method)){
			addGoal(request,response);
		} else if ("save".equals(method)){
			save(request,response);
		} else if("edit".equals(method)){
			edit(request,response);
		} else if("xiugai".equals(method)){
			xiugai(request,response);
		} else {
			response.sendError(404, "请求了一个不存在的页面");
		}
			
	}
	
	
	/**
	 * 淇濆瓨淇敼鍚庣殑鐩爣
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void xiugai(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String miaoshu = request.getParameter("content");

		new GoalService().toxiugai(id, name, miaoshu);
		response.sendRedirect("goal.jspx");
	}

	/**
	 * 缂栬緫鐩爣
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		Goal goal = new GoalService().toedit(id);
		
		if(goal != null) {
			request.setAttribute("goal", goal);
			request.getRequestDispatcher("/WEB-INF/views/edit_goal.jsp").forward(request, response);
		} else {
			response.sendRedirect("goal.jspx");
		}
	}

	/**
	 * 娣诲姞鏂扮洰鏍�
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {

		HttpSession session = request.getSession();
		String projectid = (String) session.getAttribute("projectid"); 
		 
		String userid =  request.getParameter("userid");
        String name = request.getParameter("name");
        String miaoshu = request.getParameter("miaoshu");
     
        new GoalService().baocun(projectid, userid, name, miaoshu);
        
        response.sendRedirect("goal.jspx");
	}

	
	private void addGoal(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/new_goal.jsp").forward(request, response);
	}

	/**
	 * 用项目ID获得对应的目标集合；
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		
		Pager<Goal> goalList = new GoalService().mubiao(projectid,num);
		
		 session.setAttribute("goalList", goalList);
		 request.getRequestDispatcher("/WEB-INF/views/goal.jsp").forward(request, response);
	}
}
