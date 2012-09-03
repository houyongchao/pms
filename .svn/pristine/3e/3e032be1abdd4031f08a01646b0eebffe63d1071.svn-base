package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Entity.Pager;
import Entity.Project;
import Util.DBhelp;
import Util.RowMapper;

public class ProjectDao {

	
	private DBhelp<Project> db = new DBhelp<Project>();
	
	public void save(String projectNum,String projectName,String projectDsc,String createTime, String fuZeRen,String projectMember){
		String sql = "insert into t_project(id,projectName,xiangMuMiaoShu,createTime,fuZeRen,projectMember)values(?,?,?,?,?,?)";
		db.executeSQL(sql, projectNum,projectName,projectDsc,createTime,fuZeRen,projectMember);
	}
	
	
	public Pager<Project> findAllProject(String userid,int nowPageNum){
		Pager<Project> pager = new Pager<Project>(nowPageNum,projectCount());
		String sql = "SELECT id,projectName,xiangMuMiaoShu,createTime,fuZeRen,projectMember FROM t_project WHERE id IN(SELECT projectid FROM t_project_has_t_user WHERE userid = ?) order by createTime desc limit ?,?";
		List<Project> result =  db.executeQueryForList(sql, new ProjectRowMapper(), userid,pager.getStartIndex(),pager.getPageSize());
		pager.setResult(result);
		return pager;
	}
	
	private int projectCount(){
		String sql="select count(*) from t_project";
		return db.executeQueryForCount(sql);
	}
	
	private class ProjectRowMapper implements RowMapper<Project> {
		
		public Project mapperRow(ResultSet rs) throws SQLException {
			Project pro= new Project();
			pro.setId(rs.getString("id"));
			pro.setCreateTime(rs.getString("createTime"));
			pro.setFuZeRen(rs.getString("fuZeRen"));
			pro.setProjectMember(rs.getString("projectMember"));
			pro.setProjectName(rs.getString("projectName"));
			pro.setXiangMuMiaoShu(rs.getString("xiangMuMiaoShu"));
			
			pro.setProjectName(rs.getString("projectName"));
			pro.setCreateTime(rs.getString("createTime"));
			pro.setXiangMuMiaoShu(rs.getString("xiangMuMiaoShu"));
			return pro;
		}
		
	}
	public Project findByProjectId(String projectid) {

		String sql = "select id,projectName,xiangMuMiaoShu,createTime,fuZeRen,projectMember from t_project where id = ?";
		  return db.executeQueryForObject(sql, new ProjectRowMapper(), projectid);
	}
	
	
}
