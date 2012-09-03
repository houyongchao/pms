package Service;
import Util.DateUtil;
import Util.PKUtil;

import Dao.GoalDao;
import Entity.Goal;
import Entity.Pager;

public class GoalService {

	private GoalDao  goalDao = new GoalDao();
	public Pager<Goal> mubiao(String projectid,int num){
		return goalDao.findAllProjectid(projectid, num);
	}
	
	public void  baocun(String projectid,String userid,String name,String miaoshu){
		
		 Goal goal = new Goal();
	        goal.setCreateTime(DateUtil.getTime());
	        goal.setId(PKUtil.getPk());
	        goal.setProjectid(projectid);
	        goal.setName(name);
	        goal.setMiaoshu(miaoshu);
	        goal.setUserid(userid);
	        goal.setRate(0);
	        GoalDao goalDao = new GoalDao();
	        goalDao.save(goal);
	}
	public Goal  toedit(String id){
		return  goalDao.findById(id);
		
	}
	
	public void toxiugai(String id,String name,String miaoshu){
		Goal goal = new Goal();
		
		goal.setId(id);
		goal.setName(name);
		goal.setMiaoshu(miaoshu);
		
		goalDao.update(goal);
		
	}
	
}
