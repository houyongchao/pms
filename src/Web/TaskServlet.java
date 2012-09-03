package Web;


import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.GoalDao;
import Dao.TaskDao;
import Entity.Goal;
import Entity.Pager;
import Entity.Task;
import Entity.User;
import Service.GoalService;
import Service.TaskService;
import Service.UserService;
import Util.StringUtil;

public class TaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String method = request.getParameter("_m");
		if (StringUtil.isEmpty(method)) {
			list(request,response);
		} else if ("new".equals(method)) {
			addTask(request,response);
		} else if("save".equals(method)){
			save(request,response);
		} else if("edit".equals(method)){
			edit(request,response);
		} else if("xiugai".equals(method)){
			xiugai(request,response);
		} else if("seeAlltask".equals(method)){
			seeAlltask(request,response);
		} else if("xiugaijindu".equals(method)){
			gaijindu(request,response);
		} else if("renwulist".equals(method)){
			renwulist(request,response);
		} else {
			response.sendError(404, "");
		}
	}


	private void renwulist(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		
	}


	private void gaijindu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String jindu1 = request.getParameter("jindu");
		String taskid = request.getParameter("taskid");
		String goalid = request.getParameter("goalid");
		TaskDao taskDao = new TaskDao();
		
		float j1 = Float.parseFloat(jindu1);
		
		taskDao.updateJinDu(j1, taskid);
		List<Task> taskList = taskDao.findByGoalId(goalid);
		
		float size = 0f;
		int count= 0;
		for (Task g : taskList) {
			if (g.getDangqianjingdu() != null) {
				
				try {
					size = size + Float.parseFloat(g.getDangqianjingdu());
					count++;
				} catch (NumberFormatException e) {
					response.sendError(500, "数字格式化异常");
					return;
				}
			}
		}	
		if (count != 0) {
			
			try {
				float goaljindu = size/count;
				GoalDao goaldao = new GoalDao();
				
				goaldao.updateGoal(goaljindu,goalid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("task.jspx?goalid=" + goalid);
	}


	private void seeAlltask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TaskService taskservice = new TaskService();
		List<Task> taskList = taskservice.findAlltask();
		UserService userservice = new UserService();
		List<User> userList = userservice.findAllUser();
		
		request.setAttribute("taskList", taskList);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/WEB-INF/views/seeAlltask.jsp").forward(request, response);
	}
	private void xiugai(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String miaoshu = request.getParameter("miaoshu");

		String goalid = request.getParameter("goalid");
		
	
		new TaskService().toXiugai(id, name, miaoshu, goalid);
		response.sendRedirect("task.jspx?goalid=" + goalid);

		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		Task task = null;
		try {
			task = new TaskService().toEdit(id);
		} catch(NumberFormatException e) {
			response.sendRedirect("task.jspx");
			return;
		}
		
		if(task != null) {
			request.setAttribute("task", task);
			request.getRequestDispatcher("/WEB-INF/views/edit_task.jsp").forward(request, response);
		} else {
			response.sendRedirect("task.jspx");
		}
		
	}

	private void save(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		 String name = request.getParameter("renwuname");
         String renwuMiaoShu = request.getParameter("renwumiaoshu");
         String zhuangTai = request.getParameter("zhuangtai");
         String fuzeren = request.getParameter("fuzeren");
         String renwuJiBie = request.getParameter("renwujibie");
         String starttime = request.getParameter("starttime");
         String endtime = request.getParameter("endtime");
         String dangqianjingdu = "0";
         
         String userid = request.getParameter("userid");
         String goalid = request.getParameter("goalid");

          new TaskService().tosave(name, renwuMiaoShu, zhuangTai, fuzeren, renwuJiBie, starttime, endtime, dangqianjingdu, userid, goalid);
        
        response.sendRedirect("task.jspx?goalid=" + goalid);
	}

	private void addTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String goalid = request.getParameter("goalid");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userid = user.getId();
		
		request.setAttribute("goalid",goalid);
		request.setAttribute("userid", userid);
		request.getRequestDispatcher("/WEB-INF/views/new_task.jsp").forward(request, response);
    
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String goalId = request.getParameter("goalid");
		
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
		Goal goal = new GoalService().toedit(goalId);
		
		Pager<Task> taskList = new TaskService().tolist(goalId,num);
		
		request.setAttribute("goal", goal);
		request.setAttribute("taskList",taskList);
			
		TaskDao taskDao = new TaskDao();
		List<User> userList = taskDao.findBygoalid(goalId);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/WEB-INF/views/task.jsp").forward(request, response);

	}
}
