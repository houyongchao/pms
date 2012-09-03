package Web;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import Dao.DocumentDao;
import Entity.Document;
import Entity.Pager;
import Entity.User;
import Util.DateUtil;
import Util.PKUtil;
import Util.StringUtil;

public class DocumentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("_d");
		
		if(StringUtil.isEmpty(method)){
			goDocument(request,response);
		} else if("new_document".equals(method)){
			goNewDocument(request,response);
		} else if("save_document".equals(method)){
			goSaveDocument(request,response);
		} else if("show_document".equals(method)){
			goShowDocument(request,response);
		}
		
		
		
	}

	private void goShowDocument(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String documentid = request.getParameter("documentid");
		DocumentDao docdao = new DocumentDao();
		Document document = docdao.findByDocumentId(documentid);
		
		
		request.setAttribute("document", document);
		request.getRequestDispatcher("/WEB-INF/views/document_show.jsp").forward(request, response);
	}

	private void goSaveDocument(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String biaoTi = request.getParameter("biaoTi");
		String neiRong = request.getParameter("content");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String projectid = (String) session.getAttribute("projectid");
		Document doc = new Document();
		
		doc.setId(PKUtil.getPk());
		doc.setCreatetime(DateUtil.getTime());
		doc.setNeiRong(neiRong);
		doc.setProjectid(projectid);
		doc.setTitle(biaoTi);
		doc.setUserid(user.getId());
		
		DocumentDao docdao = new DocumentDao();
		docdao.saveDocument(doc);
		

		response.sendRedirect("document.jspx");

		

	}

	private void goNewDocument(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/new_document.jsp").forward(request, response);
	}

	private void goDocument(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
	
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
		
		
		HttpSession session = request.getSession();
		String projectid = (String) session.getAttribute("projectid");
		DocumentDao docdao = new DocumentDao();
		Pager<Document> documentList = docdao.findByProjectid(projectid,num);
		
		List<User> userList = docdao.findByDocumentid(projectid);
		
		session.setAttribute("userList", userList);
		request.setAttribute("documentList", documentList);
		request.getRequestDispatcher("/WEB-INF/views/document.jsp").forward(request, response);

		
	}
	
}
