package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entity.Document;
import Entity.Pager;
import Entity.User;
import Util.DBhelp;
import Util.RowMapper;

public class DocumentDao {

	private DBhelp<Document> db = new DBhelp<Document>();
	private DBhelp<User> userdb = new DBhelp<User>();
	
	public List<Document> findAllDocument(String projectid){
		String sql = "select neiRong,createtime,userid,title from t_document where projectid = ?";
		return db.executeQueryForList(sql, new DocumentRowMapper(), projectid);
	}
	
	public Pager<Document> findByProjectid(String projectid,int nowPageNum){
		Pager<Document> pager = new Pager<Document>(nowPageNum,documentCount());
		String sql = "select id,neiRong,createtime,projectid,title,userid from t_document where projectid = ? order by createtime desc limit ?,?";
		List<Document> result =  db.executeQueryForList(sql, new DocumentRowMapper(), projectid,pager.getStartIndex(),pager.getPageSize());
		pager.setResult(result);
		return pager;
	}
	
	private int documentCount(){
		String sql="select count(*) from t_document";
		return db.executeQueryForCount(sql);
	}
	
	public void saveDocument(Document doc){
		String sql = "insert into t_document(id,neiRong,title,createtime,userid,projectid)values(?,?,?,?,?,?)";
		db.executeSQL(sql, doc.getId(),doc.getNeiRong(),doc.getTitle(),doc.getCreatetime(),doc.getUserid(),doc.getProjectid());
	}
	/*public List<Document> findByProjectid(String projectid){
		String sql ="select id,neiRong,createtime,projectid,title,userid from t_document where projectid = ?";
		return db.executeQueryForList(sql, new DocumentRowMapper(), projectid);
	}*/
	public List<User> findByDocumentid(String projectid){
		String sql = "select id, username,password,pic from t_user where id in(select userid from t_document where projectid = ?)";
		return userdb.executeQueryForList(sql,  new UserDao().new UserRowMapper(), projectid);
	}
	public Document findByDocumentId(String documentid){
		String sql = "select id,neiRong,projectid,title,userid,createtime from t_document where id = ? ";
		return db.executeQueryForObject(sql, new DocumentRowMapper(), documentid);
	}
	
	private class DocumentRowMapper implements RowMapper<Document>{

		public Document mapperRow(ResultSet rs) throws SQLException {
			Document doc = new Document();
			
			doc.setId(rs.getString("id"));
			doc.setCreatetime(rs.getString("createtime"));
			doc.setNeiRong(rs.getString("neiRong"));
			doc.setTitle(rs.getString("title"));
			doc.setUserid(rs.getString("userid"));
			
			doc.setProjectid(rs.getString("projectid"));
			
			return doc;
		}
		
		
		
	}
	
	
}
