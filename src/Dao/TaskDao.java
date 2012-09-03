package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entity.Pager;
import Entity.Task;
import Entity.User;
import Util.DBhelp;
import Util.RowMapper;

public class TaskDao {

	private	DBhelp<Task> db = new DBhelp<Task>();
	private DBhelp<User> userdb = new DBhelp<User>();
	public List<Task> findByGoalId(String goalId) {
		String sql = "SELECT id,renwuName,startTime,endTime,renwuMiaoShu,zhuangTai,renwuJiBie,fuzeren,dangqianjingdu,goalid,userid FROM t_task WHERE goalid = ?";
		
		return db.executeQueryForList(sql, new TaskRowMapper(), goalId);
	}
	
	public Pager<Task> findByGoalId(String goalid,int nowPageNum){
		Pager<Task> pager = new Pager<Task>(nowPageNum,projectCount());
		String sql = "SELECT id,renwuName,startTime,endTime,renwuMiaoShu,zhuangTai,renwuJiBie,fuzeren,dangqianjingdu,goalid,userid FROM t_task WHERE goalid = ? order by renwuName desc limit ?,?";
		List<Task> result =  db.executeQueryForList(sql, new TaskRowMapper(), goalid,pager.getStartIndex(),pager.getPageSize());
		pager.setResult(result);
		return pager;
	}
	
	private int projectCount(){
		String sql="select count(*) from t_task";
		return db.executeQueryForCount(sql);
	}
	
	public void updateJinDu(float jindu,String taskid){
		String sql = "update t_task set dangqianjingdu = ? where id = ?";
		db.executeSQL(sql, jindu,taskid);
	}
	public List<Task> findByUserid(String userid){
		String sql = "select * from t_task where userid = ?";
		return db.executeQueryForList(sql, new TaskRowMapper(), userid);
	}
	public List<User> findBygoalid(String goalid){
		String sql = "select * from t_user where id in(select userid from t_task where goalid = ?) ";
		return userdb.executeQueryForList(sql, new UserDao().new UserRowMapper(), goalid);
	}
	
	private class TaskRowMapper implements RowMapper<Task> {

		public Task mapperRow(ResultSet rs) throws SQLException {
			
			Task task = new Task();
			
			 task.setId(rs.getString("id"));
			 task.setRenwuName(rs.getString("renwuName"));
			 task.setStartTime(rs.getString("startTime"));
			 task.setEndTime(rs.getString("endTime"));
			 task.setRenwuMiaoShu(rs.getString("renwuMiaoShu"));
			 task.setZhuangTai(rs.getString("zhuangTai"));
			 task.setRenwuJiBie(rs.getString("renwuJiBie"));
			 task.setFuzeren(rs.getString("fuzeren"));
			 task.setDangqianjingdu(rs.getString("dangqianjingdu"));
			 task.setGoalid(rs.getString("goalid"));
			 task.setUserid(rs.getString("userid"));
			return task;
		}
		
		
	}
	
	//还没写完，先放着;这个太多了吧
	public void save(Task task){
		String sql = "insert into t_task(id,renwuName,startTime,endTime,renwuMiaoShu,zhuangTai,renwuJiBie,fuzeren,dangqianjingdu,goalid,userid) values(?,?,?,?,?,?,?,?,?,?,?)";

		db.executeSQL(sql, task.getId(),task.getRenwuName(),task.getStartTime(),task.getEndTime(),task.getRenwuMiaoShu(),task.getZhuangTai(),task.getRenwuJiBie(),task.getFuzeren(),task.getDangqianjingdu(),task.getGoalid(),task.getUserid());


	}

	public Task findById(String id) {
		String sql = "select id,renwuName,startTime,endTime,renwuMiaoShu,zhuangTai,renwuJiBie,fuzeren,dangqianjingdu,goalid,userid  from t_task where id = ?";
		return db.executeQueryForObject(sql, new TaskRowMapper(), id);
		
	}

	public void update(Task task) {
		String sql = "update t_task set renwuName =? ,renwuMiaoShu = ? where id = ?";
		db.executeSQL(sql, task.getRenwuName(),task.getRenwuMiaoShu(),task.getId());
	}

	public List<Task> findAlltask() {
		String sql = "select * from t_task";
		return db.executeQueryForList(sql, new TaskRowMapper());
	}
	

	
	


}
