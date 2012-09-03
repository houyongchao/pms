package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import Entity.User;
import Util.DBhelp;
import Util.RowMapper;

public class UserDao {

	private DBhelp<User> db = new DBhelp<User>();
	
	public User findByName(String name){
		String sql = "select * from t_user where username = ?";
		return (User)db.executeQueryForObject(sql,new UserRowMapper(),name);
	}
	public void saveUser(User user){
		String sql = "insert into t_user(id,username,password,pic)values(?,?,?,?)";
		db.executeSQL(sql, user.getId(),user.getUsername(),user.getPassword(),user.getPic());
	}
	public void updateUser(String newpassword,String userid){
		String sql = "update t_user set password = ? where id = ?";
		db.executeSQL(sql, newpassword,userid);
	}
	public User findById(String userid){
		String sql = "select * from t_user where id = ?";
		return db.executeQueryForObject(sql, new UserRowMapper(), userid);
	}
	public class UserRowMapper implements RowMapper<User> {
		
		public User mapperRow(ResultSet rs) throws SQLException {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setPic(rs.getString("pic"));
			user.setUsername(rs.getString("username"));
			return user;
		}
		
	}
	public List<User> findAlluser() {
		String sql = "select * from t_user";
		return db.executeQueryForList(sql, new UserRowMapper());
	}

	
	
}
