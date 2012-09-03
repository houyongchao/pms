package Service;


import java.util.List;

import Util.DateUtil;
import Util.PKUtil;
import Dao.FileTypeDao;
import Entity.Filetype;

public class FileTypeService {

	FileTypeDao dao = new FileTypeDao();
	
	public void tosave(String filetypename,String projectid,String userid){
		
		Filetype filetype = new Filetype();
		filetype.setFileName(filetypename);
		filetype.setId(PKUtil.getPk());
		filetype.setProjectid(projectid);
		filetype.setUserid(userid);
		filetype.setCreatetime(DateUtil.getTime());
		dao.save(filetype);
	
	}
	
	public List<Filetype> tolist(String  projectid){
		
		return dao.findByProjectid(projectid);
	}
	public Filetype findid(String fileTypeId){
			
			return dao.findById(fileTypeId);
		}
}
