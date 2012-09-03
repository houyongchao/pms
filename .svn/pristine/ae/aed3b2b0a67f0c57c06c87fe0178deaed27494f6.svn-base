package Dao;

import Entity.Project_has_user;
import Util.DBhelp;

public class Project_has_userDao {

	private DBhelp<Project_has_user> db = new DBhelp<Project_has_user>();
	
	public void save(String userid,String projectNum,String role){
		
		String sql = "insert into t_project_has_t_user(userid,projectid,role ) values(?,?,?)";
		db.executeSQL(sql, userid,projectNum,role);
	}
}
