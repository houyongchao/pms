package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entity.Message;
import Entity.Pager;
import Entity.User;
import Util.DBhelp;
import Util.RowMapper;

public class MessageDao {
	
	DBhelp<Message> db = new DBhelp<Message>();
	DBhelp<User> userdb = new DBhelp<User>();
	public void saveFenXiang(String id,String createTime,String neiRong,String userid,String projectid){
		String sql = "insert into t_message(id,ceratetime,neiRong,userid,projectid)values(?,?,?,?,?)";
		db.executeSQL(sql, id,createTime,neiRong,userid,projectid);
	}
	
	public Pager<Message> findAllProjectid(String projectid,int nowPageNum){
		Pager<Message> pager = new Pager<Message>(nowPageNum,projectCount());
		String sql = "select id,ceratetime,neiRong,projectid,userid from t_message where projectid = ? order by ceratetime desc limit ?,?";
		List<Message> result =  db.executeQueryForList(sql, new MessageRowMapper(), projectid,pager.getStartIndex(),pager.getPageSize());
		pager.setResult(result);
		return pager;
	}
	
	public int projectCount(){
		String sql="select count(*) from t_message";
		return db.executeQueryForCount(sql);
	}
	
	public List<User> findUserByProjectid(String projectid){
		String sql = "select id,password,pic,username from t_user where id in(select userid from t_message where projectid = ?)";
		return userdb.executeQueryForList(sql, new UserDao().new UserRowMapper(), projectid);
	}
	
	private class MessageRowMapper implements RowMapper<Message>{

		public Message mapperRow(ResultSet rs) throws SQLException {
			Message message = new Message();
			message.setCreatetime(rs.getString("ceratetime"));
			message.setId(rs.getString("id"));
			message.setNeiRong(rs.getString("neiRong"));
			message.setProjectid(rs.getString("projectid"));
			message.setUserid(rs.getString("userid"));
			return message;
		}
		
		
		
	}
	
	
}
