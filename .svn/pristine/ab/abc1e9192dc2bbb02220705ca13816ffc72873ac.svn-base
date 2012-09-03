package Web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.IdeaDao;
import Entity.Idea;
import Entity.User;
import Util.DateUtil;
import Util.PKUtil;
import Util.StringUtil;

public class IdeaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("_i");
		
		if(StringUtil.isEmpty(method)){
			goIdea(request,response);
		} else if("new_idea".equals(method)){
			goNewIdea(request,response);
		} else if("save_new_idea".equals(method)){
			goSaveNewIdea(request,response);
		} else if("save_edit_idea".equals(method)){
			goSaveEditIdea(request,response);
		} else if("show_idea".equals(method)){
			goShowIdea(request,response);
		} else if("edit_idea".equals(method)){
			goEditIdea(request,response);
		} else if("delete_idea".equals(method)){
			goDeleteIdea(request,response);
		}
		
	}

	private void goDeleteIdea(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String ideaid = request.getParameter("ideaid");
		
		IdeaDao ideaDao = new IdeaDao();
		ideaDao.deleteIdea(ideaid);
		
		response.sendRedirect("idea.jspx");
	}

	private void goSaveEditIdea(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String title = request.getParameter("title");
		String neiRong = request.getParameter("neiRong");
		String ideaid = request.getParameter("ideaid");
		
		IdeaDao ideaDao = new IdeaDao();
		ideaDao.saveEdeaIdea(title, neiRong, ideaid);
		response.sendRedirect("idea.jspx");
	}

	private void goEditIdea(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String ideaid = request.getParameter("ideaid");
		
		IdeaDao ideaDao = new IdeaDao();
		Idea idea = ideaDao.findByIdeaId(ideaid);
		request.setAttribute("idea", idea);
		request.getRequestDispatcher("/WEB-INF/views/edit_idea.jsp").forward(request, response);
	}

	private void goShowIdea(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/show_idea.jsp").forward(request, response);
	}

	private void goSaveNewIdea(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		String ideaid = PKUtil.getPk();
		String title = request.getParameter("title");
		String neiRong = request.getParameter("content");
		String createtime = DateUtil.getTime();
		String projectid = (String) session.getAttribute("projectid");
		User user = (User) session.getAttribute("user");
		String userid = user.getId();
		
		Idea idea = new Idea();
		idea.setCreatetime(createtime);
		idea.setId(ideaid);
		idea.setNeiRong(neiRong);
		idea.setProjectid(projectid);
		idea.setTitle(title);
		idea.setUserid(userid);
		
		IdeaDao ideaDao = new IdeaDao();
		ideaDao.saveIdea(idea);
		
		response.sendRedirect("idea.jspx");
	}

	private void goNewIdea(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/new_idea.jsp").forward(request, response);
	}

	private void goIdea(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String projectid = (String) session.getAttribute("projectid");
		
		IdeaDao ideaDao = new IdeaDao();
		List<Idea> ideaList = ideaDao.findByProjectId(projectid);
		List<User> userIdeaList = ideaDao.findByprojectid(projectid);
		
		session.setAttribute("userIdeaList", userIdeaList);
		session.setAttribute("ideaList", ideaList);
		request.getRequestDispatcher("/WEB-INF/views/idea.jsp").forward(request, response);
	}
	
}
