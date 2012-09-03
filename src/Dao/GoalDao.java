package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entity.Goal;
import Entity.Pager;
import Util.DBhelp;
import Util.RowMapper;

public class GoalDao {

	private DBhelp<Goal> db = new DBhelp<Goal>();

	
	public Pager<Goal> findAllProjectid(String projectid,int nowPageNum){
		Pager<Goal> pager = new Pager<Goal>(nowPageNum,projectCount());
		String sql = "select id,name,miaoshu,createtime,userid,rate,projectid from t_goal where projectid = ? order by createtime desc limit ?,?";
		List<Goal> result =  db.executeQueryForList(sql, new GoalRowMapper(), projectid,pager.getStartIndex(),pager.getPageSize());
		pager.setResult(result);
		return pager;
	}
	
	private int projectCount(){
		String sql="select count(*) from t_goal";
		return db.executeQueryForCount(sql);
	}
	public void updateGoal(float goaljindu,String goalid){
		String sql = "update t_goal set rate = ? where id = ?";
		db.executeSQL(sql, goaljindu,goalid);
	}
	
	
	public void save(Goal goal){
		String sql = "insert into t_goal(id,rate,name,miaoshu,createtime,userid,projectid) values(?,?,?,?,?,?,?)";
		db.executeSQL(sql, goal.getId(),goal.getRate(),goal.getName(),goal.getMiaoshu(),goal.getCreateTime(),goal.getUserid(),goal.getProjectid());
	}
	
	public class GoalRowMapper implements RowMapper<Goal> {

		public Goal mapperRow(ResultSet rs) throws SQLException {
			Goal goal = new Goal();
			goal.setId(rs.getString("id"));
			goal.setName(rs.getString("name"));
			goal.setMiaoshu(rs.getString("miaoshu"));
			goal.setProjectid(rs.getString("projectid"));
			goal.setUserid(rs.getString("userid"));
			goal.setCreateTime(rs.getString("createtime"));
			goal.setRate((rs.getFloat("rate")));
			return goal;
		}

	}

	public void update(Goal goal) {
		String sql = "update t_goal set name = ?,miaoshu = ? where id = ?";
		db.executeSQL(sql, goal.getName(),goal.getMiaoshu(),goal.getId());
	}


	public Goal findById(String goalId) {
		String sql = "select id,name,miaoshu,createtime,userid,rate,projectid from t_goal where id = ?";
		return db.executeQueryForObject(sql, new GoalRowMapper(),goalId);
		
	}

	

}
