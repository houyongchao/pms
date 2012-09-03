package Util;

import java.util.List;

public class Pager<T> {

	private int totalCount;
	private int pageSize = 5;
	private int nowPageNum;
	private List<T> result;
	
	
	public Pager(int nowPageNum,int totalCount) {
		setTotalCount(totalCount);
		setNowPageNum(nowPageNum);
	}
	
	

	public int getTotalCount() {
		return totalCount;
	}
	private void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * 根据总条数和每页显示的记录数计算总页数
	 * @return
	 */
	public int getTotalPages() {
		int result = getTotalCount() / getPageSize();
		if(getTotalCount() % getPageSize() != 0) {
			result += 1;
		}
		return result;
	}
	
	/**
	 * 获取当前页起始行数
	 * @return
	 */
	public int getStartIndex() {
		int startIndex = (getNowPageNum() - 1) * getPageSize();
		return startIndex;
	}

	
	public int getNowPageNum() {
		return nowPageNum;
	}
	private void setNowPageNum(int nowPageNum) {
		if(nowPageNum < 1) {
			nowPageNum = 1;
		} else if(nowPageNum > getTotalPages()) {
			nowPageNum = getTotalPages();
		}
		this.nowPageNum = nowPageNum;
	}
	
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
}
