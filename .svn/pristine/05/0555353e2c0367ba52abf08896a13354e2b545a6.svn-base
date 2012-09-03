package Web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.FileTypeDao;
import Entity.FileEntity;
import Entity.Filetype;
import Entity.User;
import Service.FileService;
import Service.FileTypeService;
import Util.Pager;
import Util.StringUtil;
import Util.ZSum;

public class FileTypeServlet extends HttpServlet {

	

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String method =  request.getParameter("_m");
			
			if (StringUtil.isEmpty(method)) {
				list(request,response);
			} else if("new".equals(method)){
				newFileType(request,response);
			} else if("save".equals(method)){
				save(request,response);
			}
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String filetypename = request.getParameter("filetypename");
		HttpSession session = request.getSession();
		String projectid = (String) session.getAttribute("projectid");
		String userid = request.getParameter("userid");
		
		if (filetypename == null) {
			request.getRequestDispatcher("/WEB-INF/views/file.jsp").forward(request, response);
			return;
		} else {
		
		
		new FileTypeService().tosave(filetypename, projectid, userid);
        response.sendRedirect("fileType.jspx");
		}
	}

	private void newFileType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/new_filetype.jsp").forward(request, response);
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String  projectid = (String) session.getAttribute("projectid");
		
	
		 
	/*	 String pageNum = request.getParameter("p");
			int num  = 1;
			
			if(StringUtil.isNotEmpty(pageNum)) {
				try {
					num = Integer.parseInt(pageNum);
				} catch (NumberFormatException e) {
					response.sendRedirect("fileType.jspx");
					return;
				}
			}
		
			 FileTypeDao dao = new FileTypeDao();
			 Pager<Filetype> pager = dao.findPage(projectid, num);
			 
			session.setAttribute("pager", pager); 
			List<Filetype> filetypeList = pager.getResult();*/
		
		
		
		List<Filetype> filetypeList = new FileTypeService().tolist(projectid);
		
		for (Filetype f : filetypeList) {
			long size = 0l;
			
			String fileTypeid = f.getId();
			
			List<FileEntity> ffileList = new FileService().tolist(fileTypeid);
			
			for(FileEntity ffile:ffileList){
			
					size=size+ffile.getFileSize();
				
				
			}
			
			ZSum zs=new ZSum();
			String fileTypeSize=zs.math(size);
		
			f.setfSize(fileTypeSize);
		
			
		}
		
		FileTypeDao dao = new FileTypeDao();
		List<User> userList = dao.findtoByProjectid(projectid);
		request.setAttribute("userList", userList);
		
		session.setAttribute("filetypeList", filetypeList);
		request.getRequestDispatcher("/WEB-INF/views/file.jsp").forward(request, response);
	}
}
