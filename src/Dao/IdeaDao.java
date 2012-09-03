package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entity.Idea;
import Entity.User;
import Util.DBhelp;
import Util.RowMapper;

public class IdeaDao {
	private DBhelp<Idea> db = new DBhelp<Idea>();
	private DBhelp<User> userdb = new DBhelp<User>();

	public List<User> findByprojectid(String projectid){
		String sql = "select id,password,pic,username from t_user where id in(select userid from t_idea where projectid = ?)";
		return userdb.executeQueryForList(sql, new UserDao().new UserRowMapper(), projectid);
	}
	public List<Idea> findByProjectId(String projectid){
		String sql ="select id,neiRong,createtime,projectid,title,userid from t_idea where projectid = ?";
		return db.executeQueryForList(sql,  new IdeaRowMapper(), projectid);
	}
	public void saveIdea(Idea idea){
		String sql = "insert into t_idea(id,neiRong,createtime,title,projectid,userid)values(?,?,?,?,?,?)";
		db.executeSQL(sql, idea.getId(),idea.getNeiRong(),idea.getCreatetime(),idea.getTitle(),idea.getProjectid(),idea.getUserid());
	}
	public void saveEdeaIdea(String title,String neiRong,String ideaid){
		String sql = "update t_idea set title = ?,neiRong = ? where id = ?";
		db.executeSQL(sql, title,neiRong,ideaid);
	}
	public Idea findByIdeaId(String ideaid){
		String sql = "select id,createtime,neiRong,projectid,title,userid from t_idea where id = ?";
		return db.executeQueryForObject(sql, new IdeaRowMapper(), ideaid);
	}
	public void deleteIdea(String ideaid){
		String sql = "delete from t_idea where id = ?";
		db.executeSQL(sql, ideaid);
	}
	
	private class IdeaRowMapper implements RowMapper<Idea>{

		public Idea mapperRow(ResultSet rs) throws SQLException {
			Idea idea = new Idea();
			idea.setCreatetime(rs.getString("createtime"));
			idea.setId(rs.getString("id"));
			idea.setNeiRong(rs.getString("neiRong"));
			idea.setProjectid(rs.getString("projectid"));
			idea.setTitle(rs.getString("title"));
			idea.setUserid(rs.getString("userid"));
			return idea;
		}
		
		
		
	}
	
}
