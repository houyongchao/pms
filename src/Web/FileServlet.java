package Web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import Dao.FileDao;
import Entity.FileEntity;
import Entity.Filetype;
import Entity.User;
import Service.FileService;
import Service.FileTypeService;
import Util.Pager;
import Util.StringUtil;

public class FileServlet extends HttpServlet {

	

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("_m");
		if (StringUtil.isEmpty(method)) {
			list(request,response);
		} else if("del".equals(method)){
			del(request,response);
		} else if("shangchuan".equals(method)){
			shangchuan(request,response);
		} else if("upload".equals(method)){
			//fileUpload(request,response);
		} else if("save".equals(method)){
			save(request,response);
		}
		
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String fileSize = request.getParameter("fileSize");
		String name = request.getParameter("name");
		String fileTypeid = request.getParameter("fileTypeid");
		String filename = request.getParameter("filename");
		
		
	
		new FileService().tosave(fileSize, name, fileTypeid, filename);
		response.sendRedirect("file.jspx");
		
	}



	private void shangchuan(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/shangchuanziliao.jsp").forward(request, response);
		
	}

	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String id = request.getParameter("id");
	
		new FileService().todel(id);
		response.sendRedirect("file.jspx");
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fileTypeId = request.getParameter("filetypeid");
		
		
		String pageNum = request.getParameter("p");
		
	
	
		
		
		int num  = 1;
		
		if(StringUtil.isNotEmpty(pageNum)) {
			try {
				num = Integer.parseInt(pageNum);
			} catch (NumberFormatException e) {
				response.sendRedirect("file.jspx");
				return;
			}
		}
	
		FileDao dao = new FileDao();
		 Pager<FileEntity> pager = dao.findPage(fileTypeId, num);
		
		
		

		HttpSession session = request.getSession();
		request.setAttribute("pager", pager); 
		
		
		
		Filetype filetype = new FileTypeService().findid(fileTypeId);
		if (filetype == null) {
			response.sendRedirect("fileType.jspx");
            return;
		} else {
	
			
			//List<FileEntity> fileList =  new FileService().tolist(fileTypeId);
			
			//HttpSession session = request.getSession();
			session.setAttribute("filetype", filetype);
			//session.setAttribute("file2",fileList);
			//FileDao dao = new FileDao();
			
			List<User> userList = dao.findBytoFileTypeId(fileTypeId);
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/WEB-INF/views/kehuziliao.jsp").forward(request, response);
			
		}
	}
	
}
