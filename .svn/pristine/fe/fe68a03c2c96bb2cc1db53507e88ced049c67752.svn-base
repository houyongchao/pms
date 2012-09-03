package Service;


import java.util.List;

import Util.PKUtil;
import Dao.TaskDao;
import Entity.Pager;
import Entity.Task;

public class TaskService {

	TaskDao dao = new TaskDao();
	
	public void toXiugai(String id,String name,String miaoshu,String goalid ){
		Task task = new Task();
		task.setId(id);
		task.setRenwuMiaoShu(miaoshu);
		task.setRenwuName(name);
		
		dao.update(task);
	}
	public Task toEdit(String id){
		return dao.findById(id);
	}
	public void tosave(String name,String renwuMiaoShu,String zhuangTai,String fuzeren,String renwuJiBie,String starttime,String endtime,String dangqianjingdu,String userid,String goalid ){
	      Task task = new Task();
	         task.setId(PKUtil.getPk());
			 task.setRenwuName(name);
			 task.setStartTime(starttime);
			 task.setEndTime(endtime);
			 task.setGoalid(goalid);
			 task.setRenwuMiaoShu(renwuMiaoShu);
			 task.setZhuangTai(zhuangTai);
			 task.setRenwuJiBie(renwuJiBie);
			 task.setUserid(userid);
			 task.setFuzeren(fuzeren);
			 task.setDangqianjingdu(dangqianjingdu);
			 task.setDangqianjingdu("0");
			 
	         TaskDao dao = new TaskDao();
	          dao.save(task);
	}
	
	public Pager<Task> tolist(String goalid,int num){
		return dao.findByGoalId(goalid, num);
	}
	public List<Task> findAlltask() {
		List<Task> taskList = dao.findAlltask();
		return taskList;
	}
	
	
}
