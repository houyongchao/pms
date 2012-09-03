package Entity;

import java.util.List;

public class Pager<T> {

	private int totalCount;
	private int pageSize = 3;
	private int nowPageNum;
	private List<T> result;
	
	public Pager(int nowPageNum,int totalCount){
		setTotalCount(totalCount);
		setNowPageNum(nowPageNum);
		
	}
	
	public int getStartIndex() {
		int startIndex = (getNowPageNum() - 1)*getPageSize();
		return startIndex;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getNowPageNum() {
		return nowPageNum;
	}
	public void setNowPageNum(int nowPageNum) {
		if(nowPageNum < 1){
			this.nowPageNum = 1;
		} else if(nowPageNum > getTotalpages()){
			this.nowPageNum = getTotalpages();
		} else{
			this.nowPageNum = nowPageNum;
		}
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public int getTotalpages() {
		int result = getTotalCount()/getPageSize();
		if(getTotalCount() % getPageSize() != 0){
			result += 1;
		}
		return result;
	}
	
}
