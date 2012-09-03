package Dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import Entity.FileEntity;
import Entity.User;
import Util.DBhelp;
import Util.Pager;
import Util.RowMapper;

public class FileDao {

	private DBhelp<FileEntity> db = new DBhelp<FileEntity>();
	private DBhelp<User> userdb = new DBhelp<User>();
	public  List<FileEntity> findByFileTypeId(String fileTypeId) {
		String sql = "select id,fileName,fileTypeid,fileSize,name from t_file where fileTypeid = ?";
		return db.executeQueryForList(sql, new FileRowMapper(), fileTypeId);
	}
	
	public List<User> findBytoFileTypeId(String fileTypeId){
		String sql = "select * from t_user where id in(select userid from t_filetype where id = ?)";
		return userdb.executeQueryForList(sql, new UserDao().new UserRowMapper(), fileTypeId);
		
	}
	
	public class FileRowMapper implements RowMapper<FileEntity> {

		public FileEntity mapperRow(ResultSet rs) throws SQLException {
			FileEntity file = new FileEntity();
			file.setId(rs.getString("id"));
			file.setFileName(rs.getString("fileName"));
			file.setFileTypeid(rs.getString("fileTypeid"));
			file.setName(rs.getString("name"));
			file.setFileSize(rs.getLong("fileSize"));
			
			return file;
		}

	}

	public void del(String id) {

		String sql = "DELETE  FROM t_file WHERE id = ?";
		db.executeSQL(sql, id);
	}

	public void save(FileEntity fileEntity) {

		String sql = "insert into t_file(id,fileName,fileSize,fileTypeid,name) values(?,?,?,?,?)";
		db.executeSQL(sql, fileEntity.getId(),fileEntity.getFileName(),fileEntity.getFileSize(),fileEntity.getFileTypeid(),fileEntity.getName());
	}

	public FileEntity findByName(String name) {
		String sql = "select id,fileName,fileSize,fileTypeid,name from t_file where name = ? ";
		
		return db.executeQueryForObject(sql, new FileRowMapper(), name);
	}
	
	
	


	public Pager<FileEntity> findPage(String fileTypeId, int num) {
		   String sql = "select * from t_file where fileTypeId = ? limit ?,?";
	        Pager<FileEntity> pager = new Pager<FileEntity>(getGoalCount(),num);
	     // List<FileEntity> result = db.executeQueryForList(sql, new GoalRowMapper(), fileTypeId,pager.getStartIndex(),pager.getPageSize());
	      List<FileEntity> result = db.executeQueryForList(sql, new FileRowMapper(), fileTypeId,pager.getStartIndex(),pager.getPageSize());
	        pager.setResult(result);
	        return pager;
	}

	

	public int getGoalCount() {
		String sql = "select count(*) from t_file";
		return db.executeQueryForCount(sql);
	}
	

	
}
