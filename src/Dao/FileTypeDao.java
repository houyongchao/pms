package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entity.Filetype;
import Entity.User;
import Util.DBhelp;
import Util.Pager;
import Util.RowMapper;


public class FileTypeDao {

	DBhelp<Filetype> db = new DBhelp<Filetype>();
	DBhelp<User> userdb = new DBhelp<User>();
 	public List<Filetype> findByProjectid(String projectid) {
		String sql = "select id,createtime,projectid,userid,fileName from t_filetype where projectid = ?";
		return db.executeQueryForList(sql, new FiletypeRowMapper(), projectid);
		
	}
	
	
	public List<User> findtoByProjectid(String projectid){
		
		String sql = "select * from t_user where id in(select userid from t_filetype where projectid=?)";
		return userdb.executeQueryForList(sql, new UserDao().new UserRowMapper(), projectid);
	}

	public class FiletypeRowMapper implements RowMapper<Filetype> {

		public Filetype mapperRow(ResultSet rs) throws SQLException {
			
			Filetype filetype = new Filetype();
			filetype.setId(rs.getString("id"));
			filetype.setFileName(rs.getString("fileName"));
			filetype.setCreatetime(rs.getString("createtime"));
			filetype.setProjectid(rs.getString("projectid"));
			filetype.setUserid(rs.getString("userid"));
			
			return filetype;
		}

	}

	public void save(Filetype filetype) {
		String sql = "insert into t_filetype(id,fileName,createtime,projectid,userid ) values(?,?,?,?,?)";
		db.executeSQL(sql, filetype.getId(),filetype.getFileName(),filetype.getCreatetime(),filetype.getProjectid(),filetype.getUserid());
	}

	public Filetype findById(String fileTypeId) {
		String sql = "select id,fileName,createtime,projectid,userid from t_filetype where id = ?";
		return db.executeQueryForObject(sql, new FiletypeRowMapper(), fileTypeId);
	}


	public Pager<Filetype> findPage(String projectid, int num) {
		 String sql = "select * from t_filetype where projectid = ? limit ?,?";
	        Pager<Filetype> p = new Pager<Filetype>(getFiletypeCount(),num);
	      List<Filetype> result = db.executeQueryForList(sql, new FiletypeRowMapper(), projectid,p.getStartIndex(),p.getPageSize());
 	        p.setResult(result);
	        return p;
	}
	
	
	public int getFiletypeCount() {
		String sql = "select count(*) from t_filetype";
		return db.executeQueryForCount(sql);
	}


	
}
