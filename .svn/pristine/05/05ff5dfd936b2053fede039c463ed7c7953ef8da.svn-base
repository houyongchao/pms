package Web;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import Dao.ContactDao;
import Entity.Contact;
import Entity.Contactnote;
import Entity.User;
import Service.ContactService;
import Service.UserService;
import Util.DateUtil;
import Util.PKUtil;
import Util.StringUtil;

public class ContactServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("_c");
		
		if(request.getMethod().equalsIgnoreCase("post")){
			if("savecontact".equals(method)){
				goNewContact(request,response);
			}else if("savejilu".equals(method)){
				goSavejiLu(request,response);
			}
		}else if("chaxuninfo".equals(method)){
			goChaxuninfo(request,response);
		} else if("new_contact".equals(method)){
			goAddContact(request,response);
		} else if("xiugai_contact".equals(method)){
			goXiuGaiContact(request,response);
		} else if("delete_contact".equals(method)){
			goDeleteContact(request,response);
		} else if("xiugai".equals(method)){
			goXiuGai(request,response);
		} else if("chakanjilu".equals(method)){
			goChakanjilu(request,response);
		} else if(StringUtil.isEmpty(method)){
			goContact(request,response);
		} else{
			response.sendError(404, "请求了一个不存在的页面");
		}
	}

	private void goSavejiLu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String neiRong = request.getParameter("neiRong");
		String contactid = request.getParameter("contactid");
		String id = PKUtil.getPk();
		String createtime = DateUtil.getTime();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String userid = user.getId();
		
		Contactnote note = new Contactnote();
		note.setContactid(contactid);
		note.setCreatetime(createtime);
		note.setId(id);
		note.setNeiRong(neiRong);
		note.setUserid(userid);
		
		ContactService service = new ContactService();
		service.saveNote(note);
		ContactDao contactDao = new ContactDao();
		Contact contact = contactDao.findByContactid(contactid);
		List<Contactnote> noteList = service.findAllNote();
		
		UserService userservice = new UserService();
		List<User> userList = userservice.findAllUser();
		request.setAttribute("userList", userList);
		request.setAttribute("noteList", noteList);
		request.setAttribute("note", note);
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/WEB-INF/views/show_jilu.jsp").forward(request, response);
	}

	private void goChaxuninfo(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String contactid = request.getParameter("contactid");
		ContactDao contactDao = new ContactDao();
		Contact contact = contactDao.findByContactid(contactid);
		
		response.setContentType("application/json;charset=UTF-8");
		Gson gson = new Gson();
		String json = gson.toJson(contact);
		
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
		
	}

	private void goChakanjilu(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String contactid = request.getParameter("contactid");
		
		ContactDao contactDao = new ContactDao();
		Contact contact = contactDao.findByContactid(contactid);
		Contactnote note = new Contactnote();
		ContactService service = new ContactService();
		List<Contactnote> noteList = service.findAllNote();
		
		UserService userservice = new UserService();
		List<User> userList = userservice.findAllUser();
		request.setAttribute("userList", userList);
		request.setAttribute("noteList", noteList);
		request.setAttribute("note", note);
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/WEB-INF/views/show_jilu.jsp").forward(request, response);
	}

	private void goXiuGai(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = request.getParameter("contactid");
		String name = request.getParameter("name");
		String company = request.getParameter("company");
		String tele = request.getParameter("tele");
		String homeTelt = request.getParameter("homeTelt");
		String email = request.getParameter("email");
		String zhuye = request.getParameter("zhuye");
		String weibo = request.getParameter("weibo");
		String addr = request.getParameter("addr");
		String weibohouzhui = request.getParameter("weibohouzhui");
		String jianjie = request.getParameter("jianjie");
		String projectid = (String) session.getAttribute("projectid");
		
		
		Contact contact = new Contact();
		contact.setId(id);
		contact.setName(name);
		contact.setCompany(company);
		contact.setTele(tele);
		contact.setHomeTelt(homeTelt);
		contact.setEmail(email);
		contact.setZhuye(zhuye);
		contact.setWeibo(weibo);
		contact.setAddress(addr);
		contact.setWeibohouzhui(weibohouzhui);
		contact.setJianjie(jianjie);
		contact.setProjectid(projectid);
		File file = new File("D:\\workspaces\\PMS\\WebRoot\\img\\"+id+".png");
		if(file.exists()){
			file.delete();
		}
		
		encode(contact);
		ContactDao contactDao = new ContactDao();
		contactDao.updateContact(contact);
		request.getRequestDispatcher("/WEB-INF/views/contact.jsp").forward(request, response);
	}

	private void goDeleteContact(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String contactid = request.getParameter("contactid");
		ContactDao contactDao = new ContactDao();
		contactDao.deleteContact(contactid);
		File file = new File("D:\\workspaces\\PMS\\WebRoot\\img\\"+contactid+".png");
		if(file.exists()){
			file.delete();
		}
		
		goContact(request, response);
	}

	private void goXiuGaiContact(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String contactid = request.getParameter("contactid");
		ContactDao contactDao = new ContactDao();
		Contact contact = contactDao.findByContactid(contactid);
		
		request.setAttribute("contact", contact);
		request.getRequestDispatcher("/WEB-INF/views/xiugai_contact.jsp").forward(request, response);
		
	}

	private void goAddContact(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/views/new_contact.jsp").forward(request, response);
	}

	private void goNewContact(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String company = request.getParameter("company");
		String tele = request.getParameter("tele");
		String homeTelt = request.getParameter("homeTelt");
		String email = request.getParameter("email");
		String zhuye = request.getParameter("zhuye");
		String weibo = request.getParameter("weibo");
		String addr = request.getParameter("addr");
		String weibohouzhui = request.getParameter("weibohouzhui");
		String jianjie = request.getParameter("jianjie");
		String projectid = (String) session.getAttribute("projectid");
		
		
		Contact contact = new Contact();
		contact.setId(PKUtil.getPk());
		contact.setName(name);
		contact.setCompany(company);
		contact.setTele(tele);
		contact.setHomeTelt(homeTelt);
		contact.setEmail(email);
		contact.setZhuye(zhuye);
		contact.setWeibo(weibo);
		contact.setAddress(addr);
		contact.setWeibohouzhui(weibohouzhui);
		contact.setJianjie(jianjie);
		contact.setProjectid(projectid);
		
		encode(contact);//生成二维码
		ContactDao contactDao = new ContactDao();
		contactDao.saveContact(contact);
		
		response.sendRedirect("contact.jspx");
		
		
	}

	private void goContact(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		String projectid = (String) session.getAttribute("projectid");
		ContactDao contactDao = new ContactDao();
		List<Contact> contactList = contactDao.findAllContact(projectid);
		
		request.setAttribute("contactList", contactList);
		request.getRequestDispatcher("/WEB-INF/views/contact.jsp").forward(request, response);
	}
	private void encode(Contact con){
		try{
			StringBuffer buf = new StringBuffer();
			String str = "姓名："+buf.append(con.getName())+"\n"+"公司："+buf.append(con.getCompany()+"\n"+"手机："+buf.append(con.getTele()+"\n"+"固话："+buf.append(con.getHomeTelt())+"\n"+
					"邮箱："+buf.append(con.getEmail())+"\n"+"地址："+buf.append(con.getAddress())+"\n"+"主页："+buf.append(con.getZhuye())+"\n"+buf.append(con.getWeibo())+"@"+buf.append(con.getWeibohouzhui()+"\n"+
							"简介："+buf.append(con.getJianjie()))));
			String path = "D:\\workspaces\\PMS\\WebRoot\\img\\"+con.getId()+".png";  
	         BitMatrix byteMatrix;  
	         byteMatrix = new MultiFormatWriter().encode(new String(str.getBytes("GBK"),"iso-8859-1"),  
	                 BarcodeFormat.QR_CODE, 135, 135);  
	         File file = new File(path);  
	           
	         MatrixToImageWriter.writeToFile(byteMatrix, "png", file);  
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
