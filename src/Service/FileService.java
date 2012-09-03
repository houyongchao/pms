package Service;

import java.util.List;

import Util.PKUtil;
import Dao.FileDao;
import Entity.FileEntity;

public class FileService {

	FileDao dao = new FileDao();
	
	public void tosave(String fileSize,String name,String fileTypeid,String filename){
		FileEntity fileEntity = new FileEntity();
		
		if (Integer.parseInt(fileSize)>0 ||Integer.parseInt(fileSize)< 1024 ) {
			//如何把这个fileSize值给转化成int后进行运算了呢
		}
		fileEntity.setId(PKUtil.getPk());
		fileEntity.setFileName(filename);
		fileEntity.setFileSize(Long.parseLong(fileSize));
		fileEntity.setName(name);
		fileEntity.setFileTypeid(fileTypeid);
		
		FileDao fileDao = new FileDao();
		fileDao.save(fileEntity);
		
	}
	
	public void todel(String id){
		
		
		FileDao fileDao = new FileDao();
		fileDao.del(id);
	}
	
	public List<FileEntity> tolist(String fileTypeId){
		return dao.findByFileTypeId(fileTypeId);
	}
}
