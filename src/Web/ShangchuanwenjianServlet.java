package Web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Util.PKUtil;
import Util.SumUtil;

import Dao.FileDao;
import Entity.FileEntity;



public class ShangchuanwenjianServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String method = request.getParameter("_m");
		
		if("sc".equals(method)) {
			fileUpload(request,response);
		}else if("download".equals(method)){
			download(request,response);
		}
		
		
	}

	

	private void download(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		final String path=getServletContext().getRealPath("/");
		//杈撳嚭鍒癊:\apache-tomcat-7.0.11\webapps\pms\
		
		String name = request.getParameter("name");	
		
	
			
		
	
			
			File file = new File(path + "/"+name);
			
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				
				byte[] buffer = new byte[1024];
				
				response.setContentType("application/octet-stream");
				
				String fileName =name;//鍐冲畾涓嬭浇鏂囦欢鐨勫悕绉板強绫诲瀷锛屼笌鍘熸枃浠剁被鍨嬫棤鍏筹紝杩欑被鍨嬪悗缂�畾涔変负鍟ョ被鍨嬪氨鏄暐
				//filename="1.rar"
				String encodedfileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
				
				OutputStream os = response.getOutputStream(); //鑾峰彇鍝嶅簲杈撳嚭娴�
				
				int len = -1;
				while((len = bis.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				
				os.flush();
				os.close();
				bis.close();
				
			
		
	}



	@SuppressWarnings("unchecked")
	private void fileUpload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String filetypeid = request.getParameter("filetypeid");
		
		
		//涓轰簡鍦ㄩ〉闈腑鑳芥樉绀烘垜浠笂浼犵殑涓滆タ锛屾墍浠ラ鍏堟垜浠鑾峰緱涓婁紶鐨勬枃浠跺湪tomcat涓殑璺緞
		String path=getServletContext().getRealPath("/");
		//鏂囦欢鐨勪笂浼犺矾寰�
		File file=new File(path+"/");
		
		//涓存椂鏂囦欢璺緞
		File tempFile = new File("C:/tem");
		
		if(!file.exists()) {
			file.mkdir();
		}
		
		if(!tempFile.exists()) {
			tempFile.mkdir();
		}
		
		if(ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); 
			//璁剧疆缂撳啿鍖哄ぇ灏�
			factory.setSizeThreshold(1024*10); 
			//璁剧疆涓存椂鏂囦欢澶�
			factory.setRepository(tempFile); 
			
			ServletFileUpload fileUpload = new ServletFileUpload(factory); 
			fileUpload.setSizeMax(1024 * 1024*10);
			
			try {
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(FileItem item : fileItems) {
					if(item.isFormField()) {
						
					
					} else {
						
	
						String fileName=item.getName();
						request.setAttribute("fileName", fileName);
						//杩欎釜瀵瑰簲涓庢暟鎹簱涓殑fileName;
						String str=fileName.substring(fileName.lastIndexOf("."));
						String name=PKUtil.getPk();
						//杩欎釜瀵瑰簲涓庢暟鎹簱涓殑name;
					
						long size=item.getSize();
						
						HttpSession session = request.getSession();
						session.setAttribute("houzui", str);
						
						SumUtil sum = new SumUtil();
						float size2 = sum.sum(size);
						//鍦ㄨ繖閲岄潰杈撳嚭鐨勪负xxkb鎴杧xM
						
						FileEntity ffile=new FileEntity();
						ffile.setFileName(fileName);
						ffile.setFileSize((long)size2);
						ffile.setId(PKUtil.getPk());
						ffile.setName(name);
						ffile.setFileTypeid(filetypeid);
						if (size2 > 0 || size2 < 1024) {
							String strss = "kB";
							session.setAttribute("strss", strss);
						} else if(size2 > 1024 || size < 2048){
							String strss = "m";
							session.setAttribute("strss", strss);
						}
						FileDao dao = new FileDao();
						//FflieService fflieService=new FflieService();
						//fflieService.save(ffile);
						dao.save(ffile);
						item.write(new File(file,fileName));
					}
				}
	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		} else {
			System.out.println("鏈缃甧nctype灞炴�");
		}

		
		response.sendRedirect("file.jspx?filetypeid=" + filetypeid);
		

}
		
	
}
